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

public class GFA3DUnits extends GFAObject implements A3DUnits {

	public GFA3DUnits(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DUnits");
	}

	@Override
	public Boolean getcontainsDSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DSm"));
	}

	public COSObject getDSmDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getDSmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSm"));
		if (object == null || object.empty()) {
			object = getDSmDefaultValue();
		}
		return object;
	}

	@Override
	public String getDSmType() {
		COSObject DSm = getDSmValue();
		return getObjectType(DSm);
	}

	@Override
	public Boolean getDSmHasTypeNumber() {
		COSObject DSm = getDSmValue();
		return getHasTypeNumber(DSm);
	}

	@Override
	public Boolean getcontainsDSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DSn"));
	}

	public COSObject getDSnDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getDSnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DSn"));
		if (object == null || object.empty()) {
			object = getDSnDefaultValue();
		}
		return object;
	}

	@Override
	public String getDSnType() {
		COSObject DSn = getDSnValue();
		return getObjectType(DSn);
	}

	@Override
	public Boolean getDSnHasTypeNumber() {
		COSObject DSn = getDSnValue();
		return getHasTypeNumber(DSn);
	}

	@Override
	public Boolean getcontainsDU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DU"));
	}

	public COSObject getDUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DU"));
		return object;
	}

	@Override
	public String getDUType() {
		COSObject DU = getDUValue();
		return getObjectType(DU);
	}

	@Override
	public Boolean getDUHasTypeStringText() {
		COSObject DU = getDUValue();
		return getHasTypeStringText(DU);
	}

	@Override
	public Boolean getcontainsTSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TSm"));
	}

	public COSObject getTSmDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getTSmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TSm"));
		if (object == null || object.empty()) {
			object = getTSmDefaultValue();
		}
		return object;
	}

	@Override
	public String getTSmType() {
		COSObject TSm = getTSmValue();
		return getObjectType(TSm);
	}

	@Override
	public Boolean getTSmHasTypeNumber() {
		COSObject TSm = getTSmValue();
		return getHasTypeNumber(TSm);
	}

	@Override
	public Boolean getcontainsTSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TSn"));
	}

	public COSObject getTSnDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getTSnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TSn"));
		if (object == null || object.empty()) {
			object = getTSnDefaultValue();
		}
		return object;
	}

	@Override
	public String getTSnType() {
		COSObject TSn = getTSnValue();
		return getObjectType(TSn);
	}

	@Override
	public Boolean getTSnHasTypeNumber() {
		COSObject TSn = getTSnValue();
		return getHasTypeNumber(TSn);
	}

	@Override
	public Boolean getcontainsTU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TU"));
	}

	public COSObject getTUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TU"));
		return object;
	}

	@Override
	public String getTUType() {
		COSObject TU = getTUValue();
		return getObjectType(TU);
	}

	@Override
	public Boolean getTUHasTypeStringText() {
		COSObject TU = getTUValue();
		return getHasTypeStringText(TU);
	}

	@Override
	public Boolean getcontainsUSm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("USm"));
	}

	public COSObject getUSmDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getUSmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("USm"));
		if (object == null || object.empty()) {
			object = getUSmDefaultValue();
		}
		return object;
	}

	@Override
	public String getUSmType() {
		COSObject USm = getUSmValue();
		return getObjectType(USm);
	}

	@Override
	public Boolean getUSmHasTypeNumber() {
		COSObject USm = getUSmValue();
		return getHasTypeNumber(USm);
	}

	@Override
	public Boolean getcontainsUSn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("USn"));
	}

	public COSObject getUSnDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getUSnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("USn"));
		if (object == null || object.empty()) {
			object = getUSnDefaultValue();
		}
		return object;
	}

	@Override
	public String getUSnType() {
		COSObject USn = getUSnValue();
		return getObjectType(USn);
	}

	@Override
	public Boolean getUSnHasTypeNumber() {
		COSObject USn = getUSnValue();
		return getHasTypeNumber(USn);
	}

	@Override
	public Boolean getcontainsUU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UU"));
	}

	public COSObject getUUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UU"));
		return object;
	}

	@Override
	public String getUUType() {
		COSObject UU = getUUValue();
		return getObjectType(UU);
	}

	@Override
	public Boolean getUUHasTypeStringText() {
		COSObject UU = getUUValue();
		return getHasTypeStringText(UU);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
