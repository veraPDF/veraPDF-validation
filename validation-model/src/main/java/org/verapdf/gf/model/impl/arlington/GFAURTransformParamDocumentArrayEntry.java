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

public class GFAURTransformParamDocumentArrayEntry extends GFAObject implements AURTransformParamDocumentArrayEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAURTransformParamDocumentArrayEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AURTransformParamDocumentArrayEntry");
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
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getNameValue() {
		COSObject object = getValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
