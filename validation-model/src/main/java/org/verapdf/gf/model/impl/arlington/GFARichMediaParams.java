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
				return getCuePoints1_7();
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
				return getFlashVars1_7();
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
				return getSettings1_7();
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
	public Boolean getBindingHasTypeName() {
		COSObject object = getBindingValue();
		return getHasTypeName(object);
	}

	@Override
	public String getBindingNameValue() {
		COSObject object = getBindingValue();
		return getNameValue(object);
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
	public Boolean getBindingMaterialHasTypeStringText() {
		COSObject object = getBindingMaterialValue();
		return getHasTypeStringText(object);
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
	public Boolean getCuePointsHasTypeArray() {
		COSObject object = getCuePointsValue();
		return getHasTypeArray(object);
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
		COSObject object = getFlashVarsValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getFlashVarsHasTypeStream() {
		COSObject object = getFlashVarsValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getFlashVarsHasTypeStringText() {
		COSObject object = getFlashVarsValue();
		return getHasTypeStringText(object);
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
		COSObject object = getSettingsValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getSettingsHasTypeStream() {
		COSObject object = getSettingsValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getSettingsHasTypeStringText() {
		COSObject object = getSettingsValue();
		return getHasTypeStringText(object);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
