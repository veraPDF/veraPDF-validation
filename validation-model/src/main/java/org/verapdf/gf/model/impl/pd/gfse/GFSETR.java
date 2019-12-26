package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETR;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETR extends GFSEGeneral implements SETR {

    public static final String TR_STRUCTURE_ELEMENT_TYPE = "SETR";

    public GFSETR(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TR, TR_STRUCTURE_ELEMENT_TYPE);
    }
}
