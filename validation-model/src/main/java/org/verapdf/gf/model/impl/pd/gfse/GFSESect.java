package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SESect;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSESect extends GFSEGeneral implements SESect {

    public static final String SECT_STRUCTURE_ELEMENT_TYPE = "SESect";

    public GFSESect(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.SECT, SECT_STRUCTURE_ELEMENT_TYPE);
    }
}
