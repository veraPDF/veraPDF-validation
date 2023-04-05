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

public class GFAAuthCode extends GFAObject implements AAuthCode {

	public GFAAuthCode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAuthCode");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ByteRange":
				return getByteRange();
			case "SigObjRef":
				return getSigObjRef();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_4Integers> getByteRange() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getByteRange2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4Integers> getByteRange2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4Integers((COSArray)object.getDirectBase(), this.baseObject, "ByteRange"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getSigObjRef() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSigObjRef2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSigObjRef2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigObjRef"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getSigObjRefDictionary2_0(object.getDirectBase(), "SigObjRef");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getSigObjRefDictionary2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Sig":
				return new GFASignature(base, this.baseObject, keyName);
			case "DocTimeStamp":
				return new GFADocTimeStamp(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsSigObjRef() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SigObjRef"));
	}

	@Override
	public Boolean getisSigObjRefIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigObjRef"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSigObjRefHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigObjRef"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsByteRange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ByteRange"));
	}

	@Override
	public Boolean getisByteRangeIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getByteRangeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsMAC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MAC"));
	}

	@Override
	public Boolean getisMACIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MAC"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getMACHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MAC"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsMACLocation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MACLocation"));
	}

	@Override
	public Boolean getisMACLocationIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MACLocation"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getMACLocationHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MACLocation"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getMACLocationNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MACLocation"));
		if (object == null || object.empty()) {
			return getMACLocationNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getMACLocationNameDefaultValue() {
		return null;
	}

	@Override
	public Long getByteRange1IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject ByteRange = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 1) {
			return null;
		}
		COSObject entry1 = ByteRange.at(1);
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry1IntegerValue();
	}
	@Override
	public Long getByteRange2IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject ByteRange = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 2) {
			return null;
		}
		COSObject entry2 = ByteRange.at(2);
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry2IntegerValue();
	}
	@Override
	public Long getByteRange0IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject ByteRange = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 0) {
			return null;
		}
		COSObject entry0 = ByteRange.at(0);
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry0IntegerValue();
	}
	@Override
	public Long getByteRange3IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject ByteRange = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 3) {
			return null;
		}
		COSObject entry3 = ByteRange.at(3);
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry3IntegerValue();
	}
}
