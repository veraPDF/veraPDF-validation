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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C0"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C1"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Domain"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Range"));
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
	public Boolean getC0HasTypeArray() {
		COSObject object = getC0Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getC0ArraySize() {
		COSObject object = getC0Value();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
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
	public Boolean getC1HasTypeArray() {
		COSObject object = getC1Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getC1ArraySize() {
		COSObject object = getC1Value();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
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
	public Boolean getDomainHasTypeArray() {
		COSObject object = getDomainValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getDomainArraySize() {
		COSObject object = getDomainValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
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
	public Boolean getFunctionTypeHasTypeInteger() {
		COSObject object = getFunctionTypeValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFunctionTypeIntegerValue() {
		COSObject object = getFunctionTypeValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
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
	public Boolean getNHasTypeNumber() {
		COSObject object = getNValue();
		return object != null && object.getType().isNumber();
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
	public Boolean getRangeHasTypeArray() {
		COSObject object = getRangeValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getRangeArraySize() {
		COSObject object = getRangeValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

}
