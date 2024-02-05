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

public class GFAField extends GFAObject implements AField {

	public GFAField(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AField");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AA":
				return getAA();
			case "Kids":
				return getKids();
			case "Parent":
				return getParent();
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

	private List<AArrayOfFields> getKids() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getKids1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFields> getKids1_2() {
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

	private List<org.verapdf.model.baselayer.Object> getParent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getParent1_2();
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

	private List<org.verapdf.model.baselayer.Object> getParent1_2() {
		COSObject object = getParentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_2(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getParentDictionaryDefault1_2(base, keyName);
		}
		switch (subtypeValue) {
			case "Widget":
				return getParentDictionaryWidget1_2(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryWidget1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getParentDictionaryWidgetBtn1_2(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryWidgetBtn1_2(COSBase base, String keyName) {
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
				return getParentDictionaryWidgetBtn01_2(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryWidgetBtn01_2(COSBase base, String keyName) {
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
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryDefault1_2(COSBase base, String keyName) {
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
				return getParentDictionaryDefaultBtn1_2(base, keyName);
			case "Ch":
				return new GFAFieldChoice(base, this.baseObject, keyName);
			case "Tx":
				return new GFAFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryDefaultBtn1_2(COSBase base, String keyName) {
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
				return getParentDictionaryDefaultBtn01_2(base, keyName);
			case 1:
				return new GFAFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryDefaultBtn01_2(COSBase base, String keyName) {
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
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getParentDictionaryDefault1_3(base, keyName);
		}
		switch (subtypeValue) {
			case "Widget":
				return getParentDictionaryWidget1_3(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryWidget1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getParentDictionaryWidgetBtn1_3(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAAnnotWidgetFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryWidgetBtn1_3(COSBase base, String keyName) {
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
				return getParentDictionaryWidgetBtn01_3(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryWidgetBtn01_3(COSBase base, String keyName) {
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
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryDefault1_3(COSBase base, String keyName) {
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
				return getParentDictionaryDefaultBtn1_3(base, keyName);
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

	private org.verapdf.model.baselayer.Object getParentDictionaryDefaultBtn1_3(COSBase base, String keyName) {
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
				return getParentDictionaryDefaultBtn01_3(base, keyName);
			case 1:
				return new GFAFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryDefaultBtn01_3(COSBase base, String keyName) {
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

	@Override
	public Boolean getcontainsAA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AA"));
	}

	public COSObject getAAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AA"));
		return object;
	}

	@Override
	public String getAAType() {
		COSObject AA = getAAValue();
		return getObjectType(AA);
	}

	@Override
	public Boolean getAAHasTypeDictionary() {
		COSObject AA = getAAValue();
		return getHasTypeDictionary(AA);
	}

	@Override
	public Boolean getcontainsFf() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ff"));
	}

	public COSObject getFfValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		return object;
	}

	@Override
	public String getFfType() {
		COSObject Ff = getFfValue();
		return getObjectType(Ff);
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
	public String getKidsType() {
		COSObject Kids = getKidsValue();
		return getObjectType(Kids);
	}

	@Override
	public Boolean getKidsHasTypeArray() {
		COSObject Kids = getKidsValue();
		return getHasTypeArray(Kids);
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
	public String getParentType() {
		COSObject Parent = getParentValue();
		return getObjectType(Parent);
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject Parent = getParentValue();
		return getHasTypeDictionary(Parent);
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
	public Boolean getcontainsTM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TM"));
	}

	public COSObject getTMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TM"));
		return object;
	}

	@Override
	public String getTMType() {
		COSObject TM = getTMValue();
		return getObjectType(TM);
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
	public String getTUType() {
		COSObject TU = getTUValue();
		return getObjectType(TU);
	}

	@Override
	public Boolean getTUHasTypeStringText() {
		COSObject TU = getTUValue();
		return getHasTypeStringText(TU);
	}

}
