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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DC"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DP"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DS"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WP"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WS"));
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

	@Override
	public Boolean getDCHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DC"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DP"));
	}

	@Override
	public Boolean getDPHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DP"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DS"));
	}

	@Override
	public Boolean getDSHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsWP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WP"));
	}

	@Override
	public Boolean getWPHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WP"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsWS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WS"));
	}

	@Override
	public Boolean getWSHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WS"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
