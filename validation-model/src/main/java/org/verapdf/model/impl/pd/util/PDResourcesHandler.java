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
		return getFont(name.getName());
	}

	public PDFont getFont(ASAtom name) {
		PDFont font = this.pageResources.getFont(name);
		font.setInherited(inheritedResources);
		return font;
	}

	public PDColorSpace getColorSpace(COSName name) {
		return getColorSpace(name.getName());
	}

	public PDColorSpace getColorSpace(ASAtom name) {
		//TODO : is default color space used
		PDColorSpace colorSpace = this.pageResources.getColorSpace(name);
		colorSpace.setInherited(inheritedResources);
		return colorSpace;
	}

	public PDColorSpace getPattern(COSName name) {
		return getPattern(name.getName());
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
		return getShading(name.getName());
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
		return getXObject(name.getName());
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
		return getExtGState(name.getName());
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
