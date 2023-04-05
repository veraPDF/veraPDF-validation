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
import java.io.IOException;

public class GFADSS extends GFAObject implements ADSS {

	public GFADSS(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADSS");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Certs":
				return getCerts();
			case "CRLs":
				return getCRLs();
			case "OCSPs":
				return getOCSPs();
			case "VRI":
				return getVRI();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStreamsGeneral> getCerts() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getCerts2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getCerts2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Certs"));
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

	private List<AArrayOfStreamsGeneral> getCRLs() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getCRLs2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getCRLs2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CRLs"));
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

	private List<AArrayOfStreamsGeneral> getOCSPs() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getOCSPs2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStreamsGeneral> getOCSPs2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCSPs"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getVRI2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AVRIMap> getVRI2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VRI"));
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
	public Boolean getcontainsVRI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VRI"));
	}

	@Override
	public Boolean getVRIHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VRI"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsOCSPs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OCSPs"));
	}

	@Override
	public Boolean getOCSPsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCSPs"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCRLs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CRLs"));
	}

	@Override
	public Boolean getCRLsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CRLs"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCerts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Certs"));
	}

	@Override
	public Boolean getCertsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Certs"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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

}
