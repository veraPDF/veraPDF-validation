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

public class GFADest4Array extends GFAObject implements ADest4Array {

	public GFADest4Array(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADest4Array");
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
		COSObject entry0 = getentry0Value();
		return getHasTypeDictionary(entry0);
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		COSObject entry0 = getentry0Value();
		return getHasTypeNumber(entry0);
	}

	@Override
	public Double getentry0NumberValue() {
		COSObject entry0 = getentry0Value();
		return getNumberValue(entry0);
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
		COSObject entry1 = getentry1Value();
		return getHasTypeName(entry1);
	}

	@Override
	public String getentry1NameValue() {
		COSObject entry1 = getentry1Value();
		return getNameValue(entry1);
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
		COSObject entry2 = getentry2Value();
		return getHasTypeNull(entry2);
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject entry2 = getentry2Value();
		return getHasTypeNumber(entry2);
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
		COSObject entry3 = getentry3Value();
		return getHasTypeNull(entry3);
	}

	@Override
	public Boolean getentry3HasTypeNumber() {
		COSObject entry3 = getentry3Value();
		return getHasTypeNumber(entry3);
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
		COSObject entry4 = getentry4Value();
		return getHasTypeNull(entry4);
	}

	@Override
	public Boolean getentry4HasTypeNumber() {
		COSObject entry4 = getentry4Value();
		return getHasTypeNumber(entry4);
	}

	public COSObject getentry5Value() {
		if (this.baseObject.size() <= 5) {
			return null;
		}
		COSObject object = this.baseObject.at(5);
		return object;
	}

	@Override
	public Boolean getentry5HasTypeNull() {
		COSObject entry5 = getentry5Value();
		return getHasTypeNull(entry5);
	}

	@Override
	public Boolean getentry5HasTypeNumber() {
		COSObject entry5 = getentry5Value();
		return getHasTypeNumber(entry5);
	}

}
