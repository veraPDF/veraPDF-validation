package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SERuby;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSERuby extends GFSEGeneral implements SERuby {

    public static final String RUBY_STRUCTURE_ELEMENT_TYPE = "SERuby";

    public GFSERuby(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.RUBY, RUBY_STRUCTURE_ELEMENT_TYPE);
    }
}
