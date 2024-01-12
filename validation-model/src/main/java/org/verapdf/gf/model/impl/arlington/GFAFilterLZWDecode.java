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
	public String getBitsPerComponentType() {
		COSObject BitsPerComponent = getBitsPerComponentValue();
		return getObjectType(BitsPerComponent);
	}

	@Override
	public Boolean getBitsPerComponentHasTypeInteger() {
		COSObject BitsPerComponent = getBitsPerComponentValue();
		return getHasTypeInteger(BitsPerComponent);
	}

	@Override
	public Long getBitsPerComponentIntegerValue() {
		COSObject BitsPerComponent = getBitsPerComponentValue();
		return getIntegerValue(BitsPerComponent);
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
	public String getColorsType() {
		COSObject Colors = getColorsValue();
		return getObjectType(Colors);
	}

	@Override
	public Boolean getColorsHasTypeInteger() {
		COSObject Colors = getColorsValue();
		return getHasTypeInteger(Colors);
	}

	@Override
	public Long getColorsIntegerValue() {
		COSObject Colors = getColorsValue();
		return getIntegerValue(Colors);
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
	public String getColumnsType() {
		COSObject Columns = getColumnsValue();
		return getObjectType(Columns);
	}

	@Override
	public Boolean getColumnsHasTypeInteger() {
		COSObject Columns = getColumnsValue();
		return getHasTypeInteger(Columns);
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
	public String getEarlyChangeType() {
		COSObject EarlyChange = getEarlyChangeValue();
		return getObjectType(EarlyChange);
	}

	@Override
	public Boolean getEarlyChangeHasTypeInteger() {
		COSObject EarlyChange = getEarlyChangeValue();
		return getHasTypeInteger(EarlyChange);
	}

	@Override
	public Long getEarlyChangeIntegerValue() {
		COSObject EarlyChange = getEarlyChangeValue();
		return getIntegerValue(EarlyChange);
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
	public String getPredictorType() {
		COSObject Predictor = getPredictorValue();
		return getObjectType(Predictor);
	}

	@Override
	public Boolean getPredictorHasTypeInteger() {
		COSObject Predictor = getPredictorValue();
		return getHasTypeInteger(Predictor);
	}

	@Override
	public Long getPredictorIntegerValue() {
		COSObject Predictor = getPredictorValue();
		return getIntegerValue(Predictor);
	}

}