package org.verapdf.gf.model.impl.pd.images;

import org.verapdf.cos.COSName;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.impl.cos.GFCosIIFilter;
import org.verapdf.gf.model.impl.cos.GFCosRenderingIntent;
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

	public GFPDInlineImage(org.verapdf.pd.images.PDInlineImage simplePDObject) {
		super(simplePDObject, INLINE_IMAGE_TYPE);
	}

	@Override
	public Boolean getInterpolate() {
		return Boolean.valueOf(((org.verapdf.pd.images.PDInlineImage) this.simplePDObject)
				.isInterpolate());
	}

	@Override
	public String getSubtype() {
		return null;
	}

	@Override
	public Boolean getisInherited() {
		return Boolean.valueOf(((org.verapdf.pd.images.PDInlineImage) this.simplePDObject)
				.isInherited());
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case GFPDXImage.INTENT:
				return this.getIntent();
			case GFPDXImage.IMAGE_CS:
				return this.getImageCS();
			case GFPDXObject.S_MASK:
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
		PDColorSpace buffer = ColorSpaceFactory
				.getColorSpace(((org.verapdf.pd.images.PDInlineImage) this.simplePDObject)
						.getImageCS());
		if (buffer != null) {
			List<PDColorSpace> colorSpaces =
					new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			colorSpaces.add(buffer);
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
