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

public class GFAOutline extends GFAObject implements AOutline {

	public GFAOutline(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOutline");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "First":
				return getFirst();
			case "Last":
				return getLast();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AOutlineItem> getFirst() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFirst1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOutlineItem> getFirst1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("First"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOutlineItem> list = new ArrayList<>(1);
			list.add(new GFAOutlineItem((COSDictionary)object.getDirectBase(), this.baseObject, "First"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOutlineItem> getLast() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLast1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOutlineItem> getLast1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Last"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOutlineItem> list = new ArrayList<>(1);
			list.add(new GFAOutlineItem((COSDictionary)object.getDirectBase(), this.baseObject, "Last"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCount() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Count"));
	}

	@Override
	public Boolean getCountHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Count"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getCountIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Count"));
		if (object == null || object.empty()) {
			return getCountIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getCountIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsFirst() {
		return this.baseObject.knownKey(ASAtom.getASAtom("First"));
	}

	@Override
	public Boolean getisFirstIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("First"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFirstHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("First"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsLast() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Last"));
	}

	@Override
	public Boolean getisLastIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Last"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getLastHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Last"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

}
