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
package org.verapdf.gf.model.impl.sa;

import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SAStructElem;
import org.verapdf.model.salayer.SAStructTreeRoot;
import org.verapdf.wcag.algorithms.entities.INode;
import org.verapdf.wcag.algorithms.entities.ITree;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public class GFSAStructTreeRoot extends GenericModelObject implements SAStructTreeRoot, ITree {

	public static final String STRUCT_TREE_ROOT_TYPE = "SAStructTreeRoot";

	public static final String CHILDREN = "children";

	private List<GFSAStructElem> children = null;

	private org.verapdf.pd.structure.PDStructTreeRoot treeRoot = null;

	public GFSAStructTreeRoot(org.verapdf.pd.structure.PDStructTreeRoot treeRoot) {
		super(STRUCT_TREE_ROOT_TYPE);
		this.treeRoot = treeRoot;
		StaticStorages.setRoleMapHelper(treeRoot.getRoleMap());
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case CHILDREN:
				return this.getChildren();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<SAStructElem> getChildren() {
		if (this.children == null) {
			this.children = parseChildren();
		}
		return Collections.unmodifiableList(children);
	}

	private List<GFSAStructElem> parseChildren() {
		List<org.verapdf.pd.structure.PDStructElem> elements = treeRoot.getStructChildren();
		if (!elements.isEmpty()) {
			List<GFSAStructElem> res = new ArrayList<>(elements.size());
			for (org.verapdf.pd.structure.PDStructElem element : elements) {
				res.add(new GFSAStructElem(element));
			}
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	@Override
	public INode getRoot() {
		if (this.children == null) {
			this.children = parseChildren();
		}
		return children.get(0);
	}
}
