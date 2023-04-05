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

public class GFAActionSetState extends GFAObject implements AActionSetState {

	public GFAActionSetState(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AActionSetState");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "T":
				return getT();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getT() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getT1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getT1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfAnnots> list = new ArrayList<>(1);
			list.add(new GFAArrayOfAnnots((COSArray)object.getDirectBase(), this.baseObject, "T"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getTDictionary1_2(object.getDirectBase(), "T");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getTDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			default:
				return null;
		}
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
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	@Override
	public Boolean getisTIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getTHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			return getSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsAS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AS"));
	}

	@Override
	public Boolean getASHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AS"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

}
