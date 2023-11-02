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

public class GFARichMediaAnimation extends GFAObject implements ARichMediaAnimation {

	public GFARichMediaAnimation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaAnimation");
	}

	@Override
	public Boolean getcontainsAO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AO"));
	}

	public COSObject getAODefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getAOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AO"));
		if (object == null || object.empty()) {
			object = getAODefaultValue();
		}
		return object;
	}

	@Override
	public String getAOType() {
		COSObject AO = getAOValue();
		return getObjectType(AO);
	}

	@Override
	public Boolean getAOHasTypeInteger() {
		COSObject AO = getAOValue();
		return getHasTypeInteger(AO);
	}

	@Override
	public Long getAOIntegerValue() {
		COSObject AO = getAOValue();
		return getIntegerValue(AO);
	}

	@Override
	public Boolean getcontainsPlayCount() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PlayCount"));
	}

	public COSObject getPlayCountDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(-1L);
		}
		return null;
	}

	public COSObject getPlayCountValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PlayCount"));
		if (object == null || object.empty()) {
			object = getPlayCountDefaultValue();
		}
		return object;
	}

	@Override
	public String getPlayCountType() {
		COSObject PlayCount = getPlayCountValue();
		return getObjectType(PlayCount);
	}

	@Override
	public Boolean getPlayCountHasTypeInteger() {
		COSObject PlayCount = getPlayCountValue();
		return getHasTypeInteger(PlayCount);
	}

	@Override
	public Boolean getcontainsSpeed() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Speed"));
	}

	public COSObject getSpeedDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getSpeedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Speed"));
		if (object == null || object.empty()) {
			object = getSpeedDefaultValue();
		}
		return object;
	}

	@Override
	public String getSpeedType() {
		COSObject Speed = getSpeedValue();
		return getObjectType(Speed);
	}

	@Override
	public Boolean getSpeedHasTypeNumber() {
		COSObject Speed = getSpeedValue();
		return getHasTypeNumber(Speed);
	}

	@Override
	public Double getSpeedNumberValue() {
		COSObject Speed = getSpeedValue();
		return getNumberValue(Speed);
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			object = getSubtypeDefaultValue();
		}
		return object;
	}

	@Override
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

	@Override
	public Boolean gethasExtensionISO_TS_32007() {
		return false;
	}

}
