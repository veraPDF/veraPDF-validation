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

public class GFAArrayOfRichMediaConfigurationEntry extends GFAObject implements AArrayOfRichMediaConfigurationEntry {

	private final COSBase parentParentObject;
	private final String collectionName;

	public GFAArrayOfRichMediaConfigurationEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfRichMediaConfigurationEntry");
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

	private List<ARichMediaConfiguration> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getEntry1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getEntry1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaConfiguration> getEntry1_7() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaConfiguration> list = new ArrayList<>(1);
			list.add(new GFARichMediaConfiguration((COSDictionary)object.getDirectBase(), this.parentObject, keyName));
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
	public Boolean getHasTypeDictionary() {
		COSObject entry = getValue();
		return getHasTypeDictionary(entry);
	}

}
