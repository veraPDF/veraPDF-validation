package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEHn;
import org.verapdf.pd.structure.PDStructElem;

public class GFSEHn extends GFSEGeneral implements SEHn {

    public static final String HN_STRUCTURE_ELEMENT_TYPE = "SEHn";

    public GFSEHn(PDStructElem structElemDictionary, String standardType) {
        super(structElemDictionary, standardType, HN_STRUCTURE_ELEMENT_TYPE);
    }
}
