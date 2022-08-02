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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSString;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.pd.actions.GFPDAdditionalActions;
import org.verapdf.gf.model.impl.pd.signature.GFPDSignatureField;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.pdlayer.PDAdditionalActions;
import org.verapdf.model.pdlayer.PDFormField;
import org.verapdf.pd.actions.PDFormFieldActions;
import org.verapdf.pd.form.PDSignatureField;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.tools.StaticResources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDFormField extends GFPDObject implements PDFormField {
    public static final String FORM_FIELD_TYPE = "PDFormField";

    public static final String ADDITIONAL_ACTION = "AA";

    public static final String LANG = "Lang";

    public GFPDFormField(org.verapdf.pd.form.PDFormField simplePDObject) {
        super(simplePDObject, FORM_FIELD_TYPE);
    }

    protected GFPDFormField(org.verapdf.pd.form.PDFormField field, final String type) {
        super(field, type);
    }

    public static GFPDFormField createTypedFormField(org.verapdf.pd.form.PDFormField field) {
        if (field.getFT() == ASAtom.SIG) {
            return new GFPDSignatureField((PDSignatureField) field);
        }
		return new GFPDFormField(field);
    }

    @Override
    public String getFT() {
        ASAtom ft = ((org.verapdf.pd.form.PDFormField) this.simplePDObject).getFT();
        return ft == null ? null : ft.getValue();
    }

    @Override
    public Boolean getcontainsAA() {
        return this.simplePDObject.knownKey(ASAtom.AA);
    }

    private List<CosLang> getLang() {
        PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
        Long structParent = ((org.verapdf.pd.form.PDFormField)this.simplePDObject).getStructParent();
        if (structTreeRoot != null && structParent != null) {
            PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
            COSObject structureElement = parentTreeRoot == null ? null : parentTreeRoot.getObject(structParent);
            if (structureElement != null) {
                COSObject baseLang = structureElement.getKey(ASAtom.LANG);
                if (baseLang != null && baseLang.getType() == COSObjType.COS_STRING) {
                    List<CosLang> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                    list.add(new GFCosLang((COSString) baseLang.getDirectBase()));
                    return Collections.unmodifiableList(list);
                }
            }
        }
        return Collections.emptyList();
    }

    @Override
    public String getTU() {
        return ((org.verapdf.pd.form.PDFormField)this.simplePDObject).getTU();
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case ADDITIONAL_ACTION:
                return this.getAdditionalAction();
            case LANG:
                return this.getLang();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<PDAdditionalActions> getAdditionalAction() {
        PDFormFieldActions pdActions = ((org.verapdf.pd.form.PDFormField) this.simplePDObject)
                .getActions();
        if (pdActions != null) {
            List<PDAdditionalActions> actions = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            actions.add(new GFPDAdditionalActions(pdActions));
            return Collections.unmodifiableList(actions);
        }

        return Collections.emptyList();
    }
}
