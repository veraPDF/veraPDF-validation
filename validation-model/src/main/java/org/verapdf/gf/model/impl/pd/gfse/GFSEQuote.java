package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEQuote;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEQuote extends GFSEGeneral implements SEQuote {

    public static final String QUOTE_STRUCTURE_ELEMENT_TYPE = "SEQuote";

    public GFSEQuote(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.QUOTE, QUOTE_STRUCTURE_ELEMENT_TYPE);
    }
}
