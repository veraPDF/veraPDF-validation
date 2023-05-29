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

	public COSObject getCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object;
	}

	@Override
	public Boolean getCHasTypeArray() {
		COSObject object = getCValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsIC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IC"));
	}

	public COSObject getICValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IC"));
		return object;
	}

	@Override
	public Boolean getICHasTypeArray() {
		COSObject object = getICValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsIV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IV"));
	}

	public COSObject getIVDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getIVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IV"));
		if (object == null || object.empty()) {
			object = getIVDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getIVHasTypeBoolean() {
		COSObject object = getIVValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getIVBooleanValue() {
		COSObject object = getIVValue();
		if (object != null && object.getType() == COSObjType.COS_BOOLEAN) {
			return object.getBoolean();
		}
		return null;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object;
	}

	@Override
	public Boolean getOHasTypeArray() {
		COSObject object = getOValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PC"));
	}

	public COSObject getPCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PC"));
		return object;
	}

	@Override
	public Boolean getPCHasTypeArray() {
		COSObject object = getPCValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PO"));
	}

	public COSObject getPODefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0.5D);
		}
		return null;
	}

	public COSObject getPOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PO"));
		if (object == null || object.empty()) {
			object = getPODefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPOHasTypeNumber() {
		COSObject object = getPOValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getPONumberValue() {
		COSObject object = getPOValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PV"));
	}

	public COSObject getPVDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getPVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PV"));
		if (object == null || object.empty()) {
			object = getPVDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPVHasTypeBoolean() {
		COSObject object = getPVValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsSC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SC"));
	}

	public COSObject getSCDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getSCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SC"));
		if (object == null || object.empty()) {
			object = getSCDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSCHasTypeBoolean() {
		COSObject object = getSCValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsST() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ST"));
	}

	public COSObject getSTDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getSTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ST"));
		if (object == null || object.empty()) {
			object = getSTDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSTHasTypeBoolean() {
		COSObject object = getSTValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
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
