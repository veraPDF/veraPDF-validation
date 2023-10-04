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

public class GFAShadingType2 extends GFAObject implements AShadingType2 {

	public GFAShadingType2(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AShadingType2");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Background":
				return getBackground();
			case "ColorSpace":
				return getColorSpace();
			case "Coords":
				return getCoords();
			case "Domain":
				return getDomain();
			case "Extend":
				return getExtend();
			case "Function":
				return getFunction();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getBackground() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBackground1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getBackground1_3() {
		COSObject object = getBackgroundValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Background"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColorSpace1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace1_3() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getColorSpaceArray1_3(object.getDirectBase(), "ColorSpace");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getColorSpaceArray1_3(COSBase base, String keyName) {
		if (base.size() <= 0) {
			return null;
		}
		COSObject subtype = base.at(0);
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			case "DeviceN":
				return new GFADeviceNColorSpace(base, this.baseObject, keyName);
			case "ICCBased":
				return new GFAICCBasedColorSpace(base, this.baseObject, keyName);
			case "Indexed":
				return new GFAIndexedColorSpace(base, this.baseObject, keyName);
			case "Lab":
				return new GFALabColorSpace(base, this.baseObject, keyName);
			case "Separation":
				return new GFASeparationColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOf_4Numbers> getCoords() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCoords1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4Numbers> getCoords1_3() {
		COSObject object = getCoordsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4Numbers((COSArray)object.getDirectBase(), this.baseObject, "Coords"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Numbers> getDomain() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDomain1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getDomain1_3() {
		COSObject object = getDomainValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "Domain"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Booleans> getExtend() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getExtend1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Booleans> getExtend1_3() {
		COSObject object = getExtendValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Booleans> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Booleans((COSArray)object.getDirectBase(), this.baseObject, "Extend"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getFunction() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFunction1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFunction1_3() {
		COSObject object = getFunctionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFunctions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFunctions((COSArray)object.getDirectBase(), this.baseObject, "Function"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getFunctionDictionary1_3(object.getDirectBase(), "Function");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getFunctionStream1_3(object.getDirectBase(), "Function");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFunctionDictionary1_3(COSBase base, String keyName) {
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

	private org.verapdf.model.baselayer.Object getFunctionStream1_3(COSBase base, String keyName) {
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
	public Boolean getcontainsAntiAlias() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AntiAlias"));
	}

	public COSObject getAntiAliasDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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

	public COSObject getAntiAliasValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AntiAlias"));
		if (object == null || object.empty()) {
			object = getAntiAliasDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getAntiAliasHasTypeBoolean() {
		COSObject AntiAlias = getAntiAliasValue();
		return getHasTypeBoolean(AntiAlias);
	}

	@Override
	public Boolean getcontainsBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BBox"));
	}

	public COSObject getBBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BBox"));
		return object;
	}

	@Override
	public Boolean getBBoxHasTypeRectangle() {
		COSObject BBox = getBBoxValue();
		return getHasTypeRectangle(BBox);
	}

	@Override
	public Boolean getcontainsBackground() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Background"));
	}

	public COSObject getBackgroundValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Background"));
		return object;
	}

	@Override
	public Boolean getBackgroundHasTypeArray() {
		COSObject Background = getBackgroundValue();
		return getHasTypeArray(Background);
	}

	@Override
	public Boolean getcontainsColorSpace() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorSpace"));
	}

	public COSObject getColorSpaceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorSpace"));
		return object;
	}

	@Override
	public Boolean getColorSpaceHasTypeArray() {
		COSObject ColorSpace = getColorSpaceValue();
		return getHasTypeArray(ColorSpace);
	}

	@Override
	public Boolean getColorSpaceHasTypeName() {
		COSObject ColorSpace = getColorSpaceValue();
		return getHasTypeName(ColorSpace);
	}

	@Override
	public String getColorSpaceNameValue() {
		COSObject ColorSpace = getColorSpaceValue();
		return getNameValue(ColorSpace);
	}

	@Override
	public Boolean getcontainsCoords() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Coords"));
	}

	public COSObject getCoordsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Coords"));
		return object;
	}

	@Override
	public Boolean getCoordsHasTypeArray() {
		COSObject Coords = getCoordsValue();
		return getHasTypeArray(Coords);
	}

	@Override
	public Boolean getcontainsDomain() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Domain"));
	}

	public COSObject getDomainValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Domain"));
		return object;
	}

	@Override
	public Boolean getDomainHasTypeArray() {
		COSObject Domain = getDomainValue();
		return getHasTypeArray(Domain);
	}

	@Override
	public Boolean getcontainsExtend() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Extend"));
	}

	public COSObject getExtendValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Extend"));
		return object;
	}

	@Override
	public Boolean getExtendHasTypeArray() {
		COSObject Extend = getExtendValue();
		return getHasTypeArray(Extend);
	}

	@Override
	public Boolean getcontainsFunction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Function"));
	}

	public COSObject getFunctionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Function"));
		return object;
	}

	@Override
	public Boolean getisFunctionIndirect() {
		COSObject Function = getFunctionValue();
		return getisIndirect(Function);
	}

	@Override
	public Boolean getFunctionHasTypeArray() {
		COSObject Function = getFunctionValue();
		return getHasTypeArray(Function);
	}

	@Override
	public Boolean getFunctionHasTypeDictionary() {
		COSObject Function = getFunctionValue();
		return getHasTypeDictionary(Function);
	}

	@Override
	public Boolean getFunctionHasTypeStream() {
		COSObject Function = getFunctionValue();
		return getHasTypeStream(Function);
	}

	@Override
	public Boolean getcontainsShadingType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ShadingType"));
	}

	public COSObject getShadingTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ShadingType"));
		return object;
	}

	@Override
	public Boolean getShadingTypeHasTypeInteger() {
		COSObject ShadingType = getShadingTypeValue();
		return getHasTypeInteger(ShadingType);
	}

	@Override
	public Long getShadingTypeIntegerValue() {
		COSObject ShadingType = getShadingTypeValue();
		return getIntegerValue(ShadingType);
	}

}
