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

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSString;
import org.verapdf.gf.model.impl.operator.inlineimage.GFOp_EI;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BDC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BMC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_EMC;
import org.verapdf.gf.model.impl.operator.pathpaint.GFOpPathPaint;
import org.verapdf.gf.model.impl.operator.pathpaint.GFOp_n;
import org.verapdf.gf.model.impl.operator.shading.GFOp_sh;
import org.verapdf.gf.model.impl.operator.textshow.GFOpTextShow;
import org.verapdf.gf.model.impl.operator.xobject.GFOp_Do;
import org.verapdf.gf.model.impl.pd.images.GFPDXImage;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.pdlayer.PDXObject;
import org.verapdf.model.selayer.SEContentItem;
import org.verapdf.model.selayer.SEMarkedContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Maxim Plushchov
 */
public class GFSEMarkedContent extends GFSEGroupedContent implements SEMarkedContent {

    public static final String MARKED_CONTENT_TYPE = "SEMarkedContent";

    public static final String LANG = "Lang";

    private final GFOpMarkedContent operator;

    public GFSEMarkedContent(GFOpMarkedContent operator, List<Operator> operators, COSObject parentStructElem, 
                             List<String> parentsTags, String defaultLang, boolean isSignature) {
        super(MARKED_CONTENT_TYPE, operators, getParentStructElement(parentStructElem, operator), parentsTags, defaultLang, 
                isSignature);
        this.operator = operator;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case CONTENT_ITEM:
                return this.getContentItem();
            case LANG:
                return this.getLinkLang();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<SEContentItem> getContentItem() {
        if (operators == null) {
            return Collections.emptyList();
        }
        Stack<Integer> markedContentStack = new Stack<>();
        List<SEContentItem> list = new ArrayList<>();
        for (int i = 0; i < operators.size(); i++) {
            Operator op = operators.get(i);
            String type = op.getObjectType();
            if (GFOp_BDC.OP_BDC_TYPE.equals(type) || GFOp_BMC.OP_BMC_TYPE.equals(type)) {
                markedContentStack.push(i);
            } else if (GFOp_EMC.OP_EMC_TYPE.equals(type)) {
                if (!markedContentStack.empty()) {
                    int markedContentIndex = markedContentStack.pop();
                    if (markedContentStack.empty()) {
                        list.add(new GFSEMarkedContent((GFOpMarkedContent)operators.get(markedContentIndex), 
                                operators.subList(markedContentIndex + 1, i + 1),
                                parentStructElem, parentsTags, defaultLang, isSignature));
                    }
                }
            }
            if (markedContentStack.empty()) {
                if (op instanceof GFOpTextShow) {
                    list.add(new GFSETextItem((GFOpTextShow)op, this));
                } else if (op instanceof GFOp_sh) {
                    list.add(new GFSEShadingItem((GFOp_sh)op, this));
                } else if (op instanceof GFOpPathPaint && !(op instanceof GFOp_n)) {
                    list.add(new GFSELineArtItem((GFOpPathPaint)op, this));
                } else if (op instanceof GFOp_EI) {
                    list.add(new GFSEInlineImageItem((GFOp_EI)op, this));
                } else if (op instanceof GFOp_Do) {
                    PDXObject xObject = ((GFOp_Do)op).getXObject();
                    if (xObject != null && ASAtom.IMAGE.getValue().equals(xObject.getSubtype())) {
                        list.add(new GFSEImageXObjectItem((GFOp_Do)op, (GFPDXImage)xObject, this));
                    }
                }
            }
        }
        return Collections.unmodifiableList(list);
    }

    public List<CosLang> getLinkLang() {
        return operator.getLinkLang();
    }

    @Override
    public String getLang() {
        COSString lang = operator.getLang();
        return lang != null ? lang.getString() : null;
    }

    @Override
    public String getinheritedLang() {
        String inheritedLang = operator.getInheritedLang();
        return inheritedLang != null ? inheritedLang : super.getLangValue();
    }

    @Override
    public String getExtraContext() {
        Long mcid = operator.getInheritedMCID();
        return mcid != null ? "mcid:" + mcid : null;
    }

    @Override
    public String gettag() {
        COSName tag = operator.getTag();
        return tag != null ? tag.getString() : null;
    }

    @Override
    public String getE() {
        COSString E = operator.getE();
        return E != null ? E.toString() : null;
    }

    @Override
    public String getAlt() {
        COSString Alt = operator.getAlt();
        return Alt != null ? Alt.toString() : null;
    }

    @Override
    public String getActualText() {
        COSString ActualText = operator.getActualText();
        return ActualText != null ? ActualText.toString() : null;
    }

    @Override
    public List<String> getparentsTags() {
        return operator.getParentsTags();
    }

    @Override
    public String getLangValue() {
        String lang = getLang();
        return lang != null ? lang : getinheritedLang();
    }

    @Override
    public String getInheritedActualText() {
        COSString actualText = operator.getInheritedActualText();
        if (actualText != null) {
            return actualText.getString();
        }
        return null;
    }

    @Override
    public String getInheritedAlt() {
        COSString alt = operator.getInheritedAlt();
        if (alt != null) {
            return alt.getString();
        }
        return null;
    }
    
    @Override
    public Long getMCID() {
        return operator.getMCID();
    }

    private static COSObject getParentStructElement(COSObject parentStructElem, GFOpMarkedContent markedOperator) {
        COSObject structElem = markedOperator.getParentStructElem();
        return structElem != null ? structElem : parentStructElem;
    }
}
