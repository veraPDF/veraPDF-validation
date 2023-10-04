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

public class GFAArrayOfDuration extends GFAObject implements AArrayOfDuration {

	public GFAArrayOfDuration(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfDuration");
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
		COSObject entry0 = getentry0Value();
		return getHasTypeInteger(entry0);
	}

	@Override
	public Boolean getentry0HasTypeStringByte() {
		COSObject entry0 = getentry0Value();
		return getHasTypeStringByte(entry0);
	}

	@Override
	public Long getentry0IntegerValue() {
		COSObject entry0 = getentry0Value();
		return getIntegerValue(entry0);
	}

	@Override
	public Long getentry0StringSize() {
		COSObject entry0 = getentry0Value();
		if (entry0 != null && entry0.getType() == COSObjType.COS_STRING) {
			return (long) entry0.getString().length();
		}
		return null;
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
		COSObject entry1 = getentry1Value();
		return getHasTypeInteger(entry1);
	}

	@Override
	public Long getentry1IntegerValue() {
		COSObject entry1 = getentry1Value();
		return getIntegerValue(entry1);
	}

}
