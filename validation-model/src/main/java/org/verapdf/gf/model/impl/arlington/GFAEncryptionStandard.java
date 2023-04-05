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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CF"));
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
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFilterNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (object == null || object.empty()) {
			return getFilterNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFilterNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Standard";
		}
		return null;
	}

	@Override
	public Boolean getcontainsKDFSalt() {
		return this.baseObject.knownKey(ASAtom.getASAtom("KDFSalt"));
	}

	@Override
	public Boolean getisKDFSaltIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("KDFSalt"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getKDFSaltHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("KDFSalt"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsUE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UE"));
	}

	@Override
	public Boolean getUEHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UE"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U"));
	}

	@Override
	public Boolean getUHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getUStringSize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsEFF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EFF"));
	}

	@Override
	public Boolean getEFFHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EFF"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsLength() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Length"));
	}

	@Override
	public Boolean getLengthHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getLengthIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
		if (object == null || object.empty()) {
			return getLengthIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getLengthIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 40L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	@Override
	public Boolean getOHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getOStringSize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsCF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CF"));
	}

	@Override
	public Boolean getCFHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CF"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsStrF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StrF"));
	}

	@Override
	public Boolean getStrFHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StrF"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsStmF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StmF"));
	}

	@Override
	public Boolean getStmFHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StmF"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsOE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OE"));
	}

	@Override
	public Boolean getOEHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OE"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getOEStringSize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OE"));
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	@Override
	public Boolean getVHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getVIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		if (object == null || object.empty()) {
			return getVIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getVIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsEncryptMetadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EncryptMetadata"));
	}

	@Override
	public Boolean getEncryptMetadataHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EncryptMetadata"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsPerms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Perms"));
	}

	@Override
	public Boolean getPermsHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Perms"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsSubFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SubFilter"));
	}

	@Override
	public Boolean getSubFilterHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubFilter"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	@Override
	public Boolean getPHasTypeBitmask() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPBitmaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			return getPBitmaskDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getPBitmaskDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object == null || object.empty()) {
			return getRIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getRIntegerDefaultValue() {
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
