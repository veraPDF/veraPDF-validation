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

public class GFAEncoding extends GFAObject implements AEncoding {

	public GFAEncoding(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AEncoding");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Differences":
				return getDifferences();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfDifferences> getDifferences() {
		return getDifferences1_0();
	}

	private List<AArrayOfDifferences> getDifferences1_0() {
		COSObject object = getDifferencesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDifferences> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDifferences((COSArray)object.getDirectBase(), this.baseObject, "Differences"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBaseEncoding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaseEncoding"));
	}

	public COSObject getBaseEncodingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseEncoding"));
		return object;
	}

	@Override
	public Boolean getBaseEncodingHasTypeName() {
		COSObject object = getBaseEncodingValue();
		return getHasTypeName(object);
	}

	@Override
	public String getBaseEncodingNameValue() {
		COSObject object = getBaseEncodingValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDifferences() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Differences"));
	}

	public COSObject getDifferencesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Differences"));
		return object;
	}

	@Override
	public Boolean getDifferencesHasTypeArray() {
		COSObject object = getDifferencesValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
