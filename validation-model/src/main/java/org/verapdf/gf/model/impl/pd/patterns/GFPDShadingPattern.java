/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.patterns;

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
