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

public class GFACIP4_Root extends GFAObject implements ACIP4_Root {

	public GFACIP4_Root(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_Root");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_Intent":
				return getCIP4_Intent();
			case "CIP4_IntentSummary":
				return getCIP4_IntentSummary();
			case "CIP4_Metadata":
				return getCIP4_Metadata();
			case "CIP4_Production":
				return getCIP4_Production();
			case "CIP4_Recipient":
				return getCIP4_Recipient();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACIP4_Intent> getCIP4_Intent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_Intent1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Intent> getCIP4_Intent1_7() {
		COSObject object = getCIP4_IntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Intent> list = new ArrayList<>(1);
			list.add(new GFACIP4_Intent((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Intent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_IntentSummary> getCIP4_IntentSummary() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_IntentSummary1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_IntentSummary> getCIP4_IntentSummary1_7() {
		COSObject object = getCIP4_IntentSummaryValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_IntentSummary> list = new ArrayList<>(1);
			list.add(new GFACIP4_IntentSummary((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_IntentSummary"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_Metadata> getCIP4_Metadata() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_Metadata1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Metadata> getCIP4_Metadata1_7() {
		COSObject object = getCIP4_MetadataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Metadata> list = new ArrayList<>(1);
			list.add(new GFACIP4_Metadata((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Metadata"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_Production> getCIP4_Production() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_Production1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Production> getCIP4_Production1_7() {
		COSObject object = getCIP4_ProductionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Production> list = new ArrayList<>(1);
			list.add(new GFACIP4_Production((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Production"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_Recipient> getCIP4_Recipient() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_Recipient1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Recipient> getCIP4_Recipient1_7() {
		COSObject object = getCIP4_RecipientValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Recipient> list = new ArrayList<>(1);
			list.add(new GFACIP4_Recipient((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Recipient"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public Boolean getcontainsCIP4_ExternalID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ExternalID"));
	}

	public COSObject getCIP4_ExternalIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ExternalID"));
		return object;
	}

	@Override
	public String getCIP4_ExternalIDType() {
		COSObject CIP4_ExternalID = getCIP4_ExternalIDValue();
		return getObjectType(CIP4_ExternalID);
	}

	@Override
	public Boolean getCIP4_ExternalIDHasTypeName() {
		COSObject CIP4_ExternalID = getCIP4_ExternalIDValue();
		return getHasTypeName(CIP4_ExternalID);
	}

	@Override
	public Boolean getcontainsCIP4_Intent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Intent"));
	}

	public COSObject getCIP4_IntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Intent"));
		return object;
	}

	@Override
	public String getCIP4_IntentType() {
		COSObject CIP4_Intent = getCIP4_IntentValue();
		return getObjectType(CIP4_Intent);
	}

	@Override
	public Boolean getCIP4_IntentHasTypeDictionary() {
		COSObject CIP4_Intent = getCIP4_IntentValue();
		return getHasTypeDictionary(CIP4_Intent);
	}

	@Override
	public Boolean getcontainsCIP4_IntentSummary() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_IntentSummary"));
	}

	public COSObject getCIP4_IntentSummaryValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_IntentSummary"));
		return object;
	}

	@Override
	public String getCIP4_IntentSummaryType() {
		COSObject CIP4_IntentSummary = getCIP4_IntentSummaryValue();
		return getObjectType(CIP4_IntentSummary);
	}

	@Override
	public Boolean getCIP4_IntentSummaryHasTypeDictionary() {
		COSObject CIP4_IntentSummary = getCIP4_IntentSummaryValue();
		return getHasTypeDictionary(CIP4_IntentSummary);
	}

	@Override
	public Boolean getcontainsCIP4_Metadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Metadata"));
	}

	public COSObject getCIP4_MetadataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Metadata"));
		return object;
	}

	@Override
	public String getCIP4_MetadataType() {
		COSObject CIP4_Metadata = getCIP4_MetadataValue();
		return getObjectType(CIP4_Metadata);
	}

	@Override
	public Boolean getCIP4_MetadataHasTypeDictionary() {
		COSObject CIP4_Metadata = getCIP4_MetadataValue();
		return getHasTypeDictionary(CIP4_Metadata);
	}

	@Override
	public Boolean getcontainsCIP4_Production() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Production"));
	}

	public COSObject getCIP4_ProductionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Production"));
		return object;
	}

	@Override
	public String getCIP4_ProductionType() {
		COSObject CIP4_Production = getCIP4_ProductionValue();
		return getObjectType(CIP4_Production);
	}

	@Override
	public Boolean getCIP4_ProductionHasTypeDictionary() {
		COSObject CIP4_Production = getCIP4_ProductionValue();
		return getHasTypeDictionary(CIP4_Production);
	}

	@Override
	public Boolean getcontainsCIP4_Recipient() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Recipient"));
	}

	public COSObject getCIP4_RecipientValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Recipient"));
		return object;
	}

	@Override
	public String getCIP4_RecipientType() {
		COSObject CIP4_Recipient = getCIP4_RecipientValue();
		return getObjectType(CIP4_Recipient);
	}

	@Override
	public Boolean getCIP4_RecipientHasTypeDictionary() {
		COSObject CIP4_Recipient = getCIP4_RecipientValue();
		return getHasTypeDictionary(CIP4_Recipient);
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
