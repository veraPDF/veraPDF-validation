package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEFormula;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEFormula extends GFSEGeneral implements SEFormula {

    public static final String FORMULA_STRUCTURE_ELEMENT_TYPE = "SEFormula";

    public GFSEFormula(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.FORMULA, FORMULA_STRUCTURE_ELEMENT_TYPE);
    }
}
