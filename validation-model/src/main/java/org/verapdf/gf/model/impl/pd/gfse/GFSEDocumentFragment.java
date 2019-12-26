package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEDocumentFragment;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEDocumentFragment extends GFSEGeneral implements SEDocumentFragment {

    public static final String DOCUMENT_FRAGMENT_STRUCTURE_ELEMENT_TYPE = "SEDocumentFragment";

    public GFSEDocumentFragment(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.DOCUMENT_FRAGMENT, DOCUMENT_FRAGMENT_STRUCTURE_ELEMENT_TYPE);
    }
}
