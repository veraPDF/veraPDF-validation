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

public class GFAArrayOf_4AnnotBorderCharacteristics extends GFAObject implements AArrayOf_4AnnotBorderCharacteristics {

	public GFAArrayOf_4AnnotBorderCharacteristics(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_4AnnotBorderCharacteristics");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry3":
				return getentry3();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_2DashNumbers> getentry3() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry31_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2DashNumbers> getentry31_1() {
		COSObject object = getentry3Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2DashNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2DashNumbers((COSArray)object.getDirectBase(), this.baseObject, "3"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		COSObject entry0 = getentry0Value();
		return getHasTypeNumber(entry0);
	}

	@Override
	public Double getentry0NumberValue() {
		COSObject entry0 = getentry0Value();
		return getNumberValue(entry0);
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		COSObject entry1 = getentry1Value();
		return getHasTypeNumber(entry1);
	}

	@Override
	public Double getentry1NumberValue() {
		COSObject entry1 = getentry1Value();
		return getNumberValue(entry1);
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject entry2 = getentry2Value();
		return getHasTypeNumber(entry2);
	}

	@Override
	public Double getentry2NumberValue() {
		COSObject entry2 = getentry2Value();
		return getNumberValue(entry2);
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getentry3HasTypeArray() {
		COSObject entry3 = getentry3Value();
		return getHasTypeArray(entry3);
	}

}
