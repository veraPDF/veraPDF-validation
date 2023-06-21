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

public class GFASoftwareIdentifier extends GFAObject implements ASoftwareIdentifier {

	public GFASoftwareIdentifier(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASoftwareIdentifier");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "H":
				return getH();
			case "L":
				return getL();
			case "OS":
				return getOS();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfSoftwareVersions> getH() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getH1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfSoftwareVersions> getH1_5() {
		COSObject object = getHValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfSoftwareVersions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfSoftwareVersions((COSArray)object.getDirectBase(), this.baseObject, "H"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfSoftwareVersions> getL() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getL1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfSoftwareVersions> getL1_5() {
		COSObject object = getLValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfSoftwareVersions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfSoftwareVersions((COSArray)object.getDirectBase(), this.baseObject, "L"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsByte> getOS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOS1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getOS1_5() {
		COSObject object = getOSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "OS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("H"));
	}

	public COSObject getHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		return object;
	}

	@Override
	public Boolean getHHasTypeArray() {
		COSObject object = getHValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsHI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HI"));
	}

	public COSObject getHIDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getHIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HI"));
		if (object == null || object.empty()) {
			object = getHIDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getHIHasTypeBoolean() {
		COSObject object = getHIValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("L"));
	}

	public COSObject getLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
		return object;
	}

	@Override
	public Boolean getLHasTypeArray() {
		COSObject object = getLValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsLI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LI"));
	}

	public COSObject getLIDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getLIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LI"));
		if (object == null || object.empty()) {
			object = getLIDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getLIHasTypeBoolean() {
		COSObject object = getLIValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsOS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OS"));
	}

	public COSObject getOSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
		return object;
	}

	@Override
	public Boolean getOSHasTypeArray() {
		COSObject object = getOSValue();
		return getHasTypeArray(object);
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
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U"));
	}

	public COSObject getUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		return object;
	}

	@Override
	public Boolean getUHasTypeStringAscii() {
		COSObject object = getUValue();
		return getHasTypeStringAscii(object);
	}

}
