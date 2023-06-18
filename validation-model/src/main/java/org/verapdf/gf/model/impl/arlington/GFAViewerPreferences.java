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

public class GFAViewerPreferences extends GFAObject implements AViewerPreferences {

	public GFAViewerPreferences(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AViewerPreferences");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Enforce":
				return getEnforce();
			case "PrintPageRange":
				return getPrintPageRange();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNamesForEnforce> getEnforce() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEnforce1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesForEnforce> getEnforce1_7() {
		COSObject object = getEnforceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesForEnforce> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesForEnforce((COSArray)object.getDirectBase(), this.baseObject, "Enforce"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfIntegersGeneral> getPrintPageRange() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPrintPageRange1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfIntegersGeneral> getPrintPageRange1_7() {
		COSObject object = getPrintPageRangeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfIntegersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfIntegersGeneral((COSArray)object.getDirectBase(), this.baseObject, "PrintPageRange"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCenterWindow() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CenterWindow"));
	}

	public COSObject getCenterWindowDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getCenterWindowValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CenterWindow"));
		if (object == null || object.empty()) {
			object = getCenterWindowDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getCenterWindowHasTypeBoolean() {
		COSObject object = getCenterWindowValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsDirection() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Direction"));
	}

	public COSObject getDirectionDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("L2R");
		}
		return null;
	}

	public COSObject getDirectionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Direction"));
		if (object == null || object.empty()) {
			object = getDirectionDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDirectionHasTypeName() {
		COSObject object = getDirectionValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDirectionNameValue() {
		COSObject object = getDirectionValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDisplayDocTitle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DisplayDocTitle"));
	}

	public COSObject getDisplayDocTitleDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getDisplayDocTitleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DisplayDocTitle"));
		if (object == null || object.empty()) {
			object = getDisplayDocTitleDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDisplayDocTitleHasTypeBoolean() {
		COSObject object = getDisplayDocTitleValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsDuplex() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Duplex"));
	}

	public COSObject getDuplexValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duplex"));
		return object;
	}

	@Override
	public Boolean getDuplexHasTypeName() {
		COSObject object = getDuplexValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDuplexNameValue() {
		COSObject object = getDuplexValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsEnforce() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Enforce"));
	}

	public COSObject getEnforceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Enforce"));
		return object;
	}

	@Override
	public Boolean getEnforceHasTypeArray() {
		COSObject object = getEnforceValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsFitWindow() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FitWindow"));
	}

	public COSObject getFitWindowDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getFitWindowValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FitWindow"));
		if (object == null || object.empty()) {
			object = getFitWindowDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getFitWindowHasTypeBoolean() {
		COSObject object = getFitWindowValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsHideMenubar() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HideMenubar"));
	}

	public COSObject getHideMenubarDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getHideMenubarValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideMenubar"));
		if (object == null || object.empty()) {
			object = getHideMenubarDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getHideMenubarHasTypeBoolean() {
		COSObject object = getHideMenubarValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsHideToolbar() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HideToolbar"));
	}

	public COSObject getHideToolbarDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getHideToolbarValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideToolbar"));
		if (object == null || object.empty()) {
			object = getHideToolbarDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getHideToolbarHasTypeBoolean() {
		COSObject object = getHideToolbarValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsHideWindowUI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HideWindowUI"));
	}

	public COSObject getHideWindowUIDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getHideWindowUIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideWindowUI"));
		if (object == null || object.empty()) {
			object = getHideWindowUIDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getHideWindowUIHasTypeBoolean() {
		COSObject object = getHideWindowUIValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsNonFullScreenPageMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NonFullScreenPageMode"));
	}

	public COSObject getNonFullScreenPageModeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("UseNone");
		}
		return null;
	}

	public COSObject getNonFullScreenPageModeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NonFullScreenPageMode"));
		if (object == null || object.empty()) {
			object = getNonFullScreenPageModeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getNonFullScreenPageModeHasTypeName() {
		COSObject object = getNonFullScreenPageModeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getNonFullScreenPageModeNameValue() {
		COSObject object = getNonFullScreenPageModeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsNumCopies() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NumCopies"));
	}

	public COSObject getNumCopiesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NumCopies"));
		return object;
	}

	@Override
	public Boolean getNumCopiesHasTypeInteger() {
		COSObject object = getNumCopiesValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getNumCopiesIntegerValue() {
		COSObject object = getNumCopiesValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPickTrayByPDFSize() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PickTrayByPDFSize"));
	}

	public COSObject getPickTrayByPDFSizeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getPickTrayByPDFSizeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PickTrayByPDFSize"));
		if (object == null || object.empty()) {
			object = getPickTrayByPDFSizeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPickTrayByPDFSizeHasTypeBoolean() {
		COSObject object = getPickTrayByPDFSizeValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsPrintArea() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintArea"));
	}

	public COSObject getPrintAreaDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("CropBox");
		}
		return null;
	}

	public COSObject getPrintAreaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintArea"));
		if (object == null || object.empty()) {
			object = getPrintAreaDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPrintAreaHasTypeName() {
		COSObject object = getPrintAreaValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPrintAreaNameValue() {
		COSObject object = getPrintAreaValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPrintClip() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintClip"));
	}

	public COSObject getPrintClipDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("CropBox");
		}
		return null;
	}

	public COSObject getPrintClipValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintClip"));
		if (object == null || object.empty()) {
			object = getPrintClipDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPrintClipHasTypeName() {
		COSObject object = getPrintClipValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPrintClipNameValue() {
		COSObject object = getPrintClipValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPrintPageRange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintPageRange"));
	}

	public COSObject getPrintPageRangeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintPageRange"));
		return object;
	}

	@Override
	public Boolean getPrintPageRangeHasTypeArray() {
		COSObject object = getPrintPageRangeValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPrintScaling() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintScaling"));
	}

	public COSObject getPrintScalingDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("AppDefault");
		}
		return null;
	}

	public COSObject getPrintScalingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintScaling"));
		if (object == null || object.empty()) {
			object = getPrintScalingDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPrintScalingHasTypeName() {
		COSObject object = getPrintScalingValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPrintScalingNameValue() {
		COSObject object = getPrintScalingValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsViewArea() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ViewArea"));
	}

	public COSObject getViewAreaDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("CropBox");
		}
		return null;
	}

	public COSObject getViewAreaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewArea"));
		if (object == null || object.empty()) {
			object = getViewAreaDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getViewAreaHasTypeName() {
		COSObject object = getViewAreaValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getViewAreaNameValue() {
		COSObject object = getViewAreaValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsViewClip() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ViewClip"));
	}

	public COSObject getViewClipDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("CropBox");
		}
		return null;
	}

	public COSObject getViewClipValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewClip"));
		if (object == null || object.empty()) {
			object = getViewClipDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getViewClipHasTypeName() {
		COSObject object = getViewClipValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getViewClipNameValue() {
		COSObject object = getViewClipValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public String gettrailerCatalogPageModeNameValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		if (Root == null || !Root.getType().isDictionaryBased()) {
			return null;
		}
		COSObject PageMode = Root.getKey(ASAtom.getASAtom("PageMode"));
		return new GFACatalog(Root.getDirectBase(), null, null).getPageModeNameValue();
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
