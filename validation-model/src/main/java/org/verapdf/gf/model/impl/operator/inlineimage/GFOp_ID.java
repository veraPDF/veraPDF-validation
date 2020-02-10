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
package org.verapdf.gf.model.impl.operator.inlineimage;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.gf.model.impl.cos.GFCosDict;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosDict;
import org.verapdf.model.operator.Op_ID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_ID extends GFOpInlineImage implements Op_ID {

	/** Type name for {@code GFOp_ID} operator */
	public static final String OP_ID_TYPE = "Op_ID";

	/** Name of link to the inline image dictionary */
	public static final String INLINE_IMAGE_DICTIONARY =
			"inlineImageDictionary";

	public GFOp_ID(List<COSBase> arguments) {
		super(arguments, OP_ID_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(
			String link) {
		if (INLINE_IMAGE_DICTIONARY.equals(link)) {
			return this.getInlineImageDictionary();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosDict> getInlineImageDictionary() {
		if (!this.arguments.isEmpty()) {
			COSBase dict = this.arguments
					.get(this.arguments.size() - 1);
			if (dict.getType() == COSObjType.COS_DICT) {
				List<CosDict> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(new GFCosDict((COSDictionary) dict));
				return Collections.unmodifiableList(list);
			}
		}
		return Collections.emptyList();
	}
}
