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

public class GFA3DStreamNameTreeResources extends GFAObject implements A3DStreamNameTreeResources {

	public GFA3DStreamNameTreeResources(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DStreamNameTreeResources");
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

	private List<A3DStreamNameTreeResourcesEntry> getEntries() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DStreamNameTreeResourcesEntry> getEntries1_6() {
		List<A3DStreamNameTreeResourcesEntry> list = new LinkedList<>();
		for (COSObject object : PDNameTreeNode.create(new COSObject(baseObject))) {
			list.add(new GFA3DStreamNameTreeResourcesEntry(object != null ? object.get() : null, this.baseObject, keyName, null));
		}
		return Collections.unmodifiableList(list);
	}

}
