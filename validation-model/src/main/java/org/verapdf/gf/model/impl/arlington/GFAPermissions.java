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

public class GFAPermissions extends GFAObject implements APermissions {

	public GFAPermissions(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APermissions");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DocMDP":
				return getDocMDP();
			case "UR3":
				return getUR3();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ASignature> getDocMDP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDocMDP1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignature> getDocMDP1_5() {
		COSObject object = getDocMDPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignature> list = new ArrayList<>(1);
			list.add(new GFASignature((COSDictionary)object.getDirectBase(), this.baseObject, "DocMDP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASignature> getUR3() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getUR31_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignature> getUR31_5() {
		COSObject object = getUR3Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignature> list = new ArrayList<>(1);
			list.add(new GFASignature((COSDictionary)object.getDirectBase(), this.baseObject, "UR3"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDocMDP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DocMDP"));
	}

	public COSObject getDocMDPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DocMDP"));
		return object;
	}

	@Override
	public Boolean getisDocMDPIndirect() {
		COSObject object = getDocMDPValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getDocMDPHasTypeDictionary() {
		COSObject object = getDocMDPValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsUR3() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UR3"));
	}

	public COSObject getUR3Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UR3"));
		return object;
	}

	@Override
	public Boolean getUR3HasTypeDictionary() {
		COSObject object = getUR3Value();
		return getHasTypeDictionary(object);
	}

	@Override
	public Long getDocMDPReferenceArraySize() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject DocMDP = this.baseObject.getKey(ASAtom.getASAtom("DocMDP"));
		if (DocMDP == null || !DocMDP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Reference = DocMDP.getKey(ASAtom.getASAtom("Reference"));
		if (Reference != null && Reference.getType() == COSObjType.COS_ARRAY) {
			return (long) Reference.size();
		}
		return null;
	}

	@Override
	public String getUR3Reference0TransformMethodNameValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject UR3 = this.baseObject.getKey(ASAtom.getASAtom("UR3"));
		if (UR3 == null || !UR3.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Reference = UR3.getKey(ASAtom.getASAtom("Reference"));
		if (Reference == null || Reference.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (Reference.size() <= 0) {
			return null;
		}
		COSObject entry0 = Reference.at(0);
		if (entry0 == null || !entry0.getType().isDictionaryBased()) {
			return null;
		}
		COSObject TransformMethod = entry0.getKey(ASAtom.getASAtom("TransformMethod"));
		if (TransformMethod != null && TransformMethod.getType() == COSObjType.COS_NAME) {
			return TransformMethod.getString();
		}
		return null;
	}

	@Override
	public Boolean getDocMDPReferenceHasTypeArray() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject DocMDP = this.baseObject.getKey(ASAtom.getASAtom("DocMDP"));
		if (DocMDP == null || !DocMDP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Reference = DocMDP.getKey(ASAtom.getASAtom("Reference"));
		return getHasTypeArray(Reference);
	}

}
