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
	public Boolean getNamesHasTypeArray() {
		COSObject object = getNamesValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getcontainsXPTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XPTS"));
	}

	public COSObject getXPTSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XPTS"));
		return object;
	}

	@Override
	public Boolean getXPTSHasTypeArray() {
		COSObject object = getXPTSValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}