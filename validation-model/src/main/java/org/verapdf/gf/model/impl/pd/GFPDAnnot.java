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
import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosBM;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.pd.actions.GFPDAction;
import org.verapdf.gf.model.impl.pd.actions.GFPDAdditionalActions;
import org.verapdf.gf.model.impl.pd.annotations.*;
import org.verapdf.gf.model.impl.pd.gfse.GFSEFactory;
import org.verapdf.gf.model.impl.pd.images.GFPDXForm;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosBM;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.pdlayer.*;
import org.verapdf.pd.PDPage;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDAppearanceEntry;
import org.verapdf.pd.PDAppearanceStream;
import org.verapdf.pd.actions.PDAnnotationAdditionalActions;
import org.verapdf.pd.annotations.PDWidgetAnnotation;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.tools.StaticResources;
import org.verapdf.tools.TaggedPDFConstants;
import org.verapdf.tools.TaggedPDFRoleMapHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Maksim Bezrukov
 */
public class GFPDAnnot extends GFPDObject implements PDAnnot {
	public static final String ANNOTATION_TYPE = "PDAnnot";

	public static final String DICT = "Dict";
	public static final String STREAM = "Stream";

	public static final String APPEARANCE = "appearance";
	public static final String A = "A";
	public static final String ADDITIONAL_ACTION = "AA";
	public static final String LANG = "Lang";
	public static final String BM = "BM";
	public static final String TYPE_3D = "3D";
	public static final String CARET = "Caret";
	public static final String CIRCLE = "Circle";
	public static final String FILE_ATTACHMENT = "FileAttachment";
	public static final String FREE_TEXT = "FreeText";
	public static final String HIGHLIGHT = "Highlight";
	public static final String INK = "Ink";
	public static final String LINE = "Line";
	public static final String LINK = "Link";
	public static final String MOVIE = "Movie";
	public static final String POLYGON = "Polygon";
	public static final String POLYLINE = "PolyLine";
	public static final String POPUP = "Popup";
	public static final String PRINTER_MARK = "PrinterMark";
	public static final String REDACT = "Redact";
	public static final String RICH_MEDIA = "RichMedia";
	public static final String SCREEN = "Screen";
	public static final String SOUND = "Sound";
	public static final String STAMP = "Stamp";
	public static final String STRIKE_OUT = "StrikeOut";
	public static final String SQUARE = "Square";
	public static final String SQUIGGLY = "Squiggly";
	public static final String TEXT = "Text";
	public static final String TRAP_NET = "TrapNet";
	public static final String UNDERLINE = "Underline";
	public static final String WIDGET = "Widget";

	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;

	protected final PDResourcesHandler resources;
	private final PDPage page;

	private List<CosBM> blendMode = null;
	private List<PDXForm> appearance = null;
	private boolean containsTransparency = false;

