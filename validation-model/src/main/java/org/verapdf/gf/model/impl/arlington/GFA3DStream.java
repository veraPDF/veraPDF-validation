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

public class GFA3DStream extends GFAObject implements A3DStream {

	public GFA3DStream(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DStream");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AN":
				return getAN();
			case "ColorSpace":
				return getColorSpace();
			case "DV":
				return getDV();
			case "DecodeParms":
				return getDecodeParms();
			case "F":
				return getF();
			case "FDecodeParms":
				return getFDecodeParms();
			case "FFilter":
				return getFFilter();
			case "Filter":
				return getFilter();
			case "OnInstantiate":
				return getOnInstantiate();
			case "Resources":
				return getResources();
			case "VA":
				return getVA();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<A3DAnimationStyle> getAN() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAN1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DAnimationStyle> getAN1_7() {
		COSObject object = getANValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DAnimationStyle> list = new ArrayList<>(1);
			list.add(new GFA3DAnimationStyle((COSDictionary)object.getDirectBase(), this.baseObject, "AN"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getColorSpace2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace2_0() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getColorSpaceArray2_0(object.getDirectBase(), "ColorSpace");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getColorSpaceArray2_0(COSBase base, String keyName) {
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
			case "ICCBased":
				return new GFAICCBasedColorSpace(base, this.baseObject, keyName);
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<A3DView> getDV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDV1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DView> getDV1_6() {
		COSObject object = getDVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DView> list = new ArrayList<>(1);
			list.add(new GFA3DView((COSDictionary)object.getDirectBase(), this.baseObject, "DV"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDecodeParms1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_6() {
		COSObject object = getDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_6(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_6(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AFileSpecification> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_6() {
		COSObject object = getFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "F"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFDecodeParms1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_6() {
		COSObject object = getFDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "FDecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_6(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_6(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFFilter1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter1_6() {
		COSObject object = getFFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCompressionFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCompressionFilterNames((COSArray)object.getDirectBase(), this.baseObject, "FFilter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCompressionFilterNames> getFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFilter1_6() {
		COSObject object = getFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCompressionFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCompressionFilterNames((COSArray)object.getDirectBase(), this.baseObject, "Filter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getOnInstantiate() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOnInstantiate1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getOnInstantiate1_6() {
		COSObject object = getOnInstantiateValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "OnInstantiate"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A3DStreamNameTreeResources> getResources() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResources1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DStreamNameTreeResources> getResources1_6() {
		COSObject object = getResourcesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DStreamNameTreeResources> list = new ArrayList<>(1);
			list.add(new GFA3DStreamNameTreeResources((COSDictionary)object.getDirectBase(), this.baseObject, "Resources"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DView> getVA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getVA1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DView> getVA1_6() {
		COSObject object = getVAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DView> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DView((COSArray)object.getDirectBase(), this.baseObject, "VA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AN"));
	}

	public COSObject getANValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AN"));
		return object;
	}

	@Override
	public Boolean getANHasTypeDictionary() {
		COSObject object = getANValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		COSObject object = getColorSpaceValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getColorSpaceHasTypeName() {
		COSObject object = getColorSpaceValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getColorSpaceNameValue() {
		COSObject object = getColorSpaceValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DL"));
	}

	public COSObject getDLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DL"));
		return object;
	}

	@Override
	public Boolean getDLHasTypeInteger() {
		COSObject object = getDLValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDLIntegerValue() {
		COSObject object = getDLValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DV"));
	}

	public COSObject getDVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DV"));
		return object;
	}

	@Override
	public Boolean getDVHasTypeDictionary() {
		COSObject object = getDVValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getDVHasTypeInteger() {
		COSObject object = getDVValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getDVHasTypeName() {
		COSObject object = getDVValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getDVHasTypeString() {
		COSObject object = getDVValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getDVIntegerValue() {
		COSObject object = getDVValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public String getDVNameValue() {
		COSObject object = getDVValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDecodeParms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DecodeParms"));
	}

	public COSObject getDecodeParmsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
		return object;
	}

	@Override
	public Boolean getDecodeParmsHasTypeArray() {
		COSObject object = getDecodeParmsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getDecodeParmsHasTypeDictionary() {
		COSObject object = getDecodeParmsValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Long getDecodeParmsArraySize() {
		COSObject object = getDecodeParmsValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object;
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsFDecodeParms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FDecodeParms"));
	}

	public COSObject getFDecodeParmsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
		return object;
	}

	@Override
	public Boolean getFDecodeParmsHasTypeArray() {
		COSObject object = getFDecodeParmsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getFDecodeParmsHasTypeDictionary() {
		COSObject object = getFDecodeParmsValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Long getFDecodeParmsArraySize() {
		COSObject object = getFDecodeParmsValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FFilter"));
	}

	public COSObject getFFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		return object;
	}

	@Override
	public Boolean getFFilterHasTypeArray() {
		COSObject object = getFFilterValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getFFilterHasTypeName() {
		COSObject object = getFFilterValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFFilterNameValue() {
		COSObject object = getFFilterValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Long getFFilterArraySize() {
		COSObject object = getFFilterValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	public COSObject getFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object;
	}

	@Override
	public Boolean getFilterHasTypeArray() {
		COSObject object = getFilterValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject object = getFilterValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFilterNameValue() {
		COSObject object = getFilterValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Long getFilterArraySize() {
		COSObject object = getFilterValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsLength() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Length"));
	}

	public COSObject getLengthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
		return object;
	}

	@Override
	public Boolean getLengthHasTypeInteger() {
		COSObject object = getLengthValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsOnInstantiate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OnInstantiate"));
	}

	public COSObject getOnInstantiateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OnInstantiate"));
		return object;
	}

	@Override
	public Boolean getisOnInstantiateIndirect() {
		COSObject object = getOnInstantiateValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getOnInstantiateHasTypeStream() {
		COSObject object = getOnInstantiateValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object;
	}

	@Override
	public Boolean getResourcesHasTypeNameTree() {
		COSObject object = getResourcesValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getcontainsVA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VA"));
	}

	public COSObject getVAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VA"));
		return object;
	}

	@Override
	public Boolean getVAHasTypeArray() {
		COSObject object = getVAValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getVAArraySize() {
		COSObject object = getVAValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

}
