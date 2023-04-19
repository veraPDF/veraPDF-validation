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

public class GFAWebCaptureImageSet extends GFAObject implements AWebCaptureImageSet {

	public GFAWebCaptureImageSet(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AWebCaptureImageSet");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "O":
				return getO();
			case "R":
				return getR();
			case "SI":
				return getSI();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfWebCaptureImages> getO() {
		switch(StaticContainers.getFlavour()) {
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

	private List<AArrayOfWebCaptureImages> getO1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfWebCaptureImages> list = new ArrayList<>(1);
			list.add(new GFAArrayOfWebCaptureImages((COSArray)object.getDirectBase(), this.baseObject, "O"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfIntegersGeneral> getR() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getR1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfIntegersGeneral> getR1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfIntegersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfIntegersGeneral((COSArray)object.getDirectBase(), this.baseObject, "R"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getSI() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SI"));
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

	@Override
	public Boolean getCTHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CT"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	@Override
	public Boolean getentryIDHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("O"));
	}

	@Override
	public Boolean getOHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getOArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("O"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	@Override
	public Boolean getRHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getRHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object == null || object.empty()) {
			return getRIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getRIntegerDefaultValue() {
		return null;
	}

	@Override
	public Long getRArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			return getSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SI"));
	}

	@Override
	public Boolean getSIHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SI"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getSIHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SI"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsTS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TS"));
	}

	@Override
	public Boolean getTSHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TS"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

}
