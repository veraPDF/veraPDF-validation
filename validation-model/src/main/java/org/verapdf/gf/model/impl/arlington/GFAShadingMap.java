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

public class GFAShadingMap extends GFAObject implements AShadingMap {

	public GFAShadingMap(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AShadingMap");
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

	private List<AShadingMapEntry> getEntries() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AShadingMapEntry> getEntries1_3() {
		List<AShadingMapEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFAShadingMapEntry(object != null ? object.get() : null, this.baseObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

}
