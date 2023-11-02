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

public class GFALabDict extends GFAObject implements ALabDict {

	public GFALabDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ALabDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BlackPoint":
				return getBlackPoint();
			case "Range":
				return getRange();
			case "WhitePoint":
				return getWhitePoint();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ABlackpointArray> getBlackPoint() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBlackPoint1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<ABlackpointArray> getBlackPoint1_1() {
		COSObject object = getBlackPointValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ABlackpointArray> list = new ArrayList<>(1);
			list.add(new GFABlackpointArray((COSArray)object.getDirectBase(), this.baseObject, "BlackPoint"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ALabRangeArray> getRange() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRange1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<ALabRangeArray> getRange1_1() {
		COSObject object = getRangeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ALabRangeArray> list = new ArrayList<>(1);
			list.add(new GFALabRangeArray((COSArray)object.getDirectBase(), this.baseObject, "Range"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AWhitepointArray> getWhitePoint() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getWhitePoint1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AWhitepointArray> getWhitePoint1_1() {
		COSObject object = getWhitePointValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AWhitepointArray> list = new ArrayList<>(1);
			list.add(new GFAWhitepointArray((COSArray)object.getDirectBase(), this.baseObject, "WhitePoint"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBlackPoint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BlackPoint"));
	}

	public COSObject getBlackPointValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BlackPoint"));
		return object;
	}

	@Override
	public String getBlackPointType() {
		COSObject BlackPoint = getBlackPointValue();
		return getObjectType(BlackPoint);
	}

	@Override
	public Boolean getBlackPointHasTypeArray() {
		COSObject BlackPoint = getBlackPointValue();
		return getHasTypeArray(BlackPoint);
	}

	@Override
	public Boolean getcontainsRange() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Range"));
	}

	public COSObject getRangeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Range"));
		return object;
	}

	@Override
	public String getRangeType() {
		COSObject Range = getRangeValue();
		return getObjectType(Range);
	}

	@Override
	public Boolean getRangeHasTypeArray() {
		COSObject Range = getRangeValue();
		return getHasTypeArray(Range);
	}

	@Override
	public Boolean getcontainsWhitePoint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WhitePoint"));
	}

	public COSObject getWhitePointValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WhitePoint"));
		return object;
	}

	@Override
	public String getWhitePointType() {
		COSObject WhitePoint = getWhitePointValue();
		return getObjectType(WhitePoint);
	}

	@Override
	public Boolean getWhitePointHasTypeArray() {
		COSObject WhitePoint = getWhitePointValue();
		return getHasTypeArray(WhitePoint);
	}

}
