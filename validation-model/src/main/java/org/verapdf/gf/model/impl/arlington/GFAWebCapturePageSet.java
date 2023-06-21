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

public class GFAWebCapturePageSet extends GFAObject implements AWebCapturePageSet {

	public GFAWebCapturePageSet(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AWebCapturePageSet");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "O":
				return getO();
			case "SI":
				return getSI();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfWebCapturePages> getO() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getO1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfWebCapturePages> getO1_3() {
		COSObject object = getOValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfWebCapturePages> list = new ArrayList<>(1);
			list.add(new GFAArrayOfWebCapturePages((COSArray)object.getDirectBase(), this.baseObject, "O"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getSI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSI1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSI1_3() {
		COSObject object = getSIValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfSourceInformation> list = new ArrayList<>(1);
			list.add(new GFAArrayOfSourceInformation((COSArray)object.getDirectBase(), this.baseObject, "SI"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASourceInformation> list = new ArrayList<>(1);
			list.add(new GFASourceInformation((COSDictionary)object.getDirectBase(), this.baseObject, "SI"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CT"));
	}

	public COSObject getCTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CT"));
		return object;
	}

	@Override
	public Boolean getCTHasTypeStringAscii() {
		COSObject object = getCTValue();
		return getHasTypeStringAscii(object);
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	public COSObject getentryIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object;
	}

	@Override
	public Boolean getentryIDHasTypeStringByte() {
		COSObject object = getentryIDValue();
		return getHasTypeStringByte(object);
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
	public Boolean getOHasTypeArray() {
		COSObject object = getOValue();
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
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SI"));
	}

	public COSObject getSIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SI"));
		return object;
	}

	@Override
	public Boolean getSIHasTypeArray() {
		COSObject object = getSIValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getSIHasTypeDictionary() {
		COSObject object = getSIValue();
		return getHasTypeDictionary(object);
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
	public Boolean getTHasTypeStringText() {
		COSObject object = getTValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsTID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TID"));
	}

	public COSObject getTIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TID"));
		return object;
	}

	@Override
	public Boolean getTIDHasTypeStringByte() {
		COSObject object = getTIDValue();
		return getHasTypeStringByte(object);
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
