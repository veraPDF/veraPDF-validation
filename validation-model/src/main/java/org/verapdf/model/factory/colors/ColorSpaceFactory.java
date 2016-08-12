package org.verapdf.model.factory.colors;

import org.verapdf.model.impl.containers.StaticContainers;
import org.verapdf.model.impl.pd.colors.*;
import org.verapdf.model.impl.pd.patterns.GFPDShadingPattern;
import org.verapdf.model.impl.pd.patterns.GFPDTilingPattern;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.pd.colors.*;
import org.verapdf.pd.patterns.PDPattern;
import org.verapdf.pd.patterns.PDShadingPattern;
import org.verapdf.pd.patterns.PDTilingPattern;

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
	public static final String PATTERN = "Pattern";

	private ColorSpaceFactory() {
		// disable default constructor
	}

	public static PDColorSpace getColorSpace(
			org.verapdf.pd.colors.PDColorSpace colorSpace) {
		return getColorSpace(colorSpace, null, 0, false);
	}

	public static PDColorSpace getColorSpace(
			org.verapdf.pd.colors.PDColorSpace colorSpace, PDResourcesHandler resourcesHandler) {
		return getColorSpace(colorSpace, resourcesHandler, 0, false);
	}

	public static PDColorSpace getColorSpace(
			org.verapdf.pd.colors.PDColorSpace colorSpace, PDResourcesHandler resourcesHandler, int opm, boolean overprintingFlag) {
		if (colorSpace == null) {
			return null;
		}
        if (StaticContainers.cachedColorSpaces.containsKey(colorSpace)) {
            return StaticContainers.cachedColorSpaces.get(colorSpace);
        }
		PDColorSpace result;
		switch (colorSpace.getType().toString()) {
			case CAL_GRAY:
				result = new GFPDCalGray((PDCalGray) colorSpace);
                StaticContainers.cachedColorSpaces.put(colorSpace, result);
				return result;
			case CAL_RGB:
				result = new GFPDCalRGB((PDCalRGB) colorSpace);
                StaticContainers.cachedColorSpaces.put(colorSpace, result);
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
                    StaticContainers.cachedColorSpaces.put(colorSpace, result);
					return result;
				} else {
					result = new GFPDICCBasedCMYK((PDICCBased) colorSpace, opm, overprintingFlag);
                    StaticContainers.cachedColorSpaces.put(colorSpace, result);
					return result;
				}
			case LAB:
				result = new GFPDLab((PDLab) colorSpace);
                StaticContainers.cachedColorSpaces.put(colorSpace, result);
				return result;
			case SEPARATION:
				result = new GFPDSeparation((PDSeparation) colorSpace);
                StaticContainers.cachedColorSpaces.put(colorSpace, result);
				return result;
			case INDEXED:
				result = new GFPDIndexed((PDIndexed) colorSpace);
                StaticContainers.cachedColorSpaces.put(colorSpace, result);
				return result;
			case DEVICE_N:
				result = new GFPDDeviceN((PDDeviceN) colorSpace);
                StaticContainers.cachedColorSpaces.put(colorSpace, result);
				return result;
			case PATTERN:
				return getPattern((org.verapdf.pd.patterns.PDPattern) colorSpace, resourcesHandler);
			default:
				return null;
		}
	}

	private static org.verapdf.model.pdlayer.PDPattern getPattern(org.verapdf.pd.patterns.PDPattern pattern, PDResourcesHandler resourcesHandler) {
		switch (pattern.getPatternType()) {
			case PDPattern.TYPE_TILING_PATTERN:
				return new GFPDTilingPattern((PDTilingPattern) pattern, resourcesHandler);
			case PDPattern.TYPE_SHADING_PATTERN:
				return new GFPDShadingPattern((PDShadingPattern) pattern);
			default:
				return null;
		}
	}
}
