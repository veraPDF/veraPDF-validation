/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.gf.model.impl.cos.GFCosRenderingIntent;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosRenderingIntent;
import org.verapdf.model.operator.Op_ri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_ri extends GFOpGeneralGS implements Op_ri {

	/** Type name for {@code GFOp_ri} */
    public static final String OP_RI_TYPE = "Op_ri";

	/** Name of link to the rendering intent */
    public static final String RENDERING_INTENT = "renderingIntent";

    public GFOp_ri(List<COSBase> arguments) {
        super(arguments, OP_RI_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (RENDERING_INTENT.equals(link)) {
            return this.getRenderingIntent();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosRenderingIntent> getRenderingIntent() {
		if (!this.arguments.isEmpty()) {
			COSBase base = this.arguments.get(this.arguments.size() - 1);
			if (base.getType() == COSObjType.COS_NAME) {
				List<CosRenderingIntent> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(new GFCosRenderingIntent((COSName) base));
				return Collections.unmodifiableList(list);
			}
		}
        return Collections.emptyList();
    }

}
