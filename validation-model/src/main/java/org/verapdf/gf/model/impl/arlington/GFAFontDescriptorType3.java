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

public class GFAFontDescriptorType3 extends GFAObject implements AFontDescriptorType3 {

	public GFAFontDescriptorType3(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFontDescriptorType3");
	}

	@Override
	public Boolean getcontainsAscent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ascent"));
	}

	@Override
	public Boolean getAscentHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ascent"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsAvgWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AvgWidth"));
	}

	@Override
	public Boolean getAvgWidthHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AvgWidth"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsCapHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CapHeight"));
	}

	@Override
	public Boolean getCapHeightHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CapHeight"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsDescent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Descent"));
	}

	@Override
	public Boolean getDescentHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Descent"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getDescentNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Descent"));
		if (object == null || object.empty()) {
			return getDescentNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getDescentNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsFlags() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Flags"));
	}

	@Override
	public Boolean getFlagsHasTypeBitmask() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Flags"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFlagsBitmaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Flags"));
		if (object == null || object.empty()) {
			return getFlagsBitmaskDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getFlagsBitmaskDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsFontBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontBBox"));
	}

	@Override
	public Boolean getFontBBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontBBox"));
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

	@Override
	public Boolean getFontFamilyHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontFamily"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsFontName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontName"));
	}

	@Override
	public Boolean getFontNameHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontName"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFontNameNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontName"));
		if (object == null || object.empty()) {
			return getFontNameNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFontNameNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsFontStretch() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontStretch"));
	}

	@Override
	public Boolean getFontStretchHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontStretch"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFontStretchNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontStretch"));
		if (object == null || object.empty()) {
			return getFontStretchNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFontStretchNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsFontWeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontWeight"));
	}

	@Override
	public Boolean getFontWeightHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontWeight"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFontWeightIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontWeight"));
		if (object == null || object.empty()) {
			return getFontWeightIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getFontWeightIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsItalicAngle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ItalicAngle"));
	}

	@Override
	public Boolean getItalicAngleHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ItalicAngle"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsLeading() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Leading"));
	}

	@Override
	public Boolean getLeadingHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Leading"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsMaxWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MaxWidth"));
	}

	@Override
	public Boolean getMaxWidthHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MaxWidth"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsMissingWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MissingWidth"));
	}

	@Override
	public Boolean getMissingWidthHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MissingWidth"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsStemH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StemH"));
	}

	@Override
	public Boolean getStemHHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StemH"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsStemV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StemV"));
	}

	@Override
	public Boolean getStemVHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StemV"));
		return object != null && object.getType().isNumber();
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
	public Boolean getcontainsXHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XHeight"));
	}

	@Override
	public Boolean getXHeightHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XHeight"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public String getparentNameNameValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Name = this.parentObject.getKey(ASAtom.getASAtom("Name"));
		return new GFAFontType3(this.parentObject.getDirectBase(), null, null).getNameNameValue();
	}

}
