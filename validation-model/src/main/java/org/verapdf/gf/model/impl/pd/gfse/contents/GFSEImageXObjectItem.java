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
package org.verapdf.gf.model.impl.pd.gfse.contents;

import org.verapdf.gf.model.impl.operator.xobject.GFOp_Do;
import org.verapdf.gf.model.impl.pd.images.GFPDXImage;
import org.verapdf.model.selayer.SEImageXObjectItem;

/**
 * @author Maxim Plushchov
 */
public class GFSEImageXObjectItem extends GFSEImageItem implements SEImageXObjectItem {

    public static final String IMAGE_X_OBJECT_ITEM_TYPE = "SEImageXObjectItem";

    private final GFOp_Do operator;
    private final GFPDXImage image;

    public GFSEImageXObjectItem(GFOp_Do operator, GFPDXImage image, GFSEGroupedContent groupedContent) {
        super(IMAGE_X_OBJECT_ITEM_TYPE, groupedContent);
        this.operator = operator;
        this.image = image;
    }
}
