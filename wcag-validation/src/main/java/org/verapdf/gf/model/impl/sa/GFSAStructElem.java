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

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.gf.model.impl.sa.structelems.GFSAGeneral;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SAStructElem;
import org.verapdf.pd.structure.PDMCRDictionary;
import org.verapdf.pd.structure.StructureType;
import org.verapdf.tools.TaggedPDFConstants;
import org.verapdf.wcag.algorithms.entities.INode;
import org.verapdf.wcag.algorithms.entities.SemanticSpan;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;
import org.verapdf.wcag.algorithms.entities.enums.SemanticType;
import org.verapdf.wcag.algorithms.entities.maps.SemanticTypeMapper;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public class GFSAStructElem extends GenericModelObject implements SAStructElem {

    public static final String CHILDREN = "children";

	private final org.verapdf.pd.structure.PDStructElem structElemDictionary;

	protected List<Object> children = null;

	private INode node;

	private final String id;
	private final String standardType;

	public GFSAStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary, String standardType, String type) {
		super(type);
		this.structElemDictionary = structElemDictionary;
		this.standardType = standardType;
		COSKey key = structElemDictionary.getObject().getObjectKey();
		id = (key != null ? (key.getNumber() + " " + key.getGeneration() + " obj") : "0 0 obj") +
		     (standardType != null ? (" " + standardType) : "") +
		     (getStructureType() != null ? (" " + ((COSName) COSName.fromValue(getStructureType())).getUnicodeValue()) : "");
	}

	public void setNode(INode node) {
		this.node = node;
	}

	public INode getNode() {
		return node;
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

	public String getType() {
		ASAtom type = structElemDictionary.getType();
		return type == null ? null : type.getValue();
	}

	public String getStructureType() {
		ASAtom subtype = structElemDictionary.getNameKey(ASAtom.S);
		return subtype == null ? null : subtype.getValue();
	}

	@Override
	public String getstandardType() {
		return standardType;
	}

	@Override
	public Boolean getisTableElem() {
		return TaggedPDFConstants.TBODY.equals(standardType) || TaggedPDFConstants.THEAD.equals(standardType) ||
		       TaggedPDFConstants.TFOOT.equals(standardType) || TaggedPDFConstants.TH.equals(standardType) ||
		       TaggedPDFConstants.TD.equals(standardType) || TaggedPDFConstants.TR.equals(standardType);
	}

	@Override
	public Boolean getisTableChild() {
		return getisTableElem() || TaggedPDFConstants.P.equals(standardType) ||
		       TaggedPDFConstants.SPAN.equals(standardType) || TaggedPDFConstants.TABLE.equals(standardType);
	}

	public static String getStructureElementStandardType(org.verapdf.pd.structure.PDStructElem pdStructElem){
		StructureType type = pdStructElem.getStructureType();
		if (type != null) {
			return StaticStorages.getRoleMapHelper().getStandardType(type.getType(), false);
		}
		return null;
	}

	private List<Object> getChildren() {
		if (this.children == null) {
			parseChildren();
		}
		return Collections.unmodifiableList(children);
	}

	protected void parseChildren() {
		List<java.lang.Object> elements = structElemDictionary.getChildren();
		children = new ArrayList<>(elements.size());
		if (!elements.isEmpty()) {
			for (java.lang.Object element : elements) {
				if (element instanceof org.verapdf.pd.structure.PDStructElem) {
					GFSAStructElem structElem = GFSAGeneral.createTypedStructElem((org.verapdf.pd.structure.PDStructElem)element);
					INode childNode = new GFSANode(structElem);
					structElem.setNode(childNode);
					node.addChild(childNode);
					children.add(structElem);
				} else if (element instanceof org.verapdf.pd.structure.PDMCRDictionary) {
					PDMCRDictionary mcr = (org.verapdf.pd.structure.PDMCRDictionary) element;
					addChunksToChildren(mcr.getPageObjectNumber(), mcr.getMCID());
				} else if (element instanceof COSObject && ((COSObject)element).getType() == COSObjType.COS_INTEGER) {
					addChunksToChildren(getPageObjectNumber(), (((COSObject)element).getDirectBase()).getInteger());
				}
			}
		}
	}

	private void addChunksToChildren(COSKey pageObjectNumber, Long mcid) {
		List<IChunk> chunks = StaticStorages.getChunks().get(pageObjectNumber, mcid);
		if (chunks != null) {
			for (IChunk chunk : chunks) {
				if (chunk instanceof TextChunk) {
					node.addChild(new SemanticSpan((TextChunk) chunk));
					children.add(new GFSATextChunk((TextChunk) chunk));
				}
			}
		}
	}

	@Override
	public String getContext() {
		return node.getBoundingBox().getLocation();
	}

	@Override
	public Double getcorrectSemanticScore() {
		return node.getCorrectSemanticScore();
	}

	@Override
	public Boolean gethasCorrectType() {
		if (standardType == null) {
			return false;
		}
		SemanticType semanticType = node.getSemanticType();
		if (!SemanticTypeMapper.containsType(standardType) || semanticType == null) {
			return null;
		}
		return standardType.equals(semanticType.getValue());
	}

	@Override
	public String getcorrectType() {
		SemanticType semanticType = node.getSemanticType();
		if (semanticType == null) {
			return null;
		}
		return semanticType.getValue();
	}

	@Override
	public String getID() {
		return this.id;
	}

	public COSKey getPageObjectNumber() {
		return structElemDictionary.getPageObjectNumber();
	}

}
