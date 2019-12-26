package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEFENote;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEFENote extends GFSEGeneral implements SEFENote {

    public static final String FE_NOTE_STRUCTURE_ELEMENT_TYPE = "SEFENote";

    public GFSEFENote(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.FENOTE, FE_NOTE_STRUCTURE_ELEMENT_TYPE);
    }
}
