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

public class GFAMarkInfo extends GFAObject implements AMarkInfo {

	public GFAMarkInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMarkInfo");
	}

	@Override
	public Boolean getcontainsMarked() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Marked"));
	}

	@Override
	public Boolean getMarkedHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Marked"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsSuspects() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Suspects"));
	}

	@Override
	public Boolean getSuspectsHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Suspects"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsUserProperties() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UserProperties"));
	}

	@Override
	public Boolean getUserPropertiesHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UserProperties"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getUserPropertiesBooleanValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UserProperties"));
		if (object == null || object.empty()) {
			return getUserPropertiesBooleanDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_BOOLEAN) {
			return object.getBoolean();
		}
		return null;
	}

	public Boolean getUserPropertiesBooleanDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return false;
		}
		return null;
	}

}
