package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.pdlayer.TransparencyColorSpace;
import org.verapdf.pd.colors.PDColorSpace;

/**
 * @author Maxim Plushchov
 */
public class GFTransparencyColorSpace extends GenericModelObject implements TransparencyColorSpace {

	protected PDColorSpace colorSpace;

	public static final String TRANSPARENCY_COLOR_SPACE_TYPE = "TransparencyColorSpace";

	public GFTransparencyColorSpace(PDColorSpace colorSpace, String type) {
		super(type);
		this.colorSpace = colorSpace;
	}

	public GFTransparencyColorSpace(PDColorSpace colorSpace) {
		this(colorSpace, TRANSPARENCY_COLOR_SPACE_TYPE);
	}

	@Override
	public String getcolorSpaceType() {
		StaticContainers.setCurrentTransparencyColorSpace(colorSpace);
		if (colorSpace == null) {
			return null;
		}
		if (ASAtom.ICCBASED.equals(colorSpace.getType())) {
			return ((org.verapdf.pd.colors.PDICCBased)colorSpace).getColorSpaceType();
		}
		return colorSpace.getType().getValue();
	}
}
