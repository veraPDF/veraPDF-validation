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
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BDC;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.selayer.SEMarkedContent;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;

import java.util.List;

public class GFSEMarkedContent extends GFSEContentItem implements SEMarkedContent {

    public static final String MARKED_CONTENT_TYPE = "SEMarkedContent";

    private GFOpMarkedContent operator;
    String parentTag;

    public GFSEMarkedContent() {
        super(MARKED_CONTENT_TYPE);
    }

    protected GFSEMarkedContent(String objectType) {
        super(objectType);
    }

    public GFSEMarkedContent(List<Operator> operators, String parentTag) {
        super(MARKED_CONTENT_TYPE);
        this.operators = operators.subList(1, operators.size() - 1);
        this.operator = (GFOpMarkedContent)operators.get(0);
        this.parentTag = parentTag;
    }

    @Override
    public String gettag() {
        return operator.getTag().get(0).getinternalRepresentation();
    }

    @Override
    public String getstructureTag() {
        Long mcid = operator.getMCID();
        PDStructTreeRoot structTreeRoot = StaticContainers.getDocument().getStructTreeRoot();
        if (structTreeRoot != null) {
            PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
            COSObject structureElement = parentTreeRoot == null ? null : ((GFOp_BDC)operator).structureElementAccessObject.getStructureElement(parentTreeRoot, mcid);
            if (structureElement != null && !structureElement.empty()) {
                return structureElement.getStringKey(ASAtom.S);
            }
        }
        return null;
    }

    @Override
    public String getparentTag() {
        return parentTag;
    }

}
