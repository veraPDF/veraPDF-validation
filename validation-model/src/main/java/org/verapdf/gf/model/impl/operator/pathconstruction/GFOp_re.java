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
package org.verapdf.gf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_re;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_re extends GFOpPathConstruction implements Op_re {

	/** Type name for {@code GFOp_re} */
    public static final String OP_RE_TYPE = "Op_re";

	/** Name of link to the rectangle box */
    public static final String RECT_BOX = "rectBox";

    public GFOp_re(List<COSBase> arguments) {
        super(arguments, OP_RE_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
       if(RECT_BOX.equals(link)) {
           return this.getRectBox();
       }
       return super.getLinkedObjects(link);
    }

    private List<CosNumber> getRectBox() {
        return this.getListOfNumbers();
    }

}
