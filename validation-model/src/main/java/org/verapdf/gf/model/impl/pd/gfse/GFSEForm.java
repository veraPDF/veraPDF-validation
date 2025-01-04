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
package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.GFPDStructElem;
import org.verapdf.model.selayer.SEForm;
import org.verapdf.pd.structure.PDOBJRDictionary;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.AttributeHelper;
import org.verapdf.tools.TaggedPDFConstants;

import java.util.List;

public class GFSEForm extends GFPDStructElem implements SEForm {

    public static final String FORM_STRUCTURE_ELEMENT_TYPE = "SEForm";

    public GFSEForm(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.FORM, FORM_STRUCTURE_ELEMENT_TYPE);
    }

    @Override
    public String getroleAttribute() {
        return AttributeHelper.getRole(this.simpleCOSObject);
    }

    @Override
    public Boolean gethasOneInteractiveChild() {
        List<Object> children = ((PDStructElem)this.simplePDObject).getChildren();
        if (children.size() != 1) {
            return false;
        }
        Object child = children.get(0);
        if (child instanceof PDOBJRDictionary) {
            COSObject referencedObject = ((PDOBJRDictionary) child).getReferencedObject();
            if (referencedObject != null) {
                COSObject subtypeValue = referencedObject.getDirectBase().getKey(ASAtom.SUBTYPE);
                if (subtypeValue != null) {
                    return ASAtom.WIDGET.getValue().equals(subtypeValue.getDirectBase().getString());
                }
            }
        }
        return false;
    }

    @Override
    public Long getwidgetAnnotsCount() {
        int count = 0;
        for (Object child : ((PDStructElem)this.simplePDObject).getChildren()) {
            if (child instanceof PDOBJRDictionary) {
                COSObject referencedObject = ((PDOBJRDictionary) child).getReferencedObject();
                if (referencedObject != null) {
                    COSObject subtypeValue = referencedObject.getDirectBase().getKey(ASAtom.SUBTYPE);
                    if (subtypeValue != null && ASAtom.WIDGET.getValue().equals(subtypeValue.getDirectBase().getString())) {
                        count++;
                    }
                }
            }
        }
        return (long) count;
    }
}
