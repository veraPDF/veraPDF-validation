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
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_Quote;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Quote extends GFOpStringTextShow implements Op_Quote {

	/** Type name for {@code GFOp_Quote} */
    public static final String OP_QUOTE_TYPE = "Op_Quote";

    public GFOp_Quote(List<COSBase> arguments, GraphicState state, PDResourcesHandler resourcesHandler,
                      GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject, boolean isRealContent) {
        super(arguments, state, resourcesHandler, markedContent, structureElementAccessObject, isRealContent, OP_QUOTE_TYPE);
    }

}
