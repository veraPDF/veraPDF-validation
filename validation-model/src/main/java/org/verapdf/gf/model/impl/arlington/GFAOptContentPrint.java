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

public class GFAOptContentPrint extends GFAObject implements AOptContentPrint {

	public GFAOptContentPrint(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentPrint");
	}

	@Override
	public Boolean getcontainsPrintState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintState"));
	}

	public COSObject getPrintStateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintState"));
		return object;
	}

	@Override
	public Boolean getPrintStateHasTypeName() {
		COSObject object = getPrintStateValue();
		return getHasTypeName(object);
	}

	@Override
	public String getPrintStateNameValue() {
		COSObject object = getPrintStateValue();
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

}
