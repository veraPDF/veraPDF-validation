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

public class GFAProjection extends GFAObject implements AProjection {

	public GFAProjection(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AProjection");
	}

	@Override
	public Boolean getcontainsCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CS"));
	}

	public COSObject getCSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("ANF");
		}
		return null;
	}

	public COSObject getCSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CS"));
		if (object == null || object.empty()) {
			object = getCSDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getCSHasTypeName() {
		COSObject CS = getCSValue();
		return getHasTypeName(CS);
	}

	@Override
	public String getCSNameValue() {
		COSObject CS = getCSValue();
		return getNameValue(CS);
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
	public Boolean getFHasTypeNumber() {
		COSObject F = getFValue();
		return getHasTypeNumber(F);
	}

	@Override
	public Boolean getcontainsFOV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FOV"));
	}

	public COSObject getFOVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FOV"));
		return object;
	}

	@Override
	public Boolean getFOVHasTypeNumber() {
		COSObject FOV = getFOVValue();
		return getHasTypeNumber(FOV);
	}

	@Override
	public Double getFOVNumberValue() {
		COSObject FOV = getFOVValue();
		return getNumberValue(FOV);
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	public COSObject getNDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		if (object == null || object.empty()) {
			object = getNDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getNHasTypeNumber() {
		COSObject N = getNValue();
		return getHasTypeNumber(N);
	}

	@Override
	public Double getNNumberValue() {
		COSObject N = getNValue();
		return getNumberValue(N);
	}

	@Override
	public Boolean getcontainsOB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OB"));
	}

	public COSObject getOBDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Absolute");
		}
		return null;
	}

	public COSObject getOBValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OB"));
		if (object == null || object.empty()) {
			object = getOBDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getOBHasTypeName() {
		COSObject OB = getOBValue();
		return getHasTypeName(OB);
	}

	@Override
	public String getOBNameValue() {
		COSObject OB = getOBValue();
		return getNameValue(OB);
	}

	@Override
	public Boolean getcontainsOS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OS"));
	}

	public COSObject getOSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getOSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
		if (object == null || object.empty()) {
			object = getOSDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getOSHasTypeNumber() {
		COSObject OS = getOSValue();
		return getHasTypeNumber(OS);
	}

	@Override
	public Double getOSNumberValue() {
		COSObject OS = getOSValue();
		return getNumberValue(OS);
	}

	@Override
	public Boolean getcontainsPS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PS"));
	}

	public COSObject getPSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PS"));
		return object;
	}

	@Override
	public Boolean getPSHasTypeName() {
		COSObject PS = getPSValue();
		return getHasTypeName(PS);
	}

	@Override
	public Boolean getPSHasTypeNumber() {
		COSObject PS = getPSValue();
		return getHasTypeNumber(PS);
	}

	@Override
	public Double getPSNumberValue() {
		COSObject PS = getPSValue();
		return getNumberValue(PS);
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
	}

}
