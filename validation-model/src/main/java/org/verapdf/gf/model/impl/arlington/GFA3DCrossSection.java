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

public class GFA3DCrossSection extends GFAObject implements A3DCrossSection {

	public GFA3DCrossSection(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DCrossSection");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "C":
				return getC();
			case "IC":
				return getIC();
			case "O":
				return getO();
			case "PC":
				return getPC();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_3CenterOfRotationNumbers> getC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3CenterOfRotationNumbers> getC1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3CenterOfRotationNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3CenterOfRotationNumbers((COSArray)object.getDirectBase(), this.baseObject, "C"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4ColourSpaceEntries> getIC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4ColourSpaceEntries> getIC1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IC"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4ColourSpaceEntries> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4ColourSpaceEntries((COSArray)object.getDirectBase(), this.baseObject, "IC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3OrientationNumbers> getO() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getO1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3OrientationNumbers> getO1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3OrientationNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3OrientationNumbers((COSArray)object.getDirectBase(), this.baseObject, "O"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4ColourSpaceEntries> getPC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4ColourSpaceEntries> getPC1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PC"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4ColourSpaceEntries> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4ColourSpaceEntries((COSArray)object.getDirectBase(), this.baseObject, "PC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C"));
	}

	@Override
	public Boolean getCHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsIC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IC"));
	}

	@Override
	public Boolean getICHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IC"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsIV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IV"));
	}

	@Override
	public Boolean getIVHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IV"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getIVBooleanValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IV"));
		if (object == null || object.empty()) {
			return getIVBooleanDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_BOOLEAN) {
			return object.getBoolean();
		}
		return null;
	}

	public Boolean getIVBooleanDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return true;
		}
		return null;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	@Override
	public Boolean getOHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PC"));
	}

	@Override
	public Boolean getPCHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PC"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PO"));
	}

	@Override
	public Boolean getPOHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PO"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getPONumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PO"));
		if (object == null || object.empty()) {
			return getPONumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getPONumberDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0.5D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsPV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PV"));
	}

	@Override
	public Boolean getPVHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PV"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsSC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SC"));
	}

	@Override
	public Boolean getSCHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SC"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsST() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ST"));
	}

	@Override
	public Boolean getSTHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ST"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
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

}
