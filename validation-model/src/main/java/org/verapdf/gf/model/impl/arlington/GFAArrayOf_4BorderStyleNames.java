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

public class GFAArrayOf_4BorderStyleNames extends GFAObject implements AArrayOf_4BorderStyleNames {

	public GFAArrayOf_4BorderStyleNames(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_4BorderStyleNames");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeName() {
		COSObject entry0 = getentry0Value();
		return getHasTypeName(entry0);
	}

	@Override
	public Boolean getentry0HasTypeNull() {
		COSObject entry0 = getentry0Value();
		return getHasTypeNull(entry0);
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
	public Boolean getentry1HasTypeName() {
		COSObject entry1 = getentry1Value();
		return getHasTypeName(entry1);
	}

	@Override
	public Boolean getentry1HasTypeNull() {
		COSObject entry1 = getentry1Value();
		return getHasTypeNull(entry1);
	}

	@Override
	public String getentry1NameValue() {
		COSObject entry1 = getentry1Value();
		return getNameValue(entry1);
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeName() {
		COSObject entry2 = getentry2Value();
		return getHasTypeName(entry2);
	}

	@Override
	public Boolean getentry2HasTypeNull() {
		COSObject entry2 = getentry2Value();
		return getHasTypeNull(entry2);
	}

	@Override
	public String getentry2NameValue() {
		COSObject entry2 = getentry2Value();
		return getNameValue(entry2);
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getentry3HasTypeName() {
		COSObject entry3 = getentry3Value();
		return getHasTypeName(entry3);
	}

	@Override
	public Boolean getentry3HasTypeNull() {
		COSObject entry3 = getentry3Value();
		return getHasTypeNull(entry3);
	}

	@Override
	public String getentry3NameValue() {
		COSObject entry3 = getentry3Value();
		return getNameValue(entry3);
	}

}
