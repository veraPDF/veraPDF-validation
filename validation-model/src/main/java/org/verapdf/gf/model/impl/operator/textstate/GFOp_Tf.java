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
package org.verapdf.gf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSName;
import org.verapdf.gf.model.impl.cos.GFCosName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosName;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_Tf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tf extends GFOpTextState implements Op_Tf {

	public static final String OP_TF_TYPE = "Op_Tf";

	public static final String SIZE = "size";
	public static final String FONT_NAME = "fontName";

	public GFOp_Tf(List<COSBase> arguments) {
		super(arguments, OP_TF_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case SIZE:
				return this.getSize();
			case FONT_NAME:
				return this.getFontName();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosNumber> getSize() {
		return this.getLastNumber();
	}

	private List<CosName> getFontName() {
		if (this.arguments.size() > 1) {
			COSBase base = this.arguments.get(this.arguments.size() - 2);
			if (base instanceof COSName) {
				List<CosName> names = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				names.add(new GFCosName((COSName) base));
				return Collections.unmodifiableList(names);
			}
		}
		return Collections.emptyList();
	}

}
