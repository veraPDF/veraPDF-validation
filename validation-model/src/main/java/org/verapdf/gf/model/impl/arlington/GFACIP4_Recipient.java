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

public class GFACIP4_Recipient extends GFAObject implements ACIP4_Recipient {

	public GFACIP4_Recipient(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_Recipient");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_Contact":
				return getCIP4_Contact();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACIP4_Contact> getCIP4_Contact() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Contact1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_Contact> getCIP4_Contact1_7() {
		COSObject object = getCIP4_ContactValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_Contact> list = new ArrayList<>(1);
			list.add(new GFACIP4_Contact((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Contact"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_Contact() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Contact"));
	}

	public COSObject getCIP4_ContactValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Contact"));
		return object;
	}

	@Override
	public String getCIP4_ContactType() {
		COSObject CIP4_Contact = getCIP4_ContactValue();
		return getObjectType(CIP4_Contact);
	}

	@Override
	public Boolean getCIP4_ContactHasTypeDictionary() {
		COSObject CIP4_Contact = getCIP4_ContactValue();
		return getHasTypeDictionary(CIP4_Contact);
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

}
