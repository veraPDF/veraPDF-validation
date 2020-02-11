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
import org.verapdf.gf.model.impl.pd.signature.GFPDSignatureField;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDAction;
import org.verapdf.model.pdlayer.PDFormField;
import org.verapdf.pd.actions.PDFormFieldActions;
import org.verapdf.pd.form.PDSignatureField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDFormField extends GFPDObject implements PDFormField {
    public static final String FORM_FIELD_TYPE = "PDFormField";

    public static final String ADDITIONAL_ACTION = "AA";

    public static final int MAX_NUMBER_OF_ACTIONS = 4;

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

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (ADDITIONAL_ACTION.equals(link)) {
            return this.getAdditionalAction();
        }
        return super.getLinkedObjects(link);
    }

    private List<PDAction> getAdditionalAction() {
        PDFormFieldActions pbActions = ((org.verapdf.pd.form.PDFormField) this.simplePDObject)
                .getActions();
        if (pbActions != null) {
            List<PDAction> actions = new ArrayList<>(MAX_NUMBER_OF_ACTIONS);

            org.verapdf.pd.actions.PDAction buffer;

            buffer = pbActions.getC();
            this.addAction(actions, buffer);

            buffer = pbActions.getF();
            this.addAction(actions, buffer);

            buffer = pbActions.getK();
            this.addAction(actions, buffer);

            buffer = pbActions.getV();
            this.addAction(actions, buffer);

            return Collections.unmodifiableList(actions);
        }

        return Collections.emptyList();
    }
}
