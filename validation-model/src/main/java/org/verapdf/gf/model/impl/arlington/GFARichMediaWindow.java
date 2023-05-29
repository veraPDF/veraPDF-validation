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

public class GFARichMediaWindow extends GFAObject implements ARichMediaWindow {

	public GFARichMediaWindow(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaWindow");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Height":
				return getHeight();
			case "Position":
				return getPosition();
			case "Width":
				return getWidth();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaHeight> getHeight() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getHeight1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaHeight> getHeight1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaHeight> list = new ArrayList<>(1);
			list.add(new GFARichMediaHeight((COSDictionary)object.getDirectBase(), this.baseObject, "Height"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaPosition> getPosition() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPosition1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaPosition> getPosition1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaPosition> list = new ArrayList<>(1);
			list.add(new GFARichMediaPosition((COSDictionary)object.getDirectBase(), this.baseObject, "Position"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaWidth> getWidth() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getWidth1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaWidth> getWidth1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaWidth> list = new ArrayList<>(1);
			list.add(new GFARichMediaWidth((COSDictionary)object.getDirectBase(), this.baseObject, "Width"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Height"));
	}

	public COSObject getHeightValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		return object;
	}

	@Override
	public Boolean getHeightHasTypeDictionary() {
		COSObject object = getHeightValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Position"));
	}

	public COSObject getPositionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		return object;
	}

	@Override
	public Boolean getPositionHasTypeDictionary() {
		COSObject object = getPositionValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Width"));
	}

	public COSObject getWidthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		return object;
	}

	@Override
	public Boolean getWidthHasTypeDictionary() {
		COSObject object = getWidthValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
