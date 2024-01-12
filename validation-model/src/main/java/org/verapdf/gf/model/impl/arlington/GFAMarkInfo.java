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

public class GFAMarkInfo extends GFAObject implements AMarkInfo {

	public GFAMarkInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMarkInfo");
	}

	@Override
	public Boolean getcontainsMarked() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Marked"));
	}

	public COSObject getMarkedDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getMarkedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Marked"));
		if (object == null || object.empty()) {
			object = getMarkedDefaultValue();
		}
		return object;
	}

	@Override
	public String getMarkedType() {
		COSObject Marked = getMarkedValue();
		return getObjectType(Marked);
	}

	@Override
	public Boolean getMarkedHasTypeBoolean() {
		COSObject Marked = getMarkedValue();
		return getHasTypeBoolean(Marked);
	}

	@Override
	public Boolean getcontainsSuspects() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Suspects"));
	}

	public COSObject getSuspectsDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getSuspectsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Suspects"));
		if (object == null || object.empty()) {
			object = getSuspectsDefaultValue();
		}
		return object;
	}

	@Override
	public String getSuspectsType() {
		COSObject Suspects = getSuspectsValue();
		return getObjectType(Suspects);
	}

	@Override
	public Boolean getSuspectsHasTypeBoolean() {
		COSObject Suspects = getSuspectsValue();
		return getHasTypeBoolean(Suspects);
	}

	@Override
	public Boolean getcontainsUserProperties() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UserProperties"));
	}

	public COSObject getUserPropertiesDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getUserPropertiesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UserProperties"));
		if (object == null || object.empty()) {
			object = getUserPropertiesDefaultValue();
		}
		return object;
	}

	@Override
	public String getUserPropertiesType() {
		COSObject UserProperties = getUserPropertiesValue();
		return getObjectType(UserProperties);
	}

	@Override
	public Boolean getUserPropertiesHasTypeBoolean() {
		COSObject UserProperties = getUserPropertiesValue();
		return getHasTypeBoolean(UserProperties);
	}

	@Override
	public Boolean getUserPropertiesBooleanValue() {
		COSObject UserProperties = getUserPropertiesValue();
		return getBooleanValue(UserProperties);
	}

}