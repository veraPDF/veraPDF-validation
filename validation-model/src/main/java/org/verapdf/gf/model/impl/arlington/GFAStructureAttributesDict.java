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

public class GFAStructureAttributesDict extends GFAObject implements AStructureAttributesDict {

	public GFAStructureAttributesDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AStructureAttributesDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BorderThickness":
				return getBorderThickness();
			case "NS":
				return getNS();
			case "Headers":
				return getHeaders();
			case "TextDecorationColor":
				return getTextDecorationColor();
			case "BorderStyle":
				return getBorderStyle();
			case "ColumnGap":
				return getColumnGap();
			case "Color":
				return getColor();
			case "ColumnWidths":
				return getColumnWidths();
			case "BorderColor":
				return getBorderColor();
			case "P":
				return getP();
			case "Contents":
				return getContents();
			case "TPadding":
				return getTPadding();
			case "Padding":
				return getPadding();
			case "TBorderStyle":
				return getTBorderStyle();
			case "BackgroundColor":
				return getBackgroundColor();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_4BorderThicknessNumbers> getBorderThickness() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBorderThickness1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4BorderThicknessNumbers> getBorderThickness1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderThickness"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4BorderThicknessNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4BorderThicknessNumbers((COSArray)object.getDirectBase(), this.baseObject, "BorderThickness"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANamespace> getNS() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getNS2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANamespace> getNS2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NS"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANamespace> list = new ArrayList<>(1);
			list.add(new GFANamespace((COSDictionary)object.getDirectBase(), this.baseObject, "NS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsByte> getHeaders() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getHeaders1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getHeaders1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Headers"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "Headers"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3RGBNumbers> getTextDecorationColor() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTextDecorationColor1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getTextDecorationColor1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextDecorationColor"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "TextDecorationColor"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4BorderStyleNames> getBorderStyle() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBorderStyle1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4BorderStyleNames> getBorderStyle1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderStyle"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4BorderStyleNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4BorderStyleNames((COSArray)object.getDirectBase(), this.baseObject, "BorderStyle"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getColumnGap() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColumnGap1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getColumnGap1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnGap"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "ColumnGap"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3RGBNumbers> getColor() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColor1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getColor1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Color"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "Color"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getColumnWidths() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColumnWidths1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getColumnWidths1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnWidths"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "ColumnWidths"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getBorderColor() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBorderColor1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getBorderColor1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderColor"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getBorderColorArray1_5(object.getDirectBase(), "BorderColor");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getBorderColorArray1_5(COSBase base, String keyName) {
		switch (base.size()) {
			case 4:
				return new GFAArrayOf_4BorderColorArrays(base, this.baseObject, keyName);
			case 3:
				return new GFAArrayOf_3RGBNumbers(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfUserProperty> getP() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfUserProperty> getP1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfUserProperty> list = new ArrayList<>(1);
			list.add(new GFAArrayOfUserProperty((COSArray)object.getDirectBase(), this.baseObject, "P"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsText> getContents() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getContents1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getContents1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "Contents"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4Integers> getTPadding() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTPadding1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4Integers> getTPadding1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TPadding"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4Integers((COSArray)object.getDirectBase(), this.baseObject, "TPadding"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4Integers> getPadding() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPadding1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4Integers> getPadding1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Padding"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4Integers((COSArray)object.getDirectBase(), this.baseObject, "Padding"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4BorderStyleNames> getTBorderStyle() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTBorderStyle1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4BorderStyleNames> getTBorderStyle1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TBorderStyle"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4BorderStyleNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4BorderStyleNames((COSArray)object.getDirectBase(), this.baseObject, "TBorderStyle"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3RGBNumbers> getBackgroundColor() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBackgroundColor1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getBackgroundColor1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BackgroundColor"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "BackgroundColor"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsScope() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Scope"));
	}

	@Override
	public Boolean getScopeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scope"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getScopeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scope"));
		if (object == null || object.empty()) {
			return getScopeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getScopeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsPlacement() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Placement"));
	}

	@Override
	public Boolean getPlacementHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Placement"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPlacementNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Placement"));
		if (object == null || object.empty()) {
			return getPlacementNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPlacementNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsBorderStyle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BorderStyle"));
	}

	@Override
	public Boolean getBorderStyleHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderStyle"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getBorderStyleHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderStyle"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public String getBorderStyleNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderStyle"));
		if (object == null || object.empty()) {
			return getBorderStyleNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getBorderStyleNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "None";
		}
		return null;
	}

	@Override
	public Boolean getcontainsHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Height"));
	}

	@Override
	public Boolean getHeightHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getHeightHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsWritingMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WritingMode"));
	}

	@Override
	public Boolean getWritingModeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WritingMode"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getWritingModeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WritingMode"));
		if (object == null || object.empty()) {
			return getWritingModeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getWritingModeNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "LrTb";
		}
		return null;
	}

	@Override
	public Boolean getcontainsBaselineShift() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaselineShift"));
	}

	@Override
	public Boolean getBaselineShiftHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaselineShift"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	@Override
	public Boolean getOHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getONameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null || object.empty()) {
			return getONameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getONameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BBox"));
	}

	@Override
	public Boolean getBBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BBox"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean getcontainsContinuedForm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ContinuedForm"));
	}

	@Override
	public Boolean getContinuedFormHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ContinuedForm"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsContents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Contents"));
	}

	@Override
	public Boolean getContentsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getContentsHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsSpaceAfter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpaceAfter"));
	}

	@Override
	public Boolean getSpaceAfterHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpaceAfter"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsColumnCount() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColumnCount"));
	}

	@Override
	public Boolean getColumnCountHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnCount"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsRole() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Role"));
	}

	@Override
	public Boolean getRoleHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Role"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getRoleNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Role"));
		if (object == null || object.empty()) {
			return getRoleNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getRoleNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDesc() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Desc"));
	}

	@Override
	public Boolean getDescHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Desc"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTextDecorationThickness() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextDecorationThickness"));
	}

	@Override
	public Boolean getTextDecorationThicknessHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextDecorationThickness"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsColumnGap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColumnGap"));
	}

	@Override
	public Boolean getColumnGapHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnGap"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getColumnGapHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnGap"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsInlineAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("InlineAlign"));
	}

	@Override
	public Boolean getInlineAlignHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("InlineAlign"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getInlineAlignNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("InlineAlign"));
		if (object == null || object.empty()) {
			return getInlineAlignNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getInlineAlignNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Start";
		}
		return null;
	}

	@Override
	public Boolean getcontainsColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Color"));
	}

	@Override
	public Boolean getColorHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Color"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsBackgroundColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BackgroundColor"));
	}

	@Override
	public Boolean getBackgroundColorHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BackgroundColor"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsColSpan() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColSpan"));
	}

	@Override
	public Boolean getColSpanHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColSpan"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsHeaders() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Headers"));
	}

	@Override
	public Boolean getHeadersHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Headers"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsColumnWidths() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColumnWidths"));
	}

	@Override
	public Boolean getColumnWidthsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnWidths"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getColumnWidthsHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnWidths"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsRowSpan() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RowSpan"));
	}

	@Override
	public Boolean getRowSpanHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RowSpan"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			return getSubtypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSubtypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsListNumbering() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ListNumbering"));
	}

	@Override
	public Boolean getListNumberingHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ListNumbering"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getListNumberingNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ListNumbering"));
		if (object == null || object.empty()) {
			return getListNumberingNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getListNumberingNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "None";
		}
		return null;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	@Override
	public Boolean getPHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsShort() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Short"));
	}

	@Override
	public Boolean getShortHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Short"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainschecked() {
		return this.baseObject.knownKey(ASAtom.getASAtom("checked"));
	}

	@Override
	public Boolean getcheckedHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("checked"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getcheckedNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("checked"));
		if (object == null || object.empty()) {
			return getcheckedNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getcheckedNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "off";
		}
		return null;
	}

	@Override
	public Boolean getcontainsBlockAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BlockAlign"));
	}

	@Override
	public Boolean getBlockAlignHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BlockAlign"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBlockAlignNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BlockAlign"));
		if (object == null || object.empty()) {
			return getBlockAlignNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getBlockAlignNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Before";
		}
		return null;
	}

	@Override
	public Boolean getcontainsTBorderStyle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TBorderStyle"));
	}

	@Override
	public Boolean getTBorderStyleHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TBorderStyle"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getTBorderStyleHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TBorderStyle"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public String getTBorderStyleNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TBorderStyle"));
		if (object == null || object.empty()) {
			return getTBorderStyleNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTBorderStyleNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "None";
		}
		return null;
	}

	@Override
	public Boolean getcontainsTextAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextAlign"));
	}

	@Override
	public Boolean getTextAlignHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextAlign"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTextAlignNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextAlign"));
		if (object == null || object.empty()) {
			return getTextAlignNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTextAlignNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Start";
		}
		return null;
	}

	@Override
	public Boolean getcontainsContinuedList() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ContinuedList"));
	}

	@Override
	public Boolean getContinuedListHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ContinuedList"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsTextDecorationColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextDecorationColor"));
	}

	@Override
	public Boolean getTextDecorationColorHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextDecorationColor"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Width"));
	}

	@Override
	public Boolean getWidthHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getWidthHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsSummary() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Summary"));
	}

	@Override
	public Boolean getSummaryHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Summary"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsStartIndent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StartIndent"));
	}

	@Override
	public Boolean getStartIndentHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StartIndent"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsSpaceBefore() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpaceBefore"));
	}

	@Override
	public Boolean getSpaceBeforeHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpaceBefore"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTextDecorationType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextDecorationType"));
	}

	@Override
	public Boolean getTextDecorationTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextDecorationType"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTextDecorationTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextDecorationType"));
		if (object == null || object.empty()) {
			return getTextDecorationTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTextDecorationTypeNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "None";
		}
		return null;
	}

	@Override
	public Boolean getcontainsTextPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextPosition"));
	}

	@Override
	public Boolean getTextPositionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextPosition"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTextPositionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextPosition"));
		if (object == null || object.empty()) {
			return getTextPositionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTextPositionNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return "Normal";
		}
		return null;
	}

	@Override
	public Boolean getcontainsNS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NS"));
	}

	@Override
	public Boolean getisNSIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NS"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getNSHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsGlyphOrientationVertical() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GlyphOrientationVertical"));
	}

	@Override
	public Boolean getGlyphOrientationVerticalHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GlyphOrientationVertical"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getGlyphOrientationVerticalHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GlyphOrientationVertical"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public String getGlyphOrientationVerticalNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GlyphOrientationVertical"));
		if (object == null || object.empty()) {
			return getGlyphOrientationVerticalNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getGlyphOrientationVerticalNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Auto";
		}
		return null;
	}

	@Override
	public Long getGlyphOrientationVerticalIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GlyphOrientationVertical"));
		if (object == null || object.empty()) {
			return getGlyphOrientationVerticalIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getGlyphOrientationVerticalIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsLineHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LineHeight"));
	}

	@Override
	public Boolean getLineHeightHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LineHeight"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getLineHeightHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LineHeight"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public String getLineHeightNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LineHeight"));
		if (object == null || object.empty()) {
			return getLineHeightNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getLineHeightNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Normal";
		}
		return null;
	}

	@Override
	public Boolean getcontainsChecked() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Checked"));
	}

	@Override
	public Boolean getCheckedHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Checked"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getCheckedNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Checked"));
		if (object == null || object.empty()) {
			return getCheckedNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getCheckedNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "off";
		}
		return null;
	}

	@Override
	public Boolean getcontainsRubyAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RubyAlign"));
	}

	@Override
	public Boolean getRubyAlignHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RubyAlign"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getRubyAlignNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RubyAlign"));
		if (object == null || object.empty()) {
			return getRubyAlignNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getRubyAlignNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Distribute";
		}
		return null;
	}

	@Override
	public Boolean getcontainsTextIndent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextIndent"));
	}

	@Override
	public Boolean getTextIndentHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextIndent"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsBorderColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BorderColor"));
	}

	@Override
	public Boolean getBorderColorHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderColor"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPadding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Padding"));
	}

	@Override
	public Boolean getPaddingHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Padding"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getPaddingHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Padding"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsRubyPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RubyPosition"));
	}

	@Override
	public Boolean getRubyPositionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RubyPosition"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getRubyPositionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RubyPosition"));
		if (object == null || object.empty()) {
			return getRubyPositionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getRubyPositionNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Before";
		}
		return null;
	}

	@Override
	public Boolean getcontainsBorderThickness() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BorderThickness"));
	}

	@Override
	public Boolean getBorderThicknessHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderThickness"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getBorderThicknessHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderThickness"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTPadding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TPadding"));
	}

	@Override
	public Boolean getTPaddingHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TPadding"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getTPaddingHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TPadding"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsEndIndent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EndIndent"));
	}

	@Override
	public Boolean getEndIndentHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EndIndent"));
		return object != null && object.getType().isNumber();
	}

}
