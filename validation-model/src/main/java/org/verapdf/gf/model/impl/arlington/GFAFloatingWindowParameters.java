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
		COSObject object = getDValue();
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
		COSObject object = getTTValue();
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
	public String getOType() {
		COSObject O = getOValue();
		return getObjectType(O);
	}

	@Override
	public Boolean getOHasTypeInteger() {
		COSObject O = getOValue();
		return getHasTypeInteger(O);
	}

	@Override
	public Long getOIntegerValue() {
		COSObject O = getOValue();
		return getIntegerValue(O);
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
	public String getPType() {
		COSObject P = getPValue();
		return getObjectType(P);
	}

	@Override
	public Boolean getPHasTypeInteger() {
		COSObject P = getPValue();
		return getHasTypeInteger(P);
	}

	@Override
	public Long getPIntegerValue() {
		COSObject P = getPValue();
		return getIntegerValue(P);
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
	public String getRType() {
		COSObject R = getRValue();
		return getObjectType(R);
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject R = getRValue();
		return getHasTypeInteger(R);
	}

	@Override
	public Long getRIntegerValue() {
		COSObject R = getRValue();
		return getIntegerValue(R);
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
	public String getRTType() {
		COSObject RT = getRTValue();
		return getObjectType(RT);
	}

	@Override
	public Boolean getRTHasTypeInteger() {
		COSObject RT = getRTValue();
		return getHasTypeInteger(RT);
	}

	@Override
	public Long getRTIntegerValue() {
		COSObject RT = getRTValue();
		return getIntegerValue(RT);
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
	public String getTType() {
		COSObject T = getTValue();
		return getObjectType(T);
	}

	@Override
	public Boolean getTHasTypeBoolean() {
		COSObject T = getTValue();
		return getHasTypeBoolean(T);
	}

	@Override
	public Boolean getTBooleanValue() {
		COSObject T = getTValue();
		return getBooleanValue(T);
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
	public String getTTType() {
		COSObject TT = getTTValue();
		return getObjectType(TT);
	}

	@Override
	public Boolean getTTHasTypeArray() {
		COSObject TT = getTTValue();
		return getHasTypeArray(TT);
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
	public String getUCType() {
		COSObject UC = getUCValue();
		return getObjectType(UC);
	}

	@Override
	public Boolean getUCHasTypeBoolean() {
		COSObject UC = getUCValue();
		return getHasTypeBoolean(UC);
	}

	@Override
	public Long getD0IntegerValue() {
		COSObject D = getDValue();
		if (D == null || D.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (D.size() <= 0) {
			return null;
		}
		return new GFAArrayOf_2Integers(D.getDirectBase(), null, null).getentry0IntegerValue();
	}

	@Override
	public Long getD1IntegerValue() {
		COSObject D = getDValue();
		if (D == null || D.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (D.size() <= 1) {
			return null;
		}
		return new GFAArrayOf_2Integers(D.getDirectBase(), null, null).getentry1IntegerValue();
	}

	@Override
	public Boolean getD0HasTypeInteger() {
		COSObject D = getDValue();
		if (D == null || D.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (D.size() <= 0) {
			return null;
		}
		return new GFAArrayOf_2Integers(D.getDirectBase(), null, null).getentry0HasTypeInteger();
	}

	@Override
	public Boolean getD1HasTypeInteger() {
		COSObject D = getDValue();
		if (D == null || D.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (D.size() <= 1) {
			return null;
		}
		return new GFAArrayOf_2Integers(D.getDirectBase(), null, null).getentry1HasTypeInteger();
	}

}
