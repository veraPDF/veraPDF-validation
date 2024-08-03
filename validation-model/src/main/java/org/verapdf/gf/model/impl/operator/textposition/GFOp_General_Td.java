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
package org.verapdf.gf.model.impl.operator.textposition;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Base class for text position operators (Td and TD)
 *
 * @author Timur Kamalov
 */
public abstract class GFOp_General_Td extends GFOpTextPosition {

	/** Name of link to the horizontal offset for Td and TD operators */
    public static final String HORIZONTAL_OFFSET = "horizontalOffset";

	/** Name of link to the vertical offset for Td and TD operators */
	public static final String VERTICAL_OFFSET = "verticalOffset";

    protected GFOp_General_Td(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case VERTICAL_OFFSET:
				return this.getVerticalOffset();
			case HORIZONTAL_OFFSET:
				return this.getHorizontalOffset();
			default:
				return super.getLinkedObjects(link);
		}
	}

    private List<CosNumber> getHorizontalOffset() {
		if (this.arguments.size() > 1) {
			COSBase number = this.arguments
					.get(this.arguments.size() - 2);
			if (number.getType().isNumber()) {
				List<CosNumber> offset = new ArrayList<>(GFOperator.MAX_NUMBER_OF_ELEMENTS);
				offset.add(GFCosNumber.fromPDFParserNumber(number));
				return Collections.unmodifiableList(offset);
			}
		}
        return Collections.emptyList();
    }

    private List<CosNumber> getVerticalOffset() {
        return this.getLastNumber();
    }

}
