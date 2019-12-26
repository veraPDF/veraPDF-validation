package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SERT;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSERT extends GFSEGeneral implements SERT {

    public static final String RT_STRUCTURE_ELEMENT_TYPE = "SERT";

    public GFSERT(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.RT, RT_STRUCTURE_ELEMENT_TYPE);
    }
}
