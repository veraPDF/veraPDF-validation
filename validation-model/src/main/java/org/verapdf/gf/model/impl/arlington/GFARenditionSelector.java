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

public class GFARenditionSelector extends GFAObject implements ARenditionSelector {

	public GFARenditionSelector(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARenditionSelector");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BE":
				return getBE();
			case "MH":
				return getMH();
			case "R":
				return getR();
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

	private List<AArrayOfRenditions> getR() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getR1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRenditions> getR1_5() {
		COSObject object = getRValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfRenditions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfRenditions((COSArray)object.getDirectBase(), this.baseObject, "R"));
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
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	public COSObject getNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object;
	}

	@Override
	public Boolean getNHasTypeStringText() {
		COSObject object = getNValue();
		return getHasTypeStringText(object);
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
	public Boolean getRHasTypeArray() {
		COSObject object = getRValue();
		return getHasTypeArray(object);
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
	public Boolean getSHasTypeName() {
		COSObject object = getSValue();
		return getHasTypeName(object);
	}

	@Override
	public String getSNameValue() {
		COSObject object = getSValue();
		return getNameValue(object);
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
		return getNameValue(object);
	}

}
