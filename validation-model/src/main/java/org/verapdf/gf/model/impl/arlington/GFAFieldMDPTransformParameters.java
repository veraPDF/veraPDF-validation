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

public class GFAFieldMDPTransformParameters extends GFAObject implements AFieldMDPTransformParameters {

	public GFAFieldMDPTransformParameters(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFieldMDPTransformParameters");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Fields":
				return getFields();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStringsText> getFields() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFields1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getFields1_5() {
		COSObject object = getFieldsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "Fields"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAction() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Action"));
	}

	public COSObject getActionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Action"));
		return object;
	}

	@Override
	public String getActionType() {
		COSObject Action = getActionValue();
		return getObjectType(Action);
	}

	@Override
	public Boolean getActionHasTypeName() {
		COSObject Action = getActionValue();
		return getHasTypeName(Action);
	}

	@Override
	public String getActionNameValue() {
		COSObject Action = getActionValue();
		return getNameValue(Action);
	}

	@Override
	public Boolean getcontainsFields() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Fields"));
	}

	public COSObject getFieldsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Fields"));
		return object;
	}

	@Override
	public String getFieldsType() {
		COSObject Fields = getFieldsValue();
		return getObjectType(Fields);
	}

	@Override
	public Boolean getFieldsHasTypeArray() {
		COSObject Fields = getFieldsValue();
		return getHasTypeArray(Fields);
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

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("1.2");
		}
		return null;
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		if (object == null || object.empty()) {
			object = getVDefaultValue();
		}
		return object;
	}

	@Override
	public String getVType() {
		COSObject V = getVValue();
		return getObjectType(V);
	}

	@Override
	public Boolean getVHasTypeName() {
		COSObject V = getVValue();
		return getHasTypeName(V);
	}

	@Override
	public String getVNameValue() {
		COSObject V = getVValue();
		return getNameValue(V);
	}

}
