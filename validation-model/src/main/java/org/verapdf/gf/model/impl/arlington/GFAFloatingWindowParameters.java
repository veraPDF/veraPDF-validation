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
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFAFloatingWindowParameters extends GFAObject implements AFloatingWindowParameters {

	public GFAFloatingWindowParameters(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFloatingWindowParameters");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "D":
				return getD();
			case "TT":
				return getTT();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_2Integers> getD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Integers> getD1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Integers((COSArray)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsText> getTT() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTT1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getTT1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TT"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "TT"));
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
	public Boolean getDHasTypeArray() {
		COSObject object = getDValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getODefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
	}

	public COSObject getOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null || object.empty()) {
			object = getODefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getOHasTypeInteger() {
		COSObject object = getOValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getOIntegerValue() {
		COSObject object = getOValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(4L);
		}
		return null;
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			object = getPDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPHasTypeInteger() {
		COSObject object = getPValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPIntegerValue() {
		COSObject object = getPValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object == null || object.empty()) {
			object = getRDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject object = getRValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRIntegerValue() {
		COSObject object = getRValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsRT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RT"));
	}

	public COSObject getRTDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getRTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RT"));
		if (object == null || object.empty()) {
			object = getRTDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRTHasTypeInteger() {
		COSObject object = getRTValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRTIntegerValue() {
		COSObject object = getRTValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		if (object == null || object.empty()) {
			object = getTDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getTHasTypeBoolean() {
		COSObject object = getTValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getTBooleanValue() {
		COSObject object = getTValue();
		if (object != null && object.getType() == COSObjType.COS_BOOLEAN) {
			return object.getBoolean();
		}
		return null;
	}

	@Override
	public Boolean getcontainsTT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TT"));
	}

	public COSObject getTTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TT"));
		return object;
	}

	@Override
	public Boolean getTTHasTypeArray() {
		COSObject object = getTTValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsUC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UC"));
	}

	public COSObject getUCDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getUCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UC"));
		if (object == null || object.empty()) {
			object = getUCDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getUCHasTypeBoolean() {
		COSObject object = getUCValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Long getD1IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject D = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (D == null || D.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (D.size() <= 1) {
			return null;
		}
		COSObject entry1 = D.at(1);
		return new GFAArrayOf_2Integers(D.getDirectBase(), null, null).getentry1IntegerValue();
	}

	@Override
	public Long getD0IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject D = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (D == null || D.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (D.size() <= 0) {
			return null;
		}
		COSObject entry0 = D.at(0);
		return new GFAArrayOf_2Integers(D.getDirectBase(), null, null).getentry0IntegerValue();
	}

	@Override
	public Boolean getD1HasTypeInteger() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject D = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (D == null || D.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (D.size() <= 1) {
			return null;
		}
		COSObject entry1 = D.at(1);
		return new GFAArrayOf_2Integers(D.getDirectBase(), null, null).getentry1HasTypeInteger();
	}

	@Override
	public Boolean getD0HasTypeInteger() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject D = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (D == null || D.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (D.size() <= 0) {
			return null;
		}
		COSObject entry0 = D.at(0);
		return new GFAArrayOf_2Integers(D.getDirectBase(), null, null).getentry0HasTypeInteger();
	}

}
