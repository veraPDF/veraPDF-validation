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

public class GFAArrayOfIntegersGreaterThanZeroEntry extends GFAObject implements AArrayOfIntegersGreaterThanZeroEntry {

	private final COSBase parentParentObject;
	private final String collectionName;

	public GFAArrayOfIntegersGreaterThanZeroEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfIntegersGreaterThanZeroEntry");
		this.parentParentObject = parentParentObject;
		this.collectionName = collectionName;
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public String getType() {
		COSObject entry = getValue();
		return getObjectType(entry);
	}

	@Override
	public Boolean getHasTypeInteger() {
		COSObject entry = getValue();
		return getHasTypeInteger(entry);
	}

	@Override
	public Long getIntegerValue() {
		COSObject entry = getValue();
		return getIntegerValue(entry);
	}

}
