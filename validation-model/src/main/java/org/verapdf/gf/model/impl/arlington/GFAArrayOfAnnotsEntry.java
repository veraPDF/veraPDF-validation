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

public class GFAArrayOfAnnotsEntry extends GFAObject implements AArrayOfAnnotsEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfAnnotsEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfAnnotsEntry");
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
			case ARLINGTON1_0:
			case ARLINGTON1_1:
				return getEntry1_0();
			case ARLINGTON1_2:
				return getEntry1_2();
			case ARLINGTON1_3:
				return getEntry1_3();
			case ARLINGTON1_4:
				return getEntry1_4();
			case ARLINGTON1_5:
				return getEntry1_5();
			case ARLINGTON1_6:
				return getEntry1_6();
			case ARLINGTON1_7:
				return getEntry1_7();
			case ARLINGTON2_0:
				return getEntry2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_0() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary1_0(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary1_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_2() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary1_2(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Widget":
				return getEntryDictionaryWidget1_2(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidget1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getEntryDictionaryWidgetDefault1_2(base, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getEntryDictionaryWidgetBtn1_2(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAAnnotWidgetFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getEntryDictionaryWidgetBtn01_2(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn01_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetDefault1_2(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("AA"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("Ff"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("T"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TM"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TU"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		return new GFAAnnotWidget(base, this.baseObject, keyName);
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_3() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary1_3(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary1_3(COSBase base, String keyName) {
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
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "TrapNet":
				return new GFAAnnotTrapNetwork(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Widget":
				return getEntryDictionaryWidget1_3(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidget1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getEntryDictionaryWidgetDefault1_3(base, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getEntryDictionaryWidgetBtn1_3(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAAnnotWidgetFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getEntryDictionaryWidgetBtn01_3(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn01_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetDefault1_3(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("AA"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("Ff"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("T"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TM"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TU"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		return new GFAAnnotWidget(base, this.baseObject, keyName);
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_4() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary1_4(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary1_4(COSBase base, String keyName) {
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
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
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
			case "TrapNet":
				return new GFAAnnotTrapNetwork(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Widget":
				return getEntryDictionaryWidget1_4(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidget1_4(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getEntryDictionaryWidgetDefault1_4(base, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getEntryDictionaryWidgetBtn1_4(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAAnnotWidgetFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn1_4(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getEntryDictionaryWidgetBtn01_4(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn01_4(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetDefault1_4(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("AA"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("Ff"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("T"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TM"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TU"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		return new GFAAnnotWidget(base, this.baseObject, keyName);
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_5() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary1_5(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
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
			case "PolyLine":
				return new GFAAnnotPolyLine(base, this.baseObject, keyName);
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
			case "TrapNet":
				return new GFAAnnotTrapNetwork(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Widget":
				return getEntryDictionaryWidget1_5(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidget1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getEntryDictionaryWidgetDefault1_5(base, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getEntryDictionaryWidgetBtn1_5(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAAnnotWidgetFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getEntryDictionaryWidgetBtn01_5(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn01_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetDefault1_5(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("AA"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("Ff"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("T"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TM"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TU"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		return new GFAAnnotWidget(base, this.baseObject, keyName);
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_6() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary1_6(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary1_6(COSBase base, String keyName) {
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
			case "PolyLine":
				return new GFAAnnotPolyLine(base, this.baseObject, keyName);
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
			case "TrapNet":
				return new GFAAnnotTrapNetwork(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Widget":
				return getEntryDictionaryWidget1_6(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidget1_6(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getEntryDictionaryWidgetDefault1_6(base, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getEntryDictionaryWidgetBtn1_6(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAAnnotWidgetFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn1_6(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getEntryDictionaryWidgetBtn01_6(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn01_6(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetDefault1_6(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("AA"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("Ff"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("T"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TM"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TU"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		return new GFAAnnotWidget(base, this.baseObject, keyName);
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
			case "PolyLine":
				return new GFAAnnotPolyLine(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "Projection":
				if (gethasExtensionADBE_Extn3() != true) {
					return null;
				}
				return new GFAAnnotProjection(base, this.baseObject, keyName);
			case "Redact":
				return new GFAAnnotRedact(base, this.baseObject, keyName);
			case "RichMedia":
				if (gethasExtensionADBE_Extn3() != true) {
					return null;
				}
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
			case "TrapNet":
				return new GFAAnnotTrapNetwork(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Widget":
				return getEntryDictionaryWidget1_7(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidget1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getEntryDictionaryWidgetDefault1_7(base, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getEntryDictionaryWidgetBtn1_7(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAAnnotWidgetFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getEntryDictionaryWidgetBtn01_7(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn01_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetDefault1_7(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("AA"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("Ff"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("T"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TM"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TU"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		return new GFAAnnotWidget(base, this.baseObject, keyName);
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
			case "PolyLine":
				return new GFAAnnotPolyLine(base, this.baseObject, keyName);
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
			case "TrapNet":
				return new GFAAnnotTrapNetwork(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Widget":
				return getEntryDictionaryWidget2_0(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidget2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return getEntryDictionaryWidgetDefault2_0(base, keyName);
		}
		switch (subtypeValue) {
			case "Btn":
				return getEntryDictionaryWidgetBtn2_0(base, keyName);
			case "Ch":
				return new GFAAnnotWidgetFieldChoice(base, this.baseObject, keyName);
			case "Sig":
				return new GFAAnnotWidgetFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAAnnotWidgetFieldTx(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getEntryDictionaryWidgetBtn02_0(base, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetBtn02_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAAnnotWidgetFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAAnnotWidgetFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryWidgetDefault2_0(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("AA"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("Ff"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("T"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TM"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("TU"))) {
			return new GFAAnnotWidgetField(base, this.baseObject, keyName);
		}
		return new GFAAnnotWidget(base, this.baseObject, keyName);
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
