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

public class GFARichMediaCommand extends GFAObject implements ARichMediaCommand {

	public GFARichMediaCommand(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaCommand");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "A":
				return getA();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaCommandArray> getA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getA1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaCommandArray> getA1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ARichMediaCommandArray> list = new ArrayList<>(1);
			list.add(new GFARichMediaCommandArray((COSArray)object.getDirectBase(), this.baseObject, "A"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A"));
	}

	public COSObject getAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object;
	}

	@Override
	public Boolean getAHasTypeArray() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getAHasTypeBoolean() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getAHasTypeInteger() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getAHasTypeNumber() {
		COSObject object = getAValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getAHasTypeStringText() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C"));
	}

	public COSObject getCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object;
	}

	@Override
	public Boolean getCHasTypeStringText() {
		COSObject object = getCValue();
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

}
