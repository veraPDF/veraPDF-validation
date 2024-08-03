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
package org.verapdf.gf.model.impl.operator.type3font;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_d0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_d0 extends GFOpType3Font implements Op_d0 {

	public static final String OP_D0_TYPE = "Op_d0";

	public static final String HORIZONTAL_DISPLACEMENT = "horizontalDisplacement";
	public static final String VERTICAL_DISPLACEMENT = "verticalDisplacement";

	public GFOp_d0(List<COSBase> arguments) {
		super(arguments, OP_D0_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case HORIZONTAL_DISPLACEMENT:
				return this.getHorizontalDisplacement();
			case VERTICAL_DISPLACEMENT:
				return this.getVerticalDisplacement();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosNumber> getHorizontalDisplacement() {
		if (this.arguments.size() > 1) {
			COSBase base = this.arguments.get(this.arguments.size() - 2);
			if (base.getType().isNumber()) {
				List<CosNumber> real = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				real.add(GFCosNumber.fromPDFParserNumber(base));
				return Collections.unmodifiableList(real);
			}
		}
		return Collections.emptyList();
	}

	private List<CosNumber> getVerticalDisplacement() {
		return this.getLastNumber();
	}

}
