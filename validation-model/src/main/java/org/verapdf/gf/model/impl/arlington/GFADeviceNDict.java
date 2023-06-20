package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFADeviceNDict extends GFAObject implements ADeviceNDict {

	public GFADeviceNDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADeviceNDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Colorants":
				return getColorants();
			case "MixingHints":
				return getMixingHints();
			case "Process":
				return getProcess();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AColorantsDict> getColorants() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColorants1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AColorantsDict> getColorants1_3() {
		COSObject object = getColorantsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AColorantsDict> list = new ArrayList<>(1);
			list.add(new GFAColorantsDict((COSDictionary)object.getDirectBase(), this.baseObject, "Colorants"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADeviceNMixingHints> getMixingHints() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMixingHints1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADeviceNMixingHints> getMixingHints1_6() {
		COSObject object = getMixingHintsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADeviceNMixingHints> list = new ArrayList<>(1);
			list.add(new GFADeviceNMixingHints((COSDictionary)object.getDirectBase(), this.baseObject, "MixingHints"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADeviceNProcess> getProcess() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getProcess1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADeviceNProcess> getProcess1_6() {
		COSObject object = getProcessValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADeviceNProcess> list = new ArrayList<>(1);
			list.add(new GFADeviceNProcess((COSDictionary)object.getDirectBase(), this.baseObject, "Process"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsColorants() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Colorants"));
	}

	public COSObject getColorantsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colorants"));
		return object;
	}

	@Override
	public Boolean getColorantsHasTypeDictionary() {
		COSObject object = getColorantsValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsMixingHints() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MixingHints"));
	}

	public COSObject getMixingHintsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MixingHints"));
		return object;
	}

	@Override
	public Boolean getMixingHintsHasTypeDictionary() {
		COSObject object = getMixingHintsValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsProcess() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Process"));
	}

	public COSObject getProcessValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Process"));
		return object;
	}

	@Override
	public Boolean getProcessHasTypeDictionary() {
		COSObject object = getProcessValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("DeviceN");
		}
		return null;
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			object = getSubtypeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public String getparent1EntriesString() {
		if (this.parentObject == null || this.parentObject.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (this.parentObject.size() <= 1) {
			return null;
		}
		COSObject entry1 = this.parentObject.at(1);
		if (entry1 == null) {
			return null;
		}
		if (entry1.getType() == COSObjType.COS_NAME) {
			return entry1.getString();
		}
		if (entry1.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		List<String> names = new LinkedList<>();
		for (COSObject elem : (COSArray)entry1.getDirectBase()) {
			if (elem.getType() == COSObjType.COS_NAME) {
				names.add(elem.getString());
			}
		}
		return String.join("&", names);
	}

}
