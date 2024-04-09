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

public class GFAAnnotLink extends GFAObject implements AAnnotLink {

	public GFAAnnotLink(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAnnotLink");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A":
				return getA();
			case "AF":
				return getAF();
			case "AP":
				return getAP();
			case "BS":
				return getBS();
			case "Border":
				return getBorder();
			case "C":
				return getC();
			case "Dest":
				return getDest();
			case "OC":
				return getOC();
			case "P":
				return getP();
			case "PA":
				return getPA();
			case "Path":
				return getPath();
			case "QuadPoints":
				return getQuadPoints();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
				return getA1_1();
			case ARLINGTON1_2:
				return getA1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
				return getA1_3();
			case ARLINGTON1_5:
				return getA1_5();
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				return getA1_6();
			case ARLINGTON2_0:
				return getA2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getA1_1() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getADictionary1_1(object.getDirectBase(), "A");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getADictionary1_1(COSBase base, String keyName) {
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
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getA1_2() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getADictionary1_2(object.getDirectBase(), "A");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getADictionary1_2(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getA1_3() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getADictionary1_3(object.getDirectBase(), "A");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getADictionary1_3(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getA1_5() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getADictionary1_5(object.getDirectBase(), "A");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getADictionary1_5(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getA1_6() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getADictionary1_6(object.getDirectBase(), "A");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getADictionary1_6(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getA2_0() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getADictionary2_0(object.getDirectBase(), "A");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getADictionary2_0(COSBase base, String keyName) {
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

	private List<AArrayOfFileSpecifications> getAF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAF1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFileSpecifications> getAF1_7() {
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

	private List<AAppearance> getAP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAP1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAppearance> getAP1_2() {
		COSObject object = getAPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAppearance> list = new ArrayList<>(1);
			list.add(new GFAAppearance((COSDictionary)object.getDirectBase(), this.baseObject, "AP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ABorderStyle> getBS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBS1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ABorderStyle> getBS1_2() {
		COSObject object = getBSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ABorderStyle> list = new ArrayList<>(1);
			list.add(new GFABorderStyle((COSDictionary)object.getDirectBase(), this.baseObject, "BS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder() {
		return getBorder1_0();
	}

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder1_0() {
		COSObject object = getBorderValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4AnnotBorderCharacteristics> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4AnnotBorderCharacteristics((COSArray)object.getDirectBase(), this.baseObject, "Border"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4NumbersColorAnnotation> getC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4NumbersColorAnnotation> getC1_1() {
		COSObject object = getCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4NumbersColorAnnotation> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4NumbersColorAnnotation((COSArray)object.getDirectBase(), this.baseObject, "C"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDest() {
		return getDest1_0();
	}

	private List<org.verapdf.model.baselayer.Object> getDest1_0() {
		COSObject object = getDestValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getDestArray1_0(object.getDirectBase(), "Dest");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDestArray1_0(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getOC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOC1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOC1_5() {
		COSObject object = getOCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOCDictionary1_5(object.getDirectBase(), "OC");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOCDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "OCG":
				return new GFAOptContentGroup(base, this.baseObject, keyName);
			case "OCMD":
				return new GFAOptContentMembership(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<APageObject> getP() {
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

	private List<APageObject> getP1_3() {
		COSObject object = getPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "P"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AActionURI> getPA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPA1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AActionURI> getPA1_3() {
		COSObject object = getPAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AActionURI> list = new ArrayList<>(1);
			list.add(new GFAActionURI((COSDictionary)object.getDirectBase(), this.baseObject, "PA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfArraysPaths> getPath() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getPath2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfArraysPaths> getPath2_0() {
		COSObject object = getPathValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfArraysPaths> list = new ArrayList<>(1);
			list.add(new GFAArrayOfArraysPaths((COSArray)object.getDirectBase(), this.baseObject, "Path"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfQuadPoints> getQuadPoints() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getQuadPoints1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfQuadPoints> getQuadPoints1_6() {
		COSObject object = getQuadPointsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfQuadPoints> list = new ArrayList<>(1);
			list.add(new GFAArrayOfQuadPoints((COSArray)object.getDirectBase(), this.baseObject, "QuadPoints"));
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
	public String getAType() {
		COSObject A = getAValue();
		return getObjectType(A);
	}

	@Override
	public Boolean getAHasTypeDictionary() {
		COSObject A = getAValue();
		return getHasTypeDictionary(A);
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
	public Boolean getcontainsAP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AP"));
	}

	public COSObject getAPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		return object;
	}

	@Override
	public String getAPType() {
		COSObject AP = getAPValue();
		return getObjectType(AP);
	}

	@Override
	public Boolean getAPHasTypeDictionary() {
		COSObject AP = getAPValue();
		return getHasTypeDictionary(AP);
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
	public Boolean getcontainsBM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BM"));
	}

	public COSObject getBMDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSName.construct("Normal");
		}
		return null;
	}

	public COSObject getBMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		if (object == null || object.empty()) {
			object = getBMDefaultValue();
		}
		return object;
	}

	@Override
	public String getBMType() {
		COSObject BM = getBMValue();
		return getObjectType(BM);
	}

	@Override
	public Boolean getBMHasTypeName() {
		COSObject BM = getBMValue();
		return getHasTypeName(BM);
	}

	@Override
	public String getBMNameValue() {
		COSObject BM = getBMValue();
		return getNameValue(BM);
	}

	@Override
	public Boolean getcontainsBS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BS"));
	}

	public COSObject getBSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BS"));
		return object;
	}

	@Override
	public String getBSType() {
		COSObject BS = getBSValue();
		return getObjectType(BS);
	}

	@Override
	public Boolean getBSHasTypeDictionary() {
		COSObject BS = getBSValue();
		return getHasTypeDictionary(BS);
	}

	@Override
	public Boolean getcontainsBorder() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Border"));
	}

	public COSObject getBorderValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Border"));
		return object;
	}

	@Override
	public String getBorderType() {
		COSObject Border = getBorderValue();
		return getObjectType(Border);
	}

	@Override
	public Boolean getBorderHasTypeArray() {
		COSObject Border = getBorderValue();
		return getHasTypeArray(Border);
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
	public Boolean getcontainsCA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CA"));
	}

	public COSObject getCADefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSReal.construct(1.0D);
		}
		return null;
	}

	public COSObject getCAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CA"));
		if (object == null || object.empty()) {
			object = getCADefaultValue();
		}
		return object;
	}

	@Override
	public String getCAType() {
		COSObject CA = getCAValue();
		return getObjectType(CA);
	}

	@Override
	public Boolean getCAHasTypeNumber() {
		COSObject CA = getCAValue();
		return getHasTypeNumber(CA);
	}

	@Override
	public Double getCANumberValue() {
		COSObject CA = getCAValue();
		return getNumberValue(CA);
	}

	@Override
	public Boolean getcontainsContents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Contents"));
	}

	public COSObject getContentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object;
	}

	@Override
	public String getContentsType() {
		COSObject Contents = getContentsValue();
		return getObjectType(Contents);
	}

	@Override
	public Boolean getContentsHasTypeStringText() {
		COSObject Contents = getContentsValue();
		return getHasTypeStringText(Contents);
	}

	@Override
	public Boolean getcontainsDest() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dest"));
	}

	public COSObject getDestValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dest"));
		return object;
	}

	@Override
	public String getDestType() {
		COSObject Dest = getDestValue();
		return getObjectType(Dest);
	}

	@Override
	public Boolean getDestHasTypeArray() {
		COSObject Dest = getDestValue();
		return getHasTypeArray(Dest);
	}

	@Override
	public Boolean getDestHasTypeName() {
		COSObject Dest = getDestValue();
		return getHasTypeName(Dest);
	}

	@Override
	public Boolean getDestHasTypeStringByte() {
		COSObject Dest = getDestValue();
		return getHasTypeStringByte(Dest);
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
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

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null || object.empty()) {
			object = getFDefaultValue();
		}
		return object;
	}

	@Override
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeBitmask() {
		COSObject F = getFValue();
		return getHasTypeBitmask(F);
	}

	@Override
	public Long getFBitmaskValue() {
		COSObject F = getFValue();
		return getBitmaskValue(F);
	}

	@Override
	public Boolean getcontainsH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("H"));
	}

	public COSObject getHDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("I");
		}
		return null;
	}

	public COSObject getHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		if (object == null || object.empty()) {
			object = getHDefaultValue();
		}
		return object;
	}

	@Override
	public String getHType() {
		COSObject H = getHValue();
		return getObjectType(H);
	}

	@Override
	public Boolean getHHasTypeName() {
		COSObject H = getHValue();
		return getHasTypeName(H);
	}

	@Override
	public String getHNameValue() {
		COSObject H = getHValue();
		return getNameValue(H);
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
	public Boolean getcontainsM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M"));
	}

	public COSObject getMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		return object;
	}

	@Override
	public String getMType() {
		COSObject M = getMValue();
		return getObjectType(M);
	}

	@Override
	public Boolean getMHasTypeDate() {
		COSObject M = getMValue();
		return getHasTypeDate(M);
	}

	@Override
	public Boolean getMHasTypeStringText() {
		COSObject M = getMValue();
		return getHasTypeStringText(M);
	}

	@Override
	public Boolean getcontainsNM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NM"));
	}

	public COSObject getNMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NM"));
		return object;
	}

	@Override
	public String getNMType() {
		COSObject NM = getNMValue();
		return getObjectType(NM);
	}

	@Override
	public Boolean getNMHasTypeStringText() {
		COSObject NM = getNMValue();
		return getHasTypeStringText(NM);
	}

	@Override
	public Boolean getcontainsOC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OC"));
	}

	public COSObject getOCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OC"));
		return object;
	}

	@Override
	public String getOCType() {
		COSObject OC = getOCValue();
		return getObjectType(OC);
	}

	@Override
	public Boolean getOCHasTypeDictionary() {
		COSObject OC = getOCValue();
		return getHasTypeDictionary(OC);
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
	public Boolean getcontainsPA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PA"));
	}

	public COSObject getPAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PA"));
		return object;
	}

	@Override
	public String getPAType() {
		COSObject PA = getPAValue();
		return getObjectType(PA);
	}

	@Override
	public Boolean getPAHasTypeDictionary() {
		COSObject PA = getPAValue();
		return getHasTypeDictionary(PA);
	}

	@Override
	public Boolean getcontainsPath() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Path"));
	}

