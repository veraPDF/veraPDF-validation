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

public class GFAOOAdditionalStmsArray extends GFAObject implements AOOAdditionalStmsArray {

	public GFAOOAdditionalStmsArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOOAdditionalStmsArray");
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

	private List<AOOAdditionalStmsArraySubArray> getsubArrays() {
		return getsubArrays1_0();
	}

	private List<AOOAdditionalStmsArraySubArray> getsubArrays1_0() {
		List<AOOAdditionalStmsArraySubArray> list = new LinkedList<>();
		COSObject array = COSArray.construct();
		for (int i = 0; i < baseObject.size(); i++) {
			COSObject child = baseObject.at(i);
			array.add(child);
			if (array.size() == 2) {
				list.add(new GFAOOAdditionalStmsArraySubArray(array.getDirectBase(), this.parentObject, null));
				array = COSArray.construct();
			}
		}
		if (array.size() > 0) {
			list.add(new GFAOOAdditionalStmsArraySubArray(array.getDirectBase(), this.parentObject, null));
		}
		return Collections.unmodifiableList(list);
	}

}
