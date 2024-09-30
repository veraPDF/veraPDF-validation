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

public class GFACIP4_LayoutIntent extends GFAObject implements ACIP4_LayoutIntent {

	public GFACIP4_LayoutIntent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_LayoutIntent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_FinishedDimensions":
				return getCIP4_FinishedDimensions();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_FinishedDimensions> getCIP4_FinishedDimensions() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_FinishedDimensions1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_FinishedDimensions> getCIP4_FinishedDimensions1_7() {
		COSObject object = getCIP4_FinishedDimensionsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_FinishedDimensions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_FinishedDimensions((COSArray)object.getDirectBase(), this.baseObject, "CIP4_FinishedDimensions"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_FinishedDimensions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_FinishedDimensions"));
	}

	public COSObject getCIP4_FinishedDimensionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_FinishedDimensions"));
		return object;
	}

	@Override
	public String getCIP4_FinishedDimensionsType() {
		COSObject CIP4_FinishedDimensions = getCIP4_FinishedDimensionsValue();
		return getObjectType(CIP4_FinishedDimensions);
	}

	@Override
	public Boolean getCIP4_FinishedDimensionsHasTypeArray() {
		COSObject CIP4_FinishedDimensions = getCIP4_FinishedDimensionsValue();
		return getHasTypeArray(CIP4_FinishedDimensions);
	}

	@Override
	public Boolean getcontainsCIP4_Sides() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Sides"));
	}

	public COSObject getCIP4_SidesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Sides"));
		return object;
	}

	@Override
	public String getCIP4_SidesType() {
		COSObject CIP4_Sides = getCIP4_SidesValue();
		return getObjectType(CIP4_Sides);
	}

	@Override
	public Boolean getCIP4_SidesHasTypeName() {
		COSObject CIP4_Sides = getCIP4_SidesValue();
		return getHasTypeName(CIP4_Sides);
	}

	@Override
	public String getCIP4_SidesNameValue() {
		COSObject CIP4_Sides = getCIP4_SidesValue();
		return getNameValue(CIP4_Sides);
	}

	@Override
	public Boolean getcontainsCIP4_SpreadType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_SpreadType"));
	}

	public COSObject getCIP4_SpreadTypeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("SinglePage");
		}
		return null;
	}

	public COSObject getCIP4_SpreadTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_SpreadType"));
		if (object == null || object.empty()) {
			object = getCIP4_SpreadTypeDefaultValue();
		}
		return object;
	}

	@Override
	public String getCIP4_SpreadTypeType() {
		COSObject CIP4_SpreadType = getCIP4_SpreadTypeValue();
		return getObjectType(CIP4_SpreadType);
	}

	@Override
	public Boolean getCIP4_SpreadTypeHasTypeName() {
		COSObject CIP4_SpreadType = getCIP4_SpreadTypeValue();
		return getHasTypeName(CIP4_SpreadType);
	}

	@Override
	public String getCIP4_SpreadTypeNameValue() {
		COSObject CIP4_SpreadType = getCIP4_SpreadTypeValue();
		return getNameValue(CIP4_SpreadType);
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
