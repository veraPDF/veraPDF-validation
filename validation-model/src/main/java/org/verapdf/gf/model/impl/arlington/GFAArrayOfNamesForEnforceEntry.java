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

public class GFAArrayOfNamesForEnforceEntry extends GFAObject implements AArrayOfNamesForEnforceEntry {

	private String collectionName;

	public GFAArrayOfNamesForEnforceEntry(COSBase baseObject, COSBase parentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfNamesForEnforceEntry");
		this.collectionName = collectionName;
	}

	@Override
	public Boolean getHasTypeName() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getNameValue() {
		COSObject object = new COSObject(this.baseObject);
		if (object == null || object.empty()) {
			return getNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getNameDefaultValue() {
		return null;
	}

	@Override
	public String getparentPrintScalingNameValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject PrintScaling = this.parentObject.getKey(ASAtom.getASAtom("PrintScaling"));
		return new GFAViewerPreferences(this.parentObject.getDirectBase(), null, null).getPrintScalingNameValue();
	}
}
