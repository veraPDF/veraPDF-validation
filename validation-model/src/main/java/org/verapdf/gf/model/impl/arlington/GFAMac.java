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

public class GFAMac extends GFAObject implements AMac {

	public GFAMac(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMac");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ResFork":
				return getResFork();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStream> getResFork() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResFork1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getResFork1_3() {
		COSObject object = getResForkValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "ResFork"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCreator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Creator"));
	}

	public COSObject getCreatorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Creator"));
		return object;
	}

	@Override
	public Boolean getCreatorHasTypeInteger() {
		COSObject Creator = getCreatorValue();
		return getHasTypeInteger(Creator);
	}

	@Override
	public Boolean getcontainsResFork() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ResFork"));
	}

	public COSObject getResForkValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ResFork"));
		return object;
	}

	@Override
	public Boolean getisResForkIndirect() {
		COSObject ResFork = getResForkValue();
		return getisIndirect(ResFork);
	}

	@Override
	public Boolean getResForkHasTypeStream() {
		COSObject ResFork = getResForkValue();
		return getHasTypeStream(ResFork);
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public Boolean getSubtypeHasTypeInteger() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeInteger(Subtype);
	}

}
