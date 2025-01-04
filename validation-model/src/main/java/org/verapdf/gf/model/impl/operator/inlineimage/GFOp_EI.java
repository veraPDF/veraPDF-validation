/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.operator.inlineimage;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.images.GFPDInlineImage;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_EI;
import org.verapdf.model.pdlayer.PDInlineImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_EI extends GFOpInlineImage implements Op_EI {

	public static final String OP_EI_TYPE = "Op_EI";

	public static final String INLINE_IMAGE = "inlineImage";

	private final PDResourcesHandler resourcesHandler;
	private final org.verapdf.pd.colors.PDColorSpace inheritedFillCS;

	public GFOp_EI(List<COSBase> arguments, PDResourcesHandler resourcesHandler,
				   org.verapdf.pd.colors.PDColorSpace inheritedFillCS) {
		super(arguments, OP_EI_TYPE);
		this.resourcesHandler = resourcesHandler;
		this.inheritedFillCS = inheritedFillCS;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (INLINE_IMAGE.equals(link)) {
			return this.getInlineImage();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDInlineImage> getInlineImage() {
		COSBase parameters = this.arguments.get(0);
		org.verapdf.pd.images.PDInlineImage inlineImage =
				new org.verapdf.pd.images.PDInlineImage(new COSObject(parameters),
						resourcesHandler.getObjectResources(), resourcesHandler.getPageResources());
		List<PDInlineImage> inlineImages = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		inlineImages.add(new GFPDInlineImage(inlineImage, this.inheritedFillCS));
		return Collections.unmodifiableList(inlineImages);
	}

}
