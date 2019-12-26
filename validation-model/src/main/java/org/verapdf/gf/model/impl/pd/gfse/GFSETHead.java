package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETHead;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETHead extends GFSEGeneral implements SETHead {

    public static final String THEAD_STRUCTURE_ELEMENT_TYPE = "SETHead";

    public GFSETHead(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.THEAD, THEAD_STRUCTURE_ELEMENT_TYPE);
    }
}
