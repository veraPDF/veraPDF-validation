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

public class GFACMapStream extends GFAObject implements ACMapStream {

	public GFACMapStream(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACMapStream");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIDSystemInfo":
				return getCIDSystemInfo();
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
			case "UseCMap":
				return getUseCMap();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACIDSystemInfo> getCIDSystemInfo() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIDSystemInfo1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIDSystemInfo> getCIDSystemInfo1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDSystemInfo"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIDSystemInfo> list = new ArrayList<>(1);
			list.add(new GFACIDSystemInfo((COSDictionary)object.getDirectBase(), this.baseObject, "CIDSystemInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
				return getDecodeParms1_2();
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_2(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_2(COSBase base, String keyName) {
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
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_5(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_5(COSBase base, String keyName) {
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
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
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
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
				return getFDecodeParms1_2();
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "FDecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_2(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_2(COSBase base, String keyName) {
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
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "FDecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_5(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_5(COSBase base, String keyName) {
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
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFFilter1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
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
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFilter1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
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

	private List<AStream> getUseCMap() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getUseCMap1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getUseCMap1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UseCMap"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "UseCMap"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIDSystemInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIDSystemInfo"));
	}

	public COSObject getCIDSystemInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDSystemInfo"));
		return object;
	}

	@Override
	public Boolean getCIDSystemInfoHasTypeDictionary() {
		COSObject object = getCIDSystemInfoValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsCMapName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CMapName"));
	}

	public COSObject getCMapNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CMapName"));
		return object;
	}

	@Override
	public Boolean getCMapNameHasTypeName() {
		COSObject object = getCMapNameValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getcontainsUseCMap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UseCMap"));
	}

	public COSObject getUseCMapValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UseCMap"));
		return object;
	}

	@Override
	public Boolean getisUseCMapIndirect() {
		COSObject object = getUseCMapValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getUseCMapHasTypeName() {
		COSObject object = getUseCMapValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getUseCMapHasTypeStream() {
		COSObject object = getUseCMapValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public String getUseCMapNameValue() {
		COSObject object = getUseCMapValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsWMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WMode"));
	}

	public COSObject getWModeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getWModeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WMode"));
		if (object == null || object.empty()) {
			object = getWModeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getWModeHasTypeInteger() {
		COSObject object = getWModeValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getWModeIntegerValue() {
		COSObject object = getWModeValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

}
