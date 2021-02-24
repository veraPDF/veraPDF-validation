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
import org.verapdf.pd.font.PDFont;

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

}
