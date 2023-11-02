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

public class GFAOptContentZoom extends GFAObject implements AOptContentZoom {

	public GFAOptContentZoom(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentZoom");
	}

	@Override
	public Boolean getcontainsmax() {
		return this.baseObject.knownKey(ASAtom.getASAtom("max"));
	}

	public COSObject getmaxDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(999999.9D);
		}
		return null;
	}

	public COSObject getmaxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("max"));
		if (object == null || object.empty()) {
			object = getmaxDefaultValue();
		}
		return object;
	}

	@Override
	public String getmaxType() {
		COSObject max = getmaxValue();
		return getObjectType(max);
	}

	@Override
	public Boolean getmaxHasTypeNumber() {
		COSObject max = getmaxValue();
		return getHasTypeNumber(max);
	}

	@Override
	public Double getmaxNumberValue() {
		COSObject max = getmaxValue();
		return getNumberValue(max);
	}

	@Override
	public Boolean getcontainsmin() {
		return this.baseObject.knownKey(ASAtom.getASAtom("min"));
	}

	public COSObject getminDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0.0D);
		}
		return null;
	}

	public COSObject getminValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("min"));
		if (object == null || object.empty()) {
			object = getminDefaultValue();
		}
		return object;
	}

	@Override
	public String getminType() {
		COSObject min = getminValue();
		return getObjectType(min);
	}

	@Override
	public Boolean getminHasTypeNumber() {
		COSObject min = getminValue();
		return getHasTypeNumber(min);
	}

	@Override
	public Double getminNumberValue() {
		COSObject min = getminValue();
		return getNumberValue(min);
	}

}
