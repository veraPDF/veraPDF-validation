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

public class GFASeparation extends GFAObject implements ASeparation {

	public GFASeparation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASeparation");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ColorSpace":
				return getColorSpace();
			case "Pages":
				return getPages();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getColorSpace() {
		switch (StaticContainers.getFlavour()) {
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
			case "Separation":
				return new GFASeparationColorSpace(base, this.baseObject, keyName);
			case "DeviceN":
				return new GFADeviceNColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfPages> getPages() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPages1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfPages> getPages1_3() {
		COSObject object = getPagesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfPages> list = new ArrayList<>(1);
			list.add(new GFAArrayOfPages((COSArray)object.getDirectBase(), this.baseObject, "Pages"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public Boolean getcontainsDeviceColorant() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DeviceColorant"));
	}

	public COSObject getDeviceColorantValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DeviceColorant"));
		return object;
	}

	@Override
	public Boolean getDeviceColorantHasTypeName() {
		COSObject object = getDeviceColorantValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getDeviceColorantHasTypeString() {
		COSObject object = getDeviceColorantValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsPages() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pages"));
	}

	public COSObject getPagesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pages"));
		return object;
	}

	@Override
	public Boolean getPagesHasTypeArray() {
		COSObject object = getPagesValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
