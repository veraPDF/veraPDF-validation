package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEAside;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEAside extends GFSEGeneral implements SEAside {

    public static final String ASIDE_STRUCTURE_ELEMENT_TYPE = "SEAside";

    public GFSEAside(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.ASIDE, ASIDE_STRUCTURE_ELEMENT_TYPE);
    }
}
