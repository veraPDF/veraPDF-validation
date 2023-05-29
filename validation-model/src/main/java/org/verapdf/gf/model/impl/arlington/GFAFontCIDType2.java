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

public class GFAFontCIDType2 extends GFAObject implements AFontCIDType2 {

	public GFAFontCIDType2(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFontCIDType2");
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
		switch (StaticContainers.getFlavour()) {
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
		switch (StaticContainers.getFlavour()) {
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
		switch (StaticContainers.getFlavour()) {
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

	private List<AFontDescriptorCIDType2> getFontDescriptor() {
		switch (StaticContainers.getFlavour()) {
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

	private List<AFontDescriptorCIDType2> getFontDescriptor1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontDescriptor"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFontDescriptorCIDType2> list = new ArrayList<>(1);
			list.add(new GFAFontDescriptorCIDType2((COSDictionary)object.getDirectBase(), this.baseObject, "FontDescriptor"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getToUnicode() {
		switch (StaticContainers.getFlavour()) {
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
		switch (StaticContainers.getFlavour()) {
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
		switch (StaticContainers.getFlavour()) {
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

	public COSObject getBaseFontValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseFont"));
		return object;
	}

	@Override
	public Boolean getBaseFontHasTypeName() {
		COSObject object = getBaseFontValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBaseFontNameValue() {
		COSObject object = getBaseFontValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsCIDSystemInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIDSystemInfo"));
	}

	public COSObject getCIDSystemInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDSystemInfo"));
		return object;
	}

	@Override
	public Boolean getCIDSystemInfoHasTypeDictionary() {
		COSObject object = getCIDSystemInfoValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsCIDToGIDMap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIDToGIDMap"));
	}

	public COSObject getCIDToGIDMapValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIDToGIDMap"));
		return object;
	}

	@Override
	public Boolean getisCIDToGIDMapIndirect() {
		COSObject object = getCIDToGIDMapValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getCIDToGIDMapHasTypeName() {
		COSObject object = getCIDToGIDMapValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getCIDToGIDMapHasTypeStream() {
		COSObject object = getCIDToGIDMapValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public String getCIDToGIDMapNameValue() {
		COSObject object = getCIDToGIDMapValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DW"));
	}

	public COSObject getDWDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1000D);
		}
		return null;
	}

	public COSObject getDWValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DW"));
		if (object == null || object.empty()) {
			object = getDWDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDWHasTypeNumber() {
		COSObject object = getDWValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsDW2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DW2"));
	}

	public COSObject getDW2Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DW2"));
		return object;
	}

	@Override
	public Boolean getDW2HasTypeArray() {
		COSObject object = getDW2Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsFontDescriptor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontDescriptor"));
	}

	public COSObject getFontDescriptorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontDescriptor"));
		return object;
	}

	@Override
	public Boolean getisFontDescriptorIndirect() {
		COSObject object = getFontDescriptorValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFontDescriptorHasTypeDictionary() {
		COSObject object = getFontDescriptorValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getcontainsToUnicode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ToUnicode"));
	}

	public COSObject getToUnicodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ToUnicode"));
		return object;
	}

	@Override
	public Boolean getisToUnicodeIndirect() {
		COSObject object = getToUnicodeValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getToUnicodeHasTypeStream() {
		COSObject object = getToUnicodeValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
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
	public Boolean getcontainsW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("W"));
	}

	public COSObject getWValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W"));
		return object;
	}

	@Override
	public Boolean getWHasTypeArray() {
		COSObject object = getWValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsW2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("W2"));
	}

	public COSObject getW2Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W2"));
		return object;
	}

	@Override
	public Boolean getW2HasTypeArray() {
		COSObject object = getW2Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsFontDescriptorFontFile2() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject FontDescriptor = this.baseObject.getKey(ASAtom.getASAtom("FontDescriptor"));
		return FontDescriptor.knownKey(ASAtom.getASAtom("FontFile2"));
	}

}
