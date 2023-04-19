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

public class GFASigFieldLock extends GFAObject implements ASigFieldLock {

	public GFASigFieldLock(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASigFieldLock");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Fields":
				return getFields();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStringsText> getFields() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFields1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getFields1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Fields"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "Fields"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Action"));
	}

	@Override
	public Boolean getActionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Action"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getActionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Action"));
		if (object == null || object.empty()) {
			return getActionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getActionNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsFields() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Fields"));
	}

	@Override
	public Boolean getFieldsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Fields"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	@Override
	public Boolean getPHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getPNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			return getPNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getPNumberDefaultValue() {
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
