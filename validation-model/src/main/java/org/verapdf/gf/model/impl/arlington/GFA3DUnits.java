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

public class GFA3DUnits extends GFAObject implements A3DUnits {

	public GFA3DUnits(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DUnits");
	}

	@Override
	public Boolean getcontainsDSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DSm"));
	}

	public COSObject getDSmDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getDSmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSm"));
		if (object == null || object.empty()) {
			object = getDSmDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDSmHasTypeNumber() {
		COSObject object = getDSmValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsDSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DSn"));
	}

	public COSObject getDSnDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getDSnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSn"));
		if (object == null || object.empty()) {
			object = getDSnDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDSnHasTypeNumber() {
		COSObject object = getDSnValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsDU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DU"));
	}

	public COSObject getDUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DU"));
		return object;
	}

	@Override
	public Boolean getDUHasTypeStringText() {
		COSObject object = getDUValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TSm"));
	}

	public COSObject getTSmDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getTSmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TSm"));
		if (object == null || object.empty()) {
			object = getTSmDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getTSmHasTypeNumber() {
		COSObject object = getTSmValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TSn"));
	}

	public COSObject getTSnDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getTSnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TSn"));
		if (object == null || object.empty()) {
			object = getTSnDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getTSnHasTypeNumber() {
		COSObject object = getTSnValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TU"));
	}

	public COSObject getTUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TU"));
		return object;
	}

	@Override
	public Boolean getTUHasTypeStringText() {
		COSObject object = getTUValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsUSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("USm"));
	}

	public COSObject getUSmDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getUSmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("USm"));
		if (object == null || object.empty()) {
			object = getUSmDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getUSmHasTypeNumber() {
		COSObject object = getUSmValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsUSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("USn"));
	}

	public COSObject getUSnDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getUSnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("USn"));
		if (object == null || object.empty()) {
			object = getUSnDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getUSnHasTypeNumber() {
		COSObject object = getUSnValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsUU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UU"));
	}

	public COSObject getUUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UU"));
		return object;
	}

	@Override
	public Boolean getUUHasTypeStringText() {
		COSObject object = getUUValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
