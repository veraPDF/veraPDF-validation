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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getExtGStateValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getShadingValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getShadingDictionary1_3(object.getDirectBase(), "Shading");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getShadingStream1_3(object.getDirectBase(), "Shading");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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

	@Override
	public Boolean getcontainsExtGState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExtGState"));
	}

	public COSObject getExtGStateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtGState"));
		return object;
	}

	@Override
	public Boolean getExtGStateHasTypeDictionary() {
		COSObject object = getExtGStateValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Matrix"));
	}

	public COSObject getMatrixDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSArray.construct(6, new double[]{1,0,0,1,0,0});
		}
		return null;
	}

	public COSObject getMatrixValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Matrix"));
		if (object == null || object.empty()) {
			object = getMatrixDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getMatrixHasTypeMatrix() {
		COSObject object = getMatrixValue();
		return getHasTypeMatrix(object);
	}

	@Override
	public Boolean getcontainsPatternType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PatternType"));
	}

	public COSObject getPatternTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PatternType"));
		return object;
	}

	@Override
	public Boolean getPatternTypeHasTypeInteger() {
		COSObject object = getPatternTypeValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getPatternTypeIntegerValue() {
		COSObject object = getPatternTypeValue();
		return getIntegerValue(object);
	}

	@Override
	public Boolean getcontainsShading() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Shading"));
	}

	public COSObject getShadingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Shading"));
		return object;
	}

	@Override
	public Boolean getisShadingIndirect() {
		COSObject object = getShadingValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getShadingHasTypeDictionary() {
		COSObject object = getShadingValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getShadingHasTypeStream() {
		COSObject object = getShadingValue();
		return getHasTypeStream(object);
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
		return getNameValue(object);
	}

}
