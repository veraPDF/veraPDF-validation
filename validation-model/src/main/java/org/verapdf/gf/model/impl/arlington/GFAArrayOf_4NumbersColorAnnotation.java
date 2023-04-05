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

public class GFAArrayOf_4NumbersColorAnnotation extends GFAObject implements AArrayOf_4NumbersColorAnnotation {

	public GFAArrayOf_4NumbersColorAnnotation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_4NumbersColorAnnotation");
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getentry1NumberValue() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		if (object == null || object.empty()) {
			return getentry1NumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getentry1NumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getentry3HasTypeNumber() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getentry3NumberValue() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		if (object == null || object.empty()) {
			return getentry3NumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getentry3NumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getentry0NumberValue() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		if (object == null || object.empty()) {
			return getentry0NumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getentry0NumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontains2() {
		return this.baseObject.size() > 2;
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getentry2NumberValue() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		if (object == null || object.empty()) {
			return getentry2NumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getentry2NumberDefaultValue() {
		return null;
	}

}
