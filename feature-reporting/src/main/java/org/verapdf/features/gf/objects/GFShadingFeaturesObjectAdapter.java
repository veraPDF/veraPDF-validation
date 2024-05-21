/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
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

import org.verapdf.features.objects.ShadingFeaturesObjectAdapter;
import org.verapdf.pd.patterns.PDShading;

import java.util.Collections;
import java.util.List;

/**
 * Features object adapter for shading
 *
 * @author Maksim Bezrukov
 */
public class GFShadingFeaturesObjectAdapter implements ShadingFeaturesObjectAdapter {

	private final PDShading shading;
	private final String id;
	private final String colorSpaceChild;

	/**
	 * Constructs new shading features object adapter
	 *
	 * @param shading         PDShading which represents shading for feature report
	 * @param id              id of the object
	 * @param colorSpaceChild colorSpace id which contains in this shading
	 */
	public GFShadingFeaturesObjectAdapter(PDShading shading, String id, String colorSpaceChild) {
		this.shading = shading;
		this.id = id;
		this.colorSpaceChild = colorSpaceChild;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getColorSpaceChild() {
		return colorSpaceChild;
	}

	@Override
	public int getShadingType() {
		if (shading != null && !shading.empty()) {
			return shading.getShadingType();
		}
		return 0;
	}

	@Override
	public double[] getBBox() {
		if (shading != null && !shading.empty()) {
			return shading.getBBox();
		}
		return null;
	}

	@Override
	public boolean getAntiAlias() {
		if (shading != null && !shading.empty()) {
			return shading.getAntiAlias();
		}
		return false;
	}

	@Override
	public boolean isPDFObjectPresent() {
		return this.shading != null && !shading.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}
}
