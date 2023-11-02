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
	public String getCIType() {
		COSObject CI = getCIValue();
		return getObjectType(CI);
	}

	@Override
	public Boolean getCIHasTypeDictionary() {
		COSObject CI = getCIValue();
		return getHasTypeDictionary(CI);
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
		COSObject Child = getChildValue();
		return getisIndirect(Child);
	}

	@Override
	public String getChildType() {
		COSObject Child = getChildValue();
		return getObjectType(Child);
	}

	@Override
	public Boolean getChildHasTypeDictionary() {
		COSObject Child = getChildValue();
		return getHasTypeDictionary(Child);
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
	public String getCreationDateType() {
		COSObject CreationDate = getCreationDateValue();
		return getObjectType(CreationDate);
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject CreationDate = getCreationDateValue();
		return getHasTypeDate(CreationDate);
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
	public String getDescType() {
		COSObject Desc = getDescValue();
		return getObjectType(Desc);
	}

	@Override
	public Boolean getDescHasTypeStringText() {
		COSObject Desc = getDescValue();
		return getHasTypeStringText(Desc);
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
	public String getFreeType() {
		COSObject Free = getFreeValue();
		return getObjectType(Free);
	}

	@Override
	public Boolean getFreeHasTypeArray() {
		COSObject Free = getFreeValue();
		return getHasTypeArray(Free);
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
	public String getentryIDType() {
		COSObject entryID = getentryIDValue();
		return getObjectType(entryID);
	}

	@Override
	public Boolean getentryIDHasTypeInteger() {
		COSObject entryID = getentryIDValue();
		return getHasTypeInteger(entryID);
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
	public String getModDateType() {
		COSObject ModDate = getModDateValue();
		return getObjectType(ModDate);
	}

	@Override
	public Boolean getModDateHasTypeDate() {
		COSObject ModDate = getModDateValue();
		return getHasTypeDate(ModDate);
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
	public String getNameType() {
		COSObject Name = getNameValue();
		return getObjectType(Name);
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject Name = getNameValue();
		return getHasTypeStringText(Name);
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
		COSObject Next = getNextValue();
		return getisIndirect(Next);
	}

	@Override
	public String getNextType() {
		COSObject Next = getNextValue();
		return getObjectType(Next);
	}

	@Override
	public Boolean getNextHasTypeDictionary() {
		COSObject Next = getNextValue();
		return getHasTypeDictionary(Next);
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
		COSObject Parent = getParentValue();
		return getisIndirect(Parent);
	}

	@Override
	public String getParentType() {
		COSObject Parent = getParentValue();
		return getObjectType(Parent);
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject Parent = getParentValue();
		return getHasTypeDictionary(Parent);
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
		COSObject Thumb = getThumbValue();
		return getisIndirect(Thumb);
	}

	@Override
	public String getThumbType() {
		COSObject Thumb = getThumbValue();
		return getObjectType(Thumb);
	}

	@Override
	public Boolean getThumbHasTypeStream() {
		COSObject Thumb = getThumbValue();
		return getHasTypeStream(Thumb);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
