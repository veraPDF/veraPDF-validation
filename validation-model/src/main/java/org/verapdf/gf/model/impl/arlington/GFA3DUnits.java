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

public class GFA3DUnits extends GFAObject implements A3DUnits {

	public GFA3DUnits(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DUnits");
	}

	@Override
	public Boolean getcontainsTU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TU"));
	}

	@Override
	public Boolean getTUHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TU"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsDU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DU"));
	}

	@Override
	public Boolean getDUHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DU"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsUSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("USm"));
	}

	@Override
	public Boolean getUSmHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("USm"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsDSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DSm"));
	}

	@Override
	public Boolean getDSmHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSm"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsUU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UU"));
	}

	@Override
	public Boolean getUUHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UU"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsDSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DSn"));
	}

	@Override
	public Boolean getDSnHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSn"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TSn"));
	}

	@Override
	public Boolean getTSnHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TSn"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsUSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("USn"));
	}

	@Override
	public Boolean getUSnHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("USn"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TSm"));
	}

	@Override
	public Boolean getTSmHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TSm"));
		return object != null && object.getType().isNumber();
	}

}
