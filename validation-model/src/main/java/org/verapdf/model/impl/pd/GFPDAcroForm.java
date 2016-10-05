package org.verapdf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosObject;
import org.verapdf.model.impl.cos.GFCosArray;
import org.verapdf.model.impl.cos.GFCosStream;
import org.verapdf.model.impl.pd.signature.GFPDSignatureField;
import org.verapdf.model.pdlayer.PDAcroForm;
import org.verapdf.model.pdlayer.PDFormField;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.form.PDSignatureField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDAcroForm extends GFPDObject implements PDAcroForm {
    public static final String ACRO_FORM_TYPE = "PDAcroForm";

    public static final String FORM_FIELDS = "formFields";
    public static final String XFA = "XFA";

    public GFPDAcroForm(org.verapdf.pd.form.PDAcroForm acroForm, PDDocument document) {
        super(acroForm, ACRO_FORM_TYPE);
        this.document = document;
    }

    @Override
    public Boolean getNeedAppearances() {
        return ((org.verapdf.pd.form.PDAcroForm) simplePDObject).getNeedAppearances();
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case FORM_FIELDS:
                return this.getFormFields();
            case XFA:
                return this.getXFA();
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
            if (field instanceof PDSignatureField) {
                formFields.add(new GFPDSignatureField((PDSignatureField) field, document));
            } else {
                formFields.add(GFPDFormField.createTypedFormField(field));
            }
        }
        return Collections.unmodifiableList(formFields);
    }

    private List<CosObject> getXFA() {
        org.verapdf.pd.form.PDAcroForm form =
                (org.verapdf.pd.form.PDAcroForm) this.simplePDObject;
        COSObject value = form.getKey(ASAtom.XFA);
        if (value != null) {
            boolean isStream = value.getType() == COSObjType.COS_STREAM;
            if (isStream || value.getType() == COSObjType.COS_ARRAY) {
                ArrayList<CosObject> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                if (isStream) {
                    list.add(new GFCosStream((COSStream) value.getDirectBase()));
                } else {
                    list.add(new GFCosArray((COSArray) value.getDirectBase()));
                }
                return Collections.unmodifiableList(list);
            }
        }
        return Collections.emptyList();
    }
}
