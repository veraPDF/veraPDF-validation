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

public class GFAXObjectImage extends GFAObject implements AXObjectImage {

	public GFAXObjectImage(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AXObjectImage");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AF":
				return getAF();
			case "Alternates":
				return getAlternates();
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
			case "Mask":
				return getMask();
			case "Measure":
				return getMeasure();
			case "Metadata":
				return getMetadata();
			case "OC":
				return getOC();
			case "OPI":
				return getOPI();
			case "PtData":
				return getPtData();
			case "SMask":
				return getSMask();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfAFFileSpecifications> getAF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionISO_19005_3() == true)) {
					return getAF1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getAF1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfAFFileSpecifications> getAF1_7() {
		COSObject object = getAFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfAFFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfAFFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfImageAlternates> getAlternates() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAlternates1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfImageAlternates> getAlternates1_3() {
		COSObject object = getAlternatesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfImageAlternates> list = new ArrayList<>(1);
			list.add(new GFAArrayOfImageAlternates((COSArray)object.getDirectBase(), this.baseObject, "Alternates"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
				return getColorSpace1_0();
			case ARLINGTON1_1:
				return getColorSpace1_1();
			case ARLINGTON1_2:
				return getColorSpace1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColorSpace1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace1_0() {
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

	private List<org.verapdf.model.baselayer.Object> getColorSpace1_1() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getColorSpaceArray1_1(object.getDirectBase(), "ColorSpace");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getColorSpaceArray1_1(COSBase base, String keyName) {
		if (base.size() <= 0) {
			return null;
		}
		COSObject subtype = base.at(0);
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			case "Indexed":
				return new GFAIndexedColorSpace(base, this.baseObject, keyName);
			case "Lab":
				return new GFALabColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace1_2() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getColorSpaceArray1_2(object.getDirectBase(), "ColorSpace");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getColorSpaceArray1_2(COSBase base, String keyName) {
		if (base.size() <= 0) {
			return null;
		}
		COSObject subtype = base.at(0);
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			case "Indexed":
				return new GFAIndexedColorSpace(base, this.baseObject, keyName);
			case "Lab":
				return new GFALabColorSpace(base, this.baseObject, keyName);
			case "Pattern":
				return new GFAPatternColorSpace(base, this.baseObject, keyName);
			case "Separation":
				return new GFASeparationColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace1_3() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getColorSpaceArray1_3(object.getDirectBase(), "ColorSpace");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getColorSpaceArray1_3(COSBase base, String keyName) {
		if (base.size() <= 0) {
			return null;
		}
		COSObject subtype = base.at(0);
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			case "DeviceN":
				return new GFADeviceNColorSpace(base, this.baseObject, keyName);
			case "ICCBased":
				return new GFAICCBasedColorSpace(base, this.baseObject, keyName);
			case "Indexed":
				return new GFAIndexedColorSpace(base, this.baseObject, keyName);
			case "Lab":
				return new GFALabColorSpace(base, this.baseObject, keyName);
			case "Pattern":
				return new GFAPatternColorSpace(base, this.baseObject, keyName);
			case "Separation":
				return new GFASeparationColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
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
			case ARLINGTON1_0:
			case ARLINGTON1_1:
				return getDecodeParms1_0();
			case ARLINGTON1_2:
			case ARLINGTON1_3:
				return getDecodeParms1_2();
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

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_0() {
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
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_0(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_0(COSBase base, String keyName) {
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
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_2() {
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
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_2(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_2(COSBase base, String keyName) {
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
			case ARLINGTON1_0:
				return getF1_0();
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_0() {
		COSObject object = getFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		return Collections.emptyList();
	}

	private List<AFileSpecification> getF1_1() {
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
			case ARLINGTON1_2:
			case ARLINGTON1_3:
				return getFDecodeParms1_2();
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

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_2() {
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
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_2(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_2(COSBase base, String keyName) {
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
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFFilter1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFilterNames> getFFilter1_2() {
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
		return getFilter1_0();
	}

	private List<AArrayOfFilterNames> getFilter1_0() {
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

	private List<org.verapdf.model.baselayer.Object> getMask() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMask1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getMask1_3() {
		COSObject object = getMaskValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfIntegersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfIntegersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Mask"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectImageMask> list = new ArrayList<>(1);
			list.add(new GFAXObjectImageMask((COSStream)object.getDirectBase(), this.baseObject, "Mask"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getMeasure() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getMeasure1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getMeasure1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getMeasure1_7() {
		COSObject object = getMeasureValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getMeasureDictionary1_7(object.getDirectBase(), "Measure");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getMeasureDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "GEO":
				return new GFAMeasureGEO(base, this.baseObject, keyName);
			case "RL":
				return new GFAMeasureRL(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AMetadata> getMetadata() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMetadata1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMetadata> getMetadata1_4() {
		COSObject object = getMetadataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AMetadata> list = new ArrayList<>(1);
			list.add(new GFAMetadata((COSStream)object.getDirectBase(), this.baseObject, "Metadata"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getOC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOC1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOC1_5() {
		COSObject object = getOCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOCDictionary1_5(object.getDirectBase(), "OC");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOCDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "OCG":
				return new GFAOptContentGroup(base, this.baseObject, keyName);
			case "OCMD":
				return new GFAOptContentMembership(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOPI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOPI1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOPI1_2() {
		COSObject object = getOPIValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOPIDictionary1_2(object.getDirectBase(), "OPI");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOPIDictionary1_2(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("1.3"))) {
			return new GFAOPIVersion13(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("2.0"))) {
			return new GFAOPIVersion20(base, this.baseObject, keyName);
		}
		return null;
	}

	private List<APointData> getPtData() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getPtData1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getPtData1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<APointData> getPtData1_7() {
		COSObject object = getPtDataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APointData> list = new ArrayList<>(1);
			list.add(new GFAPointData((COSDictionary)object.getDirectBase(), this.baseObject, "PtData"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXObjectImageSoftMask> getSMask() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSMask1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectImageSoftMask> getSMask1_4() {
		COSObject object = getSMaskValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectImageSoftMask> list = new ArrayList<>(1);
			list.add(new GFAXObjectImageSoftMask((COSStream)object.getDirectBase(), this.baseObject, "SMask"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AF"));
	}

	public COSObject getAFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		return object;
	}

	@Override
	public String getAFType() {
		COSObject AF = getAFValue();
		return getObjectType(AF);
	}

	@Override
	public Boolean getAFHasTypeArray() {
		COSObject AF = getAFValue();
		return getHasTypeArray(AF);
	}

	@Override
	public Boolean getcontainsAlternates() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Alternates"));
	}

	public COSObject getAlternatesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Alternates"));
		return object;
	}

	@Override
	public String getAlternatesType() {
		COSObject Alternates = getAlternatesValue();
		return getObjectType(Alternates);
	}

	@Override
	public Boolean getAlternatesHasTypeArray() {
		COSObject Alternates = getAlternatesValue();
		return getHasTypeArray(Alternates);
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
	public String getFilterEntriesString() {
		COSObject Filter = getFilterValue();
		return getEntriesString(Filter);
	}

	@Override
	public Boolean getcontainsGTS_Encapsulated() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_Encapsulated"));
	}

	public COSObject getGTS_EncapsulatedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_Encapsulated"));
		return object;
	}

	@Override
	public String getGTS_EncapsulatedType() {
		COSObject GTS_Encapsulated = getGTS_EncapsulatedValue();
		return getObjectType(GTS_Encapsulated);
	}

	@Override
	public Boolean getGTS_EncapsulatedHasTypeBoolean() {
		COSObject GTS_Encapsulated = getGTS_EncapsulatedValue();
		return getHasTypeBoolean(GTS_Encapsulated);
	}

	@Override
	public Boolean getcontainsGTS_Env() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_Env"));
	}

	public COSObject getGTS_EnvValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_Env"));
		return object;
	}

	@Override
	public String getGTS_EnvType() {
		COSObject GTS_Env = getGTS_EnvValue();
		return getObjectType(GTS_Env);
	}

	@Override
	public Boolean getGTS_EnvHasTypeStringText() {
		COSObject GTS_Env = getGTS_EnvValue();
		return getHasTypeStringText(GTS_Env);
	}

	@Override
	public Boolean getcontainsGTS_Scope() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_Scope"));
	}

	public COSObject getGTS_ScopeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_Scope"));
		return object;
	}

	@Override
	public String getGTS_ScopeType() {
		COSObject GTS_Scope = getGTS_ScopeValue();
		return getObjectType(GTS_Scope);
	}

	@Override
	public Boolean getGTS_ScopeHasTypeName() {
		COSObject GTS_Scope = getGTS_ScopeValue();
		return getHasTypeName(GTS_Scope);
	}

	@Override
	public String getGTS_ScopeNameValue() {
		COSObject GTS_Scope = getGTS_ScopeValue();
		return getNameValue(GTS_Scope);
	}

	@Override
	public Boolean getcontainsGTS_XID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_XID"));
	}

	public COSObject getGTS_XIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_XID"));
		return object;
	}

	@Override
	public String getGTS_XIDType() {
		COSObject GTS_XID = getGTS_XIDValue();
		return getObjectType(GTS_XID);
	}

	@Override
	public Boolean getGTS_XIDHasTypeString() {
		COSObject GTS_XID = getGTS_XIDValue();
		return getHasTypeString(GTS_XID);
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
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	public COSObject getentryIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object;
	}

	@Override
	public String getentryIDType() {
		COSObject entryID = getentryIDValue();
		return getObjectType(entryID);
	}

	@Override
	public Boolean getentryIDHasTypeStringByte() {
		COSObject entryID = getentryIDValue();
		return getHasTypeStringByte(entryID);
	}

	@Override
	public Boolean getcontainsImageMask() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ImageMask"));
	}

	public COSObject getImageMaskDefaultValue() {
		return COSBoolean.construct(false);
	}

	public COSObject getImageMaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ImageMask"));
		if (object == null || object.empty()) {
			object = getImageMaskDefaultValue();
		}
		return object;
	}

	@Override
	public String getImageMaskType() {
		COSObject ImageMask = getImageMaskValue();
		return getObjectType(ImageMask);
	}

	@Override
	public Boolean getImageMaskHasTypeBoolean() {
		COSObject ImageMask = getImageMaskValue();
		return getHasTypeBoolean(ImageMask);
	}

	@Override
	public Boolean getImageMaskBooleanValue() {
		COSObject ImageMask = getImageMaskValue();
		return getBooleanValue(ImageMask);
	}

	@Override
	public Boolean getcontainsIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Intent"));
	}

	public COSObject getIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Intent"));
		return object;
	}

	@Override
	public String getIntentType() {
		COSObject Intent = getIntentValue();
		return getObjectType(Intent);
	}

	@Override
	public Boolean getIntentHasTypeName() {
		COSObject Intent = getIntentValue();
		return getHasTypeName(Intent);
	}

	@Override
	public Boolean getcontainsInterpolate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Interpolate"));
	}

	public COSObject getInterpolateDefaultValue() {
		return COSBoolean.construct(false);
	}

	public COSObject getInterpolateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Interpolate"));
		if (object == null || object.empty()) {
			object = getInterpolateDefaultValue();
		}
		return object;
	}

	@Override
	public String getInterpolateType() {
		COSObject Interpolate = getInterpolateValue();
		return getObjectType(Interpolate);
	}

	@Override
	public Boolean getInterpolateHasTypeBoolean() {
		COSObject Interpolate = getInterpolateValue();
		return getHasTypeBoolean(Interpolate);
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
	public Boolean getcontainsMask() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Mask"));
	}

	public COSObject getMaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mask"));
		return object;
	}

	@Override
	public Boolean getisMaskIndirect() {
		COSObject Mask = getMaskValue();
		return getisIndirect(Mask);
	}

	@Override
	public String getMaskType() {
		COSObject Mask = getMaskValue();
		return getObjectType(Mask);
	}

	@Override
	public Boolean getMaskHasTypeArray() {
		COSObject Mask = getMaskValue();
		return getHasTypeArray(Mask);
	}

	@Override
	public Boolean getMaskHasTypeStream() {
		COSObject Mask = getMaskValue();
		return getHasTypeStream(Mask);
	}

	@Override
	public Boolean getcontainsMeasure() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Measure"));
	}

	public COSObject getMeasureValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Measure"));
		return object;
	}

	@Override
	public String getMeasureType() {
		COSObject Measure = getMeasureValue();
		return getObjectType(Measure);
	}

	@Override
	public Boolean getMeasureHasTypeDictionary() {
		COSObject Measure = getMeasureValue();
		return getHasTypeDictionary(Measure);
	}

	@Override
	public Boolean getcontainsMetadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Metadata"));
	}

	public COSObject getMetadataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
		return object;
	}

	@Override
	public Boolean getisMetadataIndirect() {
		COSObject Metadata = getMetadataValue();
		return getisIndirect(Metadata);
	}

	@Override
	public String getMetadataType() {
		COSObject Metadata = getMetadataValue();
		return getObjectType(Metadata);
	}

	@Override
	public Boolean getMetadataHasTypeStream() {
		COSObject Metadata = getMetadataValue();
		return getHasTypeStream(Metadata);
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
	public Boolean getcontainsOC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OC"));
	}

	public COSObject getOCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OC"));
		return object;
	}

	@Override
	public String getOCType() {
		COSObject OC = getOCValue();
		return getObjectType(OC);
	}

	@Override
	public Boolean getOCHasTypeDictionary() {
		COSObject OC = getOCValue();
		return getHasTypeDictionary(OC);
	}

	@Override
	public Boolean getcontainsOPI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OPI"));
	}

	public COSObject getOPIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OPI"));
		return object;
	}

	@Override
	public String getOPIType() {
		COSObject OPI = getOPIValue();
		return getObjectType(OPI);
	}

	@Override
	public Boolean getOPIHasTypeDictionary() {
		COSObject OPI = getOPIValue();
		return getHasTypeDictionary(OPI);
	}

	@Override
	public Boolean getcontainsPtData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PtData"));
	}

	public COSObject getPtDataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PtData"));
		return object;
	}

	@Override
	public String getPtDataType() {
		COSObject PtData = getPtDataValue();
		return getObjectType(PtData);
	}

	@Override
	public Boolean getPtDataHasTypeDictionary() {
		COSObject PtData = getPtDataValue();
		return getHasTypeDictionary(PtData);
	}

	@Override
	public Boolean getcontainsSMask() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SMask"));
	}

	public COSObject getSMaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SMask"));
		return object;
	}

	@Override
	public Boolean getisSMaskIndirect() {
		COSObject SMask = getSMaskValue();
		return getisIndirect(SMask);
	}

	@Override
	public String getSMaskType() {
		COSObject SMask = getSMaskValue();
		return getObjectType(SMask);
	}

	@Override
	public Boolean getSMaskHasTypeStream() {
		COSObject SMask = getSMaskValue();
		return getHasTypeStream(SMask);
	}

	@Override
	public Boolean getcontainsSMaskInData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SMaskInData"));
	}

	public COSObject getSMaskInDataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SMaskInData"));
		return object;
	}

	@Override
	public String getSMaskInDataType() {
		COSObject SMaskInData = getSMaskInDataValue();
		return getObjectType(SMaskInData);
	}

	@Override
	public Boolean getSMaskInDataHasTypeInteger() {
		COSObject SMaskInData = getSMaskInDataValue();
		return getHasTypeInteger(SMaskInData);
	}

	@Override
	public Long getSMaskInDataIntegerValue() {
		COSObject SMaskInData = getSMaskInDataValue();
		return getIntegerValue(SMaskInData);
	}

	@Override
	public Boolean getcontainsStructParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructParent"));
	}

	public COSObject getStructParentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructParent"));
		return object;
	}

	@Override
	public String getStructParentType() {
		COSObject StructParent = getStructParentValue();
		return getObjectType(StructParent);
	}

	@Override
	public Boolean getStructParentHasTypeInteger() {
		COSObject StructParent = getStructParentValue();
		return getHasTypeInteger(StructParent);
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

	@Override
	public Boolean getimageIsStructContentItem() {
		return getimageIsStructContentItem(new COSObject(this.baseObject));
	}

}
