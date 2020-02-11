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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDGroup;
import org.verapdf.pd.PDResources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDGroup extends GFPDObject implements PDGroup {

	public static final String GROUP_TYPE = "PDGroup";

	public static final String COLOR_SPACE = "colorSpace";

	private final PDResources resources;

	public GFPDGroup(org.verapdf.pd.PDGroup simplePDObject, PDResources resources) {
		super(simplePDObject, GROUP_TYPE);
		this.resources = resources;
		this.contextDependent = true;
	}

	@Override
	public String getS() {
		ASAtom subtype = ((org.verapdf.pd.PDGroup) this.simplePDObject).getSubtype();
		return subtype == null ? null : subtype.getValue();
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (COLOR_SPACE.equals(link)) {
			return this.getColorSpace();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDColorSpace> getColorSpace() {
		org.verapdf.pd.colors.PDColorSpace pbColorSpace =
				((org.verapdf.pd.PDGroup) this.simplePDObject).getColorSpace(this.resources);
		if (pbColorSpace != null) {
			PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(pbColorSpace);
			List<PDColorSpace> colorSpaces = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			colorSpaces.add(colorSpace);
			return Collections.unmodifiableList(colorSpaces);
		}
		return Collections.emptyList();
	}
}
