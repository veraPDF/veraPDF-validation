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

public class GFASoliditiesEntry extends GFAObject implements ASoliditiesEntry {

	private String collectionName;

	public GFASoliditiesEntry(COSBase baseObject, COSBase parentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "ASoliditiesEntry");
		this.collectionName = collectionName;
	}

	@Override
	public Boolean getHasTypeNumber() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getNumberValue() {
		COSObject object = new COSObject(this.baseObject);
		if (object == null || object.empty()) {
			return getNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getNumberDefaultValue() {
		return null;
	}

}
