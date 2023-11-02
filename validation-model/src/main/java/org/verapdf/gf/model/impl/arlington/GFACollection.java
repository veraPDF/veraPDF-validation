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
	public String getColorsType() {
		COSObject Colors = getColorsValue();
		return getObjectType(Colors);
	}

	@Override
	public Boolean getColorsHasTypeDictionary() {
		COSObject Colors = getColorsValue();
		return getHasTypeDictionary(Colors);
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
	public String getDType() {
		COSObject D = getDValue();
		return getObjectType(D);
	}

	@Override
	public Boolean getDHasTypeStringByte() {
		COSObject D = getDValue();
		return getHasTypeStringByte(D);
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
		COSObject Folders = getFoldersValue();
		return getisIndirect(Folders);
	}

	@Override
	public String getFoldersType() {
		COSObject Folders = getFoldersValue();
		return getObjectType(Folders);
	}

	@Override
	public Boolean getFoldersHasTypeDictionary() {
		COSObject Folders = getFoldersValue();
		return getHasTypeDictionary(Folders);
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
		COSObject Navigator = getNavigatorValue();
		return getisIndirect(Navigator);
	}

	@Override
	public String getNavigatorType() {
		COSObject Navigator = getNavigatorValue();
		return getObjectType(Navigator);
	}

	@Override
	public Boolean getNavigatorHasTypeDictionary() {
		COSObject Navigator = getNavigatorValue();
		return getHasTypeDictionary(Navigator);
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
		COSObject Resources = getResourcesValue();
		return getisIndirect(Resources);
	}

	@Override
	public String getResourcesType() {
		COSObject Resources = getResourcesValue();
		return getObjectType(Resources);
	}

	@Override
	public Boolean getResourcesHasTypeNameTree() {
		COSObject Resources = getResourcesValue();
		return getHasTypeNameTree(Resources);
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
	public String getSchemaType() {
		COSObject Schema = getSchemaValue();
		return getObjectType(Schema);
	}

	@Override
	public Boolean getSchemaHasTypeDictionary() {
		COSObject Schema = getSchemaValue();
		return getHasTypeDictionary(Schema);
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
	public String getSortType() {
		COSObject Sort = getSortValue();
		return getObjectType(Sort);
	}

	@Override
	public Boolean getSortHasTypeDictionary() {
		COSObject Sort = getSortValue();
		return getHasTypeDictionary(Sort);
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
	public String getSplitType() {
		COSObject Split = getSplitValue();
		return getObjectType(Split);
	}

	@Override
	public Boolean getSplitHasTypeDictionary() {
		COSObject Split = getSplitValue();
		return getHasTypeDictionary(Split);
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
	public String getViewType() {
		COSObject View = getViewValue();
		return getObjectType(View);
	}

	@Override
	public Boolean getViewHasTypeName() {
		COSObject View = getViewValue();
		return getHasTypeName(View);
	}

	@Override
	public String getViewNameValue() {
		COSObject View = getViewValue();
		return getNameValue(View);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
