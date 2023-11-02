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

public class GFAIconFit extends GFAObject implements AIconFit {

	public GFAIconFit(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AIconFit");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A":
				return getA();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_2Numbers> getA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getA1_3() {
		COSObject object = getAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "A"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A"));
	}

	public COSObject getAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object;
	}

	@Override
	public String getAType() {
		COSObject A = getAValue();
		return getObjectType(A);
	}

	@Override
	public Boolean getAHasTypeArray() {
		COSObject A = getAValue();
		return getHasTypeArray(A);
	}

	@Override
	public Boolean getcontainsFB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FB"));
	}

	public COSObject getFBDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getFBValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FB"));
		if (object == null || object.empty()) {
			object = getFBDefaultValue();
		}
		return object;
	}

	@Override
	public String getFBType() {
		COSObject FB = getFBValue();
		return getObjectType(FB);
	}

	@Override
	public Boolean getFBHasTypeBoolean() {
		COSObject FB = getFBValue();
		return getHasTypeBoolean(FB);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("P");
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
	public Boolean getcontainsSW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SW"));
	}

	public COSObject getSWDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("A");
		}
		return null;
	}

	public COSObject getSWValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SW"));
		if (object == null || object.empty()) {
			object = getSWDefaultValue();
		}
		return object;
	}

	@Override
	public String getSWType() {
		COSObject SW = getSWValue();
		return getObjectType(SW);
	}

	@Override
	public Boolean getSWHasTypeName() {
		COSObject SW = getSWValue();
		return getHasTypeName(SW);
	}

	@Override
	public String getSWNameValue() {
		COSObject SW = getSWValue();
		return getNameValue(SW);
	}

	@Override
	public Double getA0NumberValue() {
		COSObject A = getAValue();
		if (A == null || A.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (A.size() <= 0) {
			return null;
		}
		return new GFAArrayOf_2Numbers(A.getDirectBase(), null, null).getentry0NumberValue();
	}

	@Override
	public Double getA1NumberValue() {
		COSObject A = getAValue();
		if (A == null || A.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (A.size() <= 1) {
			return null;
		}
		return new GFAArrayOf_2Numbers(A.getDirectBase(), null, null).getentry1NumberValue();
	}

	@Override
	public Boolean getA0HasTypeNumber() {
		COSObject A = getAValue();
		if (A == null || A.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (A.size() <= 0) {
			return null;
		}
		return new GFAArrayOf_2Numbers(A.getDirectBase(), null, null).getentry0HasTypeNumber();
	}

	@Override
	public Boolean getA1HasTypeNumber() {
		COSObject A = getAValue();
		if (A == null || A.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (A.size() <= 1) {
			return null;
		}
		return new GFAArrayOf_2Numbers(A.getDirectBase(), null, null).getentry1HasTypeNumber();
	}

}
