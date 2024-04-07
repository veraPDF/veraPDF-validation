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

public class GFANameTreeNodeNamesArray extends GFAObject implements ANameTreeNodeNamesArray {

	public GFANameTreeNodeNamesArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANameTreeNodeNamesArray");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "subArrays":
				return getsubArrays();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ANameTreeNodeNamesArraySubArray> getsubArrays() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getsubArrays1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNodeNamesArraySubArray> getsubArrays1_2() {
		List<ANameTreeNodeNamesArraySubArray> list = new LinkedList<>();
		COSObject array = COSArray.construct();
		for (int i = 0; i < baseObject.size(); i++) {
			COSObject child = baseObject.at(i);
			array.add(child);
			if (array.size() == 2) {
				list.add(new GFANameTreeNodeNamesArraySubArray(array.getDirectBase(), this.parentObject, null));
				array = COSArray.construct();
			}
		}
		if (array.size() > 0) {
			list.add(new GFANameTreeNodeNamesArraySubArray(array.getDirectBase(), this.parentObject, null));
		}
		return Collections.unmodifiableList(list);
	}

}
