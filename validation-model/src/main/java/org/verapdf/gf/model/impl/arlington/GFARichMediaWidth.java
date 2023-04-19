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
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFARichMediaWidth extends GFAObject implements ARichMediaWidth {

	public GFARichMediaWidth(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaWidth");
	}

	@Override
	public Boolean getcontainsDefault() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Default"));
	}

	@Override
	public Boolean getDefaultHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Default"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDefaultIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Default"));
		if (object == null || object.empty()) {
			return getDefaultIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDefaultIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 288L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsMax() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Max"));
	}

	@Override
	public Boolean getMaxHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Max"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getMaxIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Max"));
		if (object == null || object.empty()) {
			return getMaxIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getMaxIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 576L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsMin() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Min"));
	}

	@Override
	public Boolean getMinHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Min"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getMinIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Min"));
		if (object == null || object.empty()) {
			return getMinIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getMinIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 72L;
		}
		return null;
	}

}
