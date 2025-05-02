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

public class GFAActionGoTo extends GFAObject implements AActionGoTo {

	public GFAActionGoTo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AActionGoTo");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "D":
				return getD();
			case "Next":
				return getNext();
			case "SD":
				return getSD();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getD1_1() {
		COSObject object = getDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getDArray1_1(object.getDirectBase(), "D");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDArray1_1(COSBase base, String keyName) {
		switch (base.size()) {
			case 2:
				return new GFADest0Array(base, this.baseObject, keyName);
			case 3:
				return new GFADest1Array(base, this.baseObject, keyName);
			case 5:
				return new GFADestXYZArray(base, this.baseObject, keyName);
			case 6:
				return new GFADest4Array(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getNext() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getNext1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
				return getNext1_3();
			case ARLINGTON1_5:
				return getNext1_5();
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				return getNext1_6();
			case ARLINGTON2_0:
				return getNext2_0();
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

	private List<org.verapdf.model.baselayer.Object> getNext1_3() {
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
			org.verapdf.model.baselayer.Object result = getNextDictionary1_3(object.getDirectBase(), "Next");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getNextDictionary1_3(COSBase base, String keyName) {
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
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
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

	private List<org.verapdf.model.baselayer.Object> getNext1_5() {
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
			org.verapdf.model.baselayer.Object result = getNextDictionary1_5(object.getDirectBase(), "Next");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getNextDictionary1_5(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getNext1_6() {
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
			org.verapdf.model.baselayer.Object result = getNextDictionary1_6(object.getDirectBase(), "Next");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getNextDictionary1_6(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getSD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSD2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSD2_0() {
		COSObject object = getSDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getSDArray2_0(object.getDirectBase(), "SD");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getSDArray2_0(COSBase base, String keyName) {
		switch (base.size()) {
			case 2:
				return new GFADest0StructArray(base, this.baseObject, keyName);
			case 3:
				return new GFADest1StructArray(base, this.baseObject, keyName);
			case 5:
				return new GFADestXYZStructArray(base, this.baseObject, keyName);
			case 6:
				return new GFADest4StructArray(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object;
	}

	@Override
	public String getDType() {
		COSObject D = getDValue();
		return getObjectType(D);
	}

	@Override
	public Boolean getDHasTypeArray() {
		COSObject D = getDValue();
		return getHasTypeArray(D);
	}

	@Override
	public Boolean getDHasTypeName() {
		COSObject D = getDValue();
		return getHasTypeName(D);
	}

	@Override
	public Boolean getDHasTypeStringByte() {
		COSObject D = getDValue();
		return getHasTypeStringByte(D);
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
	public Boolean getcontainsSD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SD"));
	}

	public COSObject getSDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SD"));
		return object;
	}

	@Override
	public String getSDType() {
		COSObject SD = getSDValue();
		return getObjectType(SD);
	}

	@Override
	public Boolean getSDHasTypeArray() {
		COSObject SD = getSDValue();
		return getHasTypeArray(SD);
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

	public COSObject gettrailerCatalogNamesDestsValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		if (Root == null || !Root.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Names = Root.getKey(ASAtom.getASAtom("Names"));
		if (Names == null || !Names.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Dests = Names.getKey(ASAtom.getASAtom("Dests"));
		return Dests;
	}

	@Override
	public Boolean getDIsNameTreetrailerCatalogNamesDestsIndex() {
		COSObject D = getDValue();
		COSObject trailerCatalogNamesDests = gettrailerCatalogNamesDestsValue();
		if (D == null || D.getType() != COSObjType.COS_STRING) {
			return false;
		}
		if (trailerCatalogNamesDests == null || trailerCatalogNamesDests.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(trailerCatalogNamesDests);
		return nameTreeNode.containsKey(D.getString());
	}

}
