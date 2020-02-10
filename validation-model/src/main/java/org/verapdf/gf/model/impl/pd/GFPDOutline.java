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

import org.verapdf.gf.model.impl.pd.actions.GFPDAction;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDAction;
import org.verapdf.model.pdlayer.PDOutline;
import org.verapdf.pd.PDOutlineItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDOutline extends GFPDObject implements PDOutline {

	public static final String OUTLINE_TYPE = "PDOutline";

	public static final String ACTION = "A";

	private final String id;

	public GFPDOutline(PDOutlineItem simplePDObject, String id) {
		super(simplePDObject, OUTLINE_TYPE);
		this.id = id;
	}

	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (ACTION.equals(link)) {
			return this.getAction();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDAction> getAction() {
		org.verapdf.pd.actions.PDAction action = ((PDOutlineItem) this.simplePDObject).getAction();
		if (action != null) {
			List<PDAction> actions = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			PDAction pdAction = GFPDAction.getAction(action);
			actions.add(pdAction);
			return Collections.unmodifiableList(actions);
		}
		return Collections.emptyList();
	}
}
