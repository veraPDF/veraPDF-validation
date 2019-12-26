package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SECode;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSECode extends GFSEGeneral implements SECode {

    public static final String CODE_STRUCTURE_ELEMENT_TYPE = "SECode";

    public GFSECode(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.CODE, CODE_STRUCTURE_ELEMENT_TYPE);
    }
}
