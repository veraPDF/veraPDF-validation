/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
import org.verapdf.cos.COSString;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSArray;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosActualText;
import org.verapdf.gf.model.impl.cos.GFCosAlt;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosActualText;
import org.verapdf.model.coslayer.CosAlt;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.pdlayer.PDStructElem;
import org.verapdf.pd.structure.StructureType;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.flavours.PDFFlavours;
import org.verapdf.tools.StaticResources;
import org.verapdf.tools.TaggedPDFConstants;
import org.verapdf.tools.TaggedPDFHelper;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class GFPDStructElem extends GFPDStructTreeNode implements PDStructElem {

	private static final Logger LOGGER = Logger.getLogger(GFPDStructElem.class.getCanonicalName());

	/**
	 * Type name for {@code GFPDStructElem}
	 */
	public static final String STRUCTURE_ELEMENT_TYPE = "PDStructElem";

	/**
	 * Link name for {@code S} key
	 */
	public static final String STRUCTURE_TYPE = "S";
	/**
	 * Link name for {@code Lang} key
	 */
	public static final String LANG = "Lang";
	/**
	 * Link name for {@code ActualText} key
	 */
	public static final String ACTUAL_TEXT = "actualText";
	public static final String ALT = "alt";

	private final String standardType;

	protected GFPDStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary, String standardType, String type) {
		super(structElemDictionary, type);
		ASAtom subtype = this.simplePDObject.getNameKey(ASAtom.S);
		if (subtype != null) {
			this.id = (super.getID() != null ? super.getID() : "0 0 obj") + ' ' + ((COSName) COSName.fromValue(subtype)).getUnicodeValue();
		}
		this.standardType = standardType;
		if (PDFFlavours.isPDFUA2RelatedFlavour(StaticContainers.getFlavour())) {
			fillStructElemRefs();
		}
	}

	/**
	 * Default constructor
	 *
	 * @param structElemDictionary dictionary of structure element
	 */
	public GFPDStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary) {
		this(structElemDictionary, null, STRUCTURE_ELEMENT_TYPE);
	}

	@Override
	public String getparentStandardType() {
		org.verapdf.pd.structure.PDStructElem parent = ((org.verapdf.pd.structure.PDStructElem) simplePDObject).getParent();
		if (parent != null) {
			StructureType parentStandardStructureType = org.verapdf.pd.structure.PDStructElem.getStructureElementStandardStructureType(parent);
			String parentStandardType = parentStandardStructureType != null ? parentStandardStructureType.getType().getValue() : null;
			while (org.verapdf.pd.structure.PDStructElem.isPassThroughTag(parentStandardType)) {
				parent = parent.getParent();
				if (parent == null) {
					return null;
				}
				parentStandardStructureType = org.verapdf.pd.structure.PDStructElem.getStructureElementStandardStructureType(parent);
				parentStandardType = parentStandardStructureType != null ? parentStandardStructureType.getType().getValue() : null;
			}
			if (parent.getType() == ASAtom.STRUCT_TREE_ROOT) {
				return ASAtom.STRUCT_TREE_ROOT.getValue();
			}
			if (org.verapdf.pd.structure.PDStructElem.isMathStandardType(parentStandardStructureType)) {
				return TaggedPDFConstants.MATH_ML;
			}
			return parentStandardType;
		}
		return null;
	}

	@Override
	public String getnamespaceAndTag() {
		StructureType type = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getStructureType();
		if (type != null) {
			return String.format("%s:%s", type.getNameSpaceURI() != null ? type.getNameSpaceURI() : "null", 
					type.getType() != null ? type.getType() : "null");
		}
		return null;
	}

	@Override
	public Boolean getcontainsParent() {
		return ((org.verapdf.pd.structure.PDStructElem) simplePDObject).getParent() != null;
	}
	
	@Override
	public String getvalueS() {
		COSName type = ((org.verapdf.pd.structure.PDStructElem) this.simplePDObject).getCOSStructureType();
		return type != null ? type.getString() : null;
	}

	@Override
	public String getstandardType() {
		return this.standardType;
	}
	
	public String getStandardTypeNamespaceURL() {
		StructureType standardStructureType = org.verapdf.pd.structure.PDStructElem.getStructureElementStandardStructureType(
				(org.verapdf.pd.structure.PDStructElem) this.simplePDObject);
		return standardStructureType != null ? standardStructureType.getNameSpaceURI() : null;
	}

	@Override
	public String getremappedStandardType() {
		StructureType standardStructureType = org.verapdf.pd.structure.PDStructElem.getStructureElementStandardStructureType(
				((org.verapdf.pd.structure.PDStructElem)simplePDObject));
		if (hasStandardType()) {
			StructureType type = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getStructureType();
			if (type == null) {
				return null;
			}
			if (standardStructureType == null || !Objects.equals(type.getType(), standardStructureType.getType()) || 
					!Objects.equals(type.getNameSpaceURI(), standardStructureType.getNameSpaceURI())) {
				return type.getType().getValue();
			}
		} else if (standardType != null) {
			StructureType standardTypeMap = org.verapdf.pd.structure.PDStructElem.getStructureTypeStandardStructureType(standardStructureType);
			if (standardTypeMap == null || !Objects.equals(standardTypeMap.getType(), standardStructureType.getType()) ||
					!Objects.equals(standardTypeMap.getNameSpaceURI(), standardStructureType.getNameSpaceURI())) {
				return standardType;
			}
		}
		return null;
	}

	private boolean hasStandardType() {
		StructureType type = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getStructureType();
		if (type == null) {
			return false;
		}
		if (PDFFlavours.isWCAGFlavour(StaticContainers.getFlavour()) && ASAtom.TITLE == type.getType()) {
			return false;
		}
		return org.verapdf.pd.structure.PDStructElem.isStandardStructureType(type);
	}

	@Override
	public String getAlt() {
		return ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getAlternateDescription();
	}

	@Override
	public String getActualText() {
		return ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getActualText().getString();
	}

	@Override
	public String getE() {
		return ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getExpandedAbbreviation();
	}

	@Override
	public Boolean getcircularMappingExist() {
		StructureType type = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getStructureType();
		if (type != null) {
			if (StaticResources.getRoleMapHelper().circularMappingExist(type.getType())) {
				return true;
			}
			if (PDFFlavours.isPDFSpecification(StaticContainers.getFlavour(), PDFAFlavour.PDFSpecification.ISO_32000_2_0) && 
					TaggedPDFHelper.isCircularMappingExist(type)) {
				return true;
			}
			return false;
		}
		return null;
	}

	@Override
	public String getroleMapToSameNamespaceTag() {
		return ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getRoleMapToSameNamespaceTag();
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case STRUCTURE_TYPE:
				return this.getStructureType();
			case LANG:
				return this.getLang();
			case ACTUAL_TEXT:
				return this.getactualText();
			case ALT:
				return this.getalt();				
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosUnicodeName> getStructureType() {
		COSName type = ((org.verapdf.pd.structure.PDStructElem) this.simplePDObject).getCOSStructureType();
		if (type != null) {
			List<CosUnicodeName> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosUnicodeName(type));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<CosLang> getLang() {
		COSString baseLang = ((org.verapdf.pd.structure.PDStructElem) this.simplePDObject).getLang();
		if (baseLang != null) {
			List<CosLang> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosLang(baseLang));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsLang() {
		return ((org.verapdf.pd.structure.PDStructElem) this.simplePDObject).getLang() != null;
	}

	@Override
	public String getparentLang() {
		Set<COSKey> keys = new HashSet<>();
		COSKey key = this.simplePDObject.getObject().getObjectKey();
		if (key != null) {
			keys.add(key);
		}
		org.verapdf.pd.structure.PDStructElem parent = ((org.verapdf.pd.structure.PDStructElem) this.simplePDObject).getParent();
		COSString baseLang = null;
		while (baseLang == null && parent != null) {
			key = parent.getObject().getObjectKey();
			if (keys.contains(key)) {
				LOGGER.log(Level.WARNING, "Struct tree loop found");
				break;
			}
			if (key != null) {
				keys.add(key);
			}
			baseLang = parent.getLang();
			parent = parent.getParent();
		}
		if (baseLang != null) {
			return baseLang.getString();
		}
		return null;
	}

	private List<CosActualText> getactualText() {
		COSObject actualText = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getActualText();
		if (actualText != null && COSObjType.COS_STRING == actualText.getType()) {
			List<CosActualText> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosActualText((COSString)actualText.getDirectBase()));
			return list;
		}
		return Collections.emptyList();
	}
	
	private void fillStructElemRefs() {
		COSKey key = simpleCOSObject.getKey();
		if (key == null) {
			return;
		}
		COSObject ref = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getRef();
		if (ref.getType() == COSObjType.COS_ARRAY) {
			for (COSObject elem : (COSArray)ref.getDirectBase()) {
				if (elem.getKey() != null) {
					StaticContainers.getStructElementsRefs().computeIfAbsent(elem.getKey(), k -> new HashSet<>()).add(key);
				}
			}
		}
	}

	private List<CosAlt> getalt() {
		COSObject alt = simplePDObject.getKey(ASAtom.ALT);
		if (alt != null && COSObjType.COS_STRING == alt.getType()) {
			List<CosAlt> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosAlt((COSString)alt.getDirectBase()));
			return list;
		}
		return Collections.emptyList();
	}
}
