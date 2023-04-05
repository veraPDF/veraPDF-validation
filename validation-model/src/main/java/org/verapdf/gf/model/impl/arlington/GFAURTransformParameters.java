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
import java.io.IOException;

public class GFAURTransformParameters extends GFAObject implements AURTransformParameters {

	public GFAURTransformParameters(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AURTransformParameters");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Annots":
				return getAnnots();
			case "EF":
				return getEF();
			case "Form":
				return getForm();
			case "Signature":
				return getSignature();
			case "Document":
				return getDocument();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AURTransformParamAnnotsArray> getAnnots() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annots"));
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

	private List<AURTransformParamEFArray> getEF() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEF1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURTransformParamEFArray> getEF1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EF"));
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Form"));
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Signature"));
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

	private List<AURTransformParamDocumentArray> getDocument() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Document"));
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

	@Override
	public Boolean getcontainsSignature() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Signature"));
	}

	@Override
	public Boolean getSignatureHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Signature"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	@Override
	public Boolean getPHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	@Override
	public Boolean getVHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsDocument() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Document"));
	}

	@Override
	public Boolean getDocumentHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Document"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsAnnots() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Annots"));
	}

	@Override
	public Boolean getAnnotsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annots"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsMsg() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Msg"));
	}

	@Override
	public Boolean getMsgHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Msg"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsEF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EF"));
	}

	@Override
	public Boolean getEFHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EF"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsForm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Form"));
	}

	@Override
	public Boolean getFormHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Form"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
