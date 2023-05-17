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
	public Boolean getCFHasTypeDictionary() {
		COSObject object = getCFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
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
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object;
	}

	@Override
	public Boolean getOHasTypeStringByte() {
		COSObject object = getOValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getOStringSize() {
		COSObject object = getOValue();
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
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
	public Boolean getOEHasTypeStringByte() {
		COSObject object = getOEValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getOEStringSize() {
		COSObject object = getOEValue();
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
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
	public Boolean getPHasTypeBitmask() {
		COSObject object = getPValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
	public Boolean getcontainsPerms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Perms"));
	}

	public COSObject getPermsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Perms"));
		return object;
	}

	@Override
	public Boolean getPermsHasTypeStringByte() {
		COSObject object = getPermsValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getRHasTypeInteger() {
		COSObject object = getRValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRIntegerValue() {
		COSObject object = getRValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getUHasTypeStringByte() {
		COSObject object = getUValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getUStringSize() {
		COSObject object = getUValue();
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
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
	public Boolean getUEHasTypeStringByte() {
		COSObject object = getUEValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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