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

public class GFAArrayOf_3OrientationNumbers extends GFAObject implements AArrayOf_3OrientationNumbers {

	public GFAArrayOf_3OrientationNumbers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_3OrientationNumbers");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeNull() {
		COSObject object = getentry0Value();
		return getHasTypeNull(object);
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		COSObject object = getentry0Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeNull() {
		COSObject object = getentry1Value();
		return getHasTypeNull(object);
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		COSObject object = getentry1Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeNull() {
		COSObject object = getentry2Value();
		return getHasTypeNull(object);
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject object = getentry2Value();
		return getHasTypeNumber(object);
	}

}