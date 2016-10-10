package org.verapdf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.pd.signature.GFPDSignatureField;
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
        } else {
            return new GFPDFormField(field);
        }
    }

    @Override
    public String getFT() {
        ASAtom ft = ((org.verapdf.pd.form.PDFormField) this.simplePDObject).getFT();
        return ft == null ? null : ft.getValue();
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
