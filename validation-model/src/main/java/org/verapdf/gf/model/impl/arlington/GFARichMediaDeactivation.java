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

public class GFARichMediaDeactivation extends GFAObject implements ARichMediaDeactivation {

	public GFARichMediaDeactivation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaDeactivation");
	}

	@Override
	public Boolean getcontainsCondition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Condition"));
	}

	public COSObject getConditionDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("XD");
		}
		return null;
	}

	public COSObject getConditionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Condition"));
		if (object == null || object.empty()) {
			object = getConditionDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getConditionHasTypeName() {
		COSObject Condition = getConditionValue();
		return getHasTypeName(Condition);
	}

	@Override
	public String getConditionNameValue() {
		COSObject Condition = getConditionValue();
		return getNameValue(Condition);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
