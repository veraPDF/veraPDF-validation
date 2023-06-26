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

public class GFAFilterDCTDecode extends GFAObject implements AFilterDCTDecode {

	public GFAFilterDCTDecode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterDCTDecode");
	}

	@Override
	public Boolean getcontainsColorTransform() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorTransform"));
	}

	public COSObject getColorTransformValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorTransform"));
		return object;
	}

	@Override
	public Boolean getColorTransformHasTypeInteger() {
		COSObject object = getColorTransformValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getColorTransformIntegerValue() {
		COSObject object = getColorTransformValue();
		return getIntegerValue(object);
	}

}
