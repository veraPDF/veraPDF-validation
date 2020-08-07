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
package org.verapdf.gf.model.impl.pd.images;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.pd.GFPDResource;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDSMaskImage;
import org.verapdf.model.pdlayer.PDXObject;
import org.verapdf.pd.images.PDXForm;
import org.verapdf.pd.images.PDXImage;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

/**
 * @author Maksim Bezrukov
 */
public class GFPDXObject extends GFPDResource implements PDXObject {

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(GFPDXObject.class.getCanonicalName());

	public static final String X_OBJECT_TYPE = "PDXObject";

	public static final String OPI = "OPI";
	public static final String S_MASK = "SMask";

	protected final PDResourcesHandler resourcesHandler;

	public GFPDXObject(
			org.verapdf.pd.images.PDXObject simplePDObject, PDResourcesHandler resourcesHandler) {
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

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case S_MASK:
				return this.getSMask();
			default:
				return super.getLinkedObjects(link);
		}
	}

	protected List<PDSMaskImage> getSMask() {
		PDXImage smask = ((org.verapdf.pd.images.PDXObject) simplePDObject).getSMask();
		if (smask != null) {
			List<PDSMaskImage> mask = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			mask.add(new GFPDSMaskImage(smask, this.resourcesHandler));
			return Collections.unmodifiableList(mask);
		}
		return Collections.emptyList();
	}

	public static PDXObject getTypedPDXObject(
			org.verapdf.pd.images.PDXObject xObject,
			PDResourcesHandler resources, GraphicState inheritedGraphicState, String parentStructureTag, String parentsTags) {
		ASAtom type = xObject.getType();
		if (ASAtom.FORM.equals(type)) {
			return new GFPDXForm((PDXForm) xObject, resources, inheritedGraphicState, parentStructureTag, parentsTags);
		} else if (ASAtom.IMAGE.equals(type)) {
			return new GFPDXImage((PDXImage) xObject, resources,
					inheritedGraphicState.getFillColorSpace());
		} else if (ASAtom.PS.equals(type)) {
			return new GFPDXObject(xObject, resources);
		} else {
			return null;
		}
	}
}
