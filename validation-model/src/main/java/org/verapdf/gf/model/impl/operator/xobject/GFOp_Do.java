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
package org.verapdf.gf.model.impl.operator.xobject;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.pd.images.GFPDXObject;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_Do;
import org.verapdf.model.pdlayer.PDXObject;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Do extends GFOperator implements Op_Do {

	/** Type name for {@code GFOp_Do} */
    public static final String OP_DO_TYPE = "Op_Do";

	/** Name of link to the XObject */
    public static final String X_OBJECT = "xObject";

	private List<PDXObject> xObjects = null;

    private final org.verapdf.pd.images.PDXObject pbXObject;
	private final PDResourcesHandler resourcesHandler;
	private final GraphicState inheritedGraphicState;
	private final StructureElementAccessObject structureElementAccessObject;
	private final String parentStructureTag;

	public GFOp_Do(List<COSBase> arguments, org.verapdf.pd.images.PDXObject pbXObject,
				   PDResourcesHandler resourcesHandler, GraphicState inheritedGraphicState,
				   StructureElementAccessObject structureElementAccessObject,
				   String parentStructureTag) {
        super(arguments, OP_DO_TYPE);
        this.pbXObject = pbXObject;
		this.resourcesHandler = resourcesHandler;
		this.inheritedGraphicState = inheritedGraphicState;
		this.structureElementAccessObject = structureElementAccessObject;
		this.parentStructureTag = parentStructureTag;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (X_OBJECT.equals(link)) {
            return this.getXObject();
        }
        return super.getLinkedObjects(link);
    }

	/**
	 * @return XObject object from veraPDF model used in current operator
	 */
	public List<org.verapdf.model.pdlayer.PDXObject> getXObject() {
		if (this.xObjects == null) {
			if (this.pbXObject == null) {
				return Collections.emptyList();
			}
			PDXObject typedPDXObject = GFPDXObject.getTypedPDXObject(this.pbXObject, this.resourcesHandler,
					inheritedGraphicState, this.structureElementAccessObject, this.parentStructureTag);
			if (typedPDXObject != null) {
				List<PDXObject> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(typedPDXObject);
				this.xObjects = Collections.unmodifiableList(list);
			} else {
				this.xObjects = Collections.emptyList();
			}
		}
		return this.xObjects;
	}

}
