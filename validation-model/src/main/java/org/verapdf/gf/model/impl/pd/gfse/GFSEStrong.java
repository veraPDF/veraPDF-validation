package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEStrong;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEStrong extends GFSEGeneral implements SEStrong {

    public static final String STRONG_STRUCTURE_ELEMENT_TYPE = "SEStrong";

    public GFSEStrong(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.STRONG, STRONG_STRUCTURE_ELEMENT_TYPE);
    }
}
