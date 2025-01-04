/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.operator.shading;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.pd.patterns.GFPDShading;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_sh;
import org.verapdf.model.pdlayer.PDShading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_sh extends GFOperator implements Op_sh {

	/** Type name for {@code GFOp_sh} */
    public static final String OP_SH_TYPE = "Op_sh";

	/** Name of link to the shading */
    public static final String SHADING = "shading";

    private final org.verapdf.pd.patterns.PDShading rawShading;

    public GFOp_sh(List<COSBase> arguments, org.verapdf.pd.patterns.PDShading rawShading) {
        super(arguments, OP_SH_TYPE);
        this.rawShading = rawShading;
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (SHADING.equals(link)) {
            return this.getShading();
        }
        return super.getLinkedObjects(link);
    }

    private List<org.verapdf.model.pdlayer.PDShading> getShading() {
        if (this.rawShading != null) {
            List<PDShading> list =
                    new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(new GFPDShading(this.rawShading));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

}
