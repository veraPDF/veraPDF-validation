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
package org.verapdf.gf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSObjType;
import org.verapdf.model.operator.Op_Tr;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tr extends GFOpTextState implements Op_Tr {

	/** Type name for {@code GFOp_Tr} */
    public static final String OP_TR_TYPE = "Op_Tr";

    public GFOp_Tr(List<COSBase> arguments) {
        super(arguments, OP_TR_TYPE);
    }

    @Override
    public Long getrenderingMode() {
        if (!this.arguments.isEmpty()) {
            COSBase renderingMode = this.arguments.get(0);
            if (renderingMode.getType() == COSObjType.COS_INTEGER) {
                return renderingMode.getInteger();
            }
        }
        return null;
    }

}
