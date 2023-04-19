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

public class GFAPageObject extends GFAObject implements APageObject {

	public GFAPageObject(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APageObject");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AA":
				return getAA();
			case "AF":
				return getAF();
			case "Annots":
				return getAnnots();
			case "B":
				return getB();
			case "BoxColorInfo":
				return getBoxColorInfo();
			case "Contents":
				return getContents();
			case "DPart":
				return getDPart();
			case "Group":
				return getGroup();
			case "Metadata":
				return getMetadata();
			case "OutputIntents":
				return getOutputIntents();
			case "Parent":
				return getParent();
			case "PieceInfo":
				return getPieceInfo();
			case "PresSteps":
				return getPresSteps();
			case "Resources":
				return getResources();
			case "SeparationInfo":
				return getSeparationInfo();
			case "Thumb":
				return getThumb();
			case "Trans":
				return getTrans();
			case "VP":
				return getVP();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AAddActionPageObject> getAA() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAA1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAddActionPageObject> getAA1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AA"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAddActionPageObject> list = new ArrayList<>(1);
			list.add(new GFAAddActionPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "AA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getAF() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAF2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getAF2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfAnnots> getAnnots() {
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
				return getAnnots1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfAnnots> getAnnots1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annots"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfAnnots> list = new ArrayList<>(1);
			list.add(new GFAArrayOfAnnots((COSArray)object.getDirectBase(), this.baseObject, "Annots"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfBeads> getB() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getB1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfBeads> getB1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("B"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfBeads> list = new ArrayList<>(1);
			list.add(new GFAArrayOfBeads((COSArray)object.getDirectBase(), this.baseObject, "B"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ABoxColorInfo> getBoxColorInfo() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBoxColorInfo1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ABoxColorInfo> getBoxColorInfo1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BoxColorInfo"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ABoxColorInfo> list = new ArrayList<>(1);
			list.add(new GFABoxColorInfo((COSDictionary)object.getDirectBase(), this.baseObject, "BoxColorInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getContents() {
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
				return getContents1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getContents1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStreamsGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStreamsGeneral((COSArray)object.getDirectBase(), this.baseObject, "Contents"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Contents"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADPart> getDPart() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDPart1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPart> getDPart1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DPart"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADPart> list = new ArrayList<>(1);
			list.add(new GFADPart((COSDictionary)object.getDirectBase(), this.baseObject, "DPart"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AGroupAttributes> getGroup() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGroup1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AGroupAttributes> getGroup1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Group"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AGroupAttributes> list = new ArrayList<>(1);
			list.add(new GFAGroupAttributes((COSDictionary)object.getDirectBase(), this.baseObject, "Group"));
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

	private List<AArrayOfOutputIntents> getOutputIntents() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getOutputIntents2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOutputIntents> getOutputIntents2_0() {
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

	private List<org.verapdf.model.baselayer.Object> getParent() {
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
				return getParent1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_0(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_0(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("Parent"))) {
			return new GFAPageTreeNode(base, this.baseObject, keyName);
		}
		return new GFAPageTreeNodeRoot(base, this.baseObject, keyName);
	}

	private List<APagePiece> getPieceInfo() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPieceInfo1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<APagePiece> getPieceInfo1_3() {
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

	private List<ANavNode> getPresSteps() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPresSteps1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANavNode> getPresSteps1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PresSteps"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANavNode> list = new ArrayList<>(1);
			list.add(new GFANavNode((COSDictionary)object.getDirectBase(), this.baseObject, "PresSteps"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AResource> getResources() {
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
				return getResources1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AResource> getResources1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AResource> list = new ArrayList<>(1);
			list.add(new GFAResource((COSDictionary)object.getDirectBase(), this.baseObject, "Resources"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASeparation> getSeparationInfo() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSeparationInfo1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASeparation> getSeparationInfo1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SeparationInfo"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASeparation> list = new ArrayList<>(1);
			list.add(new GFASeparation((COSDictionary)object.getDirectBase(), this.baseObject, "SeparationInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AThumbnail> getThumb() {
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
				return getThumb1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AThumbnail> getThumb1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AThumbnail> list = new ArrayList<>(1);
			list.add(new GFAThumbnail((COSStream)object.getDirectBase(), this.baseObject, "Thumb"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ATransition> getTrans() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTrans1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<ATransition> getTrans1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Trans"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ATransition> list = new ArrayList<>(1);
			list.add(new GFATransition((COSDictionary)object.getDirectBase(), this.baseObject, "Trans"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfViewports> getVP() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getVP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfViewports> getVP1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VP"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfViewports> list = new ArrayList<>(1);
			list.add(new GFAArrayOfViewports((COSArray)object.getDirectBase(), this.baseObject, "VP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public Boolean getcontainsAF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AF"));
	}

	@Override
	public Boolean getAFHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getAFHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsAnnots() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Annots"));
	}

	@Override
	public Boolean getAnnotsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annots"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsArtBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ArtBox"));
	}

	@Override
	public Boolean getArtBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ArtBox"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean getcontainsB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("B"));
	}

	@Override
	public Boolean getBHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("B"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsBleedBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BleedBox"));
	}

	@Override
	public Boolean getBleedBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BleedBox"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean getcontainsBoxColorInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BoxColorInfo"));
	}

	@Override
	public Boolean getBoxColorInfoHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BoxColorInfo"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsContents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Contents"));
	}

	@Override
	public Boolean getisContentsIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getContentsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getContentsHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsCropBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CropBox"));
	}

	@Override
	public Boolean getCropBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropBox"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean getcontainsDPart() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DPart"));
	}

	@Override
	public Boolean getDPartHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DPart"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDur() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dur"));
	}

	@Override
	public Boolean getDurHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dur"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsGroup() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Group"));
	}

	@Override
	public Boolean getGroupHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Group"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsHid() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Hid"));
	}

