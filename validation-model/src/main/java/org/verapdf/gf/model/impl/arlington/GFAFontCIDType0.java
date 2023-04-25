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

public class GFAFontCIDType0 extends GFAObject implements AFontCIDType0 {

	public GFAFontCIDType0(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFontCIDType0");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIDSystemInfo":
				return getCIDSystemInfo();
			case "CIDToGIDMap":
				return getCIDToGIDMap();
			case "DW2":
				return getDW2();
			case "FontDescriptor":
				return getFontDescriptor();
			case "ToUnicode":
				return getToUnicode();
			case "W":
				return getW();
			case "W2":
				return getW2();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACIDSystemInfo> getCIDSystemInfo() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIDSystemInfo1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIDSystemInfo> getCIDSystemInfo1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDSystemInfo"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIDSystemInfo> list = new ArrayList<>(1);
			list.add(new GFACIDSystemInfo((COSDictionary)object.getDirectBase(), this.baseObject, "CIDSystemInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getCIDToGIDMap() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIDToGIDMap1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getCIDToGIDMap1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDToGIDMap"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "CIDToGIDMap"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Numbers> getDW2() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDW21_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getDW21_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DW2"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "DW2"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFontDescriptorCIDType0> getFontDescriptor() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFontDescriptor1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFontDescriptorCIDType0> getFontDescriptor1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontDescriptor"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFontDescriptorCIDType0> list = new ArrayList<>(1);
			list.add(new GFAFontDescriptorCIDType0((COSDictionary)object.getDirectBase(), this.baseObject, "FontDescriptor"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getToUnicode() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getToUnicode1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getToUnicode1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ToUnicode"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "ToUnicode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIDGlyphMetricsW> getW() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getW1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIDGlyphMetricsW> getW1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIDGlyphMetricsW> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIDGlyphMetricsW((COSArray)object.getDirectBase(), this.baseObject, "W"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIDGlyphMetricsW2> getW2() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getW21_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIDGlyphMetricsW2> getW21_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W2"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIDGlyphMetricsW2> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIDGlyphMetricsW2((COSArray)object.getDirectBase(), this.baseObject, "W2"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBaseFont() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaseFont"));
	}

	@Override
	public Boolean getBaseFontHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseFont"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBaseFontNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseFont"));
		if (object == null || object.empty()) {
			return getBaseFontNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getBaseFontNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsCIDSystemInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIDSystemInfo"));
	}

	@Override
	public Boolean getCIDSystemInfoHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDSystemInfo"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsCIDToGIDMap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIDToGIDMap"));
	}

	@Override
	public Boolean getisCIDToGIDMapIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDToGIDMap"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getCIDToGIDMapHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDToGIDMap"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getCIDToGIDMapHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDToGIDMap"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public String getCIDToGIDMapNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDToGIDMap"));
		if (object == null || object.empty()) {
			return getCIDToGIDMapNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getCIDToGIDMapNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DW"));
	}

	@Override
	public Boolean getDWHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DW"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsDW2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DW2"));
	}

	@Override
	public Boolean getDW2HasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DW2"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsFontDescriptor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontDescriptor"));
	}

	@Override
	public Boolean getisFontDescriptorIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontDescriptor"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFontDescriptorHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontDescriptor"));
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getcontainsToUnicode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ToUnicode"));
	}

	@Override
	public Boolean getisToUnicodeIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ToUnicode"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getToUnicodeHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ToUnicode"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
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
	public Boolean getcontainsW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("W"));
	}

	@Override
	public Boolean getWHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsW2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("W2"));
	}

	@Override
	public Boolean getW2HasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W2"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
