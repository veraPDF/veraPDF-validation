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

public class GFARichMediaContent extends GFAObject implements ARichMediaContent {

	public GFARichMediaContent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaContent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Assets":
				return getAssets();
			case "AssetsTreeNode":
				return getAssetsTreeNode();
			case "Configurations":
				return getConfigurations();
			case "Views":
				return getViews();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaContentNameTreeAssets> getAssets() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getAssets1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getAssets1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaContentNameTreeAssets> getAssets1_7() {
		COSObject object = getAssetsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaContentNameTreeAssets> list = new ArrayList<>(1);
			list.add(new GFARichMediaContentNameTreeAssets((COSDictionary)object.getDirectBase(), this.baseObject, "Assets"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getAssetsTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getAssetsTreeNode1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getAssetsTreeNode1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getAssetsTreeNode1_7() {
		COSObject object = getAssetsTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "AssetsTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfRichMediaConfiguration> getConfigurations() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getConfigurations1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getConfigurations1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRichMediaConfiguration> getConfigurations1_7() {
		COSObject object = getConfigurationsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfRichMediaConfiguration> list = new ArrayList<>(1);
			list.add(new GFAArrayOfRichMediaConfiguration((COSArray)object.getDirectBase(), this.baseObject, "Configurations"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DViewAddEntries> getViews() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getViews1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getViews1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DViewAddEntries> getViews1_7() {
		COSObject object = getViewsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DViewAddEntries> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DViewAddEntries((COSArray)object.getDirectBase(), this.baseObject, "Views"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAssets() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Assets"));
	}

	public COSObject getAssetsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Assets"));
		return object;
	}

	@Override
	public String getAssetsType() {
		COSObject Assets = getAssetsValue();
		return getObjectType(Assets);
	}

	@Override
	public Boolean getAssetsHasTypeNameTree() {
		COSObject Assets = getAssetsValue();
		return getHasTypeNameTree(Assets);
	}

	@Override
	public Boolean getcontainsAssetsTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Assets"));
	}

	public COSObject getAssetsTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Assets"));
		return object;
	}

	@Override
	public String getAssetsTreeNodeType() {
		COSObject AssetsTreeNode = getAssetsTreeNodeValue();
		return getObjectType(AssetsTreeNode);
	}

	@Override
	public Boolean getAssetsTreeNodeHasTypeNameTree() {
		COSObject AssetsTreeNode = getAssetsTreeNodeValue();
		return getHasTypeNameTree(AssetsTreeNode);
	}

	@Override
	public Boolean getcontainsConfigurations() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Configurations"));
	}

	public COSObject getConfigurationsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configurations"));
		return object;
	}

	@Override
	public String getConfigurationsType() {
		COSObject Configurations = getConfigurationsValue();
		return getObjectType(Configurations);
	}

	@Override
	public Boolean getConfigurationsHasTypeArray() {
		COSObject Configurations = getConfigurationsValue();
		return getHasTypeArray(Configurations);
	}

	@Override
	public Long getConfigurationsArraySize() {
		COSObject Configurations = getConfigurationsValue();
		return getArraySize(Configurations);
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
	public Boolean getcontainsViews() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Views"));
	}

	public COSObject getViewsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Views"));
		return object;
	}

	@Override
	public String getViewsType() {
		COSObject Views = getViewsValue();
		return getObjectType(Views);
	}

	@Override
	public Boolean getViewsHasTypeArray() {
		COSObject Views = getViewsValue();
		return getHasTypeArray(Views);
	}

}
