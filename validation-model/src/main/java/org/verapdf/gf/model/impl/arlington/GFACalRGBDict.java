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

public class GFACalRGBDict extends GFAObject implements ACalRGBDict {

	public GFACalRGBDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACalRGBDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BlackPoint":
				return getBlackPoint();
			case "Gamma":
				return getGamma();
			case "Matrix":
				return getMatrix();
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

	private List<AGammaArray> getGamma() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGamma1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AGammaArray> getGamma1_1() {
		COSObject object = getGammaValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AGammaArray> list = new ArrayList<>(1);
			list.add(new GFAGammaArray((COSArray)object.getDirectBase(), this.baseObject, "Gamma"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_9Numbers> getMatrix() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMatrix1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_9Numbers> getMatrix1_1() {
		COSObject object = getMatrixValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_9Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_9Numbers((COSArray)object.getDirectBase(), this.baseObject, "Matrix"));
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
	public Boolean getBlackPointHasTypeArray() {
		COSObject object = getBlackPointValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsGamma() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Gamma"));
	}

	public COSObject getGammaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Gamma"));
		return object;
	}

	@Override
	public Boolean getGammaHasTypeArray() {
		COSObject object = getGammaValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getcontainsMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Matrix"));
	}

	public COSObject getMatrixValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Matrix"));
		return object;
	}

	@Override
	public Boolean getMatrixHasTypeArray() {
		COSObject object = getMatrixValue();
		return getHasTypeArray(object);
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
	public Boolean getWhitePointHasTypeArray() {
		COSObject object = getWhitePointValue();
		return getHasTypeArray(object);
	}

}
