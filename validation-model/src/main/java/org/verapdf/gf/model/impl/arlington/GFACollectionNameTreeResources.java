package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFACollectionNameTreeResources extends GFAObject implements ACollectionNameTreeResources {

	public GFACollectionNameTreeResources(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACollectionNameTreeResources");
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

	private List<ACollectionNameTreeResourcesEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionNameTreeResourcesEntry> getEntries1_7() {
		List<ACollectionNameTreeResourcesEntry> list = new LinkedList<>();
		for (COSObject object : PDNameTreeNode.create(new COSObject(baseObject))) {
			list.add(new GFACollectionNameTreeResourcesEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, null));
		}
		return Collections.unmodifiableList(list);
	}

}
