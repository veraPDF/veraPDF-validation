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
package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDDeviceN;
import org.verapdf.model.pdlayer.PDSeparation;

import java.util.*;

/**
 * @author Maksim Bezrukov
 */
public class GFPDDeviceN extends GFPDColorSpace implements PDDeviceN {

	public static final String DEVICE_N_TYPE = "PDDeviceN";

	public static final String ALTERNATE = "alternate";
	public static final String COLORANT_NAMES = "colorantNames";
	public static final String COLORANTS = "Colorants";
	public static final String PROCESS_COLOR = "processColor";

	public static final Set<ASAtom> IGNORED_COLORANTS;

	static {
		Set<ASAtom> tempIgnore = new HashSet<>();
		tempIgnore.add(ASAtom.getASAtom("Cyan"));
		tempIgnore.add(ASAtom.getASAtom("Magenta"));
		tempIgnore.add(ASAtom.getASAtom("Yellow"));
		tempIgnore.add(ASAtom.getASAtom("Black"));
		IGNORED_COLORANTS = Collections.unmodifiableSet(tempIgnore);
	}

	private final boolean areColorantsPresent;

	public GFPDDeviceN(org.verapdf.pd.colors.PDDeviceN simplePDObject) {
		super(simplePDObject, DEVICE_N_TYPE);
		this.areColorantsPresent = GFPDDeviceN.areColorantsPresent(simplePDObject);
	}

	private static boolean areColorantsPresent(org.verapdf.pd.colors.PDDeviceN simplePDObject) {
		COSObject attributes = simplePDObject.getAttributes();
		if (attributes != null && attributes.getType() == COSObjType.COS_DICT) {
			COSObject colorantsDict = attributes.getKey(ASAtom.COLORANTS);
			List<COSObject> colorantsArray = simplePDObject.getNames();
			Set<ASAtom> componentNames = new HashSet<>();
			if (colorantsDict != null && colorantsDict.getType() == COSObjType.COS_DICT) {
				componentNames.addAll(colorantsDict.getKeySet());
			}
			COSArray components = getProcessComponents(attributes);
			if (components != null) {
				for (COSObject component : components) {
					if (component.getType() == COSObjType.COS_NAME) {
						componentNames.add(component.getName());
					}
				}
			}
			return GFPDDeviceN.areColorantsPresent(componentNames, colorantsArray);
		}
		return false;
	}

	private static COSArray getProcessComponents(COSObject attributes) {
		COSObject process = attributes.getKey(ASAtom.PROCESS);
		if (!process.empty()) {
			COSObject components = process.getKey(ASAtom.COMPONENTS);
			if (!components.empty()) {
				return (COSArray) components.get();
			}
		}
		return null;
	}

	private static boolean areColorantsPresent(Set<ASAtom> colorantDictionaryEntries,
	                                           List<COSObject> colorantsArray) {
		for (int i = 0; i < colorantsArray.size(); ++i) {
			COSObject object = colorantsArray.get(i);
			if (object != null && !isNone(object) && !IGNORED_COLORANTS.contains(object.getName()) &&
			    !colorantDictionaryEntries.contains(object.getName())) {
				return false;
			}
		}
		return true;
	}

	private static boolean isNone(COSObject obj) {
		return obj.getType() == COSObjType.COS_NAME && obj.getName() == ASAtom.NONE;
	}

	@Override
	public Boolean getareColorantsPresent() {
		return Boolean.valueOf(this.areColorantsPresent);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ALTERNATE:
				return this.getAlternate();
			case COLORANT_NAMES:
				return this.getColorantNames();
			case COLORANTS:
				return this.getColorants();
			case PROCESS_COLOR:
				return this.getProcessColor();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDColorSpace> getProcessColor() {
		COSObject attributes = ((org.verapdf.pd.colors.PDDeviceN) this.simplePDObject).getAttributes();
		if (isNullOrNotDictionary(attributes)) {
			return Collections.emptyList();
		}
		COSObject processDict = attributes.getKey(ASAtom.PROCESS);
		if (isNullOrNotDictionary(processDict)) {
			return Collections.emptyList();
		}
		COSObject cs = processDict.getKey(ASAtom.COLORSPACE);
		org.verapdf.pd.colors.PDColorSpace colorSpace = org.verapdf.factory.colors.ColorSpaceFactory
				.getColorSpace(cs);

		if (colorSpace == null) {
			return Collections.emptyList();
		}

		return Collections.singletonList(ColorSpaceFactory.getColorSpace(colorSpace));
	}

	private List<PDColorSpace> getAlternate() {
		org.verapdf.pd.colors.PDColorSpace alternateColorSpace = ((org.verapdf.pd.colors.PDDeviceN) this.simplePDObject)
				.getAlternateSpace();
		PDColorSpace space = ColorSpaceFactory.getColorSpace(alternateColorSpace);
		if (space != null) {
			List<PDColorSpace> colorSpace = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			colorSpace.add(space);
			return Collections.unmodifiableList(colorSpace);
		}
		return Collections.emptyList();
	}

	private List<CosUnicodeName> getColorantNames() {
		List<COSObject> colorants = ((org.verapdf.pd.colors.PDDeviceN) this.simplePDObject).getNames();
		if (!colorants.isEmpty()) {
			ArrayList<CosUnicodeName> list = new ArrayList<>(colorants.size());
			for (COSObject colorant : colorants) {
				if (colorant.getType() == COSObjType.COS_NAME) {
					list.add(new GFCosUnicodeName((COSName) colorant.getDirectBase()));
				}
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<PDSeparation> getColorants() {
		COSObject attributes = ((org.verapdf.pd.colors.PDDeviceN) this.simplePDObject).getAttributes();
		if (attributes != null && attributes.getType() == COSObjType.COS_DICT) {
			COSObject colorantsDict = attributes.getKey(ASAtom.COLORANTS);
			if (colorantsDict.getType() == COSObjType.COS_DICT && colorantsDict.size().intValue() > 0) {
				return GFPDDeviceN.getColorants(colorantsDict);
			}
		}
		return Collections.emptyList();
	}

	private static List<PDSeparation> getColorants(COSObject colorantsDict) {
		List<PDSeparation> list = new ArrayList<>(colorantsDict.size().intValue());
		for (COSObject value : colorantsDict.getValues()) {
			org.verapdf.pd.colors.PDColorSpace colorSpace = org.verapdf.factory.colors.ColorSpaceFactory
					.getColorSpace(value);
			if (ASAtom.SEPARATION.equals(colorSpace.getType())) {
				list.add((GFPDSeparation) ColorSpaceFactory.getColorSpace(colorSpace));
			}
		}
		return Collections.unmodifiableList(list);
	}

	private boolean isNullOrNotDictionary(COSObject toCheck) {
		return toCheck == null || toCheck.getType() != COSObjType.COS_DICT;
	}
}
