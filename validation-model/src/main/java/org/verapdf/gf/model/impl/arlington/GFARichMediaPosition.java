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

public class GFARichMediaPosition extends GFAObject implements ARichMediaPosition {

	public GFARichMediaPosition(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaPosition");
	}

	@Override
	public Boolean getcontainsHAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HAlign"));
	}

	public COSObject getHAlignDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Far");
		}
		return null;
	}

	public COSObject getHAlignValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HAlign"));
		if (object == null || object.empty()) {
			object = getHAlignDefaultValue();
		}
		return object;
	}

	@Override
	public String getHAlignType() {
		COSObject HAlign = getHAlignValue();
		return getObjectType(HAlign);
	}

	@Override
	public Boolean getHAlignHasTypeName() {
		COSObject HAlign = getHAlignValue();
		return getHasTypeName(HAlign);
	}

	@Override
	public String getHAlignNameValue() {
		COSObject HAlign = getHAlignValue();
		return getNameValue(HAlign);
	}

	@Override
	public Boolean getcontainsHOffset() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HOffset"));
	}

	public COSObject getHOffsetDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(18D);
		}
		return null;
	}

	public COSObject getHOffsetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HOffset"));
		if (object == null || object.empty()) {
			object = getHOffsetDefaultValue();
		}
		return object;
	}

	@Override
	public String getHOffsetType() {
		COSObject HOffset = getHOffsetValue();
		return getObjectType(HOffset);
	}

	@Override
	public Boolean getHOffsetHasTypeNumber() {
		COSObject HOffset = getHOffsetValue();
		return getHasTypeNumber(HOffset);
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
	public Boolean getcontainsVAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VAlign"));
	}

	public COSObject getVAlignDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Near");
		}
		return null;
	}

	public COSObject getVAlignValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VAlign"));
		if (object == null || object.empty()) {
			object = getVAlignDefaultValue();
		}
		return object;
	}

	@Override
	public String getVAlignType() {
		COSObject VAlign = getVAlignValue();
		return getObjectType(VAlign);
	}

	@Override
	public Boolean getVAlignHasTypeName() {
		COSObject VAlign = getVAlignValue();
		return getHasTypeName(VAlign);
	}

	@Override
	public String getVAlignNameValue() {
		COSObject VAlign = getVAlignValue();
		return getNameValue(VAlign);
	}

	@Override
	public Boolean getcontainsVOffset() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VOffset"));
	}

	public COSObject getVOffsetDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(18D);
		}
		return null;
	}

	public COSObject getVOffsetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VOffset"));
		if (object == null || object.empty()) {
			object = getVOffsetDefaultValue();
		}
		return object;
	}

	@Override
	public String getVOffsetType() {
		COSObject VOffset = getVOffsetValue();
		return getObjectType(VOffset);
	}

	@Override
	public Boolean getVOffsetHasTypeNumber() {
		COSObject VOffset = getVOffsetValue();
		return getHasTypeNumber(VOffset);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
