package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFAAddActionCatalog extends GFAObject implements AAddActionCatalog {

	public GFAAddActionCatalog(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAddActionCatalog");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DC":
				return getDC();
			case "DP":
				return getDP();
			case "DS":
				return getDS();
			case "WP":
				return getWP();
			case "WS":
				return getWS();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AActionECMAScript> getDC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDC1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AActionECMAScript> getDC1_4() {
		COSObject object = getDCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AActionECMAScript> list = new ArrayList<>(1);
			list.add(new GFAActionECMAScript((COSDictionary)object.getDirectBase(), this.baseObject, "DC"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AActionECMAScript> getDP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDP1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AActionECMAScript> getDP1_4() {
		COSObject object = getDPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AActionECMAScript> list = new ArrayList<>(1);
			list.add(new GFAActionECMAScript((COSDictionary)object.getDirectBase(), this.baseObject, "DP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AActionECMAScript> getDS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDS1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AActionECMAScript> getDS1_4() {
		COSObject object = getDSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AActionECMAScript> list = new ArrayList<>(1);
			list.add(new GFAActionECMAScript((COSDictionary)object.getDirectBase(), this.baseObject, "DS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AActionECMAScript> getWP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getWP1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AActionECMAScript> getWP1_4() {
		COSObject object = getWPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AActionECMAScript> list = new ArrayList<>(1);
			list.add(new GFAActionECMAScript((COSDictionary)object.getDirectBase(), this.baseObject, "WP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AActionECMAScript> getWS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getWS1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AActionECMAScript> getWS1_4() {
		COSObject object = getWSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AActionECMAScript> list = new ArrayList<>(1);
			list.add(new GFAActionECMAScript((COSDictionary)object.getDirectBase(), this.baseObject, "WS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DC"));
	}

	public COSObject getDCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DC"));
		return object;
	}

	@Override
	public Boolean getDCHasTypeDictionary() {
		COSObject object = getDCValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsDP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DP"));
	}

	public COSObject getDPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DP"));
		return object;
	}

	@Override
	public Boolean getDPHasTypeDictionary() {
		COSObject object = getDPValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsDS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DS"));
	}

	public COSObject getDSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DS"));
		return object;
	}

	@Override
	public Boolean getDSHasTypeDictionary() {
		COSObject object = getDSValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsWP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WP"));
	}

	public COSObject getWPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WP"));
		return object;
	}

	@Override
	public Boolean getWPHasTypeDictionary() {
		COSObject object = getWPValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsWS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WS"));
	}

	public COSObject getWSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WS"));
		return object;
	}

	@Override
	public Boolean getWSHasTypeDictionary() {
		COSObject object = getWSValue();
		return getHasTypeDictionary(object);
	}

}
