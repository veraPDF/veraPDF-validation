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

public class GFAStructureAttributesDict extends GFAObject implements AStructureAttributesDict {

	public GFAStructureAttributesDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AStructureAttributesDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BackgroundColor":
				return getBackgroundColor();
			case "BorderColor":
				return getBorderColor();
			case "BorderStyle":
				return getBorderStyle();
			case "BorderThickness":
				return getBorderThickness();
			case "Color":
				return getColor();
			case "ColumnGap":
				return getColumnGap();
			case "ColumnWidths":
				return getColumnWidths();
			case "Contents":
				return getContents();
			case "Headers":
				return getHeaders();
			case "NS":
				return getNS();
			case "P":
				return getP();
			case "Padding":
				return getPadding();
			case "TBorderStyle":
				return getTBorderStyle();
			case "TPadding":
				return getTPadding();
			case "TextDecorationColor":
				return getTextDecorationColor();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_3RGBNumbers> getBackgroundColor() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBackgroundColorValue();
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

	private List<org.verapdf.model.baselayer.Object> getBorderColor() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBorderColorValue();
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
			case 3:
				return new GFAArrayOf_3RGBNumbers(base, this.baseObject, keyName);
			case 4:
				return new GFAArrayOf_4BorderColorArrays(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOf_4BorderStyleNames> getBorderStyle() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBorderStyleValue();
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

	private List<AArrayOf_4BorderThicknessNumbers> getBorderThickness() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBorderThicknessValue();
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

	private List<AArrayOf_3RGBNumbers> getColor() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getColorValue();
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

	private List<AArrayOfNumbersGeneral> getColumnGap() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColumnGap1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getColumnGap1_6() {
		COSObject object = getColumnGapValue();
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

	private List<AArrayOfNumbersGeneral> getColumnWidths() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColumnWidths1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getColumnWidths1_6() {
		COSObject object = getColumnWidthsValue();
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

	private List<AArrayOfStringsText> getContents() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getContents1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getContents1_7() {
		COSObject object = getContentsValue();
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

	private List<AArrayOfStringsByte> getHeaders() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getHeadersValue();
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

	private List<ANamespace> getNS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getNS2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANamespace> getNS2_0() {
		COSObject object = getNSValue();
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

	private List<AArrayOfUserProperty> getP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfUserProperty> getP1_6() {
		COSObject object = getPValue();
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

	private List<AArrayOf_4Integers> getPadding() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getPaddingValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getTBorderStyleValue();
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

	private List<AArrayOf_4Integers> getTPadding() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getTPaddingValue();
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

	private List<AArrayOf_3RGBNumbers> getTextDecorationColor() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getTextDecorationColorValue();
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

	@Override
	public Boolean getcontainsBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BBox"));
	}

	public COSObject getBBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BBox"));
		return object;
	}

	@Override
	public String getBBoxType() {
		COSObject BBox = getBBoxValue();
		return getObjectType(BBox);
	}

	@Override
	public Boolean getBBoxHasTypeRectangle() {
		COSObject BBox = getBBoxValue();
		return getHasTypeRectangle(BBox);
	}

	@Override
	public Boolean getcontainsBackgroundColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BackgroundColor"));
	}

	public COSObject getBackgroundColorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BackgroundColor"));
		return object;
	}

	@Override
	public String getBackgroundColorType() {
		COSObject BackgroundColor = getBackgroundColorValue();
		return getObjectType(BackgroundColor);
	}

	@Override
	public Boolean getBackgroundColorHasTypeArray() {
		COSObject BackgroundColor = getBackgroundColorValue();
		return getHasTypeArray(BackgroundColor);
	}

	@Override
	public Boolean getcontainsBaselineShift() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaselineShift"));
	}

	public COSObject getBaselineShiftDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getBaselineShiftValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaselineShift"));
		if (object == null || object.empty()) {
			object = getBaselineShiftDefaultValue();
		}
		return object;
	}

	@Override
	public String getBaselineShiftType() {
		COSObject BaselineShift = getBaselineShiftValue();
		return getObjectType(BaselineShift);
	}

	@Override
	public Boolean getBaselineShiftHasTypeNumber() {
		COSObject BaselineShift = getBaselineShiftValue();
		return getHasTypeNumber(BaselineShift);
	}

