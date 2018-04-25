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

	private static EnumMap<COSObjType, String> valueMap = new EnumMap<>(COSObjType.class);

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
		}
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
				return valueMap.containsKey(type) ? valueMap.get(type) : null;
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
