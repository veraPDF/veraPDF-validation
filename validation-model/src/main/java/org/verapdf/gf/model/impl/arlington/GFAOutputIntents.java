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
		COSObject DestOutputProfile = getDestOutputProfileValue();
		return getisIndirect(DestOutputProfile);
	}

	@Override
	public String getDestOutputProfileType() {
		COSObject DestOutputProfile = getDestOutputProfileValue();
		return getObjectType(DestOutputProfile);
	}

	@Override
	public Boolean getDestOutputProfileHasTypeStream() {
		COSObject DestOutputProfile = getDestOutputProfileValue();
		return getHasTypeStream(DestOutputProfile);
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
	public String getDestOutputProfileRefType() {
		COSObject DestOutputProfileRef = getDestOutputProfileRefValue();
		return getObjectType(DestOutputProfileRef);
	}

	@Override
	public Boolean getDestOutputProfileRefHasTypeDictionary() {
		COSObject DestOutputProfileRef = getDestOutputProfileRefValue();
		return getHasTypeDictionary(DestOutputProfileRef);
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
	public String getInfoType() {
		COSObject Info = getInfoValue();
		return getObjectType(Info);
	}

	@Override
	public Boolean getInfoHasTypeStringText() {
		COSObject Info = getInfoValue();
		return getHasTypeStringText(Info);
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
	public Boolean getcontainsOutputCondition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OutputCondition"));
	}

	public COSObject getOutputConditionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputCondition"));
		return object;
	}

	@Override
	public String getOutputConditionType() {
		COSObject OutputCondition = getOutputConditionValue();
		return getObjectType(OutputCondition);
	}

	@Override
	public Boolean getOutputConditionHasTypeStringText() {
		COSObject OutputCondition = getOutputConditionValue();
		return getHasTypeStringText(OutputCondition);
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
	public String getOutputConditionIdentifierType() {
		COSObject OutputConditionIdentifier = getOutputConditionIdentifierValue();
		return getObjectType(OutputConditionIdentifier);
	}

	@Override
	public Boolean getOutputConditionIdentifierHasTypeStringText() {
		COSObject OutputConditionIdentifier = getOutputConditionIdentifierValue();
		return getHasTypeStringText(OutputConditionIdentifier);
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
	public String getRegistryNameType() {
		COSObject RegistryName = getRegistryNameValue();
		return getObjectType(RegistryName);
	}

	@Override
	public Boolean getRegistryNameHasTypeStringText() {
		COSObject RegistryName = getRegistryNameValue();
		return getHasTypeStringText(RegistryName);
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
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject S = getSValue();
		return getHasTypeName(S);
	}

	@Override
	public String getSNameValue() {
		COSObject S = getSValue();
		return getNameValue(S);
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
	public String getSpectralDataType() {
		COSObject SpectralData = getSpectralDataValue();
		return getObjectType(SpectralData);
	}

	@Override
	public Boolean getSpectralDataHasTypeDictionary() {
		COSObject SpectralData = getSpectralDataValue();
		return getHasTypeDictionary(SpectralData);
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
