/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Feature Reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Feature Reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Feature Reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.features.objects.ShadingPatternFeaturesObjectAdapter;
import org.verapdf.pd.patterns.PDShadingPattern;

import java.util.Collections;
import java.util.List;

/**
 * Features object adapter for shading pattern
 *
 * @author Maksim Bezrukov
 */
public class GFShadingPatternFeaturesObjectAdapter implements ShadingPatternFeaturesObjectAdapter {

	private final PDShadingPattern shadingPattern;
	private final String id;
	private final String shadingChild;
	private final String extGStateChild;

	/**
	 * Constructs new shading pattern features object adapter
	 *
	 * @param shadingPattern PDShadingPattern which represents shading pattern for feature report
	 * @param id             id of the object
	 * @param extGStateChild external graphics state id which contains in this shading pattern
	 * @param shadingChild   shading id which contains in this shading pattern
	 */
	public GFShadingPatternFeaturesObjectAdapter(PDShadingPattern shadingPattern, String id, String shadingChild, String extGStateChild) {
		this.shadingPattern = shadingPattern;
		this.id = id;
		this.shadingChild = shadingChild;
		this.extGStateChild = extGStateChild;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getShadingChild() {
		return shadingChild;
	}

	@Override
	public String getExtGStateChild() {
		return extGStateChild;
	}

	@Override
	public double[] getMatrix() {
		if (shadingPattern != null && !shadingPattern.empty()) {
			return shadingPattern.getMatrix();
		}
		return null;
	}

	@Override
	public boolean isPDFObjectPresent() {
		return shadingPattern != null && !shadingPattern.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}
}
