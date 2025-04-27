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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.gfse.GFSEFactory;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDStructTreeNode;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.pdfa.flavours.PDFFlavours;
import org.verapdf.tools.TaggedPDFConstants;
import org.verapdf.tools.TaggedPDFHelper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maxim Plushchov
 */
public abstract class GFPDStructTreeNode extends GFPDObject implements PDStructTreeNode {

	/**
	 * Link name for {@code K} key
	 */
	public static final String CHILDREN = "K";
	
	private List<GFPDStructElem> children;

	protected GFPDStructTreeNode(org.verapdf.pd.structure.PDStructTreeNode structTreeNodeDictionary, String type) {
		super(structTreeNodeDictionary, type);
	}


	@Override
	public String getkidsStandardTypes() {
		if (PDFFlavours.isWCAGFlavour(StaticContainers.getFlavour())) {
			return this.getChildrenStandardTypes()
			           .stream()
			           .filter(type -> type != null && !TaggedPDFConstants.ARTIFACT.equals(type))
			           .collect(Collectors.joining("&"));
		}
		return this.getChildrenStandardTypes()
		           .stream()
		           .filter(Objects::nonNull)
		           .collect(Collectors.joining("&"));
	}

	@Override
	public Boolean gethasContentItems() {
		return gethasContentItems(this);
	}

	private static Boolean gethasContentItems(GFPDStructTreeNode structElem) {
		COSObject children = structElem.simplePDObject.getKey(ASAtom.K);
		if (children == null) {
			return false;
		}
		if (TaggedPDFHelper.isContentItem(children)) {
			return true;
		}
		if (children.getType() == COSObjType.COS_ARRAY) {
			for (COSObject elem : (COSArray)children.getDirectBase()) {
				if (TaggedPDFHelper.isContentItem(elem)) {
					return true;
				}
			}
		}
		for (GFPDStructElem child : structElem.getChildren()) {
			if (PDStructElem.isPassThroughTag(child.getstandardType()) && gethasContentItems(child)) {
				return true;
			}
		}
		return false;
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

	public List<String> getChildrenStandardTypes() {
		return getChildrenStandardTypes(this);
	}

	private static List<String> getChildrenStandardTypes(GFPDStructTreeNode element) {
		List<String> res = new ArrayList<>();
		for (GFPDStructElem child : element.getChildren()) {
			String elementStandardType = child.getstandardType();
			if (PDStructElem.isPassThroughTag(elementStandardType)) {
				res.addAll(getChildrenStandardTypes(child));
			} else {
				res.add(elementStandardType);
			}
		}
		return Collections.unmodifiableList(res);
	}

	private List<GFPDStructElem> getChildren() {
		if (children == null) {
			List<PDStructElem> elements = ((org.verapdf.pd.structure.PDStructTreeNode) simplePDObject).getStructChildren();
			if (!elements.isEmpty()) {
				List<GFPDStructElem> res = new ArrayList<>(elements.size());
				for (PDStructElem element : elements) {
					res.add(GFSEFactory.createTypedStructElem(element));
				}
				children = Collections.unmodifiableList(res);
			} else {
				children = Collections.emptyList();
			}
		}
		return children;
	}

	public List<GFPDStructElem> getStructuralSignificanceChildren() {
		List<GFPDStructElem> children = getChildren();
		List<GFPDStructElem> result = new LinkedList<>();
		for (GFPDStructElem child : children) {
			if (PDStructElem.isPassThroughTag(child.getstandardType())) {
				result.addAll(child.getStructuralSignificanceChildren());
			} else {
				result.add(child);
			}
		}
		return result;
	}
}
