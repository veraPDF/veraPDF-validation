package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFAProjectedCoordinateSystem extends GFAObject implements AProjectedCoordinateSystem {

	public GFAProjectedCoordinateSystem(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AProjectedCoordinateSystem");
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
		COSObject object = getEPSGValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
		COSObject object = getWKTValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
