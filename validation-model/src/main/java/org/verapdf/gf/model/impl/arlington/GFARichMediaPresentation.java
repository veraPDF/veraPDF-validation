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

public class GFARichMediaPresentation extends GFAObject implements ARichMediaPresentation {

	public GFARichMediaPresentation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaPresentation");
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
	public Boolean getcontainsTransparent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Transparent"));
	}

	@Override
	public Boolean getTransparentHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Transparent"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
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
	public Boolean getcontainsNavigationPane() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NavigationPane"));
	}

	@Override
	public Boolean getNavigationPaneHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NavigationPane"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsToolbar() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Toolbar"));
	}

	@Override
	public Boolean getToolbarHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Toolbar"));
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
	public Boolean getcontainsWindow() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Window"));
	}

	@Override
	public Boolean getWindowHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Window"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPassContextClick() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PassContextClick"));
	}

	@Override
	public Boolean getPassContextClickHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PassContextClick"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

}
