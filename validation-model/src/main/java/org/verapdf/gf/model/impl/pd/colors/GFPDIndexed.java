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
package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDIndexed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDIndexed extends GFPDColorSpace implements PDIndexed {

    public static final String INDEXED_TYPE = "PDIndexed";

    public static final String BASE = "base";

    public GFPDIndexed(
            org.verapdf.pd.colors.PDIndexed simplePDObject) {
        super(simplePDObject, INDEXED_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (BASE.equals(link)) {
            return this.getBase();
        }
        return super.getLinkedObjects(link);
    }

    private List<PDColorSpace> getBase() {
        org.verapdf.pd.colors.PDColorSpace baseColorSpace =
                ((org.verapdf.pd.colors.PDIndexed) this.simplePDObject).getBase();
        PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(baseColorSpace);
        if (colorSpace != null) {
            List<PDColorSpace> base = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            base.add(colorSpace);
            return Collections.unmodifiableList(base);
        }
        return Collections.emptyList();
    }
}
