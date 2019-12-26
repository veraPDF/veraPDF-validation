package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEWarichu;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEWarichu extends GFSEGeneral implements SEWarichu {

    public static final String WARICHU_STRUCTURE_ELEMENT_TYPE = "SEWarichu";

    public GFSEWarichu(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.WARICHU, WARICHU_STRUCTURE_ELEMENT_TYPE);
    }
}
