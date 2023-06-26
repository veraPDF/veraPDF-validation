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

public class GFAPageLabel extends GFAObject implements APageLabel {

	public GFAPageLabel(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APageLabel");
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object;
	}

	@Override
	public Boolean getPHasTypeStringText() {
		COSObject object = getPValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object;
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject object = getSValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSNameValue() {
		COSObject object = getSValue();
		return getNameValue(object);
	}

	@Override
	public Boolean getcontainsSt() {
		return this.baseObject.knownKey(ASAtom.getASAtom("St"));
	}

	public COSObject getStDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
	}

	public COSObject getStValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("St"));
		if (object == null || object.empty()) {
			object = getStDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getStHasTypeInteger() {
		COSObject object = getStValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getStIntegerValue() {
		COSObject object = getStValue();
		return getIntegerValue(object);
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
