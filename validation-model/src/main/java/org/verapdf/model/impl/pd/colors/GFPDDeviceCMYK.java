package org.verapdf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDDeviceCMYK;

/**
 * @author Maksim Bezrukov
 */
public class GFPDDeviceCMYK extends GFPDColorSpace implements PDDeviceCMYK {

    private static final PDDeviceCMYK INSTANCE = new GFPDDeviceCMYK(
            org.verapdf.pd.colors.PDDeviceCMYK.INSTANCE);

    public static final String DEVICE_CMYK_TYPE = "PDDeviceCMYK";

    private GFPDDeviceCMYK(
            org.verapdf.pd.colors.PDDeviceCMYK simplePDObject) {
        super(simplePDObject, DEVICE_CMYK_TYPE);
    }

    public static PDDeviceCMYK getInstance() {
        return INSTANCE;
    }
}
