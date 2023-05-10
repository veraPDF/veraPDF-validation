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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Cert"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Changes"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prop_Build"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Reference"));
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

	@Override
	public Boolean getByteRangeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ByteRange"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCert() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Cert"));
	}

	@Override
	public Boolean getCertHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Cert"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getCertHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Cert"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsChanges() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Changes"));
	}

	@Override
	public Boolean getChangesHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Changes"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsContactInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ContactInfo"));
	}

	@Override
	public Boolean getContactInfoHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ContactInfo"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsContents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Contents"));
	}

	@Override
	public Boolean getContentsHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getisContentsHexString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isHexadecimal();
	}

	@Override
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFilterNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (object == null || object.empty()) {
			return getFilterNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFilterNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsLocation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Location"));
	}

	@Override
	public Boolean getLocationHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Location"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M"));
	}

	@Override
	public Boolean getMHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsProp_AuthTime() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Prop_AuthTime"));
	}

	@Override
	public Boolean getProp_AuthTimeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prop_AuthTime"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getProp_AuthTimeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prop_AuthTime"));
		if (object == null || object.empty()) {
			return getProp_AuthTimeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getProp_AuthTimeIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsProp_AuthType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Prop_AuthType"));
	}

	@Override
	public Boolean getProp_AuthTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prop_AuthType"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsProp_Build() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Prop_Build"));
	}

	@Override
	public Boolean getProp_BuildHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prop_Build"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsReason() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Reason"));
	}

	@Override
	public Boolean getReasonHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Reason"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsReference() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Reference"));
	}

	@Override
	public Boolean getReferenceHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Reference"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsSubFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SubFilter"));
	}

	@Override
	public Boolean getSubFilterHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubFilter"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubFilterNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubFilter"));
		if (object == null || object.empty()) {
			return getSubFilterNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSubFilterNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	@Override
	public Boolean getVHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

}
