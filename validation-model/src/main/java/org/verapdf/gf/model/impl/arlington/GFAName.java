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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AlternatePresentations"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dests"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EmbeddedFiles"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IDS"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("JavaScript"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Renditions"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Templates"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLS"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFAResources"));
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

	@Override
	public Boolean getAPHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsAlternatePresentations() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AlternatePresentations"));
	}

	@Override
	public Boolean getAlternatePresentationsHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AlternatePresentations"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDests() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dests"));
	}

	@Override
	public Boolean getDestsHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dests"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsEmbeddedFiles() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EmbeddedFiles"));
	}

	@Override
	public Boolean getEmbeddedFilesHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EmbeddedFiles"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsIDS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IDS"));
	}

	@Override
	public Boolean getIDSHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IDS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsJavaScript() {
		return this.baseObject.knownKey(ASAtom.getASAtom("JavaScript"));
	}

	@Override
	public Boolean getJavaScriptHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("JavaScript"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPages() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pages"));
	}

	@Override
	public Boolean getPagesHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsRenditions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Renditions"));
	}

	@Override
	public Boolean getRenditionsHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Renditions"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsTemplates() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Templates"));
	}

	@Override
	public Boolean getTemplatesHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Templates"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsURLS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URLS"));
	}

	@Override
	public Boolean getURLSHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsXFAResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XFAResources"));
	}

	@Override
	public Boolean getXFAResourcesHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFAResources"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
