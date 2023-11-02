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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getA1_6() {
		COSObject object = getAValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getD1_6() {
		COSObject object = getDValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getO1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getO1_6() {
		COSObject object = getOValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getS1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getS1_6() {
		COSObject object = getSValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getT1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getT1_6() {
		COSObject object = getTValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getX1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getX1_6() {
		COSObject object = getXValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getY1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumberFormats> getY1_6() {
		COSObject object = getYValue();
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

	public COSObject getAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object;
	}

	@Override
	public String getAType() {
		COSObject A = getAValue();
		return getObjectType(A);
	}

	@Override
	public Boolean getAHasTypeArray() {
		COSObject A = getAValue();
		return getHasTypeArray(A);
	}

	@Override
	public Boolean getcontainsCYX() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CYX"));
	}

	public COSObject getCYXValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CYX"));
		return object;
	}

	@Override
	public String getCYXType() {
		COSObject CYX = getCYXValue();
		return getObjectType(CYX);
	}

	@Override
	public Boolean getCYXHasTypeNumber() {
		COSObject CYX = getCYXValue();
		return getHasTypeNumber(CYX);
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object;
	}

	@Override
	public String getDType() {
		COSObject D = getDValue();
		return getObjectType(D);
	}

	@Override
	public Boolean getDHasTypeArray() {
		COSObject D = getDValue();
		return getHasTypeArray(D);
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
	public String getOType() {
		COSObject O = getOValue();
		return getObjectType(O);
	}

	@Override
	public Boolean getOHasTypeArray() {
		COSObject O = getOValue();
		return getHasTypeArray(O);
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object;
	}

	@Override
	public String getRType() {
		COSObject R = getRValue();
		return getObjectType(R);
	}

	@Override
	public Boolean getRHasTypeStringText() {
		COSObject R = getRValue();
		return getHasTypeStringText(R);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object;
	}

	@Override
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeArray() {
		COSObject S = getSValue();
		return getHasTypeArray(S);
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
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object;
	}

	@Override
	public String getTType() {
		COSObject T = getTValue();
		return getObjectType(T);
	}

	@Override
	public Boolean getTHasTypeArray() {
		COSObject T = getTValue();
		return getHasTypeArray(T);
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
	public Boolean getcontainsX() {
		return this.baseObject.knownKey(ASAtom.getASAtom("X"));
	}

	public COSObject getXValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("X"));
		return object;
	}

	@Override
	public String getXType() {
		COSObject X = getXValue();
		return getObjectType(X);
	}

	@Override
	public Boolean getXHasTypeArray() {
		COSObject X = getXValue();
		return getHasTypeArray(X);
	}

	@Override
	public Boolean getcontainsY() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Y"));
	}

	public COSObject getYValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Y"));
		return object;
	}

	@Override
	public String getYType() {
		COSObject Y = getYValue();
		return getObjectType(Y);
	}

	@Override
	public Boolean getYHasTypeArray() {
		COSObject Y = getYValue();
		return getHasTypeArray(Y);
	}

}
