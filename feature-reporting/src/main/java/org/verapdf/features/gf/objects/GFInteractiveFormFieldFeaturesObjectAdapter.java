/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Feature Reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Feature Reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Feature Reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.features.objects.InteractiveFormFieldFeaturesObjectAdapter;
import org.verapdf.pd.form.PDFormField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFInteractiveFormFieldFeaturesObjectAdapter implements InteractiveFormFieldFeaturesObjectAdapter {

	private static final EnumMap<COSObjType, String> valueMap = new EnumMap<>(COSObjType.class);

	static {
		valueMap.put(COSObjType.COS_ARRAY, "--COSArray--");
		valueMap.put(COSObjType.COS_DICT, "--COSDictionary--");
		valueMap.put(COSObjType.COS_STREAM, "--COSStream--");
	}

	private final PDFormField formField;

	public GFInteractiveFormFieldFeaturesObjectAdapter(PDFormField formField) {
		this.formField = formField;
	}

	@Override
	public String getFullyQualifiedName() {
		return this.formField.getFullyQualifiedName();
	}

	@Override
	public String getValue() {
		COSObject value = this.formField.getV();
		if (value == null || value.empty()) {
			return null;
		} else {
			COSObjType type = value.getType();
			switch (type) {
				case COS_BOOLEAN:
					return String.valueOf(value.getBoolean());
				case COS_STRING:
				case COS_NAME:
					return value.getString();
				case COS_INTEGER:
					return String.valueOf(value.getInteger());
				case COS_REAL:
					return String.valueOf(value.getReal());
				default:
					return valueMap.getOrDefault(type, null);
			}
		}
	}

	@Override
	public List<InteractiveFormFieldFeaturesObjectAdapter> getChildren() {
		List<PDFormField> childFormFields = this.formField.getChildFormFields();
		if (childFormFields != null && !childFormFields.isEmpty()) {
			List<InteractiveFormFieldFeaturesObjectAdapter> res = new ArrayList<>();
			for (PDFormField field : childFormFields) {
				res.add(new GFInteractiveFormFieldFeaturesObjectAdapter(field));
			}
			return res;
		}
		return Collections.emptyList();
	}

	@Override
	public boolean isPDFObjectPresent() {
		return this.formField != null && !this.formField.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}
}
