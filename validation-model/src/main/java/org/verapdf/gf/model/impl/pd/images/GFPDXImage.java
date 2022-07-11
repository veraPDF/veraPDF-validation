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
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.impl.cos.GFCosRenderingIntent;
import org.verapdf.gf.model.impl.external.GFJPEG2000;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosRenderingIntent;
import org.verapdf.model.external.JPEG2000;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDSMaskImage;
import org.verapdf.model.pdlayer.PDXImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDXImage extends GFPDXObject implements PDXImage {
	public static final String X_IMAGE_TYPE = "PDXImage";

	public static final String IMAGE_CS = "imageCS";
	public static final String ALTERNATES = "Alternates";
	public static final String INTENT = "Intent";
	public static final String JPX_STREAM = "jpxStream";
	public static final String S_MASK = "SMask";

	private List<JPEG2000> jpeg2000List = null;
	private org.verapdf.pd.colors.PDColorSpace inheritedFillCS;

	protected GFPDXImage(org.verapdf.pd.images.PDXImage simplePDObject, PDResourcesHandler resourcesHandler,
						 org.verapdf.pd.colors.PDColorSpace inheritedFillCS) {
		this(simplePDObject, resourcesHandler, inheritedFillCS, X_IMAGE_TYPE);
	}

	protected GFPDXImage(org.verapdf.pd.images.PDXImage simplePDObject, PDResourcesHandler resourcesHandler,
						 org.verapdf.pd.colors.PDColorSpace inheritedFillCS, String type) {
		super(simplePDObject, resourcesHandler, type);
		this.inheritedFillCS = inheritedFillCS;
	}

	@Override
	public Boolean getInterpolate() {
		return ((org.verapdf.pd.images.PDXImage) simplePDObject).isInterpolate();
	}

	@Override
	public Boolean getcontainsAlternates() {
		return simplePDObject.knownKey(ASAtom.ALTERNATES);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case INTENT:
				return this.getIntent();
			case IMAGE_CS:
				return this.getImageCS();
			case ALTERNATES:
				return this.getAlternates();
			case JPX_STREAM:
				return this.getJPXStream();
			case S_MASK:
				return this.getSMask();
			default:
				return super.getLinkedObjects(link);
		}
	}

	protected List<PDSMaskImage> getSMask() {
		org.verapdf.pd.images.PDXImage smask = ((org.verapdf.pd.images.PDXObject) simplePDObject).getSMask();
		if (smask != null) {
			List<PDSMaskImage> mask = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			mask.add(new GFPDSMaskImage(smask, this.resourcesHandler));
			return Collections.unmodifiableList(mask);
		}
		return Collections.emptyList();
	}

	private List<CosRenderingIntent> getIntent() {
		COSName intent = ((org.verapdf.pd.images.PDXImage) simplePDObject).getIntent();
		if (intent != null) {
			List<CosRenderingIntent> intents = new ArrayList<>(
					GFPDObject.MAX_NUMBER_OF_ELEMENTS);
			intents.add(new GFCosRenderingIntent(intent));
			return Collections.unmodifiableList(intents);
		}
		return Collections.emptyList();
	}

	private List<PDColorSpace> getImageCS() {
		if (this.jpeg2000List == null) {
			this.jpeg2000List = parseJPXStream();
		}
		org.verapdf.pd.images.PDXImage image = ((org.verapdf.pd.images.PDXImage) simplePDObject);
		if (!image.getImageMask()) {
			List<PDColorSpace> colorSpaces =
					new ArrayList<>(GFPDObject.MAX_NUMBER_OF_ELEMENTS);
			org.verapdf.pd.colors.PDColorSpace colorSpace;
			ASAtom csName = image.getImageCSName();
			if (csName != null) {
				colorSpace = resourcesHandler.getColorSpace(csName);
				if (colorSpace != null) {
					colorSpaces.add(ColorSpaceFactory.getColorSpace(colorSpace));
					return Collections.unmodifiableList(colorSpaces);
				}
			} else {
				colorSpace = image.getImageCS();
				if (colorSpace != null) {
					colorSpaces.add(ColorSpaceFactory.getColorSpace(colorSpace));
					return Collections.unmodifiableList(colorSpaces);
				}
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

	private List<? extends PDXImage> getAlternates() {
		List<org.verapdf.pd.images.PDXImage> alternates =
				((org.verapdf.pd.images.PDXImage) simplePDObject).getAlternates();
		final List<PDXImage> res = new ArrayList<>(alternates.size());
		for (org.verapdf.pd.images.PDXImage image : alternates) {
			res.add(new GFPDXImage(image, this.resourcesHandler, this.inheritedFillCS));
		}
		return res;
	}

	private List<JPEG2000> getJPXStream() {
		if (jpeg2000List == null) {
			jpeg2000List = parseJPXStream();
		}
		return jpeg2000List;
	}

	private List<JPEG2000> parseJPXStream() {
		org.verapdf.external.JPEG2000 jpeg = ((org.verapdf.pd.images.PDXImage) this.simplePDObject).getJPXStream();
		if (jpeg != null) {
			COSObject colorSpace = simplePDObject.getKey(ASAtom.COLORSPACE);
			List<JPEG2000> list = new ArrayList<>(GFPDObject.MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFJPEG2000(jpeg,
					colorSpace != null && !colorSpace.empty() && colorSpace.getType() != COSObjType.COS_NULL));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	/**
	 * @return true if current image contains SMask value of type stream or SMaskInData value greater then 0
	 */
	public boolean containsTransparency() {
		COSObject smask = this.simplePDObject.getKey(ASAtom.SMASK);
		return (smask != null && smask.getType() == COSObjType.COS_STREAM)
				|| ((org.verapdf.pd.images.PDXImage) this.simplePDObject).getSMaskInData() > 0;
	}
}
