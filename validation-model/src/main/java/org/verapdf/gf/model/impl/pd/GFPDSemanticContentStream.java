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


import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BDC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BMC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_EMC;
import org.verapdf.gf.model.impl.operator.textshow.GFOpTextShow;
import org.verapdf.gf.model.impl.pd.gfse.GFSEMarkedContent;
import org.verapdf.gf.model.impl.pd.gfse.GFSEUnmarkedContent;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.pdlayer.PDSemanticContentStream;
import org.verapdf.model.selayer.SEContentItem;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Maxim Plushchov
 */
public class GFPDSemanticContentStream extends GFPDContentStream implements PDSemanticContentStream {

	public static final String CONTENT = "content";

	public static final String SEMANTIC_CONTENT_STREAM_TYPE = "PDSemanticContentStream";

	private String defaultLang;

	public GFPDSemanticContentStream(org.verapdf.pd.PDContentStream contentStream,
                                     PDResourcesHandler resourcesHandler,
                                     GraphicState inheritedGraphicState,
                                     StructureElementAccessObject structureElementAccessObject) {
		super(contentStream, resourcesHandler, inheritedGraphicState, structureElementAccessObject, SEMANTIC_CONTENT_STREAM_TYPE);
	}

	public GFPDSemanticContentStream(org.verapdf.pd.PDContentStream contentStream,
                                     PDResourcesHandler resourcesHandler,
                                     GraphicState inheritedGraphicState,
                                     StructureElementAccessObject structureElementAccessObject,
                                     String parentStructureTag, String parentsTags) {
		super(contentStream, resourcesHandler, inheritedGraphicState, structureElementAccessObject, parentStructureTag,
				parentsTags, SEMANTIC_CONTENT_STREAM_TYPE);
	}

	public GFPDSemanticContentStream(org.verapdf.pd.PDContentStream contentStream,
									 PDResourcesHandler resourcesHandler,
									 GraphicState inheritedGraphicState,
									 StructureElementAccessObject structureElementAccessObject,
									 String parentStructureTag, String parentsTags, String defaultLang) {
		this(contentStream, resourcesHandler, inheritedGraphicState, structureElementAccessObject, parentStructureTag,
				parentsTags);
		this.defaultLang = defaultLang;
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
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
		int unmarkedContentIndex = 0;
		int markedContentIndex = -1;
		Stack<Integer> markedContentStack = new Stack<>();
		List<SEContentItem> list = new ArrayList<>();
		for (int i = 0; i < operators.size(); i++) {
			String type = operators.get(i).getObjectType();
			if (GFOp_BDC.OP_BDC_TYPE.equals(type) || GFOp_BMC.OP_BMC_TYPE.equals(type)) {
				if (markedContentStack.empty() && i != markedContentIndex + 1) {
					list.add(new GFSEUnmarkedContent(operators.subList(unmarkedContentIndex, i), parentStructureTag,
							parentsTags, defaultLang));
				}
				markedContentStack.push(i);
			} else if (GFOp_EMC.OP_EMC_TYPE.equals(type)) {
				if (!markedContentStack.empty()) {
					markedContentIndex = markedContentStack.pop();
					if (markedContentStack.empty()) {
						list.add(new GFSEMarkedContent(operators.subList(markedContentIndex, i + 1), parentStructureTag,
								parentsTags, defaultLang));
						markedContentIndex = i;
						unmarkedContentIndex = i + 1;
					}
				}
			}
		}
		if (unmarkedContentIndex != operators.size()) {
			list.add(new GFSEUnmarkedContent(operators.subList(unmarkedContentIndex, operators.size()),
					parentStructureTag, parentsTags, defaultLang));
		}
		return Collections.unmodifiableList(list);
	}

}
