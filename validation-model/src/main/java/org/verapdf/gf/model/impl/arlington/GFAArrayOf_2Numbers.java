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

public class GFAArrayOf_2Numbers extends GFAObject implements AArrayOf_2Numbers {

	public GFAArrayOf_2Numbers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_2Numbers");
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
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getentry0NumberValue() {
		COSObject object = getentry0Value();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
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
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getentry1NumberValue() {
		COSObject object = getentry1Value();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

}
