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

public class GFAArrayOfOPI13Color extends GFAObject implements AArrayOfOPI13Color {

	public GFAArrayOfOPI13Color(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfOPI13Color");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		COSObject object = getentry0Value();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getentry0NumberValue() {
		COSObject object = getentry0Value();
		return getNumberValue(object);
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		COSObject object = getentry1Value();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getentry1NumberValue() {
		COSObject object = getentry1Value();
		return getNumberValue(object);
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject object = getentry2Value();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getentry2NumberValue() {
		COSObject object = getentry2Value();
		return getNumberValue(object);
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getentry3HasTypeNumber() {
		COSObject object = getentry3Value();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getentry3NumberValue() {
		COSObject object = getentry3Value();
		return getNumberValue(object);
	}

	public COSObject getentry4DefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSString.construct("Black".getBytes());
		}
		return null;
	}

	public COSObject getentry4Value() {
		if (this.baseObject.size() <= 4) {
			return null;
		}
		COSObject object = this.baseObject.at(4);
		if (object == null || object.empty()) {
			object = getentry4DefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getentry4HasTypeStringByte() {
		COSObject object = getentry4Value();
		return getHasTypeStringByte(object);
	}

}
