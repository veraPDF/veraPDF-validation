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

public class GFAArrayOfTagsSubArray extends GFAObject implements AArrayOfTagsSubArray {

	public GFAArrayOfTagsSubArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfTagsSubArray");
	}

	@Override
	public Boolean getentry1HasTypeStringAscii() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

	@Override
	public Boolean getentry0HasTypeInteger() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

}
