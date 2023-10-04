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

public class GFAArrayOf3PDUNames extends GFAObject implements AArrayOf3PDUNames {

	public GFAArrayOf3PDUNames(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf3PDUNames");
	}

	@Override
	public Boolean getcontains0() {
		return this.baseObject.size() > 0;
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
	public String getentry0NameValue() {
		COSObject entry0 = getentry0Value();
		return getNameValue(entry0);
	}

	@Override
	public Boolean getcontains1() {
		return this.baseObject.size() > 1;
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
	public String getentry1NameValue() {
		COSObject entry1 = getentry1Value();
		return getNameValue(entry1);
	}

	@Override
	public Boolean getcontains2() {
		return this.baseObject.size() > 2;
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
	public String getentry2NameValue() {
		COSObject entry2 = getentry2Value();
		return getNameValue(entry2);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
