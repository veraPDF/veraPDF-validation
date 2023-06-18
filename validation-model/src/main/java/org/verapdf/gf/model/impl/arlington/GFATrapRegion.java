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

public class GFATrapRegion extends GFAObject implements ATrapRegion {

	public GFATrapRegion(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ATrapRegion");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "TZ":
				return getTZ();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_ArrayOfNumbers> getTZ() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTZ1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_ArrayOfNumbers> getTZ1_3() {
		COSObject object = getTZValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_ArrayOfNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_ArrayOfNumbers((COSArray)object.getDirectBase(), this.baseObject, "TZ"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsTP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TP"));
	}

	public COSObject getTPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TP"));
		return object;
	}

	@Override
	public Boolean getTPHasTypeName() {
		COSObject object = getTPValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsTZ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TZ"));
	}

	public COSObject getTZValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TZ"));
		return object;
	}

	@Override
	public Boolean getTZHasTypeArray() {
		COSObject object = getTZValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
