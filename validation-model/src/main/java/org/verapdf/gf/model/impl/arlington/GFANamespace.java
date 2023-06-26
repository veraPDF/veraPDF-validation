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

public class GFANamespace extends GFAObject implements ANamespace {

	public GFANamespace(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANamespace");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "RoleMapNS":
				return getRoleMapNS();
			case "Schema":
				return getSchema();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARoleMapNS> getRoleMapNS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getRoleMapNS2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARoleMapNS> getRoleMapNS2_0() {
		COSObject object = getRoleMapNSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARoleMapNS> list = new ArrayList<>(1);
			list.add(new GFARoleMapNS((COSDictionary)object.getDirectBase(), this.baseObject, "RoleMapNS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFileSpecification> getSchema() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSchema2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getSchema2_0() {
		COSObject object = getSchemaValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "Schema"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsNS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NS"));
	}

	public COSObject getNSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NS"));
		return object;
	}

	@Override
	public Boolean getNSHasTypeStringText() {
		COSObject object = getNSValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsRoleMapNS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RoleMapNS"));
	}

	public COSObject getRoleMapNSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RoleMapNS"));
		return object;
	}

	@Override
	public Boolean getRoleMapNSHasTypeDictionary() {
		COSObject object = getRoleMapNSValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsSchema() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Schema"));
	}

	public COSObject getSchemaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Schema"));
		return object;
	}

	@Override
	public Boolean getSchemaHasTypeDictionary() {
		COSObject object = getSchemaValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getSchemaHasTypeString() {
		COSObject object = getSchemaValue();
		return getHasTypeString(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		return getNameValue(object);
	}

}
