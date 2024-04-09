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

public class GFAFileTrailer extends GFAObject implements AFileTrailer {

	public GFAFileTrailer(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFileTrailer");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AdditionalStreams":
				return getAdditionalStreams();
			case "AuthCode":
				return getAuthCode();
			case "Encrypt":
				return getEncrypt();
			case "entryID":
				return getentryID();
			case "Info":
				return getInfo();
			case "Root":
				return getRoot();
			case "XRefStream":
				return getXRefStream();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AOOAdditionalStmsArray> getAdditionalStreams() {
		return getAdditionalStreams1_0();
	}

	private List<AOOAdditionalStmsArray> getAdditionalStreams1_0() {
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

	private List<org.verapdf.model.baselayer.Object> getEncrypt() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEncrypt1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEncrypt1_1() {
		COSObject object = getEncryptValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEncryptDictionary1_1(object.getDirectBase(), "Encrypt");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEncryptDictionary1_1(COSBase base, String keyName) {
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

	private List<ATrailerIDArray> getentryID() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentryID1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<ATrailerIDArray> getentryID1_1() {
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

	private List<ADocInfo> getInfo() {
		return getInfo1_0();
	}

	private List<ADocInfo> getInfo1_0() {
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
		return getRoot1_0();
	}

	private List<ACatalog> getRoot1_0() {
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

	private List<AXRefStream> getXRefStream() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getXRefStream1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXRefStream> getXRefStream1_5() {
		COSObject object = getXRefStreamValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXRefStream> list = new ArrayList<>(1);
			list.add(new GFAXRefStream((COSStream)object.getDirectBase(), this.baseObject, "XRefStream"));
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
	public Boolean getcontainsXRefStm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XRefStm"));
	}

	public COSObject getXRefStmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XRefStm"));
		return object;
	}

	@Override
	public String getXRefStmType() {
		COSObject XRefStm = getXRefStmValue();
		return getObjectType(XRefStm);
	}

	@Override
	public Boolean getXRefStmHasTypeInteger() {
		COSObject XRefStm = getXRefStmValue();
		return getHasTypeInteger(XRefStm);
	}

	@Override
	public Long getXRefStmIntegerValue() {
		COSObject XRefStm = getXRefStmValue();
		return getIntegerValue(XRefStm);
	}

	@Override
	public Boolean getcontainsXRefStream() {
		return getcontainsXRefStm();
	}

	public COSObject getXRefStreamValue() {
		Long offset = getXRefStmIntegerValue();
		COSObject object = offset != null ? StaticResources.getDocument().getDocument().getObject(offset) : null;
		return object;
	}

	@Override
	public String getXRefStreamType() {
		COSObject XRefStream = getXRefStreamValue();
		return getObjectType(XRefStream);
	}

	@Override
	public Boolean getXRefStreamHasTypeStream() {
		COSObject XRefStream = getXRefStreamValue();
		return getHasTypeStream(XRefStream);
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
