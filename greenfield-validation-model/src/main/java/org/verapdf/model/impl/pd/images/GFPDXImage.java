package org.verapdf.model.impl.pd.images;

import org.verapdf.cos.COSName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosRenderingIntent;
import org.verapdf.model.external.JPEG2000;
import org.verapdf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.impl.cos.GFCosRenderingIntent;
import org.verapdf.model.impl.external.GFJPEG2000;
import org.verapdf.model.pdlayer.PDColorSpace;
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

	private List<JPEG2000> jpeg2000List = null;
	private PDColorSpace colorSpaceFromImage = null;

	public GFPDXImage(org.verapdf.pd.images.PDXImage simplePDObject) {
		this(simplePDObject, X_IMAGE_TYPE);
	}

	protected GFPDXImage(org.verapdf.pd.images.PDXImage simplePDObject, String type) {
		super(simplePDObject, null, type);
	}

	@Override
	public Boolean getInterpolate() {
		return Boolean.valueOf(((org.verapdf.pd.images.PDXImage) simplePDObject).isInterpolate());
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
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosRenderingIntent> getIntent() {
		COSName intent = ((org.verapdf.pd.images.PDXImage) simplePDObject).getIntent();
		if (intent != null) {
			List<CosRenderingIntent> intents = new ArrayList<>(
					MAX_NUMBER_OF_ELEMENTS);
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
			PDColorSpace buffer = ColorSpaceFactory.getColorSpace(image.getImageCS());
			if (buffer != null) {
				List<PDColorSpace> colorSpaces =
						new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				colorSpaces.add(buffer);
				return Collections.unmodifiableList(colorSpaces);
			}
		}
		return Collections.emptyList();
	}

	private List<? extends PDXImage> getAlternates() {
		List<org.verapdf.pd.images.PDXImage> alternates =
				((org.verapdf.pd.images.PDXImage) simplePDObject).getAlternates();
		final List<PDXImage> res = new ArrayList<>(alternates.size());
		for (org.verapdf.pd.images.PDXImage image : alternates) {
			res.add(new GFPDXImage(image));
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
			List<JPEG2000> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFJPEG2000(jpeg));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	/**
	 * @return true if current image contains SMask value of type stream or SMaskInData value greater then 0
	 */
	public boolean containsTransparency() {
		return ((org.verapdf.pd.images.PDXImage) this.simplePDObject).getSMaskInData() > 0;
	}
}
