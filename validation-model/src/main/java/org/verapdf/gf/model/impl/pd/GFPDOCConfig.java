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
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.pdlayer.PDOCConfig;
import org.verapdf.pd.PDObject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFPDOCConfig extends GFPDObject implements PDOCConfig {

	public static final Logger LOGGER = Logger.getLogger(GFPDOCConfig.class.getCanonicalName());

	public static final String OC_CONFIG_TYPE = "PDOCConfig";

	public static final String EVENT_KEY = "Event";

	private final List<String> groupNames;
	private final boolean duplicateName;

	public GFPDOCConfig(PDObject simplePDObject) {
		super(simplePDObject, OC_CONFIG_TYPE);
		this.groupNames = null;
		this.duplicateName = false;
	}

	public GFPDOCConfig(PDObject simplePDObject, List<String> groupNames, boolean duplicateName) {
		super(simplePDObject, OC_CONFIG_TYPE);
		this.groupNames = groupNames;
		this.duplicateName = duplicateName;
	}

	@Override
	public Boolean getdoesOrderContainAllOCGs() {
		COSObject order = this.simplePDObject.getKey(ASAtom.ORDER);
		if (!order.empty()) {
			if (order.getType() == COSObjType.COS_ARRAY) {
				int groupsInOrder = 0;
				for (int i = 0; i < order.size().intValue(); i++) {
					COSObject element = order.at(i);
					if (element.getType() == COSObjType.COS_ARRAY) {
						groupsInOrder += getLenghtOfFlattenArray((COSArray)
								element.getDirectBase());
						if (!checkCOSArrayInOrder(element).booleanValue()) {
							return Boolean.FALSE;
						}
					} else if (element.getType() == COSObjType.COS_STRING) {
						groupsInOrder++;
						if (!checkCOSStringInOrder(element).booleanValue()) {
							return Boolean.FALSE;
						}
					} else if (element.getType() == COSObjType.COS_DICT) {
						groupsInOrder++;
						if (!checkCOSDictionaryInOrder(element).booleanValue()) {
							return Boolean.FALSE;
						}
					} else {
						LOGGER.log(Level.FINE, "Invalid object type in order array. Ignoring the object.");
					}
				}
				if (groupsInOrder < groupNames.size()) {
					return Boolean.FALSE;
				}
			} else {
				LOGGER.log(Level.FINE, "Invalid object type of Order entry. Ignoring the Order entry.");
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public String getAS() {
		COSObject asArray = this.simplePDObject.getKey(ASAtom.AS);
		if (!asArray.empty()) {
			String result = "";
			if (asArray.getType() == COSObjType.COS_ARRAY) {
				for (int i = 0; i < asArray.size().intValue(); i++) {
					COSObject element = asArray.at(i);
					if (element.getType() == COSObjType.COS_DICT) {
						String event = element.getStringKey(ASAtom.EVENT);
						if (event != null && !event.isEmpty()) {
							result = result.concat(event);
						}
					} else {
						LOGGER.log(Level.FINE, "Invalid object type in the AS array. Ignoring the object.");
					}
				}
				return result;
			}
			LOGGER.log(Level.FINE, "Invalid object type of AS entry. Ignoring the entry.");
			return result;
		}
		return null;
	}

	@Override
	public Boolean gethasDuplicateName() {
		return Boolean.valueOf(this.duplicateName);
	}

	@Override
	public String getName() {
		return this.simplePDObject.getObject().getStringKey(ASAtom.NAME);
	}

	private Boolean checkCOSArrayInOrder(COSObject array) {
		for (int i = 0; i < array.size().intValue(); i++) {
			COSObject element = array.at(i);
			if (element.getType() == COSObjType.COS_ARRAY) {
				if (!checkCOSArrayInOrder(element).booleanValue()) {
					return Boolean.FALSE;
				}
			} else if (element.getType() == COSObjType.COS_STRING) {
				if (!checkCOSStringInOrder(element).booleanValue()) {
					return Boolean.FALSE;
				}
			} else if (element.getType() == COSObjType.COS_DICT) {
				if (!checkCOSDictionaryInOrder(element).booleanValue()) {
					return Boolean.FALSE;
				}
			}
		}
		return Boolean.TRUE;
	}

	private Boolean checkCOSStringInOrder(COSObject element) {
		return Boolean.valueOf(!groupNames.contains((element).getString()));
	}

	private Boolean checkCOSDictionaryInOrder(COSObject element) {
		return Boolean.valueOf(groupNames.contains(element.getStringKey(ASAtom.NAME)));
	}

	private static int getLenghtOfFlattenArray(COSArray array) {
		int res = 0;
		for (int i = 0; i < array.size(); i++) {
			COSObject element = array.at(i);
			if (element.getType() == COSObjType.COS_ARRAY) {
				res += getLenghtOfFlattenArray((COSArray) element.getDirectBase());
			} else {
				res++;
			}
		}
		return res;
	}
}