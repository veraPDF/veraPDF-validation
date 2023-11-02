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

public class GFAArrayOfNamesForEnforceEntry extends GFAObject implements AArrayOfNamesForEnforceEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfNamesForEnforceEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfNamesForEnforceEntry");
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
	public Boolean getHasTypeName() {
		COSObject entry = getValue();
		return getHasTypeName(entry);
	}

	@Override
	public String getNameValue() {
		COSObject entry = getValue();
		return getNameValue(entry);
	}

	@Override
	public String getparentPrintScalingNameValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		return new GFAViewerPreferences(this.parentObject.getDirectBase(), null, null).getPrintScalingNameValue();
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
