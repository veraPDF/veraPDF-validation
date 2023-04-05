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

public class GFAOptContentZoom extends GFAObject implements AOptContentZoom {

	public GFAOptContentZoom(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentZoom");
	}

	@Override
	public Boolean getcontainsmax() {
		return this.baseObject.knownKey(ASAtom.getASAtom("max"));
	}

	@Override
	public Boolean getmaxHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("max"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getmaxNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("max"));
		if (object == null || object.empty()) {
			return getmaxNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getmaxNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 999999.9D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsmin() {
		return this.baseObject.knownKey(ASAtom.getASAtom("min"));
	}

	@Override
	public Boolean getminHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("min"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getminNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("min"));
		if (object == null || object.empty()) {
			return getminNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getminNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0.0D;
		}
		return null;
	}

}
