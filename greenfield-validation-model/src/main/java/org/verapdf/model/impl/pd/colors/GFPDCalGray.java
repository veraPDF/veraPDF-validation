package org.verapdf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDCalGray;

/**
 * @author Maksim Bezrukov
 */
public class GFPDCalGray extends GFPDColorSpace implements PDCalGray {

    public static final String CAL_GRAY_TYPE = "PDCalGray";

    public GFPDCalGray(
            org.verapdf.pd.colors.PDCalGray simplePDObject) {
        super(simplePDObject, CAL_GRAY_TYPE);
    }
}
