package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEArt;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEArt extends GFSEGeneral implements SEArt {

    public static final String ART_STRUCTURE_ELEMENT_TYPE = "SEArt";

    public GFSEArt(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.ART, ART_STRUCTURE_ELEMENT_TYPE);
    }
}
