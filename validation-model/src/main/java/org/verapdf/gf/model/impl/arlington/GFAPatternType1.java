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

public class GFAPatternType1 extends GFAObject implements APatternType1 {

	public GFAPatternType1(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APatternType1");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
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
			case "Resources":
				return getResources();
			case "XUID":
				return getXUID();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms() {
		switch(StaticContainers.getFlavour()) {
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

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
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
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
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
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AFileSpecification> getF() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
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
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
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
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFilter1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
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

	private List<AResource> getResources() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getXUID1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfIntegersGeneral> getXUID1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XUID"));
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
	public Boolean getcontainsBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BBox"));
	}

	@Override
	public Boolean getBBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BBox"));
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
	public Boolean getcontainsDL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DL"));
	}

	@Override
	public Boolean getDLHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DL"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDLIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DL"));
		if (object == null || object.empty()) {
			return getDLIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDLIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDecodeParms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DecodeParms"));
	}

	@Override
	public Boolean getDecodeParmsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getDecodeParmsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Long getDecodeParmsArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsFDecodeParms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FDecodeParms"));
	}

	@Override
	public Boolean getFDecodeParmsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getFDecodeParmsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Long getFDecodeParmsArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FFilter"));
	}

	@Override
	public Boolean getFFilterHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getFFilterHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFFilterNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		if (object == null || object.empty()) {
			return getFFilterNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFFilterNameDefaultValue() {
		return null;
	}

	@Override
	public Long getFFilterArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	@Override
	public Boolean getFilterHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFilterNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (object == null || object.empty()) {
			return getFilterNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFilterNameDefaultValue() {
		return null;
	}

	@Override
	public Long getFilterArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsLength() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Length"));
	}

	@Override
	public Boolean getLengthHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Matrix"));
	}

	@Override
	public Boolean getMatrixHasTypeMatrix() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Matrix"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 6) {
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
	public Boolean getcontainsPaintType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PaintType"));
	}

	@Override
	public Boolean getPaintTypeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PaintType"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPaintTypeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PaintType"));
		if (object == null || object.empty()) {
			return getPaintTypeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getPaintTypeIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsPatternType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PatternType"));
	}

	@Override
	public Boolean getPatternTypeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PatternType"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPatternTypeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PatternType"));
		if (object == null || object.empty()) {
			return getPatternTypeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getPatternTypeIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	@Override
	public Boolean getResourcesHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsTilingType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TilingType"));
	}

	@Override
	public Boolean getTilingTypeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TilingType"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getTilingTypeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TilingType"));
		if (object == null || object.empty()) {
			return getTilingTypeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getTilingTypeIntegerDefaultValue() {
		return null;
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
	public Boolean getcontainsXStep() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XStep"));
	}

	@Override
	public Boolean getXStepHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XStep"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsXUID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XUID"));
	}

	@Override
	public Boolean getXUIDHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XUID"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsYStep() {
		return this.baseObject.knownKey(ASAtom.getASAtom("YStep"));
	}

	@Override
	public Boolean getYStepHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("YStep"));
		return object != null && object.getType().isNumber();
	}

}
