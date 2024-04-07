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
			case "PageLabelsTreeNode":
				return getPageLabelsTreeNode();
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

	private List<ANumberTreeNode> getPageLabelsTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPageLabelsTreeNode1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANumberTreeNode> getPageLabelsTreeNode1_3() {
		COSObject object = getPageLabelsTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANumberTreeNode> list = new ArrayList<>(1);
			list.add(new GFANumberTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "PageLabelsTreeNode"));
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
	public Boolean getcontainsAcroForm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AcroForm"));
	}

	public COSObject getAcroFormValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AcroForm"));
		return object;
	}

	@Override
	public String getAcroFormType() {
		COSObject AcroForm = getAcroFormValue();
		return getObjectType(AcroForm);
	}

	@Override
	public Boolean getAcroFormHasTypeDictionary() {
		COSObject AcroForm = getAcroFormValue();
		return getHasTypeDictionary(AcroForm);
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
	public String getCollectionType() {
		COSObject Collection = getCollectionValue();
		return getObjectType(Collection);
	}

	@Override
	public Boolean getCollectionHasTypeDictionary() {
		COSObject Collection = getCollectionValue();
		return getHasTypeDictionary(Collection);
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
	public String getDPartRootType() {
		COSObject DPartRoot = getDPartRootValue();
		return getObjectType(DPartRoot);
	}

	@Override
	public Boolean getDPartRootHasTypeDictionary() {
		COSObject DPartRoot = getDPartRootValue();
		return getHasTypeDictionary(DPartRoot);
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
	public String getDSSType() {
		COSObject DSS = getDSSValue();
		return getObjectType(DSS);
	}

	@Override
	public Boolean getDSSHasTypeDictionary() {
		COSObject DSS = getDSSValue();
		return getHasTypeDictionary(DSS);
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
		COSObject Dests = getDestsValue();
		return getisIndirect(Dests);
	}

	@Override
	public String getDestsType() {
		COSObject Dests = getDestsValue();
		return getObjectType(Dests);
	}

	@Override
	public Boolean getDestsHasTypeDictionary() {
		COSObject Dests = getDestsValue();
		return getHasTypeDictionary(Dests);
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
		COSObject Extensions = getExtensionsValue();
		return getisIndirect(Extensions);
	}

	@Override
	public String getExtensionsType() {
		COSObject Extensions = getExtensionsValue();
		return getObjectType(Extensions);
	}

	@Override
	public Boolean getExtensionsHasTypeDictionary() {
		COSObject Extensions = getExtensionsValue();
		return getHasTypeDictionary(Extensions);
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
	public Boolean getcontainsLegal() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Legal"));
	}

	public COSObject getLegalValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Legal"));
		return object;
	}

	@Override
	public String getLegalType() {
		COSObject Legal = getLegalValue();
		return getObjectType(Legal);
	}

	@Override
	public Boolean getLegalHasTypeDictionary() {
		COSObject Legal = getLegalValue();
		return getHasTypeDictionary(Legal);
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
	public String getMarkInfoType() {
		COSObject MarkInfo = getMarkInfoValue();
		return getObjectType(MarkInfo);
	}

	@Override
	public Boolean getMarkInfoHasTypeDictionary() {
		COSObject MarkInfo = getMarkInfoValue();
		return getHasTypeDictionary(MarkInfo);
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
		COSObject Metadata = getMetadataValue();
		return getisIndirect(Metadata);
	}

	@Override
	public String getMetadataType() {
		COSObject Metadata = getMetadataValue();
		return getObjectType(Metadata);
	}

	@Override
	public Boolean getMetadataHasTypeStream() {
		COSObject Metadata = getMetadataValue();
		return getHasTypeStream(Metadata);
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
	public String getNamesType() {
		COSObject Names = getNamesValue();
		return getObjectType(Names);
	}

	@Override
	public Boolean getNamesHasTypeDictionary() {
		COSObject Names = getNamesValue();
		return getHasTypeDictionary(Names);
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
	public String getNeedsRenderingType() {
		COSObject NeedsRendering = getNeedsRenderingValue();
		return getObjectType(NeedsRendering);
	}

	@Override
	public Boolean getNeedsRenderingHasTypeBoolean() {
		COSObject NeedsRendering = getNeedsRenderingValue();
		return getHasTypeBoolean(NeedsRendering);
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
	public String getOCPropertiesType() {
		COSObject OCProperties = getOCPropertiesValue();
		return getObjectType(OCProperties);
	}

	@Override
	public Boolean getOCPropertiesHasTypeDictionary() {
		COSObject OCProperties = getOCPropertiesValue();
		return getHasTypeDictionary(OCProperties);
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
	public String getOpenActionType() {
		COSObject OpenAction = getOpenActionValue();
		return getObjectType(OpenAction);
	}

	@Override
	public Boolean getOpenActionHasTypeArray() {
		COSObject OpenAction = getOpenActionValue();
		return getHasTypeArray(OpenAction);
	}

	@Override
	public Boolean getOpenActionHasTypeDictionary() {
		COSObject OpenAction = getOpenActionValue();
		return getHasTypeDictionary(OpenAction);
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
		COSObject Outlines = getOutlinesValue();
		return getisIndirect(Outlines);
	}

	@Override
	public String getOutlinesType() {
		COSObject Outlines = getOutlinesValue();
		return getObjectType(Outlines);
	}

	@Override
	public Boolean getOutlinesHasTypeDictionary() {
		COSObject Outlines = getOutlinesValue();
		return getHasTypeDictionary(Outlines);
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
	public String getOutputIntentsType() {
		COSObject OutputIntents = getOutputIntentsValue();
		return getObjectType(OutputIntents);
	}

	@Override
	public Boolean getOutputIntentsHasTypeArray() {
		COSObject OutputIntents = getOutputIntentsValue();
		return getHasTypeArray(OutputIntents);
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
	public String getPageLabelsType() {
		COSObject PageLabels = getPageLabelsValue();
		return getObjectType(PageLabels);
	}

	@Override
	public Boolean getPageLabelsHasTypeNumberTree() {
		COSObject PageLabels = getPageLabelsValue();
		return getHasTypeNumberTree(PageLabels);
	}

	@Override
	public Boolean getcontainsPageLabelsTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageLabels"));
	}

	public COSObject getPageLabelsTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageLabels"));
		return object;
	}

	@Override
	public String getPageLabelsTreeNodeType() {
		COSObject PageLabelsTreeNode = getPageLabelsTreeNodeValue();
		return getObjectType(PageLabelsTreeNode);
	}

	@Override
	public Boolean getPageLabelsTreeNodeHasTypeNumberTree() {
		COSObject PageLabelsTreeNode = getPageLabelsTreeNodeValue();
		return getHasTypeNumberTree(PageLabelsTreeNode);
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
	public String getPageLayoutType() {
		COSObject PageLayout = getPageLayoutValue();
		return getObjectType(PageLayout);
	}

	@Override
	public Boolean getPageLayoutHasTypeName() {
		COSObject PageLayout = getPageLayoutValue();
		return getHasTypeName(PageLayout);
	}

	@Override
	public String getPageLayoutNameValue() {
		COSObject PageLayout = getPageLayoutValue();
		return getNameValue(PageLayout);
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
	public String getPageModeType() {
		COSObject PageMode = getPageModeValue();
		return getObjectType(PageMode);
	}

	@Override
	public Boolean getPageModeHasTypeName() {
		COSObject PageMode = getPageModeValue();
		return getHasTypeName(PageMode);
	}

	@Override
	public String getPageModeNameValue() {
		COSObject PageMode = getPageModeValue();
		return getNameValue(PageMode);
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
		COSObject Pages = getPagesValue();
		return getisIndirect(Pages);
	}

	@Override
	public String getPagesType() {
		COSObject Pages = getPagesValue();
		return getObjectType(Pages);
	}

	@Override
	public Boolean getPagesHasTypeDictionary() {
		COSObject Pages = getPagesValue();
		return getHasTypeDictionary(Pages);
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
	public String getPermsType() {
		COSObject Perms = getPermsValue();
		return getObjectType(Perms);
	}

	@Override
	public Boolean getPermsHasTypeDictionary() {
		COSObject Perms = getPermsValue();
		return getHasTypeDictionary(Perms);
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
	public String getPieceInfoType() {
		COSObject PieceInfo = getPieceInfoValue();
		return getObjectType(PieceInfo);
	}

	@Override
	public Boolean getPieceInfoHasTypeDictionary() {
		COSObject PieceInfo = getPieceInfoValue();
		return getHasTypeDictionary(PieceInfo);
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
	public String getRequirementsType() {
		COSObject Requirements = getRequirementsValue();
		return getObjectType(Requirements);
	}

	@Override
	public Boolean getRequirementsHasTypeArray() {
		COSObject Requirements = getRequirementsValue();
		return getHasTypeArray(Requirements);
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
	public String getSpiderInfoType() {
		COSObject SpiderInfo = getSpiderInfoValue();
		return getObjectType(SpiderInfo);
	}

	@Override
	public Boolean getSpiderInfoHasTypeDictionary() {
		COSObject SpiderInfo = getSpiderInfoValue();
		return getHasTypeDictionary(SpiderInfo);
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
	public Boolean getisStructTreeRootIndirect() {
		COSObject StructTreeRoot = getStructTreeRootValue();
		return getisIndirect(StructTreeRoot);
	}

	@Override
	public String getStructTreeRootType() {
		COSObject StructTreeRoot = getStructTreeRootValue();
		return getObjectType(StructTreeRoot);
	}

	@Override
	public Boolean getStructTreeRootHasTypeDictionary() {
		COSObject StructTreeRoot = getStructTreeRootValue();
		return getHasTypeDictionary(StructTreeRoot);
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
		COSObject Threads = getThreadsValue();
		return getisIndirect(Threads);
	}

	@Override
	public String getThreadsType() {
		COSObject Threads = getThreadsValue();
		return getObjectType(Threads);
	}

	@Override
	public Boolean getThreadsHasTypeArray() {
		COSObject Threads = getThreadsValue();
		return getHasTypeArray(Threads);
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
	public Boolean getcontainsURI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URI"));
	}

	public COSObject getURIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URI"));
		return object;
	}

	@Override
	public String getURIType() {
		COSObject URI = getURIValue();
		return getObjectType(URI);
	}

	@Override
	public Boolean getURIHasTypeDictionary() {
		COSObject URI = getURIValue();
		return getHasTypeDictionary(URI);
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
	public String getVersionType() {
		COSObject Version = getVersionValue();
		return getObjectType(Version);
	}

	@Override
	public Boolean getVersionHasTypeName() {
		COSObject Version = getVersionValue();
		return getHasTypeName(Version);
	}

	@Override
	public String getVersionNameValue() {
		COSObject Version = getVersionValue();
		return getNameValue(Version);
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
	public String getViewerPreferencesType() {
		COSObject ViewerPreferences = getViewerPreferencesValue();
		return getObjectType(ViewerPreferences);
	}

	@Override
	public Boolean getViewerPreferencesHasTypeDictionary() {
		COSObject ViewerPreferences = getViewerPreferencesValue();
		return getHasTypeDictionary(ViewerPreferences);
	}

	@Override
	public Boolean gethasExtensionPDF_VT2() {
		return false;
	}

}
