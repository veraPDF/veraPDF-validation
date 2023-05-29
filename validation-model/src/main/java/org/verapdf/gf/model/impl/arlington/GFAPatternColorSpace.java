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

public class GFAPatternColorSpace extends GFAObject implements APatternColorSpace {

	public GFAPatternColorSpace(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APatternColorSpace");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry1":
				return getentry1();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry1() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getentry11_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry11_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry11_2() {
		if (this.baseObject.size() < 1) {
			return Collections.emptyList();
		}
		COSObject object = this.baseObject.at(1);
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getentry1Array1_2(object.getDirectBase(), "1");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getentry1Array1_2(COSBase base, String keyName) {
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
			case "Separation":
				return new GFASeparationColorSpace(base, this.baseObject, keyName);
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

	private List<org.verapdf.model.baselayer.Object> getentry11_3() {
		if (this.baseObject.size() < 1) {
			return Collections.emptyList();
		}
		COSObject object = this.baseObject.at(1);
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getentry1Array1_3(object.getDirectBase(), "1");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getentry1Array1_3(COSBase base, String keyName) {
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
			case "Separation":
				return new GFASeparationColorSpace(base, this.baseObject, keyName);
			case "DeviceN":
				return new GFADeviceNColorSpace(base, this.baseObject, keyName);
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
	public Boolean getentry1HasTypeArray() {
		COSObject object = getentry1Value();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getentry1HasTypeName() {
		COSObject object = getentry1Value();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getentry1NameValue() {
		COSObject object = getentry1Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
