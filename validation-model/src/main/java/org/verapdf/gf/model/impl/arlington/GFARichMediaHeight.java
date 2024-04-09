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
	public String getDefaultType() {
		COSObject Default = getDefaultValue();
		return getObjectType(Default);
	}

	@Override
	public Boolean getDefaultHasTypeInteger() {
		COSObject Default = getDefaultValue();
		return getHasTypeInteger(Default);
	}

	@Override
	public Long getDefaultIntegerValue() {
		COSObject Default = getDefaultValue();
		return getIntegerValue(Default);
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
	public String getMaxType() {
		COSObject Max = getMaxValue();
		return getObjectType(Max);
	}

	@Override
	public Boolean getMaxHasTypeInteger() {
		COSObject Max = getMaxValue();
		return getHasTypeInteger(Max);
	}

	@Override
	public Long getMaxIntegerValue() {
		COSObject Max = getMaxValue();
		return getIntegerValue(Max);
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
	public String getMinType() {
		COSObject Min = getMinValue();
		return getObjectType(Min);
	}

	@Override
	public Boolean getMinHasTypeInteger() {
		COSObject Min = getMinValue();
		return getHasTypeInteger(Min);
	}

	@Override
	public Long getMinIntegerValue() {
		COSObject Min = getMinValue();
		return getIntegerValue(Min);
	}

}
