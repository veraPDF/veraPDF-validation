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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Enforce"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintPageRange"));
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

	@Override
	public Boolean getCenterWindowHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CenterWindow"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsDirection() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Direction"));
	}

	@Override
	public Boolean getDirectionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Direction"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDirectionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Direction"));
		if (object == null || object.empty()) {
			return getDirectionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getDirectionNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "L2R";
		}
		return null;
	}

	@Override
	public Boolean getcontainsDisplayDocTitle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DisplayDocTitle"));
	}

	@Override
	public Boolean getDisplayDocTitleHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DisplayDocTitle"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsDuplex() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Duplex"));
	}

	@Override
	public Boolean getDuplexHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duplex"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDuplexNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duplex"));
		if (object == null || object.empty()) {
			return getDuplexNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getDuplexNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsEnforce() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Enforce"));
	}

	@Override
	public Boolean getEnforceHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Enforce"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsFitWindow() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FitWindow"));
	}

	@Override
	public Boolean getFitWindowHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FitWindow"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsHideMenubar() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HideMenubar"));
	}

	@Override
	public Boolean getHideMenubarHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideMenubar"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsHideToolbar() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HideToolbar"));
	}

	@Override
	public Boolean getHideToolbarHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideToolbar"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsHideWindowUI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HideWindowUI"));
	}

	@Override
	public Boolean getHideWindowUIHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideWindowUI"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsNonFullScreenPageMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NonFullScreenPageMode"));
	}

	@Override
	public Boolean getNonFullScreenPageModeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NonFullScreenPageMode"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getNonFullScreenPageModeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NonFullScreenPageMode"));
		if (object == null || object.empty()) {
			return getNonFullScreenPageModeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getNonFullScreenPageModeNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "UseNone";
		}
		return null;
	}

	@Override
	public Boolean getcontainsNumCopies() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NumCopies"));
	}

	@Override
	public Boolean getNumCopiesHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NumCopies"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getNumCopiesIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NumCopies"));
		if (object == null || object.empty()) {
			return getNumCopiesIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getNumCopiesIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsPickTrayByPDFSize() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PickTrayByPDFSize"));
	}

	@Override
	public Boolean getPickTrayByPDFSizeHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PickTrayByPDFSize"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsPrintArea() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintArea"));
	}

	@Override
	public Boolean getPrintAreaHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintArea"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPrintAreaNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintArea"));
		if (object == null || object.empty()) {
			return getPrintAreaNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPrintAreaNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "CropBox";
		}
		return null;
	}

	@Override
	public Boolean getcontainsPrintClip() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintClip"));
	}

	@Override
	public Boolean getPrintClipHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintClip"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPrintClipNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintClip"));
		if (object == null || object.empty()) {
			return getPrintClipNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPrintClipNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "CropBox";
		}
		return null;
	}

	@Override
	public Boolean getcontainsPrintPageRange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintPageRange"));
	}

	@Override
	public Boolean getPrintPageRangeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintPageRange"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPrintScaling() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintScaling"));
	}

	@Override
	public Boolean getPrintScalingHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintScaling"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPrintScalingNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintScaling"));
		if (object == null || object.empty()) {
			return getPrintScalingNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPrintScalingNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "AppDefault";
		}
		return null;
	}

	@Override
	public Boolean getcontainsViewArea() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ViewArea"));
	}

	@Override
	public Boolean getViewAreaHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewArea"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getViewAreaNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewArea"));
		if (object == null || object.empty()) {
			return getViewAreaNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getViewAreaNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "CropBox";
		}
		return null;
	}

	@Override
	public Boolean getcontainsViewClip() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ViewClip"));
	}

	@Override
	public Boolean getViewClipHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewClip"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getViewClipNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewClip"));
		if (object == null || object.empty()) {
			return getViewClipNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getViewClipNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "CropBox";
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
}
