package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEP;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEP extends GFSEGeneral implements SEP {

    public static final String P_STRUCTURE_ELEMENT_TYPE = "SEP";

    public GFSEP(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.P, P_STRUCTURE_ELEMENT_TYPE);
    }
}
