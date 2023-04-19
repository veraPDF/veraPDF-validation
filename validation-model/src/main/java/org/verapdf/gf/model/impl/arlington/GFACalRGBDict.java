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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BlackPoint"));
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Gamma"));
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Matrix"));
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
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WhitePoint"));
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

	@Override
	public Boolean getBlackPointHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BlackPoint"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsGamma() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Gamma"));
	}

	@Override
	public Boolean getGammaHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Gamma"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Matrix"));
	}

	@Override
	public Boolean getMatrixHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Matrix"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsWhitePoint() {
		return this.baseObject.knownKey(ASAtom.getASAtom("WhitePoint"));
	}

	@Override
	public Boolean getWhitePointHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("WhitePoint"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
