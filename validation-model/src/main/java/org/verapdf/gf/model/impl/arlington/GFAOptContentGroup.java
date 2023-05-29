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

public class GFAOptContentGroup extends GFAObject implements AOptContentGroup {

	public GFAOptContentGroup(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentGroup");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Intent":
				return getIntent();
			case "Usage":
				return getUsage();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNamesGeneral> getIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIntent1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesGeneral> getIntent1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Intent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesGeneral((COSArray)object.getDirectBase(), this.baseObject, "Intent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentUsage> getUsage() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getUsage1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentUsage> getUsage1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Usage"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentUsage> list = new ArrayList<>(1);
			list.add(new GFAOptContentUsage((COSDictionary)object.getDirectBase(), this.baseObject, "Usage"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Intent"));
	}

	public COSObject getIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Intent"));
		return object;
	}

	@Override
	public Boolean getIntentHasTypeArray() {
		COSObject object = getIntentValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getIntentHasTypeName() {
		COSObject object = getIntentValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object;
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject object = getNameValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
	public Boolean getcontainsUsage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Usage"));
	}

	public COSObject getUsageValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Usage"));
		return object;
	}

	@Override
	public Boolean getUsageHasTypeDictionary() {
		COSObject object = getUsageValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
