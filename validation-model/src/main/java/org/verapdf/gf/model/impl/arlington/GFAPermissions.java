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
		COSObject DocMDP = getDocMDPValue();
		return getisIndirect(DocMDP);
	}

	@Override
	public String getDocMDPType() {
		COSObject DocMDP = getDocMDPValue();
		return getObjectType(DocMDP);
	}

	@Override
	public Boolean getDocMDPHasTypeDictionary() {
		COSObject DocMDP = getDocMDPValue();
		return getHasTypeDictionary(DocMDP);
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
	public String getUR3Type() {
		COSObject UR3 = getUR3Value();
		return getObjectType(UR3);
	}

	@Override
	public Boolean getUR3HasTypeDictionary() {
		COSObject UR3 = getUR3Value();
		return getHasTypeDictionary(UR3);
	}

	public COSObject getDocMDPReferenceValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject DocMDP = this.baseObject.getKey(ASAtom.getASAtom("DocMDP"));
		if (DocMDP == null || !DocMDP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Reference = DocMDP.getKey(ASAtom.getASAtom("Reference"));
		return Reference;
	}

	public COSObject getUR3Reference0TransformMethodValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject UR3 = this.baseObject.getKey(ASAtom.getASAtom("UR3"));
		if (UR3 == null || !UR3.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Reference = UR3.getKey(ASAtom.getASAtom("Reference"));
		if (Reference == null || Reference.getType() != COSObjType.COS_ARRAY || Reference.size() <= 0) {
			return null;
		}
		COSObject entry0 = Reference.at(0);
		if (entry0 == null || !entry0.getType().isDictionaryBased()) {
			return null;
		}
		COSObject TransformMethod = entry0.getKey(ASAtom.getASAtom("TransformMethod"));
		return TransformMethod;
	}

	@Override
	public Long getDocMDPReferenceArraySize() {
		COSObject DocMDPReference = getDocMDPReferenceValue();
		return getArraySize(DocMDPReference);
	}

	@Override
	public String getUR3Reference0TransformMethodNameValue() {
		COSObject UR3Reference0TransformMethod = getUR3Reference0TransformMethodValue();
		return getNameValue(UR3Reference0TransformMethod);
	}

	@Override
	public Boolean getDocMDPReferenceHasTypeArray() {
		COSObject DocMDPReference = getDocMDPReferenceValue();
		return getHasTypeArray(DocMDPReference);
	}

}
