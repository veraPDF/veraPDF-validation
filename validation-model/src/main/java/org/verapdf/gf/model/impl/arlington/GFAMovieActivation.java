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

public class GFAMovieActivation extends GFAObject implements AMovieActivation {

	public GFAMovieActivation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMovieActivation");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "FWScale":
				return getFWScale();
			case "Start":
				return getStart();
			case "FWPosition":
				return getFWPosition();
			case "Duration":
				return getDuration();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_2Integers> getFWScale() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFWScale1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Integers> getFWScale1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FWScale"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Integers((COSArray)object.getDirectBase(), this.baseObject, "FWScale"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfDuration> getStart() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getStart1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfDuration> getStart1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Start"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDuration> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDuration((COSArray)object.getDirectBase(), this.baseObject, "Start"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Numbers> getFWPosition() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFWPosition1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getFWPosition1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FWPosition"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "FWPosition"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfDuration> getDuration() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDuration1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfDuration> getDuration1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duration"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDuration> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDuration((COSArray)object.getDirectBase(), this.baseObject, "Duration"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsFWPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FWPosition"));
	}

	@Override
	public Boolean getFWPositionHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FWPosition"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsVolume() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Volume"));
	}

	@Override
	public Boolean getVolumeHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Volume"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getVolumeNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Volume"));
		if (object == null || object.empty()) {
			return getVolumeNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getVolumeNumberDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 1.0D;
		}
		return null;
	}

	@Override
	public Boolean getcontainsSynchronous() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Synchronous"));
	}

	@Override
	public Boolean getSynchronousHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Synchronous"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Mode"));
	}

	@Override
	public Boolean getModeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mode"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getModeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mode"));
		if (object == null || object.empty()) {
			return getModeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getModeNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Once";
		}
		return null;
	}

	@Override
	public Boolean getcontainsShowControls() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ShowControls"));
	}

	@Override
	public Boolean getShowControlsHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ShowControls"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsDuration() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Duration"));
	}

	@Override
	public Boolean getDurationHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duration"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getDurationHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duration"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getDurationHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duration"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getDurationIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duration"));
		if (object == null || object.empty()) {
			return getDurationIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDurationIntegerDefaultValue() {
		return null;
	}

	@Override
	public Long getDurationStringSize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duration"));
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsStart() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Start"));
	}

	@Override
	public Boolean getStartHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Start"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getStartHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Start"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getStartHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Start"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getStartIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Start"));
		if (object == null || object.empty()) {
			return getStartIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getStartIntegerDefaultValue() {
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
	public Long getStartStringSize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Start"));
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return (long) object.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFWScale() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FWScale"));
	}

	@Override
	public Boolean getFWScaleHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FWScale"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsRate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rate"));
	}

	@Override
	public Boolean getRateHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rate"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getFWPosition0NumberValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject FWPosition = this.baseObject.getKey(ASAtom.getASAtom("FWPosition"));
		if (FWPosition == null || FWPosition.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (FWPosition.size() <= 0) {
			return null;
		}
		COSObject entry0 = FWPosition.at(0);
		return new GFAArrayOf_2Numbers(FWPosition.getDirectBase(), null, null).getentry0NumberValue();
	}
	@Override
	public Double getFWPosition1NumberValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject FWPosition = this.baseObject.getKey(ASAtom.getASAtom("FWPosition"));
		if (FWPosition == null || FWPosition.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (FWPosition.size() <= 1) {
			return null;
		}
		COSObject entry1 = FWPosition.at(1);
		return new GFAArrayOf_2Numbers(FWPosition.getDirectBase(), null, null).getentry1NumberValue();
	}
	@Override
	public Long getFWScale0IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject FWScale = this.baseObject.getKey(ASAtom.getASAtom("FWScale"));
		if (FWScale == null || FWScale.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (FWScale.size() <= 0) {
			return null;
		}
		COSObject entry0 = FWScale.at(0);
		return new GFAArrayOf_2Integers(FWScale.getDirectBase(), null, null).getentry0IntegerValue();
	}
	@Override
	public Long getFWScale1IntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject FWScale = this.baseObject.getKey(ASAtom.getASAtom("FWScale"));
		if (FWScale == null || FWScale.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		if (FWScale.size() <= 1) {
			return null;
		}
		COSObject entry1 = FWScale.at(1);
		return new GFAArrayOf_2Integers(FWScale.getDirectBase(), null, null).getentry1IntegerValue();
	}
}
