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

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeName() {
		COSObject object = getentry0Value();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry0HasTypeNull() {
		COSObject object = getentry0Value();
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public String getentry0NameValue() {
		COSObject object = getentry0Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
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
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry1HasTypeNull() {
		COSObject object = getentry1Value();
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public String getentry1NameValue() {
		COSObject object = getentry1Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeName() {
		COSObject object = getentry2Value();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry2HasTypeNull() {
		COSObject object = getentry2Value();
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public String getentry2NameValue() {
		COSObject object = getentry2Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getentry3HasTypeName() {
		COSObject object = getentry3Value();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getentry3HasTypeNull() {
		COSObject object = getentry3Value();
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public String getentry3NameValue() {
		COSObject object = getentry3Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
