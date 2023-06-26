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
	public Boolean getAOHasTypeInteger() {
		COSObject object = getAOValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getAOIntegerValue() {
		COSObject object = getAOValue();
		return getIntegerValue(object);
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
	public Boolean getPlayCountHasTypeInteger() {
		COSObject object = getPlayCountValue();
		return getHasTypeInteger(object);
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
	public Boolean getSpeedHasTypeNumber() {
		COSObject object = getSpeedValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getSpeedNumberValue() {
		COSObject object = getSpeedValue();
		return getNumberValue(object);
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
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		return getNameValue(object);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

	@Override
	public Boolean gethasExtensionISO_TS_32007() {
		return false;
	}

}
