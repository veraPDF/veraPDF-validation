package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFAOptContentView extends GFAObject implements AOptContentView {

	public GFAOptContentView(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentView");
	}

	@Override
	public Boolean getcontainsViewState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ViewState"));
	}

	public COSObject getViewStateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewState"));
		return object;
	}

	@Override
	public Boolean getViewStateHasTypeName() {
		COSObject object = getViewStateValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getViewStateNameValue() {
		COSObject object = getViewStateValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
