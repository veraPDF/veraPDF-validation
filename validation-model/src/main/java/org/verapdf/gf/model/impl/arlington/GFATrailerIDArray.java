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

public class GFATrailerIDArray extends GFAObject implements ATrailerIDArray {

	public GFATrailerIDArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ATrailerIDArray");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getisentry0Indirect() {
		COSObject object = getentry0Value();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getentry0HasTypeStringByte() {
		COSObject object = getentry0Value();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getisentry1Indirect() {
		COSObject object = getentry1Value();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getentry1HasTypeStringByte() {
		COSObject object = getentry1Value();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainstrailerEncrypt() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		return trailer.knownKey(ASAtom.getASAtom("Encrypt"));
	}

}
