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
		COSObject BaseVersion = getBaseVersionValue();
		return getisIndirect(BaseVersion);
	}

	@Override
	public Boolean getBaseVersionHasTypeName() {
		COSObject BaseVersion = getBaseVersionValue();
		return getHasTypeName(BaseVersion);
	}

	@Override
	public String getBaseVersionNameValue() {
		COSObject BaseVersion = getBaseVersionValue();
		return getNameValue(BaseVersion);
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
		COSObject ExtensionLevel = getExtensionLevelValue();
		return getisIndirect(ExtensionLevel);
	}

	@Override
	public Boolean getExtensionLevelHasTypeInteger() {
		COSObject ExtensionLevel = getExtensionLevelValue();
		return getHasTypeInteger(ExtensionLevel);
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
		COSObject ExtensionRevision = getExtensionRevisionValue();
		return getisIndirect(ExtensionRevision);
	}

	@Override
	public Boolean getExtensionRevisionHasTypeStringText() {
		COSObject ExtensionRevision = getExtensionRevisionValue();
		return getHasTypeStringText(ExtensionRevision);
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
		COSObject Type = getTypeValue();
		return getisIndirect(Type);
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
		COSObject URL = getURLValue();
		return getisIndirect(URL);
	}

	@Override
	public Boolean getURLHasTypeString() {
		COSObject URL = getURLValue();
		return getHasTypeString(URL);
	}

}
