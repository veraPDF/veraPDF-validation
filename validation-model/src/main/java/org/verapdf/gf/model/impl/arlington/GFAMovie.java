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
import java.io.IOException;

public class GFAMovie extends GFAObject implements AMovie {

	public GFAMovie(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMovie");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "F":
				return getF();
			case "Poster":
				return getPoster();
			case "Aspect":
				return getAspect();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AFileSpecification> getF() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "F"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXObjectImage> getPoster() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPoster1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectImage> getPoster1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Poster"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectImage> list = new ArrayList<>(1);
			list.add(new GFAXObjectImage((COSStream)object.getDirectBase(), this.baseObject, "Poster"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Numbers> getAspect() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAspect1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getAspect1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Aspect"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "Aspect"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsRotate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rotate"));
	}

	@Override
	public Boolean getRotateHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rotate"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRotateIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rotate"));
		if (object == null || object.empty()) {
			return getRotateIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getRotateIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsAspect() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Aspect"));
	}

	@Override
	public Boolean getAspectHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Aspect"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsPoster() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Poster"));
	}

	@Override
	public Boolean getisPosterIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Poster"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPosterHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Poster"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getPosterHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Poster"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
