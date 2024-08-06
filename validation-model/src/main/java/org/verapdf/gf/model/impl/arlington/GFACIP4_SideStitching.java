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

public class GFACIP4_SideStitching extends GFAObject implements ACIP4_SideStitching {

	public GFACIP4_SideStitching(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_SideStitching");
	}

	@Override
	public Boolean getcontainsCIP4_StitchNumber() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_StitchNumber"));
	}

	public COSObject getCIP4_StitchNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_StitchNumber"));
		return object;
	}

	@Override
	public String getCIP4_StitchNumberType() {
		COSObject CIP4_StitchNumber = getCIP4_StitchNumberValue();
		return getObjectType(CIP4_StitchNumber);
	}

	@Override
	public Boolean getCIP4_StitchNumberHasTypeInteger() {
		COSObject CIP4_StitchNumber = getCIP4_StitchNumberValue();
		return getHasTypeInteger(CIP4_StitchNumber);
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
