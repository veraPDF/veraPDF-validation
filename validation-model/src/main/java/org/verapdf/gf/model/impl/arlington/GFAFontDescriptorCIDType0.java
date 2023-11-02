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
	public String getAscentType() {
		COSObject Ascent = getAscentValue();
		return getObjectType(Ascent);
	}

	@Override
	public Boolean getAscentHasTypeNumber() {
		COSObject Ascent = getAscentValue();
		return getHasTypeNumber(Ascent);
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
	public String getAvgWidthType() {
		COSObject AvgWidth = getAvgWidthValue();
		return getObjectType(AvgWidth);
	}

	@Override
	public Boolean getAvgWidthHasTypeNumber() {
		COSObject AvgWidth = getAvgWidthValue();
		return getHasTypeNumber(AvgWidth);
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
		COSObject CIDSet = getCIDSetValue();
		return getisIndirect(CIDSet);
	}

	@Override
	public String getCIDSetType() {
		COSObject CIDSet = getCIDSetValue();
		return getObjectType(CIDSet);
	}

	@Override
	public Boolean getCIDSetHasTypeStream() {
		COSObject CIDSet = getCIDSetValue();
		return getHasTypeStream(CIDSet);
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
	public String getCapHeightType() {
		COSObject CapHeight = getCapHeightValue();
		return getObjectType(CapHeight);
	}

	@Override
	public Boolean getCapHeightHasTypeNumber() {
		COSObject CapHeight = getCapHeightValue();
		return getHasTypeNumber(CapHeight);
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
	public String getDescentType() {
		COSObject Descent = getDescentValue();
		return getObjectType(Descent);
	}

	@Override
	public Boolean getDescentHasTypeNumber() {
		COSObject Descent = getDescentValue();
		return getHasTypeNumber(Descent);
	}

	@Override
	public Double getDescentNumberValue() {
		COSObject Descent = getDescentValue();
		return getNumberValue(Descent);
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
	public String getFDType() {
		COSObject FD = getFDValue();
		return getObjectType(FD);
	}

	@Override
	public Boolean getFDHasTypeDictionary() {
		COSObject FD = getFDValue();
		return getHasTypeDictionary(FD);
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
	public String getFlagsType() {
		COSObject Flags = getFlagsValue();
		return getObjectType(Flags);
	}

	@Override
	public Boolean getFlagsHasTypeBitmask() {
		COSObject Flags = getFlagsValue();
		return getHasTypeBitmask(Flags);
	}

	@Override
	public Long getFlagsBitmaskValue() {
		COSObject Flags = getFlagsValue();
		return getBitmaskValue(Flags);
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
	public String getFontBBoxType() {
		COSObject FontBBox = getFontBBoxValue();
		return getObjectType(FontBBox);
	}

	@Override
	public Boolean getFontBBoxHasTypeRectangle() {
		COSObject FontBBox = getFontBBoxValue();
		return getHasTypeRectangle(FontBBox);
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
	public String getFontFamilyType() {
		COSObject FontFamily = getFontFamilyValue();
		return getObjectType(FontFamily);
	}

	@Override
	public Boolean getFontFamilyHasTypeString() {
		COSObject FontFamily = getFontFamilyValue();
		return getHasTypeString(FontFamily);
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
		COSObject FontFile = getFontFileValue();
		return getisIndirect(FontFile);
	}

	@Override
	public String getFontFileType() {
		COSObject FontFile = getFontFileValue();
		return getObjectType(FontFile);
	}

	@Override
	public Boolean getFontFileHasTypeStream() {
		COSObject FontFile = getFontFileValue();
		return getHasTypeStream(FontFile);
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
		COSObject FontFile3 = getFontFile3Value();
		return getisIndirect(FontFile3);
	}

	@Override
	public String getFontFile3Type() {
		COSObject FontFile3 = getFontFile3Value();
		return getObjectType(FontFile3);
	}

	@Override
	public Boolean getFontFile3HasTypeStream() {
		COSObject FontFile3 = getFontFile3Value();
		return getHasTypeStream(FontFile3);
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
	public String getFontNameType() {
		COSObject FontName = getFontNameValue();
		return getObjectType(FontName);
	}

	@Override
	public Boolean getFontNameHasTypeName() {
		COSObject FontName = getFontNameValue();
		return getHasTypeName(FontName);
	}

	@Override
	public String getFontNameNameValue() {
		COSObject FontName = getFontNameValue();
		return getNameValue(FontName);
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
	public String getFontStretchType() {
		COSObject FontStretch = getFontStretchValue();
		return getObjectType(FontStretch);
	}

	@Override
	public Boolean getFontStretchHasTypeName() {
		COSObject FontStretch = getFontStretchValue();
		return getHasTypeName(FontStretch);
	}

	@Override
	public String getFontStretchNameValue() {
		COSObject FontStretch = getFontStretchValue();
		return getNameValue(FontStretch);
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
	public String getFontWeightType() {
		COSObject FontWeight = getFontWeightValue();
		return getObjectType(FontWeight);
	}

	@Override
	public Boolean getFontWeightHasTypeInteger() {
		COSObject FontWeight = getFontWeightValue();
		return getHasTypeInteger(FontWeight);
	}

	@Override
	public Long getFontWeightIntegerValue() {
		COSObject FontWeight = getFontWeightValue();
		return getIntegerValue(FontWeight);
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
	public String getItalicAngleType() {
		COSObject ItalicAngle = getItalicAngleValue();
		return getObjectType(ItalicAngle);
	}

	@Override
	public Boolean getItalicAngleHasTypeNumber() {
		COSObject ItalicAngle = getItalicAngleValue();
		return getHasTypeNumber(ItalicAngle);
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
	public String getLangType() {
		COSObject Lang = getLangValue();
		return getObjectType(Lang);
	}

	@Override
	public Boolean getLangHasTypeName() {
		COSObject Lang = getLangValue();
		return getHasTypeName(Lang);
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
	public String getLeadingType() {
		COSObject Leading = getLeadingValue();
		return getObjectType(Leading);
	}

	@Override
	public Boolean getLeadingHasTypeNumber() {
		COSObject Leading = getLeadingValue();
		return getHasTypeNumber(Leading);
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
	public String getMaxWidthType() {
		COSObject MaxWidth = getMaxWidthValue();
		return getObjectType(MaxWidth);
	}

	@Override
	public Boolean getMaxWidthHasTypeNumber() {
		COSObject MaxWidth = getMaxWidthValue();
		return getHasTypeNumber(MaxWidth);
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
	public String getMissingWidthType() {
		COSObject MissingWidth = getMissingWidthValue();
		return getObjectType(MissingWidth);
	}

	@Override
	public Boolean getMissingWidthHasTypeNumber() {
		COSObject MissingWidth = getMissingWidthValue();
		return getHasTypeNumber(MissingWidth);
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
	public String getStemHType() {
		COSObject StemH = getStemHValue();
		return getObjectType(StemH);
	}

	@Override
	public Boolean getStemHHasTypeNumber() {
		COSObject StemH = getStemHValue();
		return getHasTypeNumber(StemH);
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
	public String getStemVType() {
		COSObject StemV = getStemVValue();
		return getObjectType(StemV);
	}

	@Override
	public Boolean getStemVHasTypeNumber() {
		COSObject StemV = getStemVValue();
		return getHasTypeNumber(StemV);
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
	public String getStyleType() {
		COSObject Style = getStyleValue();
		return getObjectType(Style);
	}

	@Override
	public Boolean getStyleHasTypeDictionary() {
		COSObject Style = getStyleValue();
		return getHasTypeDictionary(Style);
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
	public String getXHeightType() {
		COSObject XHeight = getXHeightValue();
		return getObjectType(XHeight);
	}

	@Override
	public Boolean getXHeightHasTypeNumber() {
		COSObject XHeight = getXHeightValue();
		return getHasTypeNumber(XHeight);
	}

	@Override
	public String getparentBaseFontNameValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		return new GFAFontCIDType0(this.parentObject.getDirectBase(), null, null).getBaseFontNameValue();
	}

}
