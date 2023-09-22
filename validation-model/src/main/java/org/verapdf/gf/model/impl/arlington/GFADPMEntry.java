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

public class GFADPMEntry extends GFAObject implements ADPMEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFADPMEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "ADPMEntry");
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

	private List<org.verapdf.model.baselayer.Object> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_6() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public Boolean getHasTypeArray() {
		COSObject object = getValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getHasTypeBoolean() {
		COSObject object = getValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getHasTypeDate() {
		COSObject object = getValue();
		return getHasTypeDate(object);
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject object = getValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getHasTypeInteger() {
		COSObject object = getValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getHasTypeName() {
		COSObject object = getValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getHasTypeNumber() {
		COSObject object = getValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Boolean getHasTypeStringText() {
		COSObject object = getValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean gethasExtensionPDF_VT2() {
		return false;
	}

}