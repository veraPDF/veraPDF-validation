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

public class GFALinearizationParameterDict extends GFAObject implements ALinearizationParameterDict {

	public GFALinearizationParameterDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ALinearizationParameterDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "H":
				return getH();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getH() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getH1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getH1_2() {
		COSObject object = getHValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getHArray1_2(object.getDirectBase(), "H");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getHArray1_2(COSBase base, String keyName) {
		switch (base.size()) {
			case 2:
				return new GFAArrayOf_2Integers(base, this.baseObject, keyName);
			case 4:
				return new GFAArrayOf_4Integers(base, this.baseObject, keyName);
			default:
				return null;
		}
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
	public Boolean getisEIndirect() {
		COSObject E = getEValue();
		return getisIndirect(E);
	}

	@Override
	public Boolean getEHasTypeInteger() {
		COSObject E = getEValue();
		return getHasTypeInteger(E);
	}

	@Override
	public Long getEIntegerValue() {
		COSObject E = getEValue();
		return getIntegerValue(E);
	}

	@Override
	public Boolean getcontainsH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("H"));
	}

	public COSObject getHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		return object;
	}

	@Override
	public Boolean getisHIndirect() {
		COSObject H = getHValue();
		return getisIndirect(H);
	}

	@Override
	public Boolean getHHasTypeArray() {
		COSObject H = getHValue();
		return getHasTypeArray(H);
	}

	@Override
	public Boolean getcontainsL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("L"));
	}

	public COSObject getLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
		return object;
	}

	@Override
	public Boolean getisLIndirect() {
		COSObject L = getLValue();
		return getisIndirect(L);
	}

	@Override
	public Boolean getLHasTypeInteger() {
		COSObject L = getLValue();
		return getHasTypeInteger(L);
	}

	@Override
	public Long getLIntegerValue() {
		COSObject L = getLValue();
		return getIntegerValue(L);
	}

	@Override
	public Boolean getcontainsLinearized() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Linearized"));
	}

	public COSObject getLinearizedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Linearized"));
		return object;
	}

	@Override
	public Boolean getisLinearizedIndirect() {
		COSObject Linearized = getLinearizedValue();
		return getisIndirect(Linearized);
	}

	@Override
	public Boolean getLinearizedHasTypeNumber() {
		COSObject Linearized = getLinearizedValue();
		return getHasTypeNumber(Linearized);
	}

	@Override
	public Double getLinearizedNumberValue() {
		COSObject Linearized = getLinearizedValue();
		return getNumberValue(Linearized);
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
	public Boolean getisNIndirect() {
		COSObject N = getNValue();
		return getisIndirect(N);
	}

	@Override
	public Boolean getNHasTypeInteger() {
		COSObject N = getNValue();
		return getHasTypeInteger(N);
	}

	@Override
	public Long getNIntegerValue() {
		COSObject N = getNValue();
		return getIntegerValue(N);
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	public COSObject getOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object;
	}

	@Override
	public Boolean getisOIndirect() {
		COSObject O = getOValue();
		return getisIndirect(O);
	}

	@Override
	public Boolean getOHasTypeInteger() {
		COSObject O = getOValue();
		return getHasTypeInteger(O);
	}

	@Override
	public Long getOIntegerValue() {
		COSObject O = getOValue();
		return getIntegerValue(O);
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
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

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			object = getPDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getisPIndirect() {
		COSObject P = getPValue();
		return getisIndirect(P);
	}

	@Override
	public Boolean getPHasTypeInteger() {
		COSObject P = getPValue();
		return getHasTypeInteger(P);
	}

	@Override
	public Long getPIntegerValue() {
		COSObject P = getPValue();
		return getIntegerValue(P);
	}

	@Override
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object;
	}

	@Override
	public Boolean getisTIndirect() {
		COSObject T = getTValue();
		return getisIndirect(T);
	}

	@Override
	public Boolean getTHasTypeInteger() {
		COSObject T = getTValue();
		return getHasTypeInteger(T);
	}

	@Override
	public Long getTIntegerValue() {
		COSObject T = getTValue();
		return getIntegerValue(T);
	}

}
