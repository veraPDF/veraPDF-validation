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

public class GFACIP4_Address extends GFAObject implements ACIP4_Address {

	public GFACIP4_Address(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_Address");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_AddressLines":
				return getCIP4_AddressLines();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStringsText> getCIP4_AddressLines() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_AddressLines1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getCIP4_AddressLines1_7() {
		COSObject object = getCIP4_AddressLinesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "CIP4_AddressLines"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_AddressLines() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_AddressLines"));
	}

	public COSObject getCIP4_AddressLinesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_AddressLines"));
		return object;
	}

	@Override
	public String getCIP4_AddressLinesType() {
		COSObject CIP4_AddressLines = getCIP4_AddressLinesValue();
		return getObjectType(CIP4_AddressLines);
	}

	@Override
	public Boolean getCIP4_AddressLinesHasTypeArray() {
		COSObject CIP4_AddressLines = getCIP4_AddressLinesValue();
		return getHasTypeArray(CIP4_AddressLines);
	}

	@Override
	public Boolean getcontainsCIP4_AddressUsage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_AddressUsage"));
	}

	public COSObject getCIP4_AddressUsageValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_AddressUsage"));
		return object;
	}

	@Override
	public String getCIP4_AddressUsageType() {
		COSObject CIP4_AddressUsage = getCIP4_AddressUsageValue();
		return getObjectType(CIP4_AddressUsage);
	}

	@Override
	public Boolean getCIP4_AddressUsageHasTypeName() {
		COSObject CIP4_AddressUsage = getCIP4_AddressUsageValue();
		return getHasTypeName(CIP4_AddressUsage);
	}

	@Override
	public String getCIP4_AddressUsageNameValue() {
		COSObject CIP4_AddressUsage = getCIP4_AddressUsageValue();
		return getNameValue(CIP4_AddressUsage);
	}

	@Override
	public Boolean getcontainsCIP4_City() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_City"));
	}

	public COSObject getCIP4_CityValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_City"));
		return object;
	}

	@Override
	public String getCIP4_CityType() {
		COSObject CIP4_City = getCIP4_CityValue();
		return getObjectType(CIP4_City);
	}

	@Override
	public Boolean getCIP4_CityHasTypeString() {
		COSObject CIP4_City = getCIP4_CityValue();
		return getHasTypeString(CIP4_City);
	}

	@Override
	public Boolean getcontainsCIP4_CivicNumber() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_CivicNumber"));
	}

	public COSObject getCIP4_CivicNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_CivicNumber"));
		return object;
	}

	@Override
	public String getCIP4_CivicNumberType() {
		COSObject CIP4_CivicNumber = getCIP4_CivicNumberValue();
		return getObjectType(CIP4_CivicNumber);
	}

	@Override
	public Boolean getCIP4_CivicNumberHasTypeString() {
		COSObject CIP4_CivicNumber = getCIP4_CivicNumberValue();
		return getHasTypeString(CIP4_CivicNumber);
	}

	@Override
	public Boolean getcontainsCIP4_Country() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Country"));
	}

	public COSObject getCIP4_CountryValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Country"));
		return object;
	}

	@Override
	public String getCIP4_CountryType() {
		COSObject CIP4_Country = getCIP4_CountryValue();
		return getObjectType(CIP4_Country);
	}

	@Override
	public Boolean getCIP4_CountryHasTypeString() {
		COSObject CIP4_Country = getCIP4_CountryValue();
		return getHasTypeString(CIP4_Country);
	}

	@Override
	public Boolean getcontainsCIP4_CountryCode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_CountryCode"));
	}

	public COSObject getCIP4_CountryCodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_CountryCode"));
		return object;
	}

	@Override
	public String getCIP4_CountryCodeType() {
		COSObject CIP4_CountryCode = getCIP4_CountryCodeValue();
		return getObjectType(CIP4_CountryCode);
	}

	@Override
	public Boolean getCIP4_CountryCodeHasTypeName() {
		COSObject CIP4_CountryCode = getCIP4_CountryCodeValue();
		return getHasTypeName(CIP4_CountryCode);
	}

	@Override
	public Boolean getcontainsCIP4_PostBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_PostBox"));
	}

	public COSObject getCIP4_PostBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_PostBox"));
		return object;
	}

	@Override
	public String getCIP4_PostBoxType() {
		COSObject CIP4_PostBox = getCIP4_PostBoxValue();
		return getObjectType(CIP4_PostBox);
	}

	@Override
	public Boolean getCIP4_PostBoxHasTypeString() {
		COSObject CIP4_PostBox = getCIP4_PostBoxValue();
		return getHasTypeString(CIP4_PostBox);
	}

	@Override
	public Boolean getcontainsCIP4_PostalCode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_PostalCode"));
	}

	public COSObject getCIP4_PostalCodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_PostalCode"));
		return object;
	}

	@Override
	public String getCIP4_PostalCodeType() {
		COSObject CIP4_PostalCode = getCIP4_PostalCodeValue();
		return getObjectType(CIP4_PostalCode);
	}

	@Override
	public Boolean getCIP4_PostalCodeHasTypeString() {
		COSObject CIP4_PostalCode = getCIP4_PostalCodeValue();
		return getHasTypeString(CIP4_PostalCode);
	}

	@Override
	public Boolean getcontainsCIP4_Region() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Region"));
	}

	public COSObject getCIP4_RegionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Region"));
		return object;
	}

	@Override
	public String getCIP4_RegionType() {
		COSObject CIP4_Region = getCIP4_RegionValue();
		return getObjectType(CIP4_Region);
	}

	@Override
	public Boolean getCIP4_RegionHasTypeString() {
		COSObject CIP4_Region = getCIP4_RegionValue();
		return getHasTypeString(CIP4_Region);
	}

	@Override
	public Boolean getcontainsCIP4_Street() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Street"));
	}

	public COSObject getCIP4_StreetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Street"));
		return object;
	}

	@Override
	public String getCIP4_StreetType() {
		COSObject CIP4_Street = getCIP4_StreetValue();
		return getObjectType(CIP4_Street);
	}

	@Override
	public Boolean getCIP4_StreetHasTypeString() {
		COSObject CIP4_Street = getCIP4_StreetValue();
		return getHasTypeString(CIP4_Street);
	}

	@Override
	public Boolean getcontainsCIP4_StreetName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_StreetName"));
	}

	public COSObject getCIP4_StreetNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_StreetName"));
		return object;
	}

	@Override
	public String getCIP4_StreetNameType() {
		COSObject CIP4_StreetName = getCIP4_StreetNameValue();
		return getObjectType(CIP4_StreetName);
	}

	@Override
	public Boolean getCIP4_StreetNameHasTypeString() {
		COSObject CIP4_StreetName = getCIP4_StreetNameValue();
		return getHasTypeString(CIP4_StreetName);
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
