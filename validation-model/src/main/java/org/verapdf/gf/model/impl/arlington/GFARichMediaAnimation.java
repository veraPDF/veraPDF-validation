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

public class GFARichMediaAnimation extends GFAObject implements ARichMediaAnimation {

	public GFARichMediaAnimation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaAnimation");
	}

	@Override
	public Boolean getcontainsAO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AO"));
	}

	@Override
	public Boolean getAOHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AO"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getAOIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AO"));
		if (object == null || object.empty()) {
			return getAOIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getAOIntegerDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsPlayCount() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PlayCount"));
	}

	@Override
	public Boolean getPlayCountHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PlayCount"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsSpeed() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Speed"));
	}

	@Override
	public Boolean getSpeedHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Speed"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getSpeedNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Speed"));
		if (object == null || object.empty()) {
			return getSpeedNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getSpeedNumberDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 1D;
		}
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "None";
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
