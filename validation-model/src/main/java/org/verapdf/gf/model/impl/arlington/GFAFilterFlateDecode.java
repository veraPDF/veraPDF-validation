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

public class GFAFilterFlateDecode extends GFAObject implements AFilterFlateDecode {

	public GFAFilterFlateDecode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterFlateDecode");
	}

	@Override
	public Boolean getcontainsBitsPerComponent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BitsPerComponent"));
	}

	@Override
	public Boolean getBitsPerComponentHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BitsPerComponent"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getBitsPerComponentIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BitsPerComponent"));
		if (object == null || object.empty()) {
			return getBitsPerComponentIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getBitsPerComponentIntegerDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 8L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsColors() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Colors"));
	}

	@Override
	public Boolean getColorsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colors"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getColorsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colors"));
		if (object == null || object.empty()) {
			return getColorsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getColorsIntegerDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 1L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsColumns() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Columns"));
	}

	@Override
	public Boolean getColumnsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Columns"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsPredictor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Predictor"));
	}

	@Override
	public Boolean getPredictorHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Predictor"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPredictorIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Predictor"));
		if (object == null || object.empty()) {
			return getPredictorIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getPredictorIntegerDefaultValue() {
		return null;
	}

}
