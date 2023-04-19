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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Recipients"));
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

	@Override
	public Boolean getAuthEventHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthEvent"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getAuthEventNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthEvent"));
		if (object == null || object.empty()) {
			return getAuthEventNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getAuthEventNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "DocOpen";
		}
		return null;
	}

	@Override
	public Boolean getcontainsCFM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CFM"));
	}

	@Override
	public Boolean getCFMHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CFM"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getCFMNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CFM"));
		if (object == null || object.empty()) {
			return getCFMNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getCFMNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "None";
		}
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
		return null;
	}

	@Override
	public Boolean getcontainsRecipients() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Recipients"));
	}

	@Override
	public Boolean getRecipientsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Recipients"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getRecipientsHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Recipients"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

}
