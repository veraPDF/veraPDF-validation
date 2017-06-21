/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.gf.model.impl.pd.actions.GFPDAction;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.pdlayer.PDAction;
import org.verapdf.model.pdlayer.PDAnnot;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDAppearanceEntry;
import org.verapdf.pd.PDAppearanceStream;
import org.verapdf.pd.PDGroup;
import org.verapdf.pd.actions.PDAnnotationAdditionalActions;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

	public static final int MAX_COUNT_OF_ACTIONS = 10;
	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;

	private final PDResourcesHandler resources;

	private List<PDContentStream> appearance = null;
	private boolean containsTransparency = false;

	public GFPDAnnot(PDAnnotation annot, PDResourcesHandler pageResources) {
		super(annot, ANNOTATION_TYPE);
		this.resources = pageResources;
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
			StringBuilder result = new StringBuilder();
			for (ASAtom key : apLocal.getKeySet()) {
				result.append(key.getValue());
				result.append(' ');
			}
			//remove last whitespace character
			return result.length() <= 0 ? result.toString() :
					result.substring(0, result.length() - 1);
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

	private static Double getDifference(double[] array, int shift) {
		if (array != null && array.length > shift + 2) {
			return Double.valueOf(array[shift + 2] - array[shift]);
		}
		return null;
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
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDAction> getAdditionalActions() {
		PDAnnotationAdditionalActions additionalActions = ((PDAnnotation) simplePDObject).getAdditionalActions();
		if (additionalActions != null) {
			List<PDAction> actions = new ArrayList<>(MAX_COUNT_OF_ACTIONS);
			org.verapdf.pd.actions.PDAction buffer;

			buffer = additionalActions.getBl();
			this.addAction(actions, buffer);

			buffer = additionalActions.getD();
			this.addAction(actions, buffer);

			buffer = additionalActions.getE();
			this.addAction(actions, buffer);

			buffer = additionalActions.getFo();
			this.addAction(actions, buffer);

			buffer = additionalActions.getPC();
			this.addAction(actions, buffer);

			buffer = additionalActions.getPI();
			this.addAction(actions, buffer);

			buffer = additionalActions.getPO();
			this.addAction(actions, buffer);

			buffer = additionalActions.getPV();
			this.addAction(actions, buffer);

			buffer = additionalActions.getU();
			this.addAction(actions, buffer);

			buffer = additionalActions.getX();
			this.addAction(actions, buffer);

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
		}
		return Collections.emptyList();
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
			GFPDContentStream stream = new GFPDContentStream(toAdd, resources, null,
					new StructureElementAccessObject(this.simpleCOSObject));
			this.containsTransparency |= stream.isContainsTransparency();
			PDGroup group = toAdd.getGroup();
			this.containsTransparency |= group != null && ASAtom.TRANSPARENCY.equals(group.getSubtype());
			list.add(stream);
		}
	}
}
