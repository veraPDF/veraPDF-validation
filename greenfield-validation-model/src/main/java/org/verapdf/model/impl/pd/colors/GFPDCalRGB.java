package org.verapdf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDCalRGB;

/**
 * @author Maksim Bezrukov
 */
public class GFPDCalRGB extends GFPDColorSpace implements PDCalRGB {

    public static final String CAL_RGB_TYPE = "PDCalRGB";

    public GFPDCalRGB(
            org.verapdf.pd.colors.PDCalRGB simplePDObject) {
        super(simplePDObject, CAL_RGB_TYPE);
    }
}
