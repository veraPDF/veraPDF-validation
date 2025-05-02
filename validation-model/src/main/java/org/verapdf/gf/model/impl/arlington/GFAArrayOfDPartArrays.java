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

public class GFAArrayOfDPartArrays extends GFAObject implements AArrayOfDPartArrays {

	public GFAArrayOfDPartArrays(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfDPartArrays");
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

	private List<AArrayOfDPartArraysEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				if ((gethasExtensionPDF_VT2() == true)) {
					return getEntries1_6();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getEntries1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfDPartArraysEntry> getEntries1_6() {
		List<AArrayOfDPartArraysEntry> list = new LinkedList<>();
		for (int i = 0; i < baseObject.size(); i++) {
			COSObject object = baseObject.at(i);
			list.add(new GFAArrayOfDPartArraysEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, String.valueOf(i)));
		}
		return Collections.unmodifiableList(list);
	}

}
