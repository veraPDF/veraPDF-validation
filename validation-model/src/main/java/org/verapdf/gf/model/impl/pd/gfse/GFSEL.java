package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEL;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEL extends GFSEGeneral implements SEL {

    public static final String L_STRUCTURE_ELEMENT_TYPE = "SEL";

    public GFSEL(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.L, L_STRUCTURE_ELEMENT_TYPE);
    }
}
