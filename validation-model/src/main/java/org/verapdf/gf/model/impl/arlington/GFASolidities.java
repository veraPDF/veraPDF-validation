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

public class GFASolidities extends GFAObject implements ASolidities {

	public GFASolidities(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASolidities");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ASoliditiesEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASoliditiesEntry> getEntries1_6() {
		List<ASoliditiesEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("Default".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFASoliditiesEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	@Override
	public Boolean getcontainsDefault() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Default"));
	}

	public COSObject getDefaultValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Default"));
		return object;
	}

	@Override
	public Boolean getDefaultHasTypeNumber() {
		COSObject object = getDefaultValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getDefaultNumberValue() {
		COSObject object = getDefaultValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

}
