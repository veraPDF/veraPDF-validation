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

public class GFADSS extends GFAObject implements ADSS {

	public GFADSS(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADSS");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CRLs":
				return getCRLs();
			case "Certs":
				return getCerts();
			case "OCSPs":
				return getOCSPs();
			case "VRI":
				return getVRI();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStreamsGeneral> getCRLs() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getCRLs2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getCRLs2_0() {
		COSObject object = getCRLsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStreamsGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStreamsGeneral((COSArray)object.getDirectBase(), this.baseObject, "CRLs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStreamsGeneral> getCerts() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getCerts2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getCerts2_0() {
		COSObject object = getCertsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStreamsGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStreamsGeneral((COSArray)object.getDirectBase(), this.baseObject, "Certs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStreamsGeneral> getOCSPs() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getOCSPs2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getOCSPs2_0() {
		COSObject object = getOCSPsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStreamsGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStreamsGeneral((COSArray)object.getDirectBase(), this.baseObject, "OCSPs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AVRIMap> getVRI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getVRI2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AVRIMap> getVRI2_0() {
		COSObject object = getVRIValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AVRIMap> list = new ArrayList<>(1);
			list.add(new GFAVRIMap((COSDictionary)object.getDirectBase(), this.baseObject, "VRI"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCRLs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CRLs"));
	}

	public COSObject getCRLsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CRLs"));
		return object;
	}

	@Override
	public Boolean getCRLsHasTypeArray() {
		COSObject object = getCRLsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCerts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Certs"));
	}

	public COSObject getCertsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Certs"));
		return object;
	}

	@Override
	public Boolean getCertsHasTypeArray() {
		COSObject object = getCertsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsOCSPs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OCSPs"));
	}

	public COSObject getOCSPsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCSPs"));
		return object;
	}

	@Override
	public Boolean getOCSPsHasTypeArray() {
		COSObject object = getOCSPsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getcontainsVRI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VRI"));
	}

	public COSObject getVRIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VRI"));
		return object;
	}

	@Override
	public Boolean getVRIHasTypeDictionary() {
		COSObject object = getVRIValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
