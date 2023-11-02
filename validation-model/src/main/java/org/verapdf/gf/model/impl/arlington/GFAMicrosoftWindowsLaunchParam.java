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

public class GFAMicrosoftWindowsLaunchParam extends GFAObject implements AMicrosoftWindowsLaunchParam {

	public GFAMicrosoftWindowsLaunchParam(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMicrosoftWindowsLaunchParam");
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object;
	}

	@Override
	public String getDType() {
		COSObject D = getDValue();
		return getObjectType(D);
	}

	@Override
	public Boolean getDHasTypeStringByte() {
		COSObject D = getDValue();
		return getHasTypeStringByte(D);
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object;
	}

	@Override
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeStringByte() {
		COSObject F = getFValue();
		return getHasTypeStringByte(F);
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getODefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSString.construct("open".getBytes());
		}
		return null;
	}

	public COSObject getOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null || object.empty()) {
			object = getODefaultValue();
		}
		return object;
	}

	@Override
	public String getOType() {
		COSObject O = getOValue();
		return getObjectType(O);
	}

	@Override
	public Boolean getOHasTypeStringAscii() {
		COSObject O = getOValue();
		return getHasTypeStringAscii(O);
	}

	@Override
	public String getOStringAsciiValue() {
		COSObject O = getOValue();
		return getStringAsciiValue(O);
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
	public Boolean getPHasTypeStringByte() {
		COSObject P = getPValue();
		return getHasTypeStringByte(P);
	}

}
