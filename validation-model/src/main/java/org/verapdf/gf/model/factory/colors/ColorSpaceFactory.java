/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.factory.colors;

import org.verapdf.gf.model.factory.operators.GraphicState;
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

import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class ColorSpaceFactory {

	private static final Logger LOGGER = Logger.getLogger(ColorSpaceFactory.class.getCanonicalName());

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

	public static PDColorSpace getColorSpace(org.verapdf.pd.colors.PDColorSpace colorSpace) {
		return getColorSpace(colorSpace, PDResourcesHandler.EMPTY, 0, false, null);
	}

	public static PDColorSpace getColorSpace(org.verapdf.pd.colors.PDColorSpace colorSpace,
											 PDResourcesHandler resourcesHandler, GraphicState inheritedGraphicSpace) {
		return getColorSpace(colorSpace, resourcesHandler, 0, false, inheritedGraphicSpace);
	}

	public static PDColorSpace getColorSpace(org.verapdf.pd.colors.PDColorSpace colorSpace,
			PDResourcesHandler resourcesHandler, int opm, boolean overprintingFlag,
											 GraphicState inheritedGraphicSpace) {
		if (colorSpace == null) {
			LOGGER.warning("Invalid ColorSpace object");
			return new GFPDEmptyColorSpace();
		}
		String uniqueID = getColorSpaceUniqueIdentifier(colorSpace, opm, overprintingFlag);
		if (StaticContainers.getCachedColorSpaces().containsKey(uniqueID)) {
			return StaticContainers.getCachedColorSpaces().get(uniqueID);
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
			if (colorSpace.isInherited()) {
				return GFPDDeviceCMYK.getInheritedInstance();
			}
			return GFPDDeviceCMYK.getInstance();
		case DEVICE_RGB:
			if (colorSpace.isInherited()) {
				return GFPDDeviceRGB.getInheritedInstance();
			}
			return GFPDDeviceRGB.getInstance();
		case DEVICE_GRAY:
			if (colorSpace.isInherited()) {
				return GFPDDeviceGray.getInheritedInstance();
			}
			return GFPDDeviceGray.getInstance();
		case ICC_BASED:
			result = colorSpace.getNumberOfComponents() != 4 ? new GFPDICCBased((PDICCBased) colorSpace)
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
			return getPattern((org.verapdf.pd.patterns.PDPattern) colorSpace,
					resourcesHandler, inheritedGraphicSpace);
		default:
			return null;
		}
		StaticContainers.getCachedColorSpaces().put(uniqueID, result);
		return result;
	}

	private static org.verapdf.model.pdlayer.PDPattern getPattern(org.verapdf.pd.patterns.PDPattern pattern,
			PDResourcesHandler resourcesHandler, GraphicState inheritedGraphicState) {
		switch (pattern.getPatternType()) {
		case PDPattern.TYPE_TILING_PATTERN:
			return new GFPDTilingPattern((PDTilingPattern) pattern,
					resourcesHandler.getExtendedResources(((PDTilingPattern) pattern).getResources()),
					inheritedGraphicState);
		case PDPattern.TYPE_SHADING_PATTERN:
			return new GFPDShadingPattern((PDShadingPattern) pattern);
		default:
			return null;
		}
	}

	private static String getColorSpaceUniqueIdentifier(org.verapdf.pd.colors.PDColorSpace base, int opm,
			boolean overprintFlag) {
		if (ICC_BASED.equals(base.getType().toString()) && base.getNumberOfComponents() == 4) {
			return String.valueOf(base.hashCode() + " " + opm + " " + overprintFlag);
		}
		return String.valueOf(base.hashCode());
	}
}
