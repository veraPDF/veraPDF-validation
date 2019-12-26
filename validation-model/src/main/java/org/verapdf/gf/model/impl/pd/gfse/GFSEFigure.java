package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEFigure;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEFigure extends GFSEGeneral implements SEFigure {

    public static final String FIGURE_STRUCTURE_ELEMENT_TYPE = "SEFigure";

    public GFSEFigure(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.FIGURE, FIGURE_STRUCTURE_ELEMENT_TYPE);
    }
}
