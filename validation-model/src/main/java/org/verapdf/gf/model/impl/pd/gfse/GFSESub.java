package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SESub;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSESub extends GFSEGeneral implements SESub {

    public static final String SUB_STRUCTURE_ELEMENT_TYPE = "SESub";

    public GFSESub(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.SUB, SUB_STRUCTURE_ELEMENT_TYPE);
    }
}
