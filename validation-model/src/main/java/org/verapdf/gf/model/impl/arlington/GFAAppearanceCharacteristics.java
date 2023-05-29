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

public class GFAAppearanceCharacteristics extends GFAObject implements AAppearanceCharacteristics {

	public GFAAppearanceCharacteristics(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAppearanceCharacteristics");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BC":
				return getBC();
			case "BG":
				return getBG();
			case "I":
				return getI();
			case "IF":
				return getIF();
			case "IX":
				return getIX();
			case "RI":
				return getRI();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getBC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBC1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getBC1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BC"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "BC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getBG() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBG1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getBG1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "BG"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getI1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getI1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("I"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getIStream1_2(object.getDirectBase(), "I");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getIStream1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Form":
				return new GFAXObjectFormType1(base, this.baseObject, keyName);
			case "Image":
				return new GFAXObjectImage(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AIconFit> getIF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIF1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AIconFit> getIF1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IF"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AIconFit> list = new ArrayList<>(1);
			list.add(new GFAIconFit((COSDictionary)object.getDirectBase(), this.baseObject, "IF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getIX() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIX1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getIX1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IX"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getIXStream1_2(object.getDirectBase(), "IX");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getIXStream1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Form":
				return new GFAXObjectFormType1(base, this.baseObject, keyName);
			case "Image":
				return new GFAXObjectImage(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getRI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRI1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getRI1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RI"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getRIStream1_2(object.getDirectBase(), "RI");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getRIStream1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Form":
				return new GFAXObjectFormType1(base, this.baseObject, keyName);
			case "Image":
				return new GFAXObjectImage(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsAC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AC"));
	}

	public COSObject getACValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AC"));
		return object;
	}

	@Override
	public Boolean getACHasTypeStringText() {
		COSObject object = getACValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsBC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BC"));
	}

	public COSObject getBCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BC"));
		return object;
	}

	@Override
	public Boolean getBCHasTypeArray() {
		COSObject object = getBCValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsBG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BG"));
	}

	public COSObject getBGValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		return object;
	}

	@Override
	public Boolean getBGHasTypeArray() {
		COSObject object = getBGValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CA"));
	}

	public COSObject getCAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CA"));
		return object;
	}

	@Override
	public Boolean getCAHasTypeStringText() {
		COSObject object = getCAValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("I"));
	}

	public COSObject getIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("I"));
		return object;
	}

	@Override
	public Boolean getisIIndirect() {
		COSObject object = getIValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getIHasTypeStream() {
		COSObject object = getIValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsIF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IF"));
	}

	public COSObject getIFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IF"));
		return object;
	}

	@Override
	public Boolean getIFHasTypeDictionary() {
		COSObject object = getIFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsIX() {
		return this.baseObject.knownKey(ASAtom.getASAtom("IX"));
	}

	public COSObject getIXValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("IX"));
		return object;
	}

	@Override
	public Boolean getisIXIndirect() {
		COSObject object = getIXValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getIXHasTypeStream() {
		COSObject object = getIXValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
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

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object == null || object.empty()) {
			object = getRDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject object = getRValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
	public Boolean getRCHasTypeStringText() {
		COSObject object = getRCValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RI"));
	}

	public COSObject getRIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RI"));
		return object;
	}

	@Override
	public Boolean getisRIIndirect() {
		COSObject object = getRIValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getRIHasTypeStream() {
		COSObject object = getRIValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsTP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TP"));
	}

	public COSObject getTPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
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

	public COSObject getTPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TP"));
		if (object == null || object.empty()) {
			object = getTPDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getTPHasTypeInteger() {
		COSObject object = getTPValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getTPIntegerValue() {
		COSObject object = getTPValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

}
