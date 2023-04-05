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

public class GFAMediaClipDataMHBE extends GFAObject implements AMediaClipDataMHBE {

	public GFAMediaClipDataMHBE(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMediaClipDataMHBE");
	}

	@Override
	public Boolean getcontainsBU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BU"));
	}

	@Override
	public Boolean getBUHasTypeStringAscii() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BU"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

}