	@Override
	public Boolean getHidHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Hid"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	@Override
	public Boolean getentryIDHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsLastModified() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LastModified"));
	}

	@Override
	public Boolean getLastModifiedHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LastModified"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsMediaBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MediaBox"));
	}

	@Override
	public Boolean getMediaBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MediaBox"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
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
	public Boolean getcontainsOutputIntents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OutputIntents"));
	}

	@Override
	public Boolean getOutputIntentsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OutputIntents"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPZ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PZ"));
	}

	@Override
	public Boolean getPZHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PZ"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Parent"));
	}

	@Override
	public Boolean getisParentIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getcontainsPresSteps() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PresSteps"));
	}

	@Override
	public Boolean getPresStepsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PresSteps"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	@Override
	public Boolean getResourcesHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsRotate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rotate"));
	}

	@Override
	public Boolean getRotateHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rotate"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRotateIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rotate"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("Rotate"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (object == null || object.empty()) {
			return getRotateIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getRotateIntegerDefaultValue() {
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
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsSeparationInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SeparationInfo"));
	}

	@Override
	public Boolean getSeparationInfoHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SeparationInfo"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsStructParents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructParents"));
	}

	@Override
	public Boolean getStructParentsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructParents"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsTabs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Tabs"));
	}

	@Override
	public Boolean getTabsHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Tabs"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTabsNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Tabs"));
		if (object == null || object.empty()) {
			return getTabsNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTabsNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsTemplateInstantiated() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TemplateInstantiated"));
	}

	@Override
	public Boolean getTemplateInstantiatedHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TemplateInstantiated"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getnameTreetrailerCatalogNamesPagesContainsTemplateInstantiatedString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TemplateInstantiated"));
		if (object == null || object.getType() != COSObjType.COS_STRING) {
			return false;
		}
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
		COSObject Pages = Names.getKey(ASAtom.getASAtom("Pages"));
		if (Pages == null || Pages.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(Pages);
		return nameTreeNode.getObject(object.getString()) != null;
	}

	@Override
	public Boolean getnameTreetrailerCatalogNamesTemplatesContainsTemplateInstantiatedString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TemplateInstantiated"));
		if (object == null || object.getType() != COSObjType.COS_STRING) {
			return false;
		}
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
		COSObject Templates = Names.getKey(ASAtom.getASAtom("Templates"));
		if (Templates == null || Templates.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(Templates);
		return nameTreeNode.getObject(object.getString()) != null;
	}

	@Override
	public Boolean getcontainsThumb() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Thumb"));
	}

	@Override
	public Boolean getisThumbIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getThumbHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsTrans() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Trans"));
	}

	@Override
	public Boolean getTransHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Trans"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsTrimBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrimBox"));
	}

	@Override
	public Boolean getTrimBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrimBox"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
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
	public Boolean getcontainsUserUnit() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UserUnit"));
	}

	@Override
	public Boolean getUserUnitHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UserUnit"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsVP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VP"));
	}

	@Override
	public Boolean getVPHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VP"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getpageContainsStructContentItems() {
		COSObject contents = this.baseObject.getKey(ASAtom.CONTENTS);
		if (contents.getType() == COSObjType.COS_STREAM || contents.getType() == COSObjType.COS_ARRAY) {
			try (ASInputStream opStream = contents.getDirectBase().getData(COSStream.FilterFlags.DECODE)) {
				try (PDFStreamParser streamParser = new PDFStreamParser(opStream)) {
					streamParser.parseTokens();
					for (java.lang.Object rawToken : streamParser.getTokens()) {
						if (rawToken instanceof Operator) {
							String operatorName = ((Operator)rawToken).getOperator();
							if (Operators.BMC.equals(operatorName) || Operators.BDC.equals(operatorName)) {
								return true;
							}
						}
					}
				}
			} catch (IOException exception) {
				return false;
			}
		}
		return false;
	}

}
