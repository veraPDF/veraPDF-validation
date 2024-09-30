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

public class GFACIP4_AssemblingIntent extends GFAObject implements ACIP4_AssemblingIntent {

	public GFACIP4_AssemblingIntent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_AssemblingIntent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_AssemblyItem":
				return getCIP4_AssemblyItem();
			case "CIP4_BindIn":
				return getCIP4_BindIn();
			case "CIP4_BlowIn":
				return getCIP4_BlowIn();
			case "CIP4_Container":
				return getCIP4_Container();
			case "CIP4_StickOn":
				return getCIP4_StickOn();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_AssemblyItem> getCIP4_AssemblyItem() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_AssemblyItem1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_AssemblyItem> getCIP4_AssemblyItem1_7() {
		COSObject object = getCIP4_AssemblyItemValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_AssemblyItem> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_AssemblyItem((COSArray)object.getDirectBase(), this.baseObject, "CIP4_AssemblyItem"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_BindIn> getCIP4_BindIn() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_BindIn1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_BindIn> getCIP4_BindIn1_7() {
		COSObject object = getCIP4_BindInValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_BindIn> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_BindIn((COSArray)object.getDirectBase(), this.baseObject, "CIP4_BindIn"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_BlowIn> getCIP4_BlowIn() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_BlowIn1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_BlowIn> getCIP4_BlowIn1_7() {
		COSObject object = getCIP4_BlowInValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_BlowIn> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_BlowIn((COSArray)object.getDirectBase(), this.baseObject, "CIP4_BlowIn"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADPart> getCIP4_Container() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Container1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPart> getCIP4_Container1_7() {
		COSObject object = getCIP4_ContainerValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADPart> list = new ArrayList<>(1);
			list.add(new GFADPart((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Container"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_StickOn> getCIP4_StickOn() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_StickOn1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_StickOn> getCIP4_StickOn1_7() {
		COSObject object = getCIP4_StickOnValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_StickOn> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_StickOn((COSArray)object.getDirectBase(), this.baseObject, "CIP4_StickOn"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_AssemblyItem() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_AssemblyItem"));
	}

	public COSObject getCIP4_AssemblyItemValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_AssemblyItem"));
		return object;
	}

	@Override
	public String getCIP4_AssemblyItemType() {
		COSObject CIP4_AssemblyItem = getCIP4_AssemblyItemValue();
		return getObjectType(CIP4_AssemblyItem);
	}

	@Override
	public Boolean getCIP4_AssemblyItemHasTypeArray() {
		COSObject CIP4_AssemblyItem = getCIP4_AssemblyItemValue();
		return getHasTypeArray(CIP4_AssemblyItem);
	}

	@Override
	public Boolean getcontainsCIP4_BindIn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_BindIn"));
	}

	public COSObject getCIP4_BindInValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_BindIn"));
		return object;
	}

	@Override
	public String getCIP4_BindInType() {
		COSObject CIP4_BindIn = getCIP4_BindInValue();
		return getObjectType(CIP4_BindIn);
	}

	@Override
	public Boolean getCIP4_BindInHasTypeArray() {
		COSObject CIP4_BindIn = getCIP4_BindInValue();
		return getHasTypeArray(CIP4_BindIn);
	}

	@Override
	public Boolean getcontainsCIP4_BlowIn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_BlowIn"));
	}

	public COSObject getCIP4_BlowInValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_BlowIn"));
		return object;
	}

	@Override
	public String getCIP4_BlowInType() {
		COSObject CIP4_BlowIn = getCIP4_BlowInValue();
		return getObjectType(CIP4_BlowIn);
	}

	@Override
	public Boolean getCIP4_BlowInHasTypeArray() {
		COSObject CIP4_BlowIn = getCIP4_BlowInValue();
		return getHasTypeArray(CIP4_BlowIn);
	}

	@Override
	public Boolean getcontainsCIP4_Container() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Container"));
	}

	public COSObject getCIP4_ContainerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Container"));
		return object;
	}

	@Override
	public Boolean getisCIP4_ContainerIndirect() {
		COSObject CIP4_Container = getCIP4_ContainerValue();
		return getisIndirect(CIP4_Container);
	}

	@Override
	public String getCIP4_ContainerType() {
		COSObject CIP4_Container = getCIP4_ContainerValue();
		return getObjectType(CIP4_Container);
	}

	@Override
	public Boolean getCIP4_ContainerHasTypeDictionary() {
		COSObject CIP4_Container = getCIP4_ContainerValue();
		return getHasTypeDictionary(CIP4_Container);
	}

	@Override
	public Boolean getcontainsCIP4_StickOn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_StickOn"));
	}

	public COSObject getCIP4_StickOnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_StickOn"));
		return object;
	}

	@Override
	public String getCIP4_StickOnType() {
		COSObject CIP4_StickOn = getCIP4_StickOnValue();
		return getObjectType(CIP4_StickOn);
	}

	@Override
	public Boolean getCIP4_StickOnHasTypeArray() {
		COSObject CIP4_StickOn = getCIP4_StickOnValue();
		return getHasTypeArray(CIP4_StickOn);
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
