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

public class GFAMovieActivation extends GFAObject implements AMovieActivation {

	public GFAMovieActivation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMovieActivation");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Duration":
				return getDuration();
			case "FWPosition":
				return getFWPosition();
			case "FWScale":
				return getFWScale();
			case "Start":
				return getStart();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfDuration> getDuration() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getDurationValue();
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

	private List<AArrayOf_2Numbers> getFWPosition() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getFWPositionValue();
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

	private List<AArrayOf_2Integers> getFWScale() {
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getFWScaleValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getStartValue();
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

	@Override
	public Boolean getcontainsDuration() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Duration"));
	}

	public COSObject getDurationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Duration"));
		return object;
	}

	@Override
	public Boolean getDurationHasTypeArray() {
		COSObject Duration = getDurationValue();
		return getHasTypeArray(Duration);
	}

	@Override
	public Boolean getDurationHasTypeInteger() {
		COSObject Duration = getDurationValue();
		return getHasTypeInteger(Duration);
	}

	@Override
	public Boolean getDurationHasTypeStringByte() {
		COSObject Duration = getDurationValue();
		return getHasTypeStringByte(Duration);
	}

	@Override
	public Long getDurationIntegerValue() {
		COSObject Duration = getDurationValue();
		return getIntegerValue(Duration);
	}

	@Override
	public Long getDurationStringSize() {
		COSObject Duration = getDurationValue();
		if (Duration != null && Duration.getType() == COSObjType.COS_STRING) {
			return (long) Duration.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFWPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FWPosition"));
	}

	public COSObject getFWPositionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FWPosition"));
		return object;
	}

	@Override
	public Boolean getFWPositionHasTypeArray() {
		COSObject FWPosition = getFWPositionValue();
		return getHasTypeArray(FWPosition);
	}

	@Override
	public Boolean getcontainsFWScale() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FWScale"));
	}

	public COSObject getFWScaleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FWScale"));
		return object;
	}

	@Override
	public Boolean getFWScaleHasTypeArray() {
		COSObject FWScale = getFWScaleValue();
		return getHasTypeArray(FWScale);
	}

	@Override
	public Boolean getcontainsMode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Mode"));
	}

	public COSObject getModeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Once");
		}
		return null;
	}

	public COSObject getModeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mode"));
		if (object == null || object.empty()) {
			object = getModeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getModeHasTypeName() {
		COSObject Mode = getModeValue();
		return getHasTypeName(Mode);
	}

	@Override
	public String getModeNameValue() {
		COSObject Mode = getModeValue();
		return getNameValue(Mode);
	}

	@Override
	public Boolean getcontainsRate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rate"));
	}

	public COSObject getRateDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1.0D);
		}
		return null;
	}

	public COSObject getRateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rate"));
		if (object == null || object.empty()) {
			object = getRateDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRateHasTypeNumber() {
		COSObject Rate = getRateValue();
		return getHasTypeNumber(Rate);
	}

	@Override
	public Boolean getcontainsShowControls() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ShowControls"));
	}

	public COSObject getShowControlsDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getShowControlsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ShowControls"));
		if (object == null || object.empty()) {
			object = getShowControlsDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getShowControlsHasTypeBoolean() {
		COSObject ShowControls = getShowControlsValue();
		return getHasTypeBoolean(ShowControls);
	}

	@Override
	public Boolean getcontainsStart() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Start"));
	}

	public COSObject getStartDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getStartValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Start"));
		if (object == null || object.empty()) {
			object = getStartDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getStartHasTypeArray() {
		COSObject Start = getStartValue();
		return getHasTypeArray(Start);
	}

	@Override
	public Boolean getStartHasTypeInteger() {
		COSObject Start = getStartValue();
		return getHasTypeInteger(Start);
	}

	@Override
	public Boolean getStartHasTypeStringByte() {
		COSObject Start = getStartValue();
		return getHasTypeStringByte(Start);
	}

	@Override
	public Long getStartIntegerValue() {
		COSObject Start = getStartValue();
		return getIntegerValue(Start);
	}

	@Override
	public Long getStartStringSize() {
		COSObject Start = getStartValue();
		if (Start != null && Start.getType() == COSObjType.COS_STRING) {
			return (long) Start.getString().length();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSynchronous() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Synchronous"));
	}

	public COSObject getSynchronousDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getSynchronousValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Synchronous"));
		if (object == null || object.empty()) {
			object = getSynchronousDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSynchronousHasTypeBoolean() {
		COSObject Synchronous = getSynchronousValue();
		return getHasTypeBoolean(Synchronous);
	}

	@Override
	public Boolean getcontainsVolume() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Volume"));
	}

	public COSObject getVolumeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1.0D);
		}
		return null;
	}

	public COSObject getVolumeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Volume"));
		if (object == null || object.empty()) {
			object = getVolumeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getVolumeHasTypeNumber() {
		COSObject Volume = getVolumeValue();
		return getHasTypeNumber(Volume);
	}

	@Override
	public Double getVolumeNumberValue() {
		COSObject Volume = getVolumeValue();
		return getNumberValue(Volume);
	}

	@Override
	public Double getFWPosition0NumberValue() {
		COSObject FWPosition = getFWPositionValue();
		return new GFAArrayOf_2Numbers(FWPosition.getDirectBase(), null, null).getentry0NumberValue();
	}

	@Override
	public Double getFWPosition1NumberValue() {
		COSObject FWPosition = getFWPositionValue();
		return new GFAArrayOf_2Numbers(FWPosition.getDirectBase(), null, null).getentry1NumberValue();
	}

	@Override
	public Long getFWScale0IntegerValue() {
		COSObject FWScale = getFWScaleValue();
		return new GFAArrayOf_2Integers(FWScale.getDirectBase(), null, null).getentry0IntegerValue();
	}

	@Override
	public Long getFWScale1IntegerValue() {
		COSObject FWScale = getFWScaleValue();
		return new GFAArrayOf_2Integers(FWScale.getDirectBase(), null, null).getentry1IntegerValue();
	}

	@Override
	public Boolean getFWPosition0HasTypeNumber() {
		COSObject FWPosition = getFWPositionValue();
		return new GFAArrayOf_2Numbers(FWPosition.getDirectBase(), null, null).getentry0HasTypeNumber();
	}

	@Override
	public Boolean getFWPosition1HasTypeNumber() {
		COSObject FWPosition = getFWPositionValue();
		return new GFAArrayOf_2Numbers(FWPosition.getDirectBase(), null, null).getentry1HasTypeNumber();
	}

	@Override
	public Boolean getFWScale0HasTypeInteger() {
		COSObject FWScale = getFWScaleValue();
		return new GFAArrayOf_2Integers(FWScale.getDirectBase(), null, null).getentry0HasTypeInteger();
	}

	@Override
	public Boolean getFWScale1HasTypeInteger() {
		COSObject FWScale = getFWScaleValue();
		return new GFAArrayOf_2Integers(FWScale.getDirectBase(), null, null).getentry1HasTypeInteger();
	}

}
