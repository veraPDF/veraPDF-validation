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

public class GFAArrayOfCIP4_BindIn extends GFAObject implements AArrayOfCIP4_BindIn {

	public GFAArrayOfCIP4_BindIn(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfCIP4_BindIn");
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

	private List<AArrayOfCIP4_BindInEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_BindInEntry> getEntries1_7() {
		List<AArrayOfCIP4_BindInEntry> list = new LinkedList<>();
		for (int i = 0; i < baseObject.size(); i++) {
			COSObject object = baseObject.at(i);
			list.add(new GFAArrayOfCIP4_BindInEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, String.valueOf(i)));
		}
		return Collections.unmodifiableList(list);
	}

}
