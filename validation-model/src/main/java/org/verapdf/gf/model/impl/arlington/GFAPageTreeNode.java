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

public class GFAPageTreeNode extends GFAObject implements APageTreeNode {

	public GFAPageTreeNode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APageTreeNode");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Kids":
				return getKids();
			case "Parent":
				return getParent();
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

	private List<org.verapdf.model.baselayer.Object> getParent() {
		return getParent1_0();
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_0() {
		COSObject object = getParentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_0(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_0(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("Parent"))) {
			return new GFAPageTreeNode(base, this.baseObject, keyName);
		}
		return new GFAPageTreeNodeRoot(base, this.baseObject, keyName);
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
	public Boolean getCountHasTypeInteger() {
		COSObject object = getCountValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getCountIntegerValue() {
		COSObject object = getCountValue();
		return getIntegerValue(object);
	}

	@Override
	public Boolean getcontainsCropBox() {
		if (isContainsInheritableValue(ASAtom.getASAtom("CropBox"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("CropBox"));
	}

	public COSObject getCropBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropBox"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("CropBox"));
		}
		return object;
	}

	@Override
	public Boolean getCropBoxHasTypeRectangle() {
		COSObject object = getCropBoxValue();
		return getHasTypeRectangle(object);
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
	public Boolean getKidsHasTypeArray() {
		COSObject object = getKidsValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsMediaBox() {
		if (isContainsInheritableValue(ASAtom.getASAtom("MediaBox"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("MediaBox"));
	}

	public COSObject getMediaBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MediaBox"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("MediaBox"));
		}
		return object;
	}

	@Override
	public Boolean getMediaBoxHasTypeRectangle() {
		COSObject object = getMediaBoxValue();
		return getHasTypeRectangle(object);
	}

	@Override
	public Boolean getcontainsParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Parent"));
	}

	public COSObject getParentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		return object;
	}

	@Override
	public Boolean getisParentIndirect() {
		COSObject object = getParentValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject object = getParentValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsResources() {
		if (isContainsInheritableValue(ASAtom.getASAtom("Resources"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("Resources"));
		}
		return object;
	}

	@Override
	public Boolean getResourcesHasTypeDictionary() {
		COSObject object = getResourcesValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsRotate() {
		if (isContainsInheritableValue(ASAtom.getASAtom("Rotate"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("Rotate"));
	}

	public COSObject getRotateDefaultValue() {
		return COSInteger.construct(0L);
	}

	public COSObject getRotateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rotate"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("Rotate"));
		}
		if (object == null || object.empty()) {
			object = getRotateDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRotateHasTypeInteger() {
		COSObject object = getRotateValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getRotateIntegerValue() {
		COSObject object = getRotateValue();
		return getIntegerValue(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		return getNameValue(object);
	}

}
