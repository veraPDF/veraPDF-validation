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

public class GFACIDFontDescriptorMetrics extends GFAObject implements ACIDFontDescriptorMetrics {

	public GFACIDFontDescriptorMetrics(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIDFontDescriptorMetrics");
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
		return getHasTypeNumber(object);
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
		return getHasTypeNumber(object);
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
		return getHasTypeNumber(object);
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
	public Boolean getCharSetHasTypeString() {
		COSObject object = getCharSetValue();
		return getHasTypeString(object);
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
		return getHasTypeNumber(object);
	}

	@Override
	public Double getDescentNumberValue() {
		COSObject object = getDescentValue();
		return getNumberValue(object);
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
		return getHasTypeBitmask(object);
	}

	@Override
	public Long getFlagsBitmaskValue() {
		COSObject object = getFlagsValue();
		return getBitmaskValue(object);
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
		return getHasTypeRectangle(object);
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
		return getHasTypeName(object);
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
		return getHasTypeNumber(object);
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
		return getHasTypeNumber(object);
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
		return getHasTypeNumber(object);
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
		return getHasTypeNumber(object);
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
		return getHasTypeNumber(object);
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
		return getHasTypeNumber(object);
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
		return getNameValue(object);
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
		return getHasTypeNumber(object);
	}

}
