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

public class GFASeparationColorSpace extends GFAObject implements ASeparationColorSpace {

	public GFASeparationColorSpace(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASeparationColorSpace");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry2":
				return getentry2();
			case "entry3":
				return getentry3();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry2() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getentry21_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry21_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry21_2() {
		if (this.baseObject.size() < 2) {
			return Collections.emptyList();
		}
		COSObject object = this.baseObject.at(2);
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getentry2Array1_2(object.getDirectBase(), "2");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getentry2Array1_2(COSBase base, String keyName) {
		if (base.size() <= 0) {
			return null;
		}
		COSObject subtype = base.at(0);
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			case "Lab":
				return new GFALabColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry21_3() {
		if (this.baseObject.size() < 2) {
			return Collections.emptyList();
		}
		COSObject object = this.baseObject.at(2);
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getentry2Array1_3(object.getDirectBase(), "2");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getentry2Array1_3(COSBase base, String keyName) {
		if (base.size() <= 0) {
			return null;
		}
		COSObject subtype = base.at(0);
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "ICCBased":
				return new GFAICCBasedColorSpace(base, this.baseObject, keyName);
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			case "Lab":
				return new GFALabColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry3() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getentry31_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry31_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry31_2() {
		if (this.baseObject.size() < 3) {
			return Collections.emptyList();
		}
		COSObject object = this.baseObject.at(3);
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFunctionType0> list = new ArrayList<>(1);
			list.add(new GFAFunctionType0((COSStream)object.getDirectBase(), this.baseObject, "3"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getentry31_3() {
		if (this.baseObject.size() < 3) {
			return Collections.emptyList();
		}
		COSObject object = this.baseObject.at(3);
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getentry3Dictionary1_3(object.getDirectBase(), "3");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getentry3Stream1_3(object.getDirectBase(), "3");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getentry3Dictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getentry3Stream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeName() {
		COSObject object = getentry0Value();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getentry0NameValue() {
		COSObject object = getentry0Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeName() {
		COSObject object = getentry1Value();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeArray() {
		COSObject object = getentry2Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getentry2HasTypeName() {
		COSObject object = getentry2Value();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getentry2NameValue() {
		COSObject object = getentry2Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getisentry3Indirect() {
		COSObject object = getentry3Value();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getentry3HasTypeDictionary() {
		COSObject object = getentry3Value();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getentry3HasTypeStream() {
		COSObject object = getentry3Value();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
