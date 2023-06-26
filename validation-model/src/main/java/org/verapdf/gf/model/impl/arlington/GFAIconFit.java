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
	public Boolean getAHasTypeArray() {
		COSObject object = getAValue();
		return getHasTypeArray(object);
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
	public Boolean getFBHasTypeBoolean() {
		COSObject object = getFBValue();
		return getHasTypeBoolean(object);
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
	public Boolean getSHasTypeName() {
		COSObject object = getSValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSNameValue() {
		COSObject object = getSValue();
		return getNameValue(object);
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
	public Boolean getSWHasTypeName() {
		COSObject object = getSWValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSWNameValue() {
		COSObject object = getSWValue();
		return getNameValue(object);
	}

	@Override
	public Double getA1NumberValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject A = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (A == null || A.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (A.size() <= 1) {
			return null;
		}
		COSObject entry1 = A.at(1);
		return new GFAArrayOf_2Numbers(A.getDirectBase(), null, null).getentry1NumberValue();
	}

	@Override
	public Double getA0NumberValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject A = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (A == null || A.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (A.size() <= 0) {
			return null;
		}
		COSObject entry0 = A.at(0);
		return new GFAArrayOf_2Numbers(A.getDirectBase(), null, null).getentry0NumberValue();
	}

	@Override
	public Boolean getA1HasTypeNumber() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject A = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (A == null || A.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (A.size() <= 1) {
			return null;
		}
		COSObject entry1 = A.at(1);
		return new GFAArrayOf_2Numbers(A.getDirectBase(), null, null).getentry1HasTypeNumber();
	}

	@Override
	public Boolean getA0HasTypeNumber() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject A = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (A == null || A.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (A.size() <= 0) {
			return null;
		}
		COSObject entry0 = A.at(0);
		return new GFAArrayOf_2Numbers(A.getDirectBase(), null, null).getentry0HasTypeNumber();
	}

}
