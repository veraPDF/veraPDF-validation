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

public class GFAViewport extends GFAObject implements AViewport {

	public GFAViewport(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AViewport");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Measure":
				return getMeasure();
			case "PtData":
				return getPtData();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getMeasure() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				return getMeasure1_6();
			case ARLINGTON2_0:
				return getMeasure2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getMeasure1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Measure"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMeasureRL> list = new ArrayList<>(1);
			list.add(new GFAMeasureRL((COSDictionary)object.getDirectBase(), this.baseObject, "Measure"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getMeasure2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Measure"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getMeasureDictionary2_0(object.getDirectBase(), "Measure");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getMeasureDictionary2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "GEO":
				return new GFAMeasureGEO(base, this.baseObject, keyName);
			case "RL":
				return new GFAMeasureRL(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<APointData> getPtData() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getPtData2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<APointData> getPtData2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PtData"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APointData> list = new ArrayList<>(1);
			list.add(new GFAPointData((COSDictionary)object.getDirectBase(), this.baseObject, "PtData"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BBox"));
	}

	@Override
	public Boolean getBBoxHasTypeRectangle() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BBox"));
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
	public Boolean getcontainsMeasure() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Measure"));
	}

	@Override
	public Boolean getMeasureHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Measure"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsPtData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PtData"));
	}

	@Override
	public Boolean getPtDataHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PtData"));
		return object != null && object.getType() == COSObjType.COS_DICT;
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
