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
			case "Strings":
				return getStrings();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACollectionSchema> getInitialFields() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getInitialFields1_7();
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
				return getResources1_7();
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

	private List<ANavigatorNameTreeStrings> getStrings() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getStrings1_7();
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

	@Override
	public Boolean getcontainsAPIVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("APIVersion"));
	}

	public COSObject getAPIVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("APIVersion"));
		return object;
	}

	@Override
	public Boolean getAPIVersionHasTypeStringText() {
		COSObject object = getAPIVersionValue();
		return getHasTypeStringText(object);
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
	public Boolean getCategoryHasTypeStringText() {
		COSObject object = getCategoryValue();
		return getHasTypeStringText(object);
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
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	public COSObject getentryIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object;
	}

	@Override
	public Boolean getentryIDHasTypeStringText() {
		COSObject object = getentryIDValue();
		return getHasTypeStringText(object);
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
	public Boolean getIconHasTypeStringText() {
		COSObject object = getIconValue();
		return getHasTypeStringText(object);
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
	public Boolean getInitialFieldsHasTypeDictionary() {
		COSObject object = getInitialFieldsValue();
		return getHasTypeDictionary(object);
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
	public Boolean getLayoutHasTypeArray() {
		COSObject object = getLayoutValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getLayoutHasTypeName() {
		COSObject object = getLayoutValue();
		return getHasTypeName(object);
	}

	@Override
	public String getLayoutNameValue() {
		COSObject object = getLayoutValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getLoadTypeHasTypeName() {
		COSObject object = getLoadTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getLoadTypeNameValue() {
		COSObject object = getLoadTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getLocaleHasTypeStringText() {
		COSObject object = getLocaleValue();
		return getHasTypeStringText(object);
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
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object;
	}

	@Override
	public Boolean getResourcesHasTypeNameTree() {
		COSObject object = getResourcesValue();
		return getHasTypeNameTree(object);
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
	public Boolean getSWFHasTypeStringText() {
		COSObject object = getSWFValue();
		return getHasTypeStringText(object);
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
	public Boolean getStringsHasTypeNameTree() {
		COSObject object = getStringsValue();
		return getHasTypeNameTree(object);
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
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	public COSObject getVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object;
	}

	@Override
	public Boolean getVersionHasTypeStringText() {
		COSObject object = getVersionValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
