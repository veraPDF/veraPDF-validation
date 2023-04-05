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

public class GFAOptContentView extends GFAObject implements AOptContentView {

	public GFAOptContentView(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentView");
	}

	@Override
	public Boolean getcontainsViewState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ViewState"));
	}

	@Override
	public Boolean getViewStateHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewState"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getViewStateNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewState"));
		if (object == null || object.empty()) {
			return getViewStateNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getViewStateNameDefaultValue() {
		return null;
	}

}
