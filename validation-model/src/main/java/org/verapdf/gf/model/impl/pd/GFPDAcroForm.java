/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDAcroForm;
import org.verapdf.model.pdlayer.PDFormField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class GFPDAcroForm extends GFPDObject implements PDAcroForm {

    private static final Logger LOGGER = Logger.getLogger(GFPDAcroForm.class.getCanonicalName());

    public static final String ACRO_FORM_TYPE = "PDAcroForm";

    public static final String FORM_FIELDS = "formFields";

    public GFPDAcroForm(org.verapdf.pd.form.PDAcroForm acroForm) {
        super(acroForm, ACRO_FORM_TYPE);
    }

    @Override
    public Boolean getNeedAppearances() {
        COSObject cosNeedAppearances = ((org.verapdf.pd.form.PDAcroForm)
                simplePDObject).getNeedAppearances();
        if (cosNeedAppearances.getType() == COSObjType.COS_BOOLEAN) {
            return cosNeedAppearances.getBoolean();
        } else if (cosNeedAppearances.empty()) {
            return null;
        } else {
            LOGGER.log(Level.SEVERE, "Value of NeedAppearances key is not a boolean. Ignoring NeedAppearances");
            // value that fails the check
            return Boolean.TRUE;
        }
    }

    @Override
    public Boolean getcontainsXFA() {
        return Boolean.valueOf(this.simplePDObject.knownKey(ASAtom.XFA));
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case FORM_FIELDS:
                return this.getFormFields();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<PDFormField> getFormFields() {
        List<org.verapdf.pd.form.PDFormField> fields = ((org.verapdf.pd.form.PDAcroForm) this.simplePDObject)
                .getFields();
        List<PDFormField> formFields =
                new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        for (org.verapdf.pd.form.PDFormField field : fields) {
            formFields.add(GFPDFormField.createTypedFormField(field));
        }
        return Collections.unmodifiableList(formFields);
    }

}
