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

public class GFALinearizationParameterDict extends GFAObject implements ALinearizationParameterDict {

	public GFALinearizationParameterDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ALinearizationParameterDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "H":
				return getH();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getH() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getH1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getH1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getHArray1_2(object.getDirectBase(), "H");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getHArray1_2(COSBase base, String keyName) {
		switch (base.size()) {
			case 2:
				return new GFAArrayOf_2Integers(base, this.baseObject, keyName);
			case 4:
				return new GFAArrayOf_4Integers(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("E"));
	}

	public COSObject getEValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("E"));
		return object;
	}

	@Override
	public Boolean getisEIndirect() {
		COSObject object = getEValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getEHasTypeInteger() {
		COSObject object = getEValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getEIntegerValue() {
		COSObject object = getEValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("H"));
	}

	public COSObject getHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		return object;
	}

	@Override
	public Boolean getisHIndirect() {
		COSObject object = getHValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getHHasTypeArray() {
		COSObject object = getHValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("L"));
	}

	public COSObject getLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
		return object;
	}

	@Override
	public Boolean getisLIndirect() {
		COSObject object = getLValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getLHasTypeInteger() {
		COSObject object = getLValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getLIntegerValue() {
		COSObject object = getLValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsLinearized() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Linearized"));
	}

	public COSObject getLinearizedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Linearized"));
		return object;
	}

	@Override
	public Boolean getisLinearizedIndirect() {
		COSObject object = getLinearizedValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getLinearizedHasTypeNumber() {
		COSObject object = getLinearizedValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getLinearizedNumberValue() {
		COSObject object = getLinearizedValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	public COSObject getNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object;
	}

	@Override
	public Boolean getisNIndirect() {
		COSObject object = getNValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getNHasTypeInteger() {
		COSObject object = getNValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getNIntegerValue() {
		COSObject object = getNValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
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
	public Boolean getisOIndirect() {
		COSObject object = getOValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getOHasTypeInteger() {
		COSObject object = getOValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getOIntegerValue() {
		COSObject object = getOValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
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
	public Boolean getisPIndirect() {
		COSObject object = getPValue();
		return object != null && object.get() != null && object.get().isIndirect();
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
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object;
	}

	@Override
	public Boolean getisTIndirect() {
		COSObject object = getTValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTHasTypeInteger() {
		COSObject object = getTValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getTIntegerValue() {
		COSObject object = getTValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

}
