package org.verapdf.model.impl.pd.signature;

import org.verapdf.cos.COSObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.pd.GFPDFormField;
import org.verapdf.model.pdlayer.PDSignature;
import org.verapdf.model.pdlayer.PDSignatureField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Shemyakov
 */
public class GFPDSignatureField extends GFPDFormField implements PDSignatureField {

    /**
     * Type name for {@code PBoxPDSignatureField}
     */
    public static final String SIGNATURE_FIELD_TYPE = "PDSignatureField";

    public static final String SIGNATURE_DICTIONARY = "V";

    public GFPDSignatureField(org.verapdf.pd.form.PDSignatureField pdSignatureField) {
        super(pdSignatureField, SIGNATURE_FIELD_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case SIGNATURE_DICTIONARY:
                return getSignatureDictionary();
            default:
                return super.getLinkedObjects(link);
        }
    }

    /**
     * Here we suppose that signature can be present in signature dictionary
     * only indirectly. If it is not then we will get ClassCastException.
     */
    private List<PDSignature> getSignatureDictionary() {
        org.verapdf.pd.PDSignature signature =
                ((org.verapdf.pd.form.PDSignatureField) this.simplePDObject).getSignature();
        if (signature != null) {
            List<PDSignature> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            COSObject signatureReference = ((org.verapdf.pd.form.PDSignatureField)
                    this.simplePDObject).getSignatureReference();
            list.add(new GFPDSignature(signature, document, signatureReference));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }
}
