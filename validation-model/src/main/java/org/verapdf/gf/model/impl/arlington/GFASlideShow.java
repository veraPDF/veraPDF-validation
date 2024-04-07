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

public class GFASlideShow extends GFAObject implements ASlideShow {

	public GFASlideShow(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASlideShow");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Resources":
				return getResources();
			case "ResourcesTreeNode":
				return getResourcesTreeNode();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ASlideShowNameTreeResources> getResources() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResources1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASlideShowNameTreeResources> getResources1_4() {
		COSObject object = getResourcesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASlideShowNameTreeResources> list = new ArrayList<>(1);
			list.add(new GFASlideShowNameTreeResources((COSDictionary)object.getDirectBase(), this.baseObject, "Resources"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNode> getResourcesTreeNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResourcesTreeNode1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNode> getResourcesTreeNode1_4() {
		COSObject object = getResourcesTreeNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ANameTreeNode> list = new ArrayList<>(1);
			list.add(new GFANameTreeNode((COSDictionary)object.getDirectBase(), this.baseObject, "ResourcesTreeNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object;
	}

	@Override
	public String getResourcesType() {
		COSObject Resources = getResourcesValue();
		return getObjectType(Resources);
	}

	@Override
	public Boolean getResourcesHasTypeNameTree() {
		COSObject Resources = getResourcesValue();
		return getHasTypeNameTree(Resources);
	}

	@Override
	public Boolean getcontainsResourcesTreeNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesTreeNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object;
	}

	@Override
	public String getResourcesTreeNodeType() {
		COSObject ResourcesTreeNode = getResourcesTreeNodeValue();
		return getObjectType(ResourcesTreeNode);
	}

	@Override
	public Boolean getResourcesTreeNodeHasTypeNameTree() {
		COSObject ResourcesTreeNode = getResourcesTreeNodeValue();
		return getHasTypeNameTree(ResourcesTreeNode);
	}

	@Override
	public Boolean getcontainsStartResource() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StartResource"));
	}

	public COSObject getStartResourceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StartResource"));
		return object;
	}

	@Override
	public String getStartResourceType() {
		COSObject StartResource = getStartResourceValue();
		return getObjectType(StartResource);
	}

	@Override
	public Boolean getStartResourceHasTypeStringByte() {
		COSObject StartResource = getStartResourceValue();
		return getHasTypeStringByte(StartResource);
	}

	@Override
	public Boolean getStartResourceEntryIsIndexInNameTreeResources() {
		COSObject StartResource = getStartResourceValue();
		if (StartResource == null || StartResource.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject Resources = getResourcesValue();
		if (Resources == null || Resources.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(Resources);
		return nameTreeNode.containsKey(StartResource.getString());
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

}