	public COSObject getPathValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Path"));
		return object;
	}

	@Override
	public String getPathType() {
		COSObject Path = getPathValue();
		return getObjectType(Path);
	}

	@Override
	public Boolean getPathHasTypeArray() {
		COSObject Path = getPathValue();
		return getHasTypeArray(Path);
	}

	@Override
	public Boolean getcontainsQuadPoints() {
		return this.baseObject.knownKey(ASAtom.getASAtom("QuadPoints"));
	}

	public COSObject getQuadPointsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("QuadPoints"));
		return object;
	}

	@Override
	public String getQuadPointsType() {
		COSObject QuadPoints = getQuadPointsValue();
		return getObjectType(QuadPoints);
	}

	@Override
	public Boolean getQuadPointsHasTypeArray() {
		COSObject QuadPoints = getQuadPointsValue();
		return getHasTypeArray(QuadPoints);
	}

	@Override
	public Boolean getcontainsRect() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rect"));
	}

	public COSObject getRectValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rect"));
		return object;
	}

	@Override
	public String getRectType() {
		COSObject Rect = getRectValue();
		return getObjectType(Rect);
	}

	@Override
	public Boolean getRectHasTypeRectangle() {
		COSObject Rect = getRectValue();
		return getHasTypeRectangle(Rect);
	}

	@Override
	public Boolean getcontainsStructParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructParent"));
	}

	public COSObject getStructParentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructParent"));
		return object;
	}

	@Override
	public String getStructParentType() {
		COSObject StructParent = getStructParentValue();
		return getObjectType(StructParent);
	}

	@Override
	public Boolean getStructParentHasTypeInteger() {
		COSObject StructParent = getStructParentValue();
		return getHasTypeInteger(StructParent);
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
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

	@Override
	public Boolean getcontainsca() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ca"));
	}

	public COSObject getcaDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSReal.construct(1.0D);
		}
		return null;
	}

	public COSObject getcaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ca"));
		if (object == null || object.empty()) {
			object = getcaDefaultValue();
		}
		return object;
	}

	@Override
	public String getcaType() {
		COSObject ca = getcaValue();
		return getObjectType(ca);
	}

	@Override
	public Boolean getcaHasTypeNumber() {
		COSObject ca = getcaValue();
		return getHasTypeNumber(ca);
	}

	@Override
	public Double getcaNumberValue() {
		COSObject ca = getcaValue();
		return getNumberValue(ca);
	}

	public COSObject getAPDValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject D = AP.getKey(ASAtom.getASAtom("D"));
		return D;
	}

	public COSObject getAPNValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject N = AP.getKey(ASAtom.getASAtom("N"));
		return N;
	}

	public COSObject getAPRValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject R = AP.getKey(ASAtom.getASAtom("R"));
		return R;
	}

	@Override
	public Boolean getAPDHasTypeDictionary() {
		COSObject APD = getAPDValue();
		return getHasTypeDictionary(APD);
	}

	@Override
	public Boolean getAPNHasTypeDictionary() {
		COSObject APN = getAPNValue();
		return getHasTypeDictionary(APN);
	}

	@Override
	public Boolean getAPRHasTypeDictionary() {
		COSObject APR = getAPRValue();
		return getHasTypeDictionary(APR);
	}

}
