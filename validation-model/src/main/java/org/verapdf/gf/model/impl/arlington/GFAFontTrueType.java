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
		return getEncoding1_0();
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
		return getFontDescriptor1_0();
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

	private List<AToUnicodeCMapStream> getToUnicode() {
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

	private List<AToUnicodeCMapStream> getToUnicode1_2() {
		COSObject object = getToUnicodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AToUnicodeCMapStream> list = new ArrayList<>(1);
			list.add(new GFAToUnicodeCMapStream((COSStream)object.getDirectBase(), this.baseObject, "ToUnicode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getWidths() {
		return getWidths1_0();
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
	public String getBaseFontType() {
		COSObject BaseFont = getBaseFontValue();
		return getObjectType(BaseFont);
	}

	@Override
	public Boolean getBaseFontHasTypeName() {
		COSObject BaseFont = getBaseFontValue();
		return getHasTypeName(BaseFont);
	}

	@Override
	public String getBaseFontNameValue() {
		COSObject BaseFont = getBaseFontValue();
		return getNameValue(BaseFont);
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
	public String getEncodingType() {
		COSObject Encoding = getEncodingValue();
		return getObjectType(Encoding);
	}

	@Override
	public Boolean getEncodingHasTypeDictionary() {
		COSObject Encoding = getEncodingValue();
		return getHasTypeDictionary(Encoding);
	}

	@Override
	public Boolean getEncodingHasTypeName() {
		COSObject Encoding = getEncodingValue();
		return getHasTypeName(Encoding);
	}

	@Override
	public String getEncodingNameValue() {
		COSObject Encoding = getEncodingValue();
		return getNameValue(Encoding);
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
	public String getFirstCharType() {
		COSObject FirstChar = getFirstCharValue();
		return getObjectType(FirstChar);
	}

	@Override
	public Boolean getFirstCharHasTypeInteger() {
		COSObject FirstChar = getFirstCharValue();
		return getHasTypeInteger(FirstChar);
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
		COSObject FontDescriptor = getFontDescriptorValue();
		return getisIndirect(FontDescriptor);
	}

	@Override
	public String getFontDescriptorType() {
		COSObject FontDescriptor = getFontDescriptorValue();
		return getObjectType(FontDescriptor);
	}

	@Override
	public Boolean getFontDescriptorHasTypeDictionary() {
		COSObject FontDescriptor = getFontDescriptorValue();
		return getHasTypeDictionary(FontDescriptor);
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
	public String getLastCharType() {
		COSObject LastChar = getLastCharValue();
		return getObjectType(LastChar);
	}

	@Override
	public Boolean getLastCharHasTypeInteger() {
		COSObject LastChar = getLastCharValue();
		return getHasTypeInteger(LastChar);
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
	public String getNameType() {
		COSObject Name = getNameValue();
		return getObjectType(Name);
	}

	@Override
	public Boolean getNameHasTypeName() {
		COSObject Name = getNameValue();
		return getHasTypeName(Name);
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
	public Boolean getcontainsToUnicode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ToUnicode"));
	}

	public COSObject getToUnicodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ToUnicode"));
		return object;
	}

	@Override
	public Boolean getisToUnicodeIndirect() {
		COSObject ToUnicode = getToUnicodeValue();
		return getisIndirect(ToUnicode);
	}

	@Override
	public String getToUnicodeType() {
		COSObject ToUnicode = getToUnicodeValue();
		return getObjectType(ToUnicode);
	}

	@Override
	public Boolean getToUnicodeHasTypeStream() {
		COSObject ToUnicode = getToUnicodeValue();
		return getHasTypeStream(ToUnicode);
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
	public Boolean getcontainsWidths() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Widths"));
	}

	public COSObject getWidthsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Widths"));
		return object;
	}

	@Override
	public String getWidthsType() {
		COSObject Widths = getWidthsValue();
		return getObjectType(Widths);
	}

	@Override
	public Boolean getWidthsHasTypeArray() {
		COSObject Widths = getWidthsValue();
		return getHasTypeArray(Widths);
	}

}
