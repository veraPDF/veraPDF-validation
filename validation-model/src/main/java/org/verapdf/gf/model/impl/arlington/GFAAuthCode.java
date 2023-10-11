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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getByteRange2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4Integers> getByteRange2_0() {
		COSObject object = getByteRangeValue();
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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSigObjRef2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSigObjRef2_0() {
		COSObject object = getSigObjRefValue();
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
			case "DocTimeStamp":
				return new GFADocTimeStamp(base, this.baseObject, keyName);
			case "Sig":
				return new GFASignature(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsByteRange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ByteRange"));
	}

	public COSObject getByteRangeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		return object;
	}

	@Override
	public Boolean getisByteRangeIndirect() {
		COSObject ByteRange = getByteRangeValue();
		return getisIndirect(ByteRange);
	}

	@Override
	public Boolean getByteRangeHasTypeArray() {
		COSObject ByteRange = getByteRangeValue();
		return getHasTypeArray(ByteRange);
	}

	@Override
	public Boolean getcontainsMAC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MAC"));
	}

	public COSObject getMACValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MAC"));
		return object;
	}

	@Override
	public Boolean getisMACIndirect() {
		COSObject MAC = getMACValue();
		return getisIndirect(MAC);
	}

	@Override
	public Boolean getMACHasTypeStringByte() {
		COSObject MAC = getMACValue();
		return getHasTypeStringByte(MAC);
	}

	@Override
	public Boolean getcontainsMACLocation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MACLocation"));
	}

	public COSObject getMACLocationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MACLocation"));
		return object;
	}

	@Override
	public Boolean getisMACLocationIndirect() {
		COSObject MACLocation = getMACLocationValue();
		return getisIndirect(MACLocation);
	}

	@Override
	public Boolean getMACLocationHasTypeName() {
		COSObject MACLocation = getMACLocationValue();
		return getHasTypeName(MACLocation);
	}

	@Override
	public String getMACLocationNameValue() {
		COSObject MACLocation = getMACLocationValue();
		return getNameValue(MACLocation);
	}

	@Override
	public Boolean getcontainsSigObjRef() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SigObjRef"));
	}

	public COSObject getSigObjRefValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigObjRef"));
		return object;
	}

	@Override
	public Boolean getisSigObjRefIndirect() {
		COSObject SigObjRef = getSigObjRefValue();
		return getisIndirect(SigObjRef);
	}

	@Override
	public Boolean getSigObjRefHasTypeDictionary() {
		COSObject SigObjRef = getSigObjRefValue();
		return getHasTypeDictionary(SigObjRef);
	}

	@Override
	public Long getByteRange0IntegerValue() {
		COSObject ByteRange = getByteRangeValue();
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 0) {
			return null;
		}
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry0IntegerValue();
	}

	@Override
	public Long getByteRange1IntegerValue() {
		COSObject ByteRange = getByteRangeValue();
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 1) {
			return null;
		}
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry1IntegerValue();
	}

	@Override
	public Long getByteRange2IntegerValue() {
		COSObject ByteRange = getByteRangeValue();
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 2) {
			return null;
		}
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry2IntegerValue();
	}

	@Override
	public Long getByteRange3IntegerValue() {
		COSObject ByteRange = getByteRangeValue();
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 3) {
			return null;
		}
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry3IntegerValue();
	}

	@Override
	public Boolean getByteRange1HasTypeInteger() {
		COSObject ByteRange = getByteRangeValue();
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 1) {
			return null;
		}
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry1HasTypeInteger();
	}

	@Override
	public Boolean getByteRange2HasTypeInteger() {
		COSObject ByteRange = getByteRangeValue();
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 2) {
			return null;
		}
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry2HasTypeInteger();
	}

	@Override
	public Boolean getByteRange0HasTypeInteger() {
		COSObject ByteRange = getByteRangeValue();
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 0) {
			return null;
		}
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry0HasTypeInteger();
	}

	@Override
	public Boolean getByteRange3HasTypeInteger() {
		COSObject ByteRange = getByteRangeValue();
		if (ByteRange == null || ByteRange.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (ByteRange.size() <= 3) {
			return null;
		}
		return new GFAArrayOf_4Integers(ByteRange.getDirectBase(), null, null).getentry3HasTypeInteger();
	}

	@Override
	public Boolean gethasExtensionISO_TS_32004() {
		return false;
	}

}
