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

	public COSObject getCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object;
	}

	@Override
	public Boolean getCHasTypeNumber() {
		COSObject object = getCValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(16L);
		}
		return null;
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null || object.empty()) {
			object = getDDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDHasTypeInteger() {
		COSObject object = getDValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDIntegerValue() {
		COSObject object = getDValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("D");
		}
		return null;
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null || object.empty()) {
			object = getFDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getFHasTypeName() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFNameValue() {
		COSObject object = getFValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FD"));
	}

	public COSObject getFDDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getFDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FD"));
		if (object == null || object.empty()) {
			object = getFDDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getFDHasTypeBoolean() {
		COSObject object = getFDValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getODefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("S");
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
	public Boolean getOHasTypeName() {
		COSObject object = getOValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getONameValue() {
		COSObject object = getOValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PS"));
	}

	public COSObject getPSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSString.construct(" ".getBytes());
		}
		return null;
	}

	public COSObject getPSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PS"));
		if (object == null || object.empty()) {
			object = getPSDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPSHasTypeStringText() {
		COSObject object = getPSValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RD"));
	}

	public COSObject getRDDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSString.construct(".".getBytes());
		}
		return null;
	}

	public COSObject getRDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RD"));
		if (object == null || object.empty()) {
			object = getRDDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRDHasTypeStringText() {
		COSObject object = getRDValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RT"));
	}

	public COSObject getRTDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSString.construct(",".getBytes());
		}
		return null;
	}

	public COSObject getRTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RT"));
		if (object == null || object.empty()) {
			object = getRTDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRTHasTypeStringText() {
		COSObject object = getRTValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsSS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SS"));
	}

	public COSObject getSSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSString.construct(" ".getBytes());
		}
		return null;
	}

	public COSObject getSSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SS"));
		if (object == null || object.empty()) {
			object = getSSDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSSHasTypeStringText() {
		COSObject object = getSSValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getcontainsU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U"));
	}

	public COSObject getUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		return object;
	}

	@Override
	public Boolean getUHasTypeStringText() {
		COSObject object = getUValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

}
