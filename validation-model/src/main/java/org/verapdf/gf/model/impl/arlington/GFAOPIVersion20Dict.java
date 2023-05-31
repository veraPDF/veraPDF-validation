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

public class GFAOPIVersion20Dict extends GFAObject implements AOPIVersion20Dict {

	public GFAOPIVersion20Dict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOPIVersion20Dict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "F":
				return getF();
			case "IncludedImageDimensions":
				return getIncludedImageDimensions();
			case "Inks":
				return getInks();
			case "Size":
				return getSize();
			case "Tags":
				return getTags();
			default:
				return super.getLinkedObjects(link);
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

	private List<AArrayOf_2Integers> getIncludedImageDimensions() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIncludedImageDimensions1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Integers> getIncludedImageDimensions1_2() {
		COSObject object = getIncludedImageDimensionsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Integers((COSArray)object.getDirectBase(), this.baseObject, "IncludedImageDimensions"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOPI2Inks> getInks() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getInks1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOPI2Inks> getInks1_2() {
		COSObject object = getInksValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOPI2Inks> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOPI2Inks((COSArray)object.getDirectBase(), this.baseObject, "Inks"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Numbers> getSize() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSize1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getSize1_2() {
		COSObject object = getSizeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "Size"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfTags> getTags() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTags1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfTags> getTags1_2() {
		COSObject object = getTagsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfTags> list = new ArrayList<>(1);
			list.add(new GFAArrayOfTags((COSArray)object.getDirectBase(), this.baseObject, "Tags"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCropRect() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CropRect"));
	}

	public COSObject getCropRectValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropRect"));
		return object;
	}

	@Override
	public Boolean getCropRectHasTypeRectangle() {
		COSObject object = getCropRectValue();
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
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object;
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsIncludedImageDimensions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IncludedImageDimensions"));
	}

	public COSObject getIncludedImageDimensionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IncludedImageDimensions"));
		return object;
	}

	@Override
	public Boolean getIncludedImageDimensionsHasTypeArray() {
		COSObject object = getIncludedImageDimensionsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsIncludedImageQuality() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IncludedImageQuality"));
	}

	public COSObject getIncludedImageQualityValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IncludedImageQuality"));
		return object;
	}

	@Override
	public Boolean getIncludedImageQualityHasTypeNumber() {
		COSObject object = getIncludedImageQualityValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getIncludedImageQualityNumberValue() {
		COSObject object = getIncludedImageQualityValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsInks() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Inks"));
	}

	public COSObject getInksValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Inks"));
		return object;
	}

	@Override
	public Boolean getInksHasTypeArray() {
		COSObject object = getInksValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getInksHasTypeName() {
		COSObject object = getInksValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getInksNameValue() {
		COSObject object = getInksValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsMainImage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MainImage"));
	}

	public COSObject getMainImageValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MainImage"));
		return object;
	}

	@Override
	public Boolean getMainImageHasTypeStringByte() {
		COSObject object = getMainImageValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsOverprint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Overprint"));
	}

	public COSObject getOverprintValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Overprint"));
		return object;
	}

	@Override
	public Boolean getOverprintHasTypeBoolean() {
		COSObject object = getOverprintValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsSize() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Size"));
	}

	public COSObject getSizeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		return object;
	}

	@Override
	public Boolean getSizeHasTypeArray() {
		COSObject object = getSizeValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsTags() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Tags"));
	}

	public COSObject getTagsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Tags"));
		return object;
	}

	@Override
	public Boolean getTagsHasTypeArray() {
		COSObject object = getTagsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	public COSObject getVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object;
	}

	@Override
	public Boolean getVersionHasTypeNumber() {
		COSObject object = getVersionValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getVersionNumberValue() {
		COSObject object = getVersionValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Long getIncludedImageDimensions1IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject IncludedImageDimensions = this.baseObject.getKey(ASAtom.getASAtom("IncludedImageDimensions"));
		if (IncludedImageDimensions == null || IncludedImageDimensions.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (IncludedImageDimensions.size() <= 1) {
			return null;
		}
		COSObject entry1 = IncludedImageDimensions.at(1);
		return new GFAArrayOf_2Integers(IncludedImageDimensions.getDirectBase(), null, null).getentry1IntegerValue();
	}

	@Override
	public Double getSize0NumberValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Size = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		if (Size == null || Size.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (Size.size() <= 0) {
			return null;
		}
		COSObject entry0 = Size.at(0);
		return new GFAArrayOf_2Numbers(Size.getDirectBase(), null, null).getentry0NumberValue();
	}

	@Override
	public Long getIncludedImageDimensions0IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject IncludedImageDimensions = this.baseObject.getKey(ASAtom.getASAtom("IncludedImageDimensions"));
		if (IncludedImageDimensions == null || IncludedImageDimensions.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (IncludedImageDimensions.size() <= 0) {
			return null;
		}
		COSObject entry0 = IncludedImageDimensions.at(0);
		return new GFAArrayOf_2Integers(IncludedImageDimensions.getDirectBase(), null, null).getentry0IntegerValue();
	}

	@Override
	public Double getSize1NumberValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Size = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		if (Size == null || Size.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (Size.size() <= 1) {
			return null;
		}
		COSObject entry1 = Size.at(1);
		return new GFAArrayOf_2Numbers(Size.getDirectBase(), null, null).getentry1NumberValue();
	}

	@Override
	public Boolean getIncludedImageDimensions1HasTypeInteger() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject IncludedImageDimensions = this.baseObject.getKey(ASAtom.getASAtom("IncludedImageDimensions"));
		if (IncludedImageDimensions == null || IncludedImageDimensions.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (IncludedImageDimensions.size() <= 1) {
			return null;
		}
		COSObject entry1 = IncludedImageDimensions.at(1);
		return new GFAArrayOf_2Integers(IncludedImageDimensions.getDirectBase(), null, null).getentry1HasTypeInteger();
	}

	@Override
	public Boolean getSize0HasTypeNumber() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Size = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		if (Size == null || Size.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (Size.size() <= 0) {
			return null;
		}
		COSObject entry0 = Size.at(0);
		return new GFAArrayOf_2Numbers(Size.getDirectBase(), null, null).getentry0HasTypeNumber();
	}

	@Override
	public Boolean getIncludedImageDimensions0HasTypeInteger() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject IncludedImageDimensions = this.baseObject.getKey(ASAtom.getASAtom("IncludedImageDimensions"));
		if (IncludedImageDimensions == null || IncludedImageDimensions.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (IncludedImageDimensions.size() <= 0) {
			return null;
		}
		COSObject entry0 = IncludedImageDimensions.at(0);
		return new GFAArrayOf_2Integers(IncludedImageDimensions.getDirectBase(), null, null).getentry0HasTypeInteger();
	}

	@Override
	public Boolean getSize1HasTypeNumber() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Size = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		if (Size == null || Size.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (Size.size() <= 1) {
			return null;
		}
		COSObject entry1 = Size.at(1);
		return new GFAArrayOf_2Numbers(Size.getDirectBase(), null, null).getentry1HasTypeNumber();
	}

}
