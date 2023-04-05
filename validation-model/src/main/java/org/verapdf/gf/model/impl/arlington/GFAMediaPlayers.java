package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import java.io.IOException;

public class GFAMediaPlayers extends GFAObject implements AMediaPlayers {

	public GFAMediaPlayers(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMediaPlayers");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A":
				return getA();
			case "NU":
				return getNU();
			case "MU":
				return getMU();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfMediaPlayerInfo> getA() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
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

	private List<AArrayOfMediaPlayerInfo> getNU() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NU"));
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

	private List<AArrayOfMediaPlayerInfo> getMU() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MU"));
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

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsNU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NU"));
	}

	@Override
	public Boolean getNUHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NU"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsMU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MU"));
	}

	@Override
	public Boolean getMUHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MU"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getMUArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MU"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A"));
	}

	@Override
	public Boolean getAHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
