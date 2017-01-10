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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDStructElem;
import org.verapdf.model.pdlayer.PDStructTreeRoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDStructTreeRoot extends GFPDObject implements PDStructTreeRoot {

	/** Type name for {@code PBoxPDStructTreeRoot} */
	public static final String STRUCT_TREE_ROOT_TYPE = "PDStructTreeRoot";

	/** Link name for {@code K} key */
	public static final String CHILDREN = "K";

	private List<PDStructElem> children = null;

	/**
	 * Default constructor
	 *
	 * @param treeRoot structure tree root implementation
	 */
	public GFPDStructTreeRoot(org.verapdf.pd.PDStructTreeRoot treeRoot) {
		super(treeRoot, STRUCT_TREE_ROOT_TYPE);
		StaticContainers.setRoleMapHelper(treeRoot.getRoleMap());
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (CHILDREN.equals(link)) {
			return this.getChildren();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDStructElem> getChildren() {
		if (this.children == null) {
			this.children = parseChildren();
		}
		return this.children;
	}

	private List<PDStructElem> parseChildren() {
		List<org.verapdf.pd.PDStructElem> elements = ((org.verapdf.pd.PDStructTreeRoot) simplePDObject).getChildren();
		if (!elements.isEmpty()) {
			List<PDStructElem> res = new ArrayList<>(elements.size());
			for (org.verapdf.pd.PDStructElem element : elements) {
				res.add(new GFPDStructElem(element));
			}
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	@Override
	public String gettopLevelFirstElementStandartType() {
		if (this.children == null) {
			this.children = parseChildren();
		}

		if (!this.children.isEmpty()) {
			return this.children.get(0).getstandardType();
		}
		return null;
	}
}
