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

public class GFAArrayOfRichMediaCuePointsEntry extends GFAObject implements AArrayOfRichMediaCuePointsEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfRichMediaCuePointsEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfRichMediaCuePointsEntry");
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

	private List<ARichMediaCuePoint> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaCuePoint> getEntry1_7() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaCuePoint> list = new ArrayList<>(1);
			list.add(new GFARichMediaCuePoint((COSDictionary)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject object = getValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
