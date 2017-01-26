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
package org.verapdf.gf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.pd.GFPDExtGState;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_gs;
import org.verapdf.model.pdlayer.PDExtGState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Operator defining the specified parameters in the graphics state.
 *
 * @author Timur Kamalov
 */
public class GFOp_gs extends GFOpGeneralGS implements Op_gs {

	/** Type name for {@code GFOp_gs} */
    public static final String OP_GS_TYPE = "Op_gs";

	/** Name of link to the extended graphic state */
    public static final String EXT_G_STATE = "extGState";

    private final org.verapdf.pd.PDExtGState extGState;

    public GFOp_gs(List<COSBase> arguments, org.verapdf.pd.PDExtGState extGState) {
        super(arguments, OP_GS_TYPE);
        this.extGState = extGState;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (EXT_G_STATE.equals(link)) {
            return this.getExtGState();
        }
        return super.getLinkedObjects(link);
    }

    private List<PDExtGState> getExtGState() {
        if (this.extGState != null) {
            List<PDExtGState> extGStates = new ArrayList<>(GFOperator.MAX_NUMBER_OF_ELEMENTS);
            extGStates.add(new GFPDExtGState(this.extGState));
            return Collections.unmodifiableList(extGStates);
        }
        return Collections.emptyList();
    }

}
