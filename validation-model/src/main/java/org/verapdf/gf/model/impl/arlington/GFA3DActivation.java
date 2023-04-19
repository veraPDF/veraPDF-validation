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

public class GFA3DActivation extends GFAObject implements A3DActivation {

	public GFA3DActivation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DActivation");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Window":
				return getWindow();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaWindow> getWindow() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getWindow1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaWindow> getWindow1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Window"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaWindow> list = new ArrayList<>(1);
			list.add(new GFARichMediaWindow((COSDictionary)object.getDirectBase(), this.baseObject, "Window"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A"));
	}

	@Override
	public Boolean getAHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getANameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (object == null || object.empty()) {
			return getANameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getANameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "XA";
		}
		return null;
	}

	@Override
	public Boolean getcontainsAIS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AIS"));
	}

	@Override
	public Boolean getAISHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AIS"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getAISNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AIS"));
		if (object == null || object.empty()) {
			return getAISNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getAISNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "L";
		}
		return null;
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	@Override
	public Boolean getDHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null || object.empty()) {
			return getDNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getDNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "PI";
		}
		return null;
	}

	@Override
	public Boolean getcontainsDIS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DIS"));
	}

	@Override
	public Boolean getDISHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DIS"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDISNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DIS"));
		if (object == null || object.empty()) {
			return getDISNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getDISNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "U";
		}
		return null;
	}

	@Override
	public Boolean getcontainsNP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NP"));
	}

	@Override
	public Boolean getNPHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NP"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsStyle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Style"));
	}

	@Override
	public Boolean getStyleHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Style"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getStyleNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Style"));
		if (object == null || object.empty()) {
			return getStyleNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getStyleNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Embedded";
		}
		return null;
	}

	@Override
	public Boolean getcontainsTB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TB"));
	}

	@Override
	public Boolean getTBHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TB"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsTransparent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Transparent"));
	}

	@Override
	public Boolean getTransparentHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Transparent"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsWindow() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Window"));
	}

	@Override
	public Boolean getWindowHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Window"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
