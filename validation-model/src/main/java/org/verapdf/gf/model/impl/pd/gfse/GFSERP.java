package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SERP;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSERP extends GFSEGeneral implements SERP {

    public static final String RP_STRUCTURE_ELEMENT_TYPE = "SERP";

    public GFSERP(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.RP, RP_STRUCTURE_ELEMENT_TYPE);
    }
}
