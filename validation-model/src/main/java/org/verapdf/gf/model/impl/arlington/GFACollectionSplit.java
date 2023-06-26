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
	public Boolean getDirectionHasTypeName() {
		COSObject object = getDirectionValue();
		return getHasTypeName(object);
	}

	@Override
	public String getDirectionNameValue() {
		COSObject object = getDirectionValue();
		return getNameValue(object);
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
	public Boolean getPositionHasTypeNumber() {
		COSObject object = getPositionValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getPositionNumberValue() {
		COSObject object = getPositionValue();
		return getNumberValue(object);
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
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		return getNameValue(object);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
