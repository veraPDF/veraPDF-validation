package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETOC;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETOC extends GFSEGeneral implements SETOC {

    public static final String TOC_STRUCTURE_ELEMENT_TYPE = "SETOC";

    public GFSETOC(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TOC, TOC_STRUCTURE_ELEMENT_TYPE);
    }
}
