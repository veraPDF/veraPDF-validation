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

public class GFACatalog extends GFAObject implements ACatalog {

	public GFACatalog(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACatalog");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DPartRoot":
				return getDPartRoot();
			case "Legal":
				return getLegal();
			case "Metadata":
				return getMetadata();
			case "PageLabels":
				return getPageLabels();
			case "Extensions":
				return getExtensions();
			case "URI":
				return getURI();
			case "Requirements":
				return getRequirements();
			case "Names":
				return getNames();
			case "AcroForm":
				return getAcroForm();
			case "Outlines":
				return getOutlines();
			case "Dests":
				return getDests();
			case "SpiderInfo":
				return getSpiderInfo();
			case "AA":
				return getAA();
			case "AF":
				return getAF();
			case "DSS":
				return getDSS();
			case "OutputIntents":
				return getOutputIntents();
			case "PieceInfo":
				return getPieceInfo();
			case "OCProperties":
				return getOCProperties();
			case "Pages":
				return getPages();
			case "Threads":
				return getThreads();
			case "OpenAction":
				return getOpenAction();
			case "Perms":
				return getPerms();
			case "ViewerPreferences":
				return getViewerPreferences();
			case "Collection":
				return getCollection();
			case "MarkInfo":
				return getMarkInfo();
			case "StructTreeRoot":
				return getStructTreeRoot();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ADPartRoot> getDPartRoot() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDPartRoot1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPartRoot> getDPartRoot1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DPartRoot"));
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

	private List<ALegalAttestation> getLegal() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Legal"));
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

	private List<AMetadata> getMetadata() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
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

	private List<ACatalogNumberTreePageLabels> getPageLabels() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageLabels"));
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

	private List<AExtensions> getExtensions() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getExtensions1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AExtensions> getExtensions1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Extensions"));
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

	private List<AURI> getURI() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URI"));
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

	private List<AArrayOfRequirements> getRequirements() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRequirements1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRequirements> getRequirements1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Requirements"));
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

	private List<AName> getNames() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Names"));
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

	private List<AInteractiveForm> getAcroForm() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AcroForm"));
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

	private List<AOutline> getOutlines() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOutlines1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOutline> getOutlines1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Outlines"));
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

	private List<ADestsMap> getDests() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dests"));
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

	private List<AWebCaptureInfo> getSpiderInfo() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpiderInfo"));
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

	private List<AAddActionCatalog> getAA() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AA"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAF2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFileSpecifications> getAF2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
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

	private List<ADSS> getDSS() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getDSS2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADSS> getDSS2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSS"));
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

	private List<AArrayOfOutputIntents> getOutputIntents() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputIntents"));
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

	private List<APagePiece> getPieceInfo() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PieceInfo"));
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

	private List<AOptContentProperties> getOCProperties() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCProperties"));
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

	private List<APageTreeNodeRoot> getPages() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPages1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageTreeNodeRoot> getPages1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
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

	private List<AArrayOfThreads> getThreads() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Threads"));
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

	private List<org.verapdf.model.baselayer.Object> getOpenAction() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
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
			case 5:
				return new GFADestXYZArray(base, this.baseObject, keyName);
			case 2:
				return new GFADest0Array(base, this.baseObject, keyName);
			case 3:
				return new GFADest1Array(base, this.baseObject, keyName);
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
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
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
			case 5:
				return new GFADestXYZArray(base, this.baseObject, keyName);
			case 2:
				return new GFADest0Array(base, this.baseObject, keyName);
			case 3:
				return new GFADest1Array(base, this.baseObject, keyName);
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
			case "Hide":
				return new GFAActionHide(base, this.baseObject, keyName);
			case "Movie":
				return new GFAActionMovie(base, this.baseObject, keyName);
			case "Named":
				return new GFAActionNamed(base, this.baseObject, keyName);
			case "GoTo":
				return new GFAActionGoTo(base, this.baseObject, keyName);
			case "Sound":
				return new GFAActionSound(base, this.baseObject, keyName);
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			case "NOP":
				return new GFAActionNOP(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "GoToR":
				return new GFAActionGoToR(base, this.baseObject, keyName);
			case "ImportData":
				return new GFAActionImportData(base, this.baseObject, keyName);
			case "SubmitForm":
				return new GFAActionSubmitForm(base, this.baseObject, keyName);
			case "SetState":
				return new GFAActionSetState(base, this.baseObject, keyName);
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
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
			case 5:
				return new GFADestXYZArray(base, this.baseObject, keyName);
			case 2:
				return new GFADest0Array(base, this.baseObject, keyName);
			case 3:
				return new GFADest1Array(base, this.baseObject, keyName);
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
			case "Hide":
				return new GFAActionHide(base, this.baseObject, keyName);
			case "Movie":
				return new GFAActionMovie(base, this.baseObject, keyName);
			case "Named":
				return new GFAActionNamed(base, this.baseObject, keyName);
			case "GoTo":
				return new GFAActionGoTo(base, this.baseObject, keyName);
			case "Sound":
				return new GFAActionSound(base, this.baseObject, keyName);
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "GoToR":
				return new GFAActionGoToR(base, this.baseObject, keyName);
			case "JavaScript":
				return new GFAActionECMAScript(base, this.baseObject, keyName);
			case "ImportData":
				return new GFAActionImportData(base, this.baseObject, keyName);
			case "SubmitForm":
				return new GFAActionSubmitForm(base, this.baseObject, keyName);
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
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
			case 5:
				return new GFADestXYZArray(base, this.baseObject, keyName);
			case 2:
				return new GFADest0Array(base, this.baseObject, keyName);
			case 3:
				return new GFADest1Array(base, this.baseObject, keyName);
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
			case "Hide":
				return new GFAActionHide(base, this.baseObject, keyName);
			case "Movie":
				return new GFAActionMovie(base, this.baseObject, keyName);
			case "Named":
				return new GFAActionNamed(base, this.baseObject, keyName);
			case "GoTo":
				return new GFAActionGoTo(base, this.baseObject, keyName);
			case "Rendition":
				return new GFAActionRendition(base, this.baseObject, keyName);
			case "Sound":
				return new GFAActionSound(base, this.baseObject, keyName);
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "SetOCGState":
				return new GFAActionSetOCGState(base, this.baseObject, keyName);
			case "GoToR":
				return new GFAActionGoToR(base, this.baseObject, keyName);
			case "JavaScript":
				return new GFAActionECMAScript(base, this.baseObject, keyName);
			case "ImportData":
				return new GFAActionImportData(base, this.baseObject, keyName);
			case "SubmitForm":
				return new GFAActionSubmitForm(base, this.baseObject, keyName);
			case "Trans":
				return new GFAActionTransition(base, this.baseObject, keyName);
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOpenAction1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
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
			case 5:
				return new GFADestXYZArray(base, this.baseObject, keyName);
			case 2:
				return new GFADest0Array(base, this.baseObject, keyName);
			case 3:
				return new GFADest1Array(base, this.baseObject, keyName);
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
			case "Hide":
				return new GFAActionHide(base, this.baseObject, keyName);
			case "Movie":
				return new GFAActionMovie(base, this.baseObject, keyName);
			case "Named":
				return new GFAActionNamed(base, this.baseObject, keyName);
			case "GoTo":
				return new GFAActionGoTo(base, this.baseObject, keyName);
			case "Rendition":
				return new GFAActionRendition(base, this.baseObject, keyName);
			case "Sound":
				return new GFAActionSound(base, this.baseObject, keyName);
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "SetOCGState":
				return new GFAActionSetOCGState(base, this.baseObject, keyName);
			case "GoToR":
				return new GFAActionGoToR(base, this.baseObject, keyName);
			case "GoTo3DView":
				return new GFAActionGoTo3DView(base, this.baseObject, keyName);
			case "JavaScript":
				return new GFAActionECMAScript(base, this.baseObject, keyName);
			case "ImportData":
				return new GFAActionImportData(base, this.baseObject, keyName);
			case "SubmitForm":
				return new GFAActionSubmitForm(base, this.baseObject, keyName);
			case "Trans":
				return new GFAActionTransition(base, this.baseObject, keyName);
			case "GoToE":
				return new GFAActionGoToE(base, this.baseObject, keyName);
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOpenAction2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
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
			case 5:
				return new GFADestXYZArray(base, this.baseObject, keyName);
			case 2:
				return new GFADest0Array(base, this.baseObject, keyName);
			case 3:
				return new GFADest1Array(base, this.baseObject, keyName);
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
			case "Hide":
				return new GFAActionHide(base, this.baseObject, keyName);
			case "Movie":
				return new GFAActionMovie(base, this.baseObject, keyName);
			case "Named":
				return new GFAActionNamed(base, this.baseObject, keyName);
			case "GoTo":
				return new GFAActionGoTo(base, this.baseObject, keyName);
			case "GoToDp":
				return new GFAActionGoToDp(base, this.baseObject, keyName);
			case "Rendition":
				return new GFAActionRendition(base, this.baseObject, keyName);
			case "RichMediaExecute":
				return new GFAActionRichMediaExecute(base, this.baseObject, keyName);
			case "Sound":
				return new GFAActionSound(base, this.baseObject, keyName);
			case "Launch":
				return new GFAActionLaunch(base, this.baseObject, keyName);
			case "URI":
				return new GFAActionURI(base, this.baseObject, keyName);
			case "Thread":
				return new GFAActionThread(base, this.baseObject, keyName);
			case "SetOCGState":
				return new GFAActionSetOCGState(base, this.baseObject, keyName);
			case "GoToR":
				return new GFAActionGoToR(base, this.baseObject, keyName);
			case "GoTo3DView":
				return new GFAActionGoTo3DView(base, this.baseObject, keyName);
			case "JavaScript":
				return new GFAActionECMAScript(base, this.baseObject, keyName);
			case "ImportData":
				return new GFAActionImportData(base, this.baseObject, keyName);
			case "SubmitForm":
				return new GFAActionSubmitForm(base, this.baseObject, keyName);
			case "Trans":
				return new GFAActionTransition(base, this.baseObject, keyName);
			case "GoToE":
				return new GFAActionGoToE(base, this.baseObject, keyName);
			case "ResetForm":
				return new GFAActionResetForm(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<APermissions> getPerms() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Perms"));
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

	private List<AViewerPreferences> getViewerPreferences() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewerPreferences"));
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

	private List<ACollection> getCollection() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCollection1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollection> getCollection1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Collection"));
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

	private List<AMarkInfo> getMarkInfo() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MarkInfo"));
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

	private List<AStructTreeRoot> getStructTreeRoot() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructTreeRoot"));
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

	@Override
	public Boolean getcontainsPerms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Perms"));
	}

	@Override
	public Boolean getPermsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Perms"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDPartRoot() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DPartRoot"));
	}

	@Override
	public Boolean getDPartRootHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DPartRoot"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPages() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pages"));
	}

	@Override
	public Boolean getisPagesIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPagesHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsViewerPreferences() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ViewerPreferences"));
	}

	@Override
	public Boolean getViewerPreferencesHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ViewerPreferences"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSpiderInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SpiderInfo"));
	}

	@Override
	public Boolean getSpiderInfoHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SpiderInfo"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsMetadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Metadata"));
	}

	@Override
	public Boolean getisMetadataIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getMetadataHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsURI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URI"));
	}

	@Override
	public Boolean getURIHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URI"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsNeedsRendering() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NeedsRendering"));
	}

	@Override
	public Boolean getNeedsRenderingHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NeedsRendering"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsPageLabels() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageLabels"));
	}

	@Override
	public Boolean getPageLabelsHasTypeNumberTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageLabels"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	@Override
	public Boolean getVersionHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getVersionNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		if (object == null || object.empty()) {
			return getVersionNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getVersionNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsAcroForm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AcroForm"));
	}

	@Override
	public Boolean getAcroFormHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AcroForm"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsOpenAction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OpenAction"));
	}

	@Override
	public Boolean getOpenActionHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getOpenActionHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OpenAction"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsAF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AF"));
	}

	@Override
	public Boolean getAFHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getAFArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsAA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AA"));
	}

	@Override
	public Boolean getAAHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AA"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPageMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageMode"));
	}

	@Override
	public Boolean getPageModeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageMode"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPageModeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageMode"));
		if (object == null || object.empty()) {
			return getPageModeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPageModeNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "UseNone";
		}
		return null;
	}

	@Override
	public Boolean getcontainsPageLayout() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PageLayout"));
	}

	@Override
	public Boolean getPageLayoutHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageLayout"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPageLayoutNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PageLayout"));
		if (object == null || object.empty()) {
			return getPageLayoutNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPageLayoutNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "SinglePage";
		}
		return null;
	}

	@Override
	public Boolean getcontainsOCProperties() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OCProperties"));
	}

	@Override
	public Boolean getOCPropertiesHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCProperties"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsLegal() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Legal"));
	}

	@Override
	public Boolean getLegalHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Legal"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsOutlines() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Outlines"));
	}

	@Override
	public Boolean getisOutlinesIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Outlines"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getOutlinesHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Outlines"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsCollection() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Collection"));
	}

	@Override
	public Boolean getCollectionHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Collection"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDests() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dests"));
	}

	@Override
	public Boolean getisDestsIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dests"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getDestsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dests"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsOutputIntents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OutputIntents"));
	}

	@Override
	public Boolean getOutputIntentsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputIntents"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsMarkInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MarkInfo"));
	}

	@Override
	public Boolean getMarkInfoHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MarkInfo"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsNames() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Names"));
	}

	@Override
	public Boolean getNamesHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Names"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsStructTreeRoot() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructTreeRoot"));
	}

	@Override
	public Boolean getStructTreeRootHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructTreeRoot"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsPieceInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PieceInfo"));
	}

	@Override
	public Boolean getPieceInfoHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PieceInfo"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsExtensions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Extensions"));
	}

	@Override
	public Boolean getisExtensionsIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Extensions"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getExtensionsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Extensions"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDSS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DSS"));
	}

	@Override
	public Boolean getDSSHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsLang() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Lang"));
	}

	@Override
	public Boolean getLangHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Lang"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRequirements() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Requirements"));
	}

	@Override
	public Boolean getRequirementsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Requirements"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsThreads() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Threads"));
	}

	@Override
	public Boolean getisThreadsIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Threads"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getThreadsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Threads"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
