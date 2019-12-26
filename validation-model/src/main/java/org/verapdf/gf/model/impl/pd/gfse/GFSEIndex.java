package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEIndex;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEIndex extends GFSEGeneral implements SEIndex {

    public static final String INDEX_STRUCTURE_ELEMENT_TYPE = "SEIndex";

    public GFSEIndex(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.INDEX, INDEX_STRUCTURE_ELEMENT_TYPE);
    }
}
