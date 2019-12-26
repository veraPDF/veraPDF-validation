package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SELink;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSELink extends GFSEGeneral implements SELink {

    public static final String LINK_STRUCTURE_ELEMENT_TYPE = "SELink";

    public GFSELink(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.LINK, LINK_STRUCTURE_ELEMENT_TYPE);
    }
}
