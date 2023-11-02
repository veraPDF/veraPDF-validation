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

public class GFAThumbnail extends GFAObject implements AThumbnail {

	public GFAThumbnail(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AThumbnail");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ColorSpace":
				return getColorSpace();
			case "Decode":
				return getDecode();
			case "DecodeParms":
				return getDecodeParms();
			case "F":
				return getF();
			case "FDecodeParms":
				return getFDecodeParms();
			case "FFilter":
				return getFFilter();
			case "Filter":
				return getFilter();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AIndexedColorSpace> getColorSpace() {
		return getColorSpace1_0();
	}

	private List<AIndexedColorSpace> getColorSpace1_0() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AIndexedColorSpace> list = new ArrayList<>(1);
			list.add(new GFAIndexedColorSpace((COSArray)object.getDirectBase(), this.baseObject, "ColorSpace"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getDecode() {
		return getDecode1_0();
	}

	private List<AArrayOfNumbersGeneral> getDecode1_0() {
		COSObject object = getDecodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Decode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
				return getDecodeParms1_3();
			case ARLINGTON1_4:
				return getDecodeParms1_4();
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_3() {
		COSObject object = getDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_3(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CCITTFaxDecode":
				return new GFAFilterCCITTFaxDecode(base, this.baseObject, keyName);
			case "DCTDecode":
				return new GFAFilterDCTDecode(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_4() {
		COSObject object = getDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_4(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_4(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CCITTFaxDecode":
				return new GFAFilterCCITTFaxDecode(base, this.baseObject, keyName);
			case "DCTDecode":
				return new GFAFilterDCTDecode(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "JBIG2Decode":
				return new GFAFilterJBIG2Decode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_5() {
		COSObject object = getDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_5(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CCITTFaxDecode":
				return new GFAFilterCCITTFaxDecode(base, this.baseObject, keyName);
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "DCTDecode":
				return new GFAFilterDCTDecode(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "JBIG2Decode":
				return new GFAFilterJBIG2Decode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AFileSpecification> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_3() {
		COSObject object = getFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "F"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
				return getFDecodeParms1_3();
			case ARLINGTON1_4:
				return getFDecodeParms1_4();
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_3() {
		COSObject object = getFDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "FDecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_3(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CCITTFaxDecode":
				return new GFAFilterCCITTFaxDecode(base, this.baseObject, keyName);
			case "DCTDecode":
				return new GFAFilterDCTDecode(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_4() {
		COSObject object = getFDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "FDecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_4(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_4(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CCITTFaxDecode":
				return new GFAFilterCCITTFaxDecode(base, this.baseObject, keyName);
			case "DCTDecode":
				return new GFAFilterDCTDecode(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "JBIG2Decode":
				return new GFAFilterJBIG2Decode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_5() {
		COSObject object = getFDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "FDecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_5(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CCITTFaxDecode":
				return new GFAFilterCCITTFaxDecode(base, this.baseObject, keyName);
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "DCTDecode":
				return new GFAFilterDCTDecode(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "JBIG2Decode":
				return new GFAFilterJBIG2Decode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfFilterNames> getFFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFFilter1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFilterNames> getFFilter1_3() {
		COSObject object = getFFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFilterNames((COSArray)object.getDirectBase(), this.baseObject, "FFilter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfFilterNames> getFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFilterNames> getFilter1_3() {
		COSObject object = getFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFilterNames((COSArray)object.getDirectBase(), this.baseObject, "Filter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBitsPerComponent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BitsPerComponent"));
	}

	public COSObject getBitsPerComponentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BitsPerComponent"));
		return object;
	}

	@Override
	public String getBitsPerComponentType() {
		COSObject BitsPerComponent = getBitsPerComponentValue();
		return getObjectType(BitsPerComponent);
	}

	@Override
	public Boolean getBitsPerComponentHasTypeInteger() {
		COSObject BitsPerComponent = getBitsPerComponentValue();
		return getHasTypeInteger(BitsPerComponent);
	}

	@Override
	public Long getBitsPerComponentIntegerValue() {
		COSObject BitsPerComponent = getBitsPerComponentValue();
		return getIntegerValue(BitsPerComponent);
	}

	@Override
	public Boolean getcontainsColorSpace() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorSpace"));
	}

	public COSObject getColorSpaceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorSpace"));
		return object;
	}

	@Override
	public String getColorSpaceType() {
		COSObject ColorSpace = getColorSpaceValue();
		return getObjectType(ColorSpace);
	}

	@Override
	public Boolean getColorSpaceHasTypeArray() {
		COSObject ColorSpace = getColorSpaceValue();
		return getHasTypeArray(ColorSpace);
	}

	@Override
	public Boolean getColorSpaceHasTypeName() {
		COSObject ColorSpace = getColorSpaceValue();
		return getHasTypeName(ColorSpace);
	}

	@Override
	public String getColorSpaceNameValue() {
		COSObject ColorSpace = getColorSpaceValue();
		return getNameValue(ColorSpace);
	}

	@Override
	public Boolean getcontainsDL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DL"));
	}

	public COSObject getDLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DL"));
		return object;
	}

	@Override
	public String getDLType() {
		COSObject DL = getDLValue();
		return getObjectType(DL);
	}

	@Override
	public Boolean getDLHasTypeInteger() {
		COSObject DL = getDLValue();
		return getHasTypeInteger(DL);
	}

	@Override
	public Long getDLIntegerValue() {
		COSObject DL = getDLValue();
		return getIntegerValue(DL);
	}

	@Override
	public Boolean getcontainsDecode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Decode"));
	}

	public COSObject getDecodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Decode"));
		return object;
	}

	@Override
	public String getDecodeType() {
		COSObject Decode = getDecodeValue();
		return getObjectType(Decode);
	}

	@Override
	public Boolean getDecodeHasTypeArray() {
		COSObject Decode = getDecodeValue();
		return getHasTypeArray(Decode);
	}

	@Override
	public Boolean getcontainsDecodeParms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DecodeParms"));
	}

	public COSObject getDecodeParmsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
		return object;
	}

	@Override
	public String getDecodeParmsType() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getObjectType(DecodeParms);
	}

	@Override
	public Boolean getDecodeParmsHasTypeArray() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getHasTypeArray(DecodeParms);
	}

	@Override
	public Boolean getDecodeParmsHasTypeDictionary() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getHasTypeDictionary(DecodeParms);
	}

	@Override
	public Long getDecodeParmsArraySize() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getArraySize(DecodeParms);
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object;
	}

	@Override
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject F = getFValue();
		return getHasTypeDictionary(F);
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject F = getFValue();
		return getHasTypeString(F);
	}

	@Override
	public Boolean getcontainsFDecodeParms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FDecodeParms"));
	}

	public COSObject getFDecodeParmsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
		return object;
	}

	@Override
	public String getFDecodeParmsType() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getObjectType(FDecodeParms);
	}

	@Override
	public Boolean getFDecodeParmsHasTypeArray() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getHasTypeArray(FDecodeParms);
	}

	@Override
	public Boolean getFDecodeParmsHasTypeDictionary() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getHasTypeDictionary(FDecodeParms);
	}

	@Override
	public Long getFDecodeParmsArraySize() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getArraySize(FDecodeParms);
	}

	@Override
	public Boolean getcontainsFFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FFilter"));
	}

