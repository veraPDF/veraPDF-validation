/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.util;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSName;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.PDResource;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceCMYK;
import org.verapdf.pd.colors.PDDeviceGray;
import org.verapdf.pd.colors.PDDeviceRGB;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.images.PDXObject;
import org.verapdf.pd.patterns.PDPattern;
import org.verapdf.pd.patterns.PDShading;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class PDResourcesHandler {

	private static final Logger LOGGER = Logger.getLogger(PDResourcesHandler.class.getCanonicalName());

	public static final PDResourcesHandler EMPTY = PDResourcesHandler.getInstance(new PDResources(COSDictionary.construct()), false);

	private final PDResources pageResources;
	private final boolean inheritedResources;

	private final PDResources objectResources;

	private Set<ASAtom> undefinedResourceNames = new HashSet<>();
	private Set<ASAtom> inheritedResourceNames = new HashSet<>();

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
		}
		return null;
	}

	public PDFont getFont(ASAtom name) {
		PDFont font = null;
		if (this.objectResources != null) {
			font = this.objectResources.getFont(name);
			if (font == null && this.pageResources != null) {
				font = this.pageResources.getFont(name);
				setInherited(font, name, true);
			}
		} else if (this.pageResources != null) {
			font = this.pageResources.getFont(name);
			setInherited(font, name, inheritedResources);
		}
		if (font == null) {
			undefinedResourceNames.add(name);
			LOGGER.log(Level.SEVERE, "Undefined font " + name + " in a content stream");
		}
		return font;
	}

	public PDColorSpace getColorSpace(COSName name) {
		if (name != null) {
			return getColorSpace(name.getName());
		}
		return null;
	}

	public PDColorSpace getColorSpace(ASAtom name) {
		PDColorSpace colorSpace = null;
		if (this.objectResources != null) {
			if (isDefaultColorSpaceUsed(name)) {
				colorSpace = this.objectResources.getDefaultColorSpace(name);
			} else {
				colorSpace = this.objectResources.getColorSpace(name);
				if (colorSpace == null && this.pageResources != null) {
					colorSpace = this.pageResources.getColorSpace(name);
					colorSpace = setColorSpaceInherited(colorSpace, name, true);
				}
			}
		} else if (this.pageResources != null) {
			if (isDefaultColorSpaceUsed(name)) {
				colorSpace = this.pageResources.getDefaultColorSpace(name);
			} else {
				colorSpace = this.pageResources.getColorSpace(name);
				colorSpace = setColorSpaceInherited(colorSpace, name, inheritedResources);
			}
		}
		if (colorSpace == null) {
			undefinedResourceNames.add(name);
			LOGGER.log(Level.SEVERE, "Undefined color space " + name + " in a content stream");
		}
		return colorSpace;
	}

	public PDPattern getPattern(COSName name) {
		if (name != null) {
			return getPattern(name.getName());
		}
		return null;
	}

	public PDPattern getPattern(ASAtom name) {
		PDPattern pattern = null;
		if (this.objectResources != null) {
			pattern = this.objectResources.getPattern(name);
			if (pattern == null && this.pageResources != null) {
				pattern = this.pageResources.getPattern(name);
				setInherited(pattern, name, true);
			}
		} else if (this.pageResources != null){
			pattern = this.pageResources.getPattern(name);
			setInherited(pattern, name, inheritedResources);
		}
		if (pattern == null) {
			undefinedResourceNames.add(name);
			LOGGER.log(Level.SEVERE, "Undefined pattern " + name + " in a content stream");
		}
		return pattern;
	}

	public PDShading getShading(COSName name) {
		if (name != null) {
			return getShading(name.getName());
		}
		return null;
	}

	public PDShading getShading(ASAtom name) {
		PDShading shading = null;
		if (this.objectResources != null) {
			shading = this.objectResources.getShading(name);
			if (shading == null && this.pageResources != null) {
				shading = this.pageResources.getShading(name);
				setInherited(shading, name, true);
			}
		} else if (this.pageResources != null) {
			shading = this.pageResources.getShading(name);
			setInherited(shading, name, inheritedResources);
		}
		if (shading == null) {
			undefinedResourceNames.add(name);
			LOGGER.log(Level.SEVERE, "Undefined shading " + name + " in a content stream");
		}
		return shading;
	}

	public PDXObject getXObject(COSName name) {
		if (name != null) {
			return getXObject(name.getName());
		}
		return null;
	}

	public PDXObject getXObject(ASAtom name) {
		PDXObject xObject = null;
		if (this.objectResources != null) {
			xObject = this.objectResources.getXObject(name);
			if (xObject == null && this.pageResources != null) {
				xObject = this.pageResources.getXObject(name);
				setInherited(xObject, name, true);
			}
		} else if (this.pageResources != null) {
			xObject = this.pageResources.getXObject(name);
			setInherited(xObject, name, inheritedResources);
		}
		if (xObject == null) {
			undefinedResourceNames.add(name);
			LOGGER.log(Level.SEVERE, "Undefined XObject " + name + " in a content stream");
		}
		return xObject;
	}

	public PDExtGState getExtGState(COSName name) {
		if (name != null) {
			return getExtGState(name.getName());
		}
		return null;
	}

	public PDExtGState getExtGState(ASAtom name) {
		PDExtGState state = null;
		if (this.objectResources != null) {
			state = this.objectResources.getExtGState(name);
			if (state == null && this.pageResources != null) {
				state = this.pageResources.getExtGState(name);
				setInherited(state, name, true);
			}
		} else if (this.pageResources != null) {
			state = this.pageResources.getExtGState(name);
			setInherited(state, name, inheritedResources);
		}
		if (state == null) {
			undefinedResourceNames.add(name);
			LOGGER.log(Level.SEVERE, "Undefined graphics state " + name + " in a content stream");
		}
		return state;
	}

	public PDResource getProperties(COSName name) {
		if (name != null) {
			return getProperties(name.getName());
		}
		return null;
	}

	public PDResource getProperties(ASAtom name) {
		PDResource res = null;
		if (this.objectResources != null) {
			res = this.objectResources.getProperties(name);
			if (res == null && this.pageResources != null) {
				res = this.pageResources.getProperties(name);
				setInherited(res, name, true);
			}
		} else if (this.pageResources != null) {
			res = this.pageResources.getProperties(name);
			setInherited(res, name, inheritedResources);
		}
		if (res == null) {
			undefinedResourceNames.add(name);
			LOGGER.log(Level.SEVERE, "Undefined property " + name + " in a content stream");
		}
		return res;
	}

	public PDColorSpace setColorSpaceInherited(PDColorSpace colorSpace, ASAtom name, boolean isInherited) {
		if (isInherited) {
			if (colorSpace == PDDeviceCMYK.INSTANCE) {
				return PDDeviceCMYK.INHERITED_INSTANCE;
			} else if (colorSpace == PDDeviceRGB.INSTANCE) {
				return PDDeviceRGB.INHERITED_INSTANCE;
			} else if (colorSpace == PDDeviceGray.INSTANCE) {
				return PDDeviceGray.INHERITED_INSTANCE;
			}
		}
		setInherited(colorSpace, name, isInherited);
		return colorSpace;

	}

	public void setInherited(PDResource resource, ASAtom name, boolean value) {
		if (resource != null) {
			resource.setInherited(value);
			if (value) {
				inheritedResourceNames.add(name);
			}
		}
	}

	public PDResources getObjectResources() {
		return this.objectResources;
	}

	public PDResources getPageResources() {
		return this.pageResources;
	}

	private boolean isDefaultColorSpaceUsed(ASAtom name) {
		if (PDResourcesHandler.isDeviceDependent(name)) {
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

	private static boolean isDeviceDependent(ASAtom name) {
		return ASAtom.DEVICERGB.equals(name) ||
				ASAtom.DEVICEGRAY.equals(name) || ASAtom.DEVICECMYK.equals(name);
	}

	public Set<ASAtom> getUndefinedResourceNames() {
		return undefinedResourceNames;
	}

	public Set<ASAtom> getInheritedResourceNames() {
		return inheritedResourceNames;
	}
}
