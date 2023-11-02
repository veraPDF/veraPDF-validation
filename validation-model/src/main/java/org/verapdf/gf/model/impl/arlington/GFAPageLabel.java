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
	public String getPType() {
		COSObject P = getPValue();
		return getObjectType(P);
	}

	@Override
	public Boolean getPHasTypeStringText() {
		COSObject P = getPValue();
		return getHasTypeStringText(P);
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
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject S = getSValue();
		return getHasTypeName(S);
	}

	@Override
	public String getSNameValue() {
		COSObject S = getSValue();
		return getNameValue(S);
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
	public String getStType() {
		COSObject St = getStValue();
		return getObjectType(St);
	}

	@Override
	public Boolean getStHasTypeInteger() {
		COSObject St = getStValue();
		return getHasTypeInteger(St);
	}

	@Override
	public Long getStIntegerValue() {
		COSObject St = getStValue();
		return getIntegerValue(St);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
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

}
