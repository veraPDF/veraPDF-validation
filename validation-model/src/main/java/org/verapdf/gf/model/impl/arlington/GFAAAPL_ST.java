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

public class GFAAAPL_ST extends GFAObject implements AAAPL_ST {

	public GFAAAPL_ST(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAAPL_ST");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Color":
				return getColor();
			case "ColorSpace":
				return getColorSpace();
			case "Offset":
				return getOffset();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getColor() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColor1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getColor1_2() {
		COSObject object = getColorValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Color"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getColorSpace1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getColorSpace1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace1_2() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getColorSpaceArray1_2(object.getDirectBase(), "ColorSpace");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getColorSpaceArray1_2(COSBase base, String keyName) {
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
			case "Indexed":
				return new GFAIndexedColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace1_3() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getColorSpaceArray1_3(object.getDirectBase(), "ColorSpace");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getColorSpaceArray1_3(COSBase base, String keyName) {
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
			case "Indexed":
				return new GFAIndexedColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOf_2Numbers> getOffset() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOffset1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getOffset1_2() {
		COSObject object = getOffsetValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "Offset"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsColor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Color"));
	}

	public COSObject getColorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Color"));
		return object;
	}

	@Override
	public Boolean getColorHasTypeArray() {
		COSObject object = getColorValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsColorSpace() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorSpace"));
	}

	public COSObject getColorSpaceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorSpace"));
		return object;
	}

	@Override
	public Boolean getColorSpaceHasTypeArray() {
		COSObject object = getColorSpaceValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getColorSpaceHasTypeName() {
		COSObject object = getColorSpaceValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getColorSpaceNameValue() {
		COSObject object = getColorSpaceValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsOffset() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Offset"));
	}

	public COSObject getOffsetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Offset"));
		return object;
	}

	@Override
	public Boolean getOffsetHasTypeArray() {
		COSObject object = getOffsetValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsRadius() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Radius"));
	}

	public COSObject getRadiusValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Radius"));
		return object;
	}

	@Override
	public Boolean getRadiusHasTypeNumber() {
		COSObject object = getRadiusValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getRadiusNumberValue() {
		COSObject object = getRadiusValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean gethasExtensionAAPL() {
		return false;
	}

}
