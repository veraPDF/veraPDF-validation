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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
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

	@Override
	public Boolean getHHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsHI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HI"));
	}

	@Override
	public Boolean getHIHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HI"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("L"));
	}

	@Override
	public Boolean getLHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsLI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LI"));
	}

	@Override
	public Boolean getLIHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LI"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsOS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OS"));
	}

	@Override
	public Boolean getOSHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
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
	public Boolean getcontainsU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U"));
	}

	@Override
	public Boolean getUHasTypeStringAscii() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

}
