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

public class GFACollectionItemEntry extends GFAObject implements ACollectionItemEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFACollectionItemEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "ACollectionItemEntry");
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

	private List<ACollectionSubitem> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionSubitem> getEntry1_7() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionSubitem> list = new ArrayList<>(1);
			list.add(new GFACollectionSubitem((COSDictionary)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public String getType() {
		COSObject entry = getValue();
		return getObjectType(entry);
	}

	@Override
	public Boolean getHasTypeDate() {
		COSObject entry = getValue();
		return getHasTypeDate(entry);
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject entry = getValue();
		return getHasTypeDictionary(entry);
	}

	@Override
	public Boolean getHasTypeNumber() {
		COSObject entry = getValue();
		return getHasTypeNumber(entry);
	}

	@Override
	public Boolean getHasTypeStringText() {
		COSObject entry = getValue();
		return getHasTypeStringText(entry);
	}

}
