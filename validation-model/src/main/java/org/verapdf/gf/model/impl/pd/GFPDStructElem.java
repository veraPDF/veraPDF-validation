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
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.gf.model.impl.pd.gfse.*;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosActualText;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.pdlayer.PDStructElem;
import org.verapdf.pd.structure.StructureType;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.tools.TaggedPDFConstants;
import org.verapdf.tools.TaggedPDFHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Maksim Bezrukov
 */
public class GFPDStructElem extends GFPDObject implements PDStructElem {
	/**
	 * Type name for {@code GFPDStructElem}
	 */
	public static final String STRUCTURE_ELEMENT_TYPE = "PDStructElem";

	/**
	 * Link name for {@code K} key
	 */
	public static final String CHILDREN = "K";
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

	private final String standardType;

	private List<GFPDStructElem> children;

	protected GFPDStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary, String standardType, String type) {
		super(structElemDictionary, type);
		ASAtom subtype = this.simplePDObject.getNameKey(ASAtom.S);
		if (subtype != null) {
			this.id = (super.getID() != null ? super.getID() : "0 0 obj") + " " + ((COSName) COSName.fromValue(subtype)).getUnicodeValue();
		}
		this.standardType = standardType;
	}

	/**
	 * Default constructor
	 *
	 * @param structElemDictionary dictionary of structure element
	 */
	public GFPDStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary) {
		this(structElemDictionary, null, STRUCTURE_ELEMENT_TYPE);
	}

    public static GFSEGeneral createTypedStructElem(org.verapdf.pd.structure.PDStructElem structElemDictionary){
        String standardType = GFPDStructElem.getStructureElementStandardType(structElemDictionary);

        if (standardType == null) {
            return new GFSENonStandard(structElemDictionary, null);
        }

        switch (standardType) {
            case TaggedPDFConstants.ANNOT:
                return new GFSEAnnot(structElemDictionary);
            case TaggedPDFConstants.ART:
                return new GFSEArt(structElemDictionary);
            case TaggedPDFConstants.ARTIFACT:
                return new GFSEArtifact(structElemDictionary);
            case TaggedPDFConstants.ASIDE:
                return new GFSEAside(structElemDictionary);
            case TaggedPDFConstants.BIB_ENTRY:
                return new GFSEBibEntry(structElemDictionary);
            case TaggedPDFConstants.BLOCK_QUOTE:
                return new GFSEBlockQuote(structElemDictionary);
            case TaggedPDFConstants.CAPTION:
                return new GFSECaption(structElemDictionary);
            case TaggedPDFConstants.CODE:
                return new GFSECode(structElemDictionary);
            case TaggedPDFConstants.DIV:
                return new GFSEDiv(structElemDictionary);
            case TaggedPDFConstants.DOCUMENT:
                return new GFSEDocument(structElemDictionary);
            case TaggedPDFConstants.DOCUMENT_FRAGMENT:
                return new GFSEDocumentFragment(structElemDictionary);
            case TaggedPDFConstants.EM:
                return new GFSEEm(structElemDictionary);
            case TaggedPDFConstants.FENOTE:
                return new GFSEFENote(structElemDictionary);
            case TaggedPDFConstants.FIGURE:
                return new GFSEFigure(structElemDictionary);
            case TaggedPDFConstants.FORM:
                return new GFSEForm(structElemDictionary);
            case TaggedPDFConstants.FORMULA:
                return new GFSEFormula(structElemDictionary);
            case TaggedPDFConstants.H:
                return new GFSEH(structElemDictionary);
            case TaggedPDFConstants.INDEX:
                return new GFSEIndex(structElemDictionary);
            case TaggedPDFConstants.L:
                return new GFSEL(structElemDictionary);
            case TaggedPDFConstants.LBL:
                return new GFSELbl(structElemDictionary);
            case TaggedPDFConstants.LBODY:
                return new GFSELBody(structElemDictionary);
            case TaggedPDFConstants.LI:
                return new GFSELI(structElemDictionary);
            case TaggedPDFConstants.LINK:
                return new GFSELink(structElemDictionary);
            case TaggedPDFConstants.NON_STRUCT:
                return new GFSENonStruct(structElemDictionary);
            case TaggedPDFConstants.NOTE:
                return new GFSENote(structElemDictionary);
            case TaggedPDFConstants.P:
                return new GFSEP(structElemDictionary);
            case TaggedPDFConstants.PART:
                return new GFSEPart(structElemDictionary);
            case TaggedPDFConstants.PRIVATE:
                return new GFSEPrivate(structElemDictionary);
            case TaggedPDFConstants.QUOTE:
                return new GFSEQuote(structElemDictionary);
            case TaggedPDFConstants.RB:
                return new GFSERB(structElemDictionary);
            case TaggedPDFConstants.REFERENCE:
                return new GFSEReference(structElemDictionary);
            case TaggedPDFConstants.RP:
                return new GFSERP(structElemDictionary);
            case TaggedPDFConstants.RT:
                return new GFSERT(structElemDictionary);
            case TaggedPDFConstants.RUBY:
                return new GFSERuby(structElemDictionary);
            case TaggedPDFConstants.SECT:
                return new GFSESect(structElemDictionary);
            case TaggedPDFConstants.SPAN:
                return new GFSESpan(structElemDictionary);
            case TaggedPDFConstants.STRONG:
                return new GFSEStrong(structElemDictionary);
            case TaggedPDFConstants.SUB:
                return new GFSESub(structElemDictionary);
            case TaggedPDFConstants.TABLE:
                return new GFSETable(structElemDictionary);
            case TaggedPDFConstants.TBODY:
                return new GFSETBody(structElemDictionary);
            case TaggedPDFConstants.TD:
                return new GFSETD(structElemDictionary);
            case TaggedPDFConstants.TFOOT:
                return new GFSETFoot(structElemDictionary);
            case TaggedPDFConstants.TH:
                return new GFSETH(structElemDictionary);
            case TaggedPDFConstants.THEAD:
                return new GFSETHead(structElemDictionary);
            case TaggedPDFConstants.TITLE:
                return new GFSETitle(structElemDictionary);
            case TaggedPDFConstants.TOC:
                return new GFSETOC(structElemDictionary);
            case TaggedPDFConstants.TOCI:
                return new GFSETOCI(structElemDictionary);
            case TaggedPDFConstants.TR:
                return new GFSETR(structElemDictionary);
            case TaggedPDFConstants.WARICHU:
                return new GFSEWarichu(structElemDictionary);
            case TaggedPDFConstants.WP:
                return new GFSEWP(structElemDictionary);
            case TaggedPDFConstants.WT:
                return new GFSEWT(structElemDictionary);
            default:
                if (standardType.matches(TaggedPDFConstants.HN_REGEXP)) {
                    return new GFSEHn(structElemDictionary, standardType);
                } else {
                    return new GFSENonStandard(structElemDictionary, standardType);
                }
        }
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
	public String getkidsStandardTypes() {
		if (StaticContainers.getFlavour() != null &&
		    StaticContainers.getFlavour().getPart() == PDFAFlavour.Specification.WCAG_2_1) {
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
	public String getparentStandardType() {
		org.verapdf.pd.structure.PDStructElem parent = ((org.verapdf.pd.structure.PDStructElem) simplePDObject).getParent();
		if (parent != null) {
			String parentStandardType = getStructureElementStandardType(parent);
			while (TaggedPDFConstants.NON_STRUCT.equals(parentStandardType)) {
				parent = parent.getParent();
				if (parent == null) {
					return null;
				}
				parentStandardType = getStructureElementStandardType(parent);
			}
			return parentStandardType;
		}
		return null;
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
		if (children.getType() == COSObjType.COS_ARRAY) {
			for (COSObject elem : (COSArray)children.getDirectBase()) {
				if (TaggedPDFHelper.isContentItem(elem)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String getstandardType() {
		return this.standardType;
	}

	@Override
	public Boolean getisRemappedStandardType() {
		StructureType type = ((org.verapdf.pd.structure.PDStructElem)simplePDObject).getStructureType();
		if (type == null) {
			return false;
		}
		boolean isStandardType;
		if (StaticContainers.getFlavour() != null && StaticContainers.getFlavour().getPart() == PDFAFlavour.Specification.WCAG_2_1) {
			isStandardType = TaggedPDFHelper.isWCAGStandardType(type) && !TaggedPDFConstants.TITLE.equals(type.getType().getValue());
		} else {
			isStandardType =  TaggedPDFHelper.isStandardType(type);
		}
		if (isStandardType) {
			String actualType = type.getType().getValue();
			return !actualType.equals(standardType);
		}
		return false;
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
		return type != null ? StaticContainers.getRoleMapHelper().circularMappingExist(type.getType()) : null;
	}

	public static String getStructureElementStandardType(org.verapdf.pd.structure.PDStructElem pdStructElem){
		if (StaticContainers.getFlavour().getPart() == PDFAFlavour.Specification.ISO_19005_4) {
			StructureType defaultStructureType = pdStructElem.getDefaultStructureType();
			if (defaultStructureType != null) {
				return defaultStructureType.getType().getValue();
			}
		} else {
			StructureType type = pdStructElem.getStructureType();
			if (type != null) {
				return StaticContainers.getRoleMapHelper().getStandardType(type.getType(),
						StaticContainers.getFlavour() != null &&
						StaticContainers.getFlavour().getPart() == PDFAFlavour.Specification.ISO_19005_1,
						StaticContainers.getFlavour() != null &&
						StaticContainers.getFlavour().getPart() == PDFAFlavour.Specification.WCAG_2_1);
			}
		}
		return null;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case CHILDREN:
				return this.getChildren();
			case STRUCTURE_TYPE:
				return this.getStructureType();
			case LANG:
				return this.getLang();
			case ACTUAL_TEXT:
				return this.getactualText();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<String> getChildrenStandardTypes() {
		return getChildrenStandardTypes(this);
	}

	private static List<String> getChildrenStandardTypes(GFPDStructElem element) {
		List<String> res = new ArrayList<>();
		for (GFPDStructElem child : element.getChildren()) {
			String elementStandardType = child.getstandardType();
			if (TaggedPDFConstants.NON_STRUCT.equals(elementStandardType)) {
				res.addAll(getChildrenStandardTypes(child));
			} else {
				res.add(elementStandardType);
			}
		}
		return Collections.unmodifiableList(res);
	}

	public List<GFPDStructElem> getChildren() {
		if (children == null) {
			List<org.verapdf.pd.structure.PDStructElem> elements = ((org.verapdf.pd.structure.PDStructElem) simplePDObject).getStructChildren();
			if (!elements.isEmpty()) {
				List<GFPDStructElem> res = new ArrayList<>(elements.size());
				for (org.verapdf.pd.structure.PDStructElem element : elements) {
					res.add(createTypedStructElem(element));
				}
				children = Collections.unmodifiableList(res);
			} else {
				children = Collections.emptyList();
			}
		}
		return children;
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
}
