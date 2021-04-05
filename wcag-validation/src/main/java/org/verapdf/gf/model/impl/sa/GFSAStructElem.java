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
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SAStructElem;
import org.verapdf.pd.structure.PDMCRDictionary;
import org.verapdf.pd.structure.StructureType;
import org.verapdf.wcag.algorithms.entities.INode;
import org.verapdf.wcag.algorithms.entities.SemanticSpan;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;
import org.verapdf.wcag.algorithms.entities.enums.SemanticType;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;
import org.verapdf.wcag.algorithms.entities.maps.SemanticTypeMapper;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public class GFSAStructElem extends GenericModelObject implements SAStructElem, INode {

	public static final String STRUCTURE_ELEMENT_TYPE = "SAStructElem";

    public static final String CHILDREN = "children";

	private org.verapdf.pd.structure.PDStructElem structElemDictionary = null;

	private List<INode> nodeChildren = null;
	private List<Object> children = null;

	private Double correctSemanticScore;
	private SemanticType semanticType;
	private BoundingBox boundingBox;
	private SemanticType initialSemanticType;
	private final String id;
	private final String standardType;

	public GFSAStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary, String type) {
		super(type);
		this.structElemDictionary = structElemDictionary;
		boundingBox = new BoundingBox();
		standardType = calculateStandardType();
		COSKey key = structElemDictionary.getObject().getObjectKey();
		id = (key != null ? key.getNumber() + " " + key.getGeneration() + " obj" + this.getObjectType() : "0 0 obj") +
		     (standardType != null ? (" " + standardType) : "")  +
		     (getType() != null ? (" " + ((COSName) COSName.fromValue(getType())).getUnicodeValue()) : "");
		setInitialType();
	}

	public GFSAStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary) {
		this(structElemDictionary, STRUCTURE_ELEMENT_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case CHILDREN:
				return this.getchildren();
			default:
				return super.getLinkedObjects(link);
		}
	}

	public String getType() {
		ASAtom type = structElemDictionary.getType();
		return type == null ? null : type.getValue();
	}

	public String getStandardType() {
		return standardType;
	}

	public String calculateStandardType() {
		return getStructureElementStandardType(structElemDictionary);
	}

	public static String getStructureElementStandardType(org.verapdf.pd.structure.PDStructElem pdStructElem){
		StructureType type = pdStructElem.getStructureType();
		if (type != null) {
			return StaticStorages.getRoleMapHelper().getStandardType(type.getType(), false);
		}
		return null;
	}

	@Override
	public void setSemanticType(SemanticType semanticType) {
		this.semanticType = semanticType;
	}

	public SemanticType getInitialSemanticType() {
		return initialSemanticType;
	}

	private void setInitialType() {
		String standardType = getStandardType();
		if (standardType != null && SemanticTypeMapper.containsType(standardType)) {
			initialSemanticType = (SemanticTypeMapper.getSemanticType(standardType));
		}
	}

	@Override
	public Double getCorrectSemanticScore() {
		return correctSemanticScore;
	}

	@Override
	public void setCorrectSemanticScore(Double correctSemanticScore) {
		this.correctSemanticScore = correctSemanticScore;
	}

	@Override
	public Integer getPageNumber() {
		return boundingBox.getPageNumber();
	}

	@Override
	public void setPageNumber(Integer pageNumber) {
		this.boundingBox.setPageNumber(pageNumber);
	}

	@Override
	public Integer getLastPageNumber() {
		return boundingBox.getLastPageNumber();
	}

	@Override
	public void setLastPageNumber(Integer lastPageNumber) {
		this.boundingBox.setLastPageNumber(lastPageNumber);
	}

	@Override
	public double getLeftX() {
		return boundingBox.getLeftX();
	}

	@Override
	public double getBottomY() {
		return boundingBox.getBottomY();
	}

	@Override
	public double getRightX() {
		return boundingBox.getRightX();
	}

	@Override
	public double getTopY() {
		return boundingBox.getTopY();
	}

	@Override
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	@Override
	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox.init(boundingBox);
	}

	@Override
	public SemanticType getSemanticType() {
		return semanticType;
	}

	@Override
	public List<INode> getChildren() {
		if (this.nodeChildren == null) {
			parseChildren();
		}
		return Collections.unmodifiableList(nodeChildren);
	}

	private List<Object> getchildren() {
		if (this.children == null) {
			parseChildren();
		}
		return Collections.unmodifiableList(children);
	}

	private void parseChildren() {
		List<java.lang.Object> elements = structElemDictionary.getChildren();
		nodeChildren = new ArrayList<>(elements.size());
		children = new ArrayList<>(elements.size());
		if (!elements.isEmpty()) {
			for (java.lang.Object element : elements) {
				if (element instanceof org.verapdf.pd.structure.PDStructElem) {
					GFSAStructElem structElem = new GFSAStructElem((org.verapdf.pd.structure.PDStructElem)element);
					nodeChildren.add(structElem);
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
					nodeChildren.add(new SemanticSpan((TextChunk) chunk));
					children.add(new GFSATextChunk((TextChunk) chunk));
				}
			}
		}
	}

	@Override
	public String getContext() {
		return boundingBox.getLocation();
	}

	@Override
	public Double getcorrectSemanticScore() {
		return correctSemanticScore;
	}

	@Override
	public Boolean gethasCorrectType() {
		String standardType = getStandardType();
		if (standardType == null) {
			return false;
		}
		SemanticType semanticType = getSemanticType();
		if (!SemanticTypeMapper.containsType(standardType) || semanticType == null) {
			return null;
		}
		return standardType.equals(semanticType.getValue());
	}

	@Override
	public String getcorrectType() {
		return getSemanticType().getValue();
	}

	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(boundingBox);
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		GFSAStructElem that = (GFSAStructElem) o;
		return that.getBoundingBox().equals(boundingBox);
	}

	public COSKey getPageObjectNumber() {
		return structElemDictionary.getPageObjectNumber();
	}

}
