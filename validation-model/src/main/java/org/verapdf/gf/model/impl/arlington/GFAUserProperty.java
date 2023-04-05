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
import java.io.IOException;

public class GFAUserProperty extends GFAObject implements AUserProperty {

	public GFAUserProperty(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AUserProperty");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "V":
				return getV();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getV() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getV1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getV1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getFHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	@Override
	public Boolean getNHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("H"));
	}

	@Override
	public Boolean getHHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	@Override
	public Boolean getisVIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getVHasTypeNull() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public Boolean getVHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getVHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getVHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getVHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getVHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getVHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getVHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean gettrailerCatalogMarkInfoUserPropertiesBooleanValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		if (Root == null || !Root.getType().isDictionaryBased()) {
			return null;
		}
		COSObject MarkInfo = Root.getKey(ASAtom.getASAtom("MarkInfo"));
		if (MarkInfo == null || !MarkInfo.getType().isDictionaryBased()) {
			return null;
		}
		COSObject UserProperties = MarkInfo.getKey(ASAtom.getASAtom("UserProperties"));
		return new GFAMarkInfo(MarkInfo.getDirectBase(), null, null).getUserPropertiesBooleanValue();
	}
}
