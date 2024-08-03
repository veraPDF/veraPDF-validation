/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.external;

import org.verapdf.external.ICCProfile;
import org.verapdf.model.external.ICCOutputProfile;

/**
 * @author Maksim Bezrukov
 */
public class GFICCOutputProfile extends GFICCProfile implements ICCOutputProfile {

	/**	Type name for {@code GFICCOutputProfile} */
	public static final String ICC_OUTPUT_PROFILE_TYPE = "ICCOutputProfile";

	private final String subtype;

	/**
	 * Default constructor
	 *
	 * @param profile icc profile object
	 * @param subtype subtype value for current profile
	 */
	public GFICCOutputProfile(ICCProfile profile, String subtype) {
		super(profile, ICC_OUTPUT_PROFILE_TYPE);
		this.subtype = subtype;
	}

	/**
	 * @return subtype of output intent, which use current ICC profile
	 */
	@Override
	public String getS() {
		return this.subtype;
	}
}
