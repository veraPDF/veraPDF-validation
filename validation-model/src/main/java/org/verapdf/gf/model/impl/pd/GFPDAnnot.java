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
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSInteger;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSString;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSName;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosBM;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.gf.model.impl.pd.actions.GFPDAction;
import org.verapdf.gf.model.impl.pd.actions.GFPDAdditionalActions;
import org.verapdf.gf.model.impl.pd.annotations.GFPD3DAnnot;
import org.verapdf.gf.model.impl.pd.annotations.GFPDLinkAnnot;
import org.verapdf.gf.model.impl.pd.annotations.GFPDPrinterMarkAnnot;
import org.verapdf.gf.model.impl.pd.annotations.GFPDTrapNetAnnot;
import org.verapdf.gf.model.impl.pd.annotations.GFPDWidgetAnnot;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosBM;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.pdlayer.PDAction;
import org.verapdf.model.pdlayer.PDAdditionalActions;
import org.verapdf.model.pdlayer.PDAnnot;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.pd.PDPage;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDAppearanceEntry;
import org.verapdf.pd.PDAppearanceStream;
import org.verapdf.pd.PDGroup;
import org.verapdf.pd.actions.PDAnnotationAdditionalActions;
import org.verapdf.pd.annotations.PDWidgetAnnotation;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.pd.structure.StructureElementAccessObject;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.tools.StaticResources;

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
	public static final String C = "C";
	public static final String IC = "IC";
	public static final String A = "A";
	public static final String ADDITIONAL_ACTION = "AA";
	public static final String LANG = "Lang";
	public static final String BM = "BM";
	public static final String LINK = "Link";
	public static final String PRINTER_MARK = "PrinterMark";
	public static final String WIDGET = "Widget";
	public static final String TRAP_NET = "TrapNet";
	public static final String TYPE_3D = "3D";

	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;

	protected final PDResourcesHandler resources;
	private final PDPage page;

	private List<CosBM> blendMode = null;
	private List<PDContentStream> appearance = null;
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
		PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
		Long structParent = ((PDAnnotation)this.simplePDObject).getStructParent();
		if (structTreeRoot != null && structParent != null) {
			PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
			COSObject structureElement = parentTreeRoot == null ? null : parentTreeRoot.getObject(structParent);
			if (structureElement != null && structureElement.getType() == COSObjType.COS_DICT) {
				return structureElement.getStringKey(ASAtom.S);
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
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ADDITIONAL_ACTION:
				return this.getAdditionalActions();
			case A:
				return this.getA();
			case IC:
				return this.getIC();
			case C:
				return this.getC();
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

	private List<CosNumber> getIC() {
		COSObject ic = ((PDAnnotation) simplePDObject).getCOSIC();
		if (ic != null) {
			return GFPDAnnot.getNumbersFromArray(ic);
		}
		return Collections.emptyList();
	}

	private List<CosNumber> getC() {
		COSObject c = ((PDAnnotation) simplePDObject).getCOSC();
		if (c != null) {
			return GFPDAnnot.getNumbersFromArray(c);
		}
		return Collections.emptyList();
	}

	private static List<CosNumber> getNumbersFromArray(COSObject array) {
		if (array.size().intValue() > 0) {
			List<CosNumber> color = new ArrayList<>();
			for (COSObject colorValue : (COSArray) array.getDirectBase()) {
				if (colorValue.getType().isNumber()) {
					color.add(GFCosNumber.fromPDFParserNumber(colorValue.get()));
				}
			}
			return Collections.unmodifiableList(color);
		} else {
			// Array size is 0 but it is present
			List<CosNumber> res = new ArrayList<>(1);
			res.add(GFCosNumber.fromPDFParserNumber(COSInteger.construct(0).getDirectBase()));
			return res;
		}
	}

	/**
	 * @return normal appearance stream (N key in the appearance dictionary) of
	 * the annotation
	 */
	private List<PDContentStream> getAppearance() {
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

	private List<PDContentStream> parseAppearance() {
		PDAppearanceEntry normalAppearance = ((PDAnnotation) simplePDObject).getNormalAppearance();
		PDAppearanceEntry downAppearance = ((PDAnnotation) simplePDObject).getDownAppearance();
		PDAppearanceEntry rolloverAppearance = ((PDAnnotation) simplePDObject).getRolloverAppearance();
		if (normalAppearance != null || downAppearance != null || rolloverAppearance != null) {
			List<PDContentStream> appearances = new ArrayList<>();
			addContentStreamsFromAppearanceEntry(normalAppearance, appearances);
			addContentStreamsFromAppearanceEntry(downAppearance, appearances);
			addContentStreamsFromAppearanceEntry(rolloverAppearance, appearances);
			return Collections.unmodifiableList(appearances);
		}
		return Collections.emptyList();
	}

	private void addContentStreamsFromAppearanceEntry(PDAppearanceEntry appearanceEntry, List<PDContentStream> appearances) {
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

	private void addAppearance(List<PDContentStream> list, PDAppearanceStream toAdd) {
		if (toAdd != null) {
			PDResourcesHandler resources = this.resources.getExtendedResources(toAdd.getResources());
			List<CosLang> annotLang = getLang();
			GFPDContentStream stream;
			if (!PDFAFlavour.PDFUA_1.getPart().getFamily().equals(StaticContainers.getFlavour().getPart().getFamily()) &&
			    !PDFAFlavour.WCAG2_1.getPart().getFamily().equals(StaticContainers.getFlavour().getPart().getFamily())) {
				stream = new GFPDContentStream(toAdd, resources, null,
						new StructureElementAccessObject(this.simpleCOSObject), getstructParentType(), "");
			} else {
				stream = new GFPDSemanticContentStream(toAdd, resources, null,
						new StructureElementAccessObject(this.simpleCOSObject), getstructParentType(), "",
						annotLang.isEmpty() ? null : annotLang.get(0).getunicodeValue());
			}
			this.containsTransparency |= stream.isContainsTransparency();
			PDGroup group = toAdd.getGroup();
			this.containsTransparency |= group != null && ASAtom.TRANSPARENCY.equals(group.getSubtype());
			list.add(stream);
		}
	}

	public static GFPDAnnot createAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page) {
		ASAtom subtype = annot.getSubtype();
		if (subtype == null) {
			return new GFPDAnnot(annot, pageResources, page);
		}
		String subtypeString = subtype.getValue();
		switch (subtypeString) {
			case WIDGET:
				return new GFPDWidgetAnnot((PDWidgetAnnotation) annot, pageResources, page);
			case TYPE_3D:
				return new GFPD3DAnnot(annot, pageResources, page);
			case TRAP_NET:
				return new GFPDTrapNetAnnot(annot, pageResources, page);
			case LINK:
				return new GFPDLinkAnnot(annot, pageResources, page);
			case PRINTER_MARK:
				return new GFPDPrinterMarkAnnot(annot, pageResources, page);
			default:
				return new GFPDAnnot(annot, pageResources, page);
		}
	}
}
