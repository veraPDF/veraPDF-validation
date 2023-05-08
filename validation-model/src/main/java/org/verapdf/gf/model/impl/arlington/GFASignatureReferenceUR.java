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

public class GFASignatureReferenceUR extends GFAObject implements ASignatureReferenceUR {

	public GFASignatureReferenceUR(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASignatureReferenceUR");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Data":
				return getData();
			case "TransformParams":
				return getTransformParams();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getData() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getData1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getData1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.baseObject, "Data"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "Data"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Data"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AURTransformParameters> getTransformParams() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTransformParams1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURTransformParameters> getTransformParams1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransformParams"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AURTransformParameters> list = new ArrayList<>(1);
			list.add(new GFAURTransformParameters((COSDictionary)object.getDirectBase(), this.baseObject, "TransformParams"));
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
	public Boolean getDataHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getDataHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getDataHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getDataHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getDataHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getDataHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getDataHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsDigestMethod() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DigestMethod"));
	}

	@Override
	public Boolean getDigestMethodHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DigestMethod"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDigestMethodNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DigestMethod"));
		if (object == null || object.empty()) {
			return getDigestMethodNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getDigestMethodNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return gethasExtensionISO_TS_32001() ? "SHA256" : null;
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				return true ? "MD5" : gethasExtensionISO_TS_32001() ? "SHA256" : null;
		}
		return null;
	}

	@Override
	public Boolean getcontainsTransformMethod() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TransformMethod"));
	}

	@Override
	public Boolean getTransformMethodHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransformMethod"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTransformMethodNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransformMethod"));
		if (object == null || object.empty()) {
			return getTransformMethodNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTransformMethodNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsTransformParams() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TransformParams"));
	}

	@Override
	public Boolean getTransformParamsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransformParams"));
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
	public Boolean gethasExtensionISO_TS_32001() {
		return false;
	}

}
