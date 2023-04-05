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
			case "Position":
				return getPosition();
			case "Height":
				return getHeight();
			case "Width":
				return getWidth();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaPosition> getPosition() {
		switch(StaticContainers.getFlavour()) {
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

	private List<ARichMediaHeight> getHeight() {
		switch(StaticContainers.getFlavour()) {
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

	private List<ARichMediaWidth> getWidth() {
		switch(StaticContainers.getFlavour()) {
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
	public Boolean getcontainsPosition() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Position"));
	}

	@Override
	public Boolean getPositionHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Position"));
		return object != null && object.getType() == COSObjType.COS_DICT;
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

	@Override
	public Boolean getcontainsHeight() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Height"));
	}

	@Override
	public Boolean getHeightHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Height"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsWidth() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Width"));
	}

	@Override
	public Boolean getWidthHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Width"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
