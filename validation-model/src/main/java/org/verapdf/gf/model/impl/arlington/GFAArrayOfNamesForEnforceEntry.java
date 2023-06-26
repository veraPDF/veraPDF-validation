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
	public Boolean getHasTypeName() {
		COSObject object = getValue();
		return getHasTypeName(object);
	}

	@Override
	public String getNameValue() {
		COSObject object = getValue();
		return getNameValue(object);
	}

	@Override
	public String getparentPrintScalingNameValue() {
		if (this.parentParentObject == null || !this.parentParentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject PrintScaling = this.parentParentObject.getKey(ASAtom.getASAtom("PrintScaling"));
		return new GFAViewerPreferences(this.parentObject.getDirectBase(), null, null).getPrintScalingNameValue();
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
