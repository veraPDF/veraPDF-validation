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

public class GFACollection extends GFAObject implements ACollection {

	public GFACollection(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACollection");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Colors":
				return getColors();
			case "Folders":
				return getFolders();
			case "Navigator":
				return getNavigator();
			case "Resources":
				return getResources();
			case "Schema":
				return getSchema();
			case "Sort":
				return getSort();
			case "Split":
				return getSplit();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACollectionColors> getColors() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColors1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionColors> getColors1_7() {
		COSObject object = getColorsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionColors> list = new ArrayList<>(1);
			list.add(new GFACollectionColors((COSDictionary)object.getDirectBase(), this.baseObject, "Colors"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionFolder> getFolders() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFolders1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionFolder> getFolders1_7() {
		COSObject object = getFoldersValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionFolder> list = new ArrayList<>(1);
			list.add(new GFACollectionFolder((COSDictionary)object.getDirectBase(), this.baseObject, "Folders"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANavigator> getNavigator() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNavigator1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANavigator> getNavigator1_7() {
		COSObject object = getNavigatorValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANavigator> list = new ArrayList<>(1);
			list.add(new GFANavigator((COSDictionary)object.getDirectBase(), this.baseObject, "Navigator"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionNameTreeResources> getResources() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResources1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionNameTreeResources> getResources1_7() {
		COSObject object = getResourcesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionNameTreeResources> list = new ArrayList<>(1);
			list.add(new GFACollectionNameTreeResources((COSDictionary)object.getDirectBase(), this.baseObject, "Resources"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionSchema> getSchema() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSchema1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSchema> getSchema1_7() {
		COSObject object = getSchemaValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionSchema> list = new ArrayList<>(1);
			list.add(new GFACollectionSchema((COSDictionary)object.getDirectBase(), this.baseObject, "Schema"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionSort> getSort() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSort1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSort> getSort1_7() {
		COSObject object = getSortValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionSort> list = new ArrayList<>(1);
			list.add(new GFACollectionSort((COSDictionary)object.getDirectBase(), this.baseObject, "Sort"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionSplit> getSplit() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSplit1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSplit> getSplit1_7() {
		COSObject object = getSplitValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionSplit> list = new ArrayList<>(1);
			list.add(new GFACollectionSplit((COSDictionary)object.getDirectBase(), this.baseObject, "Split"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsColors() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Colors"));
	}

	public COSObject getColorsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colors"));
		return object;
	}

	@Override
	public Boolean getColorsHasTypeDictionary() {
		COSObject object = getColorsValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object;
	}

	@Override
	public Boolean getDHasTypeStringByte() {
		COSObject object = getDValue();
		return getHasTypeStringByte(object);
	}

	@Override
	public Boolean getcontainsFolders() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Folders"));
	}

	public COSObject getFoldersValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Folders"));
		return object;
	}

	@Override
	public Boolean getisFoldersIndirect() {
		COSObject object = getFoldersValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getFoldersHasTypeDictionary() {
		COSObject object = getFoldersValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsNavigator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Navigator"));
	}

	public COSObject getNavigatorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Navigator"));
		return object;
	}

	@Override
	public Boolean getisNavigatorIndirect() {
		COSObject object = getNavigatorValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getNavigatorHasTypeDictionary() {
		COSObject object = getNavigatorValue();
		return getHasTypeDictionary(object);
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
	public Boolean getisResourcesIndirect() {
		COSObject object = getResourcesValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getResourcesHasTypeNameTree() {
		COSObject object = getResourcesValue();
		return getHasTypeNameTree(object);
	}

	@Override
	public Boolean getcontainsSchema() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Schema"));
	}

	public COSObject getSchemaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Schema"));
		return object;
	}

	@Override
	public Boolean getSchemaHasTypeDictionary() {
		COSObject object = getSchemaValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsSort() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Sort"));
	}

	public COSObject getSortValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Sort"));
		return object;
	}

	@Override
	public Boolean getSortHasTypeDictionary() {
		COSObject object = getSortValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsSplit() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Split"));
	}

	public COSObject getSplitValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Split"));
		return object;
	}

	@Override
	public Boolean getSplitHasTypeDictionary() {
		COSObject object = getSplitValue();
		return getHasTypeDictionary(object);
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
	public Boolean getcontainsView() {
		return this.baseObject.knownKey(ASAtom.getASAtom("View"));
	}

	public COSObject getViewDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("D");
		}
		return null;
	}

	public COSObject getViewValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		if (object == null || object.empty()) {
			object = getViewDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getViewHasTypeName() {
		COSObject object = getViewValue();
		return getHasTypeName(object);
	}

	@Override
	public String getViewNameValue() {
		COSObject object = getViewValue();
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
