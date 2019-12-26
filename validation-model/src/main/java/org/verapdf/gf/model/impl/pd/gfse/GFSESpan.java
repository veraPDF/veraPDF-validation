package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SESpan;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSESpan extends GFSEGeneral implements SESpan {

    public static final String SPAN_STRUCTURE_ELEMENT_TYPE = "SESpan";

    public GFSESpan(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.SPAN, SPAN_STRUCTURE_ELEMENT_TYPE);
    }
}
