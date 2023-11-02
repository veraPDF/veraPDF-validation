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

public class GFARenditionMedia extends GFAObject implements ARenditionMedia {

	public GFARenditionMedia(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARenditionMedia");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BE":
				return getBE();
			case "C":
				return getC();
			case "MH":
				return getMH();
			case "P":
				return getP();
			case "SP":
				return getSP();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARenditionBE> getBE() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBE1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARenditionBE> getBE1_5() {
		COSObject object = getBEValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARenditionBE> list = new ArrayList<>(1);
			list.add(new GFARenditionBE((COSDictionary)object.getDirectBase(), this.baseObject, "BE"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getC1_5() {
		COSObject object = getCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getCDictionary1_5(object.getDirectBase(), "C");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getCDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("S"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "MCD":
				return new GFAMediaClipData(base, this.baseObject, keyName);
			case "MCS":
				return new GFAMediaClipSection(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<ARenditionMH> getMH() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMH1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARenditionMH> getMH1_5() {
		COSObject object = getMHValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARenditionMH> list = new ArrayList<>(1);
			list.add(new GFARenditionMH((COSDictionary)object.getDirectBase(), this.baseObject, "MH"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMediaPlayParameters> getP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaPlayParameters> getP1_5() {
		COSObject object = getPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaPlayParameters> list = new ArrayList<>(1);
			list.add(new GFAMediaPlayParameters((COSDictionary)object.getDirectBase(), this.baseObject, "P"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMediaScreenParameters> getSP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSP1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaScreenParameters> getSP1_5() {
		COSObject object = getSPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaScreenParameters> list = new ArrayList<>(1);
			list.add(new GFAMediaScreenParameters((COSDictionary)object.getDirectBase(), this.baseObject, "SP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BE"));
	}

	public COSObject getBEValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BE"));
		return object;
	}

	@Override
	public String getBEType() {
		COSObject BE = getBEValue();
		return getObjectType(BE);
	}

	@Override
	public Boolean getBEHasTypeDictionary() {
		COSObject BE = getBEValue();
		return getHasTypeDictionary(BE);
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
	public Boolean getcontainsMH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MH"));
	}

	public COSObject getMHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MH"));
		return object;
	}

	@Override
	public String getMHType() {
		COSObject MH = getMHValue();
		return getObjectType(MH);
	}

	@Override
	public Boolean getMHHasTypeDictionary() {
		COSObject MH = getMHValue();
		return getHasTypeDictionary(MH);
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	public COSObject getNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object;
	}

	@Override
	public String getNType() {
		COSObject N = getNValue();
		return getObjectType(N);
	}

	@Override
	public Boolean getNHasTypeStringText() {
		COSObject N = getNValue();
		return getHasTypeStringText(N);
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object;
	}

	@Override
	public String getPType() {
		COSObject P = getPValue();
		return getObjectType(P);
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject P = getPValue();
		return getHasTypeDictionary(P);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object;
	}

	@Override
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject S = getSValue();
		return getHasTypeName(S);
	}

	@Override
	public String getSNameValue() {
		COSObject S = getSValue();
		return getNameValue(S);
	}

	@Override
	public Boolean getcontainsSP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SP"));
	}

	public COSObject getSPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SP"));
		return object;
	}

	@Override
	public String getSPType() {
		COSObject SP = getSPValue();
		return getObjectType(SP);
	}

	@Override
	public Boolean getSPHasTypeDictionary() {
		COSObject SP = getSPValue();
		return getHasTypeDictionary(SP);
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

}
