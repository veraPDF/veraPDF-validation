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
package org.verapdf.gf.model.impl.pd.images;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.impl.cos.GFCosIIFilter;
import org.verapdf.gf.model.impl.cos.GFCosRenderingIntent;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.gf.model.impl.pd.GFPDResource;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosIIFilter;
import org.verapdf.model.coslayer.CosRenderingIntent;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDInlineImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDInlineImage extends GFPDResource implements PDInlineImage {

	public static final String F = "F";

	public static final String INLINE_IMAGE_TYPE = "PDInlineImage";

	private final org.verapdf.pd.colors.PDColorSpace inheritedFillCS;

	public GFPDInlineImage(org.verapdf.pd.images.PDInlineImage simplePDObject,
						   org.verapdf.pd.colors.PDColorSpace inheritedFillCS) {
		super(simplePDObject, INLINE_IMAGE_TYPE);
		this.inheritedFillCS = inheritedFillCS;
	}

	@Override
	public Boolean getInterpolate() {
		return ((org.verapdf.pd.images.PDInlineImage) this.simplePDObject)
				.isInterpolate();
	}

	@Override
	public String getSubtype() {
		return null;
	}

	@Override
	public Boolean getisInherited() {
		return ((org.verapdf.pd.images.PDInlineImage) this.simplePDObject)
				.isInherited();
	}

	@Override
	public Boolean getcontainsOPI() {
		return this.simplePDObject.knownKey(ASAtom.OPI);
	}

	@Override
	public Boolean getcontainsSMask() {
		return this.simplePDObject.knownKey(ASAtom.SMASK);
	}

	@Override
	public Boolean getcontainsAlternates() {
		return simplePDObject.knownKey(ASAtom.ALTERNATES);
	}

	@Override
	public Long getBitsPerComponent() {
		return ((org.verapdf.pd.images.PDInlineImage) simplePDObject).getBitsPerComponent();
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case GFPDXImage.INTENT:
				return this.getIntent();
			case GFPDXImage.IMAGE_CS:
				return this.getImageCS();
			case GFPDXImage.S_MASK:
			case GFPDXObject.OPI:
			case GFPDXImage.ALTERNATES:
			case GFPDXImage.JPX_STREAM:
				return Collections.emptyList();
			case F:
				return getFilters();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosIIFilter> getFilters() {
		List<COSName> filters = ((org.verapdf.pd.images.PDInlineImage) this.simplePDObject)
				.getCOSFilters();
		if (!filters.isEmpty()) {
			List<CosIIFilter> result = new ArrayList<>(filters.size());
			for (COSName filter : filters) {
				result.add(new GFCosIIFilter(filter));
			}
			return Collections.unmodifiableList(result);
		}
		return Collections.emptyList();
	}

	private List<PDColorSpace> getImageCS() {
		if (!((org.verapdf.pd.images.PDInlineImage) this.simplePDObject).getImageMask()) {
			PDColorSpace buffer = ColorSpaceFactory
					.getColorSpace(((org.verapdf.pd.images.PDInlineImage) this.simplePDObject)
							.getImageCS());
			if (buffer != null) {
				List<PDColorSpace> colorSpaces =
						new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				colorSpaces.add(buffer);
				return Collections.unmodifiableList(colorSpaces);
			}
		} else if (this.inheritedFillCS != null) {
			// for image mask we return current fill color space
			List<PDColorSpace> colorSpaces =
					new ArrayList<>(GFPDObject.MAX_NUMBER_OF_ELEMENTS);
			colorSpaces.add(ColorSpaceFactory.getColorSpace(this.inheritedFillCS));
			return Collections.unmodifiableList(colorSpaces);
		}
		return Collections.emptyList();
	}

	private List<CosRenderingIntent> getIntent() {
		COSName intent = ((org.verapdf.pd.images.PDInlineImage) this.simplePDObject).getIntent();
		if (intent != null) {
			List<CosRenderingIntent> intents = new ArrayList<>(
					MAX_NUMBER_OF_ELEMENTS);
			intents.add(new GFCosRenderingIntent(intent));
			return Collections.unmodifiableList(intents);
		}
		return Collections.emptyList();
	}
}
