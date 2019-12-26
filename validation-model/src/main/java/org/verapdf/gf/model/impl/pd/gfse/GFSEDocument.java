package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEDocument;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEDocument extends GFSEGeneral implements SEDocument {

    public static final String DOCUMENT_STRUCTURE_ELEMENT_TYPE = "SEDocument";

    public GFSEDocument(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.DOCUMENT, DOCUMENT_STRUCTURE_ELEMENT_TYPE);
    }
}
