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

public class GFAArrayOf_9Numbers extends GFAObject implements AArrayOf_9Numbers {

	public GFAArrayOf_9Numbers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_9Numbers");
	}

	@Override
	public Boolean getentry8HasTypeNumber() {
		if (this.baseObject.size() <= 8) {
			return null;
		}
		COSObject object = this.baseObject.at(8);
		return object != null && object.getType().isNumber();
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
	public Boolean getentry4HasTypeNumber() {
		if (this.baseObject.size() <= 4) {
			return null;
		}
		COSObject object = this.baseObject.at(4);
		return object != null && object.getType().isNumber();
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
	public Boolean getentry6HasTypeNumber() {
		if (this.baseObject.size() <= 6) {
			return null;
		}
		COSObject object = this.baseObject.at(6);
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getentry7HasTypeNumber() {
		if (this.baseObject.size() <= 7) {
			return null;
		}
		COSObject object = this.baseObject.at(7);
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getentry5HasTypeNumber() {
		if (this.baseObject.size() <= 5) {
			return null;
		}
		COSObject object = this.baseObject.at(5);
		return object != null && object.getType().isNumber();
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
	public Boolean getentry1HasTypeNumber() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object != null && object.getType().isNumber();
	}

}
