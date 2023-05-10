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

public class GFARichMediaContent extends GFAObject implements ARichMediaContent {

	public GFARichMediaContent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaContent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Assets":
				return getAssets();
			case "Configurations":
				return getConfigurations();
			case "Views":
				return getViews();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaContentNameTreeAssets> getAssets() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAssets1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaContentNameTreeAssets> getAssets1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Assets"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaContentNameTreeAssets> list = new ArrayList<>(1);
			list.add(new GFARichMediaContentNameTreeAssets((COSDictionary)object.getDirectBase(), this.baseObject, "Assets"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfRichMediaConfiguration> getConfigurations() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getConfigurations1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRichMediaConfiguration> getConfigurations1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configurations"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfRichMediaConfiguration> list = new ArrayList<>(1);
			list.add(new GFAArrayOfRichMediaConfiguration((COSArray)object.getDirectBase(), this.baseObject, "Configurations"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf3DView> getViews() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getViews1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf3DView> getViews1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Views"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf3DView> list = new ArrayList<>(1);
			list.add(new GFAArrayOf3DView((COSArray)object.getDirectBase(), this.baseObject, "Views"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAssets() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Assets"));
	}

	@Override
	public Boolean getAssetsHasTypeNameTree() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Assets"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsConfigurations() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Configurations"));
	}

	@Override
	public Boolean getConfigurationsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configurations"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getConfigurationsArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configurations"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
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
	public Boolean getcontainsViews() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Views"));
	}

	@Override
	public Boolean getViewsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Views"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
