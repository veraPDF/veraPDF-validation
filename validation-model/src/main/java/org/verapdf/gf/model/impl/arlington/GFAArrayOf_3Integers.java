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

public class GFAArrayOf_3Integers extends GFAObject implements AArrayOf_3Integers {

	public GFAArrayOf_3Integers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_3Integers");
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

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public String getentry2Type() {
		COSObject entry2 = getentry2Value();
		return getObjectType(entry2);
	}

	@Override
	public Boolean getentry2HasTypeInteger() {
		COSObject entry2 = getentry2Value();
		return getHasTypeInteger(entry2);
	}

	@Override
	public Long getentry2IntegerValue() {
		COSObject entry2 = getentry2Value();
		return getIntegerValue(entry2);
	}

}
