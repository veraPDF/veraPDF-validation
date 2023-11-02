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

public class GFAArrayOfArraysPathsEntry extends GFAObject implements AArrayOfArraysPathsEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfArraysPathsEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfArraysPathsEntry");
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

	private List<AArrayOfPaths> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getEntry2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfPaths> getEntry2_0() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfPaths> list = new ArrayList<>(1);
			list.add(new GFAArrayOfPaths((COSArray)object.getDirectBase(), this.parentObject, keyName));
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
	public Boolean getHasTypeArray() {
		COSObject entry = getValue();
		return getHasTypeArray(entry);
	}

	@Override
	public Long getArraySize() {
		COSObject entry = getValue();
		return getArraySize(entry);
	}

}
