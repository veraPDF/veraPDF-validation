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

public class GFAOPIVersion13Dict extends GFAObject implements AOPIVersion13Dict {

	public GFAOPIVersion13Dict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOPIVersion13Dict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Position":
				return getPosition();
			case "Size":
				return getSize();
			case "F":
				return getF();
			case "Color":
				return getColor();
			case "GrayMap":
				return getGrayMap();
			case "CropFixed":
				return getCropFixed();
			case "Tags":
				return getTags();
			case "ImageType":
				return getImageType();
			case "Resolution":
				return getResolution();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_8Numbers> getPosition() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPosition1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_8Numbers> getPosition1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_8Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_8Numbers((COSArray)object.getDirectBase(), this.baseObject, "Position"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Integers> getSize() {
		switch(StaticContainers.getFlavour()) {
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

	private List<AArrayOf_2Integers> getSize1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Integers((COSArray)object.getDirectBase(), this.baseObject, "Size"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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

	private List<AArrayOfOPI13Color> getColor() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColor1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOPI13Color> getColor1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Color"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOPI13Color> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOPI13Color((COSArray)object.getDirectBase(), this.baseObject, "Color"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfIntegersGeneral> getGrayMap() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGrayMap1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfIntegersGeneral> getGrayMap1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GrayMap"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfIntegersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfIntegersGeneral((COSArray)object.getDirectBase(), this.baseObject, "GrayMap"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4Numbers> getCropFixed() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCropFixed1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4Numbers> getCropFixed1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropFixed"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4Numbers((COSArray)object.getDirectBase(), this.baseObject, "CropFixed"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfTags> getTags() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Tags"));
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

	private List<AArrayOf_2Integers> getImageType() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getImageType1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Integers> getImageType1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ImageType"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Integers((COSArray)object.getDirectBase(), this.baseObject, "ImageType"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Numbers> getResolution() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResolution1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getResolution1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resolution"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "Resolution"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsResolution() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resolution"));
	}

	@Override
	public Boolean getResolutionHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resolution"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsTags() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Tags"));
	}

	@Override
	public Boolean getTagsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Tags"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsTint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Tint"));
	}

	@Override
	public Boolean getTintHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Tint"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTransparency() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Transparency"));
	}

	@Override
	public Boolean getTransparencyHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Transparency"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsSize() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Size"));
	}

	@Override
	public Boolean getSizeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	@Override
	public Boolean getVersionHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getVersionNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		if (object == null || object.empty()) {
			return getVersionNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getVersionNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsOverprint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Overprint"));
	}

	@Override
	public Boolean getOverprintHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Overprint"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Position"));
	}

	@Override
	public Boolean getPositionHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getcontainsComments() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Comments"));
	}

	@Override
	public Boolean getCommentsHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Comments"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsCropRect() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CropRect"));
	}

	@Override
	public Boolean getCropRectHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropRect"));
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
	public Boolean getcontainsImageType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ImageType"));
	}

	@Override
	public Boolean getImageTypeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ImageType"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsColorType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorType"));
	}

	@Override
	public Boolean getColorTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorType"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsCropFixed() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CropFixed"));
	}

	@Override
	public Boolean getCropFixedHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropFixed"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	@Override
	public Boolean getentryIDHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Color"));
	}

	@Override
	public Boolean getColorHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Color"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsGrayMap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GrayMap"));
	}

	@Override
	public Boolean getGrayMapHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GrayMap"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getGrayMapArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GrayMap"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

}
