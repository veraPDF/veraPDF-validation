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

public class GFACIP4_Metadata extends GFAObject implements ACIP4_Metadata {

	public GFACIP4_Metadata(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_Metadata");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_Accounting":
				return getCIP4_Accounting();
			case "CIP4_Administrator":
				return getCIP4_Administrator();
			case "CIP4_Author":
				return getCIP4_Author();
			case "CIP4_Conformance":
				return getCIP4_Conformance();
			case "CIP4_Sender":
				return getCIP4_Sender();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACIP4_Contact> getCIP4_Accounting() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Accounting1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Contact> getCIP4_Accounting1_7() {
		COSObject object = getCIP4_AccountingValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Contact> list = new ArrayList<>(1);
			list.add(new GFACIP4_Contact((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Accounting"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_Contact> getCIP4_Administrator() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Administrator1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Contact> getCIP4_Administrator1_7() {
		COSObject object = getCIP4_AdministratorValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Contact> list = new ArrayList<>(1);
			list.add(new GFACIP4_Contact((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Administrator"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_Contact> getCIP4_Author() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Author1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Contact> getCIP4_Author1_7() {
		COSObject object = getCIP4_AuthorValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Contact> list = new ArrayList<>(1);
			list.add(new GFACIP4_Contact((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Author"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsText> getCIP4_Conformance() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Conformance1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getCIP4_Conformance1_7() {
		COSObject object = getCIP4_ConformanceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "CIP4_Conformance"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_Contact> getCIP4_Sender() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Sender1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Contact> getCIP4_Sender1_7() {
		COSObject object = getCIP4_SenderValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Contact> list = new ArrayList<>(1);
			list.add(new GFACIP4_Contact((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Sender"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_Accounting() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Accounting"));
	}

	public COSObject getCIP4_AccountingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Accounting"));
		return object;
	}

	@Override
	public String getCIP4_AccountingType() {
		COSObject CIP4_Accounting = getCIP4_AccountingValue();
		return getObjectType(CIP4_Accounting);
	}

	@Override
	public Boolean getCIP4_AccountingHasTypeDictionary() {
		COSObject CIP4_Accounting = getCIP4_AccountingValue();
		return getHasTypeDictionary(CIP4_Accounting);
	}

	@Override
	public Boolean getcontainsCIP4_Administrator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Administrator"));
	}

	public COSObject getCIP4_AdministratorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Administrator"));
		return object;
	}

	@Override
	public String getCIP4_AdministratorType() {
		COSObject CIP4_Administrator = getCIP4_AdministratorValue();
		return getObjectType(CIP4_Administrator);
	}

	@Override
	public Boolean getCIP4_AdministratorHasTypeDictionary() {
		COSObject CIP4_Administrator = getCIP4_AdministratorValue();
		return getHasTypeDictionary(CIP4_Administrator);
	}

	@Override
	public Boolean getcontainsCIP4_Author() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Author"));
	}

	public COSObject getCIP4_AuthorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Author"));
		return object;
	}

	@Override
	public String getCIP4_AuthorType() {
		COSObject CIP4_Author = getCIP4_AuthorValue();
		return getObjectType(CIP4_Author);
	}

	@Override
	public Boolean getCIP4_AuthorHasTypeDictionary() {
		COSObject CIP4_Author = getCIP4_AuthorValue();
		return getHasTypeDictionary(CIP4_Author);
	}

	@Override
	public Boolean getcontainsCIP4_Conformance() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Conformance"));
	}

	public COSObject getCIP4_ConformanceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Conformance"));
		return object;
	}

	@Override
	public String getCIP4_ConformanceType() {
		COSObject CIP4_Conformance = getCIP4_ConformanceValue();
		return getObjectType(CIP4_Conformance);
	}

	@Override
	public Boolean getCIP4_ConformanceHasTypeArray() {
		COSObject CIP4_Conformance = getCIP4_ConformanceValue();
		return getHasTypeArray(CIP4_Conformance);
	}

	@Override
	public Boolean getcontainsCIP4_Creator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Creator"));
	}

	public COSObject getCIP4_CreatorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Creator"));
		return object;
	}

	@Override
	public String getCIP4_CreatorType() {
		COSObject CIP4_Creator = getCIP4_CreatorValue();
		return getObjectType(CIP4_Creator);
	}

	@Override
	public Boolean getCIP4_CreatorHasTypeString() {
		COSObject CIP4_Creator = getCIP4_CreatorValue();
		return getHasTypeString(CIP4_Creator);
	}

	@Override
	public Boolean getcontainsCIP4_JobID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_JobID"));
	}

	public COSObject getCIP4_JobIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_JobID"));
		return object;
	}

	@Override
	public String getCIP4_JobIDType() {
		COSObject CIP4_JobID = getCIP4_JobIDValue();
		return getObjectType(CIP4_JobID);
	}

	@Override
	public Boolean getCIP4_JobIDHasTypeName() {
		COSObject CIP4_JobID = getCIP4_JobIDValue();
		return getHasTypeName(CIP4_JobID);
	}

	@Override
	public Boolean getcontainsCIP4_ModificationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ModificationDate"));
	}

	public COSObject getCIP4_ModificationDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ModificationDate"));
		return object;
	}

	@Override
	public String getCIP4_ModificationDateType() {
		COSObject CIP4_ModificationDate = getCIP4_ModificationDateValue();
		return getObjectType(CIP4_ModificationDate);
	}

	@Override
	public Boolean getCIP4_ModificationDateHasTypeDate() {
		COSObject CIP4_ModificationDate = getCIP4_ModificationDateValue();
		return getHasTypeDate(CIP4_ModificationDate);
	}

	@Override
	public Boolean getcontainsCIP4_ProjectID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ProjectID"));
	}

	public COSObject getCIP4_ProjectIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ProjectID"));
		return object;
	}

	@Override
	public String getCIP4_ProjectIDType() {
		COSObject CIP4_ProjectID = getCIP4_ProjectIDValue();
		return getObjectType(CIP4_ProjectID);
	}

	@Override
	public Boolean getCIP4_ProjectIDHasTypeName() {
		COSObject CIP4_ProjectID = getCIP4_ProjectIDValue();
		return getHasTypeName(CIP4_ProjectID);
	}

	@Override
	public Boolean getcontainsCIP4_Sender() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Sender"));
	}

	public COSObject getCIP4_SenderValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Sender"));
		return object;
	}

	@Override
	public String getCIP4_SenderType() {
		COSObject CIP4_Sender = getCIP4_SenderValue();
		return getObjectType(CIP4_Sender);
	}

	@Override
	public Boolean getCIP4_SenderHasTypeDictionary() {
		COSObject CIP4_Sender = getCIP4_SenderValue();
		return getHasTypeDictionary(CIP4_Sender);
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
