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
