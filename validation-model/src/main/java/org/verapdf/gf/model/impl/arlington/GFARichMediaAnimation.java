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
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getAOIntegerValue() {
		COSObject object = getAOValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getSpeedNumberValue() {
		COSObject object = getSpeedValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
