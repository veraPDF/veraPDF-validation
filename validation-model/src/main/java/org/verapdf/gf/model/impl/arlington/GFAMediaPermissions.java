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

public class GFAMediaPermissions extends GFAObject implements AMediaPermissions {

	public GFAMediaPermissions(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMediaPermissions");
	}

	@Override
	public Boolean getcontainsTF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TF"));
	}

	public COSObject getTFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSString.construct("TEMPNEVER".getBytes());
		}
		return null;
	}

	public COSObject getTFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TF"));
		if (object == null || object.empty()) {
			object = getTFDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getTFHasTypeStringAscii() {
		COSObject object = getTFValue();
		return getHasTypeStringAscii(object);
	}

	@Override
	public String getTFStringAsciiValue() {
		COSObject object = getTFValue();
		return getStringAsciiValue(object);
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
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		return getNameValue(object);
	}

}