	@Override
	public Boolean getcontainsBlockAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BlockAlign"));
	}

	public COSObject getBlockAlignDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Before");
		}
		return null;
	}

	public COSObject getBlockAlignValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BlockAlign"));
		if (object == null || object.empty()) {
			object = getBlockAlignDefaultValue();
		}
		return object;
	}

	@Override
	public String getBlockAlignType() {
		COSObject BlockAlign = getBlockAlignValue();
		return getObjectType(BlockAlign);
	}

	@Override
	public Boolean getBlockAlignHasTypeName() {
		COSObject BlockAlign = getBlockAlignValue();
		return getHasTypeName(BlockAlign);
	}

	@Override
	public String getBlockAlignNameValue() {
		COSObject BlockAlign = getBlockAlignValue();
		return getNameValue(BlockAlign);
	}

	@Override
	public Boolean getcontainsBorderColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BorderColor"));
	}

	public COSObject getBorderColorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderColor"));
		return object;
	}

	@Override
	public String getBorderColorType() {
		COSObject BorderColor = getBorderColorValue();
		return getObjectType(BorderColor);
	}

	@Override
	public Boolean getBorderColorHasTypeArray() {
		COSObject BorderColor = getBorderColorValue();
		return getHasTypeArray(BorderColor);
	}

	@Override
	public Boolean getcontainsBorderStyle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BorderStyle"));
	}

	public COSObject getBorderStyleDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getBorderStyleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderStyle"));
		if (object == null || object.empty()) {
			object = getBorderStyleDefaultValue();
		}
		return object;
	}

	@Override
	public String getBorderStyleType() {
		COSObject BorderStyle = getBorderStyleValue();
		return getObjectType(BorderStyle);
	}

	@Override
	public Boolean getBorderStyleHasTypeArray() {
		COSObject BorderStyle = getBorderStyleValue();
		return getHasTypeArray(BorderStyle);
	}

	@Override
	public Boolean getBorderStyleHasTypeName() {
		COSObject BorderStyle = getBorderStyleValue();
		return getHasTypeName(BorderStyle);
	}

	@Override
	public String getBorderStyleNameValue() {
		COSObject BorderStyle = getBorderStyleValue();
		return getNameValue(BorderStyle);
	}

	@Override
	public Boolean getcontainsBorderThickness() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BorderThickness"));
	}

	public COSObject getBorderThicknessDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getBorderThicknessValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BorderThickness"));
		if (object == null || object.empty()) {
			object = getBorderThicknessDefaultValue();
		}
		return object;
	}

	@Override
	public String getBorderThicknessType() {
		COSObject BorderThickness = getBorderThicknessValue();
		return getObjectType(BorderThickness);
	}

	@Override
	public Boolean getBorderThicknessHasTypeArray() {
		COSObject BorderThickness = getBorderThicknessValue();
		return getHasTypeArray(BorderThickness);
	}

	@Override
	public Boolean getBorderThicknessHasTypeNumber() {
		COSObject BorderThickness = getBorderThicknessValue();
		return getHasTypeNumber(BorderThickness);
	}

	@Override
	public Boolean getcontainsChecked() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Checked"));
	}

	public COSObject getCheckedDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("off");
		}
		return null;
	}

	public COSObject getCheckedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Checked"));
		if (object == null || object.empty()) {
			object = getCheckedDefaultValue();
		}
		return object;
	}

	@Override
	public String getCheckedType() {
		COSObject Checked = getCheckedValue();
		return getObjectType(Checked);
	}

	@Override
	public Boolean getCheckedHasTypeName() {
		COSObject Checked = getCheckedValue();
		return getHasTypeName(Checked);
	}

	@Override
	public String getCheckedNameValue() {
		COSObject Checked = getCheckedValue();
		return getNameValue(Checked);
	}

	@Override
	public Boolean getcontainsColSpan() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColSpan"));
	}

	public COSObject getColSpanDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
	}

	public COSObject getColSpanValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColSpan"));
		if (object == null || object.empty()) {
			object = getColSpanDefaultValue();
		}
		return object;
	}

	@Override
	public String getColSpanType() {
		COSObject ColSpan = getColSpanValue();
		return getObjectType(ColSpan);
	}

	@Override
	public Boolean getColSpanHasTypeInteger() {
		COSObject ColSpan = getColSpanValue();
		return getHasTypeInteger(ColSpan);
	}

	@Override
	public Boolean getcontainsColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Color"));
	}

	public COSObject getColorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Color"));
		return object;
	}

	@Override
	public String getColorType() {
		COSObject Color = getColorValue();
		return getObjectType(Color);
	}

	@Override
	public Boolean getColorHasTypeArray() {
		COSObject Color = getColorValue();
		return getHasTypeArray(Color);
	}

	@Override
	public Boolean getcontainsColumnCount() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColumnCount"));
	}

	public COSObject getColumnCountDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
	}

	public COSObject getColumnCountValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnCount"));
		if (object == null || object.empty()) {
			object = getColumnCountDefaultValue();
		}
		return object;
	}

	@Override
	public String getColumnCountType() {
		COSObject ColumnCount = getColumnCountValue();
		return getObjectType(ColumnCount);
	}

	@Override
	public Boolean getColumnCountHasTypeInteger() {
		COSObject ColumnCount = getColumnCountValue();
		return getHasTypeInteger(ColumnCount);
	}

	@Override
	public Boolean getcontainsColumnGap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColumnGap"));
	}

	public COSObject getColumnGapValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnGap"));
		return object;
	}

	@Override
	public String getColumnGapType() {
		COSObject ColumnGap = getColumnGapValue();
		return getObjectType(ColumnGap);
	}

	@Override
	public Boolean getColumnGapHasTypeArray() {
		COSObject ColumnGap = getColumnGapValue();
		return getHasTypeArray(ColumnGap);
	}

	@Override
	public Boolean getColumnGapHasTypeNumber() {
		COSObject ColumnGap = getColumnGapValue();
		return getHasTypeNumber(ColumnGap);
	}

	@Override
	public Boolean getcontainsColumnWidths() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColumnWidths"));
	}

	public COSObject getColumnWidthsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColumnWidths"));
		return object;
	}

	@Override
	public String getColumnWidthsType() {
		COSObject ColumnWidths = getColumnWidthsValue();
		return getObjectType(ColumnWidths);
	}

	@Override
	public Boolean getColumnWidthsHasTypeArray() {
		COSObject ColumnWidths = getColumnWidthsValue();
		return getHasTypeArray(ColumnWidths);
	}

	@Override
	public Boolean getColumnWidthsHasTypeNumber() {
		COSObject ColumnWidths = getColumnWidthsValue();
		return getHasTypeNumber(ColumnWidths);
	}

	@Override
	public Boolean getcontainsContents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Contents"));
	}

	public COSObject getContentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object;
	}

	@Override
	public String getContentsType() {
		COSObject Contents = getContentsValue();
		return getObjectType(Contents);
	}

	@Override
	public Boolean getContentsHasTypeArray() {
		COSObject Contents = getContentsValue();
		return getHasTypeArray(Contents);
	}

	@Override
	public Boolean getContentsHasTypeStringText() {
		COSObject Contents = getContentsValue();
		return getHasTypeStringText(Contents);
	}

	@Override
	public Boolean getcontainsContinuedForm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ContinuedForm"));
	}

	public COSObject getContinuedFormValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ContinuedForm"));
		return object;
	}

	@Override
	public String getContinuedFormType() {
		COSObject ContinuedForm = getContinuedFormValue();
		return getObjectType(ContinuedForm);
	}

	@Override
	public Boolean getContinuedFormHasTypeStringByte() {
		COSObject ContinuedForm = getContinuedFormValue();
		return getHasTypeStringByte(ContinuedForm);
	}

	@Override
	public Boolean getcontainsContinuedList() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ContinuedList"));
	}

	public COSObject getContinuedListDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getContinuedListValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ContinuedList"));
		if (object == null || object.empty()) {
			object = getContinuedListDefaultValue();
		}
		return object;
	}

	@Override
	public String getContinuedListType() {
		COSObject ContinuedList = getContinuedListValue();
		return getObjectType(ContinuedList);
	}

	@Override
	public Boolean getContinuedListHasTypeBoolean() {
		COSObject ContinuedList = getContinuedListValue();
		return getHasTypeBoolean(ContinuedList);
	}

	@Override
	public Boolean getcontainsDesc() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Desc"));
	}

	public COSObject getDescValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Desc"));
		return object;
	}

	@Override
	public String getDescType() {
		COSObject Desc = getDescValue();
		return getObjectType(Desc);
	}

	@Override
	public Boolean getDescHasTypeStringText() {
		COSObject Desc = getDescValue();
		return getHasTypeStringText(Desc);
	}

	@Override
	public Boolean getcontainsEndIndent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EndIndent"));
	}

	public COSObject getEndIndentDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getEndIndentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EndIndent"));
		if (object == null || object.empty()) {
			object = getEndIndentDefaultValue();
		}
		return object;
	}

	@Override
	public String getEndIndentType() {
		COSObject EndIndent = getEndIndentValue();
		return getObjectType(EndIndent);
	}

	@Override
	public Boolean getEndIndentHasTypeNumber() {
		COSObject EndIndent = getEndIndentValue();
		return getHasTypeNumber(EndIndent);
	}

	@Override
	public Boolean getcontainsGlyphOrientationVertical() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GlyphOrientationVertical"));
	}

	public COSObject getGlyphOrientationVerticalDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Auto");
		}
		return null;
	}

	public COSObject getGlyphOrientationVerticalValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GlyphOrientationVertical"));
		if (object == null || object.empty()) {
			object = getGlyphOrientationVerticalDefaultValue();
		}
		return object;
	}

	@Override
	public String getGlyphOrientationVerticalType() {
		COSObject GlyphOrientationVertical = getGlyphOrientationVerticalValue();
		return getObjectType(GlyphOrientationVertical);
	}

	@Override
	public Boolean getGlyphOrientationVerticalHasTypeInteger() {
		COSObject GlyphOrientationVertical = getGlyphOrientationVerticalValue();
		return getHasTypeInteger(GlyphOrientationVertical);
	}

	@Override
	public Boolean getGlyphOrientationVerticalHasTypeName() {
		COSObject GlyphOrientationVertical = getGlyphOrientationVerticalValue();
		return getHasTypeName(GlyphOrientationVertical);
	}

	@Override
	public Long getGlyphOrientationVerticalIntegerValue() {
		COSObject GlyphOrientationVertical = getGlyphOrientationVerticalValue();
		return getIntegerValue(GlyphOrientationVertical);
	}

	@Override
	public String getGlyphOrientationVerticalNameValue() {
		COSObject GlyphOrientationVertical = getGlyphOrientationVerticalValue();
		return getNameValue(GlyphOrientationVertical);
	}

	@Override
	public Boolean getcontainsHeaders() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Headers"));
	}

	public COSObject getHeadersValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Headers"));
		return object;
	}

	@Override
	public String getHeadersType() {
		COSObject Headers = getHeadersValue();
		return getObjectType(Headers);
	}

	@Override
	public Boolean getHeadersHasTypeArray() {
		COSObject Headers = getHeadersValue();
		return getHasTypeArray(Headers);
	}

	@Override
	public Boolean getcontainsHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Height"));
	}

	public COSObject getHeightDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Auto");
		}
		return null;
	}

	public COSObject getHeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		if (object == null || object.empty()) {
			object = getHeightDefaultValue();
		}
		return object;
	}

	@Override
	public String getHeightType() {
		COSObject Height = getHeightValue();
		return getObjectType(Height);
	}

	@Override
	public Boolean getHeightHasTypeName() {
		COSObject Height = getHeightValue();
		return getHasTypeName(Height);
	}

	@Override
	public Boolean getHeightHasTypeNumber() {
		COSObject Height = getHeightValue();
		return getHasTypeNumber(Height);
	}

	@Override
	public Boolean getcontainsInlineAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("InlineAlign"));
	}

	public COSObject getInlineAlignDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Start");
		}
		return null;
	}

	public COSObject getInlineAlignValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("InlineAlign"));
		if (object == null || object.empty()) {
			object = getInlineAlignDefaultValue();
		}
		return object;
	}

	@Override
	public String getInlineAlignType() {
		COSObject InlineAlign = getInlineAlignValue();
		return getObjectType(InlineAlign);
	}

	@Override
	public Boolean getInlineAlignHasTypeName() {
		COSObject InlineAlign = getInlineAlignValue();
		return getHasTypeName(InlineAlign);
	}

	@Override
	public String getInlineAlignNameValue() {
		COSObject InlineAlign = getInlineAlignValue();
		return getNameValue(InlineAlign);
	}

	@Override
	public Boolean getcontainsLineHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LineHeight"));
	}

	public COSObject getLineHeightDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Normal");
		}
		return null;
	}

	public COSObject getLineHeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LineHeight"));
		if (object == null || object.empty()) {
			object = getLineHeightDefaultValue();
		}
		return object;
	}

	@Override
	public String getLineHeightType() {
		COSObject LineHeight = getLineHeightValue();
		return getObjectType(LineHeight);
	}

	@Override
	public Boolean getLineHeightHasTypeName() {
		COSObject LineHeight = getLineHeightValue();
		return getHasTypeName(LineHeight);
	}

	@Override
	public Boolean getLineHeightHasTypeNumber() {
		COSObject LineHeight = getLineHeightValue();
		return getHasTypeNumber(LineHeight);
	}

	@Override
	public String getLineHeightNameValue() {
		COSObject LineHeight = getLineHeightValue();
		return getNameValue(LineHeight);
	}

	@Override
	public Boolean getcontainsListNumbering() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ListNumbering"));
	}

	public COSObject getListNumberingDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getListNumberingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ListNumbering"));
		if (object == null || object.empty()) {
			object = getListNumberingDefaultValue();
		}
		return object;
	}

	@Override
	public String getListNumberingType() {
		COSObject ListNumbering = getListNumberingValue();
		return getObjectType(ListNumbering);
	}

	@Override
	public Boolean getListNumberingHasTypeName() {
		COSObject ListNumbering = getListNumberingValue();
		return getHasTypeName(ListNumbering);
	}

	@Override
	public String getListNumberingNameValue() {
		COSObject ListNumbering = getListNumberingValue();
		return getNameValue(ListNumbering);
	}

	@Override
	public Boolean getcontainsNS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NS"));
	}

	public COSObject getNSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NS"));
		return object;
	}

	@Override
	public Boolean getisNSIndirect() {
		COSObject NS = getNSValue();
		return getisIndirect(NS);
	}

	@Override
	public String getNSType() {
		COSObject NS = getNSValue();
		return getObjectType(NS);
	}

	@Override
	public Boolean getNSHasTypeDictionary() {
		COSObject NS = getNSValue();
		return getHasTypeDictionary(NS);
	}

	@Override
	public Boolean getcontainsNoteType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NoteType"));
	}

	public COSObject getNoteTypeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return gethasExtensionWTPDF() ? COSName.construct("None") : null;
		}
		return null;
	}

	public COSObject getNoteTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NoteType"));
		if (object == null || object.empty()) {
			object = getNoteTypeDefaultValue();
		}
		return object;
	}

	@Override
	public String getNoteTypeType() {
		COSObject NoteType = getNoteTypeValue();
		return getObjectType(NoteType);
	}

	@Override
	public Boolean getNoteTypeHasTypeName() {
		COSObject NoteType = getNoteTypeValue();
		return getHasTypeName(NoteType);
	}

	@Override
	public String getNoteTypeNameValue() {
		COSObject NoteType = getNoteTypeValue();
		return getNameValue(NoteType);
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object;
	}

	@Override
	public String getOType() {
		COSObject O = getOValue();
		return getObjectType(O);
	}

	@Override
	public Boolean getOHasTypeName() {
		COSObject O = getOValue();
		return getHasTypeName(O);
	}

	@Override
	public String getONameValue() {
		COSObject O = getOValue();
		return getNameValue(O);
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object;
	}

	@Override
	public String getPType() {
		COSObject P = getPValue();
		return getObjectType(P);
	}

	@Override
	public Boolean getPHasTypeArray() {
		COSObject P = getPValue();
		return getHasTypeArray(P);
	}

	@Override
	public Boolean getcontainsPadding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Padding"));
	}

	public COSObject getPaddingDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getPaddingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Padding"));
		if (object == null || object.empty()) {
			object = getPaddingDefaultValue();
		}
		return object;
	}

	@Override
	public String getPaddingType() {
		COSObject Padding = getPaddingValue();
		return getObjectType(Padding);
	}

	@Override
	public Boolean getPaddingHasTypeArray() {
		COSObject Padding = getPaddingValue();
		return getHasTypeArray(Padding);
	}

	@Override
	public Boolean getPaddingHasTypeNumber() {
		COSObject Padding = getPaddingValue();
		return getHasTypeNumber(Padding);
	}

	@Override
	public Boolean getcontainsPlacement() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Placement"));
	}

	public COSObject getPlacementValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Placement"));
		return object;
	}

	@Override
	public String getPlacementType() {
		COSObject Placement = getPlacementValue();
		return getObjectType(Placement);
	}

	@Override
	public Boolean getPlacementHasTypeName() {
		COSObject Placement = getPlacementValue();
		return getHasTypeName(Placement);
	}

	@Override
	public String getPlacementNameValue() {
		COSObject Placement = getPlacementValue();
		return getNameValue(Placement);
	}

	@Override
	public Boolean getcontainsRole() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Role"));
	}

	public COSObject getRoleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Role"));
		return object;
	}

	@Override
	public String getRoleType() {
		COSObject Role = getRoleValue();
		return getObjectType(Role);
	}

	@Override
	public Boolean getRoleHasTypeName() {
		COSObject Role = getRoleValue();
		return getHasTypeName(Role);
	}

	@Override
	public String getRoleNameValue() {
		COSObject Role = getRoleValue();
		return getNameValue(Role);
	}

	@Override
	public Boolean getcontainsRowSpan() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RowSpan"));
	}

	public COSObject getRowSpanDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
	}

	public COSObject getRowSpanValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RowSpan"));
		if (object == null || object.empty()) {
			object = getRowSpanDefaultValue();
		}
		return object;
	}

	@Override
	public String getRowSpanType() {
		COSObject RowSpan = getRowSpanValue();
		return getObjectType(RowSpan);
	}

	@Override
	public Boolean getRowSpanHasTypeInteger() {
		COSObject RowSpan = getRowSpanValue();
		return getHasTypeInteger(RowSpan);
	}

	@Override
	public Boolean getcontainsRubyAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RubyAlign"));
	}

	public COSObject getRubyAlignDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Distribute");
		}
		return null;
	}

	public COSObject getRubyAlignValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RubyAlign"));
		if (object == null || object.empty()) {
			object = getRubyAlignDefaultValue();
		}
		return object;
	}

	@Override
	public String getRubyAlignType() {
		COSObject RubyAlign = getRubyAlignValue();
		return getObjectType(RubyAlign);
	}

	@Override
	public Boolean getRubyAlignHasTypeName() {
		COSObject RubyAlign = getRubyAlignValue();
		return getHasTypeName(RubyAlign);
	}

	@Override
	public String getRubyAlignNameValue() {
		COSObject RubyAlign = getRubyAlignValue();
		return getNameValue(RubyAlign);
	}

	@Override
	public Boolean getcontainsRubyPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RubyPosition"));
	}

	public COSObject getRubyPositionDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Before");
		}
		return null;
	}

	public COSObject getRubyPositionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RubyPosition"));
		if (object == null || object.empty()) {
			object = getRubyPositionDefaultValue();
		}
		return object;
	}

	@Override
	public String getRubyPositionType() {
		COSObject RubyPosition = getRubyPositionValue();
		return getObjectType(RubyPosition);
	}

	@Override
	public Boolean getRubyPositionHasTypeName() {
		COSObject RubyPosition = getRubyPositionValue();
		return getHasTypeName(RubyPosition);
	}

	@Override
	public String getRubyPositionNameValue() {
		COSObject RubyPosition = getRubyPositionValue();
		return getNameValue(RubyPosition);
	}

	@Override
	public Boolean getcontainsScope() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Scope"));
	}

	public COSObject getScopeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scope"));
		return object;
	}

	@Override
	public String getScopeType() {
		COSObject Scope = getScopeValue();
		return getObjectType(Scope);
	}

	@Override
	public Boolean getScopeHasTypeName() {
		COSObject Scope = getScopeValue();
		return getHasTypeName(Scope);
	}

	@Override
	public String getScopeNameValue() {
		COSObject Scope = getScopeValue();
		return getNameValue(Scope);
	}

	@Override
	public Boolean getcontainsShort() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Short"));
	}

	public COSObject getShortValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Short"));
		return object;
	}

	@Override
	public String getShortType() {
		COSObject Short = getShortValue();
		return getObjectType(Short);
	}

	@Override
	public Boolean getShortHasTypeStringText() {
		COSObject Short = getShortValue();
		return getHasTypeStringText(Short);
	}

	@Override
	public Boolean getcontainsSpaceAfter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpaceAfter"));
	}

	public COSObject getSpaceAfterDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getSpaceAfterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpaceAfter"));
		if (object == null || object.empty()) {
			object = getSpaceAfterDefaultValue();
		}
		return object;
	}

	@Override
	public String getSpaceAfterType() {
		COSObject SpaceAfter = getSpaceAfterValue();
		return getObjectType(SpaceAfter);
	}

	@Override
	public Boolean getSpaceAfterHasTypeNumber() {
		COSObject SpaceAfter = getSpaceAfterValue();
		return getHasTypeNumber(SpaceAfter);
	}

	@Override
	public Boolean getcontainsSpaceBefore() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpaceBefore"));
	}

	public COSObject getSpaceBeforeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getSpaceBeforeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpaceBefore"));
		if (object == null || object.empty()) {
			object = getSpaceBeforeDefaultValue();
		}
		return object;
	}

	@Override
	public String getSpaceBeforeType() {
		COSObject SpaceBefore = getSpaceBeforeValue();
		return getObjectType(SpaceBefore);
	}

	@Override
	public Boolean getSpaceBeforeHasTypeNumber() {
		COSObject SpaceBefore = getSpaceBeforeValue();
		return getHasTypeNumber(SpaceBefore);
	}

	@Override
	public Boolean getcontainsStartIndent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StartIndent"));
	}

	public COSObject getStartIndentDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getStartIndentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StartIndent"));
		if (object == null || object.empty()) {
			object = getStartIndentDefaultValue();
		}
		return object;
	}

	@Override
	public String getStartIndentType() {
		COSObject StartIndent = getStartIndentValue();
		return getObjectType(StartIndent);
	}

	@Override
	public Boolean getStartIndentHasTypeNumber() {
		COSObject StartIndent = getStartIndentValue();
		return getHasTypeNumber(StartIndent);
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
	}

	@Override
	public Boolean getcontainsSummary() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Summary"));
	}

	public COSObject getSummaryValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Summary"));
		return object;
	}

	@Override
	public String getSummaryType() {
		COSObject Summary = getSummaryValue();
		return getObjectType(Summary);
	}

	@Override
	public Boolean getSummaryHasTypeStringText() {
		COSObject Summary = getSummaryValue();
		return getHasTypeStringText(Summary);
	}

	@Override
	public Boolean getcontainsTBorderStyle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TBorderStyle"));
	}

	public COSObject getTBorderStyleDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getTBorderStyleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TBorderStyle"));
		if (object == null || object.empty()) {
			object = getTBorderStyleDefaultValue();
		}
		return object;
	}

	@Override
	public String getTBorderStyleType() {
		COSObject TBorderStyle = getTBorderStyleValue();
		return getObjectType(TBorderStyle);
	}

	@Override
	public Boolean getTBorderStyleHasTypeArray() {
		COSObject TBorderStyle = getTBorderStyleValue();
		return getHasTypeArray(TBorderStyle);
	}

	@Override
	public Boolean getTBorderStyleHasTypeName() {
		COSObject TBorderStyle = getTBorderStyleValue();
		return getHasTypeName(TBorderStyle);
	}

	@Override
	public String getTBorderStyleNameValue() {
		COSObject TBorderStyle = getTBorderStyleValue();
		return getNameValue(TBorderStyle);
	}

	@Override
	public Boolean getcontainsTPadding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TPadding"));
	}

	public COSObject getTPaddingDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getTPaddingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TPadding"));
		if (object == null || object.empty()) {
			object = getTPaddingDefaultValue();
		}
		return object;
	}

	@Override
	public String getTPaddingType() {
		COSObject TPadding = getTPaddingValue();
		return getObjectType(TPadding);
	}

	@Override
	public Boolean getTPaddingHasTypeArray() {
		COSObject TPadding = getTPaddingValue();
		return getHasTypeArray(TPadding);
	}

	@Override
	public Boolean getTPaddingHasTypeInteger() {
		COSObject TPadding = getTPaddingValue();
		return getHasTypeInteger(TPadding);
	}

	@Override
	public Boolean getcontainsTextAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextAlign"));
	}

	public COSObject getTextAlignDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Start");
		}
		return null;
	}

	public COSObject getTextAlignValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextAlign"));
		if (object == null || object.empty()) {
			object = getTextAlignDefaultValue();
		}
		return object;
	}

	@Override
	public String getTextAlignType() {
		COSObject TextAlign = getTextAlignValue();
		return getObjectType(TextAlign);
	}

	@Override
	public Boolean getTextAlignHasTypeName() {
		COSObject TextAlign = getTextAlignValue();
		return getHasTypeName(TextAlign);
	}

	@Override
	public String getTextAlignNameValue() {
		COSObject TextAlign = getTextAlignValue();
		return getNameValue(TextAlign);
	}

	@Override
	public Boolean getcontainsTextDecorationColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextDecorationColor"));
	}

	public COSObject getTextDecorationColorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextDecorationColor"));
		return object;
	}

	@Override
	public String getTextDecorationColorType() {
		COSObject TextDecorationColor = getTextDecorationColorValue();
		return getObjectType(TextDecorationColor);
	}

	@Override
	public Boolean getTextDecorationColorHasTypeArray() {
		COSObject TextDecorationColor = getTextDecorationColorValue();
		return getHasTypeArray(TextDecorationColor);
	}

	@Override
	public Boolean getcontainsTextDecorationThickness() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextDecorationThickness"));
	}

	public COSObject getTextDecorationThicknessValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextDecorationThickness"));
		return object;
	}

	@Override
	public String getTextDecorationThicknessType() {
		COSObject TextDecorationThickness = getTextDecorationThicknessValue();
		return getObjectType(TextDecorationThickness);
	}

	@Override
	public Boolean getTextDecorationThicknessHasTypeNumber() {
		COSObject TextDecorationThickness = getTextDecorationThicknessValue();
		return getHasTypeNumber(TextDecorationThickness);
	}

	@Override
	public Boolean getcontainsTextDecorationType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextDecorationType"));
	}

	public COSObject getTextDecorationTypeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getTextDecorationTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextDecorationType"));
		if (object == null || object.empty()) {
			object = getTextDecorationTypeDefaultValue();
		}
		return object;
	}

	@Override
	public String getTextDecorationTypeType() {
		COSObject TextDecorationType = getTextDecorationTypeValue();
		return getObjectType(TextDecorationType);
	}

	@Override
	public Boolean getTextDecorationTypeHasTypeName() {
		COSObject TextDecorationType = getTextDecorationTypeValue();
		return getHasTypeName(TextDecorationType);
	}

	@Override
	public String getTextDecorationTypeNameValue() {
		COSObject TextDecorationType = getTextDecorationTypeValue();
		return getNameValue(TextDecorationType);
	}

	@Override
	public Boolean getcontainsTextIndent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextIndent"));
	}

	public COSObject getTextIndentDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getTextIndentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextIndent"));
		if (object == null || object.empty()) {
			object = getTextIndentDefaultValue();
		}
		return object;
	}

	@Override
	public String getTextIndentType() {
		COSObject TextIndent = getTextIndentValue();
		return getObjectType(TextIndent);
	}

	@Override
	public Boolean getTextIndentHasTypeNumber() {
		COSObject TextIndent = getTextIndentValue();
		return getHasTypeNumber(TextIndent);
	}

	@Override
	public Boolean getcontainsTextPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TextPosition"));
	}

	public COSObject getTextPositionDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSName.construct("Normal");
		}
		return null;
	}

	public COSObject getTextPositionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TextPosition"));
		if (object == null || object.empty()) {
			object = getTextPositionDefaultValue();
		}
		return object;
	}

	@Override
	public String getTextPositionType() {
		COSObject TextPosition = getTextPositionValue();
		return getObjectType(TextPosition);
	}

	@Override
	public Boolean getTextPositionHasTypeName() {
		COSObject TextPosition = getTextPositionValue();
		return getHasTypeName(TextPosition);
	}

	@Override
	public String getTextPositionNameValue() {
		COSObject TextPosition = getTextPositionValue();
		return getNameValue(TextPosition);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Width"));
	}

	public COSObject getWidthDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Auto");
		}
		return null;
	}

	public COSObject getWidthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		if (object == null || object.empty()) {
			object = getWidthDefaultValue();
		}
		return object;
	}

	@Override
	public String getWidthType() {
		COSObject Width = getWidthValue();
		return getObjectType(Width);
	}

	@Override
	public Boolean getWidthHasTypeName() {
		COSObject Width = getWidthValue();
		return getHasTypeName(Width);
	}

	@Override
	public Boolean getWidthHasTypeNumber() {
		COSObject Width = getWidthValue();
		return getHasTypeNumber(Width);
	}

	@Override
	public Boolean getcontainsWritingMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WritingMode"));
	}

	public COSObject getWritingModeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("LrTb");
		}
		return null;
	}

	public COSObject getWritingModeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WritingMode"));
		if (object == null || object.empty()) {
			object = getWritingModeDefaultValue();
		}
		return object;
	}

	@Override
	public String getWritingModeType() {
		COSObject WritingMode = getWritingModeValue();
		return getObjectType(WritingMode);
	}

	@Override
	public Boolean getWritingModeHasTypeName() {
		COSObject WritingMode = getWritingModeValue();
		return getHasTypeName(WritingMode);
	}

	@Override
	public String getWritingModeNameValue() {
		COSObject WritingMode = getWritingModeValue();
		return getNameValue(WritingMode);
	}

	@Override
	public Boolean getcontainschecked() {
		return this.baseObject.knownKey(ASAtom.getASAtom("checked"));
	}

	public COSObject getcheckedDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("off");
		}
		return null;
	}

	public COSObject getcheckedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("checked"));
		if (object == null || object.empty()) {
			object = getcheckedDefaultValue();
		}
		return object;
	}

	@Override
	public String getcheckedType() {
		COSObject checked = getcheckedValue();
		return getObjectType(checked);
	}

	@Override
	public Boolean getcheckedHasTypeName() {
		COSObject checked = getcheckedValue();
		return getHasTypeName(checked);
	}

	@Override
	public String getcheckedNameValue() {
		COSObject checked = getcheckedValue();
		return getNameValue(checked);
	}

}
