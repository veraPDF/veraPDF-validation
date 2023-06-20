package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
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
			List<org.verapdf.model.baselayer.Object> list = Collections.emptyList();
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public Boolean getCFHasTypeDictionary() {
		COSObject object = getCFValue();
		return getHasTypeDictionary(object);
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
	public Boolean getEFFHasTypeName() {
		COSObject object = getEFFValue();
		return getHasTypeName(object);
	}

	@Override
	public String getEFFNameValue() {
		COSObject object = getEFFValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getEncryptMetadataHasTypeBoolean() {
		COSObject object = getEncryptMetadataValue();
		return getHasTypeBoolean(object);
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
	public Boolean getcontainsKDFSalt() {
		return this.baseObject.knownKey(ASAtom.getASAtom("KDFSalt"));
	}

	public COSObject getKDFSaltValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("KDFSalt"));
		return object;
	}

	@Override
	public Boolean getisKDFSaltIndirect() {
		COSObject object = getKDFSaltValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getKDFSaltHasTypeStringByte() {
		COSObject object = getKDFSaltValue();
		return getHasTypeStringByte(object);
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
	public Boolean getPHasTypeBitmask() {
		COSObject object = getPValue();
		return getHasTypeBitmask(object);
	}

	@Override
	public Long getPBitmaskValue() {
		COSObject object = getPValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
	public Boolean getRecipientsHasTypeArray() {
		COSObject object = getRecipientsValue();
		return getHasTypeArray(object);
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
	public Boolean getStmFHasTypeName() {
		COSObject object = getStmFValue();
		return getHasTypeName(object);
	}

	@Override
	public String getStmFNameValue() {
		COSObject object = getStmFValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getStrFHasTypeName() {
		COSObject object = getStrFValue();
		return getHasTypeName(object);
	}

	@Override
	public String getStrFNameValue() {
		COSObject object = getStrFValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getSubFilterHasTypeName() {
		COSObject object = getSubFilterValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSubFilterNameValue() {
		COSObject object = getSubFilterValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getVHasTypeInteger() {
		COSObject object = getVValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getVIntegerValue() {
		COSObject object = getVValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
