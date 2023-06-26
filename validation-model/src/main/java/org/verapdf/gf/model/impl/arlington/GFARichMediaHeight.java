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

public class GFARichMediaHeight extends GFAObject implements ARichMediaHeight {

	public GFARichMediaHeight(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaHeight");
	}

	@Override
	public Boolean getcontainsDefault() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Default"));
	}

	public COSObject getDefaultDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(216L);
		}
		return null;
	}

	public COSObject getDefaultValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Default"));
		if (object == null || object.empty()) {
			object = getDefaultDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDefaultHasTypeInteger() {
		COSObject object = getDefaultValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getDefaultIntegerValue() {
		COSObject object = getDefaultValue();
		return getIntegerValue(object);
	}

	@Override
	public Boolean getcontainsMax() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Max"));
	}

	public COSObject getMaxDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(432L);
		}
		return null;
	}

	public COSObject getMaxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Max"));
		if (object == null || object.empty()) {
			object = getMaxDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getMaxHasTypeInteger() {
		COSObject object = getMaxValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getMaxIntegerValue() {
		COSObject object = getMaxValue();
		return getIntegerValue(object);
	}

	@Override
	public Boolean getcontainsMin() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Min"));
	}

	public COSObject getMinDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(72L);
		}
		return null;
	}

	public COSObject getMinValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Min"));
		if (object == null || object.empty()) {
			object = getMinDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getMinHasTypeInteger() {
		COSObject object = getMinValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getMinIntegerValue() {
		COSObject object = getMinValue();
		return getIntegerValue(object);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
