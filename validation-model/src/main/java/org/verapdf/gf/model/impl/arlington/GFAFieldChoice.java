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

public class GFAFieldChoice extends GFAObject implements AFieldChoice {

	public GFAFieldChoice(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFieldChoice");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AA":
				return getAA();
			case "DV":
				return getDV();
			case "I":
				return getI();
			case "Kids":
				return getKids();
			case "Opt":
				return getOpt();
			case "Parent":
				return getParent();
			case "RV":
				return getRV();
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

	private List<AArrayOfStringsText> getDV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDV1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getDV1_2() {
		COSObject object = getDVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "DV"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNonNegativeIntegersGeneral> getI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getI1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNonNegativeIntegersGeneral> getI1_4() {
		COSObject object = getIValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNonNegativeIntegersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNonNegativeIntegersGeneral((COSArray)object.getDirectBase(), this.baseObject, "I"));
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

	private List<AArrayOfFieldChoiceOpt> getOpt() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOpt1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFieldChoiceOpt> getOpt1_2() {
		COSObject object = getOptValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFieldChoiceOpt> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFieldChoiceOpt((COSArray)object.getDirectBase(), this.baseObject, "Opt"));
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("FT"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("Ff"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 16) {
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("Ff"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 15) {
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("FT"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("Ff"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return new GFAFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 16) {
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("Ff"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return new GFAFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 15) {
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("FT"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("Ff"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 16) {
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("Ff"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 15) {
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("FT"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("Ff"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return new GFAFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 16) {
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
		COSObject parent = base.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((subtype == null || subtype.empty()) && (parent != null && !parent.empty())) {
			subtype = parent.getKey(ASAtom.getASAtom("Ff"));
			if (parent.getKey() != null) {
				if (visitedKeys.contains(parent.getKey())) {
					break;
				}
				visitedKeys.add(parent.getKey());
			}
			parent = parent.getKey(ASAtom.getASAtom("Parent"));
		}
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return new GFAFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 15) {
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

	private List<AArrayOfStringsText> getV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getV1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getV1_2() {
		COSObject object = getVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public String getDAType() {
		COSObject DA = getDAValue();
		return getObjectType(DA);
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
	public String getDSType() {
		COSObject DS = getDSValue();
		return getObjectType(DS);
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
	public String getDVType() {
		COSObject DV = getDVValue();
		return getObjectType(DV);
	}

	@Override
	public Boolean getDVHasTypeArray() {
		COSObject DV = getDVValue();
		return getHasTypeArray(DV);
	}

	@Override
	public Boolean getDVHasTypeStringText() {
		COSObject DV = getDVValue();
		return getHasTypeStringText(DV);
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
	public String getFTType() {
		COSObject FT = getFTValue();
		return getObjectType(FT);
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
	public Boolean getcontainsI() {
		if (isContainsInheritableValue(ASAtom.getASAtom("I"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("I"));
	}

	public COSObject getIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("I"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("I"));
		}
		return object;
	}

	@Override
	public String getIType() {
		COSObject I = getIValue();
		return getObjectType(I);
	}

	@Override
	public Boolean getIHasTypeArray() {
		COSObject I = getIValue();
		return getHasTypeArray(I);
	}

	@Override
	public Boolean getisIArraySortAscending1() {
		COSObject I = getIValue();
		return getisArraySortAscending(I, 1);
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
	public Boolean getcontainsOpt() {
		if (isContainsInheritableValue(ASAtom.getASAtom("Opt"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("Opt"));
	}

	public COSObject getOptValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Opt"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("Opt"));
		}
		return object;
	}

	@Override
	public String getOptType() {
		COSObject Opt = getOptValue();
		return getObjectType(Opt);
	}

	@Override
	public Boolean getOptHasTypeArray() {
		COSObject Opt = getOptValue();
		return getHasTypeArray(Opt);
	}

	@Override
	public Long getOptArraySize() {
		COSObject Opt = getOptValue();
		return getArraySize(Opt);
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
	public Boolean getcontainsQ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Q"));
	}

	public COSObject getQDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
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
	public String getQType() {
		COSObject Q = getQValue();
		return getObjectType(Q);
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
	public String getRVType() {
		COSObject RV = getRVValue();
		return getObjectType(RV);
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
	public Boolean getcontainsTI() {
		if (isContainsInheritableValue(ASAtom.getASAtom("TI"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("TI"));
	}

	public COSObject getTIDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
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

	public COSObject getTIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TI"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("TI"));
		}
		if (object == null || object.empty()) {
			object = getTIDefaultValue();
		}
		return object;
	}

	@Override
	public String getTIType() {
		COSObject TI = getTIValue();
		return getObjectType(TI);
	}

	@Override
	public Boolean getTIHasTypeInteger() {
		COSObject TI = getTIValue();
		return getHasTypeInteger(TI);
	}

	@Override
	public Long getTIIntegerValue() {
		COSObject TI = getTIValue();
		return getIntegerValue(TI);
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
	public String getVType() {
		COSObject V = getVValue();
		return getObjectType(V);
	}

	@Override
	public Boolean getVHasTypeArray() {
		COSObject V = getVValue();
		return getHasTypeArray(V);
	}

	@Override
	public Boolean getVHasTypeStringText() {
		COSObject V = getVValue();
		return getHasTypeStringText(V);
	}

}
