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

public class GFADest0Array extends GFAObject implements ADest0Array {

	public GFADest0Array(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADest0Array");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry0":
				return getentry0();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<APageObject> getentry0() {
		return getentry01_0();
	}

	private List<APageObject> getentry01_0() {
		COSObject object = getentry0Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "0"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeDictionary() {
		COSObject object = getentry0Value();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		COSObject object = getentry0Value();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getentry0NumberValue() {
		COSObject object = getentry0Value();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeName() {
		COSObject object = getentry1Value();
		return getHasTypeName(object);
	}

	@Override
	public String getentry1NameValue() {
		COSObject object = getentry1Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
