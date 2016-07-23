package org.verapdf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDLab;

/**
 * @author Maksim Bezrukov
 */
public class GFPDLab extends GFPDColorSpace implements PDLab {

    public static final String LAB_COLOR_SPACE_TYPE = "PDLab";

    public GFPDLab(
            org.verapdf.pd.colors.PDLab simplePDObject) {
        super(simplePDObject, LAB_COLOR_SPACE_TYPE);
    }
}
