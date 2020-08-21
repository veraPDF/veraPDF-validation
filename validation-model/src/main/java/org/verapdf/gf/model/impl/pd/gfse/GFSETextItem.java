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

import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BDC;
import org.verapdf.gf.model.impl.operator.textshow.GFOpTextShow;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.selayer.SETextItem;

import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSETextItem extends GFSESimpleContentItem implements SETextItem {

    public static final String TEXT_ITEM_TYPE = "SETextItem";

    private GFOpTextShow opTextShow;
    private String defaultLang;

    public GFSETextItem(GFOpTextShow opTextShow, String parentStructureTag, String parentsTags, String defaultLang) {
        this(opTextShow, null, parentStructureTag, parentsTags, defaultLang);
    }

    public GFSETextItem(GFOpTextShow opTextShow, GFOpMarkedContent parentMarkedContentOperator,
                        String parentStructureTag, String parentsTags, String defaultLang) {
        super(TEXT_ITEM_TYPE, parentMarkedContentOperator, parentStructureTag, parentsTags);
        this.opTextShow = opTextShow;
        this.defaultLang = defaultLang;
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
        if (opTextShow.getScaleFactor() != null) {
            if ((opTextShow.getPrevScaleFactor() != null && opTextShow.getScaleFactor() > opTextShow.getPrevScaleFactor())
                    || (opTextShow.getNextScaleFactor() != null && opTextShow.getScaleFactor() > opTextShow.getNextScaleFactor())) {
                return "H";
            }
            return "P";
        }
        return null;
    }

    @Override
    public String getLang() {
        if (parentMarkedContentOperator == null) {
            return null;
        }
        List<CosLang> lang =  parentMarkedContentOperator.getLang();
        if (lang != null && lang.size() != 0) {
            return lang.get(0).getunicodeValue();
        }
        if (parentMarkedContentOperator.getObjectType().equals(GFOp_BDC.OP_BDC_TYPE)) {
            String structParentLang = ((GFOp_BDC)parentMarkedContentOperator).getstructParentLang();
            if (structParentLang != null) {
                return structParentLang;
            }
        }
        String parentLang = parentMarkedContentOperator.getParentLang();
        return parentLang != null ? parentLang : this.defaultLang;
    }
}
