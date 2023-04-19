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
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFATransition extends GFAObject implements ATransition {

	public GFATransition(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ATransition");
	}

	@Override
	public Boolean getcontainsB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("B"));
	}

	@Override
	public Boolean getBHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("B"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	@Override
	public Boolean getDHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getDNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null || object.empty()) {
			return getDNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getDNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 1D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsDi() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Di"));
	}

	@Override
	public Boolean getDiHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Di"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getDiHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Di"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Long getDiIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Di"));
		if (object == null || object.empty()) {
			return getDiIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDiIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public String getDiNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Di"));
		if (object == null || object.empty()) {
			return getDiNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getDiNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dm"));
	}

	@Override
	public Boolean getDmHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dm"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDmNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dm"));
		if (object == null || object.empty()) {
			return getDmNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getDmNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "H";
		}
		return null;
	}

	@Override
	public Boolean getcontainsM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M"));
	}

	@Override
	public Boolean getMHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getMNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		if (object == null || object.empty()) {
			return getMNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getMNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "I";
		}
		return null;
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			return getSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "R";
		}
		return null;
	}

	@Override
	public Boolean getcontainsSS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SS"));
	}

	@Override
	public Boolean getSSHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SS"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getSSNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SS"));
		if (object == null || object.empty()) {
			return getSSNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getSSNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 1.0D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

}
