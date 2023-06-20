package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFAFontTrueType extends GFAObject implements AFontTrueType {

	public GFAFontTrueType(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFontTrueType");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Encoding":
				return getEncoding();
			case "FontDescriptor":
				return getFontDescriptor();
			case "ToUnicode":
				return getToUnicode();
			case "Widths":
				return getWidths();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AEncoding> getEncoding() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEncoding1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AEncoding> getEncoding1_0() {
		COSObject object = getEncodingValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AEncoding> list = new ArrayList<>(1);
			list.add(new GFAEncoding((COSDictionary)object.getDirectBase(), this.baseObject, "Encoding"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFontDescriptorTrueType> getFontDescriptor() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFontDescriptor1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFontDescriptorTrueType> getFontDescriptor1_0() {
		COSObject object = getFontDescriptorValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFontDescriptorTrueType> list = new ArrayList<>(1);
			list.add(new GFAFontDescriptorTrueType((COSDictionary)object.getDirectBase(), this.baseObject, "FontDescriptor"));
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
		COSObject object = getToUnicodeValue();
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

	private List<AArrayOfNumbersGeneral> getWidths() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getWidths1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getWidths1_0() {
		COSObject object = getWidthsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Widths"));
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
		return getHasTypeName(object);
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
	public Boolean getcontainsEncoding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Encoding"));
	}

	public COSObject getEncodingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encoding"));
		return object;
	}

	@Override
	public Boolean getEncodingHasTypeDictionary() {
		COSObject object = getEncodingValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getEncodingHasTypeName() {
		COSObject object = getEncodingValue();
		return getHasTypeName(object);
	}

	@Override
	public String getEncodingNameValue() {
		COSObject object = getEncodingValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFirstChar() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FirstChar"));
	}

	public COSObject getFirstCharValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FirstChar"));
		return object;
	}

	@Override
	public Boolean getFirstCharHasTypeInteger() {
		COSObject object = getFirstCharValue();
		return getHasTypeInteger(object);
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
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsLastChar() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LastChar"));
	}

	public COSObject getLastCharValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LastChar"));
		return object;
	}

	@Override
	public Boolean getLastCharHasTypeInteger() {
		COSObject object = getLastCharValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object;
	}

	@Override
	public Boolean getNameHasTypeName() {
		COSObject object = getNameValue();
		return getHasTypeName(object);
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
		return getHasTypeStream(object);
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
	public Boolean getcontainsWidths() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Widths"));
	}

	public COSObject getWidthsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Widths"));
		return object;
	}

	@Override
	public Boolean getWidthsHasTypeArray() {
		COSObject object = getWidthsValue();
		return getHasTypeArray(object);
	}

}
