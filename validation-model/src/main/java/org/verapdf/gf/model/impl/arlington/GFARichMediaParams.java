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

public class GFARichMediaParams extends GFAObject implements ARichMediaParams {

	public GFARichMediaParams(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaParams");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CuePoints":
				return getCuePoints();
			case "FlashVars":
				return getFlashVars();
			case "Settings":
				return getSettings();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfRichMediaCuePoints> getCuePoints() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getCuePoints1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRichMediaCuePoints> getCuePoints1_7() {
		COSObject object = getCuePointsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfRichMediaCuePoints> list = new ArrayList<>(1);
			list.add(new GFAArrayOfRichMediaCuePoints((COSArray)object.getDirectBase(), this.baseObject, "CuePoints"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getFlashVars() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getFlashVars1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getFlashVars1_7() {
		COSObject object = getFlashVarsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "FlashVars"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getSettings() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getSettings1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getSettings1_7() {
		COSObject object = getSettingsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Settings"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBinding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Binding"));
	}

	public COSObject getBindingDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getBindingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Binding"));
		if (object == null || object.empty()) {
			object = getBindingDefaultValue();
		}
		return object;
	}

	@Override
	public String getBindingType() {
		COSObject Binding = getBindingValue();
		return getObjectType(Binding);
	}

	@Override
	public Boolean getBindingHasTypeName() {
		COSObject Binding = getBindingValue();
		return getHasTypeName(Binding);
	}

	@Override
	public String getBindingNameValue() {
		COSObject Binding = getBindingValue();
		return getNameValue(Binding);
	}

	@Override
	public Boolean getcontainsBindingMaterial() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BindingMaterial"));
	}

	public COSObject getBindingMaterialValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BindingMaterial"));
		return object;
	}

	@Override
	public String getBindingMaterialType() {
		COSObject BindingMaterial = getBindingMaterialValue();
		return getObjectType(BindingMaterial);
	}

	@Override
	public Boolean getBindingMaterialHasTypeStringText() {
		COSObject BindingMaterial = getBindingMaterialValue();
		return getHasTypeStringText(BindingMaterial);
	}

	@Override
	public Boolean getcontainsCuePoints() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CuePoints"));
	}

	public COSObject getCuePointsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CuePoints"));
		return object;
	}

	@Override
	public String getCuePointsType() {
		COSObject CuePoints = getCuePointsValue();
		return getObjectType(CuePoints);
	}

	@Override
	public Boolean getCuePointsHasTypeArray() {
		COSObject CuePoints = getCuePointsValue();
		return getHasTypeArray(CuePoints);
	}

	@Override
	public Boolean getcontainsFlashVars() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FlashVars"));
	}

	public COSObject getFlashVarsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FlashVars"));
		return object;
	}

	@Override
	public Boolean getisFlashVarsIndirect() {
		COSObject FlashVars = getFlashVarsValue();
		return getisIndirect(FlashVars);
	}

	@Override
	public String getFlashVarsType() {
		COSObject FlashVars = getFlashVarsValue();
		return getObjectType(FlashVars);
	}

	@Override
	public Boolean getFlashVarsHasTypeStream() {
		COSObject FlashVars = getFlashVarsValue();
		return getHasTypeStream(FlashVars);
	}

	@Override
	public Boolean getFlashVarsHasTypeStringText() {
		COSObject FlashVars = getFlashVarsValue();
		return getHasTypeStringText(FlashVars);
	}

	@Override
	public Boolean getcontainsSettings() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Settings"));
	}

	public COSObject getSettingsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Settings"));
		return object;
	}

	@Override
	public Boolean getisSettingsIndirect() {
		COSObject Settings = getSettingsValue();
		return getisIndirect(Settings);
	}

	@Override
	public String getSettingsType() {
		COSObject Settings = getSettingsValue();
		return getObjectType(Settings);
	}

	@Override
	public Boolean getSettingsHasTypeStream() {
		COSObject Settings = getSettingsValue();
		return getHasTypeStream(Settings);
	}

	@Override
	public Boolean getSettingsHasTypeStringText() {
		COSObject Settings = getSettingsValue();
		return getHasTypeStringText(Settings);
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
