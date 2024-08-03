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
package org.verapdf.gf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_M_miter_limit;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_M_miter_limit extends GFOpGeneralGS implements Op_M_miter_limit {

	/** Type name for {@code GFOp_M_miter_limit} */
    public static final String OP_M_MITER_LIMIT_TYPE = "Op_M_miter_limit";

	/** Name of link to the miter limit */
    public static final String MITER_LIMIT = "miterLimit";

    public GFOp_M_miter_limit(List<COSBase> arguments) {
        super(arguments, OP_M_MITER_LIMIT_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (MITER_LIMIT.equals(link)) {
            return this.getMiterLimit();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getMiterLimit() {
        return this.getLastNumber();
    }

}
