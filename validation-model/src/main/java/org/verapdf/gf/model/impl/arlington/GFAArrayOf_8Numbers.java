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

public class GFAArrayOf_8Numbers extends GFAObject implements AArrayOf_8Numbers {

	public GFAArrayOf_8Numbers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_8Numbers");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
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
	public Boolean getentry2HasTypeNumber() {
		COSObject object = getentry2Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getentry3HasTypeNumber() {
		COSObject object = getentry3Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry4Value() {
		if (this.baseObject.size() <= 4) {
			return null;
		}
		COSObject object = this.baseObject.at(4);
		return object;
	}

	@Override
	public Boolean getentry4HasTypeNumber() {
		COSObject object = getentry4Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry5Value() {
		if (this.baseObject.size() <= 5) {
			return null;
		}
		COSObject object = this.baseObject.at(5);
		return object;
	}

	@Override
	public Boolean getentry5HasTypeNumber() {
		COSObject object = getentry5Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry6Value() {
		if (this.baseObject.size() <= 6) {
			return null;
		}
		COSObject object = this.baseObject.at(6);
		return object;
	}

	@Override
	public Boolean getentry6HasTypeNumber() {
		COSObject object = getentry6Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry7Value() {
		if (this.baseObject.size() <= 7) {
			return null;
		}
		COSObject object = this.baseObject.at(7);
		return object;
	}

	@Override
	public Boolean getentry7HasTypeNumber() {
		COSObject object = getentry7Value();
		return getHasTypeNumber(object);
	}

}
