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

public class GFASignatureBuildDataDict extends GFAObject implements ASignatureBuildDataDict {

	public GFASignatureBuildDataDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASignatureBuildDataDict");
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

	private List<AArrayOfStringsText> getOS() {
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

	private List<AArrayOfStringsText> getOS1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "OS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Date"));
	}

	@Override
	public Boolean getDateHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Date"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	@Override
	public Boolean getNameHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsNonEFontNoWarn() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NonEFontNoWarn"));
	}

	@Override
	public Boolean getNonEFontNoWarnHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NonEFontNoWarn"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsOS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OS"));
	}

	@Override
	public Boolean getOSHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OS"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPreRelease() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PreRelease"));
	}

	@Override
	public Boolean getPreReleaseHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PreRelease"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	@Override
	public Boolean getRHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getcontainsTrustedMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrustedMode"));
	}

	@Override
	public Boolean getTrustedModeHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrustedMode"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	@Override
	public Boolean getVHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType().isNumber();
	}

}
