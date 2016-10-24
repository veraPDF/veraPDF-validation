package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDDeviceRGB;

/**
 * @author Maksim Bezrukov
 */
public class GFPDDeviceRGB extends GFPDColorSpace implements PDDeviceRGB {
    private static final PDDeviceRGB INSTANCE = new GFPDDeviceRGB(
            org.verapdf.pd.colors.PDDeviceRGB.INSTANCE);
    private static final PDDeviceRGB INHERITED_INSTANCE = new GFPDDeviceRGB(
            org.verapdf.pd.colors.PDDeviceRGB.INHERITED_INSTANCE);

    public static final String DEVICE_RGB_TYPE = "PDDeviceRGB";

    private GFPDDeviceRGB(
            org.verapdf.pd.colors.PDDeviceRGB simplePDObject) {
        super(simplePDObject, DEVICE_RGB_TYPE);
    }

    public static PDDeviceRGB getInstance() {
        return INSTANCE;
    }

    public static PDDeviceRGB getInheritedInstance() {
        return INHERITED_INSTANCE;
    }
}
