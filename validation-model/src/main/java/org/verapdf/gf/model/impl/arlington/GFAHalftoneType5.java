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

public class GFAHalftoneType5 extends GFAObject implements AHalftoneType5 {

	public GFAHalftoneType5(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AHalftoneType5");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "Default":
				return getDefault();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AHalftoneType5Entry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AHalftoneType5Entry> getEntries1_2() {
		List<AHalftoneType5Entry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("Default".equals(key.getValue()) || "HalftoneName".equals(key.getValue()) || "HalftoneType".equals(key.getValue()) || "Type".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFAHalftoneType5Entry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<org.verapdf.model.baselayer.Object> getDefault() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getDefault1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDefault1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDefault1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Default"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AHalftoneType1> list = new ArrayList<>(1);
			list.add(new GFAHalftoneType1((COSDictionary)object.getDirectBase(), this.baseObject, "Default"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getDefaultStream1_2(object.getDirectBase(), "Default");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDefaultStream1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("HalftoneType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 6:
				return new GFAHalftoneType6(base, this.baseObject, keyName);
			case 10:
				return new GFAHalftoneType10(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDefault1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Default"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AHalftoneType1> list = new ArrayList<>(1);
			list.add(new GFAHalftoneType1((COSDictionary)object.getDirectBase(), this.baseObject, "Default"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getDefaultStream1_3(object.getDirectBase(), "Default");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDefaultStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("HalftoneType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 16:
				return new GFAHalftoneType16(base, this.baseObject, keyName);
			case 6:
				return new GFAHalftoneType6(base, this.baseObject, keyName);
			case 10:
				return new GFAHalftoneType10(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsDefault() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Default"));
	}

	public COSObject getDefaultValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Default"));
		return object;
	}

	@Override
	public Boolean getisDefaultIndirect() {
		COSObject object = getDefaultValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getDefaultHasTypeDictionary() {
		COSObject object = getDefaultValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getDefaultHasTypeStream() {
		COSObject object = getDefaultValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsHalftoneName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HalftoneName"));
	}

	public COSObject getHalftoneNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HalftoneName"));
		return object;
	}

	@Override
	public Boolean getHalftoneNameHasTypeStringByte() {
		COSObject object = getHalftoneNameValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsHalftoneType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HalftoneType"));
	}

	public COSObject getHalftoneTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HalftoneType"));
		return object;
	}

	@Override
	public Boolean getHalftoneTypeHasTypeInteger() {
		COSObject object = getHalftoneTypeValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getHalftoneTypeIntegerValue() {
		COSObject object = getHalftoneTypeValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
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

}
