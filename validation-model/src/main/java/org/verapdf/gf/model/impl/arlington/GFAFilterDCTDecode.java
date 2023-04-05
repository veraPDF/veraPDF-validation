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

public class GFAFilterDCTDecode extends GFAObject implements AFilterDCTDecode {

	public GFAFilterDCTDecode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterDCTDecode");
	}

	@Override
	public Boolean getcontainsColorTransform() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorTransform"));
	}

	@Override
	public Boolean getColorTransformHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorTransform"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getColorTransformIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorTransform"));
		if (object == null || object.empty()) {
			return getColorTransformIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getColorTransformIntegerDefaultValue() {
		return null;
	}

}
