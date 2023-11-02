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

public class GFAFontDescriptorType1 extends GFAObject implements AFontDescriptorType1 {

	public GFAFontDescriptorType1(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFontDescriptorType1");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "FontFile":
				return getFontFile();
			case "FontFile3":
				return getFontFile3();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AFontFileType1> getFontFile() {
		return getFontFile1_0();
	}

	private List<AFontFileType1> getFontFile1_0() {
		COSObject object = getFontFileValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFontFileType1> list = new ArrayList<>(1);
			list.add(new GFAFontFileType1((COSStream)object.getDirectBase(), this.baseObject, "FontFile"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFontFile3Type1> getFontFile3() {
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

	private List<AFontFile3Type1> getFontFile31_2() {
		COSObject object = getFontFile3Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFontFile3Type1> list = new ArrayList<>(1);
			list.add(new GFAFontFile3Type1((COSStream)object.getDirectBase(), this.baseObject, "FontFile3"));
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
		return COSReal.construct(0D);
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
	public Boolean getcontainsCharSet() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CharSet"));
	}

	public COSObject getCharSetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CharSet"));
		return object;
	}

	@Override
	public String getCharSetType() {
		COSObject CharSet = getCharSetValue();
		return getObjectType(CharSet);
	}

	@Override
	public Boolean getCharSetHasTypeStringAscii() {
		COSObject CharSet = getCharSetValue();
		return getHasTypeStringAscii(CharSet);
	}

	@Override
	public Boolean getCharSetHasTypeStringByte() {
		COSObject CharSet = getCharSetValue();
		return getHasTypeStringByte(CharSet);
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
	public Boolean getFontFamilyHasTypeStringByte() {
		COSObject FontFamily = getFontFamilyValue();
		return getHasTypeStringByte(FontFamily);
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
	public Boolean getcontainsLeading() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Leading"));
	}

	public COSObject getLeadingDefaultValue() {
		return COSReal.construct(0D);
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
		return COSReal.construct(0D);
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
		return COSReal.construct(0D);
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
		return COSReal.construct(0D);
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
		return COSReal.construct(0D);
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

	public COSObject getparentBaseFontValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject BaseFont = this.parentObject.getKey(ASAtom.getASAtom("BaseFont"));
		return BaseFont;
	}

	@Override
	public String getparentBaseFontNameValue() {
		COSObject parentBaseFont = getparentBaseFontValue();
		return getNameValue(parentBaseFont);
	}

}
