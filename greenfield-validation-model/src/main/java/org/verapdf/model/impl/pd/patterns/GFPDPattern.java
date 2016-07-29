package org.verapdf.model.impl.pd.patterns;

import org.verapdf.model.impl.pd.colors.GFPDColorSpace;
import org.verapdf.model.pdlayer.PDPattern;

/**
 * @author Maksim Bezrukov
 */
public class GFPDPattern extends GFPDColorSpace implements PDPattern {

	protected GFPDPattern(org.verapdf.pd.patterns.PDPattern simplePDObject,
							final String type) {
		super(simplePDObject, type);
	}
}
