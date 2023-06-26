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
	public Boolean getentry0HasTypeInteger() {
		COSObject object = getentry0Value();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getentry0IntegerValue() {
		COSObject object = getentry0Value();
		return getIntegerValue(object);
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeInteger() {
		COSObject object = getentry1Value();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getentry1IntegerValue() {
		COSObject object = getentry1Value();
		return getIntegerValue(object);
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeInteger() {
		COSObject object = getentry2Value();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getentry2IntegerValue() {
		COSObject object = getentry2Value();
		return getIntegerValue(object);
	}

}
