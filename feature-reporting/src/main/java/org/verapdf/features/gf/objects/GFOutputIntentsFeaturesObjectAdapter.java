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

import org.verapdf.features.objects.OutputIntentFeaturesObjectAdapter;
import org.verapdf.pd.PDOutputIntent;

import java.util.Collections;
import java.util.List;

/**
 * Feature object for output intents
 *
 * @author Maksim Bezrukov
 */
public class GFOutputIntentsFeaturesObjectAdapter implements OutputIntentFeaturesObjectAdapter {

	private PDOutputIntent outInt;
	private String iccProfileID;

	/**
	 * Constructs new OutputIntent Feature Object
	 *
	 * @param outInt       class represents OutputIntent object
	 * @param iccProfileID id of the icc profile which use in this outputIntent
	 */
	public GFOutputIntentsFeaturesObjectAdapter(PDOutputIntent outInt, String iccProfileID) {
		this.outInt = outInt;
		this.iccProfileID = iccProfileID;
	}

	@Override
	public String getICCProfileID() {
		return this.iccProfileID;
	}

	@Override
	public String getSubType() {
		if (outInt != null && !outInt.empty()) {
			return outInt.getSubtype();
		}
		return null;
	}

	@Override
	public String getOutputCondition() {
		if (outInt != null && !outInt.empty()) {
			return outInt.getOutputCondition();
		}
		return null;
	}

	@Override
	public String getOutputConditionIdentifier() {
		if (outInt != null && !outInt.empty()) {
			return outInt.getOutputConditionIdentifier();
		}
		return null;
	}

	@Override
	public String getRegistryName() {
		if (outInt != null && !outInt.empty()) {
			return outInt.getRegistryName();
		}
		return null;
	}

	@Override
	public String getInfo() {
		if (outInt != null && !outInt.empty()) {
			return outInt.getInfo();
		}
		return null;
	}

	@Override
	public boolean isPDFObjectPresent() {
		return outInt != null && !outInt.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}
}
