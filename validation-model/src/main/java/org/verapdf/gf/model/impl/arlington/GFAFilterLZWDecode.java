package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFAFilterLZWDecode extends GFAObject implements AFilterLZWDecode {

	public GFAFilterLZWDecode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterLZWDecode");
	}

	@Override
	public Boolean getcontainsBitsPerComponent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BitsPerComponent"));
	}

	public COSObject getBitsPerComponentDefaultValue() {
		return COSInteger.construct(8L);
	}

	public COSObject getBitsPerComponentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BitsPerComponent"));
		if (object == null || object.empty()) {
			object = getBitsPerComponentDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getBitsPerComponentHasTypeInteger() {
		COSObject object = getBitsPerComponentValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getBitsPerComponentIntegerValue() {
		COSObject object = getBitsPerComponentValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsColors() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Colors"));
	}

	public COSObject getColorsDefaultValue() {
		return COSInteger.construct(1L);
	}

	public COSObject getColorsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colors"));
		if (object == null || object.empty()) {
			object = getColorsDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getColorsHasTypeInteger() {
		COSObject object = getColorsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getColorsIntegerValue() {
		COSObject object = getColorsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsColumns() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Columns"));
	}

	public COSObject getColumnsDefaultValue() {
		return COSInteger.construct(1L);
	}

	public COSObject getColumnsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Columns"));
		if (object == null || object.empty()) {
			object = getColumnsDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getColumnsHasTypeInteger() {
		COSObject object = getColumnsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getcontainsEarlyChange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EarlyChange"));
	}

	public COSObject getEarlyChangeDefaultValue() {
		return COSInteger.construct(1L);
	}

	public COSObject getEarlyChangeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EarlyChange"));
		if (object == null || object.empty()) {
			object = getEarlyChangeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getEarlyChangeHasTypeInteger() {
		COSObject object = getEarlyChangeValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getEarlyChangeIntegerValue() {
		COSObject object = getEarlyChangeValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPredictor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Predictor"));
	}

	public COSObject getPredictorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Predictor"));
		return object;
	}

	@Override
	public Boolean getPredictorHasTypeInteger() {
		COSObject object = getPredictorValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getPredictorIntegerValue() {
		COSObject object = getPredictorValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

}
