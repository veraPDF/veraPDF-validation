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
package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.gf.model.impl.operator.textshow.GFOpTextShow;
import org.verapdf.model.selayer.SETextItem;

public class GFSETextItem extends GFSEContentItem implements SETextItem {

    public static final String TEXT_ITEM_TYPE = "SETextItem";

    private GFOpTextShow opTextShow;

    public GFSETextItem(GFOpTextShow opTextShow) {
        super(TEXT_ITEM_TYPE);
        this.opTextShow = opTextShow;
    }

    protected GFSETextItem(GFOpTextShow opTextShow, String objectType) {
        super(objectType);
        this.opTextShow = opTextShow;
    }

    @Override
    public String getfontName() {
        return opTextShow.getVeraModelFont().getfontName();
    }

    @Override
    public Double getscaleFactor() {
        return opTextShow.getScaleFactor();
    }

    @Override
    public String getsuspectRole() {
        if (getscaleFactor() >= 14) {
            return "Heading";
        }
        return "P";
    }
}
