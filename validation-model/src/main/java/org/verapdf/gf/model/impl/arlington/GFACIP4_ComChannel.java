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

public class GFACIP4_ComChannel extends GFAObject implements ACIP4_ComChannel {

	public GFACIP4_ComChannel(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_ComChannel");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_ChannelUsage":
				return getCIP4_ChannelUsage();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_ChannelUsage> getCIP4_ChannelUsage() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_ChannelUsage1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_ChannelUsage> getCIP4_ChannelUsage1_7() {
		COSObject object = getCIP4_ChannelUsageValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_ChannelUsage> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_ChannelUsage((COSArray)object.getDirectBase(), this.baseObject, "CIP4_ChannelUsage"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_ChannelType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ChannelType"));
	}

	public COSObject getCIP4_ChannelTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ChannelType"));
		return object;
	}

	@Override
	public String getCIP4_ChannelTypeType() {
		COSObject CIP4_ChannelType = getCIP4_ChannelTypeValue();
		return getObjectType(CIP4_ChannelType);
	}

	@Override
	public Boolean getCIP4_ChannelTypeHasTypeName() {
		COSObject CIP4_ChannelType = getCIP4_ChannelTypeValue();
		return getHasTypeName(CIP4_ChannelType);
	}

	@Override
	public String getCIP4_ChannelTypeNameValue() {
		COSObject CIP4_ChannelType = getCIP4_ChannelTypeValue();
		return getNameValue(CIP4_ChannelType);
	}

	@Override
	public Boolean getcontainsCIP4_ChannelUsage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ChannelUsage"));
	}

	public COSObject getCIP4_ChannelUsageValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ChannelUsage"));
		return object;
	}

	@Override
	public String getCIP4_ChannelUsageType() {
		COSObject CIP4_ChannelUsage = getCIP4_ChannelUsageValue();
		return getObjectType(CIP4_ChannelUsage);
	}

	@Override
	public Boolean getCIP4_ChannelUsageHasTypeArray() {
		COSObject CIP4_ChannelUsage = getCIP4_ChannelUsageValue();
		return getHasTypeArray(CIP4_ChannelUsage);
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
	public Boolean getcontainsCIP4_Locator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Locator"));
	}

	public COSObject getCIP4_LocatorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Locator"));
		return object;
	}

	@Override
	public String getCIP4_LocatorType() {
		COSObject CIP4_Locator = getCIP4_LocatorValue();
		return getObjectType(CIP4_Locator);
	}

	@Override
	public Boolean getCIP4_LocatorHasTypeString() {
		COSObject CIP4_Locator = getCIP4_LocatorValue();
		return getHasTypeString(CIP4_Locator);
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
