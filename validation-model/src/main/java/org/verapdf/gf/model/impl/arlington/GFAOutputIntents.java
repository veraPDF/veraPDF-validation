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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DestOutputProfile"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DestOutputProfileRef"));
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

	private List<ASpectralData> getSpectralData() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSpectralData2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASpectralData> getSpectralData2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpectralData"));
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

	@Override
	public Boolean getisDestOutputProfileIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DestOutputProfile"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getDestOutputProfileHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DestOutputProfile"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsDestOutputProfileRef() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DestOutputProfileRef"));
	}

	@Override
	public Boolean getDestOutputProfileRefHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DestOutputProfileRef"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Info"));
	}

	@Override
	public Boolean getInfoHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Info"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getcontainsOutputCondition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OutputCondition"));
	}

	@Override
	public Boolean getOutputConditionHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputCondition"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsOutputConditionIdentifier() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OutputConditionIdentifier"));
	}

	@Override
	public Boolean getOutputConditionIdentifierHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputConditionIdentifier"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRegistryName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RegistryName"));
	}

	@Override
	public Boolean getRegistryNameHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RegistryName"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			return getSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSpectralData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpectralData"));
	}

	@Override
	public Boolean getSpectralDataHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpectralData"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

}
