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

public class GFADevExtensions extends GFAObject implements ADevExtensions {

	public GFADevExtensions(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADevExtensions");
	}

	@Override
	public Boolean getcontainsBaseVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaseVersion"));
	}

	public COSObject getBaseVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseVersion"));
		return object;
	}

	@Override
	public Boolean getisBaseVersionIndirect() {
		COSObject object = getBaseVersionValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getBaseVersionHasTypeName() {
		COSObject object = getBaseVersionValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBaseVersionNameValue() {
		COSObject object = getBaseVersionValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsExtensionLevel() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExtensionLevel"));
	}

	public COSObject getExtensionLevelValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtensionLevel"));
		return object;
	}

	@Override
	public Boolean getisExtensionLevelIndirect() {
		COSObject object = getExtensionLevelValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getExtensionLevelHasTypeInteger() {
		COSObject object = getExtensionLevelValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsExtensionRevision() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExtensionRevision"));
	}

	public COSObject getExtensionRevisionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtensionRevision"));
		return object;
	}

	@Override
	public Boolean getisExtensionRevisionIndirect() {
		COSObject object = getExtensionRevisionValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getExtensionRevisionHasTypeStringText() {
		COSObject object = getExtensionRevisionValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
		COSObject object = getTypeValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsURL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URL"));
	}

	public COSObject getURLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URL"));
		return object;
	}

	@Override
	public Boolean getisURLIndirect() {
		COSObject object = getURLValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getURLHasTypeString() {
		COSObject object = getURLValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

}
