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

public class GFAPointData extends GFAObject implements APointData {

	public GFAPointData(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APointData");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Names":
				return getNames();
			case "XPTS":
				return getXPTS();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNamesInPtData> getNames() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getNames1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getNames1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesInPtData> getNames1_7() {
		COSObject object = getNamesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesInPtData> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesInPtData((COSArray)object.getDirectBase(), this.baseObject, "Names"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfArraysXPTSValues> getXPTS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getXPTS1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getXPTS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfArraysXPTSValues> getXPTS1_7() {
		COSObject object = getXPTSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfArraysXPTSValues> list = new ArrayList<>(1);
			list.add(new GFAArrayOfArraysXPTSValues((COSArray)object.getDirectBase(), this.baseObject, "XPTS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsNames() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Names"));
	}

	public COSObject getNamesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Names"));
		return object;
	}

	@Override
	public String getNamesType() {
		COSObject Names = getNamesValue();
		return getObjectType(Names);
	}

	@Override
	public Boolean getNamesHasTypeArray() {
		COSObject Names = getNamesValue();
		return getHasTypeArray(Names);
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
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
	public Boolean getcontainsXPTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XPTS"));
	}

	public COSObject getXPTSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XPTS"));
		return object;
	}

	@Override
	public String getXPTSType() {
		COSObject XPTS = getXPTSValue();
		return getObjectType(XPTS);
	}

	@Override
	public Boolean getXPTSHasTypeArray() {
		COSObject XPTS = getXPTSValue();
		return getHasTypeArray(XPTS);
	}

}
