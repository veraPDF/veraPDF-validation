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

public class GFACryptFilter extends GFAObject implements ACryptFilter {

	public GFACryptFilter(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACryptFilter");
	}

	@Override
	public Boolean getcontainsAuthEvent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AuthEvent"));
	}

	public COSObject getAuthEventDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("DocOpen");
		}
		return null;
	}

	public COSObject getAuthEventValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthEvent"));
		if (object == null || object.empty()) {
			object = getAuthEventDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getAuthEventHasTypeName() {
		COSObject object = getAuthEventValue();
		return getHasTypeName(object);
	}

	@Override
	public String getAuthEventNameValue() {
		COSObject object = getAuthEventValue();
		return getNameValue(object);
	}

	@Override
	public Boolean getcontainsCFM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CFM"));
	}

	public COSObject getCFMDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getCFMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CFM"));
		if (object == null || object.empty()) {
			object = getCFMDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getCFMHasTypeName() {
		COSObject object = getCFMValue();
		return getHasTypeName(object);
	}

	@Override
	public String getCFMNameValue() {
		COSObject object = getCFMValue();
		return getNameValue(object);
	}

	@Override
	public Boolean getcontainsLength() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Length"));
	}

	public COSObject getLengthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
		return object;
	}

	@Override
	public Boolean getLengthHasTypeInteger() {
		COSObject object = getLengthValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getLengthIntegerValue() {
		COSObject object = getLengthValue();
		return getIntegerValue(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		return getNameValue(object);
	}

}
