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

public class GFAArrayOf_2Integers extends GFAObject implements AArrayOf_2Integers {

	public GFAArrayOf_2Integers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_2Integers");
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
	public Boolean getentry0HasTypeInteger() {
		COSObject entry0 = getentry0Value();
		return getHasTypeInteger(entry0);
	}

	@Override
	public Long getentry0IntegerValue() {
		COSObject entry0 = getentry0Value();
		return getIntegerValue(entry0);
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
	public Boolean getentry1HasTypeInteger() {
		COSObject entry1 = getentry1Value();
		return getHasTypeInteger(entry1);
	}

	@Override
	public Long getentry1IntegerValue() {
		COSObject entry1 = getentry1Value();
		return getIntegerValue(entry1);
	}

}
