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

public class GFAAppearanceTrapNetSubDictEntry extends GFAObject implements AAppearanceTrapNetSubDictEntry {

	private final COSBase parentParentObject;
	private final String collectionName;

	public GFAAppearanceTrapNetSubDictEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AAppearanceTrapNetSubDictEntry");
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

	private List<AXObjectFormTrapNet> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectFormTrapNet> getEntry1_3() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormTrapNet> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormTrapNet((COSStream)object.getDirectBase(), this.parentObject, keyName));
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
	public Boolean getHasTypeStream() {
		COSObject entry = getValue();
		return getHasTypeStream(entry);
	}

}
