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

public class GFAArrayOfOPI2Inks extends GFAObject implements AArrayOfOPI2Inks {

	public GFAArrayOfOPI2Inks(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfOPI2Inks");
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

	private List<AArrayOfOPI2InksSubArray> getsubArrays() {
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

	private List<AArrayOfOPI2InksSubArray> getsubArrays1_2() {
		List<AArrayOfOPI2InksSubArray> list = new LinkedList<>();
		COSObject array = COSArray.construct();
		for (int i = 1; i < baseObject.size(); i++) {
			COSObject child = baseObject.at(i);
			array.add(child);
			if (array.size() == 2) {
				list.add(new GFAArrayOfOPI2InksSubArray(array.getDirectBase(), this.parentObject, null));
				array = COSArray.construct();
			}
		}
		if (array.size() > 0) {
			list.add(new GFAArrayOfOPI2InksSubArray(array.getDirectBase(), this.parentObject, null));
		}
		return Collections.unmodifiableList(list);
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeName() {
		COSObject entry0 = getentry0Value();
		return getHasTypeName(entry0);
	}

	@Override
	public String getentry0NameValue() {
		COSObject entry0 = getentry0Value();
		return getNameValue(entry0);
	}

}
