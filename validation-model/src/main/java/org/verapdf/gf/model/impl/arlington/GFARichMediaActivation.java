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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Animation"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configuration"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Presentation"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scripts"));
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

	private List<org.verapdf.model.baselayer.Object> getView() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getView1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getView1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getViewDictionary1_7(object.getDirectBase(), "View");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getViewDictionary1_7(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("Snapshot"))) {
			return new GFA3DViewAddEntries(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("Params"))) {
			return new GFA3DViewAddEntries(base, this.baseObject, keyName);
		}
		return new GFA3DView(base, this.baseObject, keyName);
	}

	@Override
	public Boolean getcontainsAnimation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Animation"));
	}

	@Override
	public Boolean getAnimationHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Animation"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsCondition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Condition"));
	}

	@Override
	public Boolean getConditionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Condition"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getConditionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Condition"));
		if (object == null || object.empty()) {
			return getConditionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getConditionNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "XA";
		}
		return null;
	}

	@Override
	public Boolean getcontainsConfiguration() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Configuration"));
	}

	@Override
	public Boolean getisConfigurationIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configuration"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getConfigurationHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configuration"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPresentation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Presentation"));
	}

	@Override
	public Boolean getPresentationHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Presentation"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsScripts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Scripts"));
	}

	@Override
	public Boolean getScriptsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scripts"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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

	@Override
	public Boolean getcontainsView() {
		return this.baseObject.knownKey(ASAtom.getASAtom("View"));
	}

	@Override
	public Boolean getisViewIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getViewHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("View"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
