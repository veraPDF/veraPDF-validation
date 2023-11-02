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

public class GFACryptFilterPublicKey extends GFAObject implements ACryptFilterPublicKey {

	public GFACryptFilterPublicKey(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACryptFilterPublicKey");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Recipients":
				return getRecipients();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStringsByte> getRecipients() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRecipients1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getRecipients1_5() {
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
	public Boolean getcontainsAuthEvent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AuthEvent"));
	}

	public COSObject getAuthEventDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("DocOpen");
		}
		return null;
	}

	public COSObject getAuthEventValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthEvent"));
		if (object == null || object.empty()) {
			object = getAuthEventDefaultValue();
		}
		return object;
	}

	@Override
	public String getAuthEventType() {
		COSObject AuthEvent = getAuthEventValue();
		return getObjectType(AuthEvent);
	}

	@Override
	public Boolean getAuthEventHasTypeName() {
		COSObject AuthEvent = getAuthEventValue();
		return getHasTypeName(AuthEvent);
	}

	@Override
	public String getAuthEventNameValue() {
		COSObject AuthEvent = getAuthEventValue();
		return getNameValue(AuthEvent);
	}

	@Override
	public Boolean getcontainsCFM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CFM"));
	}

	public COSObject getCFMDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getCFMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CFM"));
		if (object == null || object.empty()) {
			object = getCFMDefaultValue();
		}
		return object;
	}

	@Override
	public String getCFMType() {
		COSObject CFM = getCFMValue();
		return getObjectType(CFM);
	}

	@Override
	public Boolean getCFMHasTypeName() {
		COSObject CFM = getCFMValue();
		return getHasTypeName(CFM);
	}

	@Override
	public String getCFMNameValue() {
		COSObject CFM = getCFMValue();
		return getNameValue(CFM);
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
	public Boolean getcontainsLength() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Length"));
	}

	public COSObject getLengthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
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
	public Boolean getRecipientsHasTypeStringByte() {
		COSObject Recipients = getRecipientsValue();
		return getHasTypeStringByte(Recipients);
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

}