	public COSObject getFFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		return object;
	}

	@Override
	public String getFFilterType() {
		COSObject FFilter = getFFilterValue();
		return getObjectType(FFilter);
	}

	@Override
	public Boolean getFFilterHasTypeArray() {
		COSObject FFilter = getFFilterValue();
		return getHasTypeArray(FFilter);
	}

	@Override
	public Boolean getFFilterHasTypeName() {
		COSObject FFilter = getFFilterValue();
		return getHasTypeName(FFilter);
	}

	@Override
	public String getFFilterNameValue() {
		COSObject FFilter = getFFilterValue();
		return getNameValue(FFilter);
	}

	@Override
	public Long getFFilterArraySize() {
		COSObject FFilter = getFFilterValue();
		return getArraySize(FFilter);
	}

	@Override
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	public COSObject getFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object;
	}

	@Override
	public String getFilterType() {
		COSObject Filter = getFilterValue();
		return getObjectType(Filter);
	}

	@Override
	public Boolean getFilterHasTypeArray() {
		COSObject Filter = getFilterValue();
		return getHasTypeArray(Filter);
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject Filter = getFilterValue();
		return getHasTypeName(Filter);
	}

	@Override
	public String getFilterNameValue() {
		COSObject Filter = getFilterValue();
		return getNameValue(Filter);
	}

	@Override
	public Long getFilterArraySize() {
		COSObject Filter = getFilterValue();
		return getArraySize(Filter);
	}

	@Override
	public Boolean getcontainsHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Height"));
	}

	public COSObject getHeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		return object;
	}

	@Override
	public String getHeightType() {
		COSObject Height = getHeightValue();
		return getObjectType(Height);
	}

	@Override
	public Boolean getHeightHasTypeInteger() {
		COSObject Height = getHeightValue();
		return getHasTypeInteger(Height);
	}

	@Override
	public Boolean getcontainsLength() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Length"));
	}

	public COSObject getLengthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
		return object;
	}

	@Override
	public String getLengthType() {
		COSObject Length = getLengthValue();
		return getObjectType(Length);
	}

	@Override
	public Boolean getLengthHasTypeInteger() {
		COSObject Length = getLengthValue();
		return getHasTypeInteger(Length);
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
	public Boolean getcontainsWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Width"));
	}

	public COSObject getWidthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		return object;
	}

	@Override
	public String getWidthType() {
		COSObject Width = getWidthValue();
		return getObjectType(Width);
	}

	@Override
	public Boolean getWidthHasTypeInteger() {
		COSObject Width = getWidthValue();
		return getHasTypeInteger(Width);
	}

}
