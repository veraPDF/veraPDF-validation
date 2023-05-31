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

public class GFAFieldSig extends GFAObject implements AFieldSig {

	public GFAFieldSig(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFieldSig");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AA":
				return getAA();
			case "DV":
				return getDV();
			case "Kids":
				return getKids();
			case "Lock":
				return getLock();
			case "Parent":
				return getParent();
			case "RV":
				return getRV();
			case "SV":
				return getSV();
			case "V":
				return getV();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AAddActionFormField> getAA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAA1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAddActionFormField> getAA1_3() {
		COSObject object = getAAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAddActionFormField> list = new ArrayList<>(1);
			list.add(new GFAAddActionFormField((COSDictionary)object.getDirectBase(), this.baseObject, "AA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDV1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDV1_3() {
		COSObject object = getDVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDVDictionary1_3(object.getDirectBase(), "DV");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDVDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Sig":
				return new GFASignature(base, this.baseObject, keyName);
			case "DocTimeStamp":
				return new GFADocTimeStamp(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfFields> getKids() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getKids1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFields> getKids1_3() {
		COSObject object = getKidsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFields> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFields((COSArray)object.getDirectBase(), this.baseObject, "Kids"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASigFieldLock> getLock() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLock1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASigFieldLock> getLock1_5() {
		COSObject object = getLockValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASigFieldLock> list = new ArrayList<>(1);
			list.add(new GFASigFieldLock((COSDictionary)object.getDirectBase(), this.baseObject, "Lock"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getParent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getParent1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_3() {
		COSObject object = getParentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_3(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAField(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "Sig":
				return new GFAFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAFieldTx(base, this.baseObject, keyName);
			case "Ch":
				return new GFAFieldChoice(base, this.baseObject, keyName);
			case "Btn":
				return getParentDictionaryBtn1_3(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryBtn1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getParentDictionary01_3(base, keyName);
			case 1:
				return new GFAFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionary01_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AStream> getRV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRV1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getRV1_5() {
		COSObject object = getRVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "RV"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASigFieldSeedValue> getSV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSV1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASigFieldSeedValue> getSV1_5() {
		COSObject object = getSVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASigFieldSeedValue> list = new ArrayList<>(1);
			list.add(new GFASigFieldSeedValue((COSDictionary)object.getDirectBase(), this.baseObject, "SV"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getV1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getV1_3() {
		COSObject object = getVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getVDictionary1_3(object.getDirectBase(), "V");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getVDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Sig":
				return new GFASignature(base, this.baseObject, keyName);
			case "DocTimeStamp":
				return new GFADocTimeStamp(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsAA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AA"));
	}

	public COSObject getAAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AA"));
		return object;
	}

	@Override
	public Boolean getAAHasTypeDictionary() {
		COSObject object = getAAValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDA() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("DA"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("DA"));
	}

	public COSObject getDAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DA"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("DA"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object;
	}

	@Override
	public Boolean getDAHasTypeString() {
		COSObject object = getDAValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsDS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DS"));
	}

	public COSObject getDSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DS"));
		return object;
	}

	@Override
	public Boolean getDSHasTypeStringText() {
		COSObject object = getDSValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsDV() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("DV"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("DV"));
	}

	public COSObject getDVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DV"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("DV"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object;
	}

	@Override
	public Boolean getDVHasTypeDictionary() {
		COSObject object = getDVValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsFT() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("FT"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("FT"));
	}

	public COSObject getFTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FT"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("FT"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object;
	}

	@Override
	public Boolean getFTHasTypeName() {
		COSObject object = getFTValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFTNameValue() {
		COSObject object = getFTValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFf() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("Ff"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("Ff"));
	}

	public COSObject getFfValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("Ff"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object;
	}

	@Override
	public Boolean getFfHasTypeBitmask() {
		COSObject object = getFfValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFfBitmaskValue() {
		COSObject object = getFfValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsKids() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Kids"));
	}

	public COSObject getKidsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Kids"));
		return object;
	}

	@Override
	public Boolean getKidsHasTypeArray() {
		COSObject object = getKidsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsLock() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Lock"));
	}

	public COSObject getLockValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Lock"));
		return object;
	}

	@Override
	public Boolean getisLockIndirect() {
		COSObject object = getLockValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getLockHasTypeDictionary() {
		COSObject object = getLockValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Parent"));
	}

	public COSObject getParentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		return object;
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject object = getParentValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsQ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Q"));
	}

	public COSObject getQDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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

	public COSObject getQValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Q"));
		if (object == null || object.empty()) {
			object = getQDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getQHasTypeInteger() {
		COSObject object = getQValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getQIntegerValue() {
		COSObject object = getQValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsRV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RV"));
	}

	public COSObject getRVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RV"));
		return object;
	}

	@Override
	public Boolean getisRVIndirect() {
		COSObject object = getRVValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getRVHasTypeStream() {
		COSObject object = getRVValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getRVHasTypeStringText() {
		COSObject object = getRVValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsSV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SV"));
	}

	public COSObject getSVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SV"));
		return object;
	}

	@Override
	public Boolean getisSVIndirect() {
		COSObject object = getSVValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSVHasTypeDictionary() {
		COSObject object = getSVValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getTHasTypeStringText() {
		COSObject object = getTValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TM"));
	}

	public COSObject getTMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TM"));
		return object;
	}

	@Override
	public Boolean getTMHasTypeStringText() {
		COSObject object = getTMValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TU"));
	}

	public COSObject getTUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TU"));
		return object;
	}

	@Override
	public Boolean getTUHasTypeStringText() {
		COSObject object = getTUValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsV() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("V"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("V"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object;
	}

	@Override
	public Boolean getVHasTypeDictionary() {
		COSObject object = getVValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
