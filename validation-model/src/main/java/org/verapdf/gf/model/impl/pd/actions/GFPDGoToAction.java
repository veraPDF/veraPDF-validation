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
package org.verapdf.gf.model.impl.pd.actions;

import org.verapdf.cos.COSNumber;
import org.verapdf.gf.model.impl.cos.GFCosReal;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosReal;
import org.verapdf.model.pdlayer.PDGoToAction;
import org.verapdf.pd.actions.PDAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDGoToAction extends GFPDAction implements PDGoToAction {
	public static final String GOTO_ACTION_TYPE = "PDGoToAction";

	public static final String D = "D";

	public GFPDGoToAction(PDAction simplePDObject) {
		super(simplePDObject, GOTO_ACTION_TYPE);
	}

	protected GFPDGoToAction(PDAction simplePDObject, String type) {
		super(simplePDObject, type);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (D.equals(link)) {
			return this.getD();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosNumber> getD() {
		List<COSNumber> numbers = ((PDAction) simplePDObject).getCOSArrayD();
		return ( numbers.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(numbers) ); 
	}
}
