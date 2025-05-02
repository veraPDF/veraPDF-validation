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

public class GFAArrayOfCIP4_FinishedDimensions extends GFAObject implements AArrayOfCIP4_FinishedDimensions {

	public GFAArrayOfCIP4_FinishedDimensions(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfCIP4_FinishedDimensions");
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
	public String getentry0Type() {
		COSObject entry0 = getentry0Value();
		return getObjectType(entry0);
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		COSObject entry0 = getentry0Value();
		return getHasTypeNumber(entry0);
	}

	@Override
	public Double getentry0NumberValue() {
		COSObject entry0 = getentry0Value();
		return getNumberValue(entry0);
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
	public String getentry1Type() {
		COSObject entry1 = getentry1Value();
		return getObjectType(entry1);
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		COSObject entry1 = getentry1Value();
		return getHasTypeNumber(entry1);
	}

	@Override
	public Double getentry1NumberValue() {
		COSObject entry1 = getentry1Value();
		return getNumberValue(entry1);
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
	public String getentry2Type() {
		COSObject entry2 = getentry2Value();
		return getObjectType(entry2);
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject entry2 = getentry2Value();
		return getHasTypeNumber(entry2);
	}

	@Override
	public Double getentry2NumberValue() {
		COSObject entry2 = getentry2Value();
		return getNumberValue(entry2);
	}

}
