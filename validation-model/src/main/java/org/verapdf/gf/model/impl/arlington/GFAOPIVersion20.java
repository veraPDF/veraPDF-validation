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

public class GFAOPIVersion20 extends GFAObject implements AOPIVersion20 {

	public GFAOPIVersion20(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOPIVersion20");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry20":
				return getentry20();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AOPIVersion20Dict> getentry20() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry201_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOPIVersion20Dict> getentry201_2() {
		COSObject object = getentry20Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOPIVersion20Dict> list = new ArrayList<>(1);
			list.add(new GFAOPIVersion20Dict((COSDictionary)object.getDirectBase(), this.baseObject, "2.0"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontains20() {
		return this.baseObject.knownKey(ASAtom.getASAtom("2.0"));
	}

	public COSObject getentry20Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("2.0"));
		return object;
	}

	@Override
	public Boolean getentry20HasTypeDictionary() {
		COSObject entry20 = getentry20Value();
		return getHasTypeDictionary(entry20);
	}

}
