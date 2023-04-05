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

public class GFARichMediaParams extends GFAObject implements ARichMediaParams {

	public GFARichMediaParams(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaParams");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Seetings":
				return getSeetings();
			case "FlashVars":
				return getFlashVars();
			case "CuePoints":
				return getCuePoints();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStream> getSeetings() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSeetings1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getSeetings1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Seetings"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Seetings"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getFlashVars() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFlashVars1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getFlashVars1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FlashVars"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "FlashVars"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfRichMediaCuePoints> getCuePoints() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCuePoints1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRichMediaCuePoints> getCuePoints1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CuePoints"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfRichMediaCuePoints> list = new ArrayList<>(1);
			list.add(new GFAArrayOfRichMediaCuePoints((COSArray)object.getDirectBase(), this.baseObject, "CuePoints"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBinding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Binding"));
	}

	@Override
	public Boolean getBindingHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Binding"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBindingNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Binding"));
		if (object == null || object.empty()) {
			return getBindingNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getBindingNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "None";
		}
		return null;
	}

	@Override
	public Boolean getcontainsSeetings() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Seetings"));
	}

	@Override
	public Boolean getisSeetingsIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Seetings"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSeetingsHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Seetings"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getSeetingsHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Seetings"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsCuePoints() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CuePoints"));
	}

	@Override
	public Boolean getCuePointsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CuePoints"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getcontainsBindingMaterial() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BindingMaterial"));
	}

	@Override
	public Boolean getBindingMaterialHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BindingMaterial"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsFlashVars() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FlashVars"));
	}

	@Override
	public Boolean getisFlashVarsIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FlashVars"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFlashVarsHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FlashVars"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getFlashVarsHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FlashVars"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
