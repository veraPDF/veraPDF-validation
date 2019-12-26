package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEPrivate;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEPrivate extends GFSEGeneral implements SEPrivate {

    public static final String PRIVATE_STRUCTURE_ELEMENT_TYPE = "SEPrivate";

    public GFSEPrivate(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.PRIVATE, PRIVATE_STRUCTURE_ELEMENT_TYPE);
    }
}
