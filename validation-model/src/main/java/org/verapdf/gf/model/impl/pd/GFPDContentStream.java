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
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDResources;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFPDContentStream extends GFPDObject implements PDContentStream {

	private static final Logger LOGGER = Logger.getLogger(GFPDContentStream.class.getCanonicalName());

	public static final String CONTENT_STREAM_TYPE = "PDContentStream";

	public static final String OPERATORS = "operators";

	private static final String RESOURCES = "resources";

	private PDResourcesHandler resourcesHandler;

	protected List<Operator> operators = null;
	private boolean containsTransparency = false;
	private final GraphicState inheritedGraphicState;
	private final StructureElementAccessObject structureElementAccessObject;
	protected String parentStructureTag;
	protected String parentsTags;

	public GFPDContentStream(org.verapdf.pd.PDContentStream contentStream, PDResourcesHandler resourcesHandler,
							 GraphicState inheritedGraphicState,
							 StructureElementAccessObject structureElementAccessObject) {
		this(contentStream, resourcesHandler, inheritedGraphicState, structureElementAccessObject, CONTENT_STREAM_TYPE);
	}

	public GFPDContentStream(org.verapdf.pd.PDContentStream contentStream, PDResourcesHandler resourcesHandler,
							 GraphicState inheritedGraphicState,
							 StructureElementAccessObject structureElementAccessObject,
							 String parentStructureTag, String parentsTags) {
		this(contentStream, resourcesHandler, inheritedGraphicState, structureElementAccessObject,
				parentStructureTag, parentsTags, CONTENT_STREAM_TYPE);
	}

	public GFPDContentStream(org.verapdf.pd.PDContentStream contentStream, PDResourcesHandler resourcesHandler,
							 GraphicState inheritedGraphicState,
							 StructureElementAccessObject structureElementAccessObject, final String type) {
		super(contentStream, type);
		this.resourcesHandler = resourcesHandler;
		this.inheritedGraphicState = inheritedGraphicState;
		this.structureElementAccessObject = structureElementAccessObject;
		parentsTags = "";
	}

	public GFPDContentStream(org.verapdf.pd.PDContentStream contentStream,
							 PDResourcesHandler resourcesHandler,
							 GraphicState inheritedGraphicState,
							 StructureElementAccessObject structureElementAccessObject,
							 String parentStructureTag, String parentsTags, final String type) {
		this(contentStream, resourcesHandler, inheritedGraphicState, structureElementAccessObject, type);
		this.parentStructureTag = getParentStructureTag(structureElementAccessObject);
		if (this.parentStructureTag == null) {
			this.parentStructureTag = parentStructureTag;
		}
		this.parentsTags = parentsTags;
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case OPERATORS:
				return this.getOperators();
			case RESOURCES:
				return this.getResources();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<Operator> getOperators() {
		if (this.operators == null) {
			parseOperators();
		}
		return this.operators;
	}

	protected void parseOperators() {
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
									resourcesHandler, inheritedGraphicState, structureElementAccessObject, parentStructureTag, parentsTags);
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

	@Override
	public Boolean getcontainsUndefinedResource() {
		return resourcesHandler.getContainsUndefinedResource();
	}

	public boolean isContainsTransparency() {
		if (this.operators == null) {
			parseOperators();
		}
		return containsTransparency;
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

	private List<PDResources> getResources() {
		List<PDResources> result = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		org.verapdf.pd.PDResources resources = resourcesHandler.getObjectResources();
		if (resources != null) {
			result.add(new GFPDResources(resources));
		}
		return result;
	}

}
