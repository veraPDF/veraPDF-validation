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

public class GFACIP4_BlowIn extends GFAObject implements ACIP4_BlowIn {

	public GFACIP4_BlowIn(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_BlowIn");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_Child":
				return getCIP4_Child();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ADPart> getCIP4_Child() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_Child1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPart> getCIP4_Child1_7() {
		COSObject object = getCIP4_ChildValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADPart> list = new ArrayList<>(1);
			list.add(new GFADPart((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_Child"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_Child() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_Child"));
	}

	public COSObject getCIP4_ChildValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_Child"));
		return object;
	}

	@Override
	public Boolean getisCIP4_ChildIndirect() {
		COSObject CIP4_Child = getCIP4_ChildValue();
		return getisIndirect(CIP4_Child);
	}

	@Override
	public String getCIP4_ChildType() {
		COSObject CIP4_Child = getCIP4_ChildValue();
		return getObjectType(CIP4_Child);
	}

	@Override
	public Boolean getCIP4_ChildHasTypeDictionary() {
		COSObject CIP4_Child = getCIP4_ChildValue();
		return getHasTypeDictionary(CIP4_Child);
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
