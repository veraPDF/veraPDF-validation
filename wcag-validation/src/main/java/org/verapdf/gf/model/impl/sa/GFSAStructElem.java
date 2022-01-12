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
import org.verapdf.wcag.algorithms.entities.SemanticFigure;
import org.verapdf.wcag.algorithms.entities.SemanticImageNode;
import org.verapdf.wcag.algorithms.entities.SemanticSpan;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.ImageChunk;
import org.verapdf.wcag.algorithms.entities.content.LineArtChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;
import org.verapdf.wcag.algorithms.entities.enums.SemanticType;
import org.verapdf.wcag.algorithms.entities.maps.SemanticTypeMapper;
import org.verapdf.wcag.algorithms.semanticalgorithms.utils.TextChunkUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Maxim Plushchov
 */
public class GFSAStructElem extends GenericModelObject implements SAStructElem {

    public static final String CHILDREN = "children";
	public static final String START = "START";
	public static final String MIDDLE = "MIDDLE";
	public static final String END = "END";

	private final org.verapdf.pd.structure.PDStructElem structElemDictionary;

	protected List<Object> children = null;

	private INode node;

	private final String id;
	private final String standardType;
	private final StringBuilder textValue = new StringBuilder();
	private final boolean isTableChild;
	private final boolean isListChild;
	private boolean isLeafNode = true;
	private final String parentsStandardTypes;

	private int maxSpaceStartIndex;
	private int maxSpaceEndIndex;

	public GFSAStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary, String standardType,
	                      String type, String parentsStandardTypes) {
		super(type);
		this.structElemDictionary = structElemDictionary;
		this.standardType = standardType;
		COSKey key = structElemDictionary.getObject().getObjectKey();
		id = (key != null ? (key.getNumber() + " " + key.getGeneration()) : "0 0") + " obj" +
		     (standardType != null ? (" " + standardType) : "") +
		     (getStructureType() != null ? (" " + ((COSName) COSName.fromValue(getStructureType())).getUnicodeValue()) : "");
		this.isTableChild = Arrays.asList(parentsStandardTypes.split("&")).contains(TaggedPDFConstants.TABLE);
		this.isListChild = Arrays.asList(parentsStandardTypes.split("&")).contains(TaggedPDFConstants.L);
		this.parentsStandardTypes = parentsStandardTypes;
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

	@Override
	public Long getstructureID() {
		return node.getRecognizedStructureId();
	}

	public static String getStructureElementStandardType(org.verapdf.pd.structure.PDStructElem pdStructElem){
		StructureType type = pdStructElem.getStructureType();
		if (type != null) {
			return StaticStorages.getRoleMapHelper().getStandardType(type.getType(), false, true);
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
					GFSAStructElem structElem = GFSAGeneral.createTypedStructElem((org.verapdf.pd.structure.PDStructElem)element,
							(parentsStandardTypes.isEmpty() ? "" : (parentsStandardTypes + "&")) + standardType);
					INode childNode = new GFSANode(structElem);
					structElem.setNode(childNode);
					node.addChild(childNode);
					children.add(structElem);
					isLeafNode = false;
				} else if (element instanceof PDMCRDictionary) {
					PDMCRDictionary mcr = (PDMCRDictionary) element;
					COSKey streamKey = mcr.getStreamObjectKey();
					if (streamKey != null) {
						addChunksToChildren(streamKey, mcr.getMCID());
					} else {
						addChunksToChildren(mcr.getPageObjectKey(), mcr.getMCID());
					}
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
					TextChunk textChunk = (TextChunk) chunk;
					node.addChild(new SemanticSpan(textChunk));
					children.add(new GFSATextChunk(textChunk, (parentsStandardTypes.isEmpty() ? "" :
							(parentsStandardTypes + "&")) + standardType));
					textValue.append(textChunk.getValue());
				} else if (chunk instanceof ImageChunk) {
					node.addChild(new SemanticImageNode((ImageChunk) chunk));
					children.add(new GFSAImageChunk((ImageChunk) chunk));
				} else if (chunk instanceof LineArtChunk) {
					node.addChild(new SemanticFigure((LineArtChunk) chunk));
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

	@Override
	public Long getnumberOfSameCharacters() {
		return GFSAStructElem.getNumberOfSameCharacters(getTextValue());
	}

	@Override
	public String getparentsStandardTypes() {
		return parentsStandardTypes;
	}

	public String getTextValue() {
		if (children == null) {
			parseChildren();
		}
		return textValue.toString();
	}

	private static long getNumberOfSameCharacters(String value) {
		if (value == null || value.isEmpty()) {
			return 0;
		}
		char[] characters = value.toCharArray();
		char lastCharacter = characters[0];
		int maxLength = 0;
		int length = 0;
		for (char character : characters) {
			if (lastCharacter == character) {
				length++;
			} else {
				if (length > maxLength && !TextChunkUtils.isWhiteSpaceChar(lastCharacter)) {
					maxLength = length;
				}
				length = 1;
				lastCharacter = character;
			}
		}
		if (length > maxLength && !TextChunkUtils.isWhiteSpaceChar(lastCharacter)) {
			maxLength = length;
		}
		return maxLength;
	}

	@Override
	public Long getnumberOfRepeatedSpaces() {
		return getNumberOfRepeatedSpaces(getTextValue());
	}

	private long getNumberOfRepeatedSpaces(String value) {
		int[] indexes = getIndexesOfLongestSequenceOfSpaces(value);
		maxSpaceStartIndex = indexes[0];
		maxSpaceEndIndex = indexes[1];
		if (maxSpaceStartIndex == -1) {
			return 0;
		}
		return (long)maxSpaceEndIndex - maxSpaceStartIndex;
	}

	@Override
	public String getpositionOfRepeatedSpaces() {
		return getPositionOfRepeatedSpaces(getTextValue());
	}

	private String getPositionOfRepeatedSpaces(String value) {
		if (maxSpaceStartIndex == 0) {
			return START;
		}
		if (maxSpaceEndIndex == value.length()) {
			return END;
		}
		return MIDDLE;
	}

	private static int[] getIndexesOfLongestSequenceOfSpaces(String value) {
		if (value == null || value.isEmpty() || value.indexOf(' ') == -1) {
			return new int[]{-1, -1};
		}
		int firstMaxIndex = -1;
		int secondMaxIndex = -1;
		Pattern pattern = Pattern.compile("[\\s+\\u00A0\\u2007\\u202F\\u001C\\u001D\\u001E\\u001F]+");
		Matcher matcher = pattern.matcher(value);
		while (matcher.find()) {
			if (matcher.end() - matcher.start() > secondMaxIndex - firstMaxIndex) {
				firstMaxIndex = matcher.start();
				secondMaxIndex = matcher.end();
			}
		}
		return new int[]{firstMaxIndex, secondMaxIndex};
	}

	@Override
	public Boolean gethasLowestDepthError() {
		return node.getHasLowestDepthError();
	}
}
