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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CO"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DR"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Fields"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFA"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFA"));
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

	@Override
	public Boolean getCOHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CO"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsDA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DA"));
	}

	@Override
	public Boolean getDAHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DA"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsDR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DR"));
	}

	@Override
	public Boolean getDRHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DR"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsFields() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Fields"));
	}

	@Override
	public Boolean getFieldsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Fields"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsNeedAppearances() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NeedAppearances"));
	}

	@Override
	public Boolean getNeedAppearancesHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NeedAppearances"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsQ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Q"));
	}

	@Override
	public Boolean getQHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Q"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getQIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Q"));
		if (object == null || object.empty()) {
			return getQIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getQIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSigFlags() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SigFlags"));
	}

	@Override
	public Boolean getSigFlagsHasTypeBitmask() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigFlags"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getSigFlagsBitmaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigFlags"));
		if (object == null || object.empty()) {
			return getSigFlagsBitmaskDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getSigFlagsBitmaskDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsXFA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XFA"));
	}

	@Override
	public Boolean getisXFAIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFA"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getXFAHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFA"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getXFAHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XFA"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
