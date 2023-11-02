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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBCValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getGValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getTRValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getTRDictionary1_4(object.getDirectBase(), "TR");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getTRStream1_4(object.getDirectBase(), "TR");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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

	@Override
	public Boolean getcontainsBC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BC"));
	}

	public COSObject getBCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BC"));
		return object;
	}

	@Override
	public String getBCType() {
		COSObject BC = getBCValue();
		return getObjectType(BC);
	}

	@Override
	public Boolean getBCHasTypeArray() {
		COSObject BC = getBCValue();
		return getHasTypeArray(BC);
	}

	@Override
	public Boolean getcontainsG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("G"));
	}

	public COSObject getGValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("G"));
		return object;
	}

	@Override
	public Boolean getisGIndirect() {
		COSObject G = getGValue();
		return getisIndirect(G);
	}

	@Override
	public String getGType() {
		COSObject G = getGValue();
		return getObjectType(G);
	}

	@Override
	public Boolean getGHasTypeStream() {
		COSObject G = getGValue();
		return getHasTypeStream(G);
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
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject S = getSValue();
		return getHasTypeName(S);
	}

	@Override
	public String getSNameValue() {
		COSObject S = getSValue();
		return getNameValue(S);
	}

	@Override
	public Boolean getcontainsTR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TR"));
	}

	public COSObject getTRDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Identity");
		}
		return null;
	}

	public COSObject getTRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		if (object == null || object.empty()) {
			object = getTRDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getisTRIndirect() {
		COSObject TR = getTRValue();
		return getisIndirect(TR);
	}

	@Override
	public String getTRType() {
		COSObject TR = getTRValue();
		return getObjectType(TR);
	}

	@Override
	public Boolean getTRHasTypeDictionary() {
		COSObject TR = getTRValue();
		return getHasTypeDictionary(TR);
	}

	@Override
	public Boolean getTRHasTypeName() {
		COSObject TR = getTRValue();
		return getHasTypeName(TR);
	}

	@Override
	public Boolean getTRHasTypeStream() {
		COSObject TR = getTRValue();
		return getHasTypeStream(TR);
	}

	@Override
	public String getTRNameValue() {
		COSObject TR = getTRValue();
		return getNameValue(TR);
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

	public COSObject getGGroupValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject G = this.baseObject.getKey(ASAtom.getASAtom("G"));
		if (G == null || !G.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Group = G.getKey(ASAtom.getASAtom("Group"));
		return Group;
	}

	@Override
	public String getGGroupSNameValue() {
		COSObject GGroup = getGGroupValue();
		if (GGroup == null || !GGroup.getType().isDictionaryBased()) {
			return null;
		}
		return new GFAGroupAttributes(GGroup.getDirectBase(), null, null).getSNameValue();
	}

	@Override
	public Boolean getcontainsGGroupCS() {
		COSObject GGroup = getGGroupValue();
		return GGroup.knownKey(ASAtom.getASAtom("CS"));
	}

}
