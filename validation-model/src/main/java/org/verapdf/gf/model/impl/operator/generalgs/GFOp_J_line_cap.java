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
package org.verapdf.gf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosInteger;
import org.verapdf.model.operator.Op_J_line_cap;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_J_line_cap extends GFOpGeneralGS implements Op_J_line_cap {

	/** Type name for {@code GFOp_J_line_cap} */
    public static final String OP_J_LINE_CAP_TYPE = "Op_J_line_cap";

	/** Name of link to the line cap */
    public static final String LINE_CAP = "lineCap";

    public GFOp_J_line_cap(List<COSBase> arguments) {
        super(arguments, OP_J_LINE_CAP_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (LINE_CAP.equals(link)) {
            return this.getLineCap();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosInteger> getLineCap() {
		return this.getLastInteger();
    }

}
