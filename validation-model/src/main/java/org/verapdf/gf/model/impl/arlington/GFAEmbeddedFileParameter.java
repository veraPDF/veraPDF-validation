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

public class GFAEmbeddedFileParameter extends GFAObject implements AEmbeddedFileParameter {

	public GFAEmbeddedFileParameter(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AEmbeddedFileParameter");
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mac"));
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
	public Boolean getcontainsCreationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreationDate"));
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreationDate"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsMac() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Mac"));
	}

	@Override
	public Boolean getMacHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mac"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsModDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ModDate"));
	}

	@Override
	public Boolean getModDateHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ModDate"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsCheckSum() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CheckSum"));
	}

	@Override
	public Boolean getCheckSumHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CheckSum"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getCheckSumStringSize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CheckSum"));
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSize() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Size"));
	}

	@Override
	public Boolean getSizeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getSizeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		if (object == null || object.empty()) {
			return getSizeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getSizeIntegerDefaultValue() {
		return null;
	}

}
