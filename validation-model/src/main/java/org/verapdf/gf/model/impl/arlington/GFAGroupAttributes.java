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

public class GFAGroupAttributes extends GFAObject implements AGroupAttributes {

	public GFAGroupAttributes(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AGroupAttributes");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CS":
				return getCS();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getCS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCS1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getCS1_4() {
		COSObject object = getCSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getCSArray1_4(object.getDirectBase(), "CS");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getCSArray1_4(COSBase base, String keyName) {
		if (base.size() <= 0) {
			return null;
		}
		COSObject subtype = base.at(0);
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			case "ICCBased":
				return new GFAICCBasedColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CS"));
	}

	public COSObject getCSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CS"));
		return object;
	}

	@Override
	public String getCSType() {
		COSObject CS = getCSValue();
		return getObjectType(CS);
	}

	@Override
	public Boolean getCSHasTypeArray() {
		COSObject CS = getCSValue();
		return getHasTypeArray(CS);
	}

	@Override
	public Boolean getCSHasTypeName() {
		COSObject CS = getCSValue();
		return getHasTypeName(CS);
	}

	@Override
	public String getCSNameValue() {
		COSObject CS = getCSValue();
		return getNameValue(CS);
	}

	@Override
	public Boolean getcontainsI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("I"));
	}

	public COSObject getIDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("I"));
		if (object == null || object.empty()) {
			object = getIDefaultValue();
		}
		return object;
	}

	@Override
	public String getIType() {
		COSObject I = getIValue();
		return getObjectType(I);
	}

	@Override
	public Boolean getIHasTypeBoolean() {
		COSObject I = getIValue();
		return getHasTypeBoolean(I);
	}

	@Override
	public Boolean getcontainsK() {
		return this.baseObject.knownKey(ASAtom.getASAtom("K"));
	}

	public COSObject getKDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getKValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("K"));
		if (object == null || object.empty()) {
			object = getKDefaultValue();
		}
		return object;
	}

	@Override
	public String getKType() {
		COSObject K = getKValue();
		return getObjectType(K);
	}

	@Override
	public Boolean getKHasTypeBoolean() {
		COSObject K = getKValue();
		return getHasTypeBoolean(K);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object;
	}

	@Override
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject S = getSValue();
		return getHasTypeName(S);
	}

	@Override
	public String getSNameValue() {
		COSObject S = getSValue();
		return getNameValue(S);
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