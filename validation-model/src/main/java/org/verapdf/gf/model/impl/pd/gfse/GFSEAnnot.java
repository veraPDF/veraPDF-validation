package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEAnnot;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEAnnot extends GFSEGeneral implements SEAnnot {

    public static final String ANNOT_STRUCTURE_ELEMENT_TYPE = "SEAnnot";

    public GFSEAnnot(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.ANNOT, ANNOT_STRUCTURE_ELEMENT_TYPE);
    }
}
