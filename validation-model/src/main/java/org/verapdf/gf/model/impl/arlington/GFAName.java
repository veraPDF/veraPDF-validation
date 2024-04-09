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

public class GFAName extends GFAObject implements AName {

	public GFAName(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AName");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AP":
				return getAP();
			case "APTreeNode":
				return getAPTreeNode();
			case "AlternatePresentations":
				return getAlternatePresentations();
			case "AlternatePresentationsTreeNode":
				return getAlternatePresentationsTreeNode();
			case "Dests":
				return getDests();
			case "DestsTreeNode":
				return getDestsTreeNode();
			case "EmbeddedFiles":
				return getEmbeddedFiles();
			case "EmbeddedFilesTreeNode":
				return getEmbeddedFilesTreeNode();
			case "IDS":
				return getIDS();
			case "IDSTreeNode":
				return getIDSTreeNode();
			case "JavaScript":
				return getJavaScript();
			case "JavaScriptTreeNode":
				return getJavaScriptTreeNode();
			case "Pages":
				return getPages();
			case "PagesTreeNode":
				return getPagesTreeNode();
			case "Renditions":
				return getRenditions();
			case "RenditionsTreeNode":
				return getRenditionsTreeNode();
			case "Templates":
				return getTemplates();
			case "TemplatesTreeNode":
				return getTemplatesTreeNode();
			case "URLS":
				return getURLS();
			case "URLSTreeNode":
				return getURLSTreeNode();
			case "XFAResources":
				return getXFAResources();
			case "XFAResourcesTreeNode":
				return getXFAResourcesTreeNode();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ANameNameTreeAP> getAP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAP1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeAP> getAP1_3() {
		COSObject object = getAPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeAP> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeAP((COSDictionary)object.getDirectBase(), this.baseObject, "AP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getAPTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAPTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getAPTreeNode1_3() {
		COSObject object = getAPTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "APTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeAlternatePresentations> getAlternatePresentations() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAlternatePresentations1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeAlternatePresentations> getAlternatePresentations1_4() {
		COSObject object = getAlternatePresentationsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeAlternatePresentations> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeAlternatePresentations((COSDictionary)object.getDirectBase(), this.baseObject, "AlternatePresentations"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getAlternatePresentationsTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAlternatePresentationsTreeNode1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getAlternatePresentationsTreeNode1_4() {
		COSObject object = getAlternatePresentationsTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "AlternatePresentationsTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeDests> getDests() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDests1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeDests> getDests1_2() {
		COSObject object = getDestsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeDests> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeDests((COSDictionary)object.getDirectBase(), this.baseObject, "Dests"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getDestsTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDestsTreeNode1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getDestsTreeNode1_2() {
		COSObject object = getDestsTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "DestsTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeEmbeddedFiles> getEmbeddedFiles() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEmbeddedFiles1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeEmbeddedFiles> getEmbeddedFiles1_4() {
		COSObject object = getEmbeddedFilesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeEmbeddedFiles> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeEmbeddedFiles((COSDictionary)object.getDirectBase(), this.baseObject, "EmbeddedFiles"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getEmbeddedFilesTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEmbeddedFilesTreeNode1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getEmbeddedFilesTreeNode1_4() {
		COSObject object = getEmbeddedFilesTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "EmbeddedFilesTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeIDS> getIDS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIDS1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeIDS> getIDS1_3() {
		COSObject object = getIDSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeIDS> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeIDS((COSDictionary)object.getDirectBase(), this.baseObject, "IDS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getIDSTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIDSTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getIDSTreeNode1_3() {
		COSObject object = getIDSTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "IDSTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeJavaScript> getJavaScript() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getJavaScript1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeJavaScript> getJavaScript1_3() {
		COSObject object = getJavaScriptValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeJavaScript> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeJavaScript((COSDictionary)object.getDirectBase(), this.baseObject, "JavaScript"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getJavaScriptTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getJavaScriptTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getJavaScriptTreeNode1_3() {
		COSObject object = getJavaScriptTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "JavaScriptTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreePages> getPages() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPages1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreePages> getPages1_3() {
		COSObject object = getPagesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreePages> list = new ArrayList<>(1);
			list.add(new GFANameNameTreePages((COSDictionary)object.getDirectBase(), this.baseObject, "Pages"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getPagesTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPagesTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getPagesTreeNode1_3() {
		COSObject object = getPagesTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "PagesTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeRenditions> getRenditions() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRenditions1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeRenditions> getRenditions1_5() {
		COSObject object = getRenditionsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeRenditions> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeRenditions((COSDictionary)object.getDirectBase(), this.baseObject, "Renditions"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getRenditionsTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRenditionsTreeNode1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getRenditionsTreeNode1_5() {
		COSObject object = getRenditionsTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "RenditionsTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeTemplates> getTemplates() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTemplates1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeTemplates> getTemplates1_3() {
		COSObject object = getTemplatesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeTemplates> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeTemplates((COSDictionary)object.getDirectBase(), this.baseObject, "Templates"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getTemplatesTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTemplatesTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getTemplatesTreeNode1_3() {
		COSObject object = getTemplatesTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "TemplatesTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeURLS> getURLS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getURLS1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeURLS> getURLS1_3() {
		COSObject object = getURLSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeURLS> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeURLS((COSDictionary)object.getDirectBase(), this.baseObject, "URLS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getURLSTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getURLSTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getURLSTreeNode1_3() {
		COSObject object = getURLSTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "URLSTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameNameTreeXFAResources> getXFAResources() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getXFAResources1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameNameTreeXFAResources> getXFAResources1_7() {
		COSObject object = getXFAResourcesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameNameTreeXFAResources> list = new ArrayList<>(1);
			list.add(new GFANameNameTreeXFAResources((COSDictionary)object.getDirectBase(), this.baseObject, "XFAResources"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getXFAResourcesTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getXFAResourcesTreeNode1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getXFAResourcesTreeNode1_7() {
		COSObject object = getXFAResourcesTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "XFAResourcesTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AP"));
	}

	public COSObject getAPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		return object;
	}

	@Override
	public String getAPType() {
		COSObject AP = getAPValue();
		return getObjectType(AP);
	}

	@Override
	public Boolean getAPHasTypeNameTree() {
		COSObject AP = getAPValue();
		return getHasTypeNameTree(AP);
	}

	@Override
	public Boolean getcontainsAPTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AP"));
	}

	public COSObject getAPTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		return object;
	}

	@Override
	public String getAPTreeNodeType() {
		COSObject APTreeNode = getAPTreeNodeValue();
		return getObjectType(APTreeNode);
	}

	@Override
	public Boolean getAPTreeNodeHasTypeNameTree() {
		COSObject APTreeNode = getAPTreeNodeValue();
		return getHasTypeNameTree(APTreeNode);
	}

	@Override
	public Boolean getcontainsAlternatePresentations() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AlternatePresentations"));
	}

	public COSObject getAlternatePresentationsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AlternatePresentations"));
		return object;
	}

	@Override
	public String getAlternatePresentationsType() {
		COSObject AlternatePresentations = getAlternatePresentationsValue();
		return getObjectType(AlternatePresentations);
	}

	@Override
	public Boolean getAlternatePresentationsHasTypeNameTree() {
		COSObject AlternatePresentations = getAlternatePresentationsValue();
		return getHasTypeNameTree(AlternatePresentations);
	}

	@Override
	public Boolean getcontainsAlternatePresentationsTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AlternatePresentations"));
	}

	public COSObject getAlternatePresentationsTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AlternatePresentations"));
		return object;
	}

	@Override
	public String getAlternatePresentationsTreeNodeType() {
		COSObject AlternatePresentationsTreeNode = getAlternatePresentationsTreeNodeValue();
		return getObjectType(AlternatePresentationsTreeNode);
	}

	@Override
	public Boolean getAlternatePresentationsTreeNodeHasTypeNameTree() {
		COSObject AlternatePresentationsTreeNode = getAlternatePresentationsTreeNodeValue();
		return getHasTypeNameTree(AlternatePresentationsTreeNode);
	}

	@Override
	public Boolean getcontainsDests() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dests"));
	}

	public COSObject getDestsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dests"));
		return object;
	}

	@Override
	public String getDestsType() {
		COSObject Dests = getDestsValue();
		return getObjectType(Dests);
	}

	@Override
	public Boolean getDestsHasTypeNameTree() {
		COSObject Dests = getDestsValue();
		return getHasTypeNameTree(Dests);
	}

	@Override
	public Boolean getcontainsDestsTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dests"));
	}

	public COSObject getDestsTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dests"));
		return object;
	}

	@Override
	public String getDestsTreeNodeType() {
		COSObject DestsTreeNode = getDestsTreeNodeValue();
		return getObjectType(DestsTreeNode);
	}

	@Override
	public Boolean getDestsTreeNodeHasTypeNameTree() {
		COSObject DestsTreeNode = getDestsTreeNodeValue();
		return getHasTypeNameTree(DestsTreeNode);
	}

	@Override
	public Boolean getcontainsEmbeddedFiles() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EmbeddedFiles"));
	}

	public COSObject getEmbeddedFilesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EmbeddedFiles"));
		return object;
	}

	@Override
	public String getEmbeddedFilesType() {
		COSObject EmbeddedFiles = getEmbeddedFilesValue();
		return getObjectType(EmbeddedFiles);
	}

	@Override
	public Boolean getEmbeddedFilesHasTypeNameTree() {
		COSObject EmbeddedFiles = getEmbeddedFilesValue();
		return getHasTypeNameTree(EmbeddedFiles);
	}

	@Override
	public Boolean getcontainsEmbeddedFilesTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EmbeddedFiles"));
	}

	public COSObject getEmbeddedFilesTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EmbeddedFiles"));
		return object;
	}

	@Override
	public String getEmbeddedFilesTreeNodeType() {
		COSObject EmbeddedFilesTreeNode = getEmbeddedFilesTreeNodeValue();
		return getObjectType(EmbeddedFilesTreeNode);
	}

	@Override
	public Boolean getEmbeddedFilesTreeNodeHasTypeNameTree() {
		COSObject EmbeddedFilesTreeNode = getEmbeddedFilesTreeNodeValue();
		return getHasTypeNameTree(EmbeddedFilesTreeNode);
	}

	@Override
	public Boolean getcontainsIDS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IDS"));
	}

	public COSObject getIDSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IDS"));
		return object;
	}

	@Override
	public String getIDSType() {
		COSObject IDS = getIDSValue();
		return getObjectType(IDS);
	}

	@Override
	public Boolean getIDSHasTypeNameTree() {
		COSObject IDS = getIDSValue();
		return getHasTypeNameTree(IDS);
	}

	@Override
	public Boolean getcontainsIDSTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IDS"));
	}

	public COSObject getIDSTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IDS"));
		return object;
	}

	@Override
	public String getIDSTreeNodeType() {
		COSObject IDSTreeNode = getIDSTreeNodeValue();
		return getObjectType(IDSTreeNode);
	}

	@Override
	public Boolean getIDSTreeNodeHasTypeNameTree() {
		COSObject IDSTreeNode = getIDSTreeNodeValue();
		return getHasTypeNameTree(IDSTreeNode);
	}

	@Override
	public Boolean getcontainsJavaScript() {
		return this.baseObject.knownKey(ASAtom.getASAtom("JavaScript"));
	}

	public COSObject getJavaScriptValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("JavaScript"));
		return object;
	}

	@Override
	public String getJavaScriptType() {
		COSObject JavaScript = getJavaScriptValue();
		return getObjectType(JavaScript);
	}

	@Override
	public Boolean getJavaScriptHasTypeNameTree() {
		COSObject JavaScript = getJavaScriptValue();
		return getHasTypeNameTree(JavaScript);
	}

	@Override
	public Boolean getcontainsJavaScriptTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("JavaScript"));
	}

	public COSObject getJavaScriptTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("JavaScript"));
		return object;
	}

	@Override
	public String getJavaScriptTreeNodeType() {
		COSObject JavaScriptTreeNode = getJavaScriptTreeNodeValue();
		return getObjectType(JavaScriptTreeNode);
	}

	@Override
	public Boolean getJavaScriptTreeNodeHasTypeNameTree() {
		COSObject JavaScriptTreeNode = getJavaScriptTreeNodeValue();
		return getHasTypeNameTree(JavaScriptTreeNode);
	}

	@Override
	public Boolean getcontainsPages() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pages"));
	}

	public COSObject getPagesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
		return object;
	}

	@Override
	public String getPagesType() {
		COSObject Pages = getPagesValue();
		return getObjectType(Pages);
	}

	@Override
	public Boolean getPagesHasTypeNameTree() {
		COSObject Pages = getPagesValue();
		return getHasTypeNameTree(Pages);
	}

	@Override
	public Boolean getcontainsPagesTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pages"));
	}

	public COSObject getPagesTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
		return object;
	}

	@Override
	public String getPagesTreeNodeType() {
		COSObject PagesTreeNode = getPagesTreeNodeValue();
		return getObjectType(PagesTreeNode);
	}

	@Override
	public Boolean getPagesTreeNodeHasTypeNameTree() {
		COSObject PagesTreeNode = getPagesTreeNodeValue();
		return getHasTypeNameTree(PagesTreeNode);
	}

	@Override
	public Boolean getcontainsRenditions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Renditions"));
	}

	public COSObject getRenditionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Renditions"));
		return object;
	}

	@Override
	public String getRenditionsType() {
		COSObject Renditions = getRenditionsValue();
		return getObjectType(Renditions);
	}

	@Override
	public Boolean getRenditionsHasTypeNameTree() {
		COSObject Renditions = getRenditionsValue();
		return getHasTypeNameTree(Renditions);
	}

	@Override
	public Boolean getcontainsRenditionsTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Renditions"));
	}

	public COSObject getRenditionsTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Renditions"));
		return object;
	}

	@Override
	public String getRenditionsTreeNodeType() {
		COSObject RenditionsTreeNode = getRenditionsTreeNodeValue();
		return getObjectType(RenditionsTreeNode);
	}

	@Override
	public Boolean getRenditionsTreeNodeHasTypeNameTree() {
		COSObject RenditionsTreeNode = getRenditionsTreeNodeValue();
		return getHasTypeNameTree(RenditionsTreeNode);
	}

	@Override
	public Boolean getcontainsTemplates() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Templates"));
	}

	public COSObject getTemplatesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Templates"));
		return object;
	}

	@Override
	public String getTemplatesType() {
		COSObject Templates = getTemplatesValue();
		return getObjectType(Templates);
	}

	@Override
	public Boolean getTemplatesHasTypeNameTree() {
		COSObject Templates = getTemplatesValue();
		return getHasTypeNameTree(Templates);
	}

	@Override
	public Boolean getcontainsTemplatesTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Templates"));
	}

	public COSObject getTemplatesTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Templates"));
		return object;
	}

	@Override
	public String getTemplatesTreeNodeType() {
		COSObject TemplatesTreeNode = getTemplatesTreeNodeValue();
		return getObjectType(TemplatesTreeNode);
	}

	@Override
	public Boolean getTemplatesTreeNodeHasTypeNameTree() {
		COSObject TemplatesTreeNode = getTemplatesTreeNodeValue();
		return getHasTypeNameTree(TemplatesTreeNode);
	}

	@Override
	public Boolean getcontainsURLS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URLS"));
	}

	public COSObject getURLSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLS"));
		return object;
	}

	@Override
	public String getURLSType() {
		COSObject URLS = getURLSValue();
		return getObjectType(URLS);
	}

	@Override
	public Boolean getURLSHasTypeNameTree() {
		COSObject URLS = getURLSValue();
		return getHasTypeNameTree(URLS);
	}

	@Override
	public Boolean getcontainsURLSTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URLS"));
	}

	public COSObject getURLSTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLS"));
		return object;
	}

	@Override
	public String getURLSTreeNodeType() {
		COSObject URLSTreeNode = getURLSTreeNodeValue();
		return getObjectType(URLSTreeNode);
	}

	@Override
	public Boolean getURLSTreeNodeHasTypeNameTree() {
		COSObject URLSTreeNode = getURLSTreeNodeValue();
		return getHasTypeNameTree(URLSTreeNode);
	}

	@Override
	public Boolean getcontainsXFAResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XFAResources"));
	}

	public COSObject getXFAResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFAResources"));
		return object;
	}

	@Override
	public String getXFAResourcesType() {
		COSObject XFAResources = getXFAResourcesValue();
		return getObjectType(XFAResources);
	}

	@Override
	public Boolean getXFAResourcesHasTypeNameTree() {
		COSObject XFAResources = getXFAResourcesValue();
		return getHasTypeNameTree(XFAResources);
	}

	@Override
	public Boolean getcontainsXFAResourcesTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XFAResources"));
	}

	public COSObject getXFAResourcesTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFAResources"));
		return object;
	}

	@Override
	public String getXFAResourcesTreeNodeType() {
		COSObject XFAResourcesTreeNode = getXFAResourcesTreeNodeValue();
		return getObjectType(XFAResourcesTreeNode);
	}

	@Override
	public Boolean getXFAResourcesTreeNodeHasTypeNameTree() {
		COSObject XFAResourcesTreeNode = getXFAResourcesTreeNodeValue();
		return getHasTypeNameTree(XFAResourcesTreeNode);
	}

}
