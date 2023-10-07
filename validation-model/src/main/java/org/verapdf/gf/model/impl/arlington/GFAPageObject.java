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
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getAAValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAF2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getAF2_0() {
		COSObject object = getAFValue();
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
		return getAnnots1_0();
	}

	private List<AArrayOfAnnots> getAnnots1_0() {
		COSObject object = getAnnotsValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBoxColorInfoValue();
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
		return getContents1_0();
	}

	private List<org.verapdf.model.baselayer.Object> getContents1_0() {
		COSObject object = getContentsValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDPart1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPart> getDPart1_6() {
		COSObject object = getDPartValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getGroupValue();
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

	private List<AArrayOfOutputIntents> getOutputIntents() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getOutputIntents2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOutputIntents> getOutputIntents2_0() {
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

	private List<org.verapdf.model.baselayer.Object> getParent() {
		return getParent1_0();
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_0() {
		COSObject object = getParentValue();
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
		switch (StaticContainers.getFlavour()) {
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

	private List<ANavNode> getPresSteps() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getPresStepsValue();
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
		return getResources1_0();
	}

	private List<AResource> getResources1_0() {
		COSObject object = getResourcesValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getSeparationInfoValue();
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
		return getThumb1_0();
	}

	private List<AThumbnail> getThumb1_0() {
		COSObject object = getThumbValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getTransValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getVP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfViewports> getVP1_6() {
		COSObject object = getVPValue();
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

	public COSObject getAAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AA"));
		return object;
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
	public Boolean getAFHasTypeArray() {
		COSObject AF = getAFValue();
		return getHasTypeArray(AF);
	}

	@Override
	public Boolean getAFHasTypeDictionary() {
		COSObject AF = getAFValue();
		return getHasTypeDictionary(AF);
	}

	@Override
	public Boolean getcontainsAnnots() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Annots"));
	}

	public COSObject getAnnotsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annots"));
		return object;
	}

	@Override
	public Boolean getAnnotsHasTypeArray() {
		COSObject Annots = getAnnotsValue();
		return getHasTypeArray(Annots);
	}

	@Override
	public Boolean getcontainsArtBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ArtBox"));
	}

	public COSObject getArtBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ArtBox"));
		return object;
	}

	@Override
	public Boolean getArtBoxHasTypeRectangle() {
		COSObject ArtBox = getArtBoxValue();
		return getHasTypeRectangle(ArtBox);
	}

	@Override
	public Boolean getcontainsB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("B"));
	}

	public COSObject getBValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("B"));
		return object;
	}

	@Override
	public Boolean getBHasTypeArray() {
		COSObject B = getBValue();
		return getHasTypeArray(B);
	}

	@Override
	public Boolean getcontainsBleedBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BleedBox"));
	}

	public COSObject getBleedBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BleedBox"));
		return object;
	}

	@Override
	public Boolean getBleedBoxHasTypeRectangle() {
		COSObject BleedBox = getBleedBoxValue();
		return getHasTypeRectangle(BleedBox);
	}

	@Override
	public Boolean getcontainsBoxColorInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BoxColorInfo"));
	}

	public COSObject getBoxColorInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BoxColorInfo"));
		return object;
	}

	@Override
	public Boolean getBoxColorInfoHasTypeDictionary() {
		COSObject BoxColorInfo = getBoxColorInfoValue();
		return getHasTypeDictionary(BoxColorInfo);
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
	public Boolean getisContentsIndirect() {
		COSObject Contents = getContentsValue();
		return getisIndirect(Contents);
	}

	@Override
	public Boolean getContentsHasTypeArray() {
		COSObject Contents = getContentsValue();
		return getHasTypeArray(Contents);
	}

	@Override
	public Boolean getContentsHasTypeStream() {
		COSObject Contents = getContentsValue();
		return getHasTypeStream(Contents);
	}

	@Override
	public Boolean getcontainsCropBox() {
		if (isContainsInheritableValue(ASAtom.getASAtom("CropBox"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("CropBox"));
	}

	public COSObject getCropBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropBox"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("CropBox"));
		}
		return object;
	}

	@Override
	public Boolean getCropBoxHasTypeRectangle() {
		COSObject CropBox = getCropBoxValue();
		return getHasTypeRectangle(CropBox);
	}

	@Override
	public Boolean getcontainsDPart() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DPart"));
	}

	public COSObject getDPartValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DPart"));
		return object;
	}

	@Override
	public Boolean getDPartHasTypeDictionary() {
		COSObject DPart = getDPartValue();
		return getHasTypeDictionary(DPart);
	}

	@Override
	public Boolean getcontainsDur() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dur"));
	}

	public COSObject getDurValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dur"));
		return object;
	}

	@Override
	public Boolean getDurHasTypeNumber() {
		COSObject Dur = getDurValue();
		return getHasTypeNumber(Dur);
	}

	@Override
	public Boolean getcontainsGroup() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Group"));
	}

	public COSObject getGroupValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Group"));
		return object;
	}

	@Override
	public Boolean getGroupHasTypeDictionary() {
		COSObject Group = getGroupValue();
		return getHasTypeDictionary(Group);
	}

	@Override
	public Boolean getcontainsHid() {
		if (isContainsInheritableValue(ASAtom.getASAtom("Hid"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("Hid"));
	}

	public COSObject getHidDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getHidValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Hid"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("Hid"));
		}
		if (object == null || object.empty()) {
			object = getHidDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getHidHasTypeBoolean() {
		COSObject Hid = getHidValue();
		return getHasTypeBoolean(Hid);
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	public COSObject getentryIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object;
	}

	@Override
	public Boolean getentryIDHasTypeStringByte() {
		COSObject entryID = getentryIDValue();
		return getHasTypeStringByte(entryID);
	}

	@Override
	public Boolean getcontainsLastModified() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LastModified"));
	}

	public COSObject getLastModifiedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LastModified"));
		return object;
	}

	@Override
	public Boolean getLastModifiedHasTypeDate() {
		COSObject LastModified = getLastModifiedValue();
		return getHasTypeDate(LastModified);
	}

	@Override
	public Boolean getcontainsMediaBox() {
		if (isContainsInheritableValue(ASAtom.getASAtom("MediaBox"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("MediaBox"));
	}

	public COSObject getMediaBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MediaBox"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("MediaBox"));
		}
		return object;
	}

	@Override
	public Boolean getMediaBoxHasTypeRectangle() {
		COSObject MediaBox = getMediaBoxValue();
		return getHasTypeRectangle(MediaBox);
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
	public Boolean getMetadataHasTypeStream() {
		COSObject Metadata = getMetadataValue();
		return getHasTypeStream(Metadata);
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
		COSObject OutputIntents = getOutputIntentsValue();
		return getHasTypeArray(OutputIntents);
	}

	@Override
	public Boolean getcontainsPZ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PZ"));
	}

	public COSObject getPZValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PZ"));
		return object;
	}

	@Override
	public Boolean getPZHasTypeNumber() {
		COSObject PZ = getPZValue();
		return getHasTypeNumber(PZ);
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
	public Boolean getisParentIndirect() {
		COSObject Parent = getParentValue();
		return getisIndirect(Parent);
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject Parent = getParentValue();
		return getHasTypeDictionary(Parent);
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
		COSObject PieceInfo = getPieceInfoValue();
		return getHasTypeDictionary(PieceInfo);
	}

	@Override
	public Boolean getcontainsPresSteps() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PresSteps"));
	}

	public COSObject getPresStepsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PresSteps"));
		return object;
	}

	@Override
	public Boolean getPresStepsHasTypeDictionary() {
		COSObject PresSteps = getPresStepsValue();
		return getHasTypeDictionary(PresSteps);
	}

	@Override
	public Boolean getcontainsResources() {
		if (isContainsInheritableValue(ASAtom.getASAtom("Resources"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("Resources"));
		}
		return object;
	}

	@Override
	public Boolean getResourcesHasTypeDictionary() {
		COSObject Resources = getResourcesValue();
		return getHasTypeDictionary(Resources);
	}

	@Override
	public Boolean getcontainsRotate() {
		if (isContainsInheritableValue(ASAtom.getASAtom("Rotate"))) {
			return true;
		}
		return this.baseObject.knownKey(ASAtom.getASAtom("Rotate"));
	}

	public COSObject getRotateDefaultValue() {
		return COSInteger.construct(0L);
	}

	public COSObject getRotateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rotate"));
		if (object == null || object.empty()) {
			object = getInheritableValue(ASAtom.getASAtom("Rotate"));
		}
		if (object == null || object.empty()) {
			object = getRotateDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRotateHasTypeInteger() {
		COSObject Rotate = getRotateValue();
		return getHasTypeInteger(Rotate);
	}

	@Override
	public Long getRotateIntegerValue() {
		COSObject Rotate = getRotateValue();
		return getIntegerValue(Rotate);
	}

	@Override
	public Boolean getcontainsSeparationInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SeparationInfo"));
	}

	public COSObject getSeparationInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SeparationInfo"));
		return object;
	}

	@Override
	public Boolean getSeparationInfoHasTypeDictionary() {
		COSObject SeparationInfo = getSeparationInfoValue();
		return getHasTypeDictionary(SeparationInfo);
	}

	@Override
	public Boolean getcontainsStructParents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructParents"));
	}

	public COSObject getStructParentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructParents"));
		return object;
	}

	@Override
	public Boolean getStructParentsHasTypeInteger() {
		COSObject StructParents = getStructParentsValue();
		return getHasTypeInteger(StructParents);
	}

	@Override
	public Boolean getcontainsTabs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Tabs"));
	}

	public COSObject getTabsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Tabs"));
		return object;
	}

	@Override
	public Boolean getTabsHasTypeName() {
		COSObject Tabs = getTabsValue();
		return getHasTypeName(Tabs);
	}

	@Override
	public String getTabsNameValue() {
		COSObject Tabs = getTabsValue();
		return getNameValue(Tabs);
	}

	@Override
	public Boolean getcontainsTemplateInstantiated() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TemplateInstantiated"));
	}

	public COSObject getTemplateInstantiatedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TemplateInstantiated"));
		return object;
	}

	@Override
	public Boolean getTemplateInstantiatedHasTypeName() {
		COSObject TemplateInstantiated = getTemplateInstantiatedValue();
		return getHasTypeName(TemplateInstantiated);
	}

	@Override
	public Boolean getTemplateInstantiatedEntryIsIndexInNameTreetrailerCatalogNamesPages() {
		COSObject TemplateInstantiated = getTemplateInstantiatedValue();
		if (TemplateInstantiated == null || TemplateInstantiated.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject trailerCatalogNamesPages = gettrailerCatalogNamesPagesValue();
		if (trailerCatalogNamesPages == null || trailerCatalogNamesPages.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(trailerCatalogNamesPages);
		return nameTreeNode.containsKey(TemplateInstantiated.getString());
	}

	@Override
	public Boolean getTemplateInstantiatedEntryIsIndexInNameTreetrailerCatalogNamesTemplates() {
		COSObject TemplateInstantiated = getTemplateInstantiatedValue();
		if (TemplateInstantiated == null || TemplateInstantiated.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject trailerCatalogNamesTemplates = gettrailerCatalogNamesTemplatesValue();
		if (trailerCatalogNamesTemplates == null || trailerCatalogNamesTemplates.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(trailerCatalogNamesTemplates);
		return nameTreeNode.containsKey(TemplateInstantiated.getString());
	}

	@Override
	public Boolean getcontainsThumb() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Thumb"));
	}

	public COSObject getThumbValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object;
	}

	@Override
	public Boolean getisThumbIndirect() {
		COSObject Thumb = getThumbValue();
		return getisIndirect(Thumb);
	}

	@Override
	public Boolean getThumbHasTypeStream() {
		COSObject Thumb = getThumbValue();
		return getHasTypeStream(Thumb);
	}

	@Override
	public Boolean getcontainsTrans() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Trans"));
	}

	public COSObject getTransValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Trans"));
		return object;
	}

	@Override
	public Boolean getTransHasTypeDictionary() {
		COSObject Trans = getTransValue();
		return getHasTypeDictionary(Trans);
	}

	@Override
	public Boolean getcontainsTrimBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrimBox"));
	}

	public COSObject getTrimBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrimBox"));
		return object;
	}

	@Override
	public Boolean getTrimBoxHasTypeRectangle() {
		COSObject TrimBox = getTrimBoxValue();
		return getHasTypeRectangle(TrimBox);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsUserUnit() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UserUnit"));
	}

	public COSObject getUserUnitDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1.0D);
		}
		return null;
	}

	public COSObject getUserUnitValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UserUnit"));
		if (object == null || object.empty()) {
			object = getUserUnitDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getUserUnitHasTypeNumber() {
		COSObject UserUnit = getUserUnitValue();
		return getHasTypeNumber(UserUnit);
	}

	@Override
	public Boolean getcontainsVP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VP"));
	}

	public COSObject getVPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VP"));
		return object;
	}

	@Override
	public Boolean getVPHasTypeArray() {
		COSObject VP = getVPValue();
		return getHasTypeArray(VP);
	}

	public COSObject gettrailerCatalogNamesPagesValue() {
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
		return Pages;
	}

	public COSObject gettrailerCatalogNamesTemplatesValue() {
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
		return Templates;
	}

	@Override
	public Boolean getpageContainsStructContentItems() {
		COSObject contents = this.baseObject.getKey(ASAtom.CONTENTS);
		if (contents.getType() == COSObjType.COS_STREAM || contents.getType() == COSObjType.COS_ARRAY) {
			try (ASInputStream opStream = contents.getDirectBase().getData(COSStream.FilterFlags.DECODE); PDFStreamParser streamParser = new PDFStreamParser(opStream)) {
				streamParser.parseTokens();
				List<COSBase> arguments = new ArrayList<>();
				for (java.lang.Object rawToken : streamParser.getTokens()) {
					if (rawToken instanceof COSBase) {
						arguments.add((COSBase) rawToken);
					} else if (rawToken instanceof Operator) {
						String operatorName = ((Operator)rawToken).getOperator();
						if (Operators.BMC.equals(operatorName) || Operators.BDC.equals(operatorName)) {
							if (arguments.isEmpty()) {
								continue;
							}
							COSBase lastArgument = arguments.get(arguments.size() - 1);
							if (lastArgument.getType() == COSObjType.COS_NAME) {
								//todo check dict from properties
							}
							if (lastArgument.getType() == COSObjType.COS_DICT) {
								if (lastArgument.knownKey(ASAtom.MCID)) {
									return true;
								}
							}
						}
						arguments = new ArrayList<>();
					}
				}
			} catch (IOException exception) {
				return false;
			}
		}
		return false;
	}

	@Override
	public Boolean gethasExtensionPDF_VT2() {
		return false;
	}

}
