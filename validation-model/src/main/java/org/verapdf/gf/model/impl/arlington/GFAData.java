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

public class GFAData extends GFAObject implements AData {

	public GFAData(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AData");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "Private":
				return getPrivate();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ADataEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADataEntry> getEntries1_3() {
		List<ADataEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("LastModified".equals(key.getValue()) || "Private".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFADataEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<org.verapdf.model.baselayer.Object> getPrivate() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPrivate1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getPrivate1_3() {
		COSObject object = getPrivateValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.baseObject, "Private"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "Private"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Private"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsLastModified() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LastModified"));
	}

	public COSObject getLastModifiedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LastModified"));
		return object;
	}

	@Override
	public Boolean getLastModifiedHasTypeDate() {
		COSObject object = getLastModifiedValue();
		return getHasTypeDate(object);
	}

	@Override
	public Boolean getcontainsPrivate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Private"));
	}

	public COSObject getPrivateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object;
	}

	@Override
	public Boolean getisPrivateIndirect() {
		COSObject object = getPrivateValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPrivateHasTypeArray() {
		COSObject object = getPrivateValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getPrivateHasTypeBoolean() {
		COSObject object = getPrivateValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getPrivateHasTypeDictionary() {
		COSObject object = getPrivateValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getPrivateHasTypeInteger() {
		COSObject object = getPrivateValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Boolean getPrivateHasTypeName() {
		COSObject object = getPrivateValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getPrivateHasTypeNumber() {
		COSObject object = getPrivateValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Boolean getPrivateHasTypeStream() {
		COSObject object = getPrivateValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getPrivateHasTypeString() {
		COSObject object = getPrivateValue();
		return getHasTypeString(object);
	}

}
