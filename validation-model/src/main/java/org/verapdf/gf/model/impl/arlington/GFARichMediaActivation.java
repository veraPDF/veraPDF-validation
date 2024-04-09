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

public class GFARichMediaActivation extends GFAObject implements ARichMediaActivation {

	public GFARichMediaActivation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaActivation");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Animation":
				return getAnimation();
			case "Configuration":
				return getConfiguration();
			case "Presentation":
				return getPresentation();
			case "Scripts":
				return getScripts();
			case "View":
				return getView();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaAnimation> getAnimation() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAnimation1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaAnimation> getAnimation1_7() {
		COSObject object = getAnimationValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaAnimation> list = new ArrayList<>(1);
			list.add(new GFARichMediaAnimation((COSDictionary)object.getDirectBase(), this.baseObject, "Animation"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaConfiguration> getConfiguration() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getConfiguration1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaConfiguration> getConfiguration1_7() {
		COSObject object = getConfigurationValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaConfiguration> list = new ArrayList<>(1);
			list.add(new GFARichMediaConfiguration((COSDictionary)object.getDirectBase(), this.baseObject, "Configuration"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaPresentation> getPresentation() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPresentation1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaPresentation> getPresentation1_7() {
		COSObject object = getPresentationValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaPresentation> list = new ArrayList<>(1);
			list.add(new GFARichMediaPresentation((COSDictionary)object.getDirectBase(), this.baseObject, "Presentation"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfIndirectFileSpecifications> getScripts() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getScripts1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfIndirectFileSpecifications> getScripts1_7() {
		COSObject object = getScriptsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfIndirectFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfIndirectFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "Scripts"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A3DViewAddEntries> getView() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getView1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DViewAddEntries> getView1_7() {
		COSObject object = getViewValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DViewAddEntries> list = new ArrayList<>(1);
			list.add(new GFA3DViewAddEntries((COSDictionary)object.getDirectBase(), this.baseObject, "View"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAnimation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Animation"));
	}

	public COSObject getAnimationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Animation"));
		return object;
	}

	@Override
	public String getAnimationType() {
		COSObject Animation = getAnimationValue();
		return getObjectType(Animation);
	}

	@Override
	public Boolean getAnimationHasTypeDictionary() {
		COSObject Animation = getAnimationValue();
		return getHasTypeDictionary(Animation);
	}

	@Override
	public Boolean getcontainsCondition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Condition"));
	}

	public COSObject getConditionDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("XA");
		}
		return null;
	}

	public COSObject getConditionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Condition"));
		if (object == null || object.empty()) {
			object = getConditionDefaultValue();
		}
		return object;
	}

	@Override
	public String getConditionType() {
		COSObject Condition = getConditionValue();
		return getObjectType(Condition);
	}

	@Override
	public Boolean getConditionHasTypeName() {
		COSObject Condition = getConditionValue();
		return getHasTypeName(Condition);
	}

	@Override
	public String getConditionNameValue() {
		COSObject Condition = getConditionValue();
		return getNameValue(Condition);
	}

	@Override
	public Boolean getcontainsConfiguration() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Configuration"));
	}

	public COSObject getConfigurationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configuration"));
		return object;
	}

	@Override
	public Boolean getisConfigurationIndirect() {
		COSObject Configuration = getConfigurationValue();
		return getisIndirect(Configuration);
	}

	@Override
	public String getConfigurationType() {
		COSObject Configuration = getConfigurationValue();
		return getObjectType(Configuration);
	}

	@Override
	public Boolean getConfigurationHasTypeDictionary() {
		COSObject Configuration = getConfigurationValue();
		return getHasTypeDictionary(Configuration);
	}

	@Override
	public Boolean getcontainsPresentation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Presentation"));
	}

	public COSObject getPresentationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Presentation"));
		return object;
	}

	@Override
	public String getPresentationType() {
		COSObject Presentation = getPresentationValue();
		return getObjectType(Presentation);
	}

	@Override
	public Boolean getPresentationHasTypeDictionary() {
		COSObject Presentation = getPresentationValue();
		return getHasTypeDictionary(Presentation);
	}

	@Override
	public Boolean getcontainsScripts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Scripts"));
	}

	public COSObject getScriptsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scripts"));
		return object;
	}

	@Override
	public String getScriptsType() {
		COSObject Scripts = getScriptsValue();
		return getObjectType(Scripts);
	}

	@Override
	public Boolean getScriptsHasTypeArray() {
		COSObject Scripts = getScriptsValue();
		return getHasTypeArray(Scripts);
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

	@Override
	public Boolean getcontainsView() {
		return this.baseObject.knownKey(ASAtom.getASAtom("View"));
	}

	public COSObject getViewValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		return object;
	}

	@Override
	public Boolean getisViewIndirect() {
		COSObject View = getViewValue();
		return getisIndirect(View);
	}

	@Override
	public String getViewType() {
		COSObject View = getViewValue();
		return getObjectType(View);
	}

	@Override
	public Boolean getViewHasTypeDictionary() {
		COSObject View = getViewValue();
		return getHasTypeDictionary(View);
	}

}
