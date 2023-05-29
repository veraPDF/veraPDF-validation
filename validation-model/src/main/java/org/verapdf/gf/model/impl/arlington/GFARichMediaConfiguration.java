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

public class GFARichMediaConfiguration extends GFAObject implements ARichMediaConfiguration {

	public GFARichMediaConfiguration(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaConfiguration");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Instances":
				return getInstances();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfRichMediaInstances> getInstances() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getInstances1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRichMediaInstances> getInstances1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Instances"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfRichMediaInstances> list = new ArrayList<>(1);
			list.add(new GFAArrayOfRichMediaInstances((COSArray)object.getDirectBase(), this.baseObject, "Instances"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsInstances() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Instances"));
	}

	public COSObject getInstancesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Instances"));
		return object;
	}

	@Override
	public Boolean getInstancesHasTypeArray() {
		COSObject object = getInstancesValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object;
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject object = getNameValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
