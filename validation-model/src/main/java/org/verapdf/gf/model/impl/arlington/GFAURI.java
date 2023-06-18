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

public class GFAURI extends GFAObject implements AURI {

	public GFAURI(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AURI");
	}

	@Override
	public Boolean getcontainsBase() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Base"));
	}

	public COSObject getBaseValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Base"));
		return object;
	}

	@Override
	public Boolean getBaseHasTypeStringAscii() {
		COSObject object = getBaseValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

}
