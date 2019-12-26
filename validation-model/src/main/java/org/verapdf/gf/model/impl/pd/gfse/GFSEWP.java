package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEWP;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEWP extends GFSEGeneral implements SEWP {

    public static final String WP_STRUCTURE_ELEMENT_TYPE = "SEWP";

    public GFSEWP(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.WP, WP_STRUCTURE_ELEMENT_TYPE);
    }
}
