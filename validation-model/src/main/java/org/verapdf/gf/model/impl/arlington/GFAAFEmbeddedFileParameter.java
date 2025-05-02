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

public class GFAAFEmbeddedFileParameter extends GFAObject implements AAFEmbeddedFileParameter {

	public GFAAFEmbeddedFileParameter(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAFEmbeddedFileParameter");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Mac":
				return getMac();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AMac> getMac() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMac1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMac> getMac1_3() {
		COSObject object = getMacValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMac> list = new ArrayList<>(1);
			list.add(new GFAMac((COSDictionary)object.getDirectBase(), this.baseObject, "Mac"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCheckSum() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CheckSum"));
	}

	public COSObject getCheckSumValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CheckSum"));
		return object;
	}

	@Override
	public String getCheckSumType() {
		COSObject CheckSum = getCheckSumValue();
		return getObjectType(CheckSum);
	}

	@Override
	public Boolean getCheckSumHasTypeStringByte() {
		COSObject CheckSum = getCheckSumValue();
		return getHasTypeStringByte(CheckSum);
	}

	@Override
	public Long getCheckSumStringSize() {
		COSObject CheckSum = getCheckSumValue();
		if (CheckSum != null && CheckSum.getType() == COSObjType.COS_STRING) {
			return (long) CheckSum.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsCreationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreationDate"));
	}

	public COSObject getCreationDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreationDate"));
		return object;
	}

	@Override
	public String getCreationDateType() {
		COSObject CreationDate = getCreationDateValue();
		return getObjectType(CreationDate);
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject CreationDate = getCreationDateValue();
		return getHasTypeDate(CreationDate);
	}

	@Override
	public Boolean getcontainsMac() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Mac"));
	}

	public COSObject getMacValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mac"));
		return object;
	}

	@Override
	public String getMacType() {
		COSObject Mac = getMacValue();
		return getObjectType(Mac);
	}

	@Override
	public Boolean getMacHasTypeDictionary() {
		COSObject Mac = getMacValue();
		return getHasTypeDictionary(Mac);
	}

	@Override
	public Boolean getcontainsModDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ModDate"));
	}

	public COSObject getModDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ModDate"));
		return object;
	}

	@Override
	public String getModDateType() {
		COSObject ModDate = getModDateValue();
		return getObjectType(ModDate);
	}

	@Override
	public Boolean getModDateHasTypeDate() {
		COSObject ModDate = getModDateValue();
		return getHasTypeDate(ModDate);
	}

	@Override
	public Boolean getcontainsSize() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Size"));
	}

	public COSObject getSizeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		return object;
	}

	@Override
	public String getSizeType() {
		COSObject Size = getSizeValue();
		return getObjectType(Size);
	}

	@Override
	public Boolean getSizeHasTypeInteger() {
		COSObject Size = getSizeValue();
		return getHasTypeInteger(Size);
	}

	@Override
	public Long getSizeIntegerValue() {
		COSObject Size = getSizeValue();
		return getIntegerValue(Size);
	}

}
