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

public class GFACertSeedValue extends GFAObject implements ACertSeedValue {

	public GFACertSeedValue(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACertSeedValue");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Issuer":
				return getIssuer();
			case "KeyUsage":
				return getKeyUsage();
			case "OID":
				return getOID();
			case "SubjectDN":
				return getSubjectDN();
			case "SignaturePolicyCommitmentType":
				return getSignaturePolicyCommitmentType();
			case "Subject":
				return getSubject();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStringsByte> getIssuer() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIssuer1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getIssuer1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Issuer"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "Issuer"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsASCII> getKeyUsage() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getKeyUsage1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsASCII> getKeyUsage1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("KeyUsage"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsASCII> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsASCII((COSArray)object.getDirectBase(), this.baseObject, "KeyUsage"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsByte> getOID() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOID1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getOID1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OID"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "OID"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfSubjectDN> getSubjectDN() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSubjectDN1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfSubjectDN> getSubjectDN1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubjectDN"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfSubjectDN> list = new ArrayList<>(1);
			list.add(new GFAArrayOfSubjectDN((COSArray)object.getDirectBase(), this.baseObject, "SubjectDN"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsASCII> getSignaturePolicyCommitmentType() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSignaturePolicyCommitmentType2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsASCII> getSignaturePolicyCommitmentType2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyCommitmentType"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsASCII> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsASCII((COSArray)object.getDirectBase(), this.baseObject, "SignaturePolicyCommitmentType"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsByte> getSubject() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSubject1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getSubject1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subject"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "Subject"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsKeyUsage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("KeyUsage"));
	}

	@Override
	public Boolean getKeyUsageHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("KeyUsage"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsFf() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ff"));
	}

	@Override
	public Boolean getFfHasTypeBitmask() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFfBitmaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		if (object == null || object.empty()) {
			return getFfBitmaskDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getFfBitmaskDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsSignaturePolicyHashValue() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SignaturePolicyHashValue"));
	}

	@Override
	public Boolean getSignaturePolicyHashValueHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyHashValue"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsSignaturePolicyCommitmentType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SignaturePolicyCommitmentType"));
	}

	@Override
	public Boolean getSignaturePolicyCommitmentTypeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyCommitmentType"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsOID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OID"));
	}

	@Override
	public Boolean getOIDHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OID"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsURL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URL"));
	}

	@Override
	public Boolean getURLHasTypeStringAscii() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URL"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
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
	public Boolean getcontainsSubjectDN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SubjectDN"));
	}

	@Override
	public Boolean getSubjectDNHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubjectDN"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsSignaturePolicyOID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SignaturePolicyOID"));
	}

	@Override
	public Boolean getSignaturePolicyOIDHasTypeStringAscii() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyOID"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

	@Override
	public Boolean getcontainsIssuer() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Issuer"));
	}

	@Override
	public Boolean getIssuerHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Issuer"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsURLType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URLType"));
	}

	@Override
	public Boolean getURLTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLType"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getURLTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLType"));
		if (object == null || object.empty()) {
			return getURLTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getURLTypeNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Browser";
		}
		return null;
	}

	@Override
	public Boolean getcontainsSignaturePolicyHashAlgorithm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SignaturePolicyHashAlgorithm"));
	}

	@Override
	public Boolean getSignaturePolicyHashAlgorithmHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyHashAlgorithm"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSignaturePolicyHashAlgorithmNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyHashAlgorithm"));
		if (object == null || object.empty()) {
			return getSignaturePolicyHashAlgorithmNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSignaturePolicyHashAlgorithmNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSubject() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subject"));
	}

	@Override
	public Boolean getSubjectHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subject"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
