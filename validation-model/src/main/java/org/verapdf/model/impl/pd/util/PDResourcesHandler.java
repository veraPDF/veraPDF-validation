package org.verapdf.model.impl.pd.util;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.colors.PDColorSpace;

/**
 * @author Timur Kamalov
 */
public class PDResourcesHandler {

	private final PDResources resources;
	private final boolean inheritedResources;

	private PDResourcesHandler(PDResources resources, boolean inheritedResources) {
		this.resources = resources;
		this.inheritedResources = inheritedResources;
	}

	public static PDResourcesHandler getInstance(PDResources pageResources) {
		return getInstance(null, pageResources);
	}

	public static PDResourcesHandler getInstance(PDResources resources, boolean inheritedResources) {
		return new PDResourcesHandler(resources, inheritedResources);
	}

	public static PDResourcesHandler getInstance(PDResources inheritedResources, PDResources currentResources) {
		boolean isInheritedResources = inheritedResources != null && currentResources == null;
		if (isInheritedResources) {
			return new PDResourcesHandler(inheritedResources, true);
		} else {
			return new PDResourcesHandler(currentResources, false);
		}
	}

	//Used for XObjects
	public PDResourcesHandler getExtendedResources(PDResources objectResources) {
		return getInstance(this.resources, objectResources);
	}

	public PDColorSpace getColorSpace(COSName name) {
		return getColorSpace(name.getName());
	}

	public PDColorSpace getColorSpace(ASAtom name) {
		//TODO : is default color space used
		PDColorSpace colorSpace = this.resources.getColorSpace(name);
		colorSpace.setInherited(inheritedResources);
		return colorSpace;
	}

	public PDColorSpace getPattern(COSName name) {
		return getPattern(name.getName());
	}

	public PDColorSpace getPattern(ASAtom name) {
		PDColorSpace pattern = this.resources.getPattern(name);
		if (pattern != null) {
			pattern.setInherited(inheritedResources);
			return pattern;
		}
		return null;
	}

	public PDExtGState getExtGState(COSName name) {
		PDExtGState state = this.resources.getExtGState(name.getName());
		if (state != null) {
			state.setInherited(inheritedResources);
			return state;
		}
		return null;
	}

}
