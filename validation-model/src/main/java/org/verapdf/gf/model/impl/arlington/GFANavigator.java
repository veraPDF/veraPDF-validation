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

public class GFANavigator extends GFAObject implements ANavigator {

	public GFANavigator(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANavigator");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "InitialFields":
				return getInitialFields();
			case "Layout":
				return getLayout();
			case "Resources":
				return getResources();
			case "ResourcesTreeNode":
				return getResourcesTreeNode();
			case "Strings":
				return getStrings();
			case "StringsTreeNode":
				return getStringsTreeNode();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACollectionSchema> getInitialFields() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getInitialFields1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSchema> getInitialFields1_7() {
		COSObject object = getInitialFieldsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionSchema> list = new ArrayList<>(1);
			list.add(new GFACollectionSchema((COSDictionary)object.getDirectBase(), this.baseObject, "InitialFields"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNavigatorLayoutNames> getLayout() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getLayout2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNavigatorLayoutNames> getLayout2_0() {
		COSObject object = getLayoutValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNavigatorLayoutNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNavigatorLayoutNames((COSArray)object.getDirectBase(), this.baseObject, "Layout"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANavigatorNameTreeResources> getResources() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getResources1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANavigatorNameTreeResources> getResources1_7() {
		COSObject object = getResourcesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANavigatorNameTreeResources> list = new ArrayList<>(1);
			list.add(new GFANavigatorNameTreeResources((COSDictionary)object.getDirectBase(), this.baseObject, "Resources"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getResourcesTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getResourcesTreeNode1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getResourcesTreeNode1_7() {
		COSObject object = getResourcesTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "ResourcesTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANavigatorNameTreeStrings> getStrings() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getStrings1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANavigatorNameTreeStrings> getStrings1_7() {
		COSObject object = getStringsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANavigatorNameTreeStrings> list = new ArrayList<>(1);
			list.add(new GFANavigatorNameTreeStrings((COSDictionary)object.getDirectBase(), this.baseObject, "Strings"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getStringsTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getStringsTreeNode1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getStringsTreeNode1_7() {
		COSObject object = getStringsTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "StringsTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAPIVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("APIVersion"));
	}

	public COSObject getAPIVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("APIVersion"));
		return object;
	}

	@Override
	public String getAPIVersionType() {
		COSObject APIVersion = getAPIVersionValue();
		return getObjectType(APIVersion);
	}

	@Override
	public Boolean getAPIVersionHasTypeStringText() {
		COSObject APIVersion = getAPIVersionValue();
		return getHasTypeStringText(APIVersion);
	}

	@Override
	public Boolean getcontainsCategory() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Category"));
	}

	public COSObject getCategoryValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Category"));
		return object;
	}

	@Override
	public String getCategoryType() {
		COSObject Category = getCategoryValue();
		return getObjectType(Category);
	}

	@Override
	public Boolean getCategoryHasTypeStringText() {
		COSObject Category = getCategoryValue();
		return getHasTypeStringText(Category);
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
	public Boolean getentryIDHasTypeStringText() {
		COSObject entryID = getentryIDValue();
		return getHasTypeStringText(entryID);
	}

	@Override
	public Boolean getcontainsIcon() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Icon"));
	}

	public COSObject getIconValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Icon"));
		return object;
	}

	@Override
	public String getIconType() {
		COSObject Icon = getIconValue();
		return getObjectType(Icon);
	}

	@Override
	public Boolean getIconHasTypeStringText() {
		COSObject Icon = getIconValue();
		return getHasTypeStringText(Icon);
	}

	@Override
	public Boolean getcontainsInitialFields() {
		return this.baseObject.knownKey(ASAtom.getASAtom("InitialFields"));
	}

	public COSObject getInitialFieldsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("InitialFields"));
		return object;
	}

	@Override
	public String getInitialFieldsType() {
		COSObject InitialFields = getInitialFieldsValue();
		return getObjectType(InitialFields);
	}

	@Override
	public Boolean getInitialFieldsHasTypeDictionary() {
		COSObject InitialFields = getInitialFieldsValue();
		return getHasTypeDictionary(InitialFields);
	}

	@Override
	public Boolean getcontainsLayout() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Layout"));
	}

	public COSObject getLayoutValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Layout"));
		return object;
	}

	@Override
	public String getLayoutType() {
		COSObject Layout = getLayoutValue();
		return getObjectType(Layout);
	}

	@Override
	public Boolean getLayoutHasTypeArray() {
		COSObject Layout = getLayoutValue();
		return getHasTypeArray(Layout);
	}

	@Override
	public Boolean getLayoutHasTypeName() {
		COSObject Layout = getLayoutValue();
		return getHasTypeName(Layout);
	}

	@Override
	public String getLayoutNameValue() {
		COSObject Layout = getLayoutValue();
		return getNameValue(Layout);
	}

	@Override
	public Boolean getcontainsLoadType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LoadType"));
	}

	public COSObject getLoadTypeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Default");
		}
		return null;
	}

