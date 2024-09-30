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

public class GFACIP4_Production extends GFAObject implements ACIP4_Production {

	public GFACIP4_Production(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_Production");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_Resource":
				return getCIP4_Resource();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_Resource> getCIP4_Resource() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Resource1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_Resource> getCIP4_Resource1_7() {
		COSObject object = getCIP4_ResourceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_Resource> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_Resource((COSArray)object.getDirectBase(), this.baseObject, "CIP4_Resource"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_CopyCount() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_CopyCount"));
	}

	public COSObject getCIP4_CopyCountValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_CopyCount"));
		return object;
	}

	@Override
	public String getCIP4_CopyCountType() {
		COSObject CIP4_CopyCount = getCIP4_CopyCountValue();
		return getObjectType(CIP4_CopyCount);
	}

	@Override
	public Boolean getCIP4_CopyCountHasTypeInteger() {
		COSObject CIP4_CopyCount = getCIP4_CopyCountValue();
		return getHasTypeInteger(CIP4_CopyCount);
	}

	@Override
	public Long getCIP4_CopyCountIntegerValue() {
		COSObject CIP4_CopyCount = getCIP4_CopyCountValue();
		return getIntegerValue(CIP4_CopyCount);
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
	public Boolean getcontainsCIP4_Resource() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Resource"));
	}

	public COSObject getCIP4_ResourceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Resource"));
		return object;
	}

	@Override
	public String getCIP4_ResourceType() {
		COSObject CIP4_Resource = getCIP4_ResourceValue();
		return getObjectType(CIP4_Resource);
	}

	@Override
	public Boolean getCIP4_ResourceHasTypeArray() {
		COSObject CIP4_Resource = getCIP4_ResourceValue();
		return getHasTypeArray(CIP4_Resource);
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
