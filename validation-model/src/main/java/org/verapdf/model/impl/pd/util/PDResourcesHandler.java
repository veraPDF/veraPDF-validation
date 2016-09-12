package org.verapdf.model.impl.pd.util;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.pd.PDExtGState;
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
		PDFont font = this.pageResources.getFont(name);
		if (font != null) {
			font.setInherited(inheritedResources);
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
		//TODO : is default color space used
		PDColorSpace colorSpace = this.pageResources.getColorSpace(name);
		if (colorSpace != null) {
			colorSpace.setInherited(inheritedResources);
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
		PDColorSpace pattern = this.pageResources.getPattern(name);
		if (pattern != null) {
			pattern.setInherited(inheritedResources);
			return pattern;
		}
		return null;
	}

	public PDShading getShading(COSName name) {
		if (name != null) {
			return getShading(name.getName());
		} else {
			return null;
		}
	}

	public PDShading getShading(ASAtom name) {
		PDShading shading = this.pageResources.getShading(name);
		if (shading != null) {
			shading.setInherited(inheritedResources);
			return shading;
		}
		return null;
	}

	public PDXObject getXObject(COSName name) {
		if (name != null) {
			return getXObject(name.getName());
		} else {
			return null;
		}
	}

	public PDXObject getXObject(ASAtom name) {
		PDXObject xObject = this.pageResources.getXObject(name);
		if (xObject != null) {
			xObject.setInherited(inheritedResources);
			return xObject;
		}
		return null;
	}

	public PDExtGState getExtGState(COSName name) {
		if (name != null) {
			return getExtGState(name.getName());
		} else {
			return null;
		}
	}

	public PDExtGState getExtGState(ASAtom name) {
		PDExtGState state = this.pageResources.getExtGState(name);
		if (state != null) {
			state.setInherited(inheritedResources);
			return state;
		}
		return null;
	}

}