	public COSObject getLoadTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LoadType"));
		if (object == null || object.empty()) {
			object = getLoadTypeDefaultValue();
		}
		return object;
	}

	@Override
	public String getLoadTypeType() {
		COSObject LoadType = getLoadTypeValue();
		return getObjectType(LoadType);
	}

	@Override
	public Boolean getLoadTypeHasTypeName() {
		COSObject LoadType = getLoadTypeValue();
		return getHasTypeName(LoadType);
	}

	@Override
	public String getLoadTypeNameValue() {
		COSObject LoadType = getLoadTypeValue();
		return getNameValue(LoadType);
	}

	@Override
	public Boolean getcontainsLocale() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Locale"));
	}

	public COSObject getLocaleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Locale"));
		return object;
	}

	@Override
	public String getLocaleType() {
		COSObject Locale = getLocaleValue();
		return getObjectType(Locale);
	}

	@Override
	public Boolean getLocaleHasTypeStringText() {
		COSObject Locale = getLocaleValue();
		return getHasTypeStringText(Locale);
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
	public Boolean getResourcesHasTypeNameTree() {
		COSObject Resources = getResourcesValue();
		return getHasTypeNameTree(Resources);
	}

	@Override
	public Boolean getcontainsResourcesTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object;
	}

	@Override
	public String getResourcesTreeNodeType() {
		COSObject ResourcesTreeNode = getResourcesTreeNodeValue();
		return getObjectType(ResourcesTreeNode);
	}

	@Override
	public Boolean getResourcesTreeNodeHasTypeNameTree() {
		COSObject ResourcesTreeNode = getResourcesTreeNodeValue();
		return getHasTypeNameTree(ResourcesTreeNode);
	}

	@Override
	public Boolean getcontainsSWF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SWF"));
	}

	public COSObject getSWFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SWF"));
		return object;
	}

	@Override
	public String getSWFType() {
		COSObject SWF = getSWFValue();
		return getObjectType(SWF);
	}

	@Override
	public Boolean getSWFHasTypeStringText() {
		COSObject SWF = getSWFValue();
		return getHasTypeStringText(SWF);
	}

	@Override
	public Boolean getcontainsStrings() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Strings"));
	}

	public COSObject getStringsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Strings"));
		return object;
	}

	@Override
	public String getStringsType() {
		COSObject Strings = getStringsValue();
		return getObjectType(Strings);
	}

	@Override
	public Boolean getStringsHasTypeNameTree() {
		COSObject Strings = getStringsValue();
		return getHasTypeNameTree(Strings);
	}

	@Override
	public Boolean getcontainsStringsTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Strings"));
	}

	public COSObject getStringsTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Strings"));
		return object;
	}

	@Override
	public String getStringsTreeNodeType() {
		COSObject StringsTreeNode = getStringsTreeNodeValue();
		return getObjectType(StringsTreeNode);
	}

	@Override
	public Boolean getStringsTreeNodeHasTypeNameTree() {
		COSObject StringsTreeNode = getStringsTreeNodeValue();
		return getHasTypeNameTree(StringsTreeNode);
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
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	public COSObject getVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object;
	}

	@Override
	public String getVersionType() {
		COSObject Version = getVersionValue();
		return getObjectType(Version);
	}

	@Override
	public Boolean getVersionHasTypeStringText() {
		COSObject Version = getVersionValue();
		return getHasTypeStringText(Version);
	}

}
