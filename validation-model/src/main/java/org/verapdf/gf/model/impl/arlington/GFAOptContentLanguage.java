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

public class GFAOptContentLanguage extends GFAObject implements AOptContentLanguage {

	public GFAOptContentLanguage(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentLanguage");
	}

	@Override
	public Boolean getcontainsPreferred() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Preferred"));
	}

	@Override
	public Boolean getPreferredHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Preferred"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPreferredNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Preferred"));
		if (object == null || object.empty()) {
			return getPreferredNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPreferredNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "OFF";
		}
		return null;
	}

	@Override
	public Boolean getcontainsLang() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Lang"));
	}

	@Override
	public Boolean getLangHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Lang"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

}
