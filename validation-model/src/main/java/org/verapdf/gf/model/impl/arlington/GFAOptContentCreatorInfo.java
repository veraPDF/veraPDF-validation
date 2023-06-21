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

public class GFAOptContentCreatorInfo extends GFAObject implements AOptContentCreatorInfo {

	public GFAOptContentCreatorInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentCreatorInfo");
	}

	@Override
	public Boolean getcontainsCreator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Creator"));
	}

	public COSObject getCreatorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Creator"));
		return object;
	}

	@Override
	public Boolean getCreatorHasTypeStringText() {
		COSObject object = getCreatorValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsSubType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SubType"));
	}

	public COSObject getSubTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubType"));
		return object;
	}

	@Override
	public Boolean getSubTypeHasTypeName() {
		COSObject object = getSubTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSubTypeNameValue() {
		COSObject object = getSubTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean gethasExtensionMalforms() {
		return false;
	}

}
