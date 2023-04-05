package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFANavigator extends GFAObject implements ANavigator {

	public GFANavigator(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANavigator");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Layout":
				return getLayout();
			case "InitialFields":
				return getInitialFields();
			case "Resources":
				return getResources();
			case "Strings":
				return getStrings();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNavigatorLayoutNames> getLayout() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getLayout2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNavigatorLayoutNames> getLayout2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Layout"));
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

	private List<ACollectionSchema> getInitialFields() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getInitialFields1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSchema> getInitialFields1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("InitialFields"));
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

	private List<ANavigatorNameTreeResources> getResources() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResources1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANavigatorNameTreeResources> getResources1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getStrings1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANavigatorNameTreeStrings> getStrings1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Strings"));
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
	public Boolean getcontainsLocale() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Locale"));
	}

	@Override
	public Boolean getLocaleHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Locale"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsIcon() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Icon"));
	}

	@Override
	public Boolean getIconHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Icon"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	@Override
	public Boolean getVersionHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsCategory() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Category"));
	}

	@Override
	public Boolean getCategoryHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Category"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	@Override
	public Boolean getentryIDHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsLayout() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Layout"));
	}

	@Override
	public Boolean getLayoutHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Layout"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getLayoutHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Layout"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public String getLayoutNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Layout"));
		if (object == null || object.empty()) {
			return getLayoutNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getLayoutNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsStrings() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Strings"));
	}

	@Override
	public Boolean getStringsHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Strings"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsLoadType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LoadType"));
	}

	@Override
	public Boolean getLoadTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LoadType"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getLoadTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LoadType"));
		if (object == null || object.empty()) {
			return getLoadTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getLoadTypeNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Default";
		}
		return null;
	}

	@Override
	public Boolean getcontainsDesc() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Desc"));
	}

	@Override
	public Boolean getDescHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Desc"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsInitialFields() {
		return this.baseObject.knownKey(ASAtom.getASAtom("InitialFields"));
	}

	@Override
	public Boolean getInitialFieldsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("InitialFields"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSWF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SWF"));
	}

	@Override
	public Boolean getSWFHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SWF"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	@Override
	public Boolean getResourcesHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsAPIVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("APIVersion"));
	}

	@Override
	public Boolean getAPIVersionHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("APIVersion"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

}
