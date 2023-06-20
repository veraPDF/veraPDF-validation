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
		COSObject object = getentry0Value();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getentry0HasTypeStringByte() {
		COSObject object = getentry0Value();
		return getHasTypeStringByte(object);
	}

	@Override
	public Long getentry0IntegerValue() {
		COSObject object = getentry0Value();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Long getentry0StringSize() {
		COSObject object = getentry0Value();
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
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
		COSObject object = getentry1Value();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getentry1IntegerValue() {
		COSObject object = getentry1Value();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

}
