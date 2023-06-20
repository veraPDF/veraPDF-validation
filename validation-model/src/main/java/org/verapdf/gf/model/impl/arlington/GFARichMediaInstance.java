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

public class GFARichMediaInstance extends GFAObject implements ARichMediaInstance {

	public GFARichMediaInstance(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaInstance");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Asset":
				return getAsset();
			case "Params":
				return getParams();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AFileSpecification> getAsset() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAsset1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getAsset1_7() {
		COSObject object = getAssetValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "Asset"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaParams> getParams() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getParams1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaParams> getParams1_7() {
		COSObject object = getParamsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaParams> list = new ArrayList<>(1);
			list.add(new GFARichMediaParams((COSDictionary)object.getDirectBase(), this.baseObject, "Params"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAsset() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Asset"));
	}

	public COSObject getAssetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Asset"));
		return object;
	}

	@Override
	public Boolean getAssetHasTypeDictionary() {
		COSObject object = getAssetValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsParams() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Params"));
	}

	public COSObject getParamsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Params"));
		return object;
	}

	@Override
	public Boolean getParamsHasTypeDictionary() {
		COSObject object = getParamsValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsScene() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Scene"));
	}

	public COSObject getSceneValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scene"));
		return object;
	}

	@Override
	public Boolean getSceneHasTypeInteger() {
		COSObject object = getSceneValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getSceneIntegerValue() {
		COSObject object = getSceneValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

	@Override
	public Boolean gethasExtensionISO_TS_32007() {
		return false;
	}

}
