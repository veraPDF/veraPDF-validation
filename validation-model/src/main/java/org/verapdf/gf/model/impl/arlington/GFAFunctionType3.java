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

public class GFAFunctionType3 extends GFAObject implements AFunctionType3 {

	public GFAFunctionType3(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFunctionType3");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Bounds":
				return getBounds();
			case "Domain":
				return getDomain();
			case "Encode":
				return getEncode();
			case "Functions":
				return getFunctions();
			case "Range":
				return getRange();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getBounds() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBounds1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getBounds1_3() {
		COSObject object = getBoundsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Bounds"));
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

	private List<AArrayOfNumbersGeneral> getEncode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEncode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getEncode1_3() {
		COSObject object = getEncodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Encode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfFunctions> getFunctions() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFunctions1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFunctions> getFunctions1_3() {
		COSObject object = getFunctionsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFunctions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFunctions((COSArray)object.getDirectBase(), this.baseObject, "Functions"));
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
	public Boolean getcontainsBounds() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Bounds"));
	}

	public COSObject getBoundsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Bounds"));
		return object;
	}

	@Override
	public String getBoundsType() {
		COSObject Bounds = getBoundsValue();
		return getObjectType(Bounds);
	}

	@Override
	public Boolean getBoundsHasTypeArray() {
		COSObject Bounds = getBoundsValue();
		return getHasTypeArray(Bounds);
	}

	@Override
	public Long getBoundsArraySize() {
		COSObject Bounds = getBoundsValue();
		return getArraySize(Bounds);
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
	public Boolean getcontainsEncode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Encode"));
	}

	public COSObject getEncodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encode"));
		return object;
	}

	@Override
	public String getEncodeType() {
		COSObject Encode = getEncodeValue();
		return getObjectType(Encode);
	}

	@Override
	public Boolean getEncodeHasTypeArray() {
		COSObject Encode = getEncodeValue();
		return getHasTypeArray(Encode);
	}

	@Override
	public Long getEncodeArraySize() {
		COSObject Encode = getEncodeValue();
		return getArraySize(Encode);
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
	public Boolean getcontainsFunctions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Functions"));
	}

	public COSObject getFunctionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Functions"));
		return object;
	}

	@Override
	public String getFunctionsType() {
		COSObject Functions = getFunctionsValue();
		return getObjectType(Functions);
	}

	@Override
	public Boolean getFunctionsHasTypeArray() {
		COSObject Functions = getFunctionsValue();
		return getHasTypeArray(Functions);
	}

	@Override
	public Long getFunctionsArraySize() {
		COSObject Functions = getFunctionsValue();
		return getArraySize(Functions);
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
