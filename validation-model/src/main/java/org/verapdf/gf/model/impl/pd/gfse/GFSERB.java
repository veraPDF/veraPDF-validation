package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SERB;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSERB extends GFSEGeneral implements SERB {

    public static final String RB_STRUCTURE_ELEMENT_TYPE = "SERB";

    public GFSERB(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.RB, RB_STRUCTURE_ELEMENT_TYPE);
    }
}
