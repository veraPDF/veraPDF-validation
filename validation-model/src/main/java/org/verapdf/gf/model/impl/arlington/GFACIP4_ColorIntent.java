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

public class GFACIP4_ColorIntent extends GFAObject implements ACIP4_ColorIntent {

	public GFACIP4_ColorIntent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_ColorIntent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_Coatings":
				return getCIP4_Coatings();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_Coatings> getCIP4_Coatings() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCIP4_Coatings1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_Coatings> getCIP4_Coatings1_7() {
		COSObject object = getCIP4_CoatingsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_Coatings> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_Coatings((COSArray)object.getDirectBase(), this.baseObject, "CIP4_Coatings"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_Coatings() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Coatings"));
	}

	public COSObject getCIP4_CoatingsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Coatings"));
		return object;
	}

	@Override
	public String getCIP4_CoatingsType() {
		COSObject CIP4_Coatings = getCIP4_CoatingsValue();
		return getObjectType(CIP4_Coatings);
	}

	@Override
	public Boolean getCIP4_CoatingsHasTypeArray() {
		COSObject CIP4_Coatings = getCIP4_CoatingsValue();
		return getHasTypeArray(CIP4_Coatings);
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
