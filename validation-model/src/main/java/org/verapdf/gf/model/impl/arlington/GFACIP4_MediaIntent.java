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

public class GFACIP4_MediaIntent extends GFAObject implements ACIP4_MediaIntent {

	public GFACIP4_MediaIntent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_MediaIntent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_LABColorValue":
				return getCIP4_LABColorValue();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_LABColorValue> getCIP4_LABColorValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_LABColorValue1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_LABColorValue> getCIP4_LABColorValue1_7() {
		COSObject object = getCIP4_LABColorValueValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_LABColorValue> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_LABColorValue((COSArray)object.getDirectBase(), this.baseObject, "CIP4_LABColorValue"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_BackCoating() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_BackCoating"));
	}

	public COSObject getCIP4_BackCoatingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_BackCoating"));
		return object;
	}

	@Override
	public String getCIP4_BackCoatingType() {
		COSObject CIP4_BackCoating = getCIP4_BackCoatingValue();
		return getObjectType(CIP4_BackCoating);
	}

	@Override
	public Boolean getCIP4_BackCoatingHasTypeName() {
		COSObject CIP4_BackCoating = getCIP4_BackCoatingValue();
		return getHasTypeName(CIP4_BackCoating);
	}

	@Override
	public String getCIP4_BackCoatingNameValue() {
		COSObject CIP4_BackCoating = getCIP4_BackCoatingValue();
		return getNameValue(CIP4_BackCoating);
	}

	@Override
	public Boolean getcontainsCIP4_Coating() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Coating"));
	}

	public COSObject getCIP4_CoatingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Coating"));
		return object;
	}

	@Override
	public String getCIP4_CoatingType() {
		COSObject CIP4_Coating = getCIP4_CoatingValue();
		return getObjectType(CIP4_Coating);
	}

	@Override
	public Boolean getCIP4_CoatingHasTypeName() {
		COSObject CIP4_Coating = getCIP4_CoatingValue();
		return getHasTypeName(CIP4_Coating);
	}

	@Override
	public String getCIP4_CoatingNameValue() {
		COSObject CIP4_Coating = getCIP4_CoatingValue();
		return getNameValue(CIP4_Coating);
	}

	@Override
	public Boolean getcontainsCIP4_ISOPaperSubstrate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ISOPaperSubstrate"));
	}

	public COSObject getCIP4_ISOPaperSubstrateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ISOPaperSubstrate"));
		return object;
	}

	@Override
	public String getCIP4_ISOPaperSubstrateType() {
		COSObject CIP4_ISOPaperSubstrate = getCIP4_ISOPaperSubstrateValue();
		return getObjectType(CIP4_ISOPaperSubstrate);
	}

	@Override
	public Boolean getCIP4_ISOPaperSubstrateHasTypeName() {
		COSObject CIP4_ISOPaperSubstrate = getCIP4_ISOPaperSubstrateValue();
		return getHasTypeName(CIP4_ISOPaperSubstrate);
	}

	@Override
	public String getCIP4_ISOPaperSubstrateNameValue() {
		COSObject CIP4_ISOPaperSubstrate = getCIP4_ISOPaperSubstrateValue();
		return getNameValue(CIP4_ISOPaperSubstrate);
	}

	@Override
	public Boolean getcontainsCIP4_LABColorValue() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_LABColorValue"));
	}

	public COSObject getCIP4_LABColorValueValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_LABColorValue"));
		return object;
	}

	@Override
	public String getCIP4_LABColorValueType() {
		COSObject CIP4_LABColorValue = getCIP4_LABColorValueValue();
		return getObjectType(CIP4_LABColorValue);
	}

	@Override
	public Boolean getCIP4_LABColorValueHasTypeArray() {
		COSObject CIP4_LABColorValue = getCIP4_LABColorValueValue();
		return getHasTypeArray(CIP4_LABColorValue);
	}

	@Override
	public Boolean getcontainsCIP4_MediaColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_MediaColor"));
	}

	public COSObject getCIP4_MediaColorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_MediaColor"));
		return object;
	}

	@Override
	public String getCIP4_MediaColorType() {
		COSObject CIP4_MediaColor = getCIP4_MediaColorValue();
		return getObjectType(CIP4_MediaColor);
	}

	@Override
	public Boolean getCIP4_MediaColorHasTypeName() {
		COSObject CIP4_MediaColor = getCIP4_MediaColorValue();
		return getHasTypeName(CIP4_MediaColor);
	}

	@Override
	public String getCIP4_MediaColorNameValue() {
		COSObject CIP4_MediaColor = getCIP4_MediaColorValue();
		return getNameValue(CIP4_MediaColor);
	}

	@Override
	public Boolean getcontainsCIP4_MediaColorDetails() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_MediaColorDetails"));
	}

	public COSObject getCIP4_MediaColorDetailsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_MediaColorDetails"));
		return object;
	}

	@Override
	public String getCIP4_MediaColorDetailsType() {
		COSObject CIP4_MediaColorDetails = getCIP4_MediaColorDetailsValue();
		return getObjectType(CIP4_MediaColorDetails);
	}

	@Override
	public Boolean getCIP4_MediaColorDetailsHasTypeString() {
		COSObject CIP4_MediaColorDetails = getCIP4_MediaColorDetailsValue();
		return getHasTypeString(CIP4_MediaColorDetails);
	}

	@Override
	public Boolean getcontainsCIP4_MediaQuality() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_MediaQuality"));
	}

	public COSObject getCIP4_MediaQualityValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_MediaQuality"));
		return object;
	}

	@Override
	public String getCIP4_MediaQualityType() {
		COSObject CIP4_MediaQuality = getCIP4_MediaQualityValue();
		return getObjectType(CIP4_MediaQuality);
	}

	@Override
	public Boolean getCIP4_MediaQualityHasTypeString() {
		COSObject CIP4_MediaQuality = getCIP4_MediaQualityValue();
		return getHasTypeString(CIP4_MediaQuality);
	}

	@Override
	public Boolean getcontainsCIP4_MediaTypeDetails() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_MediaTypeDetails"));
	}

	public COSObject getCIP4_MediaTypeDetailsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_MediaTypeDetails"));
		return object;
	}

	@Override
	public String getCIP4_MediaTypeDetailsType() {
		COSObject CIP4_MediaTypeDetails = getCIP4_MediaTypeDetailsValue();
		return getObjectType(CIP4_MediaTypeDetails);
	}

	@Override
	public Boolean getCIP4_MediaTypeDetailsHasTypeName() {
		COSObject CIP4_MediaTypeDetails = getCIP4_MediaTypeDetailsValue();
		return getHasTypeName(CIP4_MediaTypeDetails);
	}

	@Override
	public Boolean getcontainsCIP4_Weight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Weight"));
	}

	public COSObject getCIP4_WeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Weight"));
		return object;
	}

	@Override
	public String getCIP4_WeightType() {
		COSObject CIP4_Weight = getCIP4_WeightValue();
		return getObjectType(CIP4_Weight);
	}

	@Override
	public Boolean getCIP4_WeightHasTypeNumber() {
		COSObject CIP4_Weight = getCIP4_WeightValue();
		return getHasTypeNumber(CIP4_Weight);
	}

	@Override
	public Double getCIP4_WeightNumberValue() {
		COSObject CIP4_Weight = getCIP4_WeightValue();
		return getNumberValue(CIP4_Weight);
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

}
