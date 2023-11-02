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

public class GFAFunctionType2 extends GFAObject implements AFunctionType2 {

	public GFAFunctionType2(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFunctionType2");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "C0":
				return getC0();
			case "C1":
				return getC1();
			case "Domain":
				return getDomain();
			case "Range":
				return getRange();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getC0() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC01_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getC01_3() {
		COSObject object = getC0Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "C0"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getC1() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC11_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getC11_3() {
		COSObject object = getC1Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "C1"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getDomain() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDomain1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getDomain1_3() {
		COSObject object = getDomainValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Domain"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getRange() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRange1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getRange1_3() {
		COSObject object = getRangeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Range"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsC0() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C0"));
	}

	public COSObject getC0Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C0"));
		return object;
	}

	@Override
	public String getC0Type() {
		COSObject C0 = getC0Value();
		return getObjectType(C0);
	}

	@Override
	public Boolean getC0HasTypeArray() {
		COSObject C0 = getC0Value();
		return getHasTypeArray(C0);
	}

	@Override
	public Long getC0ArraySize() {
		COSObject C0 = getC0Value();
		return getArraySize(C0);
	}

	@Override
	public Boolean getcontainsC1() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C1"));
	}

	public COSObject getC1Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C1"));
		return object;
	}

	@Override
	public String getC1Type() {
		COSObject C1 = getC1Value();
		return getObjectType(C1);
	}

	@Override
	public Boolean getC1HasTypeArray() {
		COSObject C1 = getC1Value();
		return getHasTypeArray(C1);
	}

	@Override
	public Long getC1ArraySize() {
		COSObject C1 = getC1Value();
		return getArraySize(C1);
	}

	@Override
	public Boolean getcontainsDomain() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Domain"));
	}

	public COSObject getDomainValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Domain"));
		return object;
	}

	@Override
	public String getDomainType() {
		COSObject Domain = getDomainValue();
		return getObjectType(Domain);
	}

	@Override
	public Boolean getDomainHasTypeArray() {
		COSObject Domain = getDomainValue();
		return getHasTypeArray(Domain);
	}

	@Override
	public Long getDomainArraySize() {
		COSObject Domain = getDomainValue();
		return getArraySize(Domain);
	}

	@Override
	public Boolean getcontainsFunctionType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FunctionType"));
	}

	public COSObject getFunctionTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FunctionType"));
		return object;
	}

	@Override
	public String getFunctionTypeType() {
		COSObject FunctionType = getFunctionTypeValue();
		return getObjectType(FunctionType);
	}

	@Override
	public Boolean getFunctionTypeHasTypeInteger() {
		COSObject FunctionType = getFunctionTypeValue();
		return getHasTypeInteger(FunctionType);
	}

	@Override
	public Long getFunctionTypeIntegerValue() {
		COSObject FunctionType = getFunctionTypeValue();
		return getIntegerValue(FunctionType);
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
	public String getNType() {
		COSObject N = getNValue();
		return getObjectType(N);
	}

	@Override
	public Boolean getNHasTypeNumber() {
		COSObject N = getNValue();
		return getHasTypeNumber(N);
	}

	@Override
	public Boolean getcontainsRange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Range"));
	}

	public COSObject getRangeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Range"));
		return object;
	}

	@Override
	public String getRangeType() {
		COSObject Range = getRangeValue();
		return getObjectType(Range);
	}

	@Override
	public Boolean getRangeHasTypeArray() {
		COSObject Range = getRangeValue();
		return getHasTypeArray(Range);
	}

	@Override
	public Long getRangeArraySize() {
		COSObject Range = getRangeValue();
		return getArraySize(Range);
	}

}
