package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SELbl;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSELbl extends GFSEGeneral implements SELbl {

    public static final String LBL_STRUCTURE_ELEMENT_TYPE = "SELbl";

    public GFSELbl(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.LBL, LBL_STRUCTURE_ELEMENT_TYPE);
    }
}
