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

public class GFAStructElem extends GFAObject implements AStructElem {

	public GFAStructElem(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AStructElem");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A":
				return getA();
			case "AF":
				return getAF();
			case "C":
				return getC();
			case "K":
				return getK();
			case "NS":
				return getNS();
			case "P":
				return getP();
			case "Pg":
				return getPg();
			case "Ref":
				return getRef();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getA1_3() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfAttributeRevisions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfAttributeRevisions((COSArray)object.getDirectBase(), this.baseObject, "A"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AStructureAttributesDict> list = new ArrayList<>(1);
			list.add(new GFAStructureAttributesDict((COSDictionary)object.getDirectBase(), this.baseObject, "A"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "A"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfFileSpecifications> getAF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAF2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFileSpecifications> getAF2_0() {
		COSObject object = getAFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfClassNamesRevisions> getC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfClassNamesRevisions> getC1_3() {
		COSObject object = getCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfClassNamesRevisions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfClassNamesRevisions((COSArray)object.getDirectBase(), this.baseObject, "C"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getK() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getK1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getK1_3() {
		COSObject object = getKValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStructElemKids> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStructElemKids((COSArray)object.getDirectBase(), this.baseObject, "K"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getKDictionary1_3(object.getDirectBase(), "K");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getKDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAStructElem(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "MCR":
				return new GFAMarkedContentReference(base, this.baseObject, keyName);
			case "OBJR":
				return new GFAObjectReference(base, this.baseObject, keyName);
			case "StructElem":
				return new GFAStructElem(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<ANamespace> getNS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getNS2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANamespace> getNS2_0() {
		COSObject object = getNSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANamespace> list = new ArrayList<>(1);
			list.add(new GFANamespace((COSDictionary)object.getDirectBase(), this.baseObject, "NS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getP1_3() {
		COSObject object = getPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getPDictionary1_3(object.getDirectBase(), "P");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getPDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAStructElem(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "StructElem":
				return new GFAStructElem(base, this.baseObject, keyName);
			case "StructTreeRoot":
				return new GFAStructTreeRoot(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<APageObject> getPg() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPg1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getPg1_3() {
		COSObject object = getPgValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "Pg"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStructElem> getRef() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getRef2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStructElem> getRef2_0() {
		COSObject object = getRefValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStructElem> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStructElem((COSArray)object.getDirectBase(), this.baseObject, "Ref"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A"));
	}

	public COSObject getAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object;
	}

	@Override
	public Boolean getisAIndirect() {
		COSObject A = getAValue();
		return getisIndirect(A);
	}

	@Override
	public String getAType() {
		COSObject A = getAValue();
		return getObjectType(A);
	}

	@Override
	public Boolean getAHasTypeArray() {
		COSObject A = getAValue();
		return getHasTypeArray(A);
	}

	@Override
	public Boolean getAHasTypeDictionary() {
		COSObject A = getAValue();
		return getHasTypeDictionary(A);
	}

	@Override
	public Boolean getAHasTypeStream() {
		COSObject A = getAValue();
		return getHasTypeStream(A);
	}

	@Override
	public Long getAArraySize() {
		COSObject A = getAValue();
		return getArraySize(A);
	}

	@Override
	public Boolean getcontainsAF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AF"));
	}

	public COSObject getAFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		return object;
	}

	@Override
	public String getAFType() {
		COSObject AF = getAFValue();
		return getObjectType(AF);
	}

	@Override
	public Boolean getAFHasTypeArray() {
		COSObject AF = getAFValue();
		return getHasTypeArray(AF);
	}

	@Override
	public Boolean getcontainsActualText() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ActualText"));
	}

	public COSObject getActualTextValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ActualText"));
		return object;
	}

	@Override
	public String getActualTextType() {
		COSObject ActualText = getActualTextValue();
		return getObjectType(ActualText);
	}

	@Override
	public Boolean getActualTextHasTypeStringText() {
		COSObject ActualText = getActualTextValue();
		return getHasTypeStringText(ActualText);
	}

	@Override
	public Boolean getcontainsAlt() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Alt"));
	}

	public COSObject getAltValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Alt"));
		return object;
	}

	@Override
	public String getAltType() {
		COSObject Alt = getAltValue();
		return getObjectType(Alt);
	}

	@Override
	public Boolean getAltHasTypeStringText() {
		COSObject Alt = getAltValue();
		return getHasTypeStringText(Alt);
	}

	@Override
	public Boolean getcontainsC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C"));
	}

	public COSObject getCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object;
	}

	@Override
	public String getCType() {
		COSObject C = getCValue();
		return getObjectType(C);
	}

	@Override
	public Boolean getCHasTypeArray() {
		COSObject C = getCValue();
		return getHasTypeArray(C);
	}

	@Override
	public Boolean getCHasTypeName() {
		COSObject C = getCValue();
		return getHasTypeName(C);
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
	public String getEType() {
		COSObject E = getEValue();
		return getObjectType(E);
	}

	@Override
	public Boolean getEHasTypeStringText() {
		COSObject E = getEValue();
		return getHasTypeStringText(E);
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	public COSObject getentryIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object;
	}

	@Override
	public String getentryIDType() {
		COSObject entryID = getentryIDValue();
		return getObjectType(entryID);
	}

	@Override
	public Boolean getentryIDHasTypeStringByte() {
		COSObject entryID = getentryIDValue();
		return getHasTypeStringByte(entryID);
	}

	@Override
	public Boolean getcontainsK() {
		return this.baseObject.knownKey(ASAtom.getASAtom("K"));
	}

	public COSObject getKValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("K"));
		return object;
	}

	@Override
	public String getKType() {
		COSObject K = getKValue();
		return getObjectType(K);
	}

	@Override
	public Boolean getKHasTypeArray() {
		COSObject K = getKValue();
		return getHasTypeArray(K);
	}

	@Override
	public Boolean getKHasTypeDictionary() {
		COSObject K = getKValue();
		return getHasTypeDictionary(K);
	}

	@Override
	public Boolean getKHasTypeInteger() {
		COSObject K = getKValue();
		return getHasTypeInteger(K);
	}

	@Override
	public Boolean getcontainsLang() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Lang"));
	}

	public COSObject getLangValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Lang"));
		return object;
	}

	@Override
	public String getLangType() {
		COSObject Lang = getLangValue();
		return getObjectType(Lang);
	}

	@Override
	public Boolean getLangHasTypeStringText() {
		COSObject Lang = getLangValue();
		return getHasTypeStringText(Lang);
	}

	@Override
	public Boolean getcontainsNS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NS"));
	}

	public COSObject getNSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NS"));
		return object;
	}

	@Override
	public Boolean getisNSIndirect() {
		COSObject NS = getNSValue();
		return getisIndirect(NS);
	}

	@Override
	public String getNSType() {
		COSObject NS = getNSValue();
		return getObjectType(NS);
	}

	@Override
	public Boolean getNSHasTypeDictionary() {
		COSObject NS = getNSValue();
		return getHasTypeDictionary(NS);
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object;
	}

	@Override
	public Boolean getisPIndirect() {
		COSObject P = getPValue();
		return getisIndirect(P);
	}

	@Override
	public String getPType() {
		COSObject P = getPValue();
		return getObjectType(P);
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject P = getPValue();
		return getHasTypeDictionary(P);
	}

	@Override
	public Boolean getcontainsPg() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pg"));
	}

	public COSObject getPgValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		return object;
	}

	@Override
	public Boolean getisPgIndirect() {
		COSObject Pg = getPgValue();
		return getisIndirect(Pg);
	}

	@Override
	public String getPgType() {
		COSObject Pg = getPgValue();
		return getObjectType(Pg);
	}

	@Override
	public Boolean getPgHasTypeDictionary() {
		COSObject Pg = getPgValue();
		return getHasTypeDictionary(Pg);
	}

	@Override
	public Boolean getcontainsPhoneme() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Phoneme"));
	}

	public COSObject getPhonemeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Phoneme"));
		return object;
	}

