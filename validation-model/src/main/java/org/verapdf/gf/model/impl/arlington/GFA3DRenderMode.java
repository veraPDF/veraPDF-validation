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

public class GFA3DRenderMode extends GFAObject implements A3DRenderMode {

	public GFA3DRenderMode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DRenderMode");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AC":
				return getAC();
			case "FC":
				return getFC();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_4ColourSpaceEntries> getAC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4ColourSpaceEntries> getAC1_7() {
		COSObject object = getACValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4ColourSpaceEntries> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4ColourSpaceEntries((COSArray)object.getDirectBase(), this.baseObject, "AC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4ColourSpaceEntries> getFC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4ColourSpaceEntries> getFC1_7() {
		COSObject object = getFCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4ColourSpaceEntries> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4ColourSpaceEntries((COSArray)object.getDirectBase(), this.baseObject, "FC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AC"));
	}

	public COSObject getACValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AC"));
		return object;
	}

	@Override
	public Boolean getACHasTypeArray() {
		COSObject object = getACValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CV"));
	}

	public COSObject getCVDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(45D);
		}
		return null;
	}

	public COSObject getCVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CV"));
		if (object == null || object.empty()) {
			object = getCVDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getCVHasTypeNumber() {
		COSObject object = getCVValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsFC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FC"));
	}

	public COSObject getFCDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("BG");
		}
		return null;
	}

	public COSObject getFCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FC"));
		if (object == null || object.empty()) {
			object = getFCDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getFCHasTypeArray() {
		COSObject object = getFCValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getFCHasTypeName() {
		COSObject object = getFCValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFCNameValue() {
		COSObject object = getFCValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getODefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0.5D);
		}
		return null;
	}

	public COSObject getOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null || object.empty()) {
			object = getODefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getOHasTypeNumber() {
		COSObject object = getOValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getONumberValue() {
		COSObject object = getOValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
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

}
