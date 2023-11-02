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
	public String getCreatorType() {
		COSObject Creator = getCreatorValue();
		return getObjectType(Creator);
	}

	@Override
	public Boolean getCreatorHasTypeStringText() {
		COSObject Creator = getCreatorValue();
		return getHasTypeStringText(Creator);
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
	public String getSubTypeType() {
		COSObject SubType = getSubTypeValue();
		return getObjectType(SubType);
	}

	@Override
	public Boolean getSubTypeHasTypeName() {
		COSObject SubType = getSubTypeValue();
		return getHasTypeName(SubType);
	}

	@Override
	public String getSubTypeNameValue() {
		COSObject SubType = getSubTypeValue();
		return getNameValue(SubType);
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
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
	}

	@Override
	public Boolean gethasExtensionMalforms() {
		return false;
	}

}
