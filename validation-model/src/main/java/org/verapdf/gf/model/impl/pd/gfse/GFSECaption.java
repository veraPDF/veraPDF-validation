package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SECaption;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSECaption extends GFSEGeneral implements SECaption {

    public static final String CAPTION_STRUCTURE_ELEMENT_TYPE = "SECaption";

    public GFSECaption(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.CAPTION, CAPTION_STRUCTURE_ELEMENT_TYPE);
    }
}
