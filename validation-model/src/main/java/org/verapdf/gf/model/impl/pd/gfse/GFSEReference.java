package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEReference;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEReference extends GFSEGeneral implements SEReference {

    public static final String REFERENCE_STRUCTURE_ELEMENT_TYPE = "SEReference";

    public GFSEReference(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.REFERENCE, REFERENCE_STRUCTURE_ELEMENT_TYPE);
    }
}
