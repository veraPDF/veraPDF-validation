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
		COSObject object = getA1Value();
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
		COSObject object = getA2Value();
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
		COSObject object = getA3Value();
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
		COSObject object = getA4Value();
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
		COSObject object = getAPValue();
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
		COSObject object = getCValue();
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
		COSObject object = getSValue();
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
		COSObject object = getTPValue();
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
		COSObject object = getTXValue();
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
		COSObject object = getTYValue();
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
	public String getA1Type() {
		COSObject A1 = getA1Value();
		return getObjectType(A1);
	}

	@Override
	public Boolean getA1HasTypeArray() {
		COSObject A1 = getA1Value();
		return getHasTypeArray(A1);
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
	public String getA2Type() {
		COSObject A2 = getA2Value();
		return getObjectType(A2);
	}

	@Override
	public Boolean getA2HasTypeArray() {
		COSObject A2 = getA2Value();
		return getHasTypeArray(A2);
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
	public String getA3Type() {
		COSObject A3 = getA3Value();
		return getObjectType(A3);
	}

	@Override
	public Boolean getA3HasTypeArray() {
		COSObject A3 = getA3Value();
		return getHasTypeArray(A3);
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
	public String getA4Type() {
		COSObject A4 = getA4Value();
		return getObjectType(A4);
	}

	@Override
	public Boolean getA4HasTypeArray() {
		COSObject A4 = getA4Value();
		return getHasTypeArray(A4);
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
	public String getAPType() {
		COSObject AP = getAPValue();
		return getObjectType(AP);
	}

	@Override
	public Boolean getAPHasTypeArray() {
		COSObject AP = getAPValue();
		return getHasTypeArray(AP);
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
	public String getCType() {
		COSObject C = getCValue();
		return getObjectType(C);
	}

	@Override
	public Boolean getCHasTypeArray() {
		COSObject C = getCValue();
		return getHasTypeArray(C);
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
	public String getELType() {
		COSObject EL = getELValue();
		return getObjectType(EL);
	}

	@Override
	public Boolean getELHasTypeNumber() {
		COSObject EL = getELValue();
		return getHasTypeNumber(EL);
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
	public String getN2Type() {
		COSObject N2 = getN2Value();
		return getObjectType(N2);
	}

	@Override
	public Boolean getN2HasTypeStringText() {
		COSObject N2 = getN2Value();
		return getHasTypeStringText(N2);
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
	public String getPType() {
		COSObject P = getPValue();
		return getObjectType(P);
	}

	@Override
	public Boolean getPHasTypeInteger() {
		COSObject P = getPValue();
		return getHasTypeInteger(P);
	}

	@Override
	public Long getPIntegerValue() {
		COSObject P = getPValue();
		return getIntegerValue(P);
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
	public String getRType() {
		COSObject R = getRValue();
		return getObjectType(R);
	}

	@Override
	public Boolean getRHasTypeBoolean() {
		COSObject R = getRValue();
		return getHasTypeBoolean(R);
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
		COSObject S = getSValue();
		return getisIndirect(S);
	}

	@Override
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeDictionary() {
		COSObject S = getSValue();
		return getHasTypeDictionary(S);
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
	public String getSCType() {
		COSObject SC = getSCValue();
		return getObjectType(SC);
	}

	@Override
	public Boolean getSCHasTypeBoolean() {
		COSObject SC = getSCValue();
		return getHasTypeBoolean(SC);
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
	public Boolean getcontainsTP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TP"));
	}

	public COSObject getTPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TP"));
		return object;
	}

	@Override
	public String getTPType() {
		COSObject TP = getTPValue();
		return getObjectType(TP);
	}

	@Override
	public Boolean getTPHasTypeArray() {
		COSObject TP = getTPValue();
		return getHasTypeArray(TP);
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
	public String getTRLType() {
		COSObject TRL = getTRLValue();
		return getObjectType(TRL);
	}

	@Override
	public Boolean getTRLHasTypeStringText() {
		COSObject TRL = getTRLValue();
		return getHasTypeStringText(TRL);
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
	public String getTSType() {
		COSObject TS = getTSValue();
		return getObjectType(TS);
	}

	@Override
	public Boolean getTSHasTypeNumber() {
		COSObject TS = getTSValue();
		return getHasTypeNumber(TS);
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
	public String getTXType() {
		COSObject TX = getTXValue();
		return getObjectType(TX);
	}

	@Override
	public Boolean getTXHasTypeArray() {
		COSObject TX = getTXValue();
		return getHasTypeArray(TX);
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
	public String getTYType() {
		COSObject TY = getTYValue();
		return getObjectType(TY);
	}

	@Override
	public Boolean getTYHasTypeArray() {
		COSObject TY = getTYValue();
		return getHasTypeArray(TY);
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
	public Boolean getcontainsU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("U"));
	}

	public COSObject getUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("U"));
		return object;
	}

	@Override
	public String getUType() {
		COSObject U = getUValue();
		return getObjectType(U);
	}

	@Override
	public Boolean getUHasTypeStringText() {
		COSObject U = getUValue();
		return getHasTypeStringText(U);
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
	public String getUTType() {
		COSObject UT = getUTValue();
		return getObjectType(UT);
	}

	@Override
	public Boolean getUTHasTypeStringText() {
		COSObject UT = getUTValue();
		return getHasTypeStringText(UT);
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
	public String getVType() {
		COSObject V = getVValue();
		return getObjectType(V);
	}

	@Override
	public Boolean getVHasTypeNumber() {
		COSObject V = getVValue();
		return getHasTypeNumber(V);
	}

}
