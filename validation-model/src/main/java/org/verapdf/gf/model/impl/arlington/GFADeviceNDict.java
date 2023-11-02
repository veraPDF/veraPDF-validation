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
	public String getColorantsType() {
		COSObject Colorants = getColorantsValue();
		return getObjectType(Colorants);
	}

	@Override
	public Boolean getColorantsHasTypeDictionary() {
		COSObject Colorants = getColorantsValue();
		return getHasTypeDictionary(Colorants);
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
	public String getMixingHintsType() {
		COSObject MixingHints = getMixingHintsValue();
		return getObjectType(MixingHints);
	}

	@Override
	public Boolean getMixingHintsHasTypeDictionary() {
		COSObject MixingHints = getMixingHintsValue();
		return getHasTypeDictionary(MixingHints);
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
	public String getProcessType() {
		COSObject Process = getProcessValue();
		return getObjectType(Process);
	}

	@Override
	public Boolean getProcessHasTypeDictionary() {
		COSObject Process = getProcessValue();
		return getHasTypeDictionary(Process);
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
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
	}

	public COSObject getparent1Value() {
		if (this.parentObject == null || this.parentObject.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (this.parentObject.size() <= 1) {
			return null;
		}
		COSObject entry1 = this.parentObject.at(1);
		return entry1;
	}

	@Override
	public String getparent1EntriesString() {
		COSObject parent1 = getparent1Value();
		return getEntriesString(parent1);
	}

}
