/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.sa;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.salayer.SAAnnotation;
import org.verapdf.pd.*;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.tools.StaticResources;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;

import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSAAnnotation extends GenericModelObject implements SAAnnotation {
	public static final String ANNOTATION_TYPE = "SAAnnotation";

	public static final String LINK = "Link";

	private final PDAnnotation annot;
	private final PDPage page;
	private String textValue;

	public GFSAAnnotation(PDAnnotation annot, PDPage page) {
		this(annot, page, ANNOTATION_TYPE);
	}

	public GFSAAnnotation(PDAnnotation annot, PDPage page, String type) {
		super(type);
		this.page = page;
		this.annot = annot;
	}

	@Override
	public String gettextValue() {
		if (textValue == null) {
			textValue = findTextValue();
		}
		return textValue;
	}

	private String findTextValue() {
		double[] rect = annot.getRect();
		if (rect != null) {
			List<String> values = StaticStorages.getChunks().getValues(page.getObject().getKey(),
			                                                           new BoundingBox(page.getPageNumber(), rect));
			return values.stream()
			             .reduce("", String::concat)
			             .trim();
		}
		return "";
	}

	public static GFSAAnnotation createAnnot(PDAnnotation annot, PDPage page) {
		ASAtom subtype = annot.getSubtype();
		if (subtype == null) {
			return new GFSAAnnotation(annot, page);
		}
		String subtypeString = subtype.getValue();
		switch (subtypeString) {
			case LINK:
				return new GFSALinkAnnotation(annot, page);
			default:
				return new GFSAAnnotation(annot, page);
		}
	}

	@Override
	public Boolean getisOutsideCropBox() {
		double[] cropBox = page.getCropBox();
		double[] rectangle = annot.getRect();
		if (rectangle != null && rectangle.length >= 4) {
			return cropBox[1] >= rectangle[3] || cropBox[0] >= rectangle[2]
			       || cropBox[3] <= rectangle[1] || cropBox[2] <= rectangle[0];
		}
		return null;
	}

	@Override
	public String getContents() {
		return annot.getContents();
	}

	@Override
	public String getAlt() {
		PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
		Long structParent = this.annot.getStructParent();
		if (structTreeRoot != null && structParent != null) {
			PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
			COSObject structureElement = parentTreeRoot == null ? null : parentTreeRoot.getObject(structParent);
			if (structureElement != null) {
				COSObject baseAlt = structureElement.getKey(ASAtom.ALT);
				if (baseAlt != null && baseAlt.getType() == COSObjType.COS_STRING) {
					return baseAlt.getDirectBase().toString();
				}
			}
		}
		return null;
	}

	@Override
	public Long getF() {
		return annot.getF();
	}
}
