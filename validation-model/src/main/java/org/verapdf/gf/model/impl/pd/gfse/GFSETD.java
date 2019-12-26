package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETD;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETD extends GFSEGeneral implements SETD {

    public static final String TD_STRUCTURE_ELEMENT_TYPE = "SETD";

    public GFSETD(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TD, TD_STRUCTURE_ELEMENT_TYPE);
    }
}
