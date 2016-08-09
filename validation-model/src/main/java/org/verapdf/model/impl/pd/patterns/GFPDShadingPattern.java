package org.verapdf.model.impl.pd.patterns;

import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDShading;
import org.verapdf.model.pdlayer.PDShadingPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDShadingPattern extends GFPDPattern implements PDShadingPattern {
	public static final String SHADING_PATTERN_TYPE = "PDShadingPattern";

	public static final String SHADING = "shading";

	public GFPDShadingPattern(
			org.verapdf.pd.patterns.PDShadingPattern simplePDObject) {
		super(simplePDObject, SHADING_PATTERN_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (SHADING.equals(link)) {
			return this.getShading();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDShading> getShading() {
		org.verapdf.pd.patterns.PDShading shading =
				((org.verapdf.pd.patterns.PDShadingPattern) this.simplePDObject).getShading();
		if (shading != null) {
			List<PDShading> shadings = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			shadings.add(new GFPDShading(shading));
			return Collections.unmodifiableList(shadings);
		}
		return Collections.emptyList();
	}
}
