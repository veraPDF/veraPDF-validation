package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SENonStandard;
import org.verapdf.pd.structure.PDStructElem;

public class GFSENonStandard extends GFSEGeneral implements SENonStandard {

    public static final String NON_STANDARD_STRUCTURE_ELEMENT_TYPE = "SENonStandard";

    public GFSENonStandard(PDStructElem structElemDictionary, String standardType) {
        super(structElemDictionary, standardType, NON_STANDARD_STRUCTURE_ELEMENT_TYPE);
    }
}
