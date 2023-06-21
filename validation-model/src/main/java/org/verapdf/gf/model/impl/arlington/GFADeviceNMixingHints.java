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

public class GFADeviceNMixingHints extends GFAObject implements ADeviceNMixingHints {

	public GFADeviceNMixingHints(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADeviceNMixingHints");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DotGain":
				return getDotGain();
			case "PrintingOrder":
				return getPrintingOrder();
			case "Solidities":
				return getSolidities();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ADictionaryOfFunctions> getDotGain() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDotGain1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADictionaryOfFunctions> getDotGain1_6() {
		COSObject object = getDotGainValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADictionaryOfFunctions> list = new ArrayList<>(1);
			list.add(new GFADictionaryOfFunctions((COSDictionary)object.getDirectBase(), this.baseObject, "DotGain"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNamesForPrintingOrder> getPrintingOrder() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPrintingOrder1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesForPrintingOrder> getPrintingOrder1_6() {
		COSObject object = getPrintingOrderValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesForPrintingOrder> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesForPrintingOrder((COSArray)object.getDirectBase(), this.baseObject, "PrintingOrder"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASolidities> getSolidities() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSolidities1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASolidities> getSolidities1_6() {
		COSObject object = getSoliditiesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASolidities> list = new ArrayList<>(1);
			list.add(new GFASolidities((COSDictionary)object.getDirectBase(), this.baseObject, "Solidities"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDotGain() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DotGain"));
	}

	public COSObject getDotGainValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DotGain"));
		return object;
	}

	@Override
	public Boolean getDotGainHasTypeDictionary() {
		COSObject object = getDotGainValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsPrintingOrder() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrintingOrder"));
	}

	public COSObject getPrintingOrderValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrintingOrder"));
		return object;
	}

	@Override
	public Boolean getPrintingOrderHasTypeArray() {
		COSObject object = getPrintingOrderValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsSolidities() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Solidities"));
	}

	public COSObject getSoliditiesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Solidities"));
		return object;
	}

	@Override
	public Boolean getSoliditiesHasTypeDictionary() {
		COSObject object = getSoliditiesValue();
		return getHasTypeDictionary(object);
	}

}
