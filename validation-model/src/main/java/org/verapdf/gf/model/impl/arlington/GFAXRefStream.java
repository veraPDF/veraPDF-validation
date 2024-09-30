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
			case "AdditionalStreams":
				return getAdditionalStreams();
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

	private List<AOOAdditionalStmsArray> getAdditionalStreams() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionOpenOffice() == true)) {
					return getAdditionalStreams1_5();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOOAdditionalStmsArray> getAdditionalStreams1_5() {
		COSObject object = getAdditionalStreamsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AOOAdditionalStmsArray> list = new ArrayList<>(1);
			list.add(new GFAOOAdditionalStmsArray((COSArray)object.getDirectBase(), this.baseObject, "AdditionalStreams"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AAuthCode> getAuthCode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				if ((gethasExtensionISO_TS_32004() == true)) {
					return getAuthCode2_0();
				}
				return Collections.emptyList();
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
	public Boolean getcontainsAdditionalStreams() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AdditionalStreams"));
	}

	public COSObject getAdditionalStreamsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AdditionalStreams"));
		return object;
	}

	@Override
	public Boolean getisAdditionalStreamsIndirect() {
		COSObject AdditionalStreams = getAdditionalStreamsValue();
		return getisIndirect(AdditionalStreams);
	}

	@Override
	public String getAdditionalStreamsType() {
		COSObject AdditionalStreams = getAdditionalStreamsValue();
		return getObjectType(AdditionalStreams);
	}

	@Override
	public Boolean getAdditionalStreamsHasTypeArray() {
		COSObject AdditionalStreams = getAdditionalStreamsValue();
		return getHasTypeArray(AdditionalStreams);
	}

	@Override
	public Long getAdditionalStreamsArraySize() {
		COSObject AdditionalStreams = getAdditionalStreamsValue();
		return getArraySize(AdditionalStreams);
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
		COSObject AuthCode = getAuthCodeValue();
		return getisIndirect(AuthCode);
	}

	@Override
	public String getAuthCodeType() {
		COSObject AuthCode = getAuthCodeValue();
		return getObjectType(AuthCode);
	}

	@Override
	public Boolean getAuthCodeHasTypeDictionary() {
		COSObject AuthCode = getAuthCodeValue();
		return getHasTypeDictionary(AuthCode);
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
	public Boolean getisDLIndirect() {
		COSObject DL = getDLValue();
		return getisIndirect(DL);
	}

	@Override
	public String getDLType() {
		COSObject DL = getDLValue();
		return getObjectType(DL);
	}

	@Override
	public Boolean getDLHasTypeInteger() {
		COSObject DL = getDLValue();
		return getHasTypeInteger(DL);
	}

	@Override
	public Long getDLIntegerValue() {
		COSObject DL = getDLValue();
		return getIntegerValue(DL);
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
		COSObject DecodeParms = getDecodeParmsValue();
		return getisIndirect(DecodeParms);
	}

	@Override
	public String getDecodeParmsType() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getObjectType(DecodeParms);
	}

	@Override
	public Boolean getDecodeParmsHasTypeArray() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getHasTypeArray(DecodeParms);
	}

	@Override
	public Boolean getDecodeParmsHasTypeDictionary() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getHasTypeDictionary(DecodeParms);
	}

	@Override
	public Long getDecodeParmsArraySize() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getArraySize(DecodeParms);
	}

	@Override
	public Boolean getcontainsDocChecksum() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DocChecksum"));
	}

	public COSObject getDocChecksumValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DocChecksum"));
		return object;
	}

	@Override
	public Boolean getisDocChecksumIndirect() {
		COSObject DocChecksum = getDocChecksumValue();
		return getisIndirect(DocChecksum);
	}

	@Override
	public String getDocChecksumType() {
		COSObject DocChecksum = getDocChecksumValue();
		return getObjectType(DocChecksum);
	}

	@Override
	public Boolean getDocChecksumHasTypeName() {
		COSObject DocChecksum = getDocChecksumValue();
		return getHasTypeName(DocChecksum);
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
	public Boolean getisEncryptIndirect() {
		COSObject Encrypt = getEncryptValue();
		return getisIndirect(Encrypt);
	}

	@Override
	public String getEncryptType() {
		COSObject Encrypt = getEncryptValue();
		return getObjectType(Encrypt);
	}

	@Override
	public Boolean getEncryptHasTypeDictionary() {
		COSObject Encrypt = getEncryptValue();
		return getHasTypeDictionary(Encrypt);
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
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject F = getFValue();
		return getHasTypeDictionary(F);
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject F = getFValue();
		return getHasTypeString(F);
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
	public String getFDecodeParmsType() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getObjectType(FDecodeParms);
	}

	@Override
	public Boolean getFDecodeParmsHasTypeArray() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getHasTypeArray(FDecodeParms);
	}

	@Override
	public Boolean getFDecodeParmsHasTypeDictionary() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getHasTypeDictionary(FDecodeParms);
	}

	@Override
	public Long getFDecodeParmsArraySize() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getArraySize(FDecodeParms);
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
	public String getFFilterType() {
		COSObject FFilter = getFFilterValue();
		return getObjectType(FFilter);
	}

	@Override
	public Boolean getFFilterHasTypeArray() {
		COSObject FFilter = getFFilterValue();
		return getHasTypeArray(FFilter);
	}

	@Override
	public Boolean getFFilterHasTypeName() {
		COSObject FFilter = getFFilterValue();
		return getHasTypeName(FFilter);
	}

	@Override
	public String getFFilterNameValue() {
		COSObject FFilter = getFFilterValue();
		return getNameValue(FFilter);
	}

	@Override
	public Long getFFilterArraySize() {
		COSObject FFilter = getFFilterValue();
		return getArraySize(FFilter);
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
		COSObject Filter = getFilterValue();
		return getisIndirect(Filter);
	}

	@Override
	public String getFilterType() {
		COSObject Filter = getFilterValue();
		return getObjectType(Filter);
	}

	@Override
	public Boolean getFilterHasTypeArray() {
		COSObject Filter = getFilterValue();
		return getHasTypeArray(Filter);
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject Filter = getFilterValue();
		return getHasTypeName(Filter);
	}

	@Override
	public String getFilterNameValue() {
		COSObject Filter = getFilterValue();
		return getNameValue(Filter);
	}

	@Override
	public Long getFilterArraySize() {
		COSObject Filter = getFilterValue();
		return getArraySize(Filter);
	}

	@Override
	public String getFilterEntriesString() {
		COSObject Filter = getFilterValue();
		return getEntriesString(Filter);
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
		COSObject entryID = getentryIDValue();
		return getisIndirect(entryID);
	}

	@Override
	public String getentryIDType() {
		COSObject entryID = getentryIDValue();
		return getObjectType(entryID);
	}

	@Override
	public Boolean getentryIDHasTypeArray() {
		COSObject entryID = getentryIDValue();
		return getHasTypeArray(entryID);
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
		COSObject Index = getIndexValue();
		return getisIndirect(Index);
	}

	@Override
	public String getIndexType() {
		COSObject Index = getIndexValue();
		return getObjectType(Index);
	}

	@Override
	public Boolean getIndexHasTypeArray() {
		COSObject Index = getIndexValue();
		return getHasTypeArray(Index);
	}

	@Override
	public Boolean getisIndexArraySortAscending2() {
		COSObject Index = getIndexValue();
		return getisArraySortAscending(Index, 2);
	}

	@Override
	public Long getIndexArraySize() {
		COSObject Index = getIndexValue();
		return getArraySize(Index);
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
		COSObject Info = getInfoValue();
		return getisIndirect(Info);
	}

	@Override
	public String getInfoType() {
		COSObject Info = getInfoValue();
		return getObjectType(Info);
	}

	@Override
	public Boolean getInfoHasTypeDictionary() {
		COSObject Info = getInfoValue();
		return getHasTypeDictionary(Info);
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
	public Boolean getisLengthIndirect() {
		COSObject Length = getLengthValue();
		return getisIndirect(Length);
	}

	@Override
	public String getLengthType() {
		COSObject Length = getLengthValue();
		return getObjectType(Length);
	}

	@Override
	public Boolean getLengthHasTypeInteger() {
		COSObject Length = getLengthValue();
		return getHasTypeInteger(Length);
	}

	@Override
	public Long getLengthIntegerValue() {
		COSObject Length = getLengthValue();
		return getIntegerValue(Length);
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
		COSObject Prev = getPrevValue();
		return getisIndirect(Prev);
	}

	@Override
	public String getPrevType() {
		COSObject Prev = getPrevValue();
		return getObjectType(Prev);
	}

	@Override
	public Boolean getPrevHasTypeInteger() {
		COSObject Prev = getPrevValue();
		return getHasTypeInteger(Prev);
	}

	@Override
	public Long getPrevIntegerValue() {
		COSObject Prev = getPrevValue();
		return getIntegerValue(Prev);
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
		COSObject Root = getRootValue();
		return getisIndirect(Root);
	}

	@Override
	public String getRootType() {
		COSObject Root = getRootValue();
		return getObjectType(Root);
	}

	@Override
	public Boolean getRootHasTypeDictionary() {
		COSObject Root = getRootValue();
		return getHasTypeDictionary(Root);
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
		COSObject Size = getSizeValue();
		return getisIndirect(Size);
	}

	@Override
	public String getSizeType() {
		COSObject Size = getSizeValue();
		return getObjectType(Size);
	}

	@Override
	public Boolean getSizeHasTypeInteger() {
		COSObject Size = getSizeValue();
		return getHasTypeInteger(Size);
	}

	@Override
	public Long getSizeIntegerValue() {
		COSObject Size = getSizeValue();
		return getIntegerValue(Size);
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
		COSObject Type = getTypeValue();
		return getisIndirect(Type);
	}

	@Override
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
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
		COSObject W = getWValue();
		return getisIndirect(W);
	}

	@Override
	public String getWType() {
		COSObject W = getWValue();
		return getObjectType(W);
	}

	@Override
	public Boolean getWHasTypeArray() {
		COSObject W = getWValue();
		return getHasTypeArray(W);
	}

	public COSObject getEncryptVValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Encrypt = this.baseObject.getKey(ASAtom.getASAtom("Encrypt"));
		if (Encrypt == null || !Encrypt.getType().isDictionaryBased()) {
			return null;
		}
		COSObject V = Encrypt.getKey(ASAtom.getASAtom("V"));
		return V;
	}

	public COSObject gettrailerCatalogValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		return Root;
	}

	public COSObject gettrailerInfoValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Info = trailer.getKey(ASAtom.getASAtom("Info"));
		return Info;
	}

	@Override
	public Long getEncryptVIntegerValue() {
		COSObject EncryptV = getEncryptVValue();
		return getIntegerValue(EncryptV);
	}

	@Override
	public Boolean getEncryptVHasTypeInteger() {
		COSObject EncryptV = getEncryptVValue();
		return getHasTypeInteger(EncryptV);
	}

	@Override
	public Boolean getcontainstrailerCatalogPieceInfo() {
		COSObject trailerCatalog = gettrailerCatalogValue();
		return trailerCatalog.knownKey(ASAtom.getASAtom("PieceInfo"));
	}

	@Override
	public Boolean getcontainstrailerInfoModDate() {
		COSObject trailerInfo = gettrailerInfoValue();
		return trailerInfo.knownKey(ASAtom.getASAtom("ModDate"));
	}

}
