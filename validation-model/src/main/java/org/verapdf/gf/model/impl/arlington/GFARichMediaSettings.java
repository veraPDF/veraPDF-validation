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

public class GFARichMediaSettings extends GFAObject implements ARichMediaSettings {

	public GFARichMediaSettings(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaSettings");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Activation":
				return getActivation();
			case "Deactivation":
				return getDeactivation();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaActivation> getActivation() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getActivation1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaActivation> getActivation1_7() {
		COSObject object = getActivationValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaActivation> list = new ArrayList<>(1);
			list.add(new GFARichMediaActivation((COSDictionary)object.getDirectBase(), this.baseObject, "Activation"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaDeactivation> getDeactivation() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDeactivation1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaDeactivation> getDeactivation1_7() {
		COSObject object = getDeactivationValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaDeactivation> list = new ArrayList<>(1);
			list.add(new GFARichMediaDeactivation((COSDictionary)object.getDirectBase(), this.baseObject, "Deactivation"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsActivation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Activation"));
	}

	public COSObject getActivationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Activation"));
		return object;
	}

	@Override
	public String getActivationType() {
		COSObject Activation = getActivationValue();
		return getObjectType(Activation);
	}

	@Override
	public Boolean getActivationHasTypeDictionary() {
		COSObject Activation = getActivationValue();
		return getHasTypeDictionary(Activation);
	}

	@Override
	public Boolean getcontainsDeactivation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Deactivation"));
	}

	public COSObject getDeactivationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Deactivation"));
		return object;
	}

	@Override
	public String getDeactivationType() {
		COSObject Deactivation = getDeactivationValue();
		return getObjectType(Deactivation);
	}

	@Override
	public Boolean getDeactivationHasTypeDictionary() {
		COSObject Deactivation = getDeactivationValue();
		return getHasTypeDictionary(Deactivation);
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
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
