package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFA3DMeasure3DC extends GFAObject implements A3DMeasure3DC {

	public GFA3DMeasure3DC(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DMeasure3DC");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A1":
				return getA1();
			case "C":
				return getC();
			case "S":
				return getS();
			case "TB":
				return getTB();
			case "TP":
				return getTP();
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

	private List<AArrayOf_2Integers> getTB() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTB1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Integers> getTB1_7() {
		COSObject object = getTBValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Integers((COSArray)object.getDirectBase(), this.baseObject, "TB"));
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
		return getHasTypeArray(object);
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
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsN1() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N1"));
	}

	public COSObject getN1Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N1"));
		return object;
	}

	@Override
	public Boolean getN1HasTypeStringText() {
		COSObject object = getN1Value();
		return getHasTypeStringText(object);
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
		return getHasTypeDictionary(object);
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
		return getHasTypeName(object);
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
	public Boolean getcontainsTB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TB"));
	}

	public COSObject getTBValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TB"));
		return object;
	}

	@Override
	public Boolean getTBHasTypeArray() {
		COSObject object = getTBValue();
		return getHasTypeArray(object);
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
		return getHasTypeArray(object);
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
		return getHasTypeStringText(object);
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
		return getHasTypeNumber(object);
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
		return getHasTypeName(object);
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
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
