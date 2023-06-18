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

public class GFAVRI extends GFAObject implements AVRI {

	public GFAVRI(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AVRI");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CRL":
				return getCRL();
			case "Cert":
				return getCert();
			case "OCSP":
				return getOCSP();
			case "TS":
				return getTS();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStreamsGeneral> getCRL() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getCRL2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getCRL2_0() {
		COSObject object = getCRLValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStreamsGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStreamsGeneral((COSArray)object.getDirectBase(), this.baseObject, "CRL"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStreamsGeneral> getCert() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getCert2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getCert2_0() {
		COSObject object = getCertValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStreamsGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStreamsGeneral((COSArray)object.getDirectBase(), this.baseObject, "Cert"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStreamsGeneral> getOCSP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getOCSP2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getOCSP2_0() {
		COSObject object = getOCSPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStreamsGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStreamsGeneral((COSArray)object.getDirectBase(), this.baseObject, "OCSP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getTS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getTS2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getTS2_0() {
		COSObject object = getTSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "TS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCRL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CRL"));
	}

	public COSObject getCRLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CRL"));
		return object;
	}

	@Override
	public Boolean getCRLHasTypeArray() {
		COSObject object = getCRLValue();
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
	public Boolean getcontainsOCSP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OCSP"));
	}

	public COSObject getOCSPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCSP"));
		return object;
	}

	@Override
	public Boolean getOCSPHasTypeArray() {
		COSObject object = getOCSPValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TS"));
	}

	public COSObject getTSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TS"));
		return object;
	}

	@Override
	public Boolean getisTSIndirect() {
		COSObject object = getTSValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTSHasTypeStream() {
		COSObject object = getTSValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsTU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TU"));
	}

	public COSObject getTUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TU"));
		return object;
	}

	@Override
	public Boolean getTUHasTypeDate() {
		COSObject object = getTUValue();
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
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
	public Long getparentCRLsArraySize() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject CRLs = this.parentObject.getKey(ASAtom.getASAtom("CRLs"));
		if (CRLs != null && CRLs.getType() == COSObjType.COS_ARRAY) {
			return (long) CRLs.size();
		}
		return null;
	}

	@Override
	public Long getparentOCSPsArraySize() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject OCSPs = this.parentObject.getKey(ASAtom.getASAtom("OCSPs"));
		if (OCSPs != null && OCSPs.getType() == COSObjType.COS_ARRAY) {
			return (long) OCSPs.size();
		}
		return null;
	}

	@Override
	public Boolean getparentCRLsHasTypeArray() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject CRLs = this.parentObject.getKey(ASAtom.getASAtom("CRLs"));
		return CRLs != null && CRLs.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getparentOCSPsHasTypeArray() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject OCSPs = this.parentObject.getKey(ASAtom.getASAtom("OCSPs"));
		return OCSPs != null && OCSPs.getType() == COSObjType.COS_ARRAY;
	}

}
