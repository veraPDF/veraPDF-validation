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
package org.verapdf.gf.model.impl.pd.gfse.contents;

import org.verapdf.gf.model.impl.operator.textshow.GFOpTextShow;
import org.verapdf.model.selayer.SETextItem;

/**
 * @author Maxim Plushchov
 */
public class GFSETextItem extends GFSEGraphicContentItem implements SETextItem {

    public static final String TEXT_ITEM_TYPE = "SETextItem";
    private static final String TEXT_CONTENT_ITEM_TYPE = "text";

    private final GFOpTextShow opTextShow;

    public GFSETextItem(GFOpTextShow opTextShow, GFSEGroupedContent groupedContent) {
        super(TEXT_ITEM_TYPE, groupedContent);
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
    public String getLang() {
        return groupedContent.getLangValue();
    }

    @Override
    public String getitemType() {
        return TEXT_CONTENT_ITEM_TYPE;
    }
}
