package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEDiv;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEDiv extends GFSEGeneral implements SEDiv {

    public static final String DIV_STRUCTURE_ELEMENT_TYPE = "SEDiv";

    public GFSEDiv(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.DIV, DIV_STRUCTURE_ELEMENT_TYPE);
    }
}
