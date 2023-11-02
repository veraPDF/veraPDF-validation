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

public class GFAArrayOfIndirectFileSpecificationsEntry extends GFAObject implements AArrayOfIndirectFileSpecificationsEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfIndirectFileSpecificationsEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfIndirectFileSpecificationsEntry");
		this.parentParentObject = parentParentObject;
		this.collectionName = collectionName;
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entry":
				return getEntry();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AFileSpecification> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getEntry1_7() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public Boolean getisIndirect() {
		COSObject entry = getValue();
		return getisIndirect(entry);
	}

	@Override
	public String getType() {
		COSObject entry = getValue();
		return getObjectType(entry);
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject entry = getValue();
		return getHasTypeDictionary(entry);
	}

	@Override
	public Boolean getEntryIsIndexInNameTreeparentRichMediaContentAssets() {
		COSObject entry = getValue();
		if (entry == null || entry.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject parentRichMediaContentAssets = getparentRichMediaContentAssetsValue();
		if (parentRichMediaContentAssets == null || parentRichMediaContentAssets.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(parentRichMediaContentAssets);
		return nameTreeNode.containsKey(entry.getString());
	}

	public COSObject getparentRichMediaContentAssetsValue() {
		if (this.parentParentObject == null || !this.parentParentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject RichMediaContent = this.parentParentObject.getKey(ASAtom.getASAtom("RichMediaContent"));
		if (RichMediaContent == null || !RichMediaContent.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Assets = RichMediaContent.getKey(ASAtom.getASAtom("Assets"));
		return Assets;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
