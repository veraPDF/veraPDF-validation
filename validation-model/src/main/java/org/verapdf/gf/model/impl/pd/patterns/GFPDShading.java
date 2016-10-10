package org.verapdf.gf.model.impl.pd.patterns;

import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.impl.pd.GFPDResource;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDShading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDShading extends GFPDResource implements PDShading {

	public static final String SHADING_TYPE = "PDShading";

	public static final String COLOR_SPACE = "colorSpace";

	public GFPDShading(org.verapdf.pd.patterns.PDShading simplePDObject) {
		super(simplePDObject, SHADING_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (COLOR_SPACE.equals(link)) {
			return this.getColorSpace();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDColorSpace> getColorSpace() {
		org.verapdf.pd.colors.PDColorSpace cs =
				((org.verapdf.pd.patterns.PDShading) this.simplePDObject).getColorSpace();
		if (cs != null) {
			List<PDColorSpace> colorSpaces =
					new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			colorSpaces.add(ColorSpaceFactory.getColorSpace(cs));
			return Collections.unmodifiableList(colorSpaces);
		}
		return Collections.emptyList();
	}
}
