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
	public String getAUType() {
		COSObject AU = getAUValue();
		return getObjectType(AU);
	}

	@Override
	public Boolean getAUHasTypeDictionary() {
		COSObject AU = getAUValue();
		return getHasTypeDictionary(AU);
	}

	@Override
	public Boolean getAUHasTypeStringAscii() {
		COSObject AU = getAUValue();
		return getHasTypeStringAscii(AU);
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
		COSObject C = getCValue();
		return getisIndirect(C);
	}

	@Override
	public String getCType() {
		COSObject C = getCValue();
		return getObjectType(C);
	}

	@Override
	public Boolean getCHasTypeDictionary() {
		COSObject C = getCValue();
		return getHasTypeDictionary(C);
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
	public String getEType() {
		COSObject E = getEValue();
		return getObjectType(E);
	}

	@Override
	public Boolean getEHasTypeDate() {
		COSObject E = getEValue();
		return getHasTypeDate(E);
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
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeInteger() {
		COSObject S = getSValue();
		return getHasTypeInteger(S);
	}

	@Override
	public Long getSIntegerValue() {
		COSObject S = getSValue();
		return getIntegerValue(S);
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
	public String getTSType() {
		COSObject TS = getTSValue();
		return getObjectType(TS);
	}

	@Override
	public Boolean getTSHasTypeDate() {
		COSObject TS = getTSValue();
		return getHasTypeDate(TS);
	}

	public COSObject getparentSValue() {
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject S = this.parentObject.getKey(ASAtom.getASAtom("S"));
		return S;
	}

	@Override
	public String getparentSNameValue() {
		COSObject parentS = getparentSValue();
		return getNameValue(parentS);
	}

}
