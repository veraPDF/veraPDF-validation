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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DA1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAnnot3D> getentry3DA1_7() {
		COSObject object = getentry3DAValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DV1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DView> getentry3DV1_7() {
		COSObject object = getentry3DVValue();
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

	public COSObject getentry3DAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DA"));
		return object;
	}

	@Override
	public String getentry3DAType() {
		COSObject entry3DA = getentry3DAValue();
		return getObjectType(entry3DA);
	}

	@Override
	public Boolean getentry3DAHasTypeDictionary() {
		COSObject entry3DA = getentry3DAValue();
		return getHasTypeDictionary(entry3DA);
	}

	@Override
	public Boolean getentry3DAHasTypeStringText() {
		COSObject entry3DA = getentry3DAValue();
		return getHasTypeStringText(entry3DA);
	}

	@Override
	public Boolean getcontains3DV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DV"));
	}

	public COSObject getentry3DVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		return object;
	}

	@Override
	public String getentry3DVType() {
		COSObject entry3DV = getentry3DVValue();
		return getObjectType(entry3DV);
	}

	@Override
	public Boolean getentry3DVHasTypeDictionary() {
		COSObject entry3DV = getentry3DVValue();
		return getHasTypeDictionary(entry3DV);
	}

	@Override
	public Boolean getcontainsMD5() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MD5"));
	}

	public COSObject getMD5Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MD5"));
		return object;
	}

	@Override
	public String getMD5Type() {
		COSObject MD5 = getMD5Value();
		return getObjectType(MD5);
	}

	@Override
	public Boolean getMD5HasTypeStringByte() {
		COSObject MD5 = getMD5Value();
		return getHasTypeStringByte(MD5);
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
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
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
