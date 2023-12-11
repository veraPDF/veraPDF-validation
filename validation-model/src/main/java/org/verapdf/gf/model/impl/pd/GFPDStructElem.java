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
import org.verapdf.cos.COSString;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSArray;
import org.verapdf.exceptions.LoopedException;
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
import org.verapdf.tools.StaticResources;
import org.verapdf.tools.TaggedPDFConstants;
import org.verapdf.tools.TaggedPDFHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Maksim Bezrukov
 */
public class GFPDStructElem extends GFPDStructTreeNode implements PDStructElem {
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
		if (StaticContainers.getFlavour() == PDFAFlavour.PDFUA_2) {
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

	/**
	 * @return Type entry of current structure element
	 */
	@Override
	public String getType() {
		ASAtom type = ((org.verapdf.pd.structure.PDStructElem) simplePDObject).getType();
		return type == null ? null : type.getValue();
	}

	@Override
	public String getparentStandardType() {
		org.verapdf.pd.structure.PDStructElem parent = ((org.verapdf.pd.structure.PDStructElem) simplePDObject).getParent();
		if (parent != null) {
			StructureType parentStandardStructureType = org.verapdf.pd.structure.PDStructElem.getStructureElementStandardStructureType(parent);
			String parentStandardType = parentStandardStructureType != null ? parentStandardStructureType.getType().getValue() : null;
			while (TaggedPDFConstants.NON_STRUCT.equals(parentStandardType) || TaggedPDFConstants.DIV.equals(parentStandardType)) {
				parent = parent.getParent();
				if (parent == null) {
					return null;
				}
				parentStandardStructureType = org.verapdf.pd.structure.PDStructElem.getStructureElementStandardStructureType(parent);
				parentStandardType = parentStandardStructureType != null ? parentStandardStructureType.getType().getValue() : null;
			}
			if (org.verapdf.pd.structure.PDStructElem.isMathStandardType(parentStandardStructureType)) {
				return TaggedPDFConstants.MATH_ML;
			}
			return parentStandardType;
		}
		return null;
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
	public Boolean getisRemappedStandardType() {
		if (hasStandardType()) {
			StructureType type = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getStructureType();
			if (type == null) {
				return false;
			}
			return !type.getType().getValue().equals(standardType);
		}
		return false;
	}

	private boolean hasStandardType(){
		StructureType type = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getStructureType();
		if (type == null) {
			return false;
		}
		PDFAFlavour flavour = StaticContainers.getFlavour();
		if (flavour != null) {
			if (flavour.getPart() == PDFAFlavour.Specification.ISO_19005_1) {
				return TaggedPDFHelper.getPdf14StandardRoleTypes().contains(type.getType().getValue());
			}
			if (flavour.getPart() == PDFAFlavour.Specification.ISO_19005_4 || flavour == PDFAFlavour.PDFUA_2) {
				return TaggedPDFHelper.isStandardType(type);
			}
			if (flavour.getPart() == PDFAFlavour.Specification.WCAG_2_1) {
				return TaggedPDFHelper.isWCAGStandardType(type) &&
						!TaggedPDFConstants.TITLE.equals(type.getType().getValue());
			}
		}
		return TaggedPDFHelper.getPdf17StandardRoleTypes().contains(type.getType().getValue());
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
		return type != null ? StaticResources.getRoleMapHelper().circularMappingExist(type.getType()) : null;
	}

	@Override
	public String getroleMapToSameNamespaceTag() {
		String namespace = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getRoleMapToSameNamespaceTag();
		return namespace != null ? namespace + ':' + getstandardType() : null;
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
	public String getparentLang() {
		COSString baseLang = null;
		Set<COSKey> keys = new HashSet<>();
		COSKey key = this.simplePDObject.getObject().getObjectKey();
		if (key != null) {
			keys.add(key);
		}
		org.verapdf.pd.structure.PDStructElem parent = ((org.verapdf.pd.structure.PDStructElem) this.simplePDObject).getParent();
		while (baseLang == null && parent != null) {
			key = parent.getObject().getObjectKey();
			if (keys.contains(key)) {
				throw new LoopedException("Struct tree loop found");
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
