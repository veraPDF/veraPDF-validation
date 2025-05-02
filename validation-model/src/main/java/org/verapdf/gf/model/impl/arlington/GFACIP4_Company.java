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

public class GFACIP4_Company extends GFAObject implements ACIP4_Company {

	public GFACIP4_Company(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_Company");
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
	public Boolean getcontainsCIP4_OrganizationName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_OrganizationName"));
	}

	public COSObject getCIP4_OrganizationNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_OrganizationName"));
		return object;
	}

	@Override
	public String getCIP4_OrganizationNameType() {
		COSObject CIP4_OrganizationName = getCIP4_OrganizationNameValue();
		return getObjectType(CIP4_OrganizationName);
	}

	@Override
	public Boolean getCIP4_OrganizationNameHasTypeString() {
		COSObject CIP4_OrganizationName = getCIP4_OrganizationNameValue();
		return getHasTypeString(CIP4_OrganizationName);
	}

	@Override
	public Boolean getcontainsCIP4_OrganizationalUnit() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_OrganizationalUnit"));
	}

	public COSObject getCIP4_OrganizationalUnitValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_OrganizationalUnit"));
		return object;
	}

	@Override
	public String getCIP4_OrganizationalUnitType() {
		COSObject CIP4_OrganizationalUnit = getCIP4_OrganizationalUnitValue();
		return getObjectType(CIP4_OrganizationalUnit);
	}

	@Override
	public Boolean getCIP4_OrganizationalUnitHasTypeString() {
		COSObject CIP4_OrganizationalUnit = getCIP4_OrganizationalUnitValue();
		return getHasTypeString(CIP4_OrganizationalUnit);
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
