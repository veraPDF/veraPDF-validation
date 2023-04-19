package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colorants"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMixingHints1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADeviceNMixingHints> getMixingHints1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MixingHints"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getProcess1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADeviceNProcess> getProcess1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Process"));
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

	@Override
	public Boolean getColorantsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Colorants"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsMixingHints() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MixingHints"));
	}

	@Override
	public Boolean getMixingHintsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MixingHints"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsProcess() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Process"));
	}

	@Override
	public Boolean getProcessHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Process"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			return getSubtypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSubtypeNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "DeviceN";
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
