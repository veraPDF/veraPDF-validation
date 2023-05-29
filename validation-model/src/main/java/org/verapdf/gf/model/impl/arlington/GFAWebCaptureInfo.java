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

public class GFAWebCaptureInfo extends GFAObject implements AWebCaptureInfo {

	public GFAWebCaptureInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AWebCaptureInfo");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "C":
				return getC();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfWebCaptureCommands> getC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfWebCaptureCommands> getC1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfWebCaptureCommands> list = new ArrayList<>(1);
			list.add(new GFAArrayOfWebCaptureCommands((COSArray)object.getDirectBase(), this.baseObject, "C"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C"));
	}

	public COSObject getCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object;
	}

	@Override
	public Boolean getCHasTypeArray() {
		COSObject object = getCValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object;
	}

	@Override
	public Boolean getVHasTypeNumber() {
		COSObject object = getVValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getVNumberValue() {
		COSObject object = getVValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

}
