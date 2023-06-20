package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getSpotFunctionValue();
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
		COSObject object = getSpotFunctionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFunctions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFunctions((COSArray)object.getDirectBase(), this.baseObject, "SpotFunction"));
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
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getSpotFunctionStream1_3(object.getDirectBase(), "SpotFunction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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

	private List<org.verapdf.model.baselayer.Object> getTransferFunction() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getTransferFunctionValue();
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
		COSObject object = getTransferFunctionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getTransferFunctionDictionary1_3(object.getDirectBase(), "TransferFunction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getTransferFunctionStream1_3(object.getDirectBase(), "TransferFunction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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

	@Override
	public Boolean getcontainsAccurateScreens() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AccurateScreens"));
	}

	public COSObject getAccurateScreensDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getAccurateScreensValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AccurateScreens"));
		if (object == null || object.empty()) {
			object = getAccurateScreensDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getAccurateScreensHasTypeBoolean() {
		COSObject object = getAccurateScreensValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsAngle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Angle"));
	}

	public COSObject getAngleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Angle"));
		return object;
	}

	@Override
	public Boolean getAngleHasTypeNumber() {
		COSObject object = getAngleValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Boolean getcontainsFrequency() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Frequency"));
	}

	public COSObject getFrequencyValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Frequency"));
		return object;
	}

	@Override
	public Boolean getFrequencyHasTypeNumber() {
		COSObject object = getFrequencyValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getFrequencyNumberValue() {
		COSObject object = getFrequencyValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsHalftoneName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HalftoneName"));
	}

	public COSObject getHalftoneNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HalftoneName"));
		return object;
	}

	@Override
	public Boolean getHalftoneNameHasTypeStringByte() {
		COSObject object = getHalftoneNameValue();
		return getHasTypeStringByte(object);
	}

	@Override
	public Boolean getcontainsHalftoneType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HalftoneType"));
	}

	public COSObject getHalftoneTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HalftoneType"));
		return object;
	}

	@Override
	public Boolean getHalftoneTypeHasTypeInteger() {
		COSObject object = getHalftoneTypeValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getHalftoneTypeIntegerValue() {
		COSObject object = getHalftoneTypeValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSpotFunction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpotFunction"));
	}

	public COSObject getSpotFunctionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpotFunction"));
		return object;
	}

	@Override
	public Boolean getisSpotFunctionIndirect() {
		COSObject object = getSpotFunctionValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSpotFunctionHasTypeArray() {
		COSObject object = getSpotFunctionValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getSpotFunctionHasTypeDictionary() {
		COSObject object = getSpotFunctionValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getSpotFunctionHasTypeName() {
		COSObject object = getSpotFunctionValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getSpotFunctionHasTypeStream() {
		COSObject object = getSpotFunctionValue();
		return getHasTypeStream(object);
	}

	@Override
	public String getSpotFunctionNameValue() {
		COSObject object = getSpotFunctionValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsTransferFunction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TransferFunction"));
	}

	public COSObject getTransferFunctionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransferFunction"));
		return object;
	}

	@Override
	public Boolean getisTransferFunctionIndirect() {
		COSObject object = getTransferFunctionValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTransferFunctionHasTypeDictionary() {
		COSObject object = getTransferFunctionValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getTransferFunctionHasTypeName() {
		COSObject object = getTransferFunctionValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getTransferFunctionHasTypeStream() {
		COSObject object = getTransferFunctionValue();
		return getHasTypeStream(object);
	}

	@Override
	public String getTransferFunctionNameValue() {
		COSObject object = getTransferFunctionValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
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

	@Override
	public Boolean getparentHalftoneTypeHasTypeInteger() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject HalftoneType = this.parentObject.getKey(ASAtom.getASAtom("HalftoneType"));
		return getHasTypeInteger(HalftoneType);
	}

}
