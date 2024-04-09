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
	public Boolean getcontainsNavigationPane() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NavigationPane"));
	}

	public COSObject getNavigationPaneDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getNavigationPaneValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NavigationPane"));
		if (object == null || object.empty()) {
			object = getNavigationPaneDefaultValue();
		}
		return object;
	}

	@Override
	public String getNavigationPaneType() {
		COSObject NavigationPane = getNavigationPaneValue();
		return getObjectType(NavigationPane);
	}

	@Override
	public Boolean getNavigationPaneHasTypeBoolean() {
		COSObject NavigationPane = getNavigationPaneValue();
		return getHasTypeBoolean(NavigationPane);
	}

	@Override
	public Boolean getcontainsPassContextClick() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PassContextClick"));
	}

	public COSObject getPassContextClickDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getPassContextClickValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PassContextClick"));
		if (object == null || object.empty()) {
			object = getPassContextClickDefaultValue();
		}
		return object;
	}

	@Override
	public String getPassContextClickType() {
		COSObject PassContextClick = getPassContextClickValue();
		return getObjectType(PassContextClick);
	}

	@Override
	public Boolean getPassContextClickHasTypeBoolean() {
		COSObject PassContextClick = getPassContextClickValue();
		return getHasTypeBoolean(PassContextClick);
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
	public String getStyleType() {
		COSObject Style = getStyleValue();
		return getObjectType(Style);
	}

	@Override
	public Boolean getStyleHasTypeName() {
		COSObject Style = getStyleValue();
		return getHasTypeName(Style);
	}

	@Override
	public String getStyleNameValue() {
		COSObject Style = getStyleValue();
		return getNameValue(Style);
	}

	@Override
	public Boolean getcontainsToolbar() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Toolbar"));
	}

	public COSObject getToolbarDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getToolbarValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Toolbar"));
		if (object == null || object.empty()) {
			object = getToolbarDefaultValue();
		}
		return object;
	}

	@Override
	public String getToolbarType() {
		COSObject Toolbar = getToolbarValue();
		return getObjectType(Toolbar);
	}

	@Override
	public Boolean getToolbarHasTypeBoolean() {
		COSObject Toolbar = getToolbarValue();
		return getHasTypeBoolean(Toolbar);
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
	public String getTransparentType() {
		COSObject Transparent = getTransparentValue();
		return getObjectType(Transparent);
	}

	@Override
	public Boolean getTransparentHasTypeBoolean() {
		COSObject Transparent = getTransparentValue();
		return getHasTypeBoolean(Transparent);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
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
	public String getWindowType() {
		COSObject Window = getWindowValue();
		return getObjectType(Window);
	}

	@Override
	public Boolean getWindowHasTypeDictionary() {
		COSObject Window = getWindowValue();
		return getHasTypeDictionary(Window);
	}

}
