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
import java.io.IOException;

public class GFA3DView extends GFAObject implements A3DView {

	public GFA3DView(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DView");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "P":
				return getP();
			case "NA":
				return getNA();
			case "MA":
				return getMA();
			case "BG":
				return getBG();
			case "U3DPath":
				return getU3DPath();
			case "LS":
				return getLS();
			case "C2W":
				return getC2W();
			case "RM":
				return getRM();
			case "SA":
				return getSA();
			case "O":
				return getO();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AProjection> getP() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AProjection> getP1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
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

	private List<AArrayOf3DNode> getNA() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNA1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DNode> getNA1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NA"));
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

	private List<AArrayOf3DMeasure> getMA() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getMA2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DMeasure> getMA2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MA"));
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

	private List<A3DBackground> getBG() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBG1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DBackground> getBG1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
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

	private List<AArrayOfStringsText> getU3DPath() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getU3DPath1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getU3DPath1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U3DPath"));
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

	private List<A3DLightingScheme> getLS() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DLightingScheme> getLS1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LS"));
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

	private List<AArrayOf3DTransMatrix> getC2W() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC2W1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DTransMatrix> getC2W1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C2W"));
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

	private List<A3DRenderMode> getRM() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRM1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DRenderMode> getRM1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RM"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSA1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DCrossSection> getSA1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SA"));
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

	private List<AXObjectFormType1> getO() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getO1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectFormType1> getO1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
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

	@Override
	public Boolean getcontainsLS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LS"));
	}

	@Override
	public Boolean getLSHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsC2W() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C2W"));
	}

	@Override
	public Boolean getC2WHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C2W"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsNR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NR"));
	}

	@Override
	public Boolean getNRHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NR"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsIN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IN"));
	}

	@Override
	public Boolean getINHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IN"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsU3DPath() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U3DPath"));
	}

	@Override
	public Boolean getU3DPathHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U3DPath"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getU3DPathHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U3DPath"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsCO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CO"));
	}

	@Override
	public Boolean getCOHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CO"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	@Override
	public Boolean getisOIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getOHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsNA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NA"));
	}

	@Override
	public Boolean getNAHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NA"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsBG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BG"));
	}

	@Override
	public Boolean getBGHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsXN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XN"));
	}

	@Override
	public Boolean getXNHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XN"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsMA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MA"));
	}

	@Override
	public Boolean getMAHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MA"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsSA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SA"));
	}

	@Override
	public Boolean getSAHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SA"));
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
	public Boolean getcontainsRM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RM"));
	}

	@Override
	public Boolean getRMHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RM"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsMS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MS"));
	}

	@Override
	public Boolean getMSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MS"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getMSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MS"));
		if (object == null || object.empty()) {
			return getMSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getMSNameDefaultValue() {
		return null;
	}

}
