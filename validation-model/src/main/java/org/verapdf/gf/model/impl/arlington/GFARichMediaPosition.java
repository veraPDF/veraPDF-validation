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

public class GFARichMediaPosition extends GFAObject implements ARichMediaPosition {

	public GFARichMediaPosition(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaPosition");
	}

	@Override
	public Boolean getcontainsHAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HAlign"));
	}

	@Override
	public Boolean getHAlignHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HAlign"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getHAlignNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HAlign"));
		if (object == null || object.empty()) {
			return getHAlignNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getHAlignNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Far";
		}
		return null;
	}

	@Override
	public Boolean getcontainsHOffset() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HOffset"));
	}

	@Override
	public Boolean getHOffsetHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HOffset"));
		return object != null && object.getType().isNumber();
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
	public Boolean getcontainsVAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VAlign"));
	}

	@Override
	public Boolean getVAlignHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VAlign"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getVAlignNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VAlign"));
		if (object == null || object.empty()) {
			return getVAlignNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getVAlignNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Near";
		}
		return null;
	}

	@Override
	public Boolean getcontainsVOffset() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VOffset"));
	}

	@Override
	public Boolean getVOffsetHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VOffset"));
		return object != null && object.getType().isNumber();
	}

}
