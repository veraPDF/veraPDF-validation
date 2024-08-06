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

public class GFACIP4_Contact extends GFAObject implements ACIP4_Contact {

	public GFACIP4_Contact(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_Contact");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_Address":
				return getCIP4_Address();
			case "CIP4_ComChannel":
				return getCIP4_ComChannel();
			case "CIP4_Company":
				return getCIP4_Company();
			case "CIP4_ContactTypes":
				return getCIP4_ContactTypes();
			case "CIP4_Person":
				return getCIP4_Person();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACIP4_Address> getCIP4_Address() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_Address1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Address> getCIP4_Address1_7() {
		COSObject object = getCIP4_AddressValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Address> list = new ArrayList<>(1);
			list.add(new GFACIP4_Address((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Address"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_ComChannel> getCIP4_ComChannel() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_ComChannel1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_ComChannel> getCIP4_ComChannel1_7() {
		COSObject object = getCIP4_ComChannelValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_ComChannel> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_ComChannel((COSArray)object.getDirectBase(), this.baseObject, "CIP4_ComChannel"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_Company> getCIP4_Company() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_Company1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Company> getCIP4_Company1_7() {
		COSObject object = getCIP4_CompanyValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Company> list = new ArrayList<>(1);
			list.add(new GFACIP4_Company((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Company"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_ContactTypes> getCIP4_ContactTypes() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_ContactTypes1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_ContactTypes> getCIP4_ContactTypes1_7() {
		COSObject object = getCIP4_ContactTypesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_ContactTypes> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_ContactTypes((COSArray)object.getDirectBase(), this.baseObject, "CIP4_ContactTypes"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_Person> getCIP4_Person() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_Person1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Person> getCIP4_Person1_7() {
		COSObject object = getCIP4_PersonValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Person> list = new ArrayList<>(1);
			list.add(new GFACIP4_Person((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Person"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_Address() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Address"));
	}

	public COSObject getCIP4_AddressValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Address"));
		return object;
	}

	@Override
	public String getCIP4_AddressType() {
		COSObject CIP4_Address = getCIP4_AddressValue();
		return getObjectType(CIP4_Address);
	}

	@Override
	public Boolean getCIP4_AddressHasTypeDictionary() {
		COSObject CIP4_Address = getCIP4_AddressValue();
		return getHasTypeDictionary(CIP4_Address);
	}

	@Override
	public Boolean getcontainsCIP4_ComChannel() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ComChannel"));
	}

	public COSObject getCIP4_ComChannelValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ComChannel"));
		return object;
	}

	@Override
	public String getCIP4_ComChannelType() {
		COSObject CIP4_ComChannel = getCIP4_ComChannelValue();
		return getObjectType(CIP4_ComChannel);
	}

	@Override
	public Boolean getCIP4_ComChannelHasTypeArray() {
		COSObject CIP4_ComChannel = getCIP4_ComChannelValue();
		return getHasTypeArray(CIP4_ComChannel);
	}

	@Override
	public Boolean getcontainsCIP4_Company() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Company"));
	}

	public COSObject getCIP4_CompanyValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Company"));
		return object;
	}

	@Override
	public String getCIP4_CompanyType() {
		COSObject CIP4_Company = getCIP4_CompanyValue();
		return getObjectType(CIP4_Company);
	}

	@Override
	public Boolean getCIP4_CompanyHasTypeDictionary() {
		COSObject CIP4_Company = getCIP4_CompanyValue();
		return getHasTypeDictionary(CIP4_Company);
	}

	@Override
	public Boolean getcontainsCIP4_ContactTypes() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ContactTypes"));
	}

	public COSObject getCIP4_ContactTypesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ContactTypes"));
		return object;
	}

	@Override
	public String getCIP4_ContactTypesType() {
		COSObject CIP4_ContactTypes = getCIP4_ContactTypesValue();
		return getObjectType(CIP4_ContactTypes);
	}

	@Override
	public Boolean getCIP4_ContactTypesHasTypeArray() {
		COSObject CIP4_ContactTypes = getCIP4_ContactTypesValue();
		return getHasTypeArray(CIP4_ContactTypes);
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
	public Boolean getcontainsCIP4_Person() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Person"));
	}

	public COSObject getCIP4_PersonValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Person"));
		return object;
	}

	@Override
	public String getCIP4_PersonType() {
		COSObject CIP4_Person = getCIP4_PersonValue();
		return getObjectType(CIP4_Person);
	}

	@Override
	public Boolean getCIP4_PersonHasTypeDictionary() {
		COSObject CIP4_Person = getCIP4_PersonValue();
		return getHasTypeDictionary(CIP4_Person);
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
