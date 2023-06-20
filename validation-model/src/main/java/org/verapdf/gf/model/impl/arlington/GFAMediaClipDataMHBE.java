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

public class GFAMediaClipDataMHBE extends GFAObject implements AMediaClipDataMHBE {

	public GFAMediaClipDataMHBE(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMediaClipDataMHBE");
	}

	@Override
	public Boolean getcontainsBU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BU"));
	}

	public COSObject getBUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BU"));
		return object;
	}

	@Override
	public Boolean getBUHasTypeStringAscii() {
		COSObject object = getBUValue();
		return getHasTypeStringAscii(object);
	}

}
