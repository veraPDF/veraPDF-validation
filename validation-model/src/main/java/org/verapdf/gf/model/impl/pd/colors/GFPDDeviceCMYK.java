package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDDeviceCMYK;

/**
 * @author Maksim Bezrukov
 */
public class GFPDDeviceCMYK extends GFPDColorSpace implements PDDeviceCMYK {

    private static final PDDeviceCMYK INSTANCE = new GFPDDeviceCMYK(
            org.verapdf.pd.colors.PDDeviceCMYK.INSTANCE);
    private static final PDDeviceCMYK INHERITED_INSTANCE = new GFPDDeviceCMYK(
            org.verapdf.pd.colors.PDDeviceCMYK.INHERITED_INSTANCE);

    public static final String DEVICE_CMYK_TYPE = "PDDeviceCMYK";

    private GFPDDeviceCMYK(
            org.verapdf.pd.colors.PDDeviceCMYK simplePDObject) {
        super(simplePDObject, DEVICE_CMYK_TYPE);
    }

    public static PDDeviceCMYK getInstance() {
        return INSTANCE;
    }

    public static PDDeviceCMYK getInheritedInstance() {
        return INHERITED_INSTANCE;
    }
}
