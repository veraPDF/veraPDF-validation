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

public class GFAArrayOf_9Numbers extends GFAObject implements AArrayOf_9Numbers {

	public GFAArrayOf_9Numbers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_9Numbers");
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
		COSObject entry0 = getentry0Value();
		return getHasTypeNumber(entry0);
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
		COSObject entry1 = getentry1Value();
		return getHasTypeNumber(entry1);
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
		COSObject entry2 = getentry2Value();
		return getHasTypeNumber(entry2);
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
		COSObject entry3 = getentry3Value();
		return getHasTypeNumber(entry3);
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
		COSObject entry4 = getentry4Value();
		return getHasTypeNumber(entry4);
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
		COSObject entry5 = getentry5Value();
		return getHasTypeNumber(entry5);
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
		COSObject entry6 = getentry6Value();
		return getHasTypeNumber(entry6);
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
		COSObject entry7 = getentry7Value();
		return getHasTypeNumber(entry7);
	}

	public COSObject getentry8Value() {
		if (this.baseObject.size() <= 8) {
			return null;
		}
		COSObject object = this.baseObject.at(8);
		return object;
	}

	@Override
	public Boolean getentry8HasTypeNumber() {
		COSObject entry8 = getentry8Value();
		return getHasTypeNumber(entry8);
	}

}
