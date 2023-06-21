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

public class GFACollectionFolder extends GFAObject implements ACollectionFolder {

	public GFACollectionFolder(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACollectionFolder");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CI":
				return getCI();
			case "Child":
				return getChild();
			case "Free":
				return getFree();
			case "Next":
				return getNext();
			case "Parent":
				return getParent();
			case "Thumb":
				return getThumb();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACollectionItem> getCI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCI1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionItem> getCI1_7() {
		COSObject object = getCIValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionItem> list = new ArrayList<>(1);
			list.add(new GFACollectionItem((COSDictionary)object.getDirectBase(), this.baseObject, "CI"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionFolder> getChild() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getChild1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionFolder> getChild1_7() {
		COSObject object = getChildValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionFolder> list = new ArrayList<>(1);
			list.add(new GFACollectionFolder((COSDictionary)object.getDirectBase(), this.baseObject, "Child"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getFree() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFree1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getFree1_7() {
		COSObject object = getFreeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Free"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionFolder> getNext() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNext1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionFolder> getNext1_7() {
		COSObject object = getNextValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionFolder> list = new ArrayList<>(1);
			list.add(new GFACollectionFolder((COSDictionary)object.getDirectBase(), this.baseObject, "Next"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionFolder> getParent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getParent1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionFolder> getParent1_7() {
		COSObject object = getParentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionFolder> list = new ArrayList<>(1);
			list.add(new GFACollectionFolder((COSDictionary)object.getDirectBase(), this.baseObject, "Parent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AThumbnail> getThumb() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getThumb1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AThumbnail> getThumb1_7() {
		COSObject object = getThumbValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AThumbnail> list = new ArrayList<>(1);
			list.add(new GFAThumbnail((COSStream)object.getDirectBase(), this.baseObject, "Thumb"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CI"));
	}

	public COSObject getCIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CI"));
		return object;
	}

	@Override
	public Boolean getCIHasTypeDictionary() {
		COSObject object = getCIValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsChild() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Child"));
	}

	public COSObject getChildValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Child"));
		return object;
	}

	@Override
	public Boolean getisChildIndirect() {
		COSObject object = getChildValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getChildHasTypeDictionary() {
		COSObject object = getChildValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsCreationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreationDate"));
	}

	public COSObject getCreationDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreationDate"));
		return object;
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject object = getCreationDateValue();
		return getHasTypeDate(object);
	}

	@Override
	public Boolean getcontainsDesc() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Desc"));
	}

	public COSObject getDescValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Desc"));
		return object;
	}

	@Override
	public Boolean getDescHasTypeStringText() {
		COSObject object = getDescValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsFree() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Free"));
	}

	public COSObject getFreeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Free"));
		return object;
	}

	@Override
	public Boolean getFreeHasTypeArray() {
		COSObject object = getFreeValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	public COSObject getentryIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object;
	}

	@Override
	public Boolean getentryIDHasTypeInteger() {
		COSObject object = getentryIDValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getcontainsModDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ModDate"));
	}

	public COSObject getModDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ModDate"));
		return object;
	}

	@Override
	public Boolean getModDateHasTypeDate() {
		COSObject object = getModDateValue();
		return getHasTypeDate(object);
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
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsNext() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Next"));
	}

	public COSObject getNextValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Next"));
		return object;
	}

	@Override
	public Boolean getisNextIndirect() {
		COSObject object = getNextValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getNextHasTypeDictionary() {
		COSObject object = getNextValue();
		return getHasTypeDictionary(object);
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
	public Boolean getcontainsThumb() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Thumb"));
	}

	public COSObject getThumbValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object;
	}

	@Override
	public Boolean getisThumbIndirect() {
		COSObject object = getThumbValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getThumbHasTypeStream() {
		COSObject object = getThumbValue();
		return getHasTypeStream(object);
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
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
