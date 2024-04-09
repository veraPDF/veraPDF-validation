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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DA1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DActivation> getentry3DA1_6() {
		COSObject object = getentry3DAValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DD1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry3DD1_6() {
		COSObject object = getentry3DDValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DU1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DUnits> getentry3DU1_7() {
		COSObject object = getentry3DUValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DV1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DView> getentry3DV1_6() {
		COSObject object = getentry3DVValue();
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
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAppearance> getAP1_6() {
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
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBorder1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder1_6() {
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
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4NumbersColorAnnotation> getC1_6() {
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

	private List<AMeasureGEO> getGEO() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getGEO2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMeasureGEO> getGEO2_0() {
		COSObject object = getGEOValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOC1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOC1_6() {
		COSObject object = getOCValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getP1_6() {
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

	@Override
	public Boolean getcontains3DA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DA"));
	}

	public COSObject getentry3DAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DA"));
		return object;
	}

	@Override
	public String getentry3DAType() {
		COSObject entry3DA = getentry3DAValue();
		return getObjectType(entry3DA);
	}

	@Override
	public Boolean getentry3DAHasTypeDictionary() {
		COSObject entry3DA = getentry3DAValue();
		return getHasTypeDictionary(entry3DA);
	}

	@Override
	public Boolean getcontains3DB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DB"));
	}

	public COSObject getentry3DBValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DB"));
		return object;
	}

	@Override
	public String getentry3DBType() {
		COSObject entry3DB = getentry3DBValue();
		return getObjectType(entry3DB);
	}

	@Override
	public Boolean getentry3DBHasTypeRectangle() {
		COSObject entry3DB = getentry3DBValue();
		return getHasTypeRectangle(entry3DB);
	}

	@Override
	public Boolean getcontains3DD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DD"));
	}

	public COSObject getentry3DDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DD"));
		return object;
	}

	@Override
	public Boolean getisentry3DDIndirect() {
		COSObject entry3DD = getentry3DDValue();
		return getisIndirect(entry3DD);
	}

	@Override
	public String getentry3DDType() {
		COSObject entry3DD = getentry3DDValue();
		return getObjectType(entry3DD);
	}

	@Override
	public Boolean getentry3DDHasTypeDictionary() {
		COSObject entry3DD = getentry3DDValue();
		return getHasTypeDictionary(entry3DD);
	}

	@Override
	public Boolean getentry3DDHasTypeStream() {
		COSObject entry3DD = getentry3DDValue();
		return getHasTypeStream(entry3DD);
	}

	@Override
	public Boolean getcontains3DI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DI"));
	}

	public COSObject getentry3DIDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getentry3DIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DI"));
		if (object == null || object.empty()) {
			object = getentry3DIDefaultValue();
		}
		return object;
	}

	@Override
	public String getentry3DIType() {
		COSObject entry3DI = getentry3DIValue();
		return getObjectType(entry3DI);
	}

	@Override
	public Boolean getentry3DIHasTypeBoolean() {
		COSObject entry3DI = getentry3DIValue();
		return getHasTypeBoolean(entry3DI);
	}

	@Override
	public Boolean getcontains3DU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DU"));
	}

	public COSObject getentry3DUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DU"));
		return object;
	}

	@Override
	public String getentry3DUType() {
		COSObject entry3DU = getentry3DUValue();
		return getObjectType(entry3DU);
	}

	@Override
	public Boolean getentry3DUHasTypeDictionary() {
		COSObject entry3DU = getentry3DUValue();
		return getHasTypeDictionary(entry3DU);
	}

	@Override
	public Boolean getcontains3DV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DV"));
	}

	public COSObject getentry3DVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DV"));
		return object;
	}

	@Override
	public String getentry3DVType() {
		COSObject entry3DV = getentry3DVValue();
		return getObjectType(entry3DV);
	}

	@Override
	public Boolean getentry3DVHasTypeDictionary() {
		COSObject entry3DV = getentry3DVValue();
		return getHasTypeDictionary(entry3DV);
	}

	@Override
	public Boolean getentry3DVHasTypeInteger() {
		COSObject entry3DV = getentry3DVValue();
		return getHasTypeInteger(entry3DV);
	}

	@Override
	public Boolean getentry3DVHasTypeName() {
		COSObject entry3DV = getentry3DVValue();
		return getHasTypeName(entry3DV);
	}

	@Override
	public Boolean getentry3DVHasTypeString() {
		COSObject entry3DV = getentry3DVValue();
		return getHasTypeString(entry3DV);
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
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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
	public Boolean getcontainsGEO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GEO"));
	}

	public COSObject getGEOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GEO"));
		return object;
	}

	@Override
	public String getGEOType() {
		COSObject GEO = getGEOValue();
		return getObjectType(GEO);
	}

	@Override
	public Boolean getGEOHasTypeDictionary() {
		COSObject GEO = getGEOValue();
		return getHasTypeDictionary(GEO);
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

}
