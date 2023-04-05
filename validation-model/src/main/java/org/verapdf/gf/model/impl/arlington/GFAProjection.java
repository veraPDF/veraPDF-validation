package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import java.io.IOException;

public class GFAProjection extends GFAObject implements AProjection {

	public GFAProjection(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AProjection");
	}

	@Override
	public Boolean getcontainsPS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PS"));
	}

	@Override
	public Boolean getPSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PS"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getPSHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PS"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getPSNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PS"));
		if (object == null || object.empty()) {
			return getPSNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getPSNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			return getSubtypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSubtypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsOB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OB"));
	}

	@Override
	public Boolean getOBHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OB"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getOBNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OB"));
		if (object == null || object.empty()) {
			return getOBNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getOBNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Absolute";
		}
		return null;
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	@Override
	public Boolean getNHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getNNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		if (object == null || object.empty()) {
			return getNNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getNNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsFOV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FOV"));
	}

	@Override
	public Boolean getFOVHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FOV"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getFOVNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FOV"));
		if (object == null || object.empty()) {
			return getFOVNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getFOVNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getFHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CS"));
	}

	@Override
	public Boolean getCSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CS"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getCSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CS"));
		if (object == null || object.empty()) {
			return getCSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getCSNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "ANF";
		}
		return null;
	}

	@Override
	public Boolean getcontainsOS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OS"));
	}

	@Override
	public Boolean getOSHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getOSNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
		if (object == null || object.empty()) {
			return getOSNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getOSNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 1D;
		}
		return null;
	}

}
