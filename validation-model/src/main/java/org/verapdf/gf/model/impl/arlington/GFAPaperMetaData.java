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

public class GFAPaperMetaData extends GFAObject implements APaperMetaData {

	public GFAPaperMetaData(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "APaperMetaData");
	}

	@Override
	public Boolean getcontainsCaption() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Caption"));
	}

	public COSObject getCaptionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Caption"));
		return object;
	}

	@Override
	public Boolean getCaptionHasTypeStringText() {
		COSObject object = getCaptionValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsECC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ECC"));
	}

	public COSObject getECCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ECC"));
		return object;
	}

	@Override
	public Boolean getECCHasTypeInteger() {
		COSObject object = getECCValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getECCIntegerValue() {
		COSObject object = getECCValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Height"));
	}

	public COSObject getHeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		return object;
	}

	@Override
	public Boolean getHeightHasTypeNumber() {
		COSObject object = getHeightValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getHeightNumberValue() {
		COSObject object = getHeightValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsResolution() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resolution"));
	}

	public COSObject getResolutionDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(300D);
		}
		return null;
	}

	public COSObject getResolutionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resolution"));
		if (object == null || object.empty()) {
			object = getResolutionDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getResolutionHasTypeNumber() {
		COSObject object = getResolutionValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getResolutionNumberValue() {
		COSObject object = getResolutionValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSymbology() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Symbology"));
	}

	public COSObject getSymbologyValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Symbology"));
		return object;
	}

	@Override
	public Boolean getSymbologyHasTypeName() {
		COSObject object = getSymbologyValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSymbologyNameValue() {
		COSObject object = getSymbologyValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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

	@Override
	public Boolean getcontainsVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Version"));
	}

	public COSObject getVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Version"));
		return object;
	}

	@Override
	public Boolean getVersionHasTypeNumber() {
		COSObject object = getVersionValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getVersionNumberValue() {
		COSObject object = getVersionValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Width"));
	}

	public COSObject getWidthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		return object;
	}

	@Override
	public Boolean getWidthHasTypeNumber() {
		COSObject object = getWidthValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getWidthNumberValue() {
		COSObject object = getWidthValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsXSymWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XSymWidth"));
	}

	public COSObject getXSymWidthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XSymWidth"));
		return object;
	}

	@Override
	public Boolean getXSymWidthHasTypeInteger() {
		COSObject object = getXSymWidthValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getXSymWidthIntegerValue() {
		COSObject object = getXSymWidthValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsYSymHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("YSymHeight"));
	}

	public COSObject getYSymHeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("YSymHeight"));
		return object;
	}

	@Override
	public Boolean getYSymHeightHasTypeInteger() {
		COSObject object = getYSymHeightValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getYSymHeightIntegerValue() {
		COSObject object = getYSymHeightValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsnCodeWordCol() {
		return this.baseObject.knownKey(ASAtom.getASAtom("nCodeWordCol"));
	}

	public COSObject getnCodeWordColDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getnCodeWordColValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("nCodeWordCol"));
		if (object == null || object.empty()) {
			object = getnCodeWordColDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getnCodeWordColHasTypeNumber() {
		COSObject object = getnCodeWordColValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Boolean getcontainsnCodeWordRow() {
		return this.baseObject.knownKey(ASAtom.getASAtom("nCodeWordRow"));
	}

	public COSObject getnCodeWordRowDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(0D);
		}
		return null;
	}

	public COSObject getnCodeWordRowValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("nCodeWordRow"));
		if (object == null || object.empty()) {
			object = getnCodeWordRowDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getnCodeWordRowHasTypeNumber() {
		COSObject object = getnCodeWordRowValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
