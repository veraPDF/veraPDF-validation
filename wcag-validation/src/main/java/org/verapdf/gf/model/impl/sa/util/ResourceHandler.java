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
package org.verapdf.gf.model.impl.sa.util;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.pd.PDResource;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.images.PDXObject;

/**
 * @author Maxim Plushchov
 */
public class ResourceHandler {

	private final PDResources pageResources;
	private final PDResources objectResources;

	private ResourceHandler(PDResources pageResources) {
		this.pageResources = pageResources;
		this.objectResources = null;
	}

	private ResourceHandler(PDResources pageResources, PDResources objectResources) {
		this.pageResources = pageResources;
		this.objectResources = objectResources;
	}

	public static ResourceHandler getInstance(PDResources resources) {
		return new ResourceHandler(resources);
	}

	public static ResourceHandler getInstance(PDResources pageResources, PDResources objectResources) {
		return new ResourceHandler(pageResources, objectResources);
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
				}
			}
		} else if (this.pageResources != null) {
			if (isDefaultColorSpaceUsed(name)) {
				colorSpace = this.pageResources.getDefaultColorSpace(name);
			} else {
				colorSpace = this.pageResources.getColorSpace(name);
			}
		}
		return colorSpace;
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
			}
		} else if (this.pageResources != null) {
			font = this.pageResources.getFont(name);
		}
		return font;
	}

	public PDResource getProperties(ASAtom name) {
		PDResource res = null;
		if (this.objectResources != null) {
			res = this.objectResources.getProperties(name);
			if (res == null && this.pageResources != null) {
				res = this.pageResources.getProperties(name);
			}
		} else if (this.pageResources != null) {
			res = this.pageResources.getProperties(name);
		}
		return res;
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
			}
		} else if (this.pageResources != null) {
			xObject = this.pageResources.getXObject(name);
		}
		return xObject;
	}

	private boolean isDefaultColorSpaceUsed(ASAtom name) {
		if (ResourceHandler.isDeviceDependent(name)) {
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

}
