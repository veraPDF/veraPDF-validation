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
			case "Metadata":
				return getMetadata();
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

	private List<AMetadata> getMetadata() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getMetadata2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMetadata> getMetadata2_0() {
		COSObject object = getMetadataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AMetadata> list = new ArrayList<>(1);
			list.add(new GFAMetadata((COSStream)object.getDirectBase(), this.baseObject, "Metadata"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getParent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
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
	public Boolean getAFHasTypeArray() {
		COSObject object = getAFValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getDPMHasTypeDictionary() {
		COSObject object = getDPMValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getDPartsHasTypeArray() {
		COSObject object = getDPartsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getDPartsArraySize() {
		COSObject object = getDPartsValue();
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
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
		COSObject object = getEndValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getEndHasTypeDictionary() {
		COSObject object = getEndValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsMetadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Metadata"));
	}

	public COSObject getMetadataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
		return object;
	}

	@Override
	public Boolean getisMetadataIndirect() {
		COSObject object = getMetadataValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getMetadataHasTypeStream() {
		COSObject object = getMetadataValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
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
		COSObject object = getParentValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject object = getParentValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		COSObject object = getStartValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getStartHasTypeDictionary() {
		COSObject object = getStartValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean gethasExtensionPDF_VT2() {
		return false;
	}

}
