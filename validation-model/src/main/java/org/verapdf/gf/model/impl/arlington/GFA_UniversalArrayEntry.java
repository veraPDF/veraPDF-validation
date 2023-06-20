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

public class GFA_UniversalArrayEntry extends GFAObject implements A_UniversalArrayEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFA_UniversalArrayEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "A_UniversalArrayEntry");
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

	private List<org.verapdf.model.baselayer.Object> getEntry1_2() {
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
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.parentObject, keyName));
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
		COSObject object = getValue();
		return object != null && object.get() != null && object.get().isIndirect();
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
	public Boolean getHasTypeDictionary() {
		COSObject object = getValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getHasTypeName() {
		COSObject object = getValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getHasTypeNull() {
		COSObject object = getValue();
		return getHasTypeNull(object);
	}

	@Override
	public Boolean getHasTypeNumber() {
		COSObject object = getValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Boolean getHasTypeStream() {
		COSObject object = getValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getHasTypeString() {
		COSObject object = getValue();
		return getHasTypeString(object);
	}

}
