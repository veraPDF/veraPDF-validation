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
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.gf.model.impl.pd.gfse.GFSEGeneral;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.pdlayer.PDStructElem;
import org.verapdf.model.pdlayer.PDStructTreeRoot;
import org.verapdf.pd.structure.StructureType;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.tools.TaggedPDFHelper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maksim Bezrukov
 */
public class GFPDStructTreeRoot extends GFPDObject implements PDStructTreeRoot {

	/** Type name for {@code PBoxPDStructTreeRoot} */
	public static final String STRUCT_TREE_ROOT_TYPE = "PDStructTreeRoot";

	/** Link name for {@code K} key */
	public static final String CHILDREN = "K";

	/** Link name for {@code roleMapNames} key */
	public static final String ROLE_MAP_NAMES = "roleMapNames";

	private List<PDStructElem> children = null;

	/**
	 * Default constructor
	 *
	 * @param treeRoot structure tree root implementation
	 */
	public GFPDStructTreeRoot(org.verapdf.pd.structure.PDStructTreeRoot treeRoot) {
		super(treeRoot, STRUCT_TREE_ROOT_TYPE);
		StaticContainers.setRoleMapHelper(treeRoot.getRoleMap());
	}

	@Override
	public String getkidsStandardTypes() {
		return this.getChildren()
		           .stream()
		           .map(PDStructElem::getstandardType)
		           .filter(Objects::nonNull)
		           .collect(Collectors.joining("&"));
	}

	@Override
	public Boolean gethasContentItems() {
		COSObject children = this.simplePDObject.getKey(ASAtom.K);
		if (children == null) {
			return false;
		}
		if (TaggedPDFHelper.isContentItem(children)) {
			return true;
		}
		if (children.getType() == COSObjType.COS_ARRAY && children.size().intValue() > 0) {
			for (int i = 0; i < children.size().intValue(); ++i) {
				COSObject elem = children.at(i);
				if (TaggedPDFHelper.isContentItem(elem)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case CHILDREN:
				return this.getChildren();
			case ROLE_MAP_NAMES:
				return getRoleMapNames();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDStructElem> getChildren() {
		if (this.children == null) {
			this.children = parseChildren();
		}
		return this.children;
	}

	private List<PDStructElem> parseChildren() {
		List<org.verapdf.pd.structure.PDStructElem> elements =
				((org.verapdf.pd.structure.PDStructTreeRoot) simplePDObject).getChildren();
		if (!elements.isEmpty()) {
			List<PDStructElem> res = new ArrayList<>(elements.size());
			for (org.verapdf.pd.structure.PDStructElem element : elements) {
				res.add(GFSEGeneral.createTypedStructElem(element));
			}
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	private List<CosUnicodeName> getRoleMapNames() {
		if (this.simplePDObject != null) {
			Map<ASAtom, ASAtom> roleMap = ((org.verapdf.pd.structure.PDStructTreeRoot)
					simplePDObject).getRoleMap();
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
