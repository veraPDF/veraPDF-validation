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
		COSObject object = getDataValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getDataHasTypeArray() {
		COSObject object = getDataValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getDataHasTypeBoolean() {
		COSObject object = getDataValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getDataHasTypeDictionary() {
		COSObject object = getDataValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getDataHasTypeInteger() {
		COSObject object = getDataValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getDataHasTypeName() {
		COSObject object = getDataValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getDataHasTypeStream() {
		COSObject object = getDataValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getDataHasTypeString() {
		COSObject object = getDataValue();
		return getHasTypeString(object);
	}

	@Override
	public Boolean getcontainsDigestMethod() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DigestMethod"));
	}

	public COSObject getDigestMethodDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
				return true ? COSName.construct("MD5") : gethasExtensionISO_TS_32001() ? COSName.construct("SHA256") : null;
			case ARLINGTON2_0:
				return gethasExtensionISO_TS_32001() ? COSName.construct("SHA256") : null;
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
	public Boolean getDigestMethodHasTypeName() {
		COSObject object = getDigestMethodValue();
		return getHasTypeName(object);
	}

	@Override
	public String getDigestMethodNameValue() {
		COSObject object = getDigestMethodValue();
		return getNameValue(object);
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
	public Boolean getTransformMethodHasTypeName() {
		COSObject object = getTransformMethodValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTransformMethodNameValue() {
		COSObject object = getTransformMethodValue();
		return getNameValue(object);
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
	public Boolean getTransformParamsHasTypeDictionary() {
		COSObject object = getTransformParamsValue();
		return getHasTypeDictionary(object);
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

	@Override
	public Boolean gethasExtensionISO_TS_32001() {
		return false;
	}

}
