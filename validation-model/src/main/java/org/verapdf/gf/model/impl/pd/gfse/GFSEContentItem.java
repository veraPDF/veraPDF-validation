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
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BDC;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.selayer.SEContentItem;

import java.util.Collections;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSEContentItem extends GenericModelObject implements SEContentItem {

    public static final String CONTENT_ITEM = "contentItem";

    protected Long parentMCID;
    protected GFOpMarkedContent parentMarkedContentOperator;

    List<Operator> operators;
    protected String parentStructureTag;
    protected String parentsTags;

    public GFSEContentItem(String objectType, String parentStructureTag, String parentsTags) {
        super(objectType);
        this.parentStructureTag = parentStructureTag;
        this.parentsTags = parentsTags;
    }

    public GFSEContentItem(String objectType, GFOpMarkedContent parentMarkedContentOperator, String parentStructureTag,
                           String parentsTags) {
        super(objectType);
        this.parentMarkedContentOperator = parentMarkedContentOperator;
        this.parentMCID = parentMarkedContentOperator != null ? parentMarkedContentOperator.getMCID() : null;
        this.parentStructureTag = parentStructureTag;
        this.parentsTags = parentsTags;
    }

    @Override
    public String getExtraContext() {
        return parentMCID != null ? "mcid:" + parentMCID : null;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case CONTENT_ITEM:
                return Collections.emptyList();
            default:
                return super.getLinkedObjects(link);
        }
    }

    @Override
    public String getparentsTags() {
        if (parentMarkedContentOperator != null) {
            return parentMarkedContentOperator.getParentsTags();
        }
        return parentsTags;
    }

    @Override
    public String getparentStructureTag() {
        if (parentMarkedContentOperator != null) {
            String structTag = null;
            if (GFOp_BDC.OP_BDC_TYPE.equals(parentMarkedContentOperator.getObjectType())) {
                structTag = ((GFOp_BDC)parentMarkedContentOperator).getstructureTag();
            }
            if (structTag == null) {
                structTag = parentMarkedContentOperator.getParentStructureTag();
            }
            if (structTag != null) {
                return structTag;
            }
        }
        return parentStructureTag;
    }

    @Override
    public String getparentStandardTag() {
        return StaticContainers.getRoleMapHelper().getStandardType(ASAtom.getASAtom(getparentStructureTag()));
    }

}
