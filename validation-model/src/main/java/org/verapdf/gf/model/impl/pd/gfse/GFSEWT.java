package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEWT;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEWT extends GFSEGeneral implements SEWT {

    public static final String WT_STRUCTURE_ELEMENT_TYPE = "SEWT";

    public GFSEWT(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.WT, WT_STRUCTURE_ELEMENT_TYPE);
    }
}
