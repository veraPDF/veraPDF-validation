package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.PDNameTreeNode;
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
		COSObject ViewState = getViewStateValue();
		return getHasTypeName(ViewState);
	}

	@Override
	public String getViewStateNameValue() {
		COSObject ViewState = getViewStateValue();
		return getNameValue(ViewState);
	}

}
