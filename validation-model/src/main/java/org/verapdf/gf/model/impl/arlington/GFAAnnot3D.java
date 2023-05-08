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

public class GFAAnnot3D extends GFAObject implements AAnnot3D {

	public GFAAnnot3D(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAnnot3D");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry3DA":
				return getentry3DA();
			case "entry3DD":
				return getentry3DD();
			case "entry3DU":
				return getentry3DU();
			case "entry3DV":
				return getentry3DV();
			case "AF":
				return getAF();
			case "AP":
				return getAP();
			case "Border":
				return getBorder();
			case "C":
				return getC();
			case "GEO":
				return getGEO();
			case "OC":
				return getOC();
			case "P":
				return getP();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<A3DActivation> getentry3DA() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DA1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DActivation> getentry3DA1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DA"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DActivation> list = new ArrayList<>(1);
			list.add(new GFA3DActivation((COSDictionary)object.getDirectBase(), this.baseObject, "3DA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getentry3DD() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DD1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry3DD1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DD"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DReference> list = new ArrayList<>(1);
			list.add(new GFA3DReference((COSDictionary)object.getDirectBase(), this.baseObject, "3DD"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<A3DStream> list = new ArrayList<>(1);
			list.add(new GFA3DStream((COSStream)object.getDirectBase(), this.baseObject, "3DD"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A3DUnits> getentry3DU() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DU1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DUnits> getentry3DU1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DU"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DUnits> list = new ArrayList<>(1);
			list.add(new GFA3DUnits((COSDictionary)object.getDirectBase(), this.baseObject, "3DU"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A3DView> getentry3DV() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DV1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DView> getentry3DV1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DView> list = new ArrayList<>(1);
			list.add(new GFA3DView((COSDictionary)object.getDirectBase(), this.baseObject, "3DV"));
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

	private List<AAppearance> getAP() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAppearance> getAP1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBorder1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Border"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4NumbersColorAnnotation> getC1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
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

	private List<AMeasureGEO> getGEO() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getGEO2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMeasureGEO> getGEO2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GEO"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMeasureGEO> list = new ArrayList<>(1);
			list.add(new GFAMeasureGEO((COSDictionary)object.getDirectBase(), this.baseObject, "GEO"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getOC() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOC1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOC1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OC"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOCDictionary1_6(object.getDirectBase(), "OC");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOCDictionary1_6(COSBase base, String keyName) {
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getP1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
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

	@Override
	public Boolean getcontains3DA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DA"));
	}

	@Override
	public Boolean getentry3DAHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DA"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontains3DB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DB"));
	}

	@Override
	public Boolean getentry3DBHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DB"));
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
	public Boolean getcontains3DD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DD"));
	}

	@Override
	public Boolean getisentry3DDIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DD"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getentry3DDHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DD"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getentry3DDHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DD"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontains3DI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DI"));
	}

	@Override
	public Boolean getentry3DIHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DI"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontains3DU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DU"));
	}

	@Override
	public Boolean getentry3DUHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DU"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontains3DV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DV"));
	}

	@Override
	public Boolean getentry3DVHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getentry3DVHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getentry3DVHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry3DVHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getcontainsAP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AP"));
	}

	@Override
	public Boolean getAPHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsAS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AS"));
	}

	@Override
	public Boolean getASHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AS"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsBM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BM"));
	}

	@Override
	public Boolean getBMHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBMNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		if (object == null || object.empty()) {
			return getBMNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getBMNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return "Normal";
		}
		return null;
	}

	@Override
	public Boolean getcontainsBorder() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Border"));
	}

	@Override
	public Boolean getBorderHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Border"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C"));
	}

	@Override
	public Boolean getCHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CA"));
	}

	@Override
	public Boolean getCAHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CA"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getCANumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CA"));
		if (object == null || object.empty()) {
			return getCANumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getCANumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return 1.0D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsContents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Contents"));
	}

	@Override
	public Boolean getContentsHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getFHasTypeBitmask() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFBitmaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null || object.empty()) {
			return getFBitmaskDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getFBitmaskDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsGEO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GEO"));
	}

	@Override
	public Boolean getGEOHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GEO"));
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
	public Boolean getcontainsM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M"));
	}

	@Override
	public Boolean getMHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getMHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsNM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NM"));
	}

	@Override
	public Boolean getNMHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NM"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsOC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OC"));
	}

	@Override
	public Boolean getOCHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OC"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	@Override
	public Boolean getisPIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsRect() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rect"));
	}

	@Override
	public Boolean getRectHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rect"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rect"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return null;
		}
		COSObject bottom = this.baseObject.at(1);
		COSObject top = this.baseObject.at(3);
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rect"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return null;
		}
		COSObject left = this.baseObject.at(0);
		COSObject right = this.baseObject.at(2);
		if (left == null || (left.getType() != COSObjType.COS_INTEGER && left.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		if (right == null || (right.getType() != COSObjType.COS_INTEGER && right.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		return right.getReal() - left.getReal();
	}

	@Override
	public Boolean getcontainsStructParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructParent"));
	}

	@Override
	public Boolean getStructParentHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructParent"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			return getSubtypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSubtypeNameDefaultValue() {
		return null;
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
	public Boolean getcontainsca() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ca"));
	}

	@Override
	public Boolean getcaHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ca"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getcaNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ca"));
		if (object == null || object.empty()) {
			return getcaNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getcaNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return 1.0D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsAPNAny() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject N = AP.getKey(ASAtom.getASAtom("N"));
		return N.getKeySet() != null && !N.getKeySet().isEmpty();
	}

	@Override
	public Boolean getcontainsAPRAny() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject R = AP.getKey(ASAtom.getASAtom("R"));
		return R.getKeySet() != null && !R.getKeySet().isEmpty();
	}

	@Override
	public Boolean getcontainsAPDAny() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject D = AP.getKey(ASAtom.getASAtom("D"));
		return D.getKeySet() != null && !D.getKeySet().isEmpty();
	}

}
