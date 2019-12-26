package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETFoot;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETFoot extends GFSEGeneral implements SETFoot {

    public static final String TFOOT_STRUCTURE_ELEMENT_TYPE = "SETFoot";

    public GFSETFoot(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TFOOT, TFOOT_STRUCTURE_ELEMENT_TYPE);
    }
}
