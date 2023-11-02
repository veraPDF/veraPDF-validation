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

public class GFASignature extends GFAObject implements ASignature {

	public GFASignature(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASignature");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ByteRange":
				return getByteRange();
			case "Cert":
				return getCert();
			case "Changes":
				return getChanges();
			case "Prop_Build":
				return getProp_Build();
			case "Reference":
				return getReference();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfIntegersGeneral> getByteRange() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getByteRange1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfIntegersGeneral> getByteRange1_3() {
		COSObject object = getByteRangeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfIntegersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfIntegersGeneral((COSArray)object.getDirectBase(), this.baseObject, "ByteRange"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsByte> getCert() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCert1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getCert1_3() {
		COSObject object = getCertValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "Cert"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3Integers> getChanges() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getChanges1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3Integers> getChanges1_3() {
		COSObject object = getChangesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3Integers((COSArray)object.getDirectBase(), this.baseObject, "Changes"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A_UniversalDictionary> getProp_Build() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getProp_Build1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<A_UniversalDictionary> getProp_Build1_5() {
		COSObject object = getProp_BuildValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "Prop_Build"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfSignatureReferences> getReference() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getReference1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfSignatureReferences> getReference1_5() {
		COSObject object = getReferenceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfSignatureReferences> list = new ArrayList<>(1);
			list.add(new GFAArrayOfSignatureReferences((COSArray)object.getDirectBase(), this.baseObject, "Reference"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public String getByteRangeType() {
		COSObject ByteRange = getByteRangeValue();
		return getObjectType(ByteRange);
	}

	@Override
	public Boolean getByteRangeHasTypeArray() {
		COSObject ByteRange = getByteRangeValue();
		return getHasTypeArray(ByteRange);
	}

	@Override
	public Boolean getcontainsCert() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Cert"));
	}

	public COSObject getCertValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Cert"));
		return object;
	}

	@Override
	public String getCertType() {
		COSObject Cert = getCertValue();
		return getObjectType(Cert);
	}

	@Override
	public Boolean getCertHasTypeArray() {
		COSObject Cert = getCertValue();
		return getHasTypeArray(Cert);
	}

	@Override
	public Boolean getCertHasTypeStringByte() {
		COSObject Cert = getCertValue();
		return getHasTypeStringByte(Cert);
	}

	@Override
	public Boolean getcontainsChanges() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Changes"));
	}

	public COSObject getChangesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Changes"));
		return object;
	}

	@Override
	public String getChangesType() {
		COSObject Changes = getChangesValue();
		return getObjectType(Changes);
	}

	@Override
	public Boolean getChangesHasTypeArray() {
		COSObject Changes = getChangesValue();
		return getHasTypeArray(Changes);
	}

	@Override
	public Boolean getcontainsContactInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ContactInfo"));
	}

	public COSObject getContactInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ContactInfo"));
		return object;
	}

	@Override
	public String getContactInfoType() {
		COSObject ContactInfo = getContactInfoValue();
		return getObjectType(ContactInfo);
	}

	@Override
	public Boolean getContactInfoHasTypeStringText() {
		COSObject ContactInfo = getContactInfoValue();
		return getHasTypeStringText(ContactInfo);
	}

	@Override
	public Boolean getcontainsContents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Contents"));
	}

	public COSObject getContentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object;
	}

	@Override
	public String getContentsType() {
		COSObject Contents = getContentsValue();
		return getObjectType(Contents);
	}

	@Override
	public Boolean getContentsHasTypeStringByte() {
		COSObject Contents = getContentsValue();
		return getHasTypeStringByte(Contents);
	}

	@Override
	public Boolean getisContentsHexString() {
		COSObject Contents = getContentsValue();
		return Contents != null && Contents.getType() == COSObjType.COS_STRING && ((COSString)Contents.getDirectBase()).isHexadecimal();
	}

	@Override
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	public COSObject getFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object;
	}

	@Override
	public String getFilterType() {
		COSObject Filter = getFilterValue();
		return getObjectType(Filter);
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject Filter = getFilterValue();
		return getHasTypeName(Filter);
	}

	@Override
	public String getFilterNameValue() {
		COSObject Filter = getFilterValue();
		return getNameValue(Filter);
	}

	@Override
	public Boolean getcontainsLocation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Location"));
	}

