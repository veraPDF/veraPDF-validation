package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFADocTimeStamp extends GFAObject implements ADocTimeStamp {

	public GFADocTimeStamp(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADocTimeStamp");
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

	private List<ASignatureBuildPropDict> getProp_Build() {
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

	private List<ASignatureBuildPropDict> getProp_Build1_5() {
		COSObject object = getProp_BuildValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildPropDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildPropDict((COSDictionary)object.getDirectBase(), this.baseObject, "Prop_Build"));
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
	public Boolean getcontainsADBE_Build() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ADBE_Build"));
	}

	public COSObject getADBE_BuildValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ADBE_Build"));
		return object;
	}

	@Override
	public Boolean getADBE_BuildHasTypeString() {
		COSObject object = getADBE_BuildValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getByteRangeHasTypeArray() {
		COSObject object = getByteRangeValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getCertHasTypeArray() {
		COSObject object = getCertValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getCertHasTypeStringByte() {
		COSObject object = getCertValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getChangesHasTypeArray() {
		COSObject object = getChangesValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getContactInfoHasTypeString() {
		COSObject object = getContactInfoValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getContentsHasTypeStringByte() {
		COSObject object = getContentsValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getFilterHasTypeName() {
		COSObject object = getFilterValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getLocationHasTypeString() {
		COSObject object = getLocationValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getMHasTypeDate() {
		COSObject object = getMValue();
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
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
	public Boolean getNameHasTypeString() {
		COSObject object = getNameValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getProp_AuthTimeHasTypeInteger() {
		COSObject object = getProp_AuthTimeValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
	public Boolean getProp_AuthTypeHasTypeName() {
		COSObject object = getProp_AuthTypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getProp_BuildHasTypeDictionary() {
		COSObject object = getProp_BuildValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
	public Boolean getRHasTypeInteger() {
		COSObject object = getRValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
	public Boolean getReasonHasTypeString() {
		COSObject object = getReasonValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
	public Boolean getReferenceHasTypeArray() {
		COSObject object = getReferenceValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getSubFilterHasTypeName() {
		COSObject object = getSubFilterValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubFilterNameValue() {
		COSObject object = getSubFilterValue();
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
	public Boolean getVHasTypeInteger() {
		COSObject object = getVValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

}
