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

public class GFADestXYZArray extends GFAObject implements ADestXYZArray {

	public GFADestXYZArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADestXYZArray");
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
		return getNumberValue(object);
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
		return getNameValue(object);
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeNull() {
		COSObject object = getentry2Value();
		return getHasTypeNull(object);
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject object = getentry2Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getentry3HasTypeNull() {
		COSObject object = getentry3Value();
		return getHasTypeNull(object);
	}

	@Override
	public Boolean getentry3HasTypeNumber() {
		COSObject object = getentry3Value();
		return getHasTypeNumber(object);
	}

	public COSObject getentry4Value() {
		if (this.baseObject.size() <= 4) {
			return null;
		}
		COSObject object = this.baseObject.at(4);
		return object;
	}

	@Override
	public Boolean getentry4HasTypeNull() {
		COSObject object = getentry4Value();
		return getHasTypeNull(object);
	}

	@Override
	public Boolean getentry4HasTypeNumber() {
		COSObject object = getentry4Value();
		return getHasTypeNumber(object);
	}

}
