package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SENote;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSENote extends GFSEGeneral implements SENote {

    public static final String NOTE_STRUCTURE_ELEMENT_TYPE = "SENote";

    public GFSENote(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.NOTE, NOTE_STRUCTURE_ELEMENT_TYPE);
    }
}
