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

public class GFAArrayOfURLsEntry extends GFAObject implements AArrayOfURLsEntry {

	private final COSBase parentParentObject;
	private final String collectionName;

	public GFAArrayOfURLsEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfURLsEntry");
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
			case ARLINGTON2_0:
				return getEntry2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getEntry2_0() {
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
	public String getType() {
		COSObject entry = getValue();
		return getObjectType(entry);
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject entry = getValue();
		return getHasTypeDictionary(entry);
	}

	public COSObject getEntryValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject baseObject = new COSObject(this.baseObject);
		return baseObject;
	}

	@Override
	public String getEntryFSNameValue() {
		COSObject Entry = getEntryValue();
		if (Entry == null || !Entry.getType().isDictionaryBased()) {
			return null;
		}
		return new GFAFileSpecification(Entry.getDirectBase(), null, null).getFSNameValue();
	}

	@Override
	public Boolean getcontainsEntryFS() {
		COSObject Entry = getEntryValue();
		return Entry.knownKey(ASAtom.getASAtom("FS"));
	}

}
