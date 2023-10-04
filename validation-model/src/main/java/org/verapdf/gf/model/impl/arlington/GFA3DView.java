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

public class GFA3DView extends GFAObject implements A3DView {

	public GFA3DView(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DView");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BG":
				return getBG();
			case "C2W":
				return getC2W();
			case "LS":
				return getLS();
			case "MA":
				return getMA();
			case "NA":
				return getNA();
			case "O":
				return getO();
			case "P":
				return getP();
			case "RM":
				return getRM();
			case "SA":
				return getSA();
			case "U3DPath":
				return getU3DPath();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<A3DBackground> getBG() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBG1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DBackground> getBG1_6() {
		COSObject object = getBGValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DBackground> list = new ArrayList<>(1);
			list.add(new GFA3DBackground((COSDictionary)object.getDirectBase(), this.baseObject, "BG"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DTransMatrix> getC2W() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC2W1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DTransMatrix> getC2W1_6() {
		COSObject object = getC2WValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DTransMatrix> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DTransMatrix((COSArray)object.getDirectBase(), this.baseObject, "C2W"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A3DLightingScheme> getLS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DLightingScheme> getLS1_7() {
		COSObject object = getLSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DLightingScheme> list = new ArrayList<>(1);
			list.add(new GFA3DLightingScheme((COSDictionary)object.getDirectBase(), this.baseObject, "LS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DMeasure> getMA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getMA2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DMeasure> getMA2_0() {
		COSObject object = getMAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DMeasure> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DMeasure((COSArray)object.getDirectBase(), this.baseObject, "MA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DNode> getNA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNA1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DNode> getNA1_7() {
		COSObject object = getNAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DNode> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DNode((COSArray)object.getDirectBase(), this.baseObject, "NA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXObjectFormType1> getO() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getO1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectFormType1> getO1_6() {
		COSObject object = getOValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormType1> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormType1((COSStream)object.getDirectBase(), this.baseObject, "O"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AProjection> getP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AProjection> getP1_6() {
		COSObject object = getPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AProjection> list = new ArrayList<>(1);
			list.add(new GFAProjection((COSDictionary)object.getDirectBase(), this.baseObject, "P"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A3DRenderMode> getRM() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRM1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DRenderMode> getRM1_7() {
		COSObject object = getRMValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DRenderMode> list = new ArrayList<>(1);
			list.add(new GFA3DRenderMode((COSDictionary)object.getDirectBase(), this.baseObject, "RM"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DCrossSection> getSA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSA1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DCrossSection> getSA1_7() {
		COSObject object = getSAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DCrossSection> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DCrossSection((COSArray)object.getDirectBase(), this.baseObject, "SA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsText> getU3DPath() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getU3DPath1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getU3DPath1_6() {
		COSObject object = getU3DPathValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "U3DPath"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BG"));
	}

	public COSObject getBGValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		return object;
	}

	@Override
	public Boolean getBGHasTypeDictionary() {
		COSObject BG = getBGValue();
		return getHasTypeDictionary(BG);
	}

	@Override
	public Boolean getcontainsC2W() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C2W"));
	}

	public COSObject getC2WValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C2W"));
		return object;
	}

	@Override
	public Boolean getC2WHasTypeArray() {
		COSObject C2W = getC2WValue();
		return getHasTypeArray(C2W);
	}

	@Override
	public Boolean getcontainsCO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CO"));
	}

	public COSObject getCOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CO"));
		return object;
	}

	@Override
	public Boolean getCOHasTypeNumber() {
		COSObject CO = getCOValue();
		return getHasTypeNumber(CO);
	}

	@Override
	public Boolean getcontainsIN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IN"));
	}

	public COSObject getINValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IN"));
		return object;
	}

	@Override
	public Boolean getINHasTypeStringText() {
		COSObject IN = getINValue();
		return getHasTypeStringText(IN);
	}

	@Override
	public Boolean getcontainsLS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LS"));
	}

	public COSObject getLSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LS"));
		return object;
	}

	@Override
	public Boolean getLSHasTypeDictionary() {
		COSObject LS = getLSValue();
		return getHasTypeDictionary(LS);
	}

	@Override
	public Boolean getcontainsMA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MA"));
	}

	public COSObject getMAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MA"));
		return object;
	}

	@Override
	public Boolean getMAHasTypeArray() {
		COSObject MA = getMAValue();
		return getHasTypeArray(MA);
	}

	@Override
	public Boolean getcontainsMS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MS"));
	}

	public COSObject getMSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MS"));
		return object;
	}

	@Override
	public Boolean getMSHasTypeName() {
		COSObject MS = getMSValue();
		return getHasTypeName(MS);
	}

	@Override
	public String getMSNameValue() {
		COSObject MS = getMSValue();
		return getNameValue(MS);
	}

	@Override
	public Boolean getcontainsNA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NA"));
	}

	public COSObject getNAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NA"));
		return object;
	}

	@Override
	public Boolean getNAHasTypeArray() {
		COSObject NA = getNAValue();
		return getHasTypeArray(NA);
	}

	@Override
	public Boolean getcontainsNR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NR"));
	}

	public COSObject getNRDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getNRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NR"));
		if (object == null || object.empty()) {
			object = getNRDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getNRHasTypeBoolean() {
		COSObject NR = getNRValue();
		return getHasTypeBoolean(NR);
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
	public Boolean getisOIndirect() {
		COSObject O = getOValue();
		return getisIndirect(O);
	}

	@Override
	public Boolean getOHasTypeStream() {
		COSObject O = getOValue();
		return getHasTypeStream(O);
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object;
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject P = getPValue();
		return getHasTypeDictionary(P);
	}

	@Override
	public Boolean getcontainsRM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RM"));
	}

	public COSObject getRMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RM"));
		return object;
	}

	@Override
	public Boolean getRMHasTypeDictionary() {
		COSObject RM = getRMValue();
		return getHasTypeDictionary(RM);
	}

	@Override
	public Boolean getcontainsSA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SA"));
	}

	public COSObject getSAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SA"));
		return object;
	}

	@Override
	public Boolean getSAHasTypeArray() {
		COSObject SA = getSAValue();
		return getHasTypeArray(SA);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsU3DPath() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U3DPath"));
	}

	public COSObject getU3DPathValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U3DPath"));
		return object;
	}

	@Override
	public Boolean getU3DPathHasTypeArray() {
		COSObject U3DPath = getU3DPathValue();
		return getHasTypeArray(U3DPath);
	}

	@Override
	public Boolean getU3DPathHasTypeStringText() {
		COSObject U3DPath = getU3DPathValue();
		return getHasTypeStringText(U3DPath);
	}

	@Override
	public Boolean getcontainsXN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XN"));
	}

	public COSObject getXNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XN"));
		return object;
	}

	@Override
	public Boolean getXNHasTypeStringText() {
		COSObject XN = getXNValue();
		return getHasTypeStringText(XN);
	}

}
