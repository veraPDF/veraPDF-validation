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
import org.verapdf.gf.model.impl.operator.textshow.GFOp_TJ_Big;
import org.verapdf.gf.model.impl.operator.textshow.GFOp_Tj;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.selayer.SEContentItem;
import org.verapdf.model.selayer.SEUnmarkedContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFSEUnmarkedContent extends GFSEContentItem implements SEUnmarkedContent {

    public static final String UNMARKED_CONTENT_TYPE = "SEUnmarkedContent";

    public GFSEUnmarkedContent(List<Operator> operators) {
        super(UNMARKED_CONTENT_TYPE, operators);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case CONTENT_ITEM:
                return this.getContentItem();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<SEContentItem> getContentItem() {
        if (operators == null) {
            return Collections.emptyList();
        }
        List<SEContentItem> list = new ArrayList<>();
        for (Operator operator : operators) {
            String type = operator.getObjectType();
            if (type.equals(GFOp_Tj.OP_TJ_TYPE) || type.equals(GFOp_TJ_Big.OP_TJ_BIG_TYPE)) {
                list.add(new GFSETextItem((GFOpTextShow)operator));
            }
        }
        return Collections.unmodifiableList(list);
    }

}
