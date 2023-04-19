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

public class GFA3DNode extends GFAObject implements A3DNode {

	public GFA3DNode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DNode");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Data":
				return getData();
			case "Instance":
				return getInstance();
			case "M":
				return getM();
			case "RM":
				return getRM();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStream> getData() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getData2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getData2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Data"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaInstance> getInstance() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getInstance2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaInstance> getInstance2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Instance"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaInstance> list = new ArrayList<>(1);
			list.add(new GFARichMediaInstance((COSDictionary)object.getDirectBase(), this.baseObject, "Instance"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DTransMatrix> getM() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getM1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DTransMatrix> getM1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DTransMatrix> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DTransMatrix((COSArray)object.getDirectBase(), this.baseObject, "M"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A3DRenderMode> getRM() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getRM2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<A3DRenderMode> getRM2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RM"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A3DRenderMode> list = new ArrayList<>(1);
			list.add(new GFA3DRenderMode((COSDictionary)object.getDirectBase(), this.baseObject, "RM"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Data"));
	}

	@Override
	public Boolean getisDataIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getDataHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getDataHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsInstance() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Instance"));
	}

	@Override
	public Boolean getInstanceHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Instance"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M"));
	}

	@Override
	public Boolean getMHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	@Override
	public Boolean getNHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	@Override
	public Boolean getOHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getONumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null || object.empty()) {
			return getONumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getONumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsRM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RM"));
	}

	@Override
	public Boolean getRMHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RM"));
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

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	@Override
	public Boolean getVHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

}
