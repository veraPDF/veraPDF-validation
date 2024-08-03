/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.pd.images;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.pd.GFPDResource;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.pdlayer.PDXObject;
import org.verapdf.pd.images.PDXForm;
import org.verapdf.pd.images.PDXImage;

import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDXObject extends GFPDResource implements PDXObject {

	public static final String X_OBJECT_TYPE = "PDXObject";

	public static final String OPI = "OPI";

	protected final PDResourcesHandler resourcesHandler;

	public GFPDXObject(org.verapdf.pd.images.PDXObject simplePDObject, PDResourcesHandler resourcesHandler) {
		this(simplePDObject, resourcesHandler, X_OBJECT_TYPE);
	}

	protected GFPDXObject(org.verapdf.pd.images.PDXObject simplePDObject, PDResourcesHandler resourcesHandler, final String type) {
		super(simplePDObject, type);
		this.resourcesHandler = resourcesHandler;
	}

	@Override
	public String getSubtype() {
		ASAtom subtype = ((org.verapdf.pd.images.PDXObject) simplePDObject).getSubtype();
		return subtype == null ? null : subtype.getValue();
	}

	@Override
	public Boolean getcontainsOPI() {
		return this.simplePDObject.knownKey(ASAtom.OPI);
	}

	@Override
	public Boolean getcontainsSMask() {
		return this.simplePDObject.knownKey(ASAtom.SMASK);
	}

	public static PDXObject getTypedPDXObject(org.verapdf.pd.images.PDXObject xObject, PDResourcesHandler resources,
											  GraphicState inheritedGraphicState, COSObject parentStructElem, List<String> parentsTags) {
		ASAtom type = xObject.getType();
		if (ASAtom.FORM.equals(type)) {
			return new GFPDXForm((PDXForm) xObject, resources, inheritedGraphicState, parentStructElem, parentsTags, null, false, false);
		} else if (ASAtom.IMAGE.equals(type)) {
			return new GFPDXImage((PDXImage) xObject, resources, inheritedGraphicState.getFillColorSpace());
		} else if (ASAtom.PS.equals(type)) {
			return new GFPDXObject(xObject, resources);
		} else {
			return null;
		}
	}
}
