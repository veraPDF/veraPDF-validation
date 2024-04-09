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

public class GFAGTS_ProcStepsGroup extends GFAObject implements AGTS_ProcStepsGroup {

	public GFAGTS_ProcStepsGroup(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AGTS_ProcStepsGroup");
	}

	@Override
	public Boolean getcontainsGTS_ProcStepsGroup() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_ProcStepsGroup"));
	}

	public COSObject getGTS_ProcStepsGroupValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_ProcStepsGroup"));
		return object;
	}

	@Override
	public String getGTS_ProcStepsGroupType() {
		COSObject GTS_ProcStepsGroup = getGTS_ProcStepsGroupValue();
		return getObjectType(GTS_ProcStepsGroup);
	}

	@Override
	public Boolean getGTS_ProcStepsGroupHasTypeName() {
		COSObject GTS_ProcStepsGroup = getGTS_ProcStepsGroupValue();
		return getHasTypeName(GTS_ProcStepsGroup);
	}

	@Override
	public String getGTS_ProcStepsGroupNameValue() {
		COSObject GTS_ProcStepsGroup = getGTS_ProcStepsGroupValue();
		return getNameValue(GTS_ProcStepsGroup);
	}

	@Override
	public Boolean getcontainsGTS_ProcStepsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_ProcStepsType"));
	}

	public COSObject getGTS_ProcStepsTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_ProcStepsType"));
		return object;
	}

	@Override
	public String getGTS_ProcStepsTypeType() {
		COSObject GTS_ProcStepsType = getGTS_ProcStepsTypeValue();
		return getObjectType(GTS_ProcStepsType);
	}

	@Override
	public Boolean getGTS_ProcStepsTypeHasTypeName() {
		COSObject GTS_ProcStepsType = getGTS_ProcStepsTypeValue();
		return getHasTypeName(GTS_ProcStepsType);
	}

	@Override
	public String getGTS_ProcStepsTypeNameValue() {
		COSObject GTS_ProcStepsType = getGTS_ProcStepsTypeValue();
		return getNameValue(GTS_ProcStepsType);
	}

	@Override
	public Boolean getcontainsGWG__ProcStepsColorants() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GWG__ProcStepsColorants"));
	}

	public COSObject getGWG__ProcStepsColorantsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GWG__ProcStepsColorants"));
		return object;
	}

	@Override
	public String getGWG__ProcStepsColorantsType() {
		COSObject GWG__ProcStepsColorants = getGWG__ProcStepsColorantsValue();
		return getObjectType(GWG__ProcStepsColorants);
	}

	@Override
	public Boolean getGWG__ProcStepsColorantsHasTypeName() {
		COSObject GWG__ProcStepsColorants = getGWG__ProcStepsColorantsValue();
		return getHasTypeName(GWG__ProcStepsColorants);
	}

}
