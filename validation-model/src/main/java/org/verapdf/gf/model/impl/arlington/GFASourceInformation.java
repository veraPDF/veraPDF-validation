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

public class GFASourceInformation extends GFAObject implements ASourceInformation {

	public GFASourceInformation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASourceInformation");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AU":
				return getAU();
			case "C":
				return getC();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AURLAlias> getAU() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAU1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AURLAlias> getAU1_3() {
		COSObject object = getAUValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AURLAlias> list = new ArrayList<>(1);
			list.add(new GFAURLAlias((COSDictionary)object.getDirectBase(), this.baseObject, "AU"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AWebCaptureCommand> getC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AWebCaptureCommand> getC1_3() {
		COSObject object = getCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AWebCaptureCommand> list = new ArrayList<>(1);
			list.add(new GFAWebCaptureCommand((COSDictionary)object.getDirectBase(), this.baseObject, "C"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AU"));
	}

	public COSObject getAUValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AU"));
		return object;
	}

	@Override
	public Boolean getAUHasTypeDictionary() {
		COSObject object = getAUValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getAUHasTypeStringAscii() {
		COSObject object = getAUValue();
		return getHasTypeStringAscii(object);
	}

	@Override
	public Boolean getcontainsC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C"));
	}

	public COSObject getCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object;
	}

	@Override
	public Boolean getisCIndirect() {
		COSObject object = getCValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getCHasTypeDictionary() {
		COSObject object = getCValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("E"));
	}

	public COSObject getEValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("E"));
		return object;
	}

	@Override
	public Boolean getEHasTypeDate() {
		COSObject object = getEValue();
		return getHasTypeDate(object);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			object = getSDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSHasTypeInteger() {
		COSObject object = getSValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getSIntegerValue() {
		COSObject object = getSValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TS"));
	}

	public COSObject getTSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TS"));
		return object;
	}

	@Override
	public Boolean getTSHasTypeDate() {
		COSObject object = getTSValue();
		return getHasTypeDate(object);
	}

	@Override
	public String getparentSNameValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject S = this.parentObject.getKey(ASAtom.getASAtom("S"));
		if (S != null && S.getType() == COSObjType.COS_NAME) {
			return S.getString();
		}
		return null;
	}

}
