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

public class GFAOPIVersion13Dict extends GFAObject implements AOPIVersion13Dict {

	public GFAOPIVersion13Dict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOPIVersion13Dict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Color":
				return getColor();
			case "CropFixed":
				return getCropFixed();
			case "F":
				return getF();
			case "GrayMap":
				return getGrayMap();
			case "ImageType":
				return getImageType();
			case "Position":
				return getPosition();
			case "Resolution":
				return getResolution();
			case "Size":
				return getSize();
			case "Tags":
				return getTags();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfOPI13Color> getColor() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getColorValue();
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

	private List<AArrayOf_4Numbers> getCropFixed() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getCropFixedValue();
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

	private List<AArrayOfIntegersGeneral> getGrayMap() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getGrayMapValue();
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

	private List<AArrayOf_2Integers> getImageType() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getImageTypeValue();
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

	private List<AArrayOf_8Numbers> getPosition() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getPositionValue();
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

	private List<AArrayOf_2Numbers> getResolution() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getResolutionValue();
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

	private List<AArrayOf_2Integers> getSize() {
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

	private List<AArrayOf_2Integers> getSize1_2() {
		COSObject object = getSizeValue();
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
	public Boolean getcontainsColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Color"));
	}

	public COSObject getColorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Color"));
		return object;
	}

	@Override
	public Boolean getColorHasTypeArray() {
		COSObject Color = getColorValue();
		return getHasTypeArray(Color);
	}

	@Override
	public Boolean getcontainsColorType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorType"));
	}

	public COSObject getColorTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorType"));
		return object;
	}

	@Override
	public Boolean getColorTypeHasTypeName() {
		COSObject ColorType = getColorTypeValue();
		return getHasTypeName(ColorType);
	}

	@Override
	public Boolean getcontainsComments() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Comments"));
	}

	public COSObject getCommentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Comments"));
		return object;
	}

	@Override
	public Boolean getCommentsHasTypeStringText() {
		COSObject Comments = getCommentsValue();
		return getHasTypeStringText(Comments);
	}

	@Override
	public Boolean getcontainsCropFixed() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CropFixed"));
	}

	public COSObject getCropFixedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropFixed"));
		return object;
	}

	@Override
	public Boolean getCropFixedHasTypeArray() {
		COSObject CropFixed = getCropFixedValue();
		return getHasTypeArray(CropFixed);
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
		COSObject CropRect = getCropRectValue();
		return getHasTypeRectangle(CropRect);
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
		COSObject F = getFValue();
		return getHasTypeDictionary(F);
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject F = getFValue();
		return getHasTypeString(F);
	}

	@Override
	public Boolean getcontainsGrayMap() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GrayMap"));
	}

	public COSObject getGrayMapValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GrayMap"));
		return object;
	}

	@Override
	public Boolean getGrayMapHasTypeArray() {
		COSObject GrayMap = getGrayMapValue();
		return getHasTypeArray(GrayMap);
	}

	@Override
	public Long getGrayMapArraySize() {
		COSObject GrayMap = getGrayMapValue();
		return getArraySize(GrayMap);
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
	public Boolean getentryIDHasTypeStringByte() {
		COSObject entryID = getentryIDValue();
		return getHasTypeStringByte(entryID);
	}

	@Override
	public Boolean getcontainsImageType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ImageType"));
	}

	public COSObject getImageTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ImageType"));
		return object;
	}

	@Override
	public Boolean getImageTypeHasTypeArray() {
		COSObject ImageType = getImageTypeValue();
		return getHasTypeArray(ImageType);
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
		COSObject Overprint = getOverprintValue();
		return getHasTypeBoolean(Overprint);
	}

	@Override
	public Boolean getcontainsPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Position"));
	}

	public COSObject getPositionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		return object;
	}

	@Override
	public Boolean getPositionHasTypeArray() {
		COSObject Position = getPositionValue();
		return getHasTypeArray(Position);
	}

	@Override
	public Boolean getcontainsResolution() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resolution"));
	}

	public COSObject getResolutionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resolution"));
		return object;
	}

	@Override
	public Boolean getResolutionHasTypeArray() {
		COSObject Resolution = getResolutionValue();
		return getHasTypeArray(Resolution);
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
		COSObject Size = getSizeValue();
		return getHasTypeArray(Size);
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
		COSObject Tags = getTagsValue();
		return getHasTypeArray(Tags);
	}

	@Override
	public Boolean getcontainsTint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Tint"));
	}

	public COSObject getTintValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Tint"));
		return object;
	}

	@Override
	public Boolean getTintHasTypeNumber() {
		COSObject Tint = getTintValue();
		return getHasTypeNumber(Tint);
	}

	@Override
	public Boolean getcontainsTransparency() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Transparency"));
	}

	public COSObject getTransparencyValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Transparency"));
		return object;
	}

	@Override
	public Boolean getTransparencyHasTypeBoolean() {
		COSObject Transparency = getTransparencyValue();
		return getHasTypeBoolean(Transparency);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
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
		COSObject Version = getVersionValue();
		return getHasTypeNumber(Version);
	}

	@Override
	public Double getVersionNumberValue() {
		COSObject Version = getVersionValue();
		return getNumberValue(Version);
	}

}
