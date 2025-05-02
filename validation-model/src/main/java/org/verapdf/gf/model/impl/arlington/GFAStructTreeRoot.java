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
			case "IDTreeTreeNode":
				return getIDTreeTreeNode();
			case "K":
				return getK();
			case "Namespaces":
				return getNamespaces();
			case "ParentTree":
				return getParentTree();
			case "ParentTreeTreeNode":
				return getParentTreeTreeNode();
			case "PronunciationLexicon":
				return getPronunciationLexicon();
			case "RoleMap":
				return getRoleMap();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfAFFileSpecifications> getAF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionISO_19005_3() == true)) {
					return getAF1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getAF1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfAFFileSpecifications> getAF1_7() {
		COSObject object = getAFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfAFFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfAFFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "AF"));
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

	private List<ANameTreeNode> getIDTreeTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIDTreeTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getIDTreeTreeNode1_3() {
		COSObject object = getIDTreeTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "IDTreeTreeNode"));
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

	private List<ANumberTreeNode> getParentTreeTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getParentTreeTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANumberTreeNode> getParentTreeTreeNode1_3() {
		COSObject object = getParentTreeTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANumberTreeNode> list = new ArrayList<>(1);
			list.add(new GFANumberTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "ParentTreeTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfFileSpecifications> getPronunciationLexicon() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getPronunciationLexicon2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFileSpecifications> getPronunciationLexicon2_0() {
		COSObject object = getPronunciationLexiconValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "PronunciationLexicon"));
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
	public String getAFType() {
		COSObject AF = getAFValue();
		return getObjectType(AF);
	}

	@Override
	public Boolean getAFHasTypeArray() {
		COSObject AF = getAFValue();
		return getHasTypeArray(AF);
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
	public String getClassMapType() {
		COSObject ClassMap = getClassMapValue();
		return getObjectType(ClassMap);
	}

	@Override
	public Boolean getClassMapHasTypeDictionary() {
		COSObject ClassMap = getClassMapValue();
		return getHasTypeDictionary(ClassMap);
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
	public String getIDTreeType() {
		COSObject IDTree = getIDTreeValue();
		return getObjectType(IDTree);
	}

	@Override
	public Boolean getIDTreeHasTypeNameTree() {
		COSObject IDTree = getIDTreeValue();
		return getHasTypeNameTree(IDTree);
	}

	@Override
	public Boolean getcontainsIDTreeTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IDTree"));
	}

	public COSObject getIDTreeTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IDTree"));
		return object;
	}

	@Override
	public String getIDTreeTreeNodeType() {
		COSObject IDTreeTreeNode = getIDTreeTreeNodeValue();
		return getObjectType(IDTreeTreeNode);
	}

	@Override
	public Boolean getIDTreeTreeNodeHasTypeNameTree() {
		COSObject IDTreeTreeNode = getIDTreeTreeNodeValue();
		return getHasTypeNameTree(IDTreeTreeNode);
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
	public String getKType() {
		COSObject K = getKValue();
		return getObjectType(K);
	}

	@Override
	public Boolean getKHasTypeArray() {
		COSObject K = getKValue();
		return getHasTypeArray(K);
	}

	@Override
	public Boolean getKHasTypeDictionary() {
		COSObject K = getKValue();
		return getHasTypeDictionary(K);
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
	public String getNamespacesType() {
		COSObject Namespaces = getNamespacesValue();
		return getObjectType(Namespaces);
	}

	@Override
	public Boolean getNamespacesHasTypeArray() {
		COSObject Namespaces = getNamespacesValue();
		return getHasTypeArray(Namespaces);
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
	public String getParentTreeType() {
		COSObject ParentTree = getParentTreeValue();
		return getObjectType(ParentTree);
	}

	@Override
	public Boolean getParentTreeHasTypeNumberTree() {
		COSObject ParentTree = getParentTreeValue();
		return getHasTypeNumberTree(ParentTree);
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
	public String getParentTreeNextKeyType() {
		COSObject ParentTreeNextKey = getParentTreeNextKeyValue();
		return getObjectType(ParentTreeNextKey);
	}

	@Override
	public Boolean getParentTreeNextKeyHasTypeInteger() {
		COSObject ParentTreeNextKey = getParentTreeNextKeyValue();
		return getHasTypeInteger(ParentTreeNextKey);
	}

	@Override
	public Boolean getcontainsParentTreeTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ParentTree"));
	}

	public COSObject getParentTreeTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ParentTree"));
		return object;
	}

	@Override
	public String getParentTreeTreeNodeType() {
		COSObject ParentTreeTreeNode = getParentTreeTreeNodeValue();
		return getObjectType(ParentTreeTreeNode);
	}

	@Override
	public Boolean getParentTreeTreeNodeHasTypeNumberTree() {
		COSObject ParentTreeTreeNode = getParentTreeTreeNodeValue();
		return getHasTypeNumberTree(ParentTreeTreeNode);
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
	public String getPronunciationLexiconType() {
		COSObject PronunciationLexicon = getPronunciationLexiconValue();
		return getObjectType(PronunciationLexicon);
	}

	@Override
	public Boolean getPronunciationLexiconHasTypeArray() {
		COSObject PronunciationLexicon = getPronunciationLexiconValue();
		return getHasTypeArray(PronunciationLexicon);
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
	public String getRoleMapType() {
		COSObject RoleMap = getRoleMapValue();
		return getObjectType(RoleMap);
	}

	@Override
	public Boolean getRoleMapHasTypeDictionary() {
		COSObject RoleMap = getRoleMapValue();
		return getHasTypeDictionary(RoleMap);
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

}
