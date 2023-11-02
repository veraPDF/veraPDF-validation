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

public class GFABorderStyle extends GFAObject implements ABorderStyle {

	public GFABorderStyle(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ABorderStyle");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "D":
				return getD();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfDashPatterns> getD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfDashPatterns> getD1_2() {
		COSObject object = getDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDashPatterns> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDashPatterns((COSArray)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object;
	}

	@Override
	public String getDType() {
		COSObject D = getDValue();
		return getObjectType(D);
	}

	@Override
	public Boolean getDHasTypeArray() {
		COSObject D = getDValue();
		return getHasTypeArray(D);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("S");
		}
		return null;
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			object = getSDefaultValue();
		}
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

	@Override
	public Boolean getcontainsW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("W"));
	}

	public COSObject getWDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getWValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("W"));
		if (object == null || object.empty()) {
			object = getWDefaultValue();
		}
		return object;
	}

	@Override
	public String getWType() {
		COSObject W = getWValue();
		return getObjectType(W);
	}

	@Override
	public Boolean getWHasTypeNumber() {
		COSObject W = getWValue();
		return getHasTypeNumber(W);
	}

	@Override
	public Double getWNumberValue() {
		COSObject W = getWValue();
		return getNumberValue(W);
	}

}
