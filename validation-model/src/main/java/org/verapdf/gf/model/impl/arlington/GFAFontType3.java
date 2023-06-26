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

public class GFAFontType3 extends GFAObject implements AFontType3 {

	public GFAFontType3(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFontType3");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CharProcs":
				return getCharProcs();
			case "Encoding":
				return getEncoding();
			case "FontDescriptor":
				return getFontDescriptor();
			case "Resources":
				return getResources();
			case "ToUnicode":
				return getToUnicode();
			case "Widths":
				return getWidths();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACharProcMap> getCharProcs() {
		return getCharProcs1_0();
	}

	private List<ACharProcMap> getCharProcs1_0() {
		COSObject object = getCharProcsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACharProcMap> list = new ArrayList<>(1);
			list.add(new GFACharProcMap((COSDictionary)object.getDirectBase(), this.baseObject, "CharProcs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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

	private List<AFontDescriptorType3> getFontDescriptor() {
		return getFontDescriptor1_0();
	}

	private List<AFontDescriptorType3> getFontDescriptor1_0() {
		COSObject object = getFontDescriptorValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFontDescriptorType3> list = new ArrayList<>(1);
			list.add(new GFAFontDescriptorType3((COSDictionary)object.getDirectBase(), this.baseObject, "FontDescriptor"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AResource> getResources() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResources1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AResource> getResources1_2() {
		COSObject object = getResourcesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AResource> list = new ArrayList<>(1);
			list.add(new GFAResource((COSDictionary)object.getDirectBase(), this.baseObject, "Resources"));
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
	public Boolean getcontainsCharProcs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CharProcs"));
	}

	public COSObject getCharProcsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CharProcs"));
		return object;
	}

	@Override
	public Boolean getCharProcsHasTypeDictionary() {
		COSObject object = getCharProcsValue();
		return getHasTypeDictionary(object);
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
	public Long getFirstCharIntegerValue() {
		COSObject object = getFirstCharValue();
		return getIntegerValue(object);
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
		return getisIndirect(object);
	}

	@Override
	public Boolean getFontDescriptorHasTypeDictionary() {
		COSObject object = getFontDescriptorValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsFontMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FontMatrix"));
	}

	public COSObject getFontMatrixValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FontMatrix"));
		return object;
	}

	@Override
	public Boolean getFontMatrixHasTypeMatrix() {
		COSObject object = getFontMatrixValue();
		return getHasTypeMatrix(object);
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
	public Long getLastCharIntegerValue() {
		COSObject object = getLastCharValue();
		return getIntegerValue(object);
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
	public String getNameNameValue() {
		COSObject object = getNameValue();
		return getNameValue(object);
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object;
	}

	@Override
	public Boolean getResourcesHasTypeDictionary() {
		COSObject object = getResourcesValue();
		return getHasTypeDictionary(object);
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
		return getNameValue(object);
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
		return getisIndirect(object);
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
		return getNameValue(object);
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

	@Override
	public Long getWidthsArraySize() {
		COSObject object = getWidthsValue();
		return getArraySize(object);
	}

}
