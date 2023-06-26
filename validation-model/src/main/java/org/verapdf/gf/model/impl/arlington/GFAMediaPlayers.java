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

public class GFAMediaPlayers extends GFAObject implements AMediaPlayers {

	public GFAMediaPlayers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMediaPlayers");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A":
				return getA();
			case "MU":
				return getMU();
			case "NU":
				return getNU();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfMediaPlayerInfo> getA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfMediaPlayerInfo> getA1_5() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfMediaPlayerInfo> list = new ArrayList<>(1);
			list.add(new GFAArrayOfMediaPlayerInfo((COSArray)object.getDirectBase(), this.baseObject, "A"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfMediaPlayerInfo> getMU() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMU1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfMediaPlayerInfo> getMU1_5() {
		COSObject object = getMUValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfMediaPlayerInfo> list = new ArrayList<>(1);
			list.add(new GFAArrayOfMediaPlayerInfo((COSArray)object.getDirectBase(), this.baseObject, "MU"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfMediaPlayerInfo> getNU() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNU1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfMediaPlayerInfo> getNU1_5() {
		COSObject object = getNUValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfMediaPlayerInfo> list = new ArrayList<>(1);
			list.add(new GFAArrayOfMediaPlayerInfo((COSArray)object.getDirectBase(), this.baseObject, "NU"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A"));
	}

	public COSObject getAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object;
	}

	@Override
	public Boolean getAHasTypeArray() {
		COSObject object = getAValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsMU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MU"));
	}

	public COSObject getMUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MU"));
		return object;
	}

	@Override
	public Boolean getMUHasTypeArray() {
		COSObject object = getMUValue();
		return getHasTypeArray(object);
	}

	@Override
	public Long getMUArraySize() {
		COSObject object = getMUValue();
		return getArraySize(object);
	}

	@Override
	public Boolean getcontainsNU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NU"));
	}

	public COSObject getNUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NU"));
		return object;
	}

	@Override
	public Boolean getNUHasTypeArray() {
		COSObject object = getNUValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		return getNameValue(object);
	}

}
