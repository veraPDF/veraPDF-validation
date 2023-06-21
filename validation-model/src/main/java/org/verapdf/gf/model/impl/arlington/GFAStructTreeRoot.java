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

public class GFAStructTreeRoot extends GFAObject implements AStructTreeRoot {

	public GFAStructTreeRoot(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AStructTreeRoot");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AF":
				return getAF();
			case "ClassMap":
				return getClassMap();
			case "IDTree":
				return getIDTree();
			case "K":
				return getK();
			case "Namespaces":
				return getNamespaces();
			case "ParentTree":
				return getParentTree();
			case "PronunciationLexicon":
				return getPronunciationLexicon();
			case "RoleMap":
				return getRoleMap();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getAF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAF2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getAF2_0() {
		COSObject object = getAFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AClassMap> getClassMap() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getClassMap1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AClassMap> getClassMap1_3() {
		COSObject object = getClassMapValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AClassMap> list = new ArrayList<>(1);
			list.add(new GFAClassMap((COSDictionary)object.getDirectBase(), this.baseObject, "ClassMap"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStructTreeRootNameTreeIDTree> getIDTree() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIDTree1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStructTreeRootNameTreeIDTree> getIDTree1_3() {
		COSObject object = getIDTreeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AStructTreeRootNameTreeIDTree> list = new ArrayList<>(1);
			list.add(new GFAStructTreeRootNameTreeIDTree((COSDictionary)object.getDirectBase(), this.baseObject, "IDTree"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getK() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getK1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getK1_3() {
		COSObject object = getKValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStructElem> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStructElem((COSArray)object.getDirectBase(), this.baseObject, "K"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AStructElem> list = new ArrayList<>(1);
			list.add(new GFAStructElem((COSDictionary)object.getDirectBase(), this.baseObject, "K"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNamespace> getNamespaces() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getNamespaces2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamespace> getNamespaces2_0() {
		COSObject object = getNamespacesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamespace> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamespace((COSArray)object.getDirectBase(), this.baseObject, "Namespaces"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStructTreeRootNumberTreeParentTree> getParentTree() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getParentTree1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStructTreeRootNumberTreeParentTree> getParentTree1_3() {
		COSObject object = getParentTreeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AStructTreeRootNumberTreeParentTree> list = new ArrayList<>(1);
			list.add(new GFAStructTreeRootNumberTreeParentTree((COSDictionary)object.getDirectBase(), this.baseObject, "ParentTree"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getPronunciationLexicon() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getPronunciationLexicon2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getPronunciationLexicon2_0() {
		COSObject object = getPronunciationLexiconValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "PronunciationLexicon"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "PronunciationLexicon"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARoleMap> getRoleMap() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRoleMap1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARoleMap> getRoleMap1_3() {
		COSObject object = getRoleMapValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARoleMap> list = new ArrayList<>(1);
			list.add(new GFARoleMap((COSDictionary)object.getDirectBase(), this.baseObject, "RoleMap"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AF"));
	}

	public COSObject getAFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		return object;
	}

	@Override
	public Boolean getAFHasTypeArray() {
		COSObject object = getAFValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getAFHasTypeDictionary() {
		COSObject object = getAFValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsClassMap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ClassMap"));
	}

	public COSObject getClassMapValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ClassMap"));
		return object;
	}

	@Override
	public Boolean getClassMapHasTypeDictionary() {
		COSObject object = getClassMapValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsIDTree() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IDTree"));
	}

	public COSObject getIDTreeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IDTree"));
		return object;
	}

	@Override
	public Boolean getIDTreeHasTypeNameTree() {
		COSObject object = getIDTreeValue();
		return getHasTypeNameTree(object);
	}

	@Override
	public Boolean getcontainsK() {
		return this.baseObject.knownKey(ASAtom.getASAtom("K"));
	}

	public COSObject getKValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("K"));
		return object;
	}

	@Override
	public Boolean getKHasTypeArray() {
		COSObject object = getKValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getKHasTypeDictionary() {
		COSObject object = getKValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsNamespaces() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Namespaces"));
	}

	public COSObject getNamespacesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Namespaces"));
		return object;
	}

	@Override
	public Boolean getNamespacesHasTypeArray() {
		COSObject object = getNamespacesValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsParentTree() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ParentTree"));
	}

	public COSObject getParentTreeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ParentTree"));
		return object;
	}

	@Override
	public Boolean getParentTreeHasTypeNumberTree() {
		COSObject object = getParentTreeValue();
		return getHasTypeNumberTree(object);
	}

	@Override
	public Boolean getcontainsParentTreeNextKey() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ParentTreeNextKey"));
	}

	public COSObject getParentTreeNextKeyValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ParentTreeNextKey"));
		return object;
	}

	@Override
	public Boolean getParentTreeNextKeyHasTypeInteger() {
		COSObject object = getParentTreeNextKeyValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getcontainsPronunciationLexicon() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PronunciationLexicon"));
	}

	public COSObject getPronunciationLexiconValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PronunciationLexicon"));
		return object;
	}

	@Override
	public Boolean getisPronunciationLexiconIndirect() {
		COSObject object = getPronunciationLexiconValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getPronunciationLexiconHasTypeArray() {
		COSObject object = getPronunciationLexiconValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getPronunciationLexiconHasTypeDictionary() {
		COSObject object = getPronunciationLexiconValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getPronunciationLexiconHasTypeString() {
		COSObject object = getPronunciationLexiconValue();
		return getHasTypeString(object);
	}

	@Override
	public Boolean getcontainsRoleMap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RoleMap"));
	}

	public COSObject getRoleMapValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RoleMap"));
		return object;
	}

	@Override
	public Boolean getRoleMapHasTypeDictionary() {
		COSObject object = getRoleMapValue();
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

}
