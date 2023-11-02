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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getObjValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.baseObject, "Obj"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "Obj"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getObjStream1_3(object.getDirectBase(), "Obj");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getObjStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Form":
				return new GFAXObjectFormType1(base, this.baseObject, keyName);
			case "Image":
				return new GFAXObjectImage(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<APageObject> getPg() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getPgValue();
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

	public COSObject getObjValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Obj"));
		return object;
	}

	@Override
	public Boolean getisObjIndirect() {
		COSObject Obj = getObjValue();
		return getisIndirect(Obj);
	}

	@Override
	public String getObjType() {
		COSObject Obj = getObjValue();
		return getObjectType(Obj);
	}

	@Override
	public Boolean getObjHasTypeArray() {
		COSObject Obj = getObjValue();
		return getHasTypeArray(Obj);
	}

	@Override
	public Boolean getObjHasTypeDictionary() {
		COSObject Obj = getObjValue();
		return getHasTypeDictionary(Obj);
	}

	@Override
	public Boolean getObjHasTypeStream() {
		COSObject Obj = getObjValue();
		return getHasTypeStream(Obj);
	}

	@Override
	public Boolean getcontainsPg() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pg"));
	}

	public COSObject getPgValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		return object;
	}

	@Override
	public Boolean getisPgIndirect() {
		COSObject Pg = getPgValue();
		return getisIndirect(Pg);
	}

	@Override
	public String getPgType() {
		COSObject Pg = getPgValue();
		return getObjectType(Pg);
	}

	@Override
	public Boolean getPgHasTypeDictionary() {
		COSObject Pg = getPgValue();
		return getHasTypeDictionary(Pg);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

}
