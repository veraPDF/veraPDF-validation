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

public class GFACatalog extends GFAObject implements ACatalog {

	public GFACatalog(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACatalog");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AA":
				return getAA();
			case "AF":
				return getAF();
			case "AcroForm":
				return getAcroForm();
			case "Collection":
				return getCollection();
			case "DPartRoot":
				return getDPartRoot();
			case "DSS":
				return getDSS();
			case "Dests":
				return getDests();
			case "Extensions":
				return getExtensions();
			case "Legal":
				return getLegal();
			case "MarkInfo":
				return getMarkInfo();
			case "Metadata":
				return getMetadata();
			case "Names":
				return getNames();
			case "OCProperties":
				return getOCProperties();
			case "OpenAction":
				return getOpenAction();
			case "Outlines":
				return getOutlines();
			case "OutputIntents":
				return getOutputIntents();
			case "PageLabels":
				return getPageLabels();
			case "Pages":
				return getPages();
			case "Perms":
				return getPerms();
			case "PieceInfo":
				return getPieceInfo();
			case "Requirements":
				return getRequirements();
			case "SpiderInfo":
				return getSpiderInfo();
			case "StructTreeRoot":
				return getStructTreeRoot();
			case "Threads":
				return getThreads();
			case "URI":
				return getURI();
			case "ViewerPreferences":
				return getViewerPreferences();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AAddActionCatalog> getAA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAA1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAddActionCatalog> getAA1_4() {
		COSObject object = getAAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAddActionCatalog> list = new ArrayList<>(1);
			list.add(new GFAAddActionCatalog((COSDictionary)object.getDirectBase(), this.baseObject, "AA"));
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

	private List<AInteractiveForm> getAcroForm() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAcroForm1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AInteractiveForm> getAcroForm1_2() {
		COSObject object = getAcroFormValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AInteractiveForm> list = new ArrayList<>(1);
			list.add(new GFAInteractiveForm((COSDictionary)object.getDirectBase(), this.baseObject, "AcroForm"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollection> getCollection() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCollection1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollection> getCollection1_7() {
		COSObject object = getCollectionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollection> list = new ArrayList<>(1);
			list.add(new GFACollection((COSDictionary)object.getDirectBase(), this.baseObject, "Collection"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADPartRoot> getDPartRoot() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDPartRoot1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPartRoot> getDPartRoot1_6() {
		COSObject object = getDPartRootValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADPartRoot> list = new ArrayList<>(1);
			list.add(new GFADPartRoot((COSDictionary)object.getDirectBase(), this.baseObject, "DPartRoot"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADSS> getDSS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getDSS2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADSS> getDSS2_0() {
		COSObject object = getDSSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADSS> list = new ArrayList<>(1);
			list.add(new GFADSS((COSDictionary)object.getDirectBase(), this.baseObject, "DSS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADestsMap> getDests() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDests1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADestsMap> getDests1_1() {
		COSObject object = getDestsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADestsMap> list = new ArrayList<>(1);
			list.add(new GFADestsMap((COSDictionary)object.getDirectBase(), this.baseObject, "Dests"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AExtensions> getExtensions() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getExtensions1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AExtensions> getExtensions1_7() {
		COSObject object = getExtensionsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AExtensions> list = new ArrayList<>(1);
			list.add(new GFAExtensions((COSDictionary)object.getDirectBase(), this.baseObject, "Extensions"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ALegalAttestation> getLegal() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLegal1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ALegalAttestation> getLegal1_5() {
		COSObject object = getLegalValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ALegalAttestation> list = new ArrayList<>(1);
			list.add(new GFALegalAttestation((COSDictionary)object.getDirectBase(), this.baseObject, "Legal"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMarkInfo> getMarkInfo() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMarkInfo1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMarkInfo> getMarkInfo1_4() {
		COSObject object = getMarkInfoValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMarkInfo> list = new ArrayList<>(1);
			list.add(new GFAMarkInfo((COSDictionary)object.getDirectBase(), this.baseObject, "MarkInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMetadata> getMetadata() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMetadata1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMetadata> getMetadata1_4() {
		COSObject object = getMetadataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AMetadata> list = new ArrayList<>(1);
			list.add(new GFAMetadata((COSStream)object.getDirectBase(), this.baseObject, "Metadata"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AName> getNames() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNames1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AName> getNames1_2() {
		COSObject object = getNamesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AName> list = new ArrayList<>(1);
			list.add(new GFAName((COSDictionary)object.getDirectBase(), this.baseObject, "Names"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentProperties> getOCProperties() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOCProperties1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentProperties> getOCProperties1_5() {
		COSObject object = getOCPropertiesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentProperties> list = new ArrayList<>(1);
			list.add(new GFAOptContentProperties((COSDictionary)object.getDirectBase(), this.baseObject, "OCProperties"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getOpenAction() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
				return getOpenAction1_1();
			case ARLINGTON1_2:
				return getOpenAction1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
				return getOpenAction1_3();
			case ARLINGTON1_5:
				return getOpenAction1_5();
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				return getOpenAction1_6();
			case ARLINGTON2_0:
				return getOpenAction2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_1() {
		COSObject object = getOpenActionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getOpenActionArray1_1(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOpenActionDictionary1_1(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOpenActionArray1_1(COSBase base, String keyName) {
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

	private org.verapdf.model.baselayer.Object getOpenActionDictionary1_1(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_2() {
		COSObject object = getOpenActionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getOpenActionArray1_2(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOpenActionDictionary1_2(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOpenActionArray1_2(COSBase base, String keyName) {
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

	private org.verapdf.model.baselayer.Object getOpenActionDictionary1_2(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_3() {
		COSObject object = getOpenActionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getOpenActionArray1_3(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOpenActionDictionary1_3(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOpenActionArray1_3(COSBase base, String keyName) {
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

	private org.verapdf.model.baselayer.Object getOpenActionDictionary1_3(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_5() {
		COSObject object = getOpenActionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getOpenActionArray1_5(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOpenActionDictionary1_5(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOpenActionArray1_5(COSBase base, String keyName) {
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

	private org.verapdf.model.baselayer.Object getOpenActionDictionary1_5(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_6() {
		COSObject object = getOpenActionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getOpenActionArray1_6(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOpenActionDictionary1_6(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOpenActionArray1_6(COSBase base, String keyName) {
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

	private org.verapdf.model.baselayer.Object getOpenActionDictionary1_6(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getOpenAction2_0() {
		COSObject object = getOpenActionValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getOpenActionArray2_0(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOpenActionDictionary2_0(object.getDirectBase(), "OpenAction");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOpenActionArray2_0(COSBase base, String keyName) {
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

	private org.verapdf.model.baselayer.Object getOpenActionDictionary2_0(COSBase base, String keyName) {
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

	private List<AOutline> getOutlines() {
		return getOutlines1_0();
	}

	private List<AOutline> getOutlines1_0() {
		COSObject object = getOutlinesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOutline> list = new ArrayList<>(1);
			list.add(new GFAOutline((COSDictionary)object.getDirectBase(), this.baseObject, "Outlines"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOutputIntents> getOutputIntents() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOutputIntents1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOutputIntents> getOutputIntents1_4() {
		COSObject object = getOutputIntentsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOutputIntents> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOutputIntents((COSArray)object.getDirectBase(), this.baseObject, "OutputIntents"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACatalogNumberTreePageLabels> getPageLabels() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPageLabels1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACatalogNumberTreePageLabels> getPageLabels1_3() {
		COSObject object = getPageLabelsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACatalogNumberTreePageLabels> list = new ArrayList<>(1);
			list.add(new GFACatalogNumberTreePageLabels((COSDictionary)object.getDirectBase(), this.baseObject, "PageLabels"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<APageTreeNodeRoot> getPages() {
		return getPages1_0();
	}

	private List<APageTreeNodeRoot> getPages1_0() {
		COSObject object = getPagesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageTreeNodeRoot> list = new ArrayList<>(1);
			list.add(new GFAPageTreeNodeRoot((COSDictionary)object.getDirectBase(), this.baseObject, "Pages"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<APermissions> getPerms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPerms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<APermissions> getPerms1_5() {
		COSObject object = getPermsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APermissions> list = new ArrayList<>(1);
			list.add(new GFAPermissions((COSDictionary)object.getDirectBase(), this.baseObject, "Perms"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<APagePiece> getPieceInfo() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPieceInfo1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<APagePiece> getPieceInfo1_4() {
		COSObject object = getPieceInfoValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APagePiece> list = new ArrayList<>(1);
			list.add(new GFAPagePiece((COSDictionary)object.getDirectBase(), this.baseObject, "PieceInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfRequirements> getRequirements() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRequirements1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRequirements> getRequirements1_7() {
		COSObject object = getRequirementsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfRequirements> list = new ArrayList<>(1);
			list.add(new GFAArrayOfRequirements((COSArray)object.getDirectBase(), this.baseObject, "Requirements"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AWebCaptureInfo> getSpiderInfo() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSpiderInfo1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AWebCaptureInfo> getSpiderInfo1_3() {
		COSObject object = getSpiderInfoValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AWebCaptureInfo> list = new ArrayList<>(1);
			list.add(new GFAWebCaptureInfo((COSDictionary)object.getDirectBase(), this.baseObject, "SpiderInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStructTreeRoot> getStructTreeRoot() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getStructTreeRoot1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStructTreeRoot> getStructTreeRoot1_3() {
		COSObject object = getStructTreeRootValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AStructTreeRoot> list = new ArrayList<>(1);
			list.add(new GFAStructTreeRoot((COSDictionary)object.getDirectBase(), this.baseObject, "StructTreeRoot"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfThreads> getThreads() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getThreads1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfThreads> getThreads1_1() {
		COSObject object = getThreadsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfThreads> list = new ArrayList<>(1);
			list.add(new GFAArrayOfThreads((COSArray)object.getDirectBase(), this.baseObject, "Threads"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AURI> getURI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getURI1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURI> getURI1_1() {
		COSObject object = getURIValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AURI> list = new ArrayList<>(1);
			list.add(new GFAURI((COSDictionary)object.getDirectBase(), this.baseObject, "URI"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AViewerPreferences> getViewerPreferences() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getViewerPreferences1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AViewerPreferences> getViewerPreferences1_2() {
		COSObject object = getViewerPreferencesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AViewerPreferences> list = new ArrayList<>(1);
			list.add(new GFAViewerPreferences((COSDictionary)object.getDirectBase(), this.baseObject, "ViewerPreferences"));
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
	public Boolean getAAHasTypeDictionary() {
		COSObject object = getAAValue();
		return getHasTypeDictionary(object);
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
		return getHasTypeArray(object);
	}

	@Override
	public Long getAFArraySize() {
		COSObject object = getAFValue();
		return getArraySize(object);
	}

	@Override
	public Boolean getcontainsAcroForm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AcroForm"));
	}

	public COSObject getAcroFormValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AcroForm"));
		return object;
	}

	@Override
	public Boolean getAcroFormHasTypeDictionary() {
		COSObject object = getAcroFormValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsCollection() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Collection"));
	}

	public COSObject getCollectionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Collection"));
		return object;
	}

	@Override
	public Boolean getCollectionHasTypeDictionary() {
		COSObject object = getCollectionValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsDPartRoot() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DPartRoot"));
	}

	public COSObject getDPartRootValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DPartRoot"));
		return object;
	}

	@Override
	public Boolean getDPartRootHasTypeDictionary() {
		COSObject object = getDPartRootValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsDSS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DSS"));
	}

	public COSObject getDSSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSS"));
		return object;
	}

	@Override
	public Boolean getDSSHasTypeDictionary() {
		COSObject object = getDSSValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsDests() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dests"));
	}

	public COSObject getDestsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dests"));
		return object;
	}

	@Override
	public Boolean getisDestsIndirect() {
		COSObject object = getDestsValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getDestsHasTypeDictionary() {
		COSObject object = getDestsValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsExtensions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Extensions"));
	}

	public COSObject getExtensionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Extensions"));
		return object;
	}

	@Override
	public Boolean getisExtensionsIndirect() {
		COSObject object = getExtensionsValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getExtensionsHasTypeDictionary() {
		COSObject object = getExtensionsValue();
		return getHasTypeDictionary(object);
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
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsLegal() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Legal"));
	}

	public COSObject getLegalValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Legal"));
		return object;
	}

	@Override
	public Boolean getLegalHasTypeDictionary() {
		COSObject object = getLegalValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsMarkInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MarkInfo"));
	}

	public COSObject getMarkInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MarkInfo"));
		return object;
	}

	@Override
	public Boolean getMarkInfoHasTypeDictionary() {
		COSObject object = getMarkInfoValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsMetadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Metadata"));
	}

	public COSObject getMetadataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
		return object;
	}

	@Override
	public Boolean getisMetadataIndirect() {
		COSObject object = getMetadataValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getMetadataHasTypeStream() {
		COSObject object = getMetadataValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getcontainsNames() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Names"));
	}

	public COSObject getNamesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Names"));
		return object;
	}

	@Override
	public Boolean getNamesHasTypeDictionary() {
		COSObject object = getNamesValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsNeedsRendering() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NeedsRendering"));
	}

	public COSObject getNeedsRenderingDefaultValue() {
		return COSBoolean.construct(false);
	}

	public COSObject getNeedsRenderingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NeedsRendering"));
		if (object == null || object.empty()) {
			object = getNeedsRenderingDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getNeedsRenderingHasTypeBoolean() {
		COSObject object = getNeedsRenderingValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsOCProperties() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OCProperties"));
	}

	public COSObject getOCPropertiesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCProperties"));
		return object;
	}

	@Override
	public Boolean getOCPropertiesHasTypeDictionary() {
		COSObject object = getOCPropertiesValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsOpenAction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OpenAction"));
	}

	public COSObject getOpenActionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
		return object;
	}

	@Override
	public Boolean getOpenActionHasTypeArray() {
		COSObject object = getOpenActionValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getOpenActionHasTypeDictionary() {
		COSObject object = getOpenActionValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsOutlines() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Outlines"));
	}

	public COSObject getOutlinesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Outlines"));
		return object;
	}

	@Override
	public Boolean getisOutlinesIndirect() {
		COSObject object = getOutlinesValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getOutlinesHasTypeDictionary() {
		COSObject object = getOutlinesValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsOutputIntents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OutputIntents"));
	}

	public COSObject getOutputIntentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputIntents"));
		return object;
	}

	@Override
	public Boolean getOutputIntentsHasTypeArray() {
		COSObject object = getOutputIntentsValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsPageLabels() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageLabels"));
	}

	public COSObject getPageLabelsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageLabels"));
		return object;
	}

	@Override
	public Boolean getPageLabelsHasTypeNumberTree() {
		COSObject object = getPageLabelsValue();
		return getHasTypeNumberTree(object);
	}

	@Override
	public Boolean getcontainsPageLayout() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageLayout"));
	}

	public COSObject getPageLayoutDefaultValue() {
		return COSName.construct("SinglePage");
	}

	public COSObject getPageLayoutValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageLayout"));
		if (object == null || object.empty()) {
			object = getPageLayoutDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPageLayoutHasTypeName() {
		COSObject object = getPageLayoutValue();
		return getHasTypeName(object);
	}

	@Override
	public String getPageLayoutNameValue() {
		COSObject object = getPageLayoutValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPageMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageMode"));
	}

	public COSObject getPageModeDefaultValue() {
		return COSName.construct("UseNone");
	}

	public COSObject getPageModeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageMode"));
		if (object == null || object.empty()) {
			object = getPageModeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPageModeHasTypeName() {
		COSObject object = getPageModeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getPageModeNameValue() {
		COSObject object = getPageModeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsPages() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pages"));
	}

	public COSObject getPagesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
		return object;
	}

	@Override
	public Boolean getisPagesIndirect() {
		COSObject object = getPagesValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getPagesHasTypeDictionary() {
		COSObject object = getPagesValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsPerms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Perms"));
	}

	public COSObject getPermsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Perms"));
		return object;
	}

	@Override
	public Boolean getPermsHasTypeDictionary() {
		COSObject object = getPermsValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsPieceInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PieceInfo"));
	}

	public COSObject getPieceInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PieceInfo"));
		return object;
	}

	@Override
	public Boolean getPieceInfoHasTypeDictionary() {
		COSObject object = getPieceInfoValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsRequirements() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Requirements"));
	}

	public COSObject getRequirementsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Requirements"));
		return object;
	}

	@Override
	public Boolean getRequirementsHasTypeArray() {
		COSObject object = getRequirementsValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsSpiderInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpiderInfo"));
	}

	public COSObject getSpiderInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpiderInfo"));
		return object;
	}

	@Override
	public Boolean getSpiderInfoHasTypeDictionary() {
		COSObject object = getSpiderInfoValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsStructTreeRoot() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructTreeRoot"));
	}

	public COSObject getStructTreeRootValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructTreeRoot"));
		return object;
	}

	@Override
	public Boolean getStructTreeRootHasTypeDictionary() {
		COSObject object = getStructTreeRootValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsThreads() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Threads"));
	}

	public COSObject getThreadsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Threads"));
		return object;
	}

	@Override
	public Boolean getisThreadsIndirect() {
		COSObject object = getThreadsValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getThreadsHasTypeArray() {
		COSObject object = getThreadsValue();
		return getHasTypeArray(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsURI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URI"));
	}

	public COSObject getURIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URI"));
		return object;
	}

	@Override
	public Boolean getURIHasTypeDictionary() {
		COSObject object = getURIValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	public COSObject getVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object;
	}

	@Override
	public Boolean getVersionHasTypeName() {
		COSObject object = getVersionValue();
		return getHasTypeName(object);
	}

	@Override
	public String getVersionNameValue() {
		COSObject object = getVersionValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsViewerPreferences() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ViewerPreferences"));
	}

	public COSObject getViewerPreferencesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewerPreferences"));
		return object;
	}

	@Override
	public Boolean getViewerPreferencesHasTypeDictionary() {
		COSObject object = getViewerPreferencesValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean gethasExtensionPDF_VT2() {
		return false;
	}

}
