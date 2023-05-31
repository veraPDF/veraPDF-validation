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

public class GFAFontDescriptorCIDType0 extends GFAObject implements AFontDescriptorCIDType0 {

	public GFAFontDescriptorCIDType0(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFontDescriptorCIDType0");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIDSet":
				return getCIDSet();
			case "FD":
				return getFD();
			case "FontFile":
				return getFontFile();
			case "FontFile3":
				return getFontFile3();
			case "Style":
				return getStyle();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStream> getCIDSet() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIDSet1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getCIDSet1_2() {
		COSObject object = getCIDSetValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "CIDSet"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFDDict> getFD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFD1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFDDict> getFD1_2() {
		COSObject object = getFDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFDDict> list = new ArrayList<>(1);
			list.add(new GFAFDDict((COSDictionary)object.getDirectBase(), this.baseObject, "FD"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFontFile> getFontFile() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFontFile1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFontFile> getFontFile1_2() {
		COSObject object = getFontFileValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFontFile> list = new ArrayList<>(1);
			list.add(new GFAFontFile((COSStream)object.getDirectBase(), this.baseObject, "FontFile"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFontFile3CIDType0> getFontFile3() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFontFile31_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFontFile3CIDType0> getFontFile31_2() {
		COSObject object = getFontFile3Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFontFile3CIDType0> list = new ArrayList<>(1);
			list.add(new GFAFontFile3CIDType0((COSStream)object.getDirectBase(), this.baseObject, "FontFile3"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStyleDict> getStyle() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getStyle1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStyleDict> getStyle1_2() {
		COSObject object = getStyleValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AStyleDict> list = new ArrayList<>(1);
			list.add(new GFAStyleDict((COSDictionary)object.getDirectBase(), this.baseObject, "Style"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAscent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ascent"));
	}

	public COSObject getAscentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ascent"));
		return object;
	}

	@Override
	public Boolean getAscentHasTypeNumber() {
		COSObject object = getAscentValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsAvgWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AvgWidth"));
	}

	public COSObject getAvgWidthDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getAvgWidthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AvgWidth"));
		if (object == null || object.empty()) {
			object = getAvgWidthDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getAvgWidthHasTypeNumber() {
		COSObject object = getAvgWidthValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsCIDSet() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIDSet"));
	}

	public COSObject getCIDSetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDSet"));
		return object;
	}

	@Override
	public Boolean getisCIDSetIndirect() {
		COSObject object = getCIDSetValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getCIDSetHasTypeStream() {
		COSObject object = getCIDSetValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsCapHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CapHeight"));
	}

	public COSObject getCapHeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CapHeight"));
		return object;
	}

	@Override
	public Boolean getCapHeightHasTypeNumber() {
		COSObject object = getCapHeightValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsDescent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Descent"));
	}

	public COSObject getDescentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Descent"));
		return object;
	}

	@Override
	public Boolean getDescentHasTypeNumber() {
		COSObject object = getDescentValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getDescentNumberValue() {
		COSObject object = getDescentValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FD"));
	}

	public COSObject getFDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FD"));
		return object;
	}

	@Override
	public Boolean getFDHasTypeDictionary() {
		COSObject object = getFDValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsFlags() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Flags"));
	}

	public COSObject getFlagsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Flags"));
		return object;
	}

	@Override
	public Boolean getFlagsHasTypeBitmask() {
		COSObject object = getFlagsValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFlagsBitmaskValue() {
		COSObject object = getFlagsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFontBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontBBox"));
	}

	public COSObject getFontBBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontBBox"));
		return object;
	}

	@Override
	public Boolean getFontBBoxHasTypeRectangle() {
		COSObject object = getFontBBoxValue();
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
	public Boolean getcontainsFontFamily() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontFamily"));
	}

	public COSObject getFontFamilyValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontFamily"));
		return object;
	}

	@Override
	public Boolean getFontFamilyHasTypeString() {
		COSObject object = getFontFamilyValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsFontFile() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontFile"));
	}

	public COSObject getFontFileValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontFile"));
		return object;
	}

	@Override
	public Boolean getisFontFileIndirect() {
		COSObject object = getFontFileValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFontFileHasTypeStream() {
		COSObject object = getFontFileValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsFontFile3() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontFile3"));
	}

	public COSObject getFontFile3Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontFile3"));
		return object;
	}

	@Override
	public Boolean getisFontFile3Indirect() {
		COSObject object = getFontFile3Value();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFontFile3HasTypeStream() {
		COSObject object = getFontFile3Value();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsFontName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontName"));
	}

	public COSObject getFontNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontName"));
		return object;
	}

	@Override
	public Boolean getFontNameHasTypeName() {
		COSObject object = getFontNameValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFontNameNameValue() {
		COSObject object = getFontNameValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFontStretch() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontStretch"));
	}

	public COSObject getFontStretchValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontStretch"));
		return object;
	}

	@Override
	public Boolean getFontStretchHasTypeName() {
		COSObject object = getFontStretchValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFontStretchNameValue() {
		COSObject object = getFontStretchValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFontWeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontWeight"));
	}

	public COSObject getFontWeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontWeight"));
		return object;
	}

	@Override
	public Boolean getFontWeightHasTypeInteger() {
		COSObject object = getFontWeightValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFontWeightIntegerValue() {
		COSObject object = getFontWeightValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsItalicAngle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ItalicAngle"));
	}

	public COSObject getItalicAngleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ItalicAngle"));
		return object;
	}

	@Override
	public Boolean getItalicAngleHasTypeNumber() {
		COSObject object = getItalicAngleValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsLang() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Lang"));
	}

	public COSObject getLangValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Lang"));
		return object;
	}

	@Override
	public Boolean getLangHasTypeName() {
		COSObject object = getLangValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsLeading() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Leading"));
	}

	public COSObject getLeadingDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getLeadingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Leading"));
		if (object == null || object.empty()) {
			object = getLeadingDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getLeadingHasTypeNumber() {
		COSObject object = getLeadingValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsMaxWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MaxWidth"));
	}

	public COSObject getMaxWidthDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getMaxWidthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MaxWidth"));
		if (object == null || object.empty()) {
			object = getMaxWidthDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getMaxWidthHasTypeNumber() {
		COSObject object = getMaxWidthValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsMissingWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MissingWidth"));
	}

	public COSObject getMissingWidthDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getMissingWidthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MissingWidth"));
		if (object == null || object.empty()) {
			object = getMissingWidthDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getMissingWidthHasTypeNumber() {
		COSObject object = getMissingWidthValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsStemH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StemH"));
	}

	public COSObject getStemHDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getStemHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StemH"));
		if (object == null || object.empty()) {
			object = getStemHDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getStemHHasTypeNumber() {
		COSObject object = getStemHValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsStemV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StemV"));
	}

	public COSObject getStemVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StemV"));
		return object;
	}

	@Override
	public Boolean getStemVHasTypeNumber() {
		COSObject object = getStemVValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsStyle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Style"));
	}

	public COSObject getStyleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Style"));
		return object;
	}

	@Override
	public Boolean getStyleHasTypeDictionary() {
		COSObject object = getStyleValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getcontainsXHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XHeight"));
	}

	public COSObject getXHeightDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getXHeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XHeight"));
		if (object == null || object.empty()) {
			object = getXHeightDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getXHeightHasTypeNumber() {
		COSObject object = getXHeightValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public String getparentBaseFontNameValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject BaseFont = this.parentObject.getKey(ASAtom.getASAtom("BaseFont"));
		return new GFAFontCIDType0(this.parentObject.getDirectBase(), null, null).getBaseFontNameValue();
	}

}
