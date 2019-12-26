package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SENonStruct;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSENonStruct extends GFSEGeneral implements SENonStruct {

    public static final String NON_STRUCT_STRUCTURE_ELEMENT_TYPE = "SENonStruct";

    public GFSENonStruct(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.NON_STRUCT, NON_STRUCT_STRUCTURE_ELEMENT_TYPE);
    }
}
