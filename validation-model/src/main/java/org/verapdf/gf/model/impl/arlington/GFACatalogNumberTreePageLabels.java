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

public class GFACatalogNumberTreePageLabels extends GFAObject implements ACatalogNumberTreePageLabels {

	public GFACatalogNumberTreePageLabels(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACatalogNumberTreePageLabels");
	}

	@Override
	public Long getsize() {
		return new PDNumberTreeNode(new COSObject(baseObject)).size();
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

	private List<ACatalogNumberTreePageLabelsEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
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

	private List<ACatalogNumberTreePageLabelsEntry> getEntries1_3() {
		List<ACatalogNumberTreePageLabelsEntry> list = new LinkedList<>();
		for (COSObject object : new PDNumberTreeNode(new COSObject(baseObject))) {
			list.add(new GFACatalogNumberTreePageLabelsEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, null));
		}
		return Collections.unmodifiableList(list);
	}

}