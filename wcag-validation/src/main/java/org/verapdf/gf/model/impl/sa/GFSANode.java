/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.sa;

import org.verapdf.cos.COSKey;
import org.verapdf.wcag.algorithms.entities.INode;
import org.verapdf.wcag.algorithms.entities.SemanticNode;
import org.verapdf.wcag.algorithms.entities.maps.SemanticTypeMapper;

import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSANode extends SemanticNode {

	private final GFSAStructElem structElem;

	public GFSANode(GFSAStructElem structElem) {
		super(SemanticTypeMapper.getSemanticType(structElem.getstandardType()), structElem.getErrorCodes(),
				structElem.getErrorArguments(), getObjectKeyNumber(structElem));
		this.structElem = structElem;
		setAttributesDictionary(new GFSAAttributesDictionary(structElem.getStructElemDictionary()));
	}
	
	private static Integer getObjectKeyNumber(GFSAStructElem structElem) {
		COSKey key = structElem.getStructElemDictionary().getObject().getKey();
		return key != null ? key.getNumber() : null;
	}

	@Override
	public List<INode> getChildren() {
		if (structElem.children == null) {
			structElem.parseChildren();
		}
		return super.getChildren();
	}

}
