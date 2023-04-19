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

public class GFAExData3DMarkup extends GFAObject implements AExData3DMarkup {

	public GFAExData3DMarkup(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AExData3DMarkup");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry3DA":
				return getentry3DA();
			case "entry3DV":
				return getentry3DV();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AAnnot3D> getentry3DA() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DA1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAnnot3D> getentry3DA1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DA"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAnnot3D> list = new ArrayList<>(1);
			list.add(new GFAAnnot3D((COSDictionary)object.getDirectBase(), this.baseObject, "3DA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A3DView> getentry3DV() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DV1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DView> getentry3DV1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DView> list = new ArrayList<>(1);
			list.add(new GFA3DView((COSDictionary)object.getDirectBase(), this.baseObject, "3DV"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontains3DA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DA"));
	}

	@Override
	public Boolean getentry3DAHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DA"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getentry3DAHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DA"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontains3DV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DV"));
	}

	@Override
	public Boolean getentry3DVHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsMD5() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MD5"));
	}

	@Override
	public Boolean getMD5HasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MD5"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			return getSubtypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSubtypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

}
