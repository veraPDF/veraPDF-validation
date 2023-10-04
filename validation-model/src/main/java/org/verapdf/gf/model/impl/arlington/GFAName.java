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
			case "AlternatePresentations":
				return getAlternatePresentations();
			case "Dests":
				return getDests();
			case "EmbeddedFiles":
				return getEmbeddedFiles();
			case "IDS":
				return getIDS();
			case "JavaScript":
				return getJavaScript();
			case "Pages":
				return getPages();
			case "Renditions":
				return getRenditions();
			case "Templates":
				return getTemplates();
			case "URLS":
				return getURLS();
			case "XFAResources":
				return getXFAResources();
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

	@Override
	public Boolean getcontainsAP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AP"));
	}

	public COSObject getAPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		return object;
	}

	@Override
	public Boolean getAPHasTypeNameTree() {
		COSObject AP = getAPValue();
		return getHasTypeNameTree(AP);
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
	public Boolean getAlternatePresentationsHasTypeNameTree() {
		COSObject AlternatePresentations = getAlternatePresentationsValue();
		return getHasTypeNameTree(AlternatePresentations);
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
	public Boolean getDestsHasTypeNameTree() {
		COSObject Dests = getDestsValue();
		return getHasTypeNameTree(Dests);
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
	public Boolean getEmbeddedFilesHasTypeNameTree() {
		COSObject EmbeddedFiles = getEmbeddedFilesValue();
		return getHasTypeNameTree(EmbeddedFiles);
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
	public Boolean getIDSHasTypeNameTree() {
		COSObject IDS = getIDSValue();
		return getHasTypeNameTree(IDS);
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
	public Boolean getJavaScriptHasTypeNameTree() {
		COSObject JavaScript = getJavaScriptValue();
		return getHasTypeNameTree(JavaScript);
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
	public Boolean getPagesHasTypeNameTree() {
		COSObject Pages = getPagesValue();
		return getHasTypeNameTree(Pages);
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
	public Boolean getRenditionsHasTypeNameTree() {
		COSObject Renditions = getRenditionsValue();
		return getHasTypeNameTree(Renditions);
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
	public Boolean getTemplatesHasTypeNameTree() {
		COSObject Templates = getTemplatesValue();
		return getHasTypeNameTree(Templates);
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
	public Boolean getURLSHasTypeNameTree() {
		COSObject URLS = getURLSValue();
		return getHasTypeNameTree(URLS);
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
	public Boolean getXFAResourcesHasTypeNameTree() {
		COSObject XFAResources = getXFAResourcesValue();
		return getHasTypeNameTree(XFAResources);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
