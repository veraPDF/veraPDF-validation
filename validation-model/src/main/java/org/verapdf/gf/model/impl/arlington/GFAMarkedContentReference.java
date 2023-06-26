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
		COSObject object = getPgValue();
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
		COSObject object = getStmValue();
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
		COSObject object = getStmOwnValue();
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

	public COSObject getMCIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MCID"));
		return object;
	}

	@Override
	public Boolean getMCIDHasTypeInteger() {
		COSObject object = getMCIDValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getcontainsPg() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pg"));
	}

	public COSObject getPgValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pg"));
		return object;
	}

	@Override
	public Boolean getisPgIndirect() {
		COSObject object = getPgValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getPgHasTypeDictionary() {
		COSObject object = getPgValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsStm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Stm"));
	}

	public COSObject getStmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Stm"));
		return object;
	}

	@Override
	public Boolean getisStmIndirect() {
		COSObject object = getStmValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getStmHasTypeStream() {
		COSObject object = getStmValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getcontainsStmOwn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StmOwn"));
	}

	public COSObject getStmOwnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StmOwn"));
		return object;
	}

	@Override
	public Boolean getisStmOwnIndirect() {
		COSObject object = getStmOwnValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getStmOwnHasTypeArray() {
		COSObject object = getStmOwnValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getStmOwnHasTypeDictionary() {
		COSObject object = getStmOwnValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getStmOwnHasTypeStream() {
		COSObject object = getStmOwnValue();
		return getHasTypeStream(object);
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
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		return getNameValue(object);
	}

}
