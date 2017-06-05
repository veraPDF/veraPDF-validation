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
package org.verapdf.gf.model.impl.operator.color;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.OpColor;
import org.verapdf.model.pdlayer.PDColorSpace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOpColor extends GFOperator implements OpColor {

	/** Type name for {@code GFOpColor} */
    public static final String OP_COLOR_TYPE = "OpColor";
    public static final String COLOR_SPACE = "colorSpace";

    private PDColorSpace colorSpace;

    public GFOpColor(List<COSBase> arguments, PDColorSpace colorSpace) {
        super(arguments, OP_COLOR_TYPE);
        this.colorSpace = colorSpace;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case COLOR_SPACE:
                return getColorSpace();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<PDColorSpace> getColorSpace() {
        if (this.colorSpace != null) {
            List<PDColorSpace> res = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            res.add(colorSpace);
            return Collections.unmodifiableList(res);
        }
        return Collections.emptyList();
    }
}
