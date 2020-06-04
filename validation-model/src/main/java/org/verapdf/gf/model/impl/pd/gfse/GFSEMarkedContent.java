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

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSString;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BDC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BMC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_EMC;
import org.verapdf.gf.model.impl.operator.pathpaint.GFOpPathPaint;
import org.verapdf.gf.model.impl.operator.pathpaint.GFOp_n;
import org.verapdf.gf.model.impl.operator.shading.GFOp_sh;
import org.verapdf.gf.model.impl.operator.textshow.GFOpTextShow;
import org.verapdf.gf.model.impl.operator.textshow.GFOp_TJ_Big;
import org.verapdf.gf.model.impl.operator.textshow.GFOp_Tj;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.selayer.SEContentItem;
import org.verapdf.model.selayer.SEMarkedContent;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GFSEMarkedContent extends GFSEContentItem implements SEMarkedContent {

    public static final String MARKED_CONTENT_TYPE = "SEMarkedContent";

    public static final String LANG = "Lang";

    private GFOpMarkedContent operator;
    private GFSEMarkedContent parentMarkedContentSequence;

    public GFSEMarkedContent(List<Operator> operators) {
        super(MARKED_CONTENT_TYPE);
        this.operators = operators.subList(1, operators.size() - 1);
        this.operator = (GFOpMarkedContent)operators.get(0);
    }

    public GFSEMarkedContent(List<Operator> operators, GFSEMarkedContent parentMarkedContentSequence) {
        this(operators);
        this.parentMarkedContentSequence = parentMarkedContentSequence;
        this.parentMCID = parentMarkedContentSequence.getMCID();
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case CONTENT_ITEM:
                return this.getContentItem();
            case LANG:
                return this.operator.getLang();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<SEContentItem> getContentItem() {
        if (operators == null) {
            return Collections.emptyList();
        }
        int markedContentIndex;
        Stack<Integer> markedContentStack = new Stack<>();
        List<SEContentItem> list = new ArrayList<>();
        for (int i = 0; i < operators.size(); i++) {
            Operator op = operators.get(i);
            String type = op.getObjectType();
            if (type.equals(GFOp_BDC.OP_BDC_TYPE) || type.equals(GFOp_BMC.OP_BMC_TYPE)) {
                markedContentStack.push(i);
            } else if (type.equals(GFOp_EMC.OP_EMC_TYPE)) {
                if (!markedContentStack.empty()) {
                    markedContentIndex = markedContentStack.pop();
                    if (markedContentStack.empty()) {
                        list.add(new GFSEMarkedContent(operators.subList(markedContentIndex, i + 1), this));
                    }
                }
            } else if (type.equals(GFOp_Tj.OP_TJ_TYPE) || type.equals(GFOp_TJ_Big.OP_TJ_BIG_TYPE)) {
                list.add(new GFSETextItem((GFOpTextShow)op, operator.getMCID()));
            } else if (op instanceof GFOp_sh) {
                list.add(new GFSEShadingItem((GFOp_sh)op, operator.getMCID()));
            } else if (op instanceof GFOpPathPaint && !(op instanceof GFOp_n)) {
                list.add(new GFSELineArtItem((GFOpPathPaint)op, operator.getMCID()));
            }
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public String getExtraContext() {
        Long mcid = operator.getMCID();
        return mcid != null ?  "mcid:" + mcid : parentMCID != null ? "mcid:" + parentMCID : null;
    }

    @Override
    public String gettag() {
        return operator.getTag().get(0).getinternalRepresentation();
    }

    @Override
    public String getstructureTag() {
        Long mcid = operator.getMCID();
        PDStructTreeRoot structTreeRoot = StaticContainers.getDocument().getStructTreeRoot();
        if (structTreeRoot != null && mcid != null && operator.getObjectType().equals(GFOp_BDC.OP_BDC_TYPE)) {
            PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
            COSObject structureElement = parentTreeRoot == null ? null : ((GFOp_BDC)operator).structureElementAccessObject.getStructureElement(parentTreeRoot, mcid);
            if (structureElement != null && !structureElement.empty()) {
                return structureElement.getStringKey(ASAtom.S);
            }
        }
        return null;
    }

    public Long getMCID() {
        return operator.getMCID();
    }

    @Override
    public String getparentTag() {
        return parentMarkedContentSequence != null ? parentMarkedContentSequence.gettag() : null;
    }

    @Override
    public String getparentStructureTag() {
        return parentMarkedContentSequence != null ? parentMarkedContentSequence.getstructureTag() : null;
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

}
