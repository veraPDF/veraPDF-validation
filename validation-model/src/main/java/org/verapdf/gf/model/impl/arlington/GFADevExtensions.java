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

public class GFADevExtensions extends GFAObject implements ADevExtensions {

	public GFADevExtensions(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADevExtensions");
	}

	@Override
	public Boolean getcontainsBaseVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaseVersion"));
	}

	@Override
	public Boolean getisBaseVersionIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseVersion"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getBaseVersionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseVersion"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBaseVersionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseVersion"));
		if (object == null || object.empty()) {
			return getBaseVersionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getBaseVersionNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsExtensionLevel() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExtensionLevel"));
	}

	@Override
	public Boolean getisExtensionLevelIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtensionLevel"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getExtensionLevelHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtensionLevel"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsExtensionRevision() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExtensionRevision"));
	}

	@Override
	public Boolean getisExtensionRevisionIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtensionRevision"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getExtensionRevisionHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtensionRevision"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getisTypeIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.get() != null && object.get().isIndirect();
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

	@Override
	public Boolean getcontainsURL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URL"));
	}

	@Override
	public Boolean getisURLIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URL"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getURLHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URL"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

}
