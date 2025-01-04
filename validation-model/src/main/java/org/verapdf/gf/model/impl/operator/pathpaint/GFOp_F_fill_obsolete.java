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
package org.verapdf.gf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_F_fill_obsolete;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_F_fill_obsolete extends GFOpFillPaint implements Op_F_fill_obsolete {

	/** Type name for {@code GFOp_F_fill_obsolete} */
	public static final String OP_F_FILL_OBSOLETE_TYPE = "Op_F_fill_obsolete";

	public GFOp_F_fill_obsolete(List<COSBase> arguments, final GraphicState state,
								final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_F_FILL_OBSOLETE_TYPE);
	}

}
