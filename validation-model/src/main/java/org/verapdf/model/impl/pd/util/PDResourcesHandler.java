package org.verapdf.model.impl.pd.util;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.PDResource;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.images.PDXObject;
import org.verapdf.pd.patterns.PDShading;

/**
 * @author Timur Kamalov
 */
public class PDResourcesHandler {

	private final PDResources pageResources;
	private final boolean inheritedResources;

	private final PDResources objectResources;

	private PDResourcesHandler(PDResources pageResources, boolean inheritedResources) {
		this.pageResources = pageResources;
		this.inheritedResources = inheritedResources;

		this.objectResources = null;
	}

	private PDResourcesHandler(PDResources pageResources, PDResources objectResources) {
		this.pageResources = pageResources;
		this.inheritedResources = false;

		this.objectResources = objectResources;
	}

	public static PDResourcesHandler getInstance(PDResources resources, boolean inheritedResources) {
		return new PDResourcesHandler(resources, inheritedResources);
	}

	public static PDResourcesHandler getInstance(PDResources pageResources, PDResources objectResources) {
		return new PDResourcesHandler(pageResources, objectResources);
	}

	//Used for XObjects
	public PDResourcesHandler getExtendedResources(PDResources objectResources) {
		return getInstance(this.pageResources, objectResources);
	}

	public PDFont getFont(COSName name) {
		if (name != null) {
			return getFont(name.getName());
		} else {
			return null;
		}
	}

	public PDFont getFont(ASAtom name) {
		PDFont font;
		if (this.objectResources != null) {
			font = this.objectResources.getFont(name);
			if (font == null) {
				font = this.pageResources.getFont(name);
				setInherited(font, true);
			}
		} else {
			font = this.pageResources.getFont(name);
			setInherited(font, inheritedResources);
		}
		return font;
	}

	public PDColorSpace getColorSpace(COSName name) {
		if (name != null) {
			return getColorSpace(name.getName());
		} else {
			return null;
		}
	}

	public PDColorSpace getColorSpace(ASAtom name) {
		PDColorSpace colorSpace;
		if (this.objectResources != null) {
			if (isDefaultColorSpaceUsed(name)) {
				return this.objectResources.getDefaultColorSpace(name);
			}
			colorSpace = this.objectResources.getColorSpace(name);
			if (colorSpace == null) {
				colorSpace = this.pageResources.getColorSpace(name);
				setInherited(colorSpace, true);
			}
		} else {
			if (isDefaultColorSpaceUsed(name)) {
				return this.pageResources.getDefaultColorSpace(name);
			}
			colorSpace = this.pageResources.getColorSpace(name);
			setInherited(colorSpace, inheritedResources);
		}
		return colorSpace;
	}

	public PDColorSpace getPattern(COSName name) {
		if (name != null) {
			return getPattern(name.getName());
		} else {
			return null;
		}
	}

	public PDColorSpace getPattern(ASAtom name) {
		PDColorSpace pattern;
		if (this.objectResources != null) {
			pattern = this.objectResources.getPattern(name);
			if (pattern == null) {
				pattern = this.pageResources.getPattern(name);
				setInherited(pattern, true);
			}
		} else {
			pattern = this.pageResources.getPattern(name);
			setInherited(pattern, inheritedResources);
		}
		return pattern;
	}

	public PDShading getShading(COSName name) {
		if (name != null) {
			return getShading(name.getName());
		} else {
			return null;
		}
	}

	public PDShading getShading(ASAtom name) {
		PDShading shading;
		if (this.objectResources != null) {
			shading = this.objectResources.getShading(name);
			if (shading == null) {
				shading = this.pageResources.getShading(name);
				setInherited(shading, true);
			}
		} else {
			shading = this.pageResources.getShading(name);
			setInherited(shading, inheritedResources);
		}
		return shading;
	}

	public PDXObject getXObject(COSName name) {
		if (name != null) {
			return getXObject(name.getName());
		} else {
			return null;
		}
	}

	public PDXObject getXObject(ASAtom name) {
		PDXObject xObject;
		if (this.objectResources != null) {
			xObject = this.objectResources.getXObject(name);
			if (xObject == null) {
				xObject = this.pageResources.getXObject(name);
				setInherited(xObject, true);
			}
		} else {
			xObject = this.pageResources.getXObject(name);
			setInherited(xObject, inheritedResources);
		}
		return xObject;
	}

	public PDExtGState getExtGState(COSName name) {
		if (name != null) {
			return getExtGState(name.getName());
		} else {
			return null;
		}
	}

	public PDExtGState getExtGState(ASAtom name) {
		PDExtGState state;
		if (this.objectResources != null) {
			state = this.objectResources.getExtGState(name);
			if (state == null) {
				state = this.pageResources.getExtGState(name);
				setInherited(state, true);
			}
		} else {
			state = this.pageResources.getExtGState(name);
			setInherited(state, inheritedResources);
		}
		return state;
	}

	public void setInherited(PDResource resource, boolean value) {
		if (resource != null) {
			resource.setInherited(value);
		}
	}

	public PDResources getObjectResources() {
		return this.objectResources;
	}

	public PDResources getPageResources() {
		return this.pageResources;
	}

	private boolean isDefaultColorSpaceUsed(ASAtom name) {
		if (this.isDeviceDependent(name)) {
			if (objectResources != null) {
				ASAtom value = org.verapdf.factory.colors.ColorSpaceFactory.getDefaultValue(objectResources, name);
				if (value != null) {
					return true;
				}
			} else {
				ASAtom value = org.verapdf.factory.colors.ColorSpaceFactory.getDefaultValue(pageResources, name);
				if (value != null) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isDeviceDependent(ASAtom name) {
		return ASAtom.DEVICERGB.equals(name) ||
				ASAtom.DEVICEGRAY.equals(name) || ASAtom.DEVICECMYK.equals(name);
	}

}
