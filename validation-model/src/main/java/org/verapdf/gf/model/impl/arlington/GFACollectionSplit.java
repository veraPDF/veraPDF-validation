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

public class GFACollectionSplit extends GFAObject implements ACollectionSplit {

	public GFACollectionSplit(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACollectionSplit");
	}

	@Override
	public Boolean getcontainsDirection() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Direction"));
	}

	public COSObject getDirectionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Direction"));
		return object;
	}

	@Override
	public String getDirectionType() {
		COSObject Direction = getDirectionValue();
		return getObjectType(Direction);
	}

	@Override
	public Boolean getDirectionHasTypeName() {
		COSObject Direction = getDirectionValue();
		return getHasTypeName(Direction);
	}

	@Override
	public String getDirectionNameValue() {
		COSObject Direction = getDirectionValue();
		return getNameValue(Direction);
	}

	@Override
	public Boolean getcontainsPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Position"));
	}

	public COSObject getPositionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		return object;
	}

	@Override
	public String getPositionType() {
		COSObject Position = getPositionValue();
		return getObjectType(Position);
	}

	@Override
	public Boolean getPositionHasTypeNumber() {
		COSObject Position = getPositionValue();
		return getHasTypeNumber(Position);
	}

	@Override
	public Double getPositionNumberValue() {
		COSObject Position = getPositionValue();
		return getNumberValue(Position);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
