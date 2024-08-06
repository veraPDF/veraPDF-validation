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

public class GFACIP4_HolePattern extends GFAObject implements ACIP4_HolePattern {

	public GFACIP4_HolePattern(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_HolePattern");
	}

	@Override
	public Boolean getcontainsCIP4_HoleReferenceEdge() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_HoleReferenceEdge"));
	}

	public COSObject getCIP4_HoleReferenceEdgeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_HoleReferenceEdge"));
		return object;
	}

	@Override
	public String getCIP4_HoleReferenceEdgeType() {
		COSObject CIP4_HoleReferenceEdge = getCIP4_HoleReferenceEdgeValue();
		return getObjectType(CIP4_HoleReferenceEdge);
	}

	@Override
	public Boolean getCIP4_HoleReferenceEdgeHasTypeName() {
		COSObject CIP4_HoleReferenceEdge = getCIP4_HoleReferenceEdgeValue();
		return getHasTypeName(CIP4_HoleReferenceEdge);
	}

	@Override
	public String getCIP4_HoleReferenceEdgeNameValue() {
		COSObject CIP4_HoleReferenceEdge = getCIP4_HoleReferenceEdgeValue();
		return getNameValue(CIP4_HoleReferenceEdge);
	}

	@Override
	public Boolean getcontainsCIP4_Pattern() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Pattern"));
	}

	public COSObject getCIP4_PatternValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Pattern"));
		return object;
	}

	@Override
	public String getCIP4_PatternType() {
		COSObject CIP4_Pattern = getCIP4_PatternValue();
		return getObjectType(CIP4_Pattern);
	}

	@Override
	public Boolean getCIP4_PatternHasTypeName() {
		COSObject CIP4_Pattern = getCIP4_PatternValue();
		return getHasTypeName(CIP4_Pattern);
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
