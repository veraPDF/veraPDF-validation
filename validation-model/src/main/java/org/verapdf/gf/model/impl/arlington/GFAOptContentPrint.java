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

public class GFAOptContentPrint extends GFAObject implements AOptContentPrint {

	public GFAOptContentPrint(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentPrint");
	}

	@Override
	public Boolean getcontainsPrintState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintState"));
	}

	@Override
	public Boolean getPrintStateHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintState"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPrintStateNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintState"));
		if (object == null || object.empty()) {
			return getPrintStateNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPrintStateNameDefaultValue() {
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

}
