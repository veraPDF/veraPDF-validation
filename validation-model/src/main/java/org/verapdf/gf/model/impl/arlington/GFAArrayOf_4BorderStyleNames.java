package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFAArrayOf_4BorderStyleNames extends GFAObject implements AArrayOf_4BorderStyleNames {

	public GFAArrayOf_4BorderStyleNames(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_4BorderStyleNames");
	}

	@Override
	public Boolean getentry0HasTypeName() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry0HasTypeNull() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public String getentry0NameValue() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		if (object == null || object.empty()) {
			return getentry0NameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getentry0NameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getentry1HasTypeName() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry1HasTypeNull() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public String getentry1NameValue() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		if (object == null || object.empty()) {
			return getentry1NameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getentry1NameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getentry2HasTypeName() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry2HasTypeNull() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public String getentry2NameValue() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		if (object == null || object.empty()) {
			return getentry2NameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getentry2NameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getentry3HasTypeName() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry3HasTypeNull() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public String getentry3NameValue() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		if (object == null || object.empty()) {
			return getentry3NameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getentry3NameDefaultValue() {
		return null;
	}

}
