package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEPart;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEPart extends GFSEGeneral implements SEPart {

    public static final String PART_STRUCTURE_ELEMENT_TYPE = "SEPart";

    public GFSEPart(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.PART, PART_STRUCTURE_ELEMENT_TYPE);
    }
}
