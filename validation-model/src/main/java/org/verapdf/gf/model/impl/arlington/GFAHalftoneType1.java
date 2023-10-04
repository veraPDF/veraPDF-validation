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
		COSObject AccurateScreens = getAccurateScreensValue();
		return getHasTypeBoolean(AccurateScreens);
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
		COSObject Angle = getAngleValue();
		return getHasTypeNumber(Angle);
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
		COSObject Frequency = getFrequencyValue();
		return getHasTypeNumber(Frequency);
	}

	@Override
	public Double getFrequencyNumberValue() {
		COSObject Frequency = getFrequencyValue();
		return getNumberValue(Frequency);
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
		COSObject HalftoneName = getHalftoneNameValue();
		return getHasTypeStringByte(HalftoneName);
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
		COSObject HalftoneType = getHalftoneTypeValue();
		return getHasTypeInteger(HalftoneType);
	}

	@Override
	public Long getHalftoneTypeIntegerValue() {
		COSObject HalftoneType = getHalftoneTypeValue();
		return getIntegerValue(HalftoneType);
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
		COSObject SpotFunction = getSpotFunctionValue();
		return getisIndirect(SpotFunction);
	}

	@Override
	public Boolean getSpotFunctionHasTypeArray() {
		COSObject SpotFunction = getSpotFunctionValue();
		return getHasTypeArray(SpotFunction);
	}

	@Override
	public Boolean getSpotFunctionHasTypeDictionary() {
		COSObject SpotFunction = getSpotFunctionValue();
		return getHasTypeDictionary(SpotFunction);
	}

	@Override
	public Boolean getSpotFunctionHasTypeName() {
		COSObject SpotFunction = getSpotFunctionValue();
		return getHasTypeName(SpotFunction);
	}

	@Override
	public Boolean getSpotFunctionHasTypeStream() {
		COSObject SpotFunction = getSpotFunctionValue();
		return getHasTypeStream(SpotFunction);
	}

	@Override
	public String getSpotFunctionNameValue() {
		COSObject SpotFunction = getSpotFunctionValue();
		return getNameValue(SpotFunction);
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
		COSObject TransferFunction = getTransferFunctionValue();
		return getisIndirect(TransferFunction);
	}

	@Override
	public Boolean getTransferFunctionHasTypeDictionary() {
		COSObject TransferFunction = getTransferFunctionValue();
		return getHasTypeDictionary(TransferFunction);
	}

	@Override
	public Boolean getTransferFunctionHasTypeName() {
		COSObject TransferFunction = getTransferFunctionValue();
		return getHasTypeName(TransferFunction);
	}

	@Override
	public Boolean getTransferFunctionHasTypeStream() {
		COSObject TransferFunction = getTransferFunctionValue();
		return getHasTypeStream(TransferFunction);
	}

	@Override
	public String getTransferFunctionNameValue() {
		COSObject TransferFunction = getTransferFunctionValue();
		return getNameValue(TransferFunction);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	public COSObject getparentHalftoneTypeValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject HalftoneType = this.parentObject.getKey(ASAtom.getASAtom("HalftoneType"));
		return HalftoneType;
	}

	@Override
	public Long getparentHalftoneTypeIntegerValue() {
		COSObject parentHalftoneType = getparentHalftoneTypeValue();
		return getIntegerValue(parentHalftoneType);
	}

	@Override
	public Boolean getparentHalftoneTypeHasTypeInteger() {
		COSObject parentHalftoneType = getparentHalftoneTypeValue();
		return getHasTypeInteger(parentHalftoneType);
	}

}
