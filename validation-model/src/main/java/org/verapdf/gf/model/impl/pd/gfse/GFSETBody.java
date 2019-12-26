package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETBody;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETBody extends GFSEGeneral implements SETBody {

    public static final String TBODY_STRUCTURE_ELEMENT_TYPE = "SETBody";

    public GFSETBody(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TBODY, TBODY_STRUCTURE_ELEMENT_TYPE);
    }
}
