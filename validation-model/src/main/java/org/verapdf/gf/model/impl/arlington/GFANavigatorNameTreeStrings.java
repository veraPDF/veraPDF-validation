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

public class GFANavigatorNameTreeStrings extends GFAObject implements ANavigatorNameTreeStrings {

	public GFANavigatorNameTreeStrings(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANavigatorNameTreeStrings");
	}

	@Override
	public Long getsize() {
		return PDNameTreeNode.create(new COSObject(baseObject)).size();
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

	private List<ANavigatorNameTreeStringsEntry> getEntries() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANavigatorNameTreeStringsEntry> getEntries1_7() {
		List<ANavigatorNameTreeStringsEntry> list = new LinkedList<>();
		for (COSObject object : PDNameTreeNode.create(new COSObject(baseObject))) {
			list.add(new GFANavigatorNameTreeStringsEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, null));
		}
		return Collections.unmodifiableList(list);
	}

}
