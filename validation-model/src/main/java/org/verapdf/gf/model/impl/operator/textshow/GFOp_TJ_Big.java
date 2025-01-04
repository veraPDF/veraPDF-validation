/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.operator.textshow;

import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSObjType;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.cos.GFCosArray;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosArray;
import org.verapdf.model.operator.Op_TJ_Big;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_TJ_Big extends GFOpTextShow implements Op_TJ_Big {

	/** Type name for {@code GFOp_TJ_Big} */
	public static final String OP_TJ_BIG_TYPE = "Op_TJ_Big";

	/** Name of link to the set of strings and numbers */
    public static final String SPECIAL_STRINGS = "specialStrings";

    public GFOp_TJ_Big(List<COSBase> arguments, GraphicState state,
                       PDResourcesHandler resourcesHandler, GFOpMarkedContent markedContent,
                       StructureElementAccessObject structureElementAccessObject, boolean isRealContent) {
        super(arguments, state, resourcesHandler, markedContent, structureElementAccessObject, isRealContent, OP_TJ_BIG_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (SPECIAL_STRINGS.equals(link)) {
            return this.getSpecialStrings();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosArray> getSpecialStrings() {
		if (!this.arguments.isEmpty()) {
			COSBase base = this.arguments.get(
					this.arguments.size() - 1);
			if (base.getType() == COSObjType.COS_ARRAY) {
				List<CosArray> array = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				array.add(new GFCosArray((COSArray) base));
				return Collections.unmodifiableList(array);
			}
		}
        return Collections.emptyList();
    }

}
