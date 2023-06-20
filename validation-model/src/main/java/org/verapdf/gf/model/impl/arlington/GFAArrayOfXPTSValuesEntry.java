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

public class GFAArrayOfXPTSValuesEntry extends GFAObject implements AArrayOfXPTSValuesEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfXPTSValuesEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfXPTSValuesEntry");
		this.parentParentObject = parentParentObject;
		this.collectionName = collectionName;
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public Boolean getHasTypeNumber() {
		COSObject object = getValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
