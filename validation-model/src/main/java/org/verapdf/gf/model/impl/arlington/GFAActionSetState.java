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

public class GFAActionSetState extends GFAObject implements AActionSetState {

	public GFAActionSetState(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AActionSetState");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Next":
				return getNext();
			case "T":
				return getT();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getNext() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNext1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getNext1_2() {
		COSObject object = getNextValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfActions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfActions((COSArray)object.getDirectBase(), this.baseObject, "Next"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getNextDictionary1_2(object.getDirectBase(), "Next");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getNextDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("S"));
		String subtypeValue = subtype != null ? subtype.getString() : null;
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "GoTo":
				return new GFAActionGoTo(base, this.baseObject, keyName);
			case "GoToR":
				return new GFAActionGoToR(base, this.baseObject, keyName);
			case "Hide":
				return new GFAActionHide(base, this.baseObject, keyName);
			case "ImportData":
				return new GFAActionImportData(base, this.baseObject, keyName);
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "Movie":
				return new GFAActionMovie(base, this.baseObject, keyName);
			case "NOP":
				return new GFAActionNOP(base, this.baseObject, keyName);
			case "Named":
				return new GFAActionNamed(base, this.baseObject, keyName);
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
			case "SetState":
				return new GFAActionSetState(base, this.baseObject, keyName);
			case "Sound":
				return new GFAActionSound(base, this.baseObject, keyName);
			case "SubmitForm":
				return new GFAActionSubmitForm(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getT() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getT1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getT1_2() {
		COSObject object = getTValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfAnnots> list = new ArrayList<>(1);
			list.add(new GFAArrayOfAnnots((COSArray)object.getDirectBase(), this.baseObject, "T"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getTDictionary1_2(object.getDirectBase(), "T");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getTDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		String subtypeValue = subtype != null ? subtype.getString() : null;
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Widget":
				return getTDictionaryWidget1_2(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getTDictionaryWidget1_2(COSBase base, String keyName) {
		if (base != null && base.knownKey(ASAtom.getASAtom("T"))) {
			return getTDictionaryWidgetT1_2(base, keyName);
		}
		return new GFAAnnotWidget(base, this.baseObject, keyName);
	}

	private org.verapdf.model.baselayer.Object getTDictionaryWidgetT1_2(COSBase base, String keyName) {
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
		String subtypeValue = subtype != null ? subtype.getString() : null;
		if (subtypeValue == null) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getTDictionaryWidgetTBtn1_2(base, keyName);
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

	private org.verapdf.model.baselayer.Object getTDictionaryWidgetTBtn1_2(COSBase base, String keyName) {
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
		Long subtypeValue = subtype != null ? subtype.getInteger() : null;
		if (subtypeValue == null) {
			return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 16 & 1) {
			case 0:
				return getTDictionaryWidgetTBtn01_2(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getTDictionaryWidgetTBtn01_2(COSBase base, String keyName) {
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
		Long subtypeValue = subtype != null ? subtype.getInteger() : null;
		if (subtypeValue == null) {
			return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
		}
		switch (subtypeValue.intValue() >> 15 & 1) {
			case 0:
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsAS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AS"));
	}

	public COSObject getASValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AS"));
		return object;
	}

	@Override
	public String getASType() {
		COSObject AS = getASValue();
		return getObjectType(AS);
	}

	@Override
	public Boolean getASHasTypeName() {
		COSObject AS = getASValue();
		return getHasTypeName(AS);
	}

	@Override
	public Boolean getcontainsNext() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Next"));
	}

	public COSObject getNextValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Next"));
		return object;
	}

	@Override
	public String getNextType() {
		COSObject Next = getNextValue();
		return getObjectType(Next);
	}

	@Override
	public Boolean getNextHasTypeArray() {
		COSObject Next = getNextValue();
		return getHasTypeArray(Next);
	}

	@Override
	public Boolean getNextHasTypeDictionary() {
		COSObject Next = getNextValue();
		return getHasTypeDictionary(Next);
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
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object;
	}

	@Override
	public Boolean getisTIndirect() {
		COSObject T = getTValue();
		return getisIndirect(T);
	}

	@Override
	public String getTType() {
		COSObject T = getTValue();
		return getObjectType(T);
	}

	@Override
	public Boolean getTHasTypeArray() {
		COSObject T = getTValue();
		return getHasTypeArray(T);
	}

	@Override
	public Boolean getTHasTypeDictionary() {
		COSObject T = getTValue();
		return getHasTypeDictionary(T);
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
