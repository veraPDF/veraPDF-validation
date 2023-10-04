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

public class GFAURTransformParameters extends GFAObject implements AURTransformParameters {

	public GFAURTransformParameters(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AURTransformParameters");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Annots":
				return getAnnots();
			case "Document":
				return getDocument();
			case "EF":
				return getEF();
			case "Form":
				return getForm();
			case "Signature":
				return getSignature();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AURTransformParamAnnotsArray> getAnnots() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAnnots1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURTransformParamAnnotsArray> getAnnots1_5() {
		COSObject object = getAnnotsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AURTransformParamAnnotsArray> list = new ArrayList<>(1);
			list.add(new GFAURTransformParamAnnotsArray((COSArray)object.getDirectBase(), this.baseObject, "Annots"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AURTransformParamDocumentArray> getDocument() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDocument1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURTransformParamDocumentArray> getDocument1_5() {
		COSObject object = getDocumentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AURTransformParamDocumentArray> list = new ArrayList<>(1);
			list.add(new GFAURTransformParamDocumentArray((COSArray)object.getDirectBase(), this.baseObject, "Document"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AURTransformParamEFArray> getEF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEF1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURTransformParamEFArray> getEF1_6() {
		COSObject object = getEFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AURTransformParamEFArray> list = new ArrayList<>(1);
			list.add(new GFAURTransformParamEFArray((COSArray)object.getDirectBase(), this.baseObject, "EF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AURTransformParamFormArray> getForm() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getForm1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURTransformParamFormArray> getForm1_5() {
		COSObject object = getFormValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AURTransformParamFormArray> list = new ArrayList<>(1);
			list.add(new GFAURTransformParamFormArray((COSArray)object.getDirectBase(), this.baseObject, "Form"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AURTransformParamSignatureArray> getSignature() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSignature1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURTransformParamSignatureArray> getSignature1_5() {
		COSObject object = getSignatureValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AURTransformParamSignatureArray> list = new ArrayList<>(1);
			list.add(new GFAURTransformParamSignatureArray((COSArray)object.getDirectBase(), this.baseObject, "Signature"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAnnots() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Annots"));
	}

	public COSObject getAnnotsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annots"));
		return object;
	}

	@Override
	public Boolean getAnnotsHasTypeArray() {
		COSObject Annots = getAnnotsValue();
		return getHasTypeArray(Annots);
	}

	@Override
	public Boolean getcontainsDocument() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Document"));
	}

	public COSObject getDocumentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Document"));
		return object;
	}

	@Override
	public Boolean getDocumentHasTypeArray() {
		COSObject Document = getDocumentValue();
		return getHasTypeArray(Document);
	}

	@Override
	public Boolean getcontainsEF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EF"));
	}

	public COSObject getEFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EF"));
		return object;
	}

	@Override
	public Boolean getEFHasTypeArray() {
		COSObject EF = getEFValue();
		return getHasTypeArray(EF);
	}

	@Override
	public Boolean getcontainsForm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Form"));
	}

	public COSObject getFormValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Form"));
		return object;
	}

	@Override
	public Boolean getFormHasTypeArray() {
		COSObject Form = getFormValue();
		return getHasTypeArray(Form);
	}

	@Override
	public Boolean getcontainsMsg() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Msg"));
	}

	public COSObject getMsgValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Msg"));
		return object;
	}

	@Override
	public Boolean getMsgHasTypeStringText() {
		COSObject Msg = getMsgValue();
		return getHasTypeStringText(Msg);
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
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
	public Boolean getPHasTypeBoolean() {
		COSObject P = getPValue();
		return getHasTypeBoolean(P);
	}

	@Override
	public Boolean getcontainsSignature() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Signature"));
	}

	public COSObject getSignatureValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Signature"));
		return object;
	}

	@Override
	public Boolean getSignatureHasTypeArray() {
		COSObject Signature = getSignatureValue();
		return getHasTypeArray(Signature);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("2.2");
		}
		return null;
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		if (object == null || object.empty()) {
			object = getVDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getVHasTypeName() {
		COSObject V = getVValue();
		return getHasTypeName(V);
	}

}
