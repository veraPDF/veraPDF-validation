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

public class GFAEncryptionPublicKey extends GFAObject implements AEncryptionPublicKey {

	public GFAEncryptionPublicKey(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AEncryptionPublicKey");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CF":
				return getCF();
			case "Recipients":
				return getRecipients();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getCF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCF1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getCF1_5() {
		COSObject object = getCFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getCFDictionary1_5(object.getDirectBase(), "CF");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getCFDictionary1_5(COSBase base, String keyName) {
		COSBase objectBase = COSDictionary.construct().getDirectBase();
		for (ASAtom key : base.getKeySet()) {
			COSObject obj = base.getKey(key);
			if (obj != null && obj.getDirectBase() != null) {
				objectBase = obj.getDirectBase();
				break;
			}
		}
		if (objectBase.knownKey(ASAtom.getASAtom("Recipients"))) {
			return new GFACryptFilterPublicKeyMap(base, this.baseObject, keyName);
		}
		return new GFACryptFilterMap(base, this.baseObject, keyName);
	}

	private List<AArrayOfStringsByte> getRecipients() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRecipients1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getRecipients1_3() {
		COSObject object = getRecipientsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "Recipients"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CF"));
	}

	public COSObject getCFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CF"));
		return object;
	}

	@Override
	public String getCFType() {
		COSObject CF = getCFValue();
		return getObjectType(CF);
	}

	@Override
	public Boolean getCFHasTypeDictionary() {
		COSObject CF = getCFValue();
		return getHasTypeDictionary(CF);
	}

	@Override
	public Boolean getcontainsEFF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EFF"));
	}

	public COSObject getEFFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EFF"));
		return object;
	}

	@Override
	public String getEFFType() {
		COSObject EFF = getEFFValue();
		return getObjectType(EFF);
	}

	@Override
	public Boolean getEFFHasTypeName() {
		COSObject EFF = getEFFValue();
		return getHasTypeName(EFF);
	}

	@Override
	public String getEFFNameValue() {
		COSObject EFF = getEFFValue();
		return getNameValue(EFF);
	}

	@Override
	public Boolean getcontainsEncryptMetadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EncryptMetadata"));
	}

	public COSObject getEncryptMetadataDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getEncryptMetadataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EncryptMetadata"));
		if (object == null || object.empty()) {
			object = getEncryptMetadataDefaultValue();
		}
		return object;
	}

	@Override
	public String getEncryptMetadataType() {
		COSObject EncryptMetadata = getEncryptMetadataValue();
		return getObjectType(EncryptMetadata);
	}

	@Override
	public Boolean getEncryptMetadataHasTypeBoolean() {
		COSObject EncryptMetadata = getEncryptMetadataValue();
		return getHasTypeBoolean(EncryptMetadata);
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
	public String getFilterType() {
		COSObject Filter = getFilterValue();
		return getObjectType(Filter);
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
	public Boolean getcontainsKDFSalt() {
		return this.baseObject.knownKey(ASAtom.getASAtom("KDFSalt"));
	}

	public COSObject getKDFSaltValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("KDFSalt"));
		return object;
	}

	@Override
	public Boolean getisKDFSaltIndirect() {
		COSObject KDFSalt = getKDFSaltValue();
		return getisIndirect(KDFSalt);
	}

	@Override
	public String getKDFSaltType() {
		COSObject KDFSalt = getKDFSaltValue();
		return getObjectType(KDFSalt);
	}

	@Override
	public Boolean getKDFSaltHasTypeStringByte() {
		COSObject KDFSalt = getKDFSaltValue();
		return getHasTypeStringByte(KDFSalt);
	}

	@Override
	public Boolean getcontainsLength() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Length"));
	}

	public COSObject getLengthDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(40L);
		}
		return null;
	}

	public COSObject getLengthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
		if (object == null || object.empty()) {
			object = getLengthDefaultValue();
		}
		return object;
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
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			object = getPDefaultValue();
		}
		return object;
	}

	@Override
	public String getPType() {
		COSObject P = getPValue();
		return getObjectType(P);
	}

	@Override
	public Boolean getPHasTypeBitmask() {
		COSObject P = getPValue();
		return getHasTypeBitmask(P);
	}

	@Override
	public Long getPBitmaskValue() {
		COSObject P = getPValue();
		return getBitmaskValue(P);
	}

	@Override
	public Boolean getcontainsRecipients() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Recipients"));
	}

	public COSObject getRecipientsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Recipients"));
		return object;
	}

	@Override
	public String getRecipientsType() {
		COSObject Recipients = getRecipientsValue();
		return getObjectType(Recipients);
	}

	@Override
	public Boolean getRecipientsHasTypeArray() {
		COSObject Recipients = getRecipientsValue();
		return getHasTypeArray(Recipients);
	}

	@Override
	public Boolean getcontainsStmF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StmF"));
	}

	public COSObject getStmFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Identity");
		}
		return null;
	}

	public COSObject getStmFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StmF"));
		if (object == null || object.empty()) {
			object = getStmFDefaultValue();
		}
		return object;
	}

	@Override
	public String getStmFType() {
		COSObject StmF = getStmFValue();
		return getObjectType(StmF);
	}

	@Override
	public Boolean getStmFHasTypeName() {
		COSObject StmF = getStmFValue();
		return getHasTypeName(StmF);
	}

	@Override
	public String getStmFNameValue() {
		COSObject StmF = getStmFValue();
		return getNameValue(StmF);
	}

	@Override
	public Boolean getcontainsStrF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StrF"));
	}

	public COSObject getStrFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Identity");
		}
		return null;
	}

	public COSObject getStrFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StrF"));
		if (object == null || object.empty()) {
			object = getStrFDefaultValue();
		}
		return object;
	}

	@Override
	public String getStrFType() {
		COSObject StrF = getStrFValue();
		return getObjectType(StrF);
	}

	@Override
	public Boolean getStrFHasTypeName() {
		COSObject StrF = getStrFValue();
		return getHasTypeName(StrF);
	}

	@Override
	public String getStrFNameValue() {
		COSObject StrF = getStrFValue();
		return getNameValue(StrF);
	}

	@Override
	public Boolean getcontainsSubFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SubFilter"));
	}

	public COSObject getSubFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubFilter"));
		return object;
	}

	@Override
	public String getSubFilterType() {
		COSObject SubFilter = getSubFilterValue();
		return getObjectType(SubFilter);
	}

	@Override
	public Boolean getSubFilterHasTypeName() {
		COSObject SubFilter = getSubFilterValue();
		return getHasTypeName(SubFilter);
	}

	@Override
	public String getSubFilterNameValue() {
		COSObject SubFilter = getSubFilterValue();
		return getNameValue(SubFilter);
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object;
	}

	@Override
	public String getVType() {
		COSObject V = getVValue();
		return getObjectType(V);
	}

	@Override
	public Boolean getVHasTypeInteger() {
		COSObject V = getVValue();
		return getHasTypeInteger(V);
	}

	@Override
	public Long getVIntegerValue() {
		COSObject V = getVValue();
		return getIntegerValue(V);
	}

}
