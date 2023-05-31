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

	private List<org.verapdf.model.baselayer.Object> getAF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAF2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getAF2_0() {
		COSObject object = getAFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "AF"));
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
			case "StructElem":
				return new GFAStructElem(base, this.baseObject, keyName);
			case "MCR":
				return new GFAMarkedContentReference(base, this.baseObject, keyName);
			case "OBJR":
				return new GFAObjectReference(base, this.baseObject, keyName);
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
		COSObject object = getAValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getAHasTypeArray() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getAHasTypeDictionary() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getAHasTypeStream() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Long getAArraySize() {
		COSObject object = getAValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
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
	public Boolean getAFHasTypeArray() {
		COSObject object = getAFValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getAFHasTypeDictionary() {
		COSObject object = getAFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getActualTextHasTypeStringText() {
		COSObject object = getActualTextValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getAltHasTypeStringText() {
		COSObject object = getAltValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getCHasTypeArray() {
		COSObject object = getCValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getCHasTypeName() {
		COSObject object = getCValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getEHasTypeStringText() {
		COSObject object = getEValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getentryIDHasTypeStringByte() {
		COSObject object = getentryIDValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getKHasTypeArray() {
		COSObject object = getKValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getKHasTypeDictionary() {
		COSObject object = getKValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getKHasTypeInteger() {
		COSObject object = getKValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
	public Boolean getLangHasTypeStringText() {
		COSObject object = getLangValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
		COSObject object = getNSValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getNSHasTypeDictionary() {
		COSObject object = getNSValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		COSObject object = getPValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject object = getPValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		COSObject object = getPgValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPgHasTypeDictionary() {
		COSObject object = getPgValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getPhonemeHasTypeStringText() {
		COSObject object = getPhonemeValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getPhoneticAlphabetHasTypeName() {
		COSObject object = getPhoneticAlphabetValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getRHasTypeInteger() {
		COSObject object = getRValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRIntegerValue() {
		COSObject object = getRValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
	public Boolean getRefHasTypeArray() {
		COSObject object = getRefValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getSHasTypeName() {
		COSObject object = getSValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
