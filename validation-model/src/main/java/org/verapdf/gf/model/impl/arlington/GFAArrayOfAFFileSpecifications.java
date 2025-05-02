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

public class GFAArrayOfAFFileSpecifications extends GFAObject implements AArrayOfAFFileSpecifications {

	public GFAArrayOfAFFileSpecifications(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfAFFileSpecifications");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "entry0":
				return getentry0();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfAFFileSpecificationsEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionISO_19005_3() == true)) {
					return getEntries1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getEntries1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfAFFileSpecificationsEntry> getEntries1_7() {
		List<AArrayOfAFFileSpecificationsEntry> list = new LinkedList<>();
		for (int i = 1; i < baseObject.size(); i++) {
			COSObject object = baseObject.at(i);
			list.add(new GFAArrayOfAFFileSpecificationsEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, String.valueOf(i)));
		}
		return Collections.unmodifiableList(list);
	}

	private List<AAFFileSpecification> getentry0() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionISO_19005_3() == true)) {
					return getentry01_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getentry01_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAFFileSpecification> getentry01_7() {
		COSObject object = getentry0Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAFFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAAFFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "0"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontains0() {
		return this.baseObject.size() > 0;
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public String getentry0Type() {
		COSObject entry0 = getentry0Value();
		return getObjectType(entry0);
	}

	@Override
	public Boolean getentry0HasTypeDictionary() {
		COSObject entry0 = getentry0Value();
		return getHasTypeDictionary(entry0);
	}

}
