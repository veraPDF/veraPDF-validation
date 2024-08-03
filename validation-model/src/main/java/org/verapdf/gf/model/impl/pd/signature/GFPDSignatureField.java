/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.pd.signature;

import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.GFPDFormField;
import org.verapdf.model.baselayer.Object;
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
     * Type name for {@code GFPDSignatureField}
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
            list.add(new GFPDSignature(signature, signatureReference));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }
}
