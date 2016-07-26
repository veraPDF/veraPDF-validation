package org.verapdf.model.factory.colors;

import org.verapdf.model.impl.pd.colors.*;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.pd.colors.*;

/**
 * @author Maksim Bezrukov
 */
public class ColorSpaceFactory {

    public static final String CAL_GRAY = "CalGray";
    public static final String CAL_RGB = "CalRGB";
    public static final String DEVICE_CMYK = "DeviceCMYK";
    public static final String DEVICE_RGB = "DeviceRGB";
    public static final String DEVICE_GRAY = "DeviceGray";
    public static final String ICC_BASED = "ICCBased";
    public static final String LAB = "Lab";
    public static final String DEVICE_N = "DeviceN";
    public static final String SEPARATION = "Separation";
    public static final String INDEXED = "Indexed";

    private ColorSpaceFactory() {
        // disable default constructor
    }

    public static PDColorSpace getColorSpace(
            org.verapdf.pd.colors.PDColorSpace colorSpace) {
        return getColorSpace(colorSpace, 0, false);
    }

    public static PDColorSpace getColorSpace(
            org.verapdf.pd.colors.PDColorSpace colorSpace, int opm, boolean overprintingFlag) {
        if (colorSpace == null) {
            return null;
        }
//        TODO: will we do something similar? This code copied from pdfbox based implementation
//        if (StaticContainers.cachedColorSpaces.containsKey(colorSpace)) {
//            return StaticContainers.cachedColorSpaces.get(colorSpace);
//        }
        PDColorSpace result;
        switch (colorSpace.getType().toString()) {
            case CAL_GRAY:
                result = new GFPDCalGray((PDCalGray) colorSpace);
//                StaticContainers.cachedColorSpaces.put(colorSpace, result);
                return result;
            case CAL_RGB:
                result = new GFPDCalRGB((PDCalRGB) colorSpace);
//                StaticContainers.cachedColorSpaces.put(colorSpace, result);
                return result;
            case DEVICE_CMYK:
                return GFPDDeviceCMYK.getInstance();
            case DEVICE_RGB:
                return GFPDDeviceRGB.getInstance();
            case DEVICE_GRAY:
                return GFPDDeviceGray.getInstance();
            case ICC_BASED:
                if (colorSpace.getNumberOfComponents() != 4) {
                    result = new GFPDICCBased((PDICCBased) colorSpace);
//                    StaticContainers.cachedColorSpaces.put(colorSpace, result);
                    return result;
                } else {
                    result = new GFPDICCBasedCMYK((PDICCBased) colorSpace, opm, overprintingFlag);
//                    StaticContainers.cachedColorSpaces.put(colorSpace, result);
                    return result;
                }
            case LAB:
                result = new GFPDLab((PDLab) colorSpace);
//                StaticContainers.cachedColorSpaces.put(colorSpace, result);
                return result;
            case SEPARATION:
                result = new GFPDSeparation((PDSeparation) colorSpace);
//                StaticContainers.cachedColorSpaces.put(colorSpace, result);
                return result;
            case INDEXED:
                result = new GFPDIndexed((PDIndexed) colorSpace);
//                StaticContainers.cachedColorSpaces.put(colorSpace, result);
                return result;
            default:
                return null;
        }
    }
}
