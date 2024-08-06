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

public class GFACIP4_Person extends GFAObject implements ACIP4_Person {

	public GFACIP4_Person(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_Person");
	}

	@Override
	public Boolean getcontainsCIP4_AdditionalNames() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_AdditionalNames"));
	}

	public COSObject getCIP4_AdditionalNamesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_AdditionalNames"));
		return object;
	}

	@Override
	public String getCIP4_AdditionalNamesType() {
		COSObject CIP4_AdditionalNames = getCIP4_AdditionalNamesValue();
		return getObjectType(CIP4_AdditionalNames);
	}

	@Override
	public Boolean getCIP4_AdditionalNamesHasTypeString() {
		COSObject CIP4_AdditionalNames = getCIP4_AdditionalNamesValue();
		return getHasTypeString(CIP4_AdditionalNames);
	}

	@Override
	public Boolean getcontainsCIP4_DescriptiveName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_DescriptiveName"));
	}

	public COSObject getCIP4_DescriptiveNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_DescriptiveName"));
		return object;
	}

	@Override
	public String getCIP4_DescriptiveNameType() {
		COSObject CIP4_DescriptiveName = getCIP4_DescriptiveNameValue();
		return getObjectType(CIP4_DescriptiveName);
	}

	@Override
	public Boolean getCIP4_DescriptiveNameHasTypeString() {
		COSObject CIP4_DescriptiveName = getCIP4_DescriptiveNameValue();
		return getHasTypeString(CIP4_DescriptiveName);
	}

	@Override
	public Boolean getcontainsCIP4_FamilyName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_FamilyName"));
	}

	public COSObject getCIP4_FamilyNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_FamilyName"));
		return object;
	}

	@Override
	public String getCIP4_FamilyNameType() {
		COSObject CIP4_FamilyName = getCIP4_FamilyNameValue();
		return getObjectType(CIP4_FamilyName);
	}

	@Override
	public Boolean getCIP4_FamilyNameHasTypeString() {
		COSObject CIP4_FamilyName = getCIP4_FamilyNameValue();
		return getHasTypeString(CIP4_FamilyName);
	}

	@Override
	public Boolean getcontainsCIP4_FirstName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_FirstName"));
	}

	public COSObject getCIP4_FirstNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_FirstName"));
		return object;
	}

	@Override
	public String getCIP4_FirstNameType() {
		COSObject CIP4_FirstName = getCIP4_FirstNameValue();
		return getObjectType(CIP4_FirstName);
	}

	@Override
	public Boolean getCIP4_FirstNameHasTypeString() {
		COSObject CIP4_FirstName = getCIP4_FirstNameValue();
		return getHasTypeString(CIP4_FirstName);
	}

	@Override
	public Boolean getcontainsCIP4_FullName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_FullName"));
	}

	public COSObject getCIP4_FullNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_FullName"));
		return object;
	}

	@Override
	public String getCIP4_FullNameType() {
		COSObject CIP4_FullName = getCIP4_FullNameValue();
		return getObjectType(CIP4_FullName);
	}

	@Override
	public Boolean getCIP4_FullNameHasTypeString() {
		COSObject CIP4_FullName = getCIP4_FullNameValue();
		return getHasTypeString(CIP4_FullName);
	}

	@Override
	public Boolean getcontainsCIP4_JobTitle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_JobTitle"));
	}

	public COSObject getCIP4_JobTitleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_JobTitle"));
		return object;
	}

	@Override
	public String getCIP4_JobTitleType() {
		COSObject CIP4_JobTitle = getCIP4_JobTitleValue();
		return getObjectType(CIP4_JobTitle);
	}

	@Override
	public Boolean getCIP4_JobTitleHasTypeString() {
		COSObject CIP4_JobTitle = getCIP4_JobTitleValue();
		return getHasTypeString(CIP4_JobTitle);
	}

	@Override
	public Boolean getcontainsCIP4_NamePrefix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_NamePrefix"));
	}

	public COSObject getCIP4_NamePrefixValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_NamePrefix"));
		return object;
	}

	@Override
	public String getCIP4_NamePrefixType() {
		COSObject CIP4_NamePrefix = getCIP4_NamePrefixValue();
		return getObjectType(CIP4_NamePrefix);
	}

	@Override
	public Boolean getCIP4_NamePrefixHasTypeString() {
		COSObject CIP4_NamePrefix = getCIP4_NamePrefixValue();
		return getHasTypeString(CIP4_NamePrefix);
	}

	@Override
	public Boolean getcontainsCIP4_NameSuffix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_NameSuffix"));
	}

	public COSObject getCIP4_NameSuffixValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_NameSuffix"));
		return object;
	}

	@Override
	public String getCIP4_NameSuffixType() {
		COSObject CIP4_NameSuffix = getCIP4_NameSuffixValue();
		return getObjectType(CIP4_NameSuffix);
	}

	@Override
	public Boolean getCIP4_NameSuffixHasTypeString() {
		COSObject CIP4_NameSuffix = getCIP4_NameSuffixValue();
		return getHasTypeString(CIP4_NameSuffix);
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
