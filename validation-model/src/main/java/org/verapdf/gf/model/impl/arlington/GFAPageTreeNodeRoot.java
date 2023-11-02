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

public class GFAPageTreeNodeRoot extends GFAObject implements APageTreeNodeRoot {

	public GFAPageTreeNodeRoot(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APageTreeNodeRoot");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Kids":
				return getKids();
			case "Resources":
				return getResources();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfPageTreeNodeKids> getKids() {
		return getKids1_0();
	}

	private List<AArrayOfPageTreeNodeKids> getKids1_0() {
		COSObject object = getKidsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfPageTreeNodeKids> list = new ArrayList<>(1);
			list.add(new GFAArrayOfPageTreeNodeKids((COSArray)object.getDirectBase(), this.baseObject, "Kids"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AResource> getResources() {
		return getResources1_0();
	}

	private List<AResource> getResources1_0() {
		COSObject object = getResourcesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AResource> list = new ArrayList<>(1);
			list.add(new GFAResource((COSDictionary)object.getDirectBase(), this.baseObject, "Resources"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCount() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Count"));
	}

	public COSObject getCountValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Count"));
		return object;
	}

	@Override
	public String getCountType() {
		COSObject Count = getCountValue();
		return getObjectType(Count);
	}

	@Override
	public Boolean getCountHasTypeInteger() {
		COSObject Count = getCountValue();
		return getHasTypeInteger(Count);
	}

	@Override
	public Long getCountIntegerValue() {
		COSObject Count = getCountValue();
		return getIntegerValue(Count);
	}

	@Override
	public Boolean getcontainsCropBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CropBox"));
	}

	public COSObject getCropBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropBox"));
		return object;
	}

	@Override
	public String getCropBoxType() {
		COSObject CropBox = getCropBoxValue();
		return getObjectType(CropBox);
	}

	@Override
	public Boolean getCropBoxHasTypeRectangle() {
		COSObject CropBox = getCropBoxValue();
		return getHasTypeRectangle(CropBox);
	}

	@Override
	public Boolean getcontainsKids() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Kids"));
	}

	public COSObject getKidsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Kids"));
		return object;
	}

	@Override
	public String getKidsType() {
		COSObject Kids = getKidsValue();
		return getObjectType(Kids);
	}

	@Override
	public Boolean getKidsHasTypeArray() {
		COSObject Kids = getKidsValue();
		return getHasTypeArray(Kids);
	}

	@Override
	public Boolean getcontainsMediaBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MediaBox"));
	}

	public COSObject getMediaBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MediaBox"));
		return object;
	}

	@Override
	public String getMediaBoxType() {
		COSObject MediaBox = getMediaBoxValue();
		return getObjectType(MediaBox);
	}

	@Override
	public Boolean getMediaBoxHasTypeRectangle() {
		COSObject MediaBox = getMediaBoxValue();
		return getHasTypeRectangle(MediaBox);
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object;
	}

	@Override
	public String getResourcesType() {
		COSObject Resources = getResourcesValue();
		return getObjectType(Resources);
	}

	@Override
	public Boolean getResourcesHasTypeDictionary() {
		COSObject Resources = getResourcesValue();
		return getHasTypeDictionary(Resources);
	}

	@Override
	public Boolean getcontainsRotate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rotate"));
	}

	public COSObject getRotateDefaultValue() {
		return COSInteger.construct(0L);
	}

	public COSObject getRotateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rotate"));
		if (object == null || object.empty()) {
			object = getRotateDefaultValue();
		}
		return object;
	}

	@Override
	public String getRotateType() {
		COSObject Rotate = getRotateValue();
		return getObjectType(Rotate);
	}

	@Override
	public Boolean getRotateHasTypeInteger() {
		COSObject Rotate = getRotateValue();
		return getHasTypeInteger(Rotate);
	}

	@Override
	public Long getRotateIntegerValue() {
		COSObject Rotate = getRotateValue();
		return getIntegerValue(Rotate);
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
