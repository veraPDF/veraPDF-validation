package org.verapdf.gf.model.factory.colors;

import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.colors.*;
import org.verapdf.gf.model.impl.pd.patterns.GFPDShadingPattern;
import org.verapdf.gf.model.impl.pd.patterns.GFPDTilingPattern;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.pd.colors.*;
import org.verapdf.pd.patterns.PDPattern;
import org.verapdf.pd.patterns.PDShadingPattern;
import org.verapdf.pd.patterns.PDTilingPattern;

/**
 * @author Maksim Bezrukov
 */
public class ColorSpaceFactory {

	public static final String CAL_GRAY = "/CalGray";
	public static final String CAL_RGB = "/CalRGB";
	public static final String DEVICE_CMYK = "/DeviceCMYK";
	public static final String DEVICE_RGB = "/DeviceRGB";
	public static final String DEVICE_GRAY = "/DeviceGray";
	public static final String ICC_BASED = "/ICCBased";
	public static final String LAB = "/Lab";
	public static final String DEVICE_N = "/DeviceN";
	public static final String SEPARATION = "/Separation";
	public static final String INDEXED = "/Indexed";
	public static final String PATTERN = "/Pattern";

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
		String uniqueID = getColorSpaceUniqueIdentifier(colorSpace, opm, overprintingFlag);
		if (StaticContainers.cachedColorSpaces.containsKey(uniqueID)) {
			return StaticContainers.cachedColorSpaces.get(uniqueID);
		}
		PDColorSpace result;
		switch (colorSpace.getType().toString()) {
			case CAL_GRAY:
				result = new GFPDCalGray((PDCalGray) colorSpace);
				break;
			case CAL_RGB:
				result = new GFPDCalRGB((PDCalRGB) colorSpace);
				break;
			case DEVICE_CMYK:
				return GFPDDeviceCMYK.getInstance();
			case DEVICE_RGB:
				return GFPDDeviceRGB.getInstance();
			case DEVICE_GRAY:
				return GFPDDeviceGray.getInstance();
			case ICC_BASED:
				result = colorSpace.getNumberOfComponents() != 4 ?
						new GFPDICCBased((PDICCBased) colorSpace)
						: new GFPDICCBasedCMYK((PDICCBased) colorSpace, opm, overprintingFlag);
				break;
			case LAB:
				result = new GFPDLab((PDLab) colorSpace);
				break;
			case SEPARATION:
				result = new GFPDSeparation((PDSeparation) colorSpace);
				break;
			case INDEXED:
				result = new GFPDIndexed((PDIndexed) colorSpace);
				break;
			case DEVICE_N:
				result = new GFPDDeviceN((PDDeviceN) colorSpace);
				break;
			case PATTERN:
				return getPattern((org.verapdf.pd.patterns.PDPattern) colorSpace, resourcesHandler);
			default:
				return null;
		}
		StaticContainers.cachedColorSpaces.put(uniqueID, result);
		return result;
	}

	private static org.verapdf.model.pdlayer.PDPattern getPattern(org.verapdf.pd.patterns.PDPattern pattern, PDResourcesHandler resourcesHandler) {
		switch (pattern.getPatternType()) {
			case PDPattern.TYPE_TILING_PATTERN:
				return new GFPDTilingPattern((PDTilingPattern) pattern, resourcesHandler.getExtendedResources(((PDTilingPattern) pattern).getResources()));
			case PDPattern.TYPE_SHADING_PATTERN:
				return new GFPDShadingPattern((PDShadingPattern) pattern);
			default:
				return null;
		}
	}

	private static String getColorSpaceUniqueIdentifier(org.verapdf.pd.colors.PDColorSpace base, int opm, boolean overprintFlag) {
		if (ICC_BASED.equals(base.getType().toString()) && base.getNumberOfComponents() == 4) {
			return String.valueOf(base.hashCode() + " " + opm + " " + overprintFlag);
		} else {
			return String.valueOf(base.hashCode());
		}
	}
}
