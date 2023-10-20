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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.pdlayer.PDStructTreeRoot;

import java.util.*;

/**
 * @author Maksim Bezrukov
 */
public class GFPDStructTreeRoot extends GFPDStructTreeNode implements PDStructTreeRoot {

	/** Type name for {@code GFPDStructTreeRoot} */
	public static final String STRUCT_TREE_ROOT_TYPE = "PDStructTreeRoot";

	/** Link name for {@code roleMapNames} key */
	public static final String ROLE_MAP_NAMES = "roleMapNames";

	/**
	 * Default constructor
	 *
	 * @param treeRoot structure tree root implementation
	 */
	public GFPDStructTreeRoot(org.verapdf.pd.structure.PDStructTreeRoot treeRoot) {
		super(treeRoot, STRUCT_TREE_ROOT_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ROLE_MAP_NAMES:
				return getRoleMapNames();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosUnicodeName> getRoleMapNames() {
		if (this.simplePDObject != null) {
			Map<ASAtom, ASAtom> roleMap = ((org.verapdf.pd.structure.PDStructTreeRoot) simplePDObject).getRoleMap();
			if (roleMap != null) {
				List<CosUnicodeName> res = new ArrayList<>();
				for (Map.Entry<ASAtom, ASAtom> entry : roleMap.entrySet()) {
					res.add(new GFCosUnicodeName((COSName) COSName.construct(entry.getKey()).get()));
					res.add(new GFCosUnicodeName((COSName) COSName.construct(entry.getValue()).get()));
				}
				return res;
			}
		}
		return Collections.emptyList();
	}

	@Override
	public String gettopLevelFirstElementStandardType() {
		if (!getChildren().isEmpty()) {
			return getChildren().get(0).getstandardType();
		}
		return null;
	}
}
