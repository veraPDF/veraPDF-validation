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

public class GFAMediaPlayerInfo extends GFAObject implements AMediaPlayerInfo {

	public GFAMediaPlayerInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMediaPlayerInfo");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BE":
				return getBE();
			case "MH":
				return getMH();
			case "PID":
				return getPID();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<A_UniversalDictionary> getBE() {
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

	private List<A_UniversalDictionary> getBE1_5() {
		COSObject object = getBEValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "BE"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A_UniversalDictionary> getMH() {
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

	private List<A_UniversalDictionary> getMH1_5() {
		COSObject object = getMHValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "MH"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASoftwareIdentifier> getPID() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPID1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASoftwareIdentifier> getPID1_5() {
		COSObject object = getPIDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASoftwareIdentifier> list = new ArrayList<>(1);
			list.add(new GFASoftwareIdentifier((COSDictionary)object.getDirectBase(), this.baseObject, "PID"));
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
	public Boolean getBEHasTypeDictionary() {
		COSObject object = getBEValue();
		return getHasTypeDictionary(object);
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
	public Boolean getMHHasTypeDictionary() {
		COSObject object = getMHValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsPID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PID"));
	}

	public COSObject getPIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PID"));
		return object;
	}

	@Override
	public Boolean getPIDHasTypeDictionary() {
		COSObject object = getPIDValue();
		return getHasTypeDictionary(object);
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
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
