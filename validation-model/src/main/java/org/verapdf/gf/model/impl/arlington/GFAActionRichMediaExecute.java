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

public class GFAActionRichMediaExecute extends GFAObject implements AActionRichMediaExecute {

	public GFAActionRichMediaExecute(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AActionRichMediaExecute");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CMD":
				return getCMD();
			case "Next":
				return getNext();
			case "TA":
				return getTA();
			case "TI":
				return getTI();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaCommand> getCMD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getCMD1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getCMD1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaCommand> getCMD1_7() {
		COSObject object = getCMDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaCommand> list = new ArrayList<>(1);
			list.add(new GFARichMediaCommand((COSDictionary)object.getDirectBase(), this.baseObject, "CMD"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getNext() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getNext1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getNext2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getNext1_7() {
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
			org.verapdf.model.baselayer.Object result = getNextDictionary1_7(object.getDirectBase(), "Next");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getNextDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("S"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "GoTo":
				return new GFAActionGoTo(base, this.baseObject, keyName);
			case "GoTo3DView":
				return new GFAActionGoTo3DView(base, this.baseObject, keyName);
			case "GoToE":
				return new GFAActionGoToE(base, this.baseObject, keyName);
			case "GoToR":
				return new GFAActionGoToR(base, this.baseObject, keyName);
			case "Hide":
				return new GFAActionHide(base, this.baseObject, keyName);
			case "ImportData":
				return new GFAActionImportData(base, this.baseObject, keyName);
			case "JavaScript":
				return new GFAActionECMAScript(base, this.baseObject, keyName);
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "Movie":
				return new GFAActionMovie(base, this.baseObject, keyName);
			case "Named":
				return new GFAActionNamed(base, this.baseObject, keyName);
			case "Rendition":
				return new GFAActionRendition(base, this.baseObject, keyName);
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
			case "RichMediaExecute":
				return new GFAActionRichMediaExecute(base, this.baseObject, keyName);
			case "SetOCGState":
				return new GFAActionSetOCGState(base, this.baseObject, keyName);
			case "Sound":
				return new GFAActionSound(base, this.baseObject, keyName);
			case "SubmitForm":
				return new GFAActionSubmitForm(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "Trans":
				return new GFAActionTransition(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getNext2_0() {
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
			org.verapdf.model.baselayer.Object result = getNextDictionary2_0(object.getDirectBase(), "Next");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getNextDictionary2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("S"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "GoTo":
				return new GFAActionGoTo(base, this.baseObject, keyName);
			case "GoTo3DView":
				return new GFAActionGoTo3DView(base, this.baseObject, keyName);
			case "GoToDp":
				return new GFAActionGoToDp(base, this.baseObject, keyName);
			case "GoToE":
				return new GFAActionGoToE(base, this.baseObject, keyName);
			case "GoToR":
				return new GFAActionGoToR(base, this.baseObject, keyName);
			case "Hide":
				return new GFAActionHide(base, this.baseObject, keyName);
			case "ImportData":
				return new GFAActionImportData(base, this.baseObject, keyName);
			case "JavaScript":
				return new GFAActionECMAScript(base, this.baseObject, keyName);
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "Movie":
				return new GFAActionMovie(base, this.baseObject, keyName);
			case "Named":
				return new GFAActionNamed(base, this.baseObject, keyName);
			case "Rendition":
				return new GFAActionRendition(base, this.baseObject, keyName);
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
			case "RichMediaExecute":
				return new GFAActionRichMediaExecute(base, this.baseObject, keyName);
			case "SetOCGState":
				return new GFAActionSetOCGState(base, this.baseObject, keyName);
			case "Sound":
				return new GFAActionSound(base, this.baseObject, keyName);
			case "SubmitForm":
				return new GFAActionSubmitForm(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "Trans":
				return new GFAActionTransition(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AAnnotRichMedia> getTA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getTA1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getTA1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAnnotRichMedia> getTA1_7() {
		COSObject object = getTAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAnnotRichMedia> list = new ArrayList<>(1);
			list.add(new GFAAnnotRichMedia((COSDictionary)object.getDirectBase(), this.baseObject, "TA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaInstance> getTI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getTI1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getTI1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaInstance> getTI1_7() {
		COSObject object = getTIValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaInstance> list = new ArrayList<>(1);
			list.add(new GFARichMediaInstance((COSDictionary)object.getDirectBase(), this.baseObject, "TI"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCMD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CMD"));
	}

	public COSObject getCMDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CMD"));
		return object;
	}

	@Override
	public String getCMDType() {
		COSObject CMD = getCMDValue();
		return getObjectType(CMD);
	}

	@Override
	public Boolean getCMDHasTypeDictionary() {
		COSObject CMD = getCMDValue();
		return getHasTypeDictionary(CMD);
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
	public Boolean getcontainsTA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TA"));
	}

	public COSObject getTAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TA"));
		return object;
	}

	@Override
	public Boolean getisTAIndirect() {
		COSObject TA = getTAValue();
		return getisIndirect(TA);
	}

	@Override
	public String getTAType() {
		COSObject TA = getTAValue();
		return getObjectType(TA);
	}

	@Override
	public Boolean getTAHasTypeDictionary() {
		COSObject TA = getTAValue();
		return getHasTypeDictionary(TA);
	}

	@Override
	public Boolean getcontainsTI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TI"));
	}

	public COSObject getTIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TI"));
		return object;
	}

	@Override
	public Boolean getisTIIndirect() {
		COSObject TI = getTIValue();
		return getisIndirect(TI);
	}

	@Override
	public String getTIType() {
		COSObject TI = getTIValue();
		return getObjectType(TI);
	}

	@Override
	public Boolean getTIHasTypeDictionary() {
		COSObject TI = getTIValue();
		return getHasTypeDictionary(TI);
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
