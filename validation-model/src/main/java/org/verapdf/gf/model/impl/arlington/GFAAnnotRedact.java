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

public class GFAAnnotRedact extends GFAObject implements AAnnotRedact {

	public GFAAnnotRedact(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAnnotRedact");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AF":
				return getAF();
			case "AP":
				return getAP();
			case "Border":
				return getBorder();
			case "C":
				return getC();
			case "ExData":
				return getExData();
			case "IC":
				return getIC();
			case "IRT":
				return getIRT();
			case "OC":
				return getOC();
			case "P":
				return getP();
			case "Popup":
				return getPopup();
			case "QuadPoints":
				return getQuadPoints();
			case "RC":
				return getRC();
			case "RO":
				return getRO();
			default:
				return super.getLinkedObjects(link);
		}
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

	private List<AAppearance> getAP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAP1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAppearance> getAP1_7() {
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

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBorder1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder1_7() {
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
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4NumbersColorAnnotation> getC1_7() {
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

	private List<org.verapdf.model.baselayer.Object> getExData() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				return getExData1_7();
			case ARLINGTON2_0:
				return getExData2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getExData1_7() {
		COSObject object = getExDataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getExDataDictionary1_7(object.getDirectBase(), "ExData");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getExDataDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "MarkupGeo":
				if (((gethasExtensionADBE_Extn3() == true)) == false) {
					return null;
				}
				return new GFAExDataMarkupGeo(base, this.baseObject, keyName);
			case "Markup3D":
				return new GFAExData3DMarkup(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getExData2_0() {
		COSObject object = getExDataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getExDataDictionary2_0(object.getDirectBase(), "ExData");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getExDataDictionary2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "MarkupGeo":
				return new GFAExDataMarkupGeo(base, this.baseObject, keyName);
			case "Markup3D":
				return new GFAExData3DMarkup(base, this.baseObject, keyName);
			case "3DM":
				return new GFAExDataProjection(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOf_4NumbersColorAnnotation> getIC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4NumbersColorAnnotation> getIC1_7() {
		COSObject object = getICValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4NumbersColorAnnotation> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4NumbersColorAnnotation((COSArray)object.getDirectBase(), this.baseObject, "IC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getIRT() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				return getIRT1_7();
			case ARLINGTON2_0:
				return getIRT2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getIRT1_7() {
		COSObject object = getIRTValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getIRTDictionary1_7(object.getDirectBase(), "IRT");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getIRTDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Redact":
				return new GFAAnnotRedact(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "3D":
				return new GFAAnnot3D(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getIRT2_0() {
		COSObject object = getIRTValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getIRTDictionary2_0(object.getDirectBase(), "IRT");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getIRTDictionary2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Projection":
				return new GFAAnnotProjection(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Redact":
				return new GFAAnnotRedact(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "3D":
				return new GFAAnnot3D(base, this.baseObject, keyName);
			case "RichMedia":
				return new GFAAnnotRichMedia(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOC1_7() {
		COSObject object = getOCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOCDictionary1_7(object.getDirectBase(), "OC");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOCDictionary1_7(COSBase base, String keyName) {
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
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getP1_7() {
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

	private List<AAnnotPopup> getPopup() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPopup1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAnnotPopup> getPopup1_7() {
		COSObject object = getPopupValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAnnotPopup> list = new ArrayList<>(1);
			list.add(new GFAAnnotPopup((COSDictionary)object.getDirectBase(), this.baseObject, "Popup"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfQuadPoints> getQuadPoints() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getQuadPoints1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfQuadPoints> getQuadPoints1_7() {
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

	private List<AStream> getRC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRC1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getRC1_7() {
		COSObject object = getRCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "RC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXObjectFormType1> getRO() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRO1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectFormType1> getRO1_7() {
		COSObject object = getROValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormType1> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormType1((COSStream)object.getDirectBase(), this.baseObject, "RO"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getAFHasTypeDictionary() {
		COSObject object = getAFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getAPHasTypeDictionary() {
		COSObject object = getAPValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getASHasTypeName() {
		COSObject object = getASValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getBMHasTypeName() {
		COSObject object = getBMValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBMNameValue() {
		COSObject object = getBMValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getBorderHasTypeArray() {
		COSObject object = getBorderValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getCHasTypeArray() {
		COSObject object = getCValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CA"));
	}

	public COSObject getCADefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
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
	public Boolean getCAHasTypeNumber() {
		COSObject object = getCAValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getCANumberValue() {
		COSObject object = getCAValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
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
	public Boolean getContentsHasTypeStringText() {
		COSObject object = getContentsValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsCreationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreationDate"));
	}

	public COSObject getCreationDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreationDate"));
		return object;
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject object = getCreationDateValue();
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsDA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DA"));
	}

	public COSObject getDAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DA"));
		return object;
	}

	@Override
	public Boolean getDAHasTypeStringByte() {
		COSObject object = getDAValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsExData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExData"));
	}

	public COSObject getExDataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExData"));
		return object;
	}

	@Override
	public Boolean getExDataHasTypeDictionary() {
		COSObject object = getExDataValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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
	public Boolean getFHasTypeBitmask() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFBitmaskValue() {
		COSObject object = getFValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsIC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IC"));
	}

	public COSObject getICValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IC"));
		return object;
	}

	@Override
	public Boolean getICHasTypeArray() {
		COSObject object = getICValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsIRT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IRT"));
	}

	public COSObject getIRTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IRT"));
		return object;
	}

	@Override
	public Boolean getIRTHasTypeDictionary() {
		COSObject object = getIRTValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsIT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IT"));
	}

	public COSObject getITValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IT"));
		return object;
	}

	@Override
	public Boolean getITHasTypeName() {
		COSObject object = getITValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
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
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getMHasTypeDate() {
		COSObject object = getMValue();
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getMHasTypeStringText() {
		COSObject object = getMValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getNMHasTypeStringText() {
		COSObject object = getNMValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getOCHasTypeDictionary() {
		COSObject object = getOCValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsOverlayText() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OverlayText"));
	}

	public COSObject getOverlayTextValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OverlayText"));
		return object;
	}

	@Override
	public Boolean getOverlayTextHasTypeStringText() {
		COSObject object = getOverlayTextValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
		COSObject object = getPValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject object = getPValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPopup() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Popup"));
	}

	public COSObject getPopupValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Popup"));
		return object;
	}

	@Override
	public Boolean getisPopupIndirect() {
		COSObject object = getPopupValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPopupHasTypeDictionary() {
		COSObject object = getPopupValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsQ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Q"));
	}

	public COSObject getQValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Q"));
		return object;
	}

	@Override
	public Boolean getQHasTypeInteger() {
		COSObject object = getQValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getQIntegerValue() {
		COSObject object = getQValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
	public Boolean getQuadPointsHasTypeArray() {
		COSObject object = getQuadPointsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsRC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RC"));
	}

	public COSObject getRCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RC"));
		return object;
	}

	@Override
	public Boolean getisRCIndirect() {
		COSObject object = getRCValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getRCHasTypeStream() {
		COSObject object = getRCValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getRCHasTypeStringText() {
		COSObject object = getRCValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RO"));
	}

	public COSObject getROValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RO"));
		return object;
	}

	@Override
	public Boolean getisROIndirect() {
		COSObject object = getROValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getROHasTypeStream() {
		COSObject object = getROValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsRT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RT"));
	}

	public COSObject getRTDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("R");
		}
		return null;
	}

	public COSObject getRTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RT"));
		if (object == null || object.empty()) {
			object = getRTDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRTHasTypeName() {
		COSObject object = getRTValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getRTNameValue() {
		COSObject object = getRTValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getRectHasTypeRectangle() {
		COSObject object = getRectValue();
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
	public Double getRectRectHeight() {
		COSObject object = getRectValue();
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return null;
		}
		COSObject bottom = object.at(1);
		COSObject top = object.at(3);
		if (bottom == null || (bottom.getType() != COSObjType.COS_INTEGER && bottom.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		if (top == null || (top.getType() != COSObjType.COS_INTEGER && top.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		return top.getReal() - bottom.getReal();
	}

	@Override
	public Double getRectRectWidth() {
		COSObject object = getRectValue();
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return null;
		}
		COSObject left = object.at(0);
		COSObject right = object.at(2);
		if (left == null || (left.getType() != COSObjType.COS_INTEGER && left.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		if (right == null || (right.getType() != COSObjType.COS_INTEGER && right.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		return right.getReal() - left.getReal();
	}

	@Override
	public Boolean getcontainsRepeat() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Repeat"));
	}

	public COSObject getRepeatValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Repeat"));
		return object;
	}

	@Override
	public Boolean getRepeatHasTypeBoolean() {
		COSObject object = getRepeatValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
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
	public Boolean getStructParentHasTypeInteger() {
		COSObject object = getStructParentValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsSubj() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subj"));
	}

	public COSObject getSubjValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subj"));
		return object;
	}

	@Override
	public Boolean getSubjHasTypeStringText() {
		COSObject object = getSubjValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
	public Boolean getTHasTypeStringText() {
		COSObject object = getTValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getcaHasTypeNumber() {
		COSObject object = getcaValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getcaNumberValue() {
		COSObject object = getcaValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getAPNHasTypeDictionary() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject N = AP.getKey(ASAtom.getASAtom("N"));
		return N != null && N.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getAPRHasTypeDictionary() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject R = AP.getKey(ASAtom.getASAtom("R"));
		return R != null && R.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getAPDHasTypeDictionary() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject D = AP.getKey(ASAtom.getASAtom("D"));
		return D != null && D.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
