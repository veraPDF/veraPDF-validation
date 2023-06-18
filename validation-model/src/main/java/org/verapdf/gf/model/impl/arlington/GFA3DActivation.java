package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

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
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getWindow1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaWindow> getWindow1_7() {
		COSObject object = getWindowValue();
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

	public COSObject getADefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("XA");
		}
		return null;
	}

	public COSObject getAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (object == null || object.empty()) {
			object = getADefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getAHasTypeName() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getANameValue() {
		COSObject object = getAValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsAIS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AIS"));
	}

	public COSObject getAISDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("L");
		}
		return null;
	}

	public COSObject getAISValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AIS"));
		if (object == null || object.empty()) {
			object = getAISDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getAISHasTypeName() {
		COSObject object = getAISValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getAISNameValue() {
		COSObject object = getAISValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("PI");
		}
		return null;
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null || object.empty()) {
			object = getDDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDHasTypeName() {
		COSObject object = getDValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDNameValue() {
		COSObject object = getDValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDIS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DIS"));
	}

	public COSObject getDISDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("U");
		}
		return null;
	}

	public COSObject getDISValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DIS"));
		if (object == null || object.empty()) {
			object = getDISDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDISHasTypeName() {
		COSObject object = getDISValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getDISNameValue() {
		COSObject object = getDISValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsNP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NP"));
	}

	public COSObject getNPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getNPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NP"));
		if (object == null || object.empty()) {
			object = getNPDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getNPHasTypeBoolean() {
		COSObject object = getNPValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsStyle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Style"));
	}

	public COSObject getStyleDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Embedded");
		}
		return null;
	}

	public COSObject getStyleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Style"));
		if (object == null || object.empty()) {
			object = getStyleDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getStyleHasTypeName() {
		COSObject object = getStyleValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getStyleNameValue() {
		COSObject object = getStyleValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsTB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TB"));
	}

	public COSObject getTBDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(true);
		}
		return null;
	}

	public COSObject getTBValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TB"));
		if (object == null || object.empty()) {
			object = getTBDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getTBHasTypeBoolean() {
		COSObject object = getTBValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsTransparent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Transparent"));
	}

	public COSObject getTransparentDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getTransparentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Transparent"));
		if (object == null || object.empty()) {
			object = getTransparentDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getTransparentHasTypeBoolean() {
		COSObject object = getTransparentValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsWindow() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Window"));
	}

	public COSObject getWindowValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Window"));
		return object;
	}

	@Override
	public Boolean getWindowHasTypeDictionary() {
		COSObject object = getWindowValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
