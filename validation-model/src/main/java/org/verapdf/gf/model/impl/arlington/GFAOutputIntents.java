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

public class GFAOutputIntents extends GFAObject implements AOutputIntents {

	public GFAOutputIntents(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOutputIntents");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DestOutputProfile":
				return getDestOutputProfile();
			case "DestOutputProfileRef":
				return getDestOutputProfileRef();
			case "MixingHints":
				return getMixingHints();
			case "SpectralData":
				return getSpectralData();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AICCProfileStream> getDestOutputProfile() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDestOutputProfile1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AICCProfileStream> getDestOutputProfile1_4() {
		COSObject object = getDestOutputProfileValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AICCProfileStream> list = new ArrayList<>(1);
			list.add(new GFAICCProfileStream((COSStream)object.getDirectBase(), this.baseObject, "DestOutputProfile"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADestOutputProfileRef> getDestOutputProfileRef() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getDestOutputProfileRef2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADestOutputProfileRef> getDestOutputProfileRef2_0() {
		COSObject object = getDestOutputProfileRefValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADestOutputProfileRef> list = new ArrayList<>(1);
			list.add(new GFADestOutputProfileRef((COSDictionary)object.getDirectBase(), this.baseObject, "DestOutputProfileRef"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADeviceNMixingHints> getMixingHints() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getMixingHints2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADeviceNMixingHints> getMixingHints2_0() {
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

	private List<ASpectralData> getSpectralData() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSpectralData2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASpectralData> getSpectralData2_0() {
		COSObject object = getSpectralDataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASpectralData> list = new ArrayList<>(1);
			list.add(new GFASpectralData((COSDictionary)object.getDirectBase(), this.baseObject, "SpectralData"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDestOutputProfile() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DestOutputProfile"));
	}

	public COSObject getDestOutputProfileValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DestOutputProfile"));
		return object;
	}

	@Override
	public Boolean getisDestOutputProfileIndirect() {
		COSObject object = getDestOutputProfileValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getDestOutputProfileHasTypeStream() {
		COSObject object = getDestOutputProfileValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getcontainsDestOutputProfileRef() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DestOutputProfileRef"));
	}

	public COSObject getDestOutputProfileRefValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DestOutputProfileRef"));
		return object;
	}

	@Override
	public Boolean getDestOutputProfileRefHasTypeDictionary() {
		COSObject object = getDestOutputProfileRefValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Info"));
	}

	public COSObject getInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Info"));
		return object;
	}

	@Override
	public Boolean getInfoHasTypeStringText() {
		COSObject object = getInfoValue();
		return getHasTypeStringText(object);
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
	public Boolean getcontainsOutputCondition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OutputCondition"));
	}

	public COSObject getOutputConditionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputCondition"));
		return object;
	}

	@Override
	public Boolean getOutputConditionHasTypeStringText() {
		COSObject object = getOutputConditionValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsOutputConditionIdentifier() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OutputConditionIdentifier"));
	}

	public COSObject getOutputConditionIdentifierValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputConditionIdentifier"));
		return object;
	}

	@Override
	public Boolean getOutputConditionIdentifierHasTypeStringText() {
		COSObject object = getOutputConditionIdentifierValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsRegistryName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RegistryName"));
	}

	public COSObject getRegistryNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RegistryName"));
		return object;
	}

	@Override
	public Boolean getRegistryNameHasTypeStringText() {
		COSObject object = getRegistryNameValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object;
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject object = getSValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSNameValue() {
		COSObject object = getSValue();
		return getNameValue(object);
	}

	@Override
	public Boolean getcontainsSpectralData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpectralData"));
	}

	public COSObject getSpectralDataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpectralData"));
		return object;
	}

	@Override
	public Boolean getSpectralDataHasTypeDictionary() {
		COSObject object = getSpectralDataValue();
		return getHasTypeDictionary(object);
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
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		return getNameValue(object);
	}

}
