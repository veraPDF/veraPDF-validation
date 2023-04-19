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

public class GFAMeasureRL extends GFAObject implements AMeasureRL {

	public GFAMeasureRL(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMeasureRL");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A":
				return getA();
			case "D":
				return getD();
			case "O":
				return getO();
			case "S":
				return getS();
			case "T":
				return getT();
			case "X":
				return getX();
			case "Y":
				return getY();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumberFormats> getA() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getA1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumberFormats> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumberFormats((COSArray)object.getDirectBase(), this.baseObject, "A"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumberFormats> getD() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getD1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumberFormats> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumberFormats((COSArray)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Numbers> getO() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getO1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getO1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "O"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumberFormats> getS() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getS1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getS1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumberFormats> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumberFormats((COSArray)object.getDirectBase(), this.baseObject, "S"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumberFormats> getT() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getT1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getT1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumberFormats> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumberFormats((COSArray)object.getDirectBase(), this.baseObject, "T"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumberFormats> getX() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getX1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getX1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("X"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumberFormats> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumberFormats((COSArray)object.getDirectBase(), this.baseObject, "X"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumberFormats> getY() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getY1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getY1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Y"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumberFormats> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumberFormats((COSArray)object.getDirectBase(), this.baseObject, "Y"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A"));
	}

	@Override
	public Boolean getAHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCYX() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CYX"));
	}

	@Override
	public Boolean getCYXHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CYX"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	@Override
	public Boolean getDHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	@Override
	public Boolean getRHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	@Override
	public Boolean getSHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			return getSubtypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSubtypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	@Override
	public Boolean getTHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
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
	public Boolean getcontainsX() {
		return this.baseObject.knownKey(ASAtom.getASAtom("X"));
	}

	@Override
	public Boolean getXHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("X"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsY() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Y"));
	}

	@Override
	public Boolean getYHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Y"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
