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

public class GFAMarkedContentReference extends GFAObject implements AMarkedContentReference {

	public GFAMarkedContentReference(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMarkedContentReference");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Pg":
				return getPg();
			case "Stm":
				return getStm();
			case "StmOwn":
				return getStmOwn();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<APageObject> getPg() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPg1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getPg1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "Pg"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXObjectFormType1> getStm() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getStm1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectFormType1> getStm1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Stm"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormType1> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormType1((COSStream)object.getDirectBase(), this.baseObject, "Stm"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getStmOwn() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getStmOwn1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getStmOwn1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StmOwn"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.baseObject, "StmOwn"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "StmOwn"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "StmOwn"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsMCID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MCID"));
	}

	@Override
	public Boolean getMCIDHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MCID"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsPg() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pg"));
	}

	@Override
	public Boolean getisPgIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPgHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsStm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Stm"));
	}

	@Override
	public Boolean getisStmIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Stm"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getStmHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Stm"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsStmOwn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StmOwn"));
	}

	@Override
	public Boolean getisStmOwnIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StmOwn"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getStmOwnHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StmOwn"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getStmOwnHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StmOwn"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getStmOwnHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StmOwn"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
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
