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

public class GFAEncryptionStandard extends GFAObject implements AEncryptionStandard {

	public GFAEncryptionStandard(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AEncryptionStandard");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CF":
				return getCF();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACryptFilterMap> getCF() {
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

	private List<ACryptFilterMap> getCF1_5() {
		COSObject object = getCFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACryptFilterMap> list = new ArrayList<>(1);
			list.add(new GFACryptFilterMap((COSDictionary)object.getDirectBase(), this.baseObject, "CF"));
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

	public COSObject getFilterDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Standard");
		}
		return null;
	}

	public COSObject getFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (object == null || object.empty()) {
			object = getFilterDefaultValue();
		}
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
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object;
	}

	@Override
	public String getOType() {
		COSObject O = getOValue();
		return getObjectType(O);
	}

	@Override
	public Boolean getOHasTypeStringByte() {
		COSObject O = getOValue();
		return getHasTypeStringByte(O);
	}

	@Override
	public Long getOStringSize() {
		COSObject O = getOValue();
		if (O != null && O.getType() == COSObjType.COS_STRING) {
			return (long) O.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsOE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OE"));
	}

	public COSObject getOEValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OE"));
		return object;
	}

	@Override
	public String getOEType() {
		COSObject OE = getOEValue();
		return getObjectType(OE);
	}

	@Override
	public Boolean getOEHasTypeStringByte() {
		COSObject OE = getOEValue();
		return getHasTypeStringByte(OE);
	}

	@Override
	public Long getOEStringSize() {
		COSObject OE = getOEValue();
		if (OE != null && OE.getType() == COSObjType.COS_STRING) {
			return (long) OE.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
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
	public Boolean getcontainsPerms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Perms"));
	}

	public COSObject getPermsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Perms"));
		return object;
	}

	@Override
	public String getPermsType() {
		COSObject Perms = getPermsValue();
		return getObjectType(Perms);
	}

	@Override
	public Boolean getPermsHasTypeStringByte() {
		COSObject Perms = getPermsValue();
		return getHasTypeStringByte(Perms);
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object;
	}

	@Override
	public String getRType() {
		COSObject R = getRValue();
		return getObjectType(R);
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject R = getRValue();
		return getHasTypeInteger(R);
	}

	@Override
	public Long getRIntegerValue() {
		COSObject R = getRValue();
		return getIntegerValue(R);
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
	public Boolean getcontainsU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U"));
	}

	public COSObject getUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		return object;
	}

	@Override
	public String getUType() {
		COSObject U = getUValue();
		return getObjectType(U);
	}

	@Override
	public Boolean getUHasTypeStringByte() {
		COSObject U = getUValue();
		return getHasTypeStringByte(U);
	}

	@Override
	public Long getUStringSize() {
		COSObject U = getUValue();
		if (U != null && U.getType() == COSObjType.COS_STRING) {
			return (long) U.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsUE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UE"));
	}

	public COSObject getUEValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UE"));
		return object;
	}

	@Override
	public String getUEType() {
		COSObject UE = getUEValue();
		return getObjectType(UE);
	}

	@Override
	public Boolean getUEHasTypeStringByte() {
		COSObject UE = getUEValue();
		return getHasTypeStringByte(UE);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

	@Override
	public Boolean gethasExtensionISO_TS_32004() {
		return false;
	}

}