	public GFPDAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page) {
		this(annot, pageResources, page, ANNOTATION_TYPE);
	}

	public GFPDAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page, String type) {
		super(annot, type);
		this.resources = pageResources;
		this.page = page;
	}

	@Override
	public String getSubtype() {
		ASAtom subtype = ((PDAnnotation) simplePDObject).getSubtype();
		return subtype == null ? null : subtype.getValue();
	}

	@Override
	public String getAP() {
		COSObject apLocal = ((PDAnnotation) simplePDObject).getCOSAP();
		if (apLocal != null) {
			return apLocal.getKeySet().stream().map(ASAtom::getValue).collect(Collectors.joining("&"));
		}
		return null;
	}

	@Override
	public Long getF() {
		return ((PDAnnotation) simplePDObject).getF();
	}

	@Override
	public Double getCA() {
		return ((PDAnnotation) simplePDObject).getCA();
	}

	@Override
	public String getN_type() {
		PDAppearanceEntry normalAppearance = ((PDAnnotation) simplePDObject).getNormalAppearance();
		if (normalAppearance == null) {
			return null;
		} else if (normalAppearance.isSubDictionary()) {
			return DICT;
		} else {
			return STREAM;
		}
	}

	@Override
	public Boolean getcontainsC() {
		return ((PDAnnotation) simplePDObject).getCOSC() != null;
	}

	@Override
	public Boolean getcontainsIC() {
		return ((PDAnnotation) simplePDObject).getCOSIC() != null;
	}

	@Override
	public String getFT() {
		ASAtom ft = ((PDAnnotation) simplePDObject).getFT();
		return ft == null ? null : ft.getValue();
	}

	@Override
	public Double getwidth() {
		return getDifference(((PDAnnotation) simplePDObject).getRect(), X_AXIS);
	}

	@Override
	public Double getheight() {
		return getDifference(((PDAnnotation) simplePDObject).getRect(), Y_AXIS);
	}

	@Override
	public Boolean getcontainsAA() {
		return this.simplePDObject.knownKey(ASAtom.AA);
	}

	@Override
	public String getstructParentType() {
		COSObject parentDictionary = getParentDictionary();
		return parentDictionary != null ? parentDictionary.getNameKeyStringValue(ASAtom.S) : null;
	}

	@Override
	public String getstructParentStandardType() {
		TaggedPDFRoleMapHelper taggedPDFRoleMapHelper = StaticResources.getRoleMapHelper();
		if (taggedPDFRoleMapHelper != null) {
			COSObject parentDictionary = getParentDictionary();
			if (parentDictionary != null) {
				PDStructElem structElem = new PDStructElem(parentDictionary, taggedPDFRoleMapHelper.getRoleMap());
				return GFSEFactory.getStructureElementStandardType(structElem);
			}
		}
		return null;
	}

	@Override
	public String getstructParentObjectKey() {
		TaggedPDFRoleMapHelper taggedPDFRoleMapHelper = StaticResources.getRoleMapHelper();
		if (taggedPDFRoleMapHelper != null) {
			COSObject parentDictionary = getParentDictionary();
			if (parentDictionary != null) {
				COSKey parentKey = parentDictionary.getObjectKey();
				return parentKey != null ? parentKey.toString() : null;
			}
		}
		return null;
	}

	protected COSObject getParentDictionary() {
		PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
		Long structParent = ((PDAnnotation) this.simplePDObject).getStructParent();
		if (structTreeRoot != null && structParent != null) {
			PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
			COSObject structureElement = parentTreeRoot == null ? null : parentTreeRoot.getObject(structParent);
			if (structureElement != null && structureElement.getType() == COSObjType.COS_DICT) {
				return structureElement;
			}
		}
		return null;
	}

	private List<CosLang> getLang() {
		PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
		Long structParent = ((PDAnnotation)this.simplePDObject).getStructParent();
		if (structTreeRoot != null && structParent != null) {
			PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
			COSObject structureElement = parentTreeRoot == null ? null : parentTreeRoot.getObject(structParent);
			if (structureElement != null) {
				COSObject baseLang = structureElement.getKey(ASAtom.LANG);
				if (baseLang != null && baseLang.getType() == COSObjType.COS_STRING) {
					List<CosLang> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
					list.add(new GFCosLang((COSString) baseLang.getDirectBase()));
					return Collections.unmodifiableList(list);
				}
			}
		}
		return Collections.emptyList();
	}

	private List<CosBM> getBM() {
		if (blendMode == null) {
			blendMode = parseBM();
		}
		return blendMode;
	}

	private List<CosBM> parseBM() {
		if (StaticContainers.getFlavour().getPart() != PDFAFlavour.Specification.ISO_19005_4) {
			return Collections.emptyList();
		}
		COSObject BM = ((PDAnnotation)simplePDObject).getBM();
		if (BM != null && BM.getType() == COSObjType.COS_NAME) {
			if (!ASAtom.NORMAL.equals(BM.getName())) {
				this.containsTransparency = true;
			}
			List<CosBM> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosBM((COSName)BM.getDirectBase()));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public String getContents() {
		return ((PDAnnotation) simplePDObject).getContents();
	}

	@Override
	public String getAlt() {
		PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
		Long structParent = ((PDAnnotation)this.simplePDObject).getStructParent();
		if (structTreeRoot != null && structParent != null) {
			PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
			COSObject structureElement = parentTreeRoot == null ? null : parentTreeRoot.getObject(structParent);
			if (structureElement != null) {
				COSObject baseAlt = structureElement.getKey(ASAtom.ALT);
				if (baseAlt != null && baseAlt.getType() == COSObjType.COS_STRING) {
					return baseAlt.getDirectBase().toString();
				}
			}
		}
		return null;
	}

	@Override
	public Boolean getisOutsideCropBox() {
		double[] cropBox = page.getCropBox();
		double[] rectangle = ((PDAnnotation)simplePDObject).getRect();
		if (rectangle != null && rectangle.length >= 4) {
			return cropBox[1] >= rectangle[3] || cropBox[0] >= rectangle[2]
					|| cropBox[3] <= rectangle[1] || cropBox[2] <= rectangle[0];
		}
		return null;
	}

	private static Double getDifference(double[] array, int shift) {
		if (array != null && array.length > shift + 2) {
			return Double.valueOf(array[shift + 2] - array[shift]);
		}
		return null;
	}

	@Override
	public Boolean getcontainsA() {
		return this.simplePDObject.knownKey(ASAtom.A);
	}

	@Override
	public Boolean getisArtifact() {
		TaggedPDFRoleMapHelper taggedPDFRoleMapHelper = StaticResources.getRoleMapHelper();
		if (taggedPDFRoleMapHelper != null) {
			COSObject parentDictionary = getParentDictionary();
			if (parentDictionary != null) {
				PDStructElem structElem = new PDStructElem(parentDictionary, taggedPDFRoleMapHelper.getRoleMap());
				while (structElem != null) {
					if (TaggedPDFConstants.ARTIFACT.equals(GFSEFactory.getStructureElementStandardType(structElem))) {
						return true;
					}
					structElem = structElem.getParent();
				}
			}
		}
		return false;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ADDITIONAL_ACTION:
				return this.getAdditionalActions();
			case A:
				return this.getA();
			case APPEARANCE:
				return this.getAppearance();
			case LANG:
				return this.getLang();
			case BM:
				return this.getBM();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDAdditionalActions> getAdditionalActions() {
		PDAnnotationAdditionalActions additionalActions = ((PDAnnotation) simplePDObject).getAdditionalActions();
		if (additionalActions != null) {
			List<PDAdditionalActions> actions = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			actions.add(new GFPDAdditionalActions(additionalActions));
			return Collections.unmodifiableList(actions);
		}
		return Collections.emptyList();
	}

	private List<PDAction> getA() {
		org.verapdf.pd.actions.PDAction action = ((PDAnnotation) simplePDObject).getA();
		if (action != null) {
			List<PDAction> res = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			res.add(GFPDAction.getAction(action));
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	/**
	 * @return normal appearance stream (N key in the appearance dictionary) of
	 * the annotation
	 */
	private List<PDXForm> getAppearance() {
		if (this.appearance == null) {
			this.appearance = parseAppearance();
		}
		return this.appearance;
	}

	boolean isContainsTransparency() {
		if (this.appearance == null) {
			this.appearance = parseAppearance();
		}
		if (this.blendMode == null) {
			this.blendMode = parseBM();
		}
		return this.containsTransparency;
	}

	private List<PDXForm> parseAppearance() {
		PDAppearanceEntry normalAppearance = ((PDAnnotation) simplePDObject).getNormalAppearance();
		PDAppearanceEntry downAppearance = ((PDAnnotation) simplePDObject).getDownAppearance();
		PDAppearanceEntry rolloverAppearance = ((PDAnnotation) simplePDObject).getRolloverAppearance();
		if (normalAppearance != null || downAppearance != null || rolloverAppearance != null) {
			List<PDXForm> appearances = new ArrayList<>();
			addContentStreamsFromAppearanceEntry(normalAppearance, appearances);
			addContentStreamsFromAppearanceEntry(downAppearance, appearances);
			addContentStreamsFromAppearanceEntry(rolloverAppearance, appearances);
			return Collections.unmodifiableList(appearances);
		}
		return Collections.emptyList();
	}

	private void addContentStreamsFromAppearanceEntry(PDAppearanceEntry appearanceEntry, List<PDXForm> appearances) {
		if (appearanceEntry != null) {
			if (appearanceEntry.isSubDictionary()) {
				Map<ASAtom, PDAppearanceStream> subDictionary = appearanceEntry.getSubDictionary();
				for (PDAppearanceStream stream : subDictionary.values()) {
					addAppearance(appearances, stream);
				}
			} else {
				addAppearance(appearances, appearanceEntry.getAppearanceStream());
			}
		}
	}

	private void addAppearance(List<PDXForm> list, PDAppearanceStream toAdd) {
		if (toAdd != null) {
			PDResourcesHandler resources = this.resources.getExtendedResources(toAdd.getResources());
			List<CosLang> annotLang = getLang();
			GFPDXForm xForm = new GFPDXForm(toAdd, resources, null, getParentDictionary(), "", 
					annotLang.isEmpty() ? null : annotLang.get(0).getunicodeValue());
			this.containsTransparency |= xForm.containsTransparency();
			list.add(xForm);
		}
	}

	public static GFPDAnnot createAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page) {
		ASAtom subtype = annot.getSubtype();
		if (subtype == null) {
			return new GFPDAnnot(annot, pageResources, page);
		}
		String subtypeString = subtype.getValue();
		switch (subtypeString) {
			case TYPE_3D:
				return new GFPD3DAnnot(annot, pageResources, page);
			case FILE_ATTACHMENT:
				return new GFPDFileAttachmentAnnot(annot, pageResources, page);
			case INK:
				return new GFPDInkAnnot(annot, pageResources, page);
			case LINK:
				return new GFPDLinkAnnot(annot, pageResources, page);
			case MOVIE:
				return new GFPDMovieAnnot(annot, pageResources, page);
			case POPUP:
				return new GFPDPopupAnnot(annot, pageResources, page);
			case PRINTER_MARK:
				return new GFPDPrinterMarkAnnot(annot, pageResources, page);
			case RICH_MEDIA:
				return new GFPDRichMediaAnnot(annot, pageResources, page);
			case SCREEN:
				return new GFPDScreenAnnot(annot, pageResources, page);
			case SOUND:
				return new GFPDSoundAnnot(annot, pageResources, page);
			case STAMP:
				return new GFPDRubberStampAnnot(annot, pageResources, page);
			case TRAP_NET:
				return new GFPDTrapNetAnnot(annot, pageResources, page);
			case WIDGET:
				return new GFPDWidgetAnnot((PDWidgetAnnotation) annot, pageResources, page);
			case CARET:
			case CIRCLE:
			case FREE_TEXT:
			case HIGHLIGHT:
			case LINE:
			case POLYGON:
			case POLYLINE:
			case REDACT:
			case STRIKE_OUT:
			case SQUARE:
			case SQUIGGLY:
			case TEXT:
			case UNDERLINE:
				return new GFPDMarkupAnnot(annot, pageResources, page);
			default:
				return new GFPDAnnot(annot, pageResources, page);
		}
	}
}
