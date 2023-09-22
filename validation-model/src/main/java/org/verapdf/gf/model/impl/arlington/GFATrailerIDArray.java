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
		return getisIndirect(object);
	}

	@Override
	public Boolean getentry0HasTypeStringByte() {
		COSObject object = getentry0Value();
		return getHasTypeStringByte(object);
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
		return getisIndirect(object);
	}

	@Override
	public Boolean getentry1HasTypeStringByte() {
		COSObject object = getentry1Value();
		return getHasTypeStringByte(object);
	}

	@Override
	public Boolean getcontainstrailerEncrypt() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		return trailer.knownKey(ASAtom.getASAtom("Encrypt"));
	}

}