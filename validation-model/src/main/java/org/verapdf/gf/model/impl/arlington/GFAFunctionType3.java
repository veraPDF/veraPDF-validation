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

public class GFAFunctionType3 extends GFAObject implements AFunctionType3 {

	public GFAFunctionType3(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFunctionType3");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Bounds":
				return getBounds();
			case "Functions":
				return getFunctions();
			case "Range":
				return getRange();
			case "Domain":
				return getDomain();
			case "Encode":
				return getEncode();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getBounds() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Bounds"));
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

	private List<AArrayOfFunctions> getFunctions() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Functions"));
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
		switch(StaticContainers.getFlavour()) {
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

	private List<AArrayOfNumbersGeneral> getDomain() {
		switch(StaticContainers.getFlavour()) {
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

	private List<AArrayOfNumbersGeneral> getEncode() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encode"));
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

	@Override
	public Boolean getcontainsBounds() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Bounds"));
	}

	@Override
	public Boolean getBoundsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Bounds"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getBoundsArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Bounds"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDomain() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Domain"));
	}

	@Override
	public Boolean getDomainHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Domain"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getDomainArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Domain"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFunctionType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FunctionType"));
	}

	@Override
	public Boolean getFunctionTypeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FunctionType"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFunctionTypeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FunctionType"));
		if (object == null || object.empty()) {
			return getFunctionTypeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getFunctionTypeIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsEncode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Encode"));
	}

	@Override
	public Boolean getEncodeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encode"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getEncodeArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encode"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsRange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Range"));
	}

	@Override
	public Boolean getRangeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Range"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getRangeArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Range"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFunctions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Functions"));
	}

	@Override
	public Boolean getFunctionsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Functions"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getFunctionsArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Functions"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

}