	public COSObject getLocationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Location"));
		return object;
	}

	@Override
	public String getLocationType() {
		COSObject Location = getLocationValue();
		return getObjectType(Location);
	}

	@Override
	public Boolean getLocationHasTypeStringText() {
		COSObject Location = getLocationValue();
		return getHasTypeStringText(Location);
	}

	@Override
	public Boolean getcontainsM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M"));
	}

	public COSObject getMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		return object;
	}

	@Override
	public String getMType() {
		COSObject M = getMValue();
		return getObjectType(M);
	}

	@Override
	public Boolean getMHasTypeDate() {
		COSObject M = getMValue();
		return getHasTypeDate(M);
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object;
	}

	@Override
	public String getNameType() {
		COSObject Name = getNameValue();
		return getObjectType(Name);
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject Name = getNameValue();
		return getHasTypeStringText(Name);
	}

	@Override
	public Boolean getcontainsProp_AuthTime() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Prop_AuthTime"));
	}

	public COSObject getProp_AuthTimeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prop_AuthTime"));
		return object;
	}

	@Override
	public String getProp_AuthTimeType() {
		COSObject Prop_AuthTime = getProp_AuthTimeValue();
		return getObjectType(Prop_AuthTime);
	}

	@Override
	public Boolean getProp_AuthTimeHasTypeInteger() {
		COSObject Prop_AuthTime = getProp_AuthTimeValue();
		return getHasTypeInteger(Prop_AuthTime);
	}

	@Override
	public Long getProp_AuthTimeIntegerValue() {
		COSObject Prop_AuthTime = getProp_AuthTimeValue();
		return getIntegerValue(Prop_AuthTime);
	}

	@Override
	public Boolean getcontainsProp_AuthType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Prop_AuthType"));
	}

	public COSObject getProp_AuthTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prop_AuthType"));
		return object;
	}

	@Override
	public String getProp_AuthTypeType() {
		COSObject Prop_AuthType = getProp_AuthTypeValue();
		return getObjectType(Prop_AuthType);
	}

	@Override
	public Boolean getProp_AuthTypeHasTypeName() {
		COSObject Prop_AuthType = getProp_AuthTypeValue();
		return getHasTypeName(Prop_AuthType);
	}

	@Override
	public Boolean getcontainsProp_Build() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Prop_Build"));
	}

	public COSObject getProp_BuildValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prop_Build"));
		return object;
	}

	@Override
	public String getProp_BuildType() {
		COSObject Prop_Build = getProp_BuildValue();
		return getObjectType(Prop_Build);
	}

	@Override
	public Boolean getProp_BuildHasTypeDictionary() {
		COSObject Prop_Build = getProp_BuildValue();
		return getHasTypeDictionary(Prop_Build);
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object;
	}

	@Override
	public String getRType() {
		COSObject R = getRValue();
		return getObjectType(R);
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject R = getRValue();
		return getHasTypeInteger(R);
	}

	@Override
	public Boolean getcontainsReason() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Reason"));
	}

	public COSObject getReasonValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Reason"));
		return object;
	}

	@Override
	public String getReasonType() {
		COSObject Reason = getReasonValue();
		return getObjectType(Reason);
	}

	@Override
	public Boolean getReasonHasTypeStringText() {
		COSObject Reason = getReasonValue();
		return getHasTypeStringText(Reason);
	}

	@Override
	public Boolean getcontainsReference() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Reference"));
	}

	public COSObject getReferenceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Reference"));
		return object;
	}

	@Override
	public String getReferenceType() {
		COSObject Reference = getReferenceValue();
		return getObjectType(Reference);
	}

	@Override
	public Boolean getReferenceHasTypeArray() {
		COSObject Reference = getReferenceValue();
		return getHasTypeArray(Reference);
	}

	@Override
	public Boolean getcontainsSubFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SubFilter"));
	}

	public COSObject getSubFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubFilter"));
		return object;
	}

	@Override
	public String getSubFilterType() {
		COSObject SubFilter = getSubFilterValue();
		return getObjectType(SubFilter);
	}

	@Override
	public Boolean getSubFilterHasTypeName() {
		COSObject SubFilter = getSubFilterValue();
		return getHasTypeName(SubFilter);
	}

	@Override
	public String getSubFilterNameValue() {
		COSObject SubFilter = getSubFilterValue();
		return getNameValue(SubFilter);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		if (object == null || object.empty()) {
			object = getVDefaultValue();
		}
		return object;
	}

	@Override
	public String getVType() {
		COSObject V = getVValue();
		return getObjectType(V);
	}

	@Override
	public Boolean getVHasTypeInteger() {
		COSObject V = getVValue();
		return getHasTypeInteger(V);
	}

}
