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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAsset1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getAsset1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Asset"));
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
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getParams1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaParams> getParams1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Params"));
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

	@Override
	public Boolean getAssetHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Asset"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsParams() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Params"));
	}

	@Override
	public Boolean getParamsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Params"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsScene() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Scene"));
	}

	@Override
	public Boolean getSceneHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scene"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getSceneIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Scene"));
		if (object == null || object.empty()) {
			return getSceneIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getSceneIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		if (object == null || object.empty()) {
			return getSubtypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSubtypeNameDefaultValue() {
		return null;
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

}
