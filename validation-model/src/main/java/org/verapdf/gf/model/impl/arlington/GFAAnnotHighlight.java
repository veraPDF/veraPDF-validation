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

public class GFAAnnotHighlight extends GFAObject implements AAnnotHighlight {

	public GFAAnnotHighlight(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAnnotHighlight");
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
			default:
				return super.getLinkedObjects(link);
		}
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

	private List<AAppearance> getAP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAP1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAppearance> getAP1_3() {
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
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBorder1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder1_3() {
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
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4NumbersColorAnnotation> getC1_3() {
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
			case "Markup3D":
				return new GFAExData3DMarkup(base, this.baseObject, keyName);
			case "MarkupGeo":
				if (gethasExtensionADBE_Extn3() != true) {
					return null;
				}
				return new GFAExDataMarkupGeo(base, this.baseObject, keyName);
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
			case "3DM":
				return new GFAExDataProjection(base, this.baseObject, keyName);
			case "Markup3D":
				return new GFAExData3DMarkup(base, this.baseObject, keyName);
			case "MarkupGeo":
				return new GFAExDataMarkupGeo(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getIRT() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
				return getIRT1_5();
			case ARLINGTON1_7:
				return getIRT1_7();
			case ARLINGTON2_0:
				return getIRT2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getIRT1_5() {
		COSObject object = getIRTValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getIRTDictionary1_5(object.getDirectBase(), "IRT");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getIRTDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "3D":
				return new GFAAnnot3D(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			default:
				return null;
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
			case "3D":
				return new GFAAnnot3D(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "Redact":
				return new GFAAnnotRedact(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
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
			case "3D":
				return new GFAAnnot3D(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "Projection":
				return new GFAAnnotProjection(base, this.baseObject, keyName);
			case "Redact":
				return new GFAAnnotRedact(base, this.baseObject, keyName);
			case "RichMedia":
				return new GFAAnnotRichMedia(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
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

	private List<AAnnotPopup> getPopup() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPopup1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAnnotPopup> getPopup1_3() {
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
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getQuadPoints1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfQuadPoints> getQuadPoints1_3() {
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
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRC1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getRC1_5() {
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
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
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
	public Boolean getcontainsCreationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreationDate"));
	}

	public COSObject getCreationDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreationDate"));
		return object;
	}

	@Override
	public String getCreationDateType() {
		COSObject CreationDate = getCreationDateValue();
		return getObjectType(CreationDate);
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject CreationDate = getCreationDateValue();
		return getHasTypeDate(CreationDate);
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
	public String getExDataType() {
		COSObject ExData = getExDataValue();
		return getObjectType(ExData);
	}

	@Override
	public Boolean getExDataHasTypeDictionary() {
		COSObject ExData = getExDataValue();
		return getHasTypeDictionary(ExData);
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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
	public Boolean getcontainsIRT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IRT"));
	}

	public COSObject getIRTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IRT"));
		return object;
	}

	@Override
	public String getIRTType() {
		COSObject IRT = getIRTValue();
		return getObjectType(IRT);
	}

	@Override
	public Boolean getIRTHasTypeDictionary() {
		COSObject IRT = getIRTValue();
		return getHasTypeDictionary(IRT);
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
	public String getITType() {
		COSObject IT = getITValue();
		return getObjectType(IT);
	}

	@Override
	public Boolean getITHasTypeName() {
		COSObject IT = getITValue();
		return getHasTypeName(IT);
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
	public Boolean getcontainsPopup() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Popup"));
	}

	public COSObject getPopupValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Popup"));
		return object;
	}

	@Override
	public Boolean getisPopupIndirect() {
		COSObject Popup = getPopupValue();
		return getisIndirect(Popup);
	}

	@Override
	public String getPopupType() {
		COSObject Popup = getPopupValue();
		return getObjectType(Popup);
	}

	@Override
	public Boolean getPopupHasTypeDictionary() {
		COSObject Popup = getPopupValue();
		return getHasTypeDictionary(Popup);
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
	public Boolean getcontainsRC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RC"));
	}

	public COSObject getRCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RC"));
		return object;
	}

	@Override
	public Boolean getisRCIndirect() {
		COSObject RC = getRCValue();
		return getisIndirect(RC);
	}

	@Override
	public String getRCType() {
		COSObject RC = getRCValue();
		return getObjectType(RC);
	}

	@Override
	public Boolean getRCHasTypeStream() {
		COSObject RC = getRCValue();
		return getHasTypeStream(RC);
	}

	@Override
	public Boolean getRCHasTypeStringText() {
		COSObject RC = getRCValue();
		return getHasTypeStringText(RC);
	}

	@Override
	public Boolean getcontainsRT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RT"));
	}

	public COSObject getRTDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
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
	public String getRTType() {
		COSObject RT = getRTValue();
		return getObjectType(RT);
	}

	@Override
	public Boolean getRTHasTypeName() {
		COSObject RT = getRTValue();
		return getHasTypeName(RT);
	}

	@Override
	public String getRTNameValue() {
		COSObject RT = getRTValue();
		return getNameValue(RT);
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
	public Double getRectRectHeight() {
		COSObject Rect = getRectValue();
		return getRectHeight(Rect);
	}

	@Override
	public Double getRectRectWidth() {
		COSObject Rect = getRectValue();
		return getRectWidth(Rect);
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
	public Boolean getcontainsSubj() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subj"));
	}

	public COSObject getSubjValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subj"));
		return object;
	}

	@Override
	public String getSubjType() {
		COSObject Subj = getSubjValue();
		return getObjectType(Subj);
	}

	@Override
	public Boolean getSubjHasTypeStringText() {
		COSObject Subj = getSubjValue();
		return getHasTypeStringText(Subj);
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
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object;
	}

	@Override
	public String getTType() {
		COSObject T = getTValue();
		return getObjectType(T);
	}

	@Override
	public Boolean getTHasTypeStringText() {
		COSObject T = getTValue();
		return getHasTypeStringText(T);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
