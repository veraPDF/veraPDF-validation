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

public class GFAOptContentUsage extends GFAObject implements AOptContentUsage {

	public GFAOptContentUsage(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentUsage");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Print":
				return getPrint();
			case "User":
				return getUser();
			case "Language":
				return getLanguage();
			case "Export":
				return getExport();
			case "Zoom":
				return getZoom();
			case "PageElement":
				return getPageElement();
			case "CreatorInfo":
				return getCreatorInfo();
			case "View":
				return getView();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AOptContentPrint> getPrint() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPrint1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentPrint> getPrint1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Print"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentPrint> list = new ArrayList<>(1);
			list.add(new GFAOptContentPrint((COSDictionary)object.getDirectBase(), this.baseObject, "Print"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentUser> getUser() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getUser1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentUser> getUser1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("User"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentUser> list = new ArrayList<>(1);
			list.add(new GFAOptContentUser((COSDictionary)object.getDirectBase(), this.baseObject, "User"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentLanguage> getLanguage() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLanguage1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentLanguage> getLanguage1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Language"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentLanguage> list = new ArrayList<>(1);
			list.add(new GFAOptContentLanguage((COSDictionary)object.getDirectBase(), this.baseObject, "Language"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentExport> getExport() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getExport1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentExport> getExport1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Export"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentExport> list = new ArrayList<>(1);
			list.add(new GFAOptContentExport((COSDictionary)object.getDirectBase(), this.baseObject, "Export"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentZoom> getZoom() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getZoom1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentZoom> getZoom1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Zoom"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentZoom> list = new ArrayList<>(1);
			list.add(new GFAOptContentZoom((COSDictionary)object.getDirectBase(), this.baseObject, "Zoom"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentPageElement> getPageElement() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPageElement1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentPageElement> getPageElement1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageElement"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentPageElement> list = new ArrayList<>(1);
			list.add(new GFAOptContentPageElement((COSDictionary)object.getDirectBase(), this.baseObject, "PageElement"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentCreatorInfo> getCreatorInfo() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCreatorInfo1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentCreatorInfo> getCreatorInfo1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreatorInfo"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentCreatorInfo> list = new ArrayList<>(1);
			list.add(new GFAOptContentCreatorInfo((COSDictionary)object.getDirectBase(), this.baseObject, "CreatorInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentView> getView() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getView1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentView> getView1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentView> list = new ArrayList<>(1);
			list.add(new GFAOptContentView((COSDictionary)object.getDirectBase(), this.baseObject, "View"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsView() {
		return this.baseObject.knownKey(ASAtom.getASAtom("View"));
	}

	@Override
	public Boolean getViewHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsZoom() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Zoom"));
	}

	@Override
	public Boolean getZoomHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Zoom"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsCreatorInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreatorInfo"));
	}

	@Override
	public Boolean getCreatorInfoHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreatorInfo"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPageElement() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageElement"));
	}

	@Override
	public Boolean getPageElementHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageElement"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsUser() {
		return this.baseObject.knownKey(ASAtom.getASAtom("User"));
	}

	@Override
	public Boolean getUserHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("User"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsExport() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Export"));
	}

	@Override
	public Boolean getExportHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Export"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPrint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Print"));
	}

	@Override
	public Boolean getPrintHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Print"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsLanguage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Language"));
	}

	@Override
	public Boolean getLanguageHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Language"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
