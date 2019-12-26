package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETitle;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETitle extends GFSEGeneral implements SETitle {

    public static final String TITLE_STRUCTURE_ELEMENT_TYPE = "SETitle";

    public GFSETitle(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TITLE, TITLE_STRUCTURE_ELEMENT_TYPE);
    }
}
