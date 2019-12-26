package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETH;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETH extends GFSEGeneral implements SETH {

    public static final String TH_STRUCTURE_ELEMENT_TYPE = "SETH";

    public GFSETH(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TH, TH_STRUCTURE_ELEMENT_TYPE);
    }
}
