package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETable;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETable extends GFSEGeneral implements SETable {

    public static final String TABLE_STRUCTURE_ELEMENT_TYPE = "SETable";

    public GFSETable(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TABLE, TABLE_STRUCTURE_ELEMENT_TYPE);
    }
}
