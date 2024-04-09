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

	private List<AArrayOfIntegersGreaterThanZero> getPrintPageRange() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPrintPageRange1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfIntegersGreaterThanZero> getPrintPageRange1_7() {
		COSObject object = getPrintPageRangeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfIntegersGreaterThanZero> list = new ArrayList<>(1);
			list.add(new GFAArrayOfIntegersGreaterThanZero((COSArray)object.getDirectBase(), this.baseObject, "PrintPageRange"));
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
	public String getCenterWindowType() {
		COSObject CenterWindow = getCenterWindowValue();
		return getObjectType(CenterWindow);
	}

	@Override
	public Boolean getCenterWindowHasTypeBoolean() {
		COSObject CenterWindow = getCenterWindowValue();
		return getHasTypeBoolean(CenterWindow);
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
	public String getDirectionType() {
		COSObject Direction = getDirectionValue();
		return getObjectType(Direction);
	}

	@Override
	public Boolean getDirectionHasTypeName() {
		COSObject Direction = getDirectionValue();
		return getHasTypeName(Direction);
	}

	@Override
	public String getDirectionNameValue() {
		COSObject Direction = getDirectionValue();
		return getNameValue(Direction);
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
	public String getDisplayDocTitleType() {
		COSObject DisplayDocTitle = getDisplayDocTitleValue();
		return getObjectType(DisplayDocTitle);
	}

	@Override
	public Boolean getDisplayDocTitleHasTypeBoolean() {
		COSObject DisplayDocTitle = getDisplayDocTitleValue();
		return getHasTypeBoolean(DisplayDocTitle);
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
	public String getDuplexType() {
		COSObject Duplex = getDuplexValue();
		return getObjectType(Duplex);
	}

	@Override
	public Boolean getDuplexHasTypeName() {
		COSObject Duplex = getDuplexValue();
		return getHasTypeName(Duplex);
	}

	@Override
	public String getDuplexNameValue() {
		COSObject Duplex = getDuplexValue();
		return getNameValue(Duplex);
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
	public String getEnforceType() {
		COSObject Enforce = getEnforceValue();
		return getObjectType(Enforce);
	}

	@Override
	public Boolean getEnforceHasTypeArray() {
		COSObject Enforce = getEnforceValue();
		return getHasTypeArray(Enforce);
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
	public String getFitWindowType() {
		COSObject FitWindow = getFitWindowValue();
		return getObjectType(FitWindow);
	}

	@Override
	public Boolean getFitWindowHasTypeBoolean() {
		COSObject FitWindow = getFitWindowValue();
		return getHasTypeBoolean(FitWindow);
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
	public String getHideMenubarType() {
		COSObject HideMenubar = getHideMenubarValue();
		return getObjectType(HideMenubar);
	}

	@Override
	public Boolean getHideMenubarHasTypeBoolean() {
		COSObject HideMenubar = getHideMenubarValue();
		return getHasTypeBoolean(HideMenubar);
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
	public String getHideToolbarType() {
		COSObject HideToolbar = getHideToolbarValue();
		return getObjectType(HideToolbar);
	}

	@Override
	public Boolean getHideToolbarHasTypeBoolean() {
		COSObject HideToolbar = getHideToolbarValue();
		return getHasTypeBoolean(HideToolbar);
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
	public String getHideWindowUIType() {
		COSObject HideWindowUI = getHideWindowUIValue();
		return getObjectType(HideWindowUI);
	}

	@Override
	public Boolean getHideWindowUIHasTypeBoolean() {
		COSObject HideWindowUI = getHideWindowUIValue();
		return getHasTypeBoolean(HideWindowUI);
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
	public String getNonFullScreenPageModeType() {
		COSObject NonFullScreenPageMode = getNonFullScreenPageModeValue();
		return getObjectType(NonFullScreenPageMode);
	}

	@Override
	public Boolean getNonFullScreenPageModeHasTypeName() {
		COSObject NonFullScreenPageMode = getNonFullScreenPageModeValue();
		return getHasTypeName(NonFullScreenPageMode);
	}

	@Override
	public String getNonFullScreenPageModeNameValue() {
		COSObject NonFullScreenPageMode = getNonFullScreenPageModeValue();
		return getNameValue(NonFullScreenPageMode);
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
	public String getNumCopiesType() {
		COSObject NumCopies = getNumCopiesValue();
		return getObjectType(NumCopies);
	}

	@Override
	public Boolean getNumCopiesHasTypeInteger() {
		COSObject NumCopies = getNumCopiesValue();
		return getHasTypeInteger(NumCopies);
	}

	@Override
	public Long getNumCopiesIntegerValue() {
		COSObject NumCopies = getNumCopiesValue();
		return getIntegerValue(NumCopies);
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
	public String getPickTrayByPDFSizeType() {
		COSObject PickTrayByPDFSize = getPickTrayByPDFSizeValue();
		return getObjectType(PickTrayByPDFSize);
	}

	@Override
	public Boolean getPickTrayByPDFSizeHasTypeBoolean() {
		COSObject PickTrayByPDFSize = getPickTrayByPDFSizeValue();
		return getHasTypeBoolean(PickTrayByPDFSize);
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
	public String getPrintAreaType() {
		COSObject PrintArea = getPrintAreaValue();
		return getObjectType(PrintArea);
	}

	@Override
	public Boolean getPrintAreaHasTypeName() {
		COSObject PrintArea = getPrintAreaValue();
		return getHasTypeName(PrintArea);
	}

	@Override
	public String getPrintAreaNameValue() {
		COSObject PrintArea = getPrintAreaValue();
		return getNameValue(PrintArea);
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
	public String getPrintClipType() {
		COSObject PrintClip = getPrintClipValue();
		return getObjectType(PrintClip);
	}

	@Override
	public Boolean getPrintClipHasTypeName() {
		COSObject PrintClip = getPrintClipValue();
		return getHasTypeName(PrintClip);
	}

	@Override
	public String getPrintClipNameValue() {
		COSObject PrintClip = getPrintClipValue();
		return getNameValue(PrintClip);
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
	public String getPrintPageRangeType() {
		COSObject PrintPageRange = getPrintPageRangeValue();
		return getObjectType(PrintPageRange);
	}

	@Override
	public Boolean getPrintPageRangeHasTypeArray() {
		COSObject PrintPageRange = getPrintPageRangeValue();
		return getHasTypeArray(PrintPageRange);
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
	public String getPrintScalingType() {
		COSObject PrintScaling = getPrintScalingValue();
		return getObjectType(PrintScaling);
	}

	@Override
	public Boolean getPrintScalingHasTypeName() {
		COSObject PrintScaling = getPrintScalingValue();
		return getHasTypeName(PrintScaling);
	}

	@Override
	public String getPrintScalingNameValue() {
		COSObject PrintScaling = getPrintScalingValue();
		return getNameValue(PrintScaling);
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
	public String getViewAreaType() {
		COSObject ViewArea = getViewAreaValue();
		return getObjectType(ViewArea);
	}

	@Override
	public Boolean getViewAreaHasTypeName() {
		COSObject ViewArea = getViewAreaValue();
		return getHasTypeName(ViewArea);
	}

	@Override
	public String getViewAreaNameValue() {
		COSObject ViewArea = getViewAreaValue();
		return getNameValue(ViewArea);
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
	public String getViewClipType() {
		COSObject ViewClip = getViewClipValue();
		return getObjectType(ViewClip);
	}

	@Override
	public Boolean getViewClipHasTypeName() {
		COSObject ViewClip = getViewClipValue();
		return getHasTypeName(ViewClip);
	}

	@Override
	public String getViewClipNameValue() {
		COSObject ViewClip = getViewClipValue();
		return getNameValue(ViewClip);
	}

	public COSObject gettrailerCatalogValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		return Root;
	}

	@Override
	public String gettrailerCatalogPageModeNameValue() {
		COSObject trailerCatalog = gettrailerCatalogValue();
		if (trailerCatalog == null || !trailerCatalog.getType().isDictionaryBased()) {
			return null;
		}
		return new GFACatalog(trailerCatalog.getDirectBase(), null, null).getPageModeNameValue();
	}

}
