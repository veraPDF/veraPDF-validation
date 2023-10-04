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

public class GFAOptContentConfig extends GFAObject implements AOptContentConfig {

	public GFAOptContentConfig(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentConfig");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AS":
				return getAS();
			case "Intent":
				return getIntent();
			case "Locked":
				return getLocked();
			case "OFF":
				return getOFF();
			case "ON":
				return getON();
			case "Order":
				return getOrder();
			case "RBGroups":
				return getRBGroups();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfOCUsage> getAS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAS1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOCUsage> getAS1_5() {
		COSObject object = getASValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOCUsage> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOCUsage((COSArray)object.getDirectBase(), this.baseObject, "AS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNamesGeneral> getIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIntent1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesGeneral> getIntent1_5() {
		COSObject object = getIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesGeneral((COSArray)object.getDirectBase(), this.baseObject, "Intent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOptContentGroups> getLocked() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLocked1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOptContentGroups> getLocked1_6() {
		COSObject object = getLockedValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOptContentGroups> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOptContentGroups((COSArray)object.getDirectBase(), this.baseObject, "Locked"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOptContentGroups> getOFF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOFF1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOptContentGroups> getOFF1_5() {
		COSObject object = getOFFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOptContentGroups> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOptContentGroups((COSArray)object.getDirectBase(), this.baseObject, "OFF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOptContentGroups> getON() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getON1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOptContentGroups> getON1_5() {
		COSObject object = getONValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOptContentGroups> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOptContentGroups((COSArray)object.getDirectBase(), this.baseObject, "ON"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOptContentOrderElements> getOrder() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOrder1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOptContentOrderElements> getOrder1_5() {
		COSObject object = getOrderValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOptContentOrderElements> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOptContentOrderElements((COSArray)object.getDirectBase(), this.baseObject, "Order"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfArraysRBGroups> getRBGroups() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRBGroups1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfArraysRBGroups> getRBGroups1_5() {
		COSObject object = getRBGroupsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfArraysRBGroups> list = new ArrayList<>(1);
			list.add(new GFAArrayOfArraysRBGroups((COSArray)object.getDirectBase(), this.baseObject, "RBGroups"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AS"));
	}

	public COSObject getASValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AS"));
		return object;
	}

	@Override
	public Boolean getASHasTypeArray() {
		COSObject AS = getASValue();
		return getHasTypeArray(AS);
	}

	@Override
	public Boolean getcontainsBaseState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaseState"));
	}

	public COSObject getBaseStateDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("ON");
		}
		return null;
	}

	public COSObject getBaseStateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseState"));
		if (object == null || object.empty()) {
			object = getBaseStateDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getBaseStateHasTypeName() {
		COSObject BaseState = getBaseStateValue();
		return getHasTypeName(BaseState);
	}

	@Override
	public String getBaseStateNameValue() {
		COSObject BaseState = getBaseStateValue();
		return getNameValue(BaseState);
	}

	@Override
	public Boolean getcontainsCreator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Creator"));
	}

	public COSObject getCreatorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Creator"));
		return object;
	}

	@Override
	public Boolean getCreatorHasTypeStringText() {
		COSObject Creator = getCreatorValue();
		return getHasTypeStringText(Creator);
	}

	@Override
	public Boolean getcontainsIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Intent"));
	}

	public COSObject getIntentDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("View");
		}
		return null;
	}

	public COSObject getIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Intent"));
		if (object == null || object.empty()) {
			object = getIntentDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getIntentHasTypeArray() {
		COSObject Intent = getIntentValue();
		return getHasTypeArray(Intent);
	}

	@Override
	public Boolean getIntentHasTypeName() {
		COSObject Intent = getIntentValue();
		return getHasTypeName(Intent);
	}

	@Override
	public String getIntentNameValue() {
		COSObject Intent = getIntentValue();
		return getNameValue(Intent);
	}

	@Override
	public Boolean getcontainsListMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ListMode"));
	}

	public COSObject getListModeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("AllPages");
		}
		return null;
	}

	public COSObject getListModeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ListMode"));
		if (object == null || object.empty()) {
			object = getListModeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getListModeHasTypeName() {
		COSObject ListMode = getListModeValue();
		return getHasTypeName(ListMode);
	}

	@Override
	public String getListModeNameValue() {
		COSObject ListMode = getListModeValue();
		return getNameValue(ListMode);
	}

	@Override
	public Boolean getcontainsLocked() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Locked"));
	}

	public COSObject getLockedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Locked"));
		return object;
	}

	@Override
	public Boolean getLockedHasTypeArray() {
		COSObject Locked = getLockedValue();
		return getHasTypeArray(Locked);
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object;
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject Name = getNameValue();
		return getHasTypeStringText(Name);
	}

	@Override
	public Boolean getcontainsOFF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OFF"));
	}

	public COSObject getOFFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OFF"));
		return object;
	}

	@Override
	public Boolean getOFFHasTypeArray() {
		COSObject OFF = getOFFValue();
		return getHasTypeArray(OFF);
	}

	@Override
	public Boolean getcontainsON() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ON"));
	}

	public COSObject getONValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ON"));
		return object;
	}

	@Override
	public Boolean getONHasTypeArray() {
		COSObject ON = getONValue();
		return getHasTypeArray(ON);
	}

	@Override
	public Boolean getcontainsOrder() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Order"));
	}

	public COSObject getOrderValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Order"));
		return object;
	}

	@Override
	public Boolean getOrderHasTypeArray() {
		COSObject Order = getOrderValue();
		return getHasTypeArray(Order);
	}

	@Override
	public Boolean getcontainsRBGroups() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RBGroups"));
	}

	public COSObject getRBGroupsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RBGroups"));
		return object;
	}

	@Override
	public Boolean getRBGroupsHasTypeArray() {
		COSObject RBGroups = getRBGroupsValue();
		return getHasTypeArray(RBGroups);
	}

}
