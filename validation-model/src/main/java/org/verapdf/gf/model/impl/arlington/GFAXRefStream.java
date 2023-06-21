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

public class GFAXRefStream extends GFAObject implements AXRefStream {

	public GFAXRefStream(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AXRefStream");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AuthCode":
				return getAuthCode();
			case "DecodeParms":
				return getDecodeParms();
			case "Encrypt":
				return getEncrypt();
			case "F":
				return getF();
			case "FDecodeParms":
				return getFDecodeParms();
			case "FFilter":
				return getFFilter();
			case "Filter":
				return getFilter();
			case "entryID":
				return getentryID();
			case "Index":
				return getIndex();
			case "Info":
				return getInfo();
			case "Root":
				return getRoot();
			case "W":
				return getW();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AAuthCode> getAuthCode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAuthCode2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAuthCode> getAuthCode2_0() {
		COSObject object = getAuthCodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAuthCode> list = new ArrayList<>(1);
			list.add(new GFAAuthCode((COSDictionary)object.getDirectBase(), this.baseObject, "AuthCode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_5() {
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
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEncrypt() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEncrypt1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEncrypt1_5() {
		COSObject object = getEncryptValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEncryptDictionary1_5(object.getDirectBase(), "Encrypt");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEncryptDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Filter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAEncryptionPublicKey(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "Adobe.PubSec":
				return new GFAEncryptionPublicKey(base, this.baseObject, keyName);
			case "AdobePPKLite":
				return new GFAEncryptionPublicKey(base, this.baseObject, keyName);
			case "Standard":
				return new GFAEncryptionStandard(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AFileSpecification> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_5() {
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
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_5() {
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
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFFilter1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter1_5() {
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
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFilter1_5() {
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

	private List<ATrailerIDArray> getentryID() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentryID1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ATrailerIDArray> getentryID1_5() {
		COSObject object = getentryIDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ATrailerIDArray> list = new ArrayList<>(1);
			list.add(new GFATrailerIDArray((COSArray)object.getDirectBase(), this.baseObject, "ID"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfXRefIndexIntegers> getIndex() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIndex1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfXRefIndexIntegers> getIndex1_5() {
		COSObject object = getIndexValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfXRefIndexIntegers> list = new ArrayList<>(1);
			list.add(new GFAArrayOfXRefIndexIntegers((COSArray)object.getDirectBase(), this.baseObject, "Index"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADocInfo> getInfo() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getInfo1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADocInfo> getInfo1_5() {
		COSObject object = getInfoValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADocInfo> list = new ArrayList<>(1);
			list.add(new GFADocInfo((COSDictionary)object.getDirectBase(), this.baseObject, "Info"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACatalog> getRoot() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRoot1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACatalog> getRoot1_5() {
		COSObject object = getRootValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACatalog> list = new ArrayList<>(1);
			list.add(new GFACatalog((COSDictionary)object.getDirectBase(), this.baseObject, "Root"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfXRefWIntegers> getW() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getW1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfXRefWIntegers> getW1_5() {
		COSObject object = getWValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfXRefWIntegers> list = new ArrayList<>(1);
			list.add(new GFAArrayOfXRefWIntegers((COSArray)object.getDirectBase(), this.baseObject, "W"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAuthCode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AuthCode"));
	}

	public COSObject getAuthCodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthCode"));
		return object;
	}

	@Override
	public Boolean getisAuthCodeIndirect() {
		COSObject object = getAuthCodeValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getAuthCodeHasTypeDictionary() {
		COSObject object = getAuthCodeValue();
		return getHasTypeDictionary(object);
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
		return getHasTypeInteger(object);
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
	public Boolean getisDecodeParmsIndirect() {
		COSObject object = getDecodeParmsValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getDecodeParmsHasTypeArray() {
		COSObject object = getDecodeParmsValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getDecodeParmsHasTypeDictionary() {
		COSObject object = getDecodeParmsValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Long getDecodeParmsArraySize() {
		COSObject object = getDecodeParmsValue();
		return getArraySize(object);
	}

	@Override
	public Boolean getcontainsEncrypt() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Encrypt"));
	}

	public COSObject getEncryptValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encrypt"));
		return object;
	}

	@Override
	public Boolean getEncryptHasTypeDictionary() {
		COSObject object = getEncryptValue();
		return getHasTypeDictionary(object);
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
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject object = getFValue();
		return getHasTypeString(object);
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
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getFDecodeParmsHasTypeDictionary() {
		COSObject object = getFDecodeParmsValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Long getFDecodeParmsArraySize() {
		COSObject object = getFDecodeParmsValue();
		return getArraySize(object);
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
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getFFilterHasTypeName() {
		COSObject object = getFFilterValue();
		return getHasTypeName(object);
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
		return getArraySize(object);
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
	public Boolean getisFilterIndirect() {
		COSObject object = getFilterValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getFilterHasTypeArray() {
		COSObject object = getFilterValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject object = getFilterValue();
		return getHasTypeName(object);
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
		return getArraySize(object);
	}

	@Override
	public String getFilterEntriesString() {
		COSObject object = getFilterValue();
		if (object == null) {
			return null;
		}
		if (object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		if (object.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		List<String> names = new LinkedList<>();
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem.getType() == COSObjType.COS_NAME) {
				names.add(elem.getString());
			}
		}
		return String.join("&", names);
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	public COSObject getentryIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object;
	}

	@Override
	public Boolean getisentryIDIndirect() {
		COSObject object = getentryIDValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getentryIDHasTypeArray() {
		COSObject object = getentryIDValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsIndex() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Index"));
	}

	public COSObject getIndexValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Index"));
		return object;
	}

	@Override
	public Boolean getisIndexIndirect() {
		COSObject object = getIndexValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getIndexHasTypeArray() {
		COSObject object = getIndexValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getisIndexArraySortAscending2() {
		COSObject object = getIndexValue();
		return getisArraySortAscending(object, 2);
	}

	@Override
	public Long getIndexArraySize() {
		COSObject object = getIndexValue();
		return getArraySize(object);
	}

	@Override
	public Boolean getcontainsInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Info"));
	}

	public COSObject getInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Info"));
		return object;
	}

	@Override
	public Boolean getisInfoIndirect() {
		COSObject object = getInfoValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getInfoHasTypeDictionary() {
		COSObject object = getInfoValue();
		return getHasTypeDictionary(object);
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
		return getHasTypeInteger(object);
	}

	@Override
	public Long getLengthIntegerValue() {
		COSObject object = getLengthValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPrev() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Prev"));
	}

	public COSObject getPrevValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prev"));
		return object;
	}

	@Override
	public Boolean getisPrevIndirect() {
		COSObject object = getPrevValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getPrevHasTypeInteger() {
		COSObject object = getPrevValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getPrevIntegerValue() {
		COSObject object = getPrevValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsRoot() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Root"));
	}

	public COSObject getRootValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Root"));
		return object;
	}

	@Override
	public Boolean getisRootIndirect() {
		COSObject object = getRootValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getRootHasTypeDictionary() {
		COSObject object = getRootValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsSize() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Size"));
	}

	public COSObject getSizeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		return object;
	}

	@Override
	public Boolean getisSizeIndirect() {
		COSObject object = getSizeValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getSizeHasTypeInteger() {
		COSObject object = getSizeValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getSizeIntegerValue() {
		COSObject object = getSizeValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
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
	public Boolean getisTypeIndirect() {
		COSObject object = getTypeValue();
		return getisIndirect(object);
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
	public Boolean getcontainsW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("W"));
	}

	public COSObject getWValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W"));
		return object;
	}

	@Override
	public Boolean getisWIndirect() {
		COSObject object = getWValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getWHasTypeArray() {
		COSObject object = getWValue();
		return getHasTypeArray(object);
	}

	@Override
	public Long getEncryptVIntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Encrypt = this.baseObject.getKey(ASAtom.getASAtom("Encrypt"));
		if (Encrypt == null || !Encrypt.getType().isDictionaryBased()) {
			return null;
		}
		COSObject V = Encrypt.getKey(ASAtom.getASAtom("V"));
		if (V != null && V.getType() == COSObjType.COS_INTEGER) {
			return V.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getEncryptVHasTypeInteger() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Encrypt = this.baseObject.getKey(ASAtom.getASAtom("Encrypt"));
		if (Encrypt == null || !Encrypt.getType().isDictionaryBased()) {
			return null;
		}
		COSObject V = Encrypt.getKey(ASAtom.getASAtom("V"));
		return getHasTypeInteger(V);
	}

	@Override
	public Boolean getcontainstrailerInfoModDate() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Info = trailer.getKey(ASAtom.getASAtom("Info"));
		return Info.knownKey(ASAtom.getASAtom("ModDate"));
	}

	@Override
	public Boolean getcontainstrailerCatalogPieceInfo() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		return Root.knownKey(ASAtom.getASAtom("PieceInfo"));
	}

	@Override
	public Boolean gethasExtensionISO_TS_32004() {
		return false;
	}

}
