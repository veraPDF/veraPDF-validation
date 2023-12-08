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
import org.verapdf.gf.model.impl.sa.structelems.GFSAFactory;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SAStructElem;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.structure.PDMCRDictionary;
import org.verapdf.pd.structure.PDOBJRDictionary;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;
import org.verapdf.wcag.algorithms.entities.*;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.ImageChunk;
import org.verapdf.wcag.algorithms.entities.content.LineArtChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;
import org.verapdf.wcag.algorithms.entities.enums.SemanticType;
import org.verapdf.wcag.algorithms.semanticalgorithms.utils.TextChunkUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maxim Plushchov
 */
public class GFSAStructElem extends GFSAObject implements SAStructElem {

    public static final String CHILDREN = "children";

	protected final org.verapdf.pd.structure.PDStructElem structElemDictionary;

	protected List<Object> children = null;

	private final String id;
	private final String standardType;
	private final StringBuilder textValue = new StringBuilder();
	private final boolean isTableChild;
	private final boolean isListChild;
	private boolean isLeafNode = true;
	private final String parentsStandardTypes;

	public GFSAStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary, String standardType,
	                      String type, String parentsStandardTypes) {
		super(type);
		this.structElemDictionary = structElemDictionary;
		this.standardType = standardType;
		COSKey key = structElemDictionary.getObject().getObjectKey();
		id = (key != null ? (key.getNumber() + " " + key.getGeneration()) : "0 0") + " obj" +
		     (standardType != null ? (' ' + standardType) : "") +
		     (getStructureType() != null ? (' ' + ((COSName) COSName.fromValue(getStructureType())).getUnicodeValue()) : "");
		this.isTableChild = Arrays.asList(parentsStandardTypes.split("&")).contains(TaggedPDFConstants.TABLE);
		this.isListChild = Arrays.asList(parentsStandardTypes.split("&")).contains(TaggedPDFConstants.L);
		this.parentsStandardTypes = parentsStandardTypes;
	}

	public void setNode(INode node) {
		setObject(node);
	}

	public INode getNode() {
		return (INode)object;
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
		return structElemDictionary.getNameKeyStringValue(ASAtom.S);
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
	public Boolean getisListElem() {
		return TaggedPDFConstants.L.equals(standardType) || TaggedPDFConstants.LI.equals(standardType) ||
		       TaggedPDFConstants.LBODY.equals(standardType) || TaggedPDFConstants.LBL.equals(standardType);
	}

	@Override
	public Boolean getisTableChild() {
		return isTableChild;
	}

	@Override
	public Boolean getisListChild() {
		return isListChild;
	}

	@Override
	public Boolean getisLeafElem() {
		if (this.children == null) {
			parseChildren();
		}
		return isLeafNode;
	}

	public List<Object> getChildren() {
		if (this.children == null) {
			parseChildren();
		}
		return Collections.unmodifiableList(children);
	}

	protected void parseChildren() {
		List<java.lang.Object> elements = structElemDictionary.getChildren();
		children = new ArrayList<>(elements.size());
		if (!elements.isEmpty()) {
			List<IChunk> chunks = new LinkedList<>();
			for (java.lang.Object element : elements) {
				if (element instanceof org.verapdf.pd.structure.PDStructElem) {
					addChunksToChildren(chunks);
					GFSAStructElem structElem = GFSAFactory.createTypedStructElem((org.verapdf.pd.structure.PDStructElem)element,
							(parentsStandardTypes.isEmpty() ? "" : (parentsStandardTypes + '&')) + standardType);
					INode childNode = new GFSANode(structElem);
					structElem.setNode(childNode);
					getNode().addChild(childNode);
					children.add(structElem);
					isLeafNode = false;
				} else if (element instanceof PDMCRDictionary) {
					PDMCRDictionary mcr = (PDMCRDictionary) element;
					COSKey streamKey = mcr.getStreamObjectKey();
					if (streamKey != null) {
						chunks.addAll(getChunks(streamKey, mcr.getMCID()));
					} else {
						chunks.addAll(getChunks(mcr.getPageObjectKey(), mcr.getMCID()));
					}
				} else if (element instanceof PDOBJRDictionary) {
					COSObject obj = ((PDOBJRDictionary)element).getReferencedObject();
					if (obj != null && obj.getType() == COSObjType.COS_DICT) {
						getNode().addChild(new SemanticAnnot(new GFSAAnnotationNode(new PDAnnotation(obj))));
					}
				} else if (element instanceof COSObject && ((COSObject)element).getType() == COSObjType.COS_INTEGER) {
					chunks.addAll(getChunks(getPageObjectNumber(), (((COSObject)element).getDirectBase()).getInteger()));
				}
			}
			addChunksToChildren(chunks);
		}
	}

	private List<IChunk> getChunks(COSKey objectNumber, Long mcid) {
		List<IChunk> chunks = StaticStorages.getChunks().get(objectNumber, mcid);
		return chunks != null ? chunks : Collections.emptyList();
	}

	private void addChunksToChildren(List<IChunk> chunks) {
		for (int i = 0; i < chunks.size(); i++) {
			IChunk chunk = chunks.get(i);
			if (chunk instanceof TextChunk) {
				i += addTextChunk(i, chunks);
			} else if (chunk instanceof ImageChunk) {
				getNode().addChild(new SemanticFigure((ImageChunk) chunk));
				children.add(new GFSAImageChunk((ImageChunk) chunk));
			} else if (chunk instanceof LineArtChunk) {
				getNode().addChild(new SemanticFigure((LineArtChunk) chunk));
				children.add(new GFSALineArtChunk((LineArtChunk) chunk));
			}
		}
		chunks.clear();
	}

	public int addTextChunk(int number, List<IChunk> chunks) {
		TextChunk textChunk = (TextChunk)chunks.get(number);
		int i = number + 1;
		while (i < chunks.size() && chunks.get(i) instanceof TextChunk) {
			TextChunk nextTextChunk = (TextChunk)chunks.get(i);
			if (TextChunkUtils.areTextChunksHaveSameStyle(textChunk, nextTextChunk) &&
					TextChunkUtils.areTextChunksHaveSameBaseLine(textChunk, nextTextChunk) &&
					TextChunkUtils.areNeighborsTextChunks(textChunk, nextTextChunk)) {
				textChunk = TextChunkUtils.unionTextChunks(textChunk, nextTextChunk);
				i++;
			} else {
				break;
			}
		}
		textValue.append(textChunk.getValue());
		getNode().addChild(new SemanticSpan(textChunk));
		children.add(new GFSATextChunk(textChunk, (parentsStandardTypes.isEmpty() ? "" :
				(parentsStandardTypes + '&')) + getstandardType()));
		return i - number - 1;
	}

	@Override
	public Double getcorrectSemanticScore() {
		return getNode().getCorrectSemanticScore();
	}

	@Override
	public String getvalueS() {
		COSName type = structElemDictionary.getCOSStructureType();
		return type != null ? type.getString() : null;
	}

	@Override
	public String getcorrectType() {
		SemanticType semanticType = getNode().getSemanticType();
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

	@Override
	public String getparentsStandardTypes() {
		return parentsStandardTypes;
	}

	@Override
	public String getkidsStandardTypes() {
			return this.getChildrenStandardTypes()
					.stream()
					.filter(type -> type != null && !TaggedPDFConstants.ARTIFACT.equals(type))
					.collect(Collectors.joining("&"));
	}

	private List<String> getChildrenStandardTypes() {
		return getChildrenStandardTypes(this);
	}

	private static List<String> getChildrenStandardTypes(GFSAStructElem element) {
		if (element.children == null) {
			element.parseChildren();
		}
		List<String> res = new ArrayList<>();
		for (Object child : element.children) {
			if (child instanceof GFSAStructElem) {
				String elementStandardType = ((GFSAStructElem) child).getstandardType();
				if (TaggedPDFConstants.NON_STRUCT.equals(elementStandardType) || TaggedPDFConstants.DIV.equals(elementStandardType)) {
					res.addAll(getChildrenStandardTypes((GFSAStructElem) child));
				} else {
					res.add(elementStandardType);
				}
			}
		}
		return Collections.unmodifiableList(res);
	}

	@Override
	public String getparentStandardType() {
		org.verapdf.pd.structure.PDStructElem parent = this.structElemDictionary.getParent();
		if (parent != null) {
			String parentStandardType = PDStructElem.getStructureElementStandardType(parent);
			while (TaggedPDFConstants.NON_STRUCT.equals(parentStandardType) || TaggedPDFConstants.DIV.equals(parentStandardType)) {
				parent = parent.getParent();
				if (parent == null) {
					return null;
				}
				parentStandardType = PDStructElem.getStructureElementStandardType(parent);
			}
			return parentStandardType;
		}
		return null;
	}

	public String getTextValue() {
		if (children == null) {
			parseChildren();
		}
		return textValue.toString();
	}

	@Override
	public Boolean gethasLowestDepthError() {
		return getNode().getHasLowestDepthError();
	}

	@Override
	public Long getpage() {
		Integer page = this.getObject().getBoundingBox().getPageNumber();
		if (page != null) {
			return Long.valueOf(page);
		}
		return null;
	}

	@Override
	public Long getlastPage() {
		Integer lastPage = this.getObject().getBoundingBox().getLastPageNumber();
		if (lastPage != null) {
			return Long.valueOf(lastPage);
		}
		return null;
	}

	public org.verapdf.pd.structure.PDStructElem getStructElemDictionary() {
		return structElemDictionary;
	}
}
