package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SELBody;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSELBody extends GFSEGeneral implements SELBody {

    public static final String LBODY_STRUCTURE_ELEMENT_TYPE = "SELBody";

    public GFSELBody(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.LBODY, LBODY_STRUCTURE_ELEMENT_TYPE);
    }
}
