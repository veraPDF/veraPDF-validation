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
package org.verapdf.gf.model.impl.sa;

import org.verapdf.as.ASAtom;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.salayer.SAAnnotation;
import org.verapdf.pd.*;

/**
 * @author Maxim Plushchov
 */
public class GFSAAnnotation extends GenericModelObject implements SAAnnotation {
	public static final String ANNOTATION_TYPE = "SAAnnotation";

	public static final String LINK = "Link";

	private final PDAnnotation annot;
	private final PDPage page;

	public GFSAAnnotation(PDAnnotation annot, PDPage page) {
		this(annot, page, ANNOTATION_TYPE);
	}

	public GFSAAnnotation(PDAnnotation annot, PDPage page, String type) {
		super(type);
		this.page = page;
		this.annot = annot;
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
	public Long getF() {
		return annot.getF();
	}
}
