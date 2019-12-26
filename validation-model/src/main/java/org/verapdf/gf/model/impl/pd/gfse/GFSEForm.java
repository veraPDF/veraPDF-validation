package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEForm;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEForm extends GFSEGeneral implements SEForm {

    public static final String FORM_STRUCTURE_ELEMENT_TYPE = "SEForm";

    public GFSEForm(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.FORM, FORM_STRUCTURE_ELEMENT_TYPE);
    }
}
