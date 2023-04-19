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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBounds1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getBounds1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Bounds"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDCS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDCS1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DCS"));
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
			case "PROJCS":
				return new GFAProjectedCoordinateSystem(base, this.baseObject, keyName);
			case "GEOGCS":
				return new GFAGeographicCoordinateSystem(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getGCS() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGCS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getGCS1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GCS"));
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
			case "PROJCS":
				return new GFAProjectedCoordinateSystem(base, this.baseObject, keyName);
			case "GEOGCS":
				return new GFAGeographicCoordinateSystem(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfNumbersGeneral> getGPTS() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGPTS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getGPTS1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GPTS"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLPTS1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getLPTS1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LPTS"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getPCSM2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DTransMatrix> getPCSM2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PCSM"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPDU1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3PDUNames> getPDU1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PDU"));
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

	@Override
	public Boolean getBoundsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Bounds"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsDCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DCS"));
	}

	@Override
	public Boolean getDCSHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DCS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsGCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GCS"));
	}

	@Override
	public Boolean getGCSHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GCS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsGPTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GPTS"));
	}

	@Override
	public Boolean getGPTSHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GPTS"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsLPTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LPTS"));
	}

	@Override
	public Boolean getLPTSHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LPTS"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPCSM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PCSM"));
	}

	@Override
	public Boolean getPCSMHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PCSM"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPDU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PDU"));
	}

	@Override
	public Boolean getPDUHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PDU"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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

}
