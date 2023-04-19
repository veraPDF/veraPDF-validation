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

public class GFAObjectReference extends GFAObject implements AObjectReference {

	public GFAObjectReference(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AObjectReference");
		COSObject obj = this.baseObject.getKey(ASAtom.OBJ);
		if (obj != null && obj.getKey() != null) {
			GFAObject.getKeysSet().add(obj.getKey());
		}
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Obj":
				return getObj();
			case "Pg":
				return getPg();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getObj() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getObj1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getObj1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Obj"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.baseObject, "Obj"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormType1> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormType1((COSStream)object.getDirectBase(), this.baseObject, "Obj"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "Obj"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<APageObject> getPg() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPg1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getPg1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "Pg"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsObj() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Obj"));
	}

	@Override
	public Boolean getisObjIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Obj"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getObjHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Obj"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getObjHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Obj"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getObjHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Obj"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPg() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pg"));
	}

	@Override
	public Boolean getisPgIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPgHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		return object != null && object.getType() == COSObjType.COS_DICT;
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
