package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEH;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEH extends GFSEGeneral implements SEH {

    public static final String H_STRUCTURE_ELEMENT_TYPE = "SEH";

    public GFSEH(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.H, H_STRUCTURE_ELEMENT_TYPE);
    }
}
