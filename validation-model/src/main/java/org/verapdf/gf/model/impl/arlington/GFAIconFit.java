package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import java.io.IOException;

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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
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

	@Override
	public Boolean getAHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsSW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SW"));
	}

	@Override
	public Boolean getSWHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SW"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSWNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SW"));
		if (object == null || object.empty()) {
			return getSWNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSWNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "A";
		}
		return null;
	}

	@Override
	public Boolean getcontainsFB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FB"));
	}

	@Override
	public Boolean getFBHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FB"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			return getSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "P";
		}
		return null;
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
}
