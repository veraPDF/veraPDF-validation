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
				if (((gethasExtensionADBE_Extn3() == true)) == false) {
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
			case ARLINGTON1_6:
				return getIRT1_6();
			case ARLINGTON1_7:
				return getIRT1_7();
			case ARLINGTON2_0:
				return getIRT2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getIRT1_6() {
		COSObject object = getIRTValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getIRTDictionary1_6(object.getDirectBase(), "IRT");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getIRTDictionary1_6(COSBase base, String keyName) {
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
	public Boolean getAFHasTypeArray() {
		COSObject object = getAFValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getAFHasTypeDictionary() {
		COSObject object = getAFValue();
		return getHasTypeDictionary(object);
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
		return getHasTypeDictionary(object);
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
		return getHasTypeName(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getBMNameValue() {
		COSObject object = getBMValue();
		return getNameValue(object);
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
		return getHasTypeArray(object);
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
		return getHasTypeArray(object);
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
	public Boolean getCAHasTypeNumber() {
		COSObject object = getCAValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getCANumberValue() {
		COSObject object = getCAValue();
		return getNumberValue(object);
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
		return getHasTypeStringText(object);
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
		return getHasTypeDate(object);
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
		return getHasTypeDictionary(object);
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
	public Boolean getFHasTypeBitmask() {
		COSObject object = getFValue();
		return getHasTypeBitmask(object);
	}

	@Override
	public Long getFBitmaskValue() {
		COSObject object = getFValue();
		return getBitmaskValue(object);
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
		return getHasTypeDictionary(object);
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
		return getHasTypeName(object);
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
		return getHasTypeDate(object);
	}

	@Override
	public Boolean getMHasTypeStringText() {
		COSObject object = getMValue();
		return getHasTypeStringText(object);
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
		return getHasTypeStringText(object);
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
		return getHasTypeDictionary(object);
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
		return getisIndirect(object);
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject object = getPValue();
		return getHasTypeDictionary(object);
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
		return getisIndirect(object);
	}

	@Override
	public Boolean getPopupHasTypeDictionary() {
		COSObject object = getPopupValue();
		return getHasTypeDictionary(object);
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
		return getHasTypeArray(object);
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
		return getisIndirect(object);
	}

	@Override
	public Boolean getRCHasTypeStream() {
		COSObject object = getRCValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getRCHasTypeStringText() {
		COSObject object = getRCValue();
		return getHasTypeStringText(object);
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
	public Boolean getRTHasTypeName() {
		COSObject object = getRTValue();
		return getHasTypeName(object);
	}

	@Override
	public String getRTNameValue() {
		COSObject object = getRTValue();
		return getNameValue(object);
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
		return getHasTypeRectangle(object);
	}

	@Override
	public Double getRectRectHeight() {
		COSObject object = getRectValue();
		return getRectHeight(object);
	}

	@Override
	public Double getRectRectWidth() {
		COSObject object = getRectValue();
		return getRectWidth(object);
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
		return getHasTypeInteger(object);
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
		return getHasTypeStringText(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		return getNameValue(object);
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
		return getHasTypeStringText(object);
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
		return getNameValue(object);
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
		return getHasTypeNumber(object);
	}

	@Override
	public Double getcaNumberValue() {
		COSObject object = getcaValue();
		return getNumberValue(object);
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
		return getHasTypeDictionary(N);
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
		return getHasTypeDictionary(R);
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
		return getHasTypeDictionary(D);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
