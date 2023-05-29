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

public class GFA3DMeasureRD3 extends GFAObject implements A3DMeasureRD3 {

	public GFA3DMeasureRD3(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DMeasureRD3");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A1":
				return getA1();
			case "A2":
				return getA2();
			case "A3":
				return getA3();
			case "A4":
				return getA4();
			case "AP":
				return getAP();
			case "C":
				return getC();
			case "S":
				return getS();
			case "TP":
				return getTP();
			case "TX":
				return getTX();
			case "TY":
				return getTY();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_3Numbers> getA1() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA11_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Numbers> getA11_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A1"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Numbers((COSArray)object.getDirectBase(), this.baseObject, "A1"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3Numbers> getA2() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA21_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Numbers> getA21_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A2"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Numbers((COSArray)object.getDirectBase(), this.baseObject, "A2"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3Numbers> getA3() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA31_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Numbers> getA31_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A3"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Numbers((COSArray)object.getDirectBase(), this.baseObject, "A3"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3Numbers> getA4() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA41_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Numbers> getA41_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A4"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Numbers((COSArray)object.getDirectBase(), this.baseObject, "A4"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3Numbers> getAP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAP1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Numbers> getAP1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Numbers((COSArray)object.getDirectBase(), this.baseObject, "AP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3RGBNumbers> getC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getC1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "C"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AAnnotProjection> getS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAnnotProjection> getS1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAnnotProjection> list = new ArrayList<>(1);
			list.add(new GFAAnnotProjection((COSDictionary)object.getDirectBase(), this.baseObject, "S"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3Numbers> getTP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTP1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Numbers> getTP1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TP"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Numbers((COSArray)object.getDirectBase(), this.baseObject, "TP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3Numbers> getTX() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTX1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Numbers> getTX1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TX"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Numbers((COSArray)object.getDirectBase(), this.baseObject, "TX"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3Numbers> getTY() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTY1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Numbers> getTY1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TY"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Numbers((COSArray)object.getDirectBase(), this.baseObject, "TY"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsA1() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A1"));
	}

	public COSObject getA1Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A1"));
		return object;
	}

	@Override
	public Boolean getA1HasTypeArray() {
		COSObject object = getA1Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsA2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A2"));
	}

	public COSObject getA2Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A2"));
		return object;
	}

	@Override
	public Boolean getA2HasTypeArray() {
		COSObject object = getA2Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsA3() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A3"));
	}

	public COSObject getA3Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A3"));
		return object;
	}

	@Override
	public Boolean getA3HasTypeArray() {
		COSObject object = getA3Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsA4() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A4"));
	}

	public COSObject getA4Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A4"));
		return object;
	}

	@Override
	public Boolean getA4HasTypeArray() {
		COSObject object = getA4Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsAP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AP"));
	}

	public COSObject getAPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		return object;
	}

	@Override
	public Boolean getAPHasTypeArray() {
		COSObject object = getAPValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getcontainsEL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EL"));
	}

	public COSObject getELDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(60D);
		}
		return null;
	}

	public COSObject getELValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EL"));
		if (object == null || object.empty()) {
			object = getELDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getELHasTypeNumber() {
		COSObject object = getELValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsN2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N2"));
	}

	public COSObject getN2Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N2"));
		return object;
	}

	@Override
	public Boolean getN2HasTypeStringText() {
		COSObject object = getN2Value();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(3L);
		}
		return null;
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			object = getPDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPHasTypeInteger() {
		COSObject object = getPValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPIntegerValue() {
		COSObject object = getPValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object == null || object.empty()) {
			object = getRDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRHasTypeBoolean() {
		COSObject object = getRValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
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
	public Boolean getisSIndirect() {
		COSObject object = getSValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSHasTypeDictionary() {
		COSObject object = getSValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SC"));
	}

	public COSObject getSCDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
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
	public Boolean getcontainsTP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TP"));
	}

	public COSObject getTPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TP"));
		return object;
	}

	@Override
	public Boolean getTPHasTypeArray() {
		COSObject object = getTPValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsTRL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TRL"));
	}

	public COSObject getTRLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TRL"));
		return object;
	}

	@Override
	public Boolean getTRLHasTypeStringText() {
		COSObject object = getTRLValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TS"));
	}

	public COSObject getTSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(12D);
		}
		return null;
	}

	public COSObject getTSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TS"));
		if (object == null || object.empty()) {
			object = getTSDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getTSHasTypeNumber() {
		COSObject object = getTSValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTX() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TX"));
	}

	public COSObject getTXValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TX"));
		return object;
	}

	@Override
	public Boolean getTXHasTypeArray() {
		COSObject object = getTXValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsTY() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TY"));
	}

	public COSObject getTYValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TY"));
		return object;
	}

	@Override
	public Boolean getTYHasTypeArray() {
		COSObject object = getTYValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getcontainsU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U"));
	}

	public COSObject getUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		return object;
	}

	@Override
	public Boolean getUHasTypeStringText() {
		COSObject object = getUValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsUT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UT"));
	}

	public COSObject getUTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UT"));
		return object;
	}

	@Override
	public Boolean getUTHasTypeStringText() {
		COSObject object = getUTValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object;
	}

	@Override
	public Boolean getVHasTypeNumber() {
		COSObject object = getVValue();
		return object != null && object.getType().isNumber();
	}

}
