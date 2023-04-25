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

public class GFAHalftoneType1 extends GFAObject implements AHalftoneType1 {

	public GFAHalftoneType1(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AHalftoneType1");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "SpotFunction":
				return getSpotFunction();
			case "TransferFunction":
				return getTransferFunction();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSpotFunction() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getSpotFunction1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSpotFunction1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSpotFunction1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFunctions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFunctions((COSArray)object.getDirectBase(), this.baseObject, "SpotFunction"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFunctionType0> list = new ArrayList<>(1);
			list.add(new GFAFunctionType0((COSStream)object.getDirectBase(), this.baseObject, "SpotFunction"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getSpotFunction1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFunctions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFunctions((COSArray)object.getDirectBase(), this.baseObject, "SpotFunction"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getSpotFunctionStream1_3(object.getDirectBase(), "SpotFunction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getSpotFunctionDictionary1_3(object.getDirectBase(), "SpotFunction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getSpotFunctionStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getSpotFunctionDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getTransferFunction() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getTransferFunction1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTransferFunction1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getTransferFunction1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransferFunction"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFunctionType0> list = new ArrayList<>(1);
			list.add(new GFAFunctionType0((COSStream)object.getDirectBase(), this.baseObject, "TransferFunction"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getTransferFunction1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransferFunction"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getTransferFunctionStream1_3(object.getDirectBase(), "TransferFunction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getTransferFunctionDictionary1_3(object.getDirectBase(), "TransferFunction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getTransferFunctionStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getTransferFunctionDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsAccurateScreens() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AccurateScreens"));
	}

	@Override
	public Boolean getAccurateScreensHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AccurateScreens"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsAngle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Angle"));
	}

	@Override
	public Boolean getAngleHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Angle"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsFrequency() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Frequency"));
	}

	@Override
	public Boolean getFrequencyHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Frequency"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getFrequencyNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Frequency"));
		if (object == null || object.empty()) {
			return getFrequencyNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getFrequencyNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsHalftoneName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HalftoneName"));
	}

	@Override
	public Boolean getHalftoneNameHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HalftoneName"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsHalftoneType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HalftoneType"));
	}

	@Override
	public Boolean getHalftoneTypeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HalftoneType"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getHalftoneTypeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HalftoneType"));
		if (object == null || object.empty()) {
			return getHalftoneTypeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getHalftoneTypeIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSpotFunction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpotFunction"));
	}

	@Override
	public Boolean getisSpotFunctionIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSpotFunctionHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getSpotFunctionHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getSpotFunctionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getSpotFunctionHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public String getSpotFunctionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		if (object == null || object.empty()) {
			return getSpotFunctionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSpotFunctionNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsTransferFunction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TransferFunction"));
	}

	@Override
	public Boolean getisTransferFunctionIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransferFunction"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTransferFunctionHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransferFunction"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getTransferFunctionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransferFunction"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getTransferFunctionHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransferFunction"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public String getTransferFunctionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransferFunction"));
		if (object == null || object.empty()) {
			return getTransferFunctionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTransferFunctionNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

	@Override
	public Long getparentHalftoneTypeIntegerValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject HalftoneType = this.parentObject.getKey(ASAtom.getASAtom("HalftoneType"));
		if (HalftoneType != null && HalftoneType.getType() == COSObjType.COS_INTEGER) {
			return HalftoneType.getInteger();
		}
		return null;
	}

}
