package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SELI;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSELI extends GFSEGeneral implements SELI {

    public static final String LI_STRUCTURE_ELEMENT_TYPE = "SELI";

    public GFSELI(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.LI, LI_STRUCTURE_ELEMENT_TYPE);
    }
}
