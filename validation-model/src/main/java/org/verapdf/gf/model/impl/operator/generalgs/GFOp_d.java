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

import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSObjType;
import org.verapdf.gf.model.impl.cos.GFCosArray;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosArray;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_d extends GFOpGeneralGS implements Op_d {

	/** Type name for {@code GFOp_d} */
    public static final String OP_D_TYPE = "Op_d";

	/** Name of link to the dash array */
    public static final String DASH_ARRAY = "dashArray";
	/** Name of link to the dash phase */
    public static final String DASH_PHASE = "dashPhase";

    public GFOp_d(List<COSBase> arguments) {
        super(arguments, OP_D_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case DASH_ARRAY:
                return this.getDashArray();
            case DASH_PHASE:
                return this.getDashPhase();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<CosArray> getDashArray() {
        if (this.arguments.size() > 1) {
            COSBase array = this.arguments.get(this.arguments.size() - 2);
            if (array.getType() == COSObjType.COS_ARRAY) {
                List<CosArray> list = new ArrayList<>(GFOperator.MAX_NUMBER_OF_ELEMENTS);
                list.add(new GFCosArray((COSArray) array));
                return Collections.unmodifiableList(list);
            }
        }
        return Collections.emptyList();
    }

    private List<CosNumber> getDashPhase() {
        return this.getLastNumber();
    }

}
