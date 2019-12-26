package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETOCI;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETOCI extends GFSEGeneral implements SETOCI {

    public static final String TOCI_STRUCTURE_ELEMENT_TYPE = "SETOCI";

    public GFSETOCI(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TOCI, TOCI_STRUCTURE_ELEMENT_TYPE);
    }
}
