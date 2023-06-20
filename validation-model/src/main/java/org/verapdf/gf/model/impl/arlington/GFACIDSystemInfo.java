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

public class GFACIDSystemInfo extends GFAObject implements ACIDSystemInfo {

	public GFACIDSystemInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIDSystemInfo");
	}

	@Override
	public Boolean getcontainsOrdering() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ordering"));
	}

	public COSObject getOrderingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ordering"));
		return object;
	}

	@Override
	public Boolean getOrderingHasTypeStringAscii() {
		COSObject object = getOrderingValue();
		return getHasTypeStringAscii(object);
	}

	@Override
	public Boolean getcontainsRegistry() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Registry"));
	}

	public COSObject getRegistryValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Registry"));
		return object;
	}

	@Override
	public Boolean getRegistryHasTypeStringAscii() {
		COSObject object = getRegistryValue();
		return getHasTypeStringAscii(object);
	}

	@Override
	public Boolean getcontainsSupplement() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Supplement"));
	}

	public COSObject getSupplementValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Supplement"));
		return object;
	}

	@Override
	public Boolean getSupplementHasTypeInteger() {
		COSObject object = getSupplementValue();
		return getHasTypeInteger(object);
	}

}
