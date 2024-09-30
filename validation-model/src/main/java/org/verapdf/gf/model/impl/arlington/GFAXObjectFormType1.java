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

public class GFAXObjectFormType1 extends GFAObject implements AXObjectFormType1 {

	public GFAXObjectFormType1(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AXObjectFormType1");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AF":
				return getAF();
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
			case "Group":
				return getGroup();
			case "Measure":
				return getMeasure();
			case "Metadata":
				return getMetadata();
			case "OC":
				return getOC();
			case "OPI":
				return getOPI();
			case "PieceInfo":
				return getPieceInfo();
			case "PtData":
				return getPtData();
			case "Ref":
				return getRef();
			case "Resources":
				return getResources();
			case "XUID":
				return getXUID();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfFileSpecifications> getAF() {
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

	private List<AArrayOfFileSpecifications> getAF1_7() {
		COSObject object = getAFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "AF"));
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
			case ARLINGTON1_4:
				return getDecodeParms1_2();
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
			List<AFilterLZWDecode> list = new ArrayList<>(1);
			list.add(new GFAFilterLZWDecode((COSDictionary)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
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
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AFileSpecification> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_2() {
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
			case ARLINGTON1_4:
				return getFDecodeParms1_2();
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
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
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
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter() {
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

	private List<AArrayOfCompressionFilterNames> getFFilter1_2() {
		COSObject object = getFFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCompressionFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCompressionFilterNames((COSArray)object.getDirectBase(), this.baseObject, "FFilter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCompressionFilterNames> getFilter() {
		return getFilter1_0();
	}

	private List<AArrayOfCompressionFilterNames> getFilter1_0() {
		COSObject object = getFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCompressionFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCompressionFilterNames((COSArray)object.getDirectBase(), this.baseObject, "Filter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AGroupAttributes> getGroup() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGroup1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AGroupAttributes> getGroup1_4() {
		COSObject object = getGroupValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AGroupAttributes> list = new ArrayList<>(1);
			list.add(new GFAGroupAttributes((COSDictionary)object.getDirectBase(), this.baseObject, "Group"));
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

	private List<APagePiece> getPieceInfo() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPieceInfo1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<APagePiece> getPieceInfo1_3() {
		COSObject object = getPieceInfoValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APagePiece> list = new ArrayList<>(1);
			list.add(new GFAPagePiece((COSDictionary)object.getDirectBase(), this.baseObject, "PieceInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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

	private List<AReference> getRef() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRef1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AReference> getRef1_4() {
		COSObject object = getRefValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AReference> list = new ArrayList<>(1);
			list.add(new GFAReference((COSDictionary)object.getDirectBase(), this.baseObject, "Ref"));
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

	private List<AArrayOfIntegersGeneral> getXUID() {
		return getXUID1_0();
	}

	private List<AArrayOfIntegersGeneral> getXUID1_0() {
		COSObject object = getXUIDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfIntegersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfIntegersGeneral((COSArray)object.getDirectBase(), this.baseObject, "XUID"));
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
	public Boolean getcontainsBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BBox"));
	}

	public COSObject getBBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BBox"));
		return object;
	}

	@Override
	public String getBBoxType() {
		COSObject BBox = getBBoxValue();
		return getObjectType(BBox);
	}

	@Override
	public Boolean getBBoxHasTypeRectangle() {
		COSObject BBox = getBBoxValue();
		return getHasTypeRectangle(BBox);
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
	public Boolean getcontainsFormType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FormType"));
	}

	public COSObject getFormTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FormType"));
		return object;
	}

	@Override
	public String getFormTypeType() {
		COSObject FormType = getFormTypeValue();
		return getObjectType(FormType);
	}

	@Override
	public Boolean getFormTypeHasTypeInteger() {
		COSObject FormType = getFormTypeValue();
		return getHasTypeInteger(FormType);
	}

	@Override
	public Long getFormTypeIntegerValue() {
		COSObject FormType = getFormTypeValue();
		return getIntegerValue(FormType);
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
	public Boolean getcontainsGroup() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Group"));
	}

	public COSObject getGroupValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Group"));
		return object;
	}

	@Override
	public String getGroupType() {
		COSObject Group = getGroupValue();
		return getObjectType(Group);
	}

	@Override
	public Boolean getGroupHasTypeDictionary() {
		COSObject Group = getGroupValue();
		return getHasTypeDictionary(Group);
	}

	@Override
	public Boolean getcontainsLastModified() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LastModified"));
	}

	public COSObject getLastModifiedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LastModified"));
		return object;
	}

	@Override
	public String getLastModifiedType() {
		COSObject LastModified = getLastModifiedValue();
		return getObjectType(LastModified);
	}

	@Override
	public Boolean getLastModifiedHasTypeDate() {
		COSObject LastModified = getLastModifiedValue();
		return getHasTypeDate(LastModified);
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
	public Boolean getcontainsMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Matrix"));
	}

	public COSObject getMatrixDefaultValue() {
		return COSArray.construct(6, new double[]{1,0,0,1,0,0});
	}

	public COSObject getMatrixValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Matrix"));
		if (object == null || object.empty()) {
			object = getMatrixDefaultValue();
		}
		return object;
	}

	@Override
	public String getMatrixType() {
		COSObject Matrix = getMatrixValue();
		return getObjectType(Matrix);
	}

	@Override
	public Boolean getMatrixHasTypeMatrix() {
		COSObject Matrix = getMatrixValue();
		return getHasTypeMatrix(Matrix);
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
	public Boolean getcontainsPieceInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PieceInfo"));
	}

	public COSObject getPieceInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PieceInfo"));
		return object;
	}

	@Override
	public String getPieceInfoType() {
		COSObject PieceInfo = getPieceInfoValue();
		return getObjectType(PieceInfo);
	}

	@Override
	public Boolean getPieceInfoHasTypeDictionary() {
		COSObject PieceInfo = getPieceInfoValue();
		return getHasTypeDictionary(PieceInfo);
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
	public Boolean getcontainsRef() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ref"));
	}

	public COSObject getRefValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ref"));
		return object;
	}

	@Override
	public String getRefType() {
		COSObject Ref = getRefValue();
		return getObjectType(Ref);
	}

	@Override
	public Boolean getRefHasTypeDictionary() {
		COSObject Ref = getRefValue();
		return getHasTypeDictionary(Ref);
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
	public String getResourcesType() {
		COSObject Resources = getResourcesValue();
		return getObjectType(Resources);
	}

	@Override
	public Boolean getResourcesHasTypeDictionary() {
		COSObject Resources = getResourcesValue();
		return getHasTypeDictionary(Resources);
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
	public Boolean getcontainsStructParents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructParents"));
	}

	public COSObject getStructParentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructParents"));
		return object;
	}

	@Override
	public String getStructParentsType() {
		COSObject StructParents = getStructParentsValue();
		return getObjectType(StructParents);
	}

	@Override
	public Boolean getStructParentsHasTypeInteger() {
		COSObject StructParents = getStructParentsValue();
		return getHasTypeInteger(StructParents);
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
	public Boolean getcontainsXUID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XUID"));
	}

	public COSObject getXUIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XUID"));
		return object;
	}

	@Override
	public String getXUIDType() {
		COSObject XUID = getXUIDValue();
		return getObjectType(XUID);
	}

	@Override
	public Boolean getXUIDHasTypeArray() {
		COSObject XUID = getXUIDValue();
		return getHasTypeArray(XUID);
	}

}
