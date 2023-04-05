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

public class GFAPaperMetaData extends GFAObject implements APaperMetaData {

	public GFAPaperMetaData(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APaperMetaData");
	}

	@Override
	public Boolean getcontainsECC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ECC"));
	}

	@Override
	public Boolean getECCHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ECC"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getECCIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ECC"));
		if (object == null || object.empty()) {
			return getECCIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getECCIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsnCodeWordRow() {
		return this.baseObject.knownKey(ASAtom.getASAtom("nCodeWordRow"));
	}

	@Override
	public Boolean getnCodeWordRowHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("nCodeWordRow"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Height"));
	}

	@Override
	public Boolean getHeightHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getHeightNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		if (object == null || object.empty()) {
			return getHeightNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getHeightNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsResolution() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resolution"));
	}

	@Override
	public Boolean getResolutionHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resolution"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getResolutionNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resolution"));
		if (object == null || object.empty()) {
			return getResolutionNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getResolutionNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 300D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	@Override
	public Boolean getVersionHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getVersionNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		if (object == null || object.empty()) {
			return getVersionNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getVersionNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsYSymHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("YSymHeight"));
	}

	@Override
	public Boolean getYSymHeightHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("YSymHeight"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getYSymHeightIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("YSymHeight"));
		if (object == null || object.empty()) {
			return getYSymHeightIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getYSymHeightIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsXSymWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XSymWidth"));
	}

	@Override
	public Boolean getXSymWidthHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XSymWidth"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getXSymWidthIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XSymWidth"));
		if (object == null || object.empty()) {
			return getXSymWidthIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getXSymWidthIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsnCodeWordCol() {
		return this.baseObject.knownKey(ASAtom.getASAtom("nCodeWordCol"));
	}

	@Override
	public Boolean getnCodeWordColHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("nCodeWordCol"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsCaption() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Caption"));
	}

	@Override
	public Boolean getCaptionHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Caption"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsSymbology() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Symbology"));
	}

	@Override
	public Boolean getSymbologyHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Symbology"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSymbologyNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Symbology"));
		if (object == null || object.empty()) {
			return getSymbologyNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSymbologyNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Width"));
	}

	@Override
	public Boolean getWidthHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getWidthNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		if (object == null || object.empty()) {
			return getWidthNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getWidthNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

}
