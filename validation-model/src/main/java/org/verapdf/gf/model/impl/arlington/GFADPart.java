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

public class GFADPart extends GFAObject implements ADPart {

	public GFADPart(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADPart");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AF":
				return getAF();
			case "DPM":
				return getDPM();
			case "DParts":
				return getDParts();
			case "End":
				return getEnd();
			case "Parent":
				return getParent();
			case "Start":
				return getStart();
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

	private List<ADPM> getDPM() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				if ((gethasExtensionPDF_VT2() == true)) {
					return getDPM1_6();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getDPM1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPM> getDPM1_6() {
		COSObject object = getDPMValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADPM> list = new ArrayList<>(1);
			list.add(new GFADPM((COSDictionary)object.getDirectBase(), this.baseObject, "DPM"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfDPartArrays> getDParts() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				if ((gethasExtensionPDF_VT2() == true)) {
					return getDParts1_6();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getDParts1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfDPartArrays> getDParts1_6() {
		COSObject object = getDPartsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDPartArrays> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDPartArrays((COSArray)object.getDirectBase(), this.baseObject, "DParts"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<APageObject> getEnd() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				if ((gethasExtensionPDF_VT2() == true)) {
					return getEnd1_6();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getEnd1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getEnd1_6() {
		COSObject object = getEndValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "End"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getParent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				if ((gethasExtensionPDF_VT2() == true)) {
					return getParent1_6();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getParent1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_6() {
		COSObject object = getParentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_6(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_6(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "DPart":
				return new GFADPart(base, this.baseObject, keyName);
			case "DPartRoot":
				return new GFADPartRoot(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<APageObject> getStart() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				if ((gethasExtensionPDF_VT2() == true)) {
					return getStart1_6();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getStart1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getStart1_6() {
		COSObject object = getStartValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "Start"));
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
	public Boolean getcontainsDPM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DPM"));
	}

	public COSObject getDPMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DPM"));
		return object;
	}

	@Override
	public String getDPMType() {
		COSObject DPM = getDPMValue();
		return getObjectType(DPM);
	}

	@Override
	public Boolean getDPMHasTypeDictionary() {
		COSObject DPM = getDPMValue();
		return getHasTypeDictionary(DPM);
	}

	@Override
	public Boolean getcontainsDParts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DParts"));
	}

	public COSObject getDPartsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DParts"));
		return object;
	}

	@Override
	public String getDPartsType() {
		COSObject DParts = getDPartsValue();
		return getObjectType(DParts);
	}

	@Override
	public Boolean getDPartsHasTypeArray() {
		COSObject DParts = getDPartsValue();
		return getHasTypeArray(DParts);
	}

	@Override
	public Long getDPartsArraySize() {
		COSObject DParts = getDPartsValue();
		return getArraySize(DParts);
	}

	@Override
	public Boolean getcontainsEnd() {
		return this.baseObject.knownKey(ASAtom.getASAtom("End"));
	}

	public COSObject getEndValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("End"));
		return object;
	}

	@Override
	public Boolean getisEndIndirect() {
		COSObject End = getEndValue();
		return getisIndirect(End);
	}

	@Override
	public String getEndType() {
		COSObject End = getEndValue();
		return getObjectType(End);
	}

	@Override
	public Boolean getEndHasTypeDictionary() {
		COSObject End = getEndValue();
		return getHasTypeDictionary(End);
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
	public String getParentType() {
		COSObject Parent = getParentValue();
		return getObjectType(Parent);
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject Parent = getParentValue();
		return getHasTypeDictionary(Parent);
	}

	@Override
	public Boolean getcontainsStart() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Start"));
	}

	public COSObject getStartValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Start"));
		return object;
	}

	@Override
	public Boolean getisStartIndirect() {
		COSObject Start = getStartValue();
		return getisIndirect(Start);
	}

	@Override
	public String getStartType() {
		COSObject Start = getStartValue();
		return getObjectType(Start);
	}

	@Override
	public Boolean getStartHasTypeDictionary() {
		COSObject Start = getStartValue();
		return getHasTypeDictionary(Start);
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

}
