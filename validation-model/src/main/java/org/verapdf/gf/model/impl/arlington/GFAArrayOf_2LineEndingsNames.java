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

public class GFAArrayOf_2LineEndingsNames extends GFAObject implements AArrayOf_2LineEndingsNames {

	public GFAArrayOf_2LineEndingsNames(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_2LineEndingsNames");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public String getentry0Type() {
		COSObject entry0 = getentry0Value();
		return getObjectType(entry0);
	}

	@Override
	public Boolean getentry0HasTypeName() {
		COSObject entry0 = getentry0Value();
		return getHasTypeName(entry0);
	}

	@Override
	public String getentry0NameValue() {
		COSObject entry0 = getentry0Value();
		return getNameValue(entry0);
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public String getentry1Type() {
		COSObject entry1 = getentry1Value();
		return getObjectType(entry1);
	}

	@Override
	public Boolean getentry1HasTypeName() {
		COSObject entry1 = getentry1Value();
		return getHasTypeName(entry1);
	}

	@Override
	public String getentry1NameValue() {
		COSObject entry1 = getentry1Value();
		return getNameValue(entry1);
	}

}
