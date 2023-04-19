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

public class GFACollectionSplit extends GFAObject implements ACollectionSplit {

	public GFACollectionSplit(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACollectionSplit");
	}

	@Override
	public Boolean getcontainsDirection() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Direction"));
	}

	@Override
	public Boolean getDirectionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Direction"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDirectionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Direction"));
		if (object == null || object.empty()) {
			return getDirectionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getDirectionNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Position"));
	}

	@Override
	public Boolean getPositionHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getPositionNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		if (object == null || object.empty()) {
			return getPositionNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getPositionNumberDefaultValue() {
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
