package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFAInteractiveForm extends GFAObject implements AInteractiveForm {

	public GFAInteractiveForm(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AInteractiveForm");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CO":
				return getCO();
			case "DR":
				return getDR();
			case "Fields":
				return getFields();
			case "XFA":
				return getXFA();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfFields> getCO() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCO1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFields> getCO1_3() {
		COSObject object = getCOValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFields> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFields((COSArray)object.getDirectBase(), this.baseObject, "CO"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AResource> getDR() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDR1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AResource> getDR1_2() {
		COSObject object = getDRValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AResource> list = new ArrayList<>(1);
			list.add(new GFAResource((COSDictionary)object.getDirectBase(), this.baseObject, "DR"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfFields> getFields() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFields1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFields> getFields1_2() {
		COSObject object = getFieldsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFields> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFields((COSArray)object.getDirectBase(), this.baseObject, "Fields"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getXFA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
				return getXFA1_5();
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getXFA1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getXFA1_5() {
		COSObject object = getXFAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "XFA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getXFA1_6() {
		COSObject object = getXFAValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfXFA> list = new ArrayList<>(1);
			list.add(new GFAArrayOfXFA((COSArray)object.getDirectBase(), this.baseObject, "XFA"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "XFA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CO"));
	}

	public COSObject getCOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CO"));
		return object;
	}

	@Override
	public Boolean getCOHasTypeArray() {
		COSObject object = getCOValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsDA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DA"));
	}

	public COSObject getDAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DA"));
		return object;
	}

	@Override
	public Boolean getDAHasTypeString() {
		COSObject object = getDAValue();
		return getHasTypeString(object);
	}

	@Override
	public Boolean getcontainsDR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DR"));
	}

	public COSObject getDRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DR"));
		return object;
	}

	@Override
	public Boolean getDRHasTypeDictionary() {
		COSObject object = getDRValue();
		return getHasTypeDictionary(object);
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
	public Boolean getFieldsHasTypeArray() {
		COSObject object = getFieldsValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsNeedAppearances() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NeedAppearances"));
	}

	public COSObject getNeedAppearancesDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getNeedAppearancesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NeedAppearances"));
		if (object == null || object.empty()) {
			object = getNeedAppearancesDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getNeedAppearancesHasTypeBoolean() {
		COSObject object = getNeedAppearancesValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsQ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Q"));
	}

	public COSObject getQValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Q"));
		return object;
	}

	@Override
	public Boolean getQHasTypeInteger() {
		COSObject object = getQValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getQIntegerValue() {
		COSObject object = getQValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSigFlags() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SigFlags"));
	}

	public COSObject getSigFlagsDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getSigFlagsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigFlags"));
		if (object == null || object.empty()) {
			object = getSigFlagsDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSigFlagsHasTypeBitmask() {
		COSObject object = getSigFlagsValue();
		return getHasTypeBitmask(object);
	}

	@Override
	public Long getSigFlagsBitmaskValue() {
		COSObject object = getSigFlagsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsXFA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XFA"));
	}

	public COSObject getXFAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFA"));
		return object;
	}

	@Override
	public Boolean getisXFAIndirect() {
		COSObject object = getXFAValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getXFAHasTypeArray() {
		COSObject object = getXFAValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getXFAHasTypeStream() {
		COSObject object = getXFAValue();
		return getHasTypeStream(object);
	}

}
