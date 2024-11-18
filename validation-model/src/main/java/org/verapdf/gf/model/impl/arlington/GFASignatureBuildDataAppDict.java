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

public class GFASignatureBuildDataAppDict extends GFAObject implements ASignatureBuildDataAppDict {

	public GFASignatureBuildDataAppDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASignatureBuildDataAppDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "OS":
				return getOS();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStringsTextOrNames> getOS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOS1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsTextOrNames> getOS1_5() {
		COSObject object = getOSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsTextOrNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsTextOrNames((COSArray)object.getDirectBase(), this.baseObject, "OS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Date"));
	}

	public COSObject getDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Date"));
		return object;
	}

	@Override
	public String getDateType() {
		COSObject Date = getDateValue();
		return getObjectType(Date);
	}

	@Override
	public Boolean getDateHasTypeStringText() {
		COSObject Date = getDateValue();
		return getHasTypeStringText(Date);
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object;
	}

	@Override
	public String getNameType() {
		COSObject Name = getNameValue();
		return getObjectType(Name);
	}

	@Override
	public Boolean getNameHasTypeName() {
		COSObject Name = getNameValue();
		return getHasTypeName(Name);
	}

	@Override
	public Boolean getcontainsNonEFontNoWarn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NonEFontNoWarn"));
	}

	public COSObject getNonEFontNoWarnValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NonEFontNoWarn"));
		return object;
	}

	@Override
	public String getNonEFontNoWarnType() {
		COSObject NonEFontNoWarn = getNonEFontNoWarnValue();
		return getObjectType(NonEFontNoWarn);
	}

	@Override
	public Boolean getNonEFontNoWarnHasTypeBoolean() {
		COSObject NonEFontNoWarn = getNonEFontNoWarnValue();
		return getHasTypeBoolean(NonEFontNoWarn);
	}

	@Override
	public Boolean getcontainsOS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OS"));
	}

	public COSObject getOSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
		return object;
	}

	@Override
	public String getOSType() {
		COSObject OS = getOSValue();
		return getObjectType(OS);
	}

	@Override
	public Boolean getOSHasTypeArray() {
		COSObject OS = getOSValue();
		return getHasTypeArray(OS);
	}

	@Override
	public Boolean getcontainsPreRelease() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PreRelease"));
	}

	public COSObject getPreReleaseDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getPreReleaseValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PreRelease"));
		if (object == null || object.empty()) {
			object = getPreReleaseDefaultValue();
		}
		return object;
	}

	@Override
	public String getPreReleaseType() {
		COSObject PreRelease = getPreReleaseValue();
		return getObjectType(PreRelease);
	}

	@Override
	public Boolean getPreReleaseHasTypeBoolean() {
		COSObject PreRelease = getPreReleaseValue();
		return getHasTypeBoolean(PreRelease);
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object;
	}

	@Override
	public String getRType() {
		COSObject R = getRValue();
		return getObjectType(R);
	}

	@Override
	public Boolean getRHasTypeNumber() {
		COSObject R = getRValue();
		return getHasTypeNumber(R);
	}

	@Override
	public Boolean getcontainsREx() {
		return this.baseObject.knownKey(ASAtom.getASAtom("REx"));
	}

	public COSObject getRExValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("REx"));
		return object;
	}

	@Override
	public String getRExType() {
		COSObject REx = getRExValue();
		return getObjectType(REx);
	}

	@Override
	public Boolean getRExHasTypeStringText() {
		COSObject REx = getRExValue();
		return getHasTypeStringText(REx);
	}

	@Override
	public Boolean getcontainsTrustedMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrustedMode"));
	}

	public COSObject getTrustedModeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getTrustedModeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrustedMode"));
		if (object == null || object.empty()) {
			object = getTrustedModeDefaultValue();
		}
		return object;
	}

	@Override
	public String getTrustedModeType() {
		COSObject TrustedMode = getTrustedModeValue();
		return getObjectType(TrustedMode);
	}

	@Override
	public Boolean getTrustedModeHasTypeBoolean() {
		COSObject TrustedMode = getTrustedModeValue();
		return getHasTypeBoolean(TrustedMode);
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object;
	}

	@Override
	public String getVType() {
		COSObject V = getVValue();
		return getObjectType(V);
	}

	@Override
	public Boolean getVHasTypeNumber() {
		COSObject V = getVValue();
		return getHasTypeNumber(V);
	}

}
