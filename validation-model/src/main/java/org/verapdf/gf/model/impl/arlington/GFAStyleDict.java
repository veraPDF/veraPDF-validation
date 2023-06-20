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

public class GFAStyleDict extends GFAObject implements AStyleDict {

	public GFAStyleDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AStyleDict");
	}

	@Override
	public Boolean getcontainsPanose() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Panose"));
	}

	public COSObject getPanoseValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Panose"));
		return object;
	}

	@Override
	public Boolean getPanoseHasTypeStringByte() {
		COSObject object = getPanoseValue();
		return getHasTypeStringByte(object);
	}

	@Override
	public Long getPanoseStringSize() {
		COSObject object = getPanoseValue();
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
		}
		return null;
	}

}
