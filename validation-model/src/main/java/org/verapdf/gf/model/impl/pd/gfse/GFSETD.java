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
package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.GFPDStructElem;
import org.verapdf.model.selayer.SETD;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.AttributeHelper;
import org.verapdf.tools.TaggedPDFConstants;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GFSETD extends GFPDStructElem implements SETD {

    public static final String TD_STRUCTURE_ELEMENT_TYPE = "SETD";

    public GFSETD(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TD, TD_STRUCTURE_ELEMENT_TYPE);
    }

	public Long getColSpan() {
		return AttributeHelper.getColSpan(simplePDObject);
	}

	public Long getRowSpan() {
		return AttributeHelper.getRowSpan(simplePDObject);
	}

	protected List<String> getHeaders() {
    	COSArray headers = AttributeHelper.getArrayAttributeValue(simplePDObject, ASAtom.HEADERS,
				TaggedPDFConstants.TABLE, null);
		if (headers != null) {
			List<String> list = new LinkedList<>();
			for (COSObject elem : headers) {
				if (elem.getType() == COSObjType.COS_STRING) {
					list.add(elem.getString());
				}
			}
			return list;
		}
		return Collections.emptyList();
	}
}
