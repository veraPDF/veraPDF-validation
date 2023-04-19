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

public class GFASoftMaskLuminosity extends GFAObject implements ASoftMaskLuminosity {

	public GFASoftMaskLuminosity(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASoftMaskLuminosity");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BC":
				return getBC();
			case "G":
				return getG();
			case "TR":
				return getTR();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getBC() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBC1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getBC1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BC"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "BC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXObjectFormType1> getG() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getG1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectFormType1> getG1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("G"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormType1> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormType1((COSStream)object.getDirectBase(), this.baseObject, "G"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getTR() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTR1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getTR1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getTRStream1_4(object.getDirectBase(), "TR");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getTRDictionary1_4(object.getDirectBase(), "TR");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getTRStream1_4(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getTRDictionary1_4(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsBC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BC"));
	}

	@Override
	public Boolean getBCHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BC"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("G"));
	}

	@Override
	public Boolean getisGIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("G"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getGHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("G"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			return getSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsTR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TR"));
	}

	@Override
	public Boolean getisTRIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTRHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getTRHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getTRHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public String getTRNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		if (object == null || object.empty()) {
			return getTRNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTRNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Identity";
		}
		return null;
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
	public String getGGroupSNameValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject G = this.baseObject.getKey(ASAtom.getASAtom("G"));
		if (G == null || !G.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Group = G.getKey(ASAtom.getASAtom("Group"));
		if (Group == null || !Group.getType().isDictionaryBased()) {
			return null;
		}
		COSObject S = Group.getKey(ASAtom.getASAtom("S"));
		return new GFAGroupAttributes(Group.getDirectBase(), null, null).getSNameValue();
	}
	@Override
	public Boolean getcontainsGGroupCS() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject G = this.baseObject.getKey(ASAtom.getASAtom("G"));
		if (G == null || !G.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Group = G.getKey(ASAtom.getASAtom("Group"));
		return Group.knownKey(ASAtom.getASAtom("CS"));
	}

}
