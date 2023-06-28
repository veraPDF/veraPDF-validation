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

import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.objects.ActionFeaturesObjectAdapter;
import org.verapdf.pd.actions.PDAction;

import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFActionFeaturesObjectAdapter implements ActionFeaturesObjectAdapter {

	private final PDAction action;
	private final Location location;

	public GFActionFeaturesObjectAdapter(PDAction action, Location location) {
		this.action = action;
		this.location = location;
	}

	@Override
	public String getType() {
		return GFAdapterHelper.getStringFromASAtom(this.action.getSubtype());
	}

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public boolean isPDFObjectPresent() {
		return this.action != null && !this.action.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}
}
