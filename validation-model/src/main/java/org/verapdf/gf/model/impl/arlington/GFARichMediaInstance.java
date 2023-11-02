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
	public String getAssetType() {
		COSObject Asset = getAssetValue();
		return getObjectType(Asset);
	}

	@Override
	public Boolean getAssetHasTypeDictionary() {
		COSObject Asset = getAssetValue();
		return getHasTypeDictionary(Asset);
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
	public String getParamsType() {
		COSObject Params = getParamsValue();
		return getObjectType(Params);
	}

	@Override
	public Boolean getParamsHasTypeDictionary() {
		COSObject Params = getParamsValue();
		return getHasTypeDictionary(Params);
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
	public String getSceneType() {
		COSObject Scene = getSceneValue();
		return getObjectType(Scene);
	}

	@Override
	public Boolean getSceneHasTypeInteger() {
		COSObject Scene = getSceneValue();
		return getHasTypeInteger(Scene);
	}

	@Override
	public Long getSceneIntegerValue() {
		COSObject Scene = getSceneValue();
		return getIntegerValue(Scene);
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
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

	@Override
	public Boolean gethasExtensionISO_TS_32007() {
		return false;
	}

}
