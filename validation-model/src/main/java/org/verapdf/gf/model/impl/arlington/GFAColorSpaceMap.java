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

public class GFAColorSpaceMap extends GFAObject implements AColorSpaceMap {

	public GFAColorSpaceMap(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AColorSpaceMap");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "DefaultCMYK":
				return getDefaultCMYK();
			case "DefaultGray":
				return getDefaultGray();
			case "DefaultRGB":
				return getDefaultRGB();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AColorSpaceMapEntry> getEntries() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
				return getEntries1_0();
			case ARLINGTON1_1:
			case ARLINGTON1_2:
				return getEntries1_1();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AColorSpaceMapEntry> getEntries1_0() {
		List<AColorSpaceMapEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFAColorSpaceMapEntry(object != null ? object.get() : null, this.baseObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<AColorSpaceMapEntry> getEntries1_1() {
		List<AColorSpaceMapEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("DefaultGray".equals(key.getValue()) || "DefaultRGB".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFAColorSpaceMapEntry(object != null ? object.get() : null, this.baseObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<AColorSpaceMapEntry> getEntries1_3() {
		List<AColorSpaceMapEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("DefaultCMYK".equals(key.getValue()) || "DefaultGray".equals(key.getValue()) || "DefaultRGB".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFAColorSpaceMapEntry(object != null ? object.get() : null, this.baseObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultCMYK() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDefaultCMYK1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultCMYK1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultCMYK"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getDefaultCMYKArray1_3(object.getDirectBase(), "DefaultCMYK");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDefaultCMYKArray1_3(COSBase base, String keyName) {
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
			case "DeviceN":
				return new GFADeviceNColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultGray() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
				return getDefaultGray1_1();
			case ARLINGTON1_2:
				return getDefaultGray1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDefaultGray1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultGray1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultGray"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ACalGrayColorSpace> list = new ArrayList<>(1);
			list.add(new GFACalGrayColorSpace((COSArray)object.getDirectBase(), this.baseObject, "DefaultGray"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultGray1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultGray"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getDefaultGrayArray1_2(object.getDirectBase(), "DefaultGray");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDefaultGrayArray1_2(COSBase base, String keyName) {
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
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultGray1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultGray"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getDefaultGrayArray1_3(object.getDirectBase(), "DefaultGray");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDefaultGrayArray1_3(COSBase base, String keyName) {
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
			case "Separation":
				return new GFASeparationColorSpace(base, this.baseObject, keyName);
			case "DeviceN":
				return new GFADeviceNColorSpace(base, this.baseObject, keyName);
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultRGB() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
				return getDefaultRGB1_1();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDefaultRGB1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultRGB1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultRGB"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ACalRGBColorSpace> list = new ArrayList<>(1);
			list.add(new GFACalRGBColorSpace((COSArray)object.getDirectBase(), this.baseObject, "DefaultRGB"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDefaultRGB1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultRGB"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getDefaultRGBArray1_3(object.getDirectBase(), "DefaultRGB");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDefaultRGBArray1_3(COSBase base, String keyName) {
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
			case "DeviceN":
				return new GFADeviceNColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsDefaultCMYK() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DefaultCMYK"));
	}

	@Override
	public Boolean getDefaultCMYKHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultCMYK"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsDefaultGray() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DefaultGray"));
	}

	@Override
	public Boolean getDefaultGrayHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultGray"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsDefaultRGB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DefaultRGB"));
	}

	@Override
	public Boolean getDefaultRGBHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultRGB"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
