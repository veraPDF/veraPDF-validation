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
	public String getCaptionType() {
		COSObject Caption = getCaptionValue();
		return getObjectType(Caption);
	}

	@Override
	public Boolean getCaptionHasTypeStringText() {
		COSObject Caption = getCaptionValue();
		return getHasTypeStringText(Caption);
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
	public String getECCType() {
		COSObject ECC = getECCValue();
		return getObjectType(ECC);
	}

	@Override
	public Boolean getECCHasTypeInteger() {
		COSObject ECC = getECCValue();
		return getHasTypeInteger(ECC);
	}

	@Override
	public Long getECCIntegerValue() {
		COSObject ECC = getECCValue();
		return getIntegerValue(ECC);
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
	public String getHeightType() {
		COSObject Height = getHeightValue();
		return getObjectType(Height);
	}

	@Override
	public Boolean getHeightHasTypeNumber() {
		COSObject Height = getHeightValue();
		return getHasTypeNumber(Height);
	}

	@Override
	public Double getHeightNumberValue() {
		COSObject Height = getHeightValue();
		return getNumberValue(Height);
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
	public String getResolutionType() {
		COSObject Resolution = getResolutionValue();
		return getObjectType(Resolution);
	}

	@Override
	public Boolean getResolutionHasTypeNumber() {
		COSObject Resolution = getResolutionValue();
		return getHasTypeNumber(Resolution);
	}

	@Override
	public Double getResolutionNumberValue() {
		COSObject Resolution = getResolutionValue();
		return getNumberValue(Resolution);
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
	public String getSymbologyType() {
		COSObject Symbology = getSymbologyValue();
		return getObjectType(Symbology);
	}

	@Override
	public Boolean getSymbologyHasTypeName() {
		COSObject Symbology = getSymbologyValue();
		return getHasTypeName(Symbology);
	}

	@Override
	public String getSymbologyNameValue() {
		COSObject Symbology = getSymbologyValue();
		return getNameValue(Symbology);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
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
	public String getVersionType() {
		COSObject Version = getVersionValue();
		return getObjectType(Version);
	}

	@Override
	public Boolean getVersionHasTypeNumber() {
		COSObject Version = getVersionValue();
		return getHasTypeNumber(Version);
	}

	@Override
	public Double getVersionNumberValue() {
		COSObject Version = getVersionValue();
		return getNumberValue(Version);
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
	public String getWidthType() {
		COSObject Width = getWidthValue();
		return getObjectType(Width);
	}

	@Override
	public Boolean getWidthHasTypeNumber() {
		COSObject Width = getWidthValue();
		return getHasTypeNumber(Width);
	}

	@Override
	public Double getWidthNumberValue() {
		COSObject Width = getWidthValue();
		return getNumberValue(Width);
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
	public String getXSymWidthType() {
		COSObject XSymWidth = getXSymWidthValue();
		return getObjectType(XSymWidth);
	}

	@Override
	public Boolean getXSymWidthHasTypeInteger() {
		COSObject XSymWidth = getXSymWidthValue();
		return getHasTypeInteger(XSymWidth);
	}

	@Override
	public Long getXSymWidthIntegerValue() {
		COSObject XSymWidth = getXSymWidthValue();
		return getIntegerValue(XSymWidth);
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
	public String getYSymHeightType() {
		COSObject YSymHeight = getYSymHeightValue();
		return getObjectType(YSymHeight);
	}

	@Override
	public Boolean getYSymHeightHasTypeInteger() {
		COSObject YSymHeight = getYSymHeightValue();
		return getHasTypeInteger(YSymHeight);
	}

	@Override
	public Long getYSymHeightIntegerValue() {
		COSObject YSymHeight = getYSymHeightValue();
		return getIntegerValue(YSymHeight);
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
	public String getnCodeWordColType() {
		COSObject nCodeWordCol = getnCodeWordColValue();
		return getObjectType(nCodeWordCol);
	}

	@Override
	public Boolean getnCodeWordColHasTypeNumber() {
		COSObject nCodeWordCol = getnCodeWordColValue();
		return getHasTypeNumber(nCodeWordCol);
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
	public String getnCodeWordRowType() {
		COSObject nCodeWordRow = getnCodeWordRowValue();
		return getObjectType(nCodeWordRow);
	}

	@Override
	public Boolean getnCodeWordRowHasTypeNumber() {
		COSObject nCodeWordRow = getnCodeWordRowValue();
		return getHasTypeNumber(nCodeWordRow);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
