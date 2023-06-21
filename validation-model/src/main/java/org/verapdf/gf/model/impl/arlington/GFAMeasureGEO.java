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

public class GFAMeasureGEO extends GFAObject implements AMeasureGEO {

	public GFAMeasureGEO(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMeasureGEO");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Bounds":
				return getBounds();
			case "DCS":
				return getDCS();
			case "GCS":
				return getGCS();
			case "GPTS":
				return getGPTS();
			case "LPTS":
				return getLPTS();
			case "PCSM":
				return getPCSM();
			case "PDU":
				return getPDU();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getBounds() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBounds1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getBounds1_7() {
		COSObject object = getBoundsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Bounds"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDCS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDCS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDCS1_7() {
		COSObject object = getDCSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDCSDictionary1_7(object.getDirectBase(), "DCS");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDCSDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "GEOGCS":
				return new GFAGeographicCoordinateSystem(base, this.baseObject, keyName);
			case "PROJCS":
				return new GFAProjectedCoordinateSystem(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getGCS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGCS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getGCS1_7() {
		COSObject object = getGCSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getGCSDictionary1_7(object.getDirectBase(), "GCS");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getGCSDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "GEOGCS":
				return new GFAGeographicCoordinateSystem(base, this.baseObject, keyName);
			case "PROJCS":
				return new GFAProjectedCoordinateSystem(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfNumbersGeneral> getGPTS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGPTS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getGPTS1_7() {
		COSObject object = getGPTSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "GPTS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getLPTS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLPTS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getLPTS1_7() {
		COSObject object = getLPTSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "LPTS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DTransMatrix> getPCSM() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getPCSM2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DTransMatrix> getPCSM2_0() {
		COSObject object = getPCSMValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DTransMatrix> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DTransMatrix((COSArray)object.getDirectBase(), this.baseObject, "PCSM"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3PDUNames> getPDU() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPDU1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3PDUNames> getPDU1_7() {
		COSObject object = getPDUValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3PDUNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3PDUNames((COSArray)object.getDirectBase(), this.baseObject, "PDU"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBounds() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Bounds"));
	}

	public COSObject getBoundsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Bounds"));
		return object;
	}

	@Override
	public Boolean getBoundsHasTypeArray() {
		COSObject object = getBoundsValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsDCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DCS"));
	}

	public COSObject getDCSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DCS"));
		return object;
	}

	@Override
	public Boolean getDCSHasTypeDictionary() {
		COSObject object = getDCSValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsGCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GCS"));
	}

	public COSObject getGCSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GCS"));
		return object;
	}

	@Override
	public Boolean getGCSHasTypeDictionary() {
		COSObject object = getGCSValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsGPTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GPTS"));
	}

	public COSObject getGPTSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GPTS"));
		return object;
	}

	@Override
	public Boolean getGPTSHasTypeArray() {
		COSObject object = getGPTSValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsLPTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LPTS"));
	}

	public COSObject getLPTSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LPTS"));
		return object;
	}

	@Override
	public Boolean getLPTSHasTypeArray() {
		COSObject object = getLPTSValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsPCSM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PCSM"));
	}

	public COSObject getPCSMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PCSM"));
		return object;
	}

	@Override
	public Boolean getPCSMHasTypeArray() {
		COSObject object = getPCSMValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsPDU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PDU"));
	}

	public COSObject getPDUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PDU"));
		return object;
	}

	@Override
	public Boolean getPDUHasTypeArray() {
		COSObject object = getPDUValue();
		return getHasTypeArray(object);
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
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
