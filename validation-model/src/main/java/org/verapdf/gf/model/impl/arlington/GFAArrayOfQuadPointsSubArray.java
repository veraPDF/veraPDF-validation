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

public class GFAArrayOfQuadPointsSubArray extends GFAObject implements AArrayOfQuadPointsSubArray {

	public GFAArrayOfQuadPointsSubArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfQuadPointsSubArray");
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
	public String getentry1Type() {
		COSObject entry1 = getentry1Value();
		return getObjectType(entry1);
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
	public String getentry2Type() {
		COSObject entry2 = getentry2Value();
		return getObjectType(entry2);
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
	public String getentry3Type() {
		COSObject entry3 = getentry3Value();
		return getObjectType(entry3);
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
	public String getentry4Type() {
		COSObject entry4 = getentry4Value();
		return getObjectType(entry4);
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
	public String getentry5Type() {
		COSObject entry5 = getentry5Value();
		return getObjectType(entry5);
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
	public String getentry6Type() {
		COSObject entry6 = getentry6Value();
		return getObjectType(entry6);
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
	public String getentry7Type() {
		COSObject entry7 = getentry7Value();
		return getObjectType(entry7);
	}

	@Override
	public Boolean getentry7HasTypeNumber() {
		COSObject entry7 = getentry7Value();
		return getHasTypeNumber(entry7);
	}

}
