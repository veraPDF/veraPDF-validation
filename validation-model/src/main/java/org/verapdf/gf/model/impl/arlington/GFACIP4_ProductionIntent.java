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

public class GFACIP4_ProductionIntent extends GFAObject implements ACIP4_ProductionIntent {

	public GFACIP4_ProductionIntent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_ProductionIntent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_PrintProcess":
				return getCIP4_PrintProcess();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_PrintProcess> getCIP4_PrintProcess() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_PrintProcess1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_PrintProcess> getCIP4_PrintProcess1_7() {
		COSObject object = getCIP4_PrintProcessValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_PrintProcess> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_PrintProcess((COSArray)object.getDirectBase(), this.baseObject, "CIP4_PrintProcess"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_PrintPreference() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_PrintPreference"));
	}

	public COSObject getCIP4_PrintPreferenceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_PrintPreference"));
		return object;
	}

	@Override
	public String getCIP4_PrintPreferenceType() {
		COSObject CIP4_PrintPreference = getCIP4_PrintPreferenceValue();
		return getObjectType(CIP4_PrintPreference);
	}

	@Override
	public Boolean getCIP4_PrintPreferenceHasTypeName() {
		COSObject CIP4_PrintPreference = getCIP4_PrintPreferenceValue();
		return getHasTypeName(CIP4_PrintPreference);
	}

	@Override
	public String getCIP4_PrintPreferenceNameValue() {
		COSObject CIP4_PrintPreference = getCIP4_PrintPreferenceValue();
		return getNameValue(CIP4_PrintPreference);
	}

	@Override
	public Boolean getcontainsCIP4_PrintProcess() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_PrintProcess"));
	}

	public COSObject getCIP4_PrintProcessValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_PrintProcess"));
		return object;
	}

	@Override
	public String getCIP4_PrintProcessType() {
		COSObject CIP4_PrintProcess = getCIP4_PrintProcessValue();
		return getObjectType(CIP4_PrintProcess);
	}

	@Override
	public Boolean getCIP4_PrintProcessHasTypeArray() {
		COSObject CIP4_PrintProcess = getCIP4_PrintProcessValue();
		return getHasTypeArray(CIP4_PrintProcess);
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
