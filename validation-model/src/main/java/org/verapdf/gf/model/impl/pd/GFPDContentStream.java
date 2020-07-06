/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd;


import org.verapdf.as.ASAtom;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.factory.operators.OperatorFactory;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BDC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BMC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_EMC;
import org.verapdf.gf.model.impl.operator.textshow.GFOpTextShow;
import org.verapdf.gf.model.impl.operator.textshow.GFOp_TJ_Big;
import org.verapdf.gf.model.impl.operator.textshow.GFOp_Tj;
import org.verapdf.gf.model.impl.pd.gfse.GFSEMarkedContent;
import org.verapdf.gf.model.impl.pd.gfse.GFSEUnmarkedContent;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.selayer.SEContentItem;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFPDContentStream extends GFPDObject implements PDContentStream {

	private static final Logger LOGGER = Logger.getLogger(GFPDContentStream.class.getCanonicalName());

	public static final String CONTENT_STREAM_TYPE = "PDContentStream";

	public static final String OPERATORS = "operators";

	public static final String CONTENT = "content";

	private PDResourcesHandler resourcesHandler;

	private List<Operator> operators = null;
	private boolean containsTransparency = false;
	private final GraphicState inheritedGraphicState;
	private final StructureElementAccessObject structureElementAccessObject;
	private String parentStructureTag;

	public GFPDContentStream(org.verapdf.pd.PDContentStream contentStream,
							 PDResourcesHandler resourcesHandler,
							 GraphicState inheritedGraphicState,
							 StructureElementAccessObject structureElementAccessObject) {
		super(contentStream, CONTENT_STREAM_TYPE);
		this.resourcesHandler = resourcesHandler;
		this.inheritedGraphicState = inheritedGraphicState;
		this.structureElementAccessObject = structureElementAccessObject;
		this.parentStructureTag = getParentStructureTag(structureElementAccessObject);
	}

	public GFPDContentStream(org.verapdf.pd.PDContentStream contentStream,
							 PDResourcesHandler resourcesHandler,
							 GraphicState inheritedGraphicState,
							 StructureElementAccessObject structureElementAccessObject,
							 StructureElementAccessObject parentStructureElementAccessObject, String parentStructureTag) {
		this(contentStream, resourcesHandler, inheritedGraphicState, structureElementAccessObject);
		if (this.parentStructureTag == null) {
			this.parentStructureTag = getParentStructureTag(parentStructureElementAccessObject);
		}
		if (this.parentStructureTag == null) {
			this.parentStructureTag = parentStructureTag;
		}
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case OPERATORS:
				return this.getOperators();
			case CONTENT:
				return this.getContentItem();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<SEContentItem> getContentItem() {
		if (this.operators == null) {
			parseOperators();
		}
		getNextScaleFactors();
		int unmarkedContentIndex = 0;
		int markedContentIndex = -1;
		Stack<Integer> markedContentStack = new Stack<>();
		List<SEContentItem> list = new ArrayList<>();
		for (int i = 0; i < operators.size(); i++) {
			String type = operators.get(i).getObjectType();
			if (type.equals(GFOp_BDC.OP_BDC_TYPE) || type.equals(GFOp_BMC.OP_BMC_TYPE)) {
				if (markedContentStack.empty() && i != markedContentIndex + 1) {
					list.add(new GFSEUnmarkedContent(operators.subList(unmarkedContentIndex, i), parentStructureTag));
				}
				markedContentStack.push(i);
			} else if (type.equals(GFOp_EMC.OP_EMC_TYPE)) {
				if (!markedContentStack.empty()) {
					markedContentIndex = markedContentStack.pop();
					if (markedContentStack.empty()) {
						list.add(new GFSEMarkedContent(operators.subList(markedContentIndex, i + 1), parentStructureTag));
						markedContentIndex = i;
						unmarkedContentIndex = i + 1;
					}
				}
			}
		}
		if (unmarkedContentIndex != operators.size()) {
			list.add(new GFSEUnmarkedContent(operators.subList(unmarkedContentIndex, operators.size()), parentStructureTag));
		}
		return Collections.unmodifiableList(list);
	}

	private List<Operator> getOperators() {
		if (this.operators == null) {
			parseOperators();
		}
		return this.operators;
	}

	private void parseOperators() {
		if (this.contentStream == null) {
			this.operators = Collections.emptyList();
		} else {
			try {
				COSObject contentStream = this.contentStream.getContents();
				if (contentStream.getType() == COSObjType.COS_STREAM || contentStream.getType() == COSObjType.COS_ARRAY) {
					COSKey key = contentStream.getObjectKey();
					if (key != null) {
						if (StaticContainers.getTransparencyVisitedContentStreams().contains(key)) {
							LOGGER.log(Level.FINE, "Parsing content stream loop");
							StaticContainers.setValidPDF(false);
							this.containsTransparency = false;
							this.operators = Collections.emptyList();
							return;
						} else {
							StaticContainers.getTransparencyVisitedContentStreams().push(key);
						}
					}
					try (ASInputStream opStream = contentStream.getDirectBase().getData(COSStream.FilterFlags.DECODE)) {
						PDFStreamParser streamParser = new PDFStreamParser(opStream);
						try {
							streamParser.parseTokens();
							OperatorFactory operatorFactory = new OperatorFactory();
							List<Operator> result = operatorFactory.operatorsFromTokens(streamParser.getTokens(),
									resourcesHandler, inheritedGraphicState, structureElementAccessObject, parentStructureTag);
							this.containsTransparency = operatorFactory.isLastParsedContainsTransparency();
							this.operators = Collections.unmodifiableList(result);
						} finally {
							streamParser.close();
							if (StaticContainers.getDocument() != null &&
									StaticContainers.getDocument().getDocument() != null) {
								StaticContainers.getDocument().getDocument().getResourceHandler().addAll(
										streamParser.getImageDataStreams());
							}
						}
					}
					if (key != null && StaticContainers.getTransparencyVisitedContentStreams().peek().equals(key)) {
						StaticContainers.getTransparencyVisitedContentStreams().pop();
					}
				} else {
					this.operators = Collections.emptyList();
				}
			} catch (IOException e) {
				LOGGER.log(Level.FINE, "Error while parsing content stream. " + e.getMessage(), e);
				StaticContainers.setValidPDF(false);
				this.operators = Collections.emptyList();
			}
		}
	}

	public boolean isContainsTransparency() {
		if (this.operators == null) {
			parseOperators();
		}
		return containsTransparency;
	}

	private void getNextScaleFactors() {
		Double scaleFactor = null;
		for(int i = operators.size() - 1; i >= 0; i--) {
			Operator operator = operators.get(i);
			if(operator.getObjectType().equals(GFOp_Tj.OP_TJ_TYPE) || operator.getObjectType().equals(GFOp_TJ_Big.OP_TJ_BIG_TYPE)) {
				((GFOpTextShow)operator).setNextScaleFactor(scaleFactor);
				scaleFactor = ((GFOpTextShow)operator).getScaleFactor();
			}
		}
	}

	private String getParentStructureTag(StructureElementAccessObject structureElementAccessObject) {
		PDStructTreeRoot structTreeRoot = StaticContainers.getDocument().getStructTreeRoot();
		if (structTreeRoot != null) {
			PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
			COSObject structureElement = parentTreeRoot == null ? null : structureElementAccessObject.getStructureElement(parentTreeRoot, null);
			if (structureElement != null && !structureElement.empty()) {
				return structureElement.getStringKey(ASAtom.S);
			}
		}
		return null;
	}

}
