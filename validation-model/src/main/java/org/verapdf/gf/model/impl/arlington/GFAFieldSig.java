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
			case "DocTimeStamp":
				return new GFADocTimeStamp(base, this.baseObject, keyName);
			case "Sig":
				return new GFASignature(base, this.baseObject, keyName);
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
			case "Btn":
				return getParentDictionaryBtn1_3(base, keyName);
			case "Ch":
				return new GFAFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAFieldTx(base, this.baseObject, keyName);
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
			case "DocTimeStamp":
				return new GFADocTimeStamp(base, this.baseObject, keyName);
			case "Sig":
				return new GFASignature(base, this.baseObject, keyName);
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
		COSObject AA = getAAValue();
		return getHasTypeDictionary(AA);
	}

	@Override
	public Boolean getcontainsDA() {
		if (isContainsInheritableValue(ASAtom.getASAtom("DA"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("DA"));
	}

	public COSObject getDAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DA"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("DA"));
		}
		return object;
	}

	@Override
	public Boolean getDAHasTypeStringByte() {
		COSObject DA = getDAValue();
		return getHasTypeStringByte(DA);
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
		COSObject DS = getDSValue();
		return getHasTypeStringText(DS);
	}

	@Override
	public Boolean getcontainsDV() {
		if (isContainsInheritableValue(ASAtom.getASAtom("DV"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("DV"));
	}

	public COSObject getDVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DV"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("DV"));
		}
		return object;
	}

	@Override
	public Boolean getDVHasTypeDictionary() {
		COSObject DV = getDVValue();
		return getHasTypeDictionary(DV);
	}

	@Override
	public Boolean getcontainsFT() {
		if (isContainsInheritableValue(ASAtom.getASAtom("FT"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("FT"));
	}

	public COSObject getFTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FT"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("FT"));
		}
		return object;
	}

	@Override
	public Boolean getFTHasTypeName() {
		COSObject FT = getFTValue();
		return getHasTypeName(FT);
	}

	@Override
	public String getFTNameValue() {
		COSObject FT = getFTValue();
		return getNameValue(FT);
	}

	@Override
	public Boolean getcontainsFf() {
		if (isContainsInheritableValue(ASAtom.getASAtom("Ff"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("Ff"));
	}

	public COSObject getFfValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("Ff"));
		}
		return object;
	}

	@Override
	public Boolean getFfHasTypeBitmask() {
		COSObject Ff = getFfValue();
		return getHasTypeBitmask(Ff);
	}

	@Override
	public Long getFfBitmaskValue() {
		COSObject Ff = getFfValue();
		return getBitmaskValue(Ff);
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
		COSObject Kids = getKidsValue();
		return getHasTypeArray(Kids);
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
		COSObject Lock = getLockValue();
		return getisIndirect(Lock);
	}

	@Override
	public Boolean getLockHasTypeDictionary() {
		COSObject Lock = getLockValue();
		return getHasTypeDictionary(Lock);
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
		COSObject Parent = getParentValue();
		return getHasTypeDictionary(Parent);
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
		COSObject Q = getQValue();
		return getHasTypeInteger(Q);
	}

	@Override
	public Long getQIntegerValue() {
		COSObject Q = getQValue();
		return getIntegerValue(Q);
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
		COSObject RV = getRVValue();
		return getisIndirect(RV);
	}

	@Override
	public Boolean getRVHasTypeStream() {
		COSObject RV = getRVValue();
		return getHasTypeStream(RV);
	}

	@Override
	public Boolean getRVHasTypeStringText() {
		COSObject RV = getRVValue();
		return getHasTypeStringText(RV);
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
		COSObject SV = getSVValue();
		return getisIndirect(SV);
	}

	@Override
	public Boolean getSVHasTypeDictionary() {
		COSObject SV = getSVValue();
		return getHasTypeDictionary(SV);
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
		COSObject T = getTValue();
		return getHasTypeStringText(T);
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
		COSObject TM = getTMValue();
		return getHasTypeStringText(TM);
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
		COSObject TU = getTUValue();
		return getHasTypeStringText(TU);
	}

	@Override
	public Boolean getcontainsV() {
		if (isContainsInheritableValue(ASAtom.getASAtom("V"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("V"));
		}
		return object;
	}

	@Override
	public Boolean getVHasTypeDictionary() {
		COSObject V = getVValue();
		return getHasTypeDictionary(V);
	}

}
