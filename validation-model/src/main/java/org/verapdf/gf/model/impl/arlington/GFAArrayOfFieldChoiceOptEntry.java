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

public class GFAArrayOfFieldChoiceOptEntry extends GFAObject implements AArrayOfFieldChoiceOptEntry {

	private final COSBase parentParentObject;
	private final String collectionName;

	public GFAArrayOfFieldChoiceOptEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfFieldChoiceOptEntry");
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

	private List<AArrayOf_2StringsText> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2StringsText> getEntry1_2() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2StringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2StringsText((COSArray)object.getDirectBase(), this.parentObject, keyName));
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
	public Boolean getHasTypeStringText() {
		COSObject entry = getValue();
		return getHasTypeStringText(entry);
	}

}
