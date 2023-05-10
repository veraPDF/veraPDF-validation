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

	@Override
	public Boolean getisEIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("E"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getEHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("E"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getEIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("E"));
		if (object == null || object.empty()) {
			return getEIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getEIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("H"));
	}

	@Override
	public Boolean getisHIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getHHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("L"));
	}

	@Override
	public Boolean getisLIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getLHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getLIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
		if (object == null || object.empty()) {
			return getLIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getLIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsLinearized() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Linearized"));
	}

	@Override
	public Boolean getisLinearizedIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Linearized"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getLinearizedHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Linearized"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getLinearizedNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Linearized"));
		if (object == null || object.empty()) {
			return getLinearizedNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getLinearizedNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	@Override
	public Boolean getisNIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getNHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getNIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		if (object == null || object.empty()) {
			return getNIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getNIntegerDefaultValue() {
		return null;
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
	public Boolean getOHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getOIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null || object.empty()) {
			return getOIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getOIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	@Override
	public Boolean getisPIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			return getPIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getPIntegerDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	@Override
	public Boolean getisTIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getTIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		if (object == null || object.empty()) {
			return getTIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getTIntegerDefaultValue() {
		return null;
	}

}
