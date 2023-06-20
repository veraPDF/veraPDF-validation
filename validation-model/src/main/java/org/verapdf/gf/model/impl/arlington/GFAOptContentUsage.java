package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFAOptContentUsage extends GFAObject implements AOptContentUsage {

	public GFAOptContentUsage(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentUsage");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CreatorInfo":
				return getCreatorInfo();
			case "Export":
				return getExport();
			case "Language":
				return getLanguage();
			case "PageElement":
				return getPageElement();
			case "Print":
				return getPrint();
			case "User":
				return getUser();
			case "View":
				return getView();
			case "Zoom":
				return getZoom();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AOptContentCreatorInfo> getCreatorInfo() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getCreatorInfoValue();
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

	private List<AOptContentExport> getExport() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getExportValue();
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

	private List<AOptContentLanguage> getLanguage() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getLanguageValue();
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

	private List<AOptContentPageElement> getPageElement() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getPageElementValue();
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

	private List<AOptContentPrint> getPrint() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getPrintValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getUserValue();
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

	private List<AOptContentView> getView() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getViewValue();
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

	private List<AOptContentZoom> getZoom() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getZoomValue();
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

	@Override
	public Boolean getcontainsCreatorInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreatorInfo"));
	}

	public COSObject getCreatorInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreatorInfo"));
		return object;
	}

	@Override
	public Boolean getCreatorInfoHasTypeDictionary() {
		COSObject object = getCreatorInfoValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsExport() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Export"));
	}

	public COSObject getExportValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Export"));
		return object;
	}

	@Override
	public Boolean getExportHasTypeDictionary() {
		COSObject object = getExportValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsLanguage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Language"));
	}

	public COSObject getLanguageValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Language"));
		return object;
	}

	@Override
	public Boolean getLanguageHasTypeDictionary() {
		COSObject object = getLanguageValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsPageElement() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageElement"));
	}

	public COSObject getPageElementValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageElement"));
		return object;
	}

	@Override
	public Boolean getPageElementHasTypeDictionary() {
		COSObject object = getPageElementValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsPrint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Print"));
	}

	public COSObject getPrintValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Print"));
		return object;
	}

	@Override
	public Boolean getPrintHasTypeDictionary() {
		COSObject object = getPrintValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsUser() {
		return this.baseObject.knownKey(ASAtom.getASAtom("User"));
	}

	public COSObject getUserValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("User"));
		return object;
	}

	@Override
	public Boolean getUserHasTypeDictionary() {
		COSObject object = getUserValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsView() {
		return this.baseObject.knownKey(ASAtom.getASAtom("View"));
	}

	public COSObject getViewValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		return object;
	}

	@Override
	public Boolean getViewHasTypeDictionary() {
		COSObject object = getViewValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsZoom() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Zoom"));
	}

	public COSObject getZoomValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Zoom"));
		return object;
	}

	@Override
	public Boolean getZoomHasTypeDictionary() {
		COSObject object = getZoomValue();
		return getHasTypeDictionary(object);
	}

}
