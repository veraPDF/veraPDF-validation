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

public class GFACIP4_FoldingIntent extends GFAObject implements ACIP4_FoldingIntent {

	public GFACIP4_FoldingIntent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_FoldingIntent");
	}

	@Override
	public Boolean getcontainsCIP4_FoldCatalog() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_FoldCatalog"));
	}

	public COSObject getCIP4_FoldCatalogValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_FoldCatalog"));
		return object;
	}

	@Override
	public String getCIP4_FoldCatalogType() {
		COSObject CIP4_FoldCatalog = getCIP4_FoldCatalogValue();
		return getObjectType(CIP4_FoldCatalog);
	}

	@Override
	public Boolean getCIP4_FoldCatalogHasTypeName() {
		COSObject CIP4_FoldCatalog = getCIP4_FoldCatalogValue();
		return getHasTypeName(CIP4_FoldCatalog);
	}

	@Override
	public String getCIP4_FoldCatalogNameValue() {
		COSObject CIP4_FoldCatalog = getCIP4_FoldCatalogValue();
		return getNameValue(CIP4_FoldCatalog);
	}

	@Override
	public Boolean getcontainsCIP4_Orientation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Orientation"));
	}

	public COSObject getCIP4_OrientationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Orientation"));
		return object;
	}

	@Override
	public String getCIP4_OrientationType() {
		COSObject CIP4_Orientation = getCIP4_OrientationValue();
		return getObjectType(CIP4_Orientation);
	}

	@Override
	public Boolean getCIP4_OrientationHasTypeName() {
		COSObject CIP4_Orientation = getCIP4_OrientationValue();
		return getHasTypeName(CIP4_Orientation);
	}

	@Override
	public String getCIP4_OrientationNameValue() {
		COSObject CIP4_Orientation = getCIP4_OrientationValue();
		return getNameValue(CIP4_Orientation);
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
