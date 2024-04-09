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

public class GFASignatureReferenceFieldMDP extends GFAObject implements ASignatureReferenceFieldMDP {

	public GFASignatureReferenceFieldMDP(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASignatureReferenceFieldMDP");
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getDataValue();
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

	private List<AFieldMDPTransformParameters> getTransformParams() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTransformParams1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFieldMDPTransformParameters> getTransformParams1_5() {
		COSObject object = getTransformParamsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFieldMDPTransformParameters> list = new ArrayList<>(1);
			list.add(new GFAFieldMDPTransformParameters((COSDictionary)object.getDirectBase(), this.baseObject, "TransformParams"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Data"));
	}

	public COSObject getDataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object;
	}

	@Override
	public Boolean getisDataIndirect() {
		COSObject Data = getDataValue();
		return getisIndirect(Data);
	}

	@Override
	public String getDataType() {
		COSObject Data = getDataValue();
		return getObjectType(Data);
	}

	@Override
	public Boolean getDataHasTypeArray() {
		COSObject Data = getDataValue();
		return getHasTypeArray(Data);
	}

	@Override
	public Boolean getDataHasTypeBoolean() {
		COSObject Data = getDataValue();
		return getHasTypeBoolean(Data);
	}

	@Override
	public Boolean getDataHasTypeDictionary() {
		COSObject Data = getDataValue();
		return getHasTypeDictionary(Data);
	}

	@Override
	public Boolean getDataHasTypeInteger() {
		COSObject Data = getDataValue();
		return getHasTypeInteger(Data);
	}

	@Override
	public Boolean getDataHasTypeName() {
		COSObject Data = getDataValue();
		return getHasTypeName(Data);
	}

	@Override
	public Boolean getDataHasTypeStream() {
		COSObject Data = getDataValue();
		return getHasTypeStream(Data);
	}

	@Override
	public Boolean getDataHasTypeString() {
		COSObject Data = getDataValue();
		return getHasTypeString(Data);
	}

	@Override
	public Boolean getcontainsDigestMethod() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DigestMethod"));
	}

	public COSObject getDigestMethodDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return gethasExtensionISO_TS_32001() ? COSName.construct("SHA256") : null;
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				return true ? COSName.construct("MD5") : gethasExtensionISO_TS_32001() ? COSName.construct("SHA256") : null;
		}
		return null;
	}

	public COSObject getDigestMethodValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DigestMethod"));
		if (object == null || object.empty()) {
			object = getDigestMethodDefaultValue();
		}
		return object;
	}

	@Override
	public String getDigestMethodType() {
		COSObject DigestMethod = getDigestMethodValue();
		return getObjectType(DigestMethod);
	}

	@Override
	public Boolean getDigestMethodHasTypeName() {
		COSObject DigestMethod = getDigestMethodValue();
		return getHasTypeName(DigestMethod);
	}

	@Override
	public String getDigestMethodNameValue() {
		COSObject DigestMethod = getDigestMethodValue();
		return getNameValue(DigestMethod);
	}

	@Override
	public Boolean getcontainsTransformMethod() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TransformMethod"));
	}

	public COSObject getTransformMethodValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransformMethod"));
		return object;
	}

	@Override
	public String getTransformMethodType() {
		COSObject TransformMethod = getTransformMethodValue();
		return getObjectType(TransformMethod);
	}

	@Override
	public Boolean getTransformMethodHasTypeName() {
		COSObject TransformMethod = getTransformMethodValue();
		return getHasTypeName(TransformMethod);
	}

	@Override
	public String getTransformMethodNameValue() {
		COSObject TransformMethod = getTransformMethodValue();
		return getNameValue(TransformMethod);
	}

	@Override
	public Boolean getcontainsTransformParams() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TransformParams"));
	}

	public COSObject getTransformParamsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TransformParams"));
		return object;
	}

	@Override
	public String getTransformParamsType() {
		COSObject TransformParams = getTransformParamsValue();
		return getObjectType(TransformParams);
	}

	@Override
	public Boolean getTransformParamsHasTypeDictionary() {
		COSObject TransformParams = getTransformParamsValue();
		return getHasTypeDictionary(TransformParams);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
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

}
