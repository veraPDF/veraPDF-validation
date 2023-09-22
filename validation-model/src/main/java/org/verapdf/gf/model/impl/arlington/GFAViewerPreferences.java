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
	public Boolean getCenterWindowHasTypeBoolean() {
		COSObject object = getCenterWindowValue();
		return getHasTypeBoolean(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getDirectionNameValue() {
		COSObject object = getDirectionValue();
		return getNameValue(object);
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
		return getHasTypeBoolean(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getDuplexNameValue() {
		COSObject object = getDuplexValue();
		return getNameValue(object);
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
		return getHasTypeArray(object);
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
		return getHasTypeBoolean(object);
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
		return getHasTypeBoolean(object);
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
		return getHasTypeBoolean(object);
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
		return getHasTypeBoolean(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getNonFullScreenPageModeNameValue() {
		COSObject object = getNonFullScreenPageModeValue();
		return getNameValue(object);
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
		return getHasTypeInteger(object);
	}

	@Override
	public Long getNumCopiesIntegerValue() {
		COSObject object = getNumCopiesValue();
		return getIntegerValue(object);
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
		return getHasTypeBoolean(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getPrintAreaNameValue() {
		COSObject object = getPrintAreaValue();
		return getNameValue(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getPrintClipNameValue() {
		COSObject object = getPrintClipValue();
		return getNameValue(object);
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
		return getHasTypeArray(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getPrintScalingNameValue() {
		COSObject object = getPrintScalingValue();
		return getNameValue(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getViewAreaNameValue() {
		COSObject object = getViewAreaValue();
		return getNameValue(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getViewClipNameValue() {
		COSObject object = getViewClipValue();
		return getNameValue(object);
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