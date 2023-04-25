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

public class GFAPatternType2 extends GFAObject implements APatternType2 {

	public GFAPatternType2(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APatternType2");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ExtGState":
				return getExtGState();
			case "Shading":
				return getShading();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AGraphicsStateParameter> getExtGState() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getExtGState1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AGraphicsStateParameter> getExtGState1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtGState"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AGraphicsStateParameter> list = new ArrayList<>(1);
			list.add(new GFAGraphicsStateParameter((COSDictionary)object.getDirectBase(), this.baseObject, "ExtGState"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getShading() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getShading1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getShading1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Shading"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getShadingStream1_3(object.getDirectBase(), "Shading");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getShadingDictionary1_3(object.getDirectBase(), "Shading");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getShadingStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("ShadingType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 4:
				return new GFAShadingType4(base, this.baseObject, keyName);
			case 5:
				return new GFAShadingType5(base, this.baseObject, keyName);
			case 6:
				return new GFAShadingType6(base, this.baseObject, keyName);
			case 7:
				return new GFAShadingType7(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getShadingDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("ShadingType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 1:
				return new GFAShadingType1(base, this.baseObject, keyName);
			case 2:
				return new GFAShadingType2(base, this.baseObject, keyName);
			case 3:
				return new GFAShadingType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsExtGState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExtGState"));
	}

	@Override
	public Boolean getExtGStateHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtGState"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Matrix"));
	}

	@Override
	public Boolean getMatrixHasTypeMatrix() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Matrix"));
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 6) {
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
	public Boolean getcontainsPatternType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PatternType"));
	}

	@Override
	public Boolean getPatternTypeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PatternType"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPatternTypeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PatternType"));
		if (object == null || object.empty()) {
			return getPatternTypeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getPatternTypeIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsShading() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Shading"));
	}

	@Override
	public Boolean getisShadingIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Shading"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getShadingHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Shading"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getShadingHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Shading"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
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
