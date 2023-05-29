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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthCode"));
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
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encrypt"));
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
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Index"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Info"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Root"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W"));
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
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getAuthCodeHasTypeDictionary() {
		COSObject object = getAuthCodeValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getisDecodeParmsIndirect() {
		COSObject object = getDecodeParmsValue();
		return object != null && object.get() != null && object.get().isIndirect();
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
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getisFilterIndirect() {
		COSObject object = getFilterValue();
		return object != null && object.get() != null && object.get().isIndirect();
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
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getentryIDHasTypeArray() {
		COSObject object = getentryIDValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getIndexHasTypeArray() {
		COSObject object = getIndexValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getisIndexArraySortAscending2() {
		COSObject object = getIndexValue();
		if (object == null || object.getType() != COSObjType.COS_ARRAY) {
			return false;
		}
		Long lastNumber = null;
		for (int i = 0; i < object.size(); i += 2) {
			COSObject elem = this.baseObject.at(i);
			if (elem == null || elem.getType() != COSObjType.COS_INTEGER) {
				return false;
			}
			if (lastNumber != null && lastNumber > elem.getInteger()) {
				return false;
			}
			lastNumber = elem.getInteger();
		}
		return true;
	}

	@Override
	public Long getIndexArraySize() {
		COSObject object = getIndexValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
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
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getInfoHasTypeDictionary() {
		COSObject object = getInfoValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPrevHasTypeInteger() {
		COSObject object = getPrevValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getRootHasTypeDictionary() {
		COSObject object = getRootValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSizeHasTypeInteger() {
		COSObject object = getSizeValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
		return object != null && object.get() != null && object.get().isIndirect();
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
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getWHasTypeArray() {
		COSObject object = getWValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
		return V != null && V.getType() == COSObjType.COS_INTEGER;
	}

}
