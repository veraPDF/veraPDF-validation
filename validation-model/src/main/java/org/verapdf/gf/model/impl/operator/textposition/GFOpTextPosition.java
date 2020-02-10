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
package org.verapdf.gf.model.impl.operator.textposition;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpTextPosition;

import java.util.List;

/**
 * Base class for all text position operators
 *
 * @author Timur Kamalov
 */
public class GFOpTextPosition extends GFOperator implements OpTextPosition {

	/**
	 * Type name for {@code GFOpTextPosition}. Current type applies to
	 * Tm and T* operators
	 */
    public static final String OP_TEXT_POSITION_TYPE = "OpTextPosition";

    public GFOpTextPosition(List<COSBase> arguments) {
        this(arguments, OP_TEXT_POSITION_TYPE);
    }

    public GFOpTextPosition(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

}
