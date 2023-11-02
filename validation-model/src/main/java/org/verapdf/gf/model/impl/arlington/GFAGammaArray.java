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

public class GFAGammaArray extends GFAObject implements AGammaArray {

	public GFAGammaArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AGammaArray");
	}

	public COSObject getentry0DefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		if (object == null || object.empty()) {
			object = getentry0DefaultValue();
		}
		return object;
	}

	@Override
	public String getentry0Type() {
		COSObject entry0 = getentry0Value();
		return getObjectType(entry0);
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		COSObject entry0 = getentry0Value();
		return getHasTypeNumber(entry0);
	}

	@Override
	public Double getentry0NumberValue() {
		COSObject entry0 = getentry0Value();
		return getNumberValue(entry0);
	}

	public COSObject getentry1DefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		if (object == null || object.empty()) {
			object = getentry1DefaultValue();
		}
		return object;
	}

	@Override
	public String getentry1Type() {
		COSObject entry1 = getentry1Value();
		return getObjectType(entry1);
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		COSObject entry1 = getentry1Value();
		return getHasTypeNumber(entry1);
	}

	@Override
	public Double getentry1NumberValue() {
		COSObject entry1 = getentry1Value();
		return getNumberValue(entry1);
	}

	public COSObject getentry2DefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		if (object == null || object.empty()) {
			object = getentry2DefaultValue();
		}
		return object;
	}

	@Override
	public String getentry2Type() {
		COSObject entry2 = getentry2Value();
		return getObjectType(entry2);
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject entry2 = getentry2Value();
		return getHasTypeNumber(entry2);
	}

	@Override
	public Double getentry2NumberValue() {
		COSObject entry2 = getentry2Value();
		return getNumberValue(entry2);
	}

}
