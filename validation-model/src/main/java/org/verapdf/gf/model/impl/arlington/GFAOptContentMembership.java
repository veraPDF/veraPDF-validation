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

public class GFAOptContentMembership extends GFAObject implements AOptContentMembership {

	public GFAOptContentMembership(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentMembership");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "OCGs":
				return getOCGs();
			case "VE":
				return getVE();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOCGs() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOCGs1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOCGs1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCGs"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOCG> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOCG((COSArray)object.getDirectBase(), this.baseObject, "OCGs"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentGroup> list = new ArrayList<>(1);
			list.add(new GFAOptContentGroup((COSDictionary)object.getDirectBase(), this.baseObject, "OCGs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AVisibilityExpressionArray> getVE() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getVE1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AVisibilityExpressionArray> getVE1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VE"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AVisibilityExpressionArray> list = new ArrayList<>(1);
			list.add(new GFAVisibilityExpressionArray((COSArray)object.getDirectBase(), this.baseObject, "VE"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsOCGs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OCGs"));
	}

	@Override
	public Boolean getOCGsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCGs"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getOCGsHasTypeNull() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCGs"));
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	@Override
	public Boolean getOCGsHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCGs"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	@Override
	public Boolean getPHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getPNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			return getPNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getPNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "AnyOn";
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
	public Boolean getcontainsVE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VE"));
	}

	@Override
	public Boolean getVEHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VE"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
