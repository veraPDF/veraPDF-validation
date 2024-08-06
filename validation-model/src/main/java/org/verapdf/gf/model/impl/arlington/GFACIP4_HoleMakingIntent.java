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

public class GFACIP4_HoleMakingIntent extends GFAObject implements ACIP4_HoleMakingIntent {

	public GFACIP4_HoleMakingIntent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_HoleMakingIntent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_HolePattern":
				return getCIP4_HolePattern();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_HolePattern> getCIP4_HolePattern() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_HolePattern1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_HolePattern> getCIP4_HolePattern1_7() {
		COSObject object = getCIP4_HolePatternValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_HolePattern> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_HolePattern((COSArray)object.getDirectBase(), this.baseObject, "CIP4_HolePattern"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_HolePattern() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_HolePattern"));
	}

	public COSObject getCIP4_HolePatternValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_HolePattern"));
		return object;
	}

	@Override
	public String getCIP4_HolePatternType() {
		COSObject CIP4_HolePattern = getCIP4_HolePatternValue();
		return getObjectType(CIP4_HolePattern);
	}

	@Override
	public Boolean getCIP4_HolePatternHasTypeArray() {
		COSObject CIP4_HolePattern = getCIP4_HolePatternValue();
		return getHasTypeArray(CIP4_HolePattern);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

}
