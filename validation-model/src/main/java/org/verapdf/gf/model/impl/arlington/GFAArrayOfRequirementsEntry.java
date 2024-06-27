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

public class GFAArrayOfRequirementsEntry extends GFAObject implements AArrayOfRequirementsEntry {

	private final COSBase parentParentObject;
	private final String collectionName;

	public GFAArrayOfRequirementsEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfRequirementsEntry");
		this.parentParentObject = parentParentObject;
		this.collectionName = collectionName;
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entry":
				return getEntry();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				return getEntry1_7();
			case ARLINGTON2_0:
				return getEntry2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_7() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary1_7(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("S"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "EnableJavaScripts":
				return new GFARequirementsEnableJavaScripts(base, this.baseObject, keyName);
			case "JS":
				return new GFARequirementsHandler(base, this.baseObject, keyName);
			case "NoOp":
				return new GFARequirementsHandler(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry2_0() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary2_0(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("S"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "3DMarkup":
				return new GFARequirements3DMarkup(base, this.baseObject, keyName);
			case "AcroFormInteract":
				return new GFARequirementsAcroFormInteract(base, this.baseObject, keyName);
			case "Action":
				return new GFARequirementsAction(base, this.baseObject, keyName);
			case "Attachment":
				return new GFARequirementsAttachment(base, this.baseObject, keyName);
			case "AttachmentEditing":
				return new GFARequirementsAttachmentEditing(base, this.baseObject, keyName);
			case "Collection":
				return new GFARequirementsCollection(base, this.baseObject, keyName);
			case "CollectionEditing":
				return new GFARequirementsCollectionEditing(base, this.baseObject, keyName);
			case "DPartInteract":
				return new GFARequirementsDPartInteract(base, this.baseObject, keyName);
			case "DigSig":
				return new GFARequirementsDigSig(base, this.baseObject, keyName);
			case "DigSigMDP":
				return new GFARequirementsDigSigMDP(base, this.baseObject, keyName);
			case "DigSigValidation":
				return new GFARequirementsDigSigValidation(base, this.baseObject, keyName);
			case "EnableJavaScripts":
				return new GFARequirementsEnableJavaScripts(base, this.baseObject, keyName);
			case "Encryption":
				return new GFARequirementsEncryption(base, this.baseObject, keyName);
			case "Geospatial2D":
				return new GFARequirementsGeospatial2D(base, this.baseObject, keyName);
			case "Geospatial3D":
				return new GFARequirementsGeospatial3D(base, this.baseObject, keyName);
			case "JS":
				return new GFARequirementsHandler(base, this.baseObject, keyName);
			case "Markup":
				return new GFARequirementsMarkup(base, this.baseObject, keyName);
			case "Multimedia":
				return new GFARequirementsMultimedia(base, this.baseObject, keyName);
			case "Navigation":
				return new GFARequirementsNavigation(base, this.baseObject, keyName);
			case "NoOp":
				return new GFARequirementsHandler(base, this.baseObject, keyName);
			case "OCAutoStates":
				return new GFARequirementsOCAutoStates(base, this.baseObject, keyName);
			case "OCInteract":
				return new GFARequirementsOCInteract(base, this.baseObject, keyName);
			case "PRC":
				return new GFARequirementsPRC(base, this.baseObject, keyName);
			case "RichMedia":
				return new GFARequirementsRichMedia(base, this.baseObject, keyName);
			case "STEP":
				if (gethasExtensionISO_TS_24064() != true) {
					return null;
				}
				return new GFARequirementsSTEP(base, this.baseObject, keyName);
			case "SeparationSimulation":
				return new GFARequirementsSeparationSimulation(base, this.baseObject, keyName);
			case "Transitions":
				return new GFARequirementsTransitions(base, this.baseObject, keyName);
			case "U3D":
				return new GFARequirementsU3D(base, this.baseObject, keyName);
			case "glTF":
				return new GFARequirementsglTF(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public String getType() {
		COSObject entry = getValue();
		return getObjectType(entry);
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject entry = getValue();
		return getHasTypeDictionary(entry);
	}

}
