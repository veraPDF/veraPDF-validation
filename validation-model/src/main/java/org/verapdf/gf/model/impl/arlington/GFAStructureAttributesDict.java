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
	public Boolean getBBoxHasTypeRectangle() {
		COSObject object = getBBoxValue();
		return getHasTypeRectangle(object);
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
	public Boolean getBackgroundColorHasTypeArray() {
		COSObject object = getBackgroundColorValue();
		return getHasTypeArray(object);
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
	public Boolean getBaselineShiftHasTypeNumber() {
		COSObject object = getBaselineShiftValue();
		return getHasTypeNumber(object);
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
	public Boolean getBlockAlignHasTypeName() {
		COSObject object = getBlockAlignValue();
		return getHasTypeName(object);
	}

	@Override
	public String getBlockAlignNameValue() {
		COSObject object = getBlockAlignValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getBorderColorHasTypeArray() {
		COSObject object = getBorderColorValue();
		return getHasTypeArray(object);
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
	public Boolean getBorderStyleHasTypeArray() {
		COSObject object = getBorderStyleValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getBorderStyleHasTypeName() {
		COSObject object = getBorderStyleValue();
		return getHasTypeName(object);
	}

	@Override
	public String getBorderStyleNameValue() {
		COSObject object = getBorderStyleValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getBorderThicknessHasTypeArray() {
		COSObject object = getBorderThicknessValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getBorderThicknessHasTypeNumber() {
		COSObject object = getBorderThicknessValue();
		return getHasTypeNumber(object);
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
	public Boolean getCheckedHasTypeName() {
		COSObject object = getCheckedValue();
		return getHasTypeName(object);
	}

	@Override
	public String getCheckedNameValue() {
		COSObject object = getCheckedValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getColSpanHasTypeInteger() {
		COSObject object = getColSpanValue();
		return getHasTypeInteger(object);
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
	public Boolean getColorHasTypeArray() {
		COSObject object = getColorValue();
		return getHasTypeArray(object);
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
	public Boolean getColumnCountHasTypeInteger() {
		COSObject object = getColumnCountValue();
		return getHasTypeInteger(object);
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
	public Boolean getColumnGapHasTypeArray() {
		COSObject object = getColumnGapValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getColumnGapHasTypeNumber() {
		COSObject object = getColumnGapValue();
		return getHasTypeNumber(object);
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
	public Boolean getColumnWidthsHasTypeArray() {
		COSObject object = getColumnWidthsValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getColumnWidthsHasTypeNumber() {
		COSObject object = getColumnWidthsValue();
		return getHasTypeNumber(object);
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
	public Boolean getContentsHasTypeArray() {
		COSObject object = getContentsValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getContentsHasTypeStringText() {
		COSObject object = getContentsValue();
		return getHasTypeStringText(object);
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
	public Boolean getContinuedFormHasTypeStringByte() {
		COSObject object = getContinuedFormValue();
		return getHasTypeStringByte(object);
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
	public Boolean getContinuedListHasTypeBoolean() {
		COSObject object = getContinuedListValue();
		return getHasTypeBoolean(object);
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
	public Boolean getDescHasTypeStringText() {
		COSObject object = getDescValue();
		return getHasTypeStringText(object);
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
	public Boolean getEndIndentHasTypeNumber() {
		COSObject object = getEndIndentValue();
		return getHasTypeNumber(object);
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
	public Boolean getGlyphOrientationVerticalHasTypeInteger() {
		COSObject object = getGlyphOrientationVerticalValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getGlyphOrientationVerticalHasTypeName() {
		COSObject object = getGlyphOrientationVerticalValue();
		return getHasTypeName(object);
	}

	@Override
	public Long getGlyphOrientationVerticalIntegerValue() {
		COSObject object = getGlyphOrientationVerticalValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public String getGlyphOrientationVerticalNameValue() {
		COSObject object = getGlyphOrientationVerticalValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getHeadersHasTypeArray() {
		COSObject object = getHeadersValue();
		return getHasTypeArray(object);
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
	public Boolean getHeightHasTypeName() {
		COSObject object = getHeightValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getHeightHasTypeNumber() {
		COSObject object = getHeightValue();
		return getHasTypeNumber(object);
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
	public Boolean getInlineAlignHasTypeName() {
		COSObject object = getInlineAlignValue();
		return getHasTypeName(object);
	}

	@Override
	public String getInlineAlignNameValue() {
		COSObject object = getInlineAlignValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getLineHeightHasTypeName() {
		COSObject object = getLineHeightValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getLineHeightHasTypeNumber() {
		COSObject object = getLineHeightValue();
		return getHasTypeNumber(object);
	}

	@Override
	public String getLineHeightNameValue() {
		COSObject object = getLineHeightValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getListNumberingHasTypeName() {
		COSObject object = getListNumberingValue();
		return getHasTypeName(object);
	}

	@Override
	public String getListNumberingNameValue() {
		COSObject object = getListNumberingValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
		COSObject object = getNSValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getNSHasTypeDictionary() {
		COSObject object = getNSValue();
		return getHasTypeDictionary(object);
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
	public Boolean getOHasTypeName() {
		COSObject object = getOValue();
		return getHasTypeName(object);
	}

	@Override
	public String getONameValue() {
		COSObject object = getOValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getPHasTypeArray() {
		COSObject object = getPValue();
		return getHasTypeArray(object);
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
	public Boolean getPaddingHasTypeArray() {
		COSObject object = getPaddingValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getPaddingHasTypeNumber() {
		COSObject object = getPaddingValue();
		return getHasTypeNumber(object);
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
	public Boolean getPlacementHasTypeName() {
		COSObject object = getPlacementValue();
		return getHasTypeName(object);
	}

	@Override
	public String getPlacementNameValue() {
		COSObject object = getPlacementValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getRoleHasTypeName() {
		COSObject object = getRoleValue();
		return getHasTypeName(object);
	}

	@Override
	public String getRoleNameValue() {
		COSObject object = getRoleValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getRowSpanHasTypeInteger() {
		COSObject object = getRowSpanValue();
		return getHasTypeInteger(object);
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
	public Boolean getRubyAlignHasTypeName() {
		COSObject object = getRubyAlignValue();
		return getHasTypeName(object);
	}

	@Override
	public String getRubyAlignNameValue() {
		COSObject object = getRubyAlignValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getRubyPositionHasTypeName() {
		COSObject object = getRubyPositionValue();
		return getHasTypeName(object);
	}

	@Override
	public String getRubyPositionNameValue() {
		COSObject object = getRubyPositionValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getScopeHasTypeName() {
		COSObject object = getScopeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getScopeNameValue() {
		COSObject object = getScopeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getShortHasTypeStringText() {
		COSObject object = getShortValue();
		return getHasTypeStringText(object);
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
	public Boolean getSpaceAfterHasTypeNumber() {
		COSObject object = getSpaceAfterValue();
		return getHasTypeNumber(object);
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
	public Boolean getSpaceBeforeHasTypeNumber() {
		COSObject object = getSpaceBeforeValue();
		return getHasTypeNumber(object);
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
	public Boolean getStartIndentHasTypeNumber() {
		COSObject object = getStartIndentValue();
		return getHasTypeNumber(object);
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
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getSummaryHasTypeStringText() {
		COSObject object = getSummaryValue();
		return getHasTypeStringText(object);
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
	public Boolean getTBorderStyleHasTypeArray() {
		COSObject object = getTBorderStyleValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getTBorderStyleHasTypeName() {
		COSObject object = getTBorderStyleValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTBorderStyleNameValue() {
		COSObject object = getTBorderStyleValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getTPaddingHasTypeArray() {
		COSObject object = getTPaddingValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getTPaddingHasTypeInteger() {
		COSObject object = getTPaddingValue();
		return getHasTypeInteger(object);
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
	public Boolean getTextAlignHasTypeName() {
		COSObject object = getTextAlignValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTextAlignNameValue() {
		COSObject object = getTextAlignValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getTextDecorationColorHasTypeArray() {
		COSObject object = getTextDecorationColorValue();
		return getHasTypeArray(object);
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
	public Boolean getTextDecorationThicknessHasTypeNumber() {
		COSObject object = getTextDecorationThicknessValue();
		return getHasTypeNumber(object);
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
	public Boolean getTextDecorationTypeHasTypeName() {
		COSObject object = getTextDecorationTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTextDecorationTypeNameValue() {
		COSObject object = getTextDecorationTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getTextIndentHasTypeNumber() {
		COSObject object = getTextIndentValue();
		return getHasTypeNumber(object);
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
	public Boolean getTextPositionHasTypeName() {
		COSObject object = getTextPositionValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTextPositionNameValue() {
		COSObject object = getTextPositionValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getWidthHasTypeName() {
		COSObject object = getWidthValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getWidthHasTypeNumber() {
		COSObject object = getWidthValue();
		return getHasTypeNumber(object);
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
	public Boolean getWritingModeHasTypeName() {
		COSObject object = getWritingModeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getWritingModeNameValue() {
		COSObject object = getWritingModeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getcheckedHasTypeName() {
		COSObject object = getcheckedValue();
		return getHasTypeName(object);
	}

	@Override
	public String getcheckedNameValue() {
		COSObject object = getcheckedValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
