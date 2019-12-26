package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEEm;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEEm extends GFSEGeneral implements SEEm {

    public static final String EM_STRUCTURE_ELEMENT_TYPE = "SEEm";

    public GFSEEm(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.EM, EM_STRUCTURE_ELEMENT_TYPE);
    }
}