	@Override
	public String getPhonemeType() {
		COSObject Phoneme = getPhonemeValue();
		return getObjectType(Phoneme);
	}

	@Override
	public Boolean getPhonemeHasTypeStringText() {
		COSObject Phoneme = getPhonemeValue();
		return getHasTypeStringText(Phoneme);
	}

	@Override
	public Boolean getcontainsPhoneticAlphabet() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PhoneticAlphabet"));
	}

	public COSObject getPhoneticAlphabetDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSName.construct("ipa");
		}
		return null;
	}

	public COSObject getPhoneticAlphabetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PhoneticAlphabet"));
		if (object == null || object.empty()) {
			object = getPhoneticAlphabetDefaultValue();
		}
		return object;
	}

	@Override
	public String getPhoneticAlphabetType() {
		COSObject PhoneticAlphabet = getPhoneticAlphabetValue();
		return getObjectType(PhoneticAlphabet);
	}

	@Override
	public Boolean getPhoneticAlphabetHasTypeName() {
		COSObject PhoneticAlphabet = getPhoneticAlphabetValue();
		return getHasTypeName(PhoneticAlphabet);
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRDefaultValue() {
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

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object == null || object.empty()) {
			object = getRDefaultValue();
		}
		return object;
	}

	@Override
	public String getRType() {
		COSObject R = getRValue();
		return getObjectType(R);
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject R = getRValue();
		return getHasTypeInteger(R);
	}

	@Override
	public Long getRIntegerValue() {
		COSObject R = getRValue();
		return getIntegerValue(R);
	}

	@Override
	public Boolean getcontainsRef() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ref"));
	}

	public COSObject getRefValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ref"));
		return object;
	}

	@Override
	public String getRefType() {
		COSObject Ref = getRefValue();
		return getObjectType(Ref);
	}

	@Override
	public Boolean getRefHasTypeArray() {
		COSObject Ref = getRefValue();
		return getHasTypeArray(Ref);
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
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object;
	}

	@Override
	public String getTType() {
		COSObject T = getTValue();
		return getObjectType(T);
	}

	@Override
	public Boolean getTHasTypeStringText() {
		COSObject T = getTValue();
		return getHasTypeStringText(T);
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

}
