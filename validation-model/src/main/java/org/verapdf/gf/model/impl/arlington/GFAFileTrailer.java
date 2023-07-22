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
		GFAObject.clearAllContainers();
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AuthCode":
				return getAuthCode();
			case "Encrypt":
				return getEncrypt();
			case "entryID":
				return getentryID();
			case "Info":
				return getInfo();
			case "LinearizationParameterDict":
				return getLinearizationParameterDict();
			case "Root":
				return getRoot();
			case "XRefStream":
				return getXRefStream();
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

	private List<ALinearizationParameterDict> getLinearizationParameterDict() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLinearizationParameterDict1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ALinearizationParameterDict> getLinearizationParameterDict1_2() {
		COSObject object = getLinearizationParameterDictValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ALinearizationParameterDict> list = new ArrayList<>(1);
			list.add(new GFALinearizationParameterDict((COSDictionary)object.getDirectBase(), this.baseObject, "LinearizationParameterDict"));
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
	public Boolean getcontainsLinearizationParameterDict() {
		return getLinearizationParameterDictValue() != null;
	}

	public COSObject getLinearizationParameterDictValue() {
		COSObject object = StaticResources.getDocument().getDocument().getLinearizationDictionary();
		return object;
	}

	@Override
	public Boolean getLinearizationParameterDictHasTypeDictionary() {
		COSObject object = getLinearizationParameterDictValue();
		return getHasTypeDictionary(object);
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
		return getIntegerValue(object);
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
		return getIntegerValue(object);
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
	public Boolean getXRefStmHasTypeInteger() {
		COSObject object = getXRefStmValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getXRefStmIntegerValue() {
		COSObject object = getXRefStmValue();
		return getIntegerValue(object);
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
	public Boolean getXRefStreamHasTypeStream() {
		COSObject object = getXRefStreamValue();
		return getHasTypeStream(object);
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
		return getIntegerValue(V);
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
