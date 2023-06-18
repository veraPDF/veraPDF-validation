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

public class GFAArrayOf3DTransMatrix extends GFAObject implements AArrayOf3DTransMatrix {

	public GFAArrayOf3DTransMatrix(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf3DTransMatrix");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeNumber() {
		COSObject object = getentry0Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		COSObject object = getentry1Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry10Value() {
		if (this.baseObject.size() <= 10) {
			return null;
		}
		COSObject object = this.baseObject.at(10);
		return object;
	}

	@Override
	public Boolean getentry10HasTypeNumber() {
		COSObject object = getentry10Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry11Value() {
		if (this.baseObject.size() <= 11) {
			return null;
		}
		COSObject object = this.baseObject.at(11);
		return object;
	}

	@Override
	public Boolean getentry11HasTypeNumber() {
		COSObject object = getentry11Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject object = getentry2Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getentry3HasTypeNumber() {
		COSObject object = getentry3Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry4Value() {
		if (this.baseObject.size() <= 4) {
			return null;
		}
		COSObject object = this.baseObject.at(4);
		return object;
	}

	@Override
	public Boolean getentry4HasTypeNumber() {
		COSObject object = getentry4Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry5Value() {
		if (this.baseObject.size() <= 5) {
			return null;
		}
		COSObject object = this.baseObject.at(5);
		return object;
	}

	@Override
	public Boolean getentry5HasTypeNumber() {
		COSObject object = getentry5Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry6Value() {
		if (this.baseObject.size() <= 6) {
			return null;
		}
		COSObject object = this.baseObject.at(6);
		return object;
	}

	@Override
	public Boolean getentry6HasTypeNumber() {
		COSObject object = getentry6Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry7Value() {
		if (this.baseObject.size() <= 7) {
			return null;
		}
		COSObject object = this.baseObject.at(7);
		return object;
	}

	@Override
	public Boolean getentry7HasTypeNumber() {
		COSObject object = getentry7Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry8Value() {
		if (this.baseObject.size() <= 8) {
			return null;
		}
		COSObject object = this.baseObject.at(8);
		return object;
	}

	@Override
	public Boolean getentry8HasTypeNumber() {
		COSObject object = getentry8Value();
		return object != null && object.getType().isNumber();
	}

	public COSObject getentry9Value() {
		if (this.baseObject.size() <= 9) {
			return null;
		}
		COSObject object = this.baseObject.at(9);
		return object;
	}

	@Override
	public Boolean getentry9HasTypeNumber() {
		COSObject object = getentry9Value();
		return object != null && object.getType().isNumber();
	}

}
