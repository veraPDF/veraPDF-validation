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

public class GFAExDataProjection extends GFAObject implements AExDataProjection {

	public GFAExDataProjection(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AExDataProjection");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "M3DREF":
				return getM3DREF();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getM3DREF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getM3DREF1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getM3DREF1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getM3DREF1_7() {
		COSObject object = getM3DREFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getM3DREFDictionary1_7(object.getDirectBase(), "M3DREF");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getM3DREFDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "3DC":
				return new GFA3DMeasure3DC(base, this.baseObject, keyName);
			case "AD3":
				return new GFA3DMeasureAD3(base, this.baseObject, keyName);
			case "LD3":
				return new GFA3DMeasureLD3(base, this.baseObject, keyName);
			case "PD3":
				return new GFA3DMeasurePD3(base, this.baseObject, keyName);
			case "RD3":
				return new GFA3DMeasureRD3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsM3DREF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M3DREF"));
	}

	public COSObject getM3DREFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M3DREF"));
		return object;
	}

	@Override
	public Boolean getisM3DREFIndirect() {
		COSObject M3DREF = getM3DREFValue();
		return getisIndirect(M3DREF);
	}

	@Override
	public String getM3DREFType() {
		COSObject M3DREF = getM3DREFValue();
		return getObjectType(M3DREF);
	}

	@Override
	public Boolean getM3DREFHasTypeDictionary() {
		COSObject M3DREF = getM3DREFValue();
		return getHasTypeDictionary(M3DREF);
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
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
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
