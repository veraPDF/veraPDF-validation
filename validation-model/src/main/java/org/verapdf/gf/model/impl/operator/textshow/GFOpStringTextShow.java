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
package org.verapdf.gf.model.impl.operator.textshow;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSString;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.cos.GFCosString;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosString;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpStringTextShow extends GFOpTextShow {

	/** Name of link to the showing strings for operators ", ', Tj */
    public static final String SHOW_STRING = "showString";

    protected GFOpStringTextShow(List<COSBase> arguments, GraphicState state,
                                 PDResourcesHandler resources, GFOpMarkedContent markedContent,
                                 StructureElementAccessObject structureElementAccessObject, boolean isRealContent, final String opType) {
        super(arguments, state, resources, markedContent, structureElementAccessObject, isRealContent, opType);
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (SHOW_STRING.equals(link)) {
            return this.getShowString();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosString> getShowString() {
		if (!this.arguments.isEmpty()) {
			COSBase base = this.arguments.get(this.arguments.size() - 1);
			if (base.getType() == COSObjType.COS_STRING) {
				List<CosString> string = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				string.add(new GFCosString((COSString) base));
				return Collections.unmodifiableList(string);
			}
		}
        return Collections.emptyList();
    }

}
