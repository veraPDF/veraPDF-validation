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

public class GFATimeStampDict extends GFAObject implements ATimeStampDict {

	public GFATimeStampDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ATimeStampDict");
	}

	@Override
	public Boolean getcontainsFf() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ff"));
	}

	public COSObject getFfDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getFfValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		if (object == null || object.empty()) {
			object = getFfDefaultValue();
		}
		return object;
	}

	@Override
	public String getFfType() {
		COSObject Ff = getFfValue();
		return getObjectType(Ff);
	}

	@Override
	public Boolean getFfHasTypeInteger() {
		COSObject Ff = getFfValue();
		return getHasTypeInteger(Ff);
	}

	@Override
	public Long getFfIntegerValue() {
		COSObject Ff = getFfValue();
		return getIntegerValue(Ff);
	}

	@Override
	public Boolean getcontainsURL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URL"));
	}

	public COSObject getURLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URL"));
		return object;
	}

	@Override
	public String getURLType() {
		COSObject URL = getURLValue();
		return getObjectType(URL);
	}

	@Override
	public Boolean getURLHasTypeStringAscii() {
		COSObject URL = getURLValue();
		return getHasTypeStringAscii(URL);
	}

}
