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
import java.io.IOException;

public class GFACollection extends GFAObject implements ACollection {

	public GFACollection(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACollection");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Colors":
				return getColors();
			case "Navigator":
				return getNavigator();
			case "Schema":
				return getSchema();
			case "Sort":
				return getSort();
			case "Folders":
				return getFolders();
			case "Resources":
				return getResources();
			case "Split":
				return getSplit();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACollectionColors> getColors() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColors1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionColors> getColors1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colors"));
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

	private List<ANavigator> getNavigator() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNavigator1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANavigator> getNavigator1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Navigator"));
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

	private List<ACollectionSchema> getSchema() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSchema1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSchema> getSchema1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Schema"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSort1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSort> getSort1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Sort"));
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

	private List<ACollectionFolder> getFolders() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFolders1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionFolder> getFolders1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Folders"));
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

	private List<ACollectionNameTreeResources> getResources() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResources1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionNameTreeResources> getResources1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
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

	private List<ACollectionSplit> getSplit() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSplit1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSplit> getSplit1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Split"));
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
	public Boolean getcontainsView() {
		return this.baseObject.knownKey(ASAtom.getASAtom("View"));
	}

	@Override
	public Boolean getViewHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getViewNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		if (object == null || object.empty()) {
			return getViewNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getViewNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "D";
		}
		return null;
	}

	@Override
	public Boolean getcontainsSort() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Sort"));
	}

	@Override
	public Boolean getSortHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Sort"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsFolders() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Folders"));
	}

	@Override
	public Boolean getisFoldersIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Folders"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFoldersHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Folders"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSchema() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Schema"));
	}

	@Override
	public Boolean getSchemaHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Schema"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsNavigator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Navigator"));
	}

	@Override
	public Boolean getisNavigatorIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Navigator"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getNavigatorHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Navigator"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsColors() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Colors"));
	}

	@Override
	public Boolean getColorsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colors"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	@Override
	public Boolean getDHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsSplit() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Split"));
	}

	@Override
	public Boolean getSplitHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Split"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	@Override
	public Boolean getisResourcesIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object != null && object.get() != null && object.get().isIndirect();
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

}
