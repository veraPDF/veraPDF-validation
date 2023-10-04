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

public class GFAGeographicCoordinateSystem extends GFAObject implements AGeographicCoordinateSystem {

	public GFAGeographicCoordinateSystem(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AGeographicCoordinateSystem");
	}

	@Override
	public Boolean getcontainsEPSG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EPSG"));
	}

	public COSObject getEPSGValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EPSG"));
		return object;
	}

	@Override
	public Boolean getEPSGHasTypeInteger() {
		COSObject EPSG = getEPSGValue();
		return getHasTypeInteger(EPSG);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsWKT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WKT"));
	}

	public COSObject getWKTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WKT"));
		return object;
	}

	@Override
	public Boolean getWKTHasTypeStringAscii() {
		COSObject WKT = getWKTValue();
		return getHasTypeStringAscii(WKT);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
