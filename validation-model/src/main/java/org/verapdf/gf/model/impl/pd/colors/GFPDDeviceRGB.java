package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDDeviceRGB;

/**
 * @author Maksim Bezrukov
 */
public class GFPDDeviceRGB extends GFPDColorSpace implements PDDeviceRGB {
    private static final PDDeviceRGB INSTANCE = new GFPDDeviceRGB(
            org.verapdf.pd.colors.PDDeviceRGB.INSTANCE);

    public static final String DEVICE_RGB_TYPE = "PDDeviceRGB";

    private GFPDDeviceRGB(
            org.verapdf.pd.colors.PDDeviceRGB simplePDObject) {
        super(simplePDObject, DEVICE_RGB_TYPE);
    }

    public static PDDeviceRGB getInstance() {
        return INSTANCE;
    }
}
