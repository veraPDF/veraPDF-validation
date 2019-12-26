package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEBlockQuote;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEBlockQuote extends GFSEGeneral implements SEBlockQuote {

    public static final String BLOCK_QUOTE_STRUCTURE_ELEMENT_TYPE = "SEBlockQuote";

    public GFSEBlockQuote(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.BLOCK_QUOTE, BLOCK_QUOTE_STRUCTURE_ELEMENT_TYPE);
    }
}
