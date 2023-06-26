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

public class GFAArrayOfSoftwareVersionsEntry extends GFAObject implements AArrayOfSoftwareVersionsEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfSoftwareVersionsEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfSoftwareVersionsEntry");
		this.parentParentObject = parentParentObject;
		this.collectionName = collectionName;
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public Boolean getHasTypeInteger() {
		COSObject object = getValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getIntegerValue() {
		COSObject object = getValue();
		return getIntegerValue(object);
	}

}
