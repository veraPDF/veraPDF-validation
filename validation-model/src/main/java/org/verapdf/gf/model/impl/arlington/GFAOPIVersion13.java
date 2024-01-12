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

public class GFAOPIVersion13 extends GFAObject implements AOPIVersion13 {

	public GFAOPIVersion13(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOPIVersion13");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry13":
				return getentry13();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AOPIVersion13Dict> getentry13() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry131_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOPIVersion13Dict> getentry131_2() {
		COSObject object = getentry13Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOPIVersion13Dict> list = new ArrayList<>(1);
			list.add(new GFAOPIVersion13Dict((COSDictionary)object.getDirectBase(), this.baseObject, "1.3"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontains13() {
		return this.baseObject.knownKey(ASAtom.getASAtom("1.3"));
	}

	public COSObject getentry13Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("1.3"));
		return object;
	}

	@Override
	public String getentry13Type() {
		COSObject entry13 = getentry13Value();
		return getObjectType(entry13);
	}

	@Override
	public Boolean getentry13HasTypeDictionary() {
		COSObject entry13 = getentry13Value();
		return getHasTypeDictionary(entry13);
	}

}