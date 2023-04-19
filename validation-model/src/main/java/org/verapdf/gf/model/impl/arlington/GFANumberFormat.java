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

public class GFANumberFormat extends GFAObject implements ANumberFormat {

	public GFANumberFormat(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANumberFormat");
	}

	@Override
	public Boolean getcontainsC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C"));
	}

	@Override
	public Boolean getCHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	@Override
	public Boolean getDHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null || object.empty()) {
			return getDIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 16L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getFHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null || object.empty()) {
			return getFNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "D";
		}
		return null;
	}

	@Override
	public Boolean getcontainsFD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FD"));
	}

	@Override
	public Boolean getFDHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FD"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	@Override
	public Boolean getOHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getONameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null || object.empty()) {
			return getONameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getONameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "S";
		}
		return null;
	}

	@Override
	public Boolean getcontainsPS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PS"));
	}

	@Override
	public Boolean getPSHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PS"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RD"));
	}

	@Override
	public Boolean getRDHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RD"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RT"));
	}

	@Override
	public Boolean getRTHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RT"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsSS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SS"));
	}

	@Override
	public Boolean getSSHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SS"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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

	@Override
	public Boolean getcontainsU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U"));
	}

	@Override
	public Boolean getUHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

}
