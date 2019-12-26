package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEBibEntry;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEBibEntry extends GFSEGeneral implements SEBibEntry {

    public static final String BIB_ENTRY_STRUCTURE_ELEMENT_TYPE = "SEBibEntry";

    public GFSEBibEntry(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.BIB_ENTRY, BIB_ENTRY_STRUCTURE_ELEMENT_TYPE);
    }
}
