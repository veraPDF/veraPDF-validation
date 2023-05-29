package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFAFilterLZWDecode extends GFAObject implements AFilterLZWDecode {

	public GFAFilterLZWDecode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterLZWDecode");
	}

	@Override
	public Boolean getcontainsBitsPerComponent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BitsPerComponent"));
	}

	public COSObject getBitsPerComponentDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(8L);
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsEarlyChange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EarlyChange"));
	}

	public COSObject getEarlyChangeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
