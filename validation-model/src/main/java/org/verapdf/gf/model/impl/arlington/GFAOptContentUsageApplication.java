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

public class GFAOptContentUsageApplication extends GFAObject implements AOptContentUsageApplication {

	public GFAOptContentUsageApplication(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentUsageApplication");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Category":
				return getCategory();
			case "OCGs":
				return getOCGs();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNamesGeneral> getCategory() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCategory1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesGeneral> getCategory1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Category"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesGeneral((COSArray)object.getDirectBase(), this.baseObject, "Category"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOCG> getOCGs() {
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

	private List<AArrayOfOCG> getOCGs1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCGs"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOCG> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOCG((COSArray)object.getDirectBase(), this.baseObject, "OCGs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsEvent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Event"));
	}

	@Override
	public Boolean getEventHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Event"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getEventNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Event"));
		if (object == null || object.empty()) {
			return getEventNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getEventNameDefaultValue() {
		return null;
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
	public Boolean getcontainsCategory() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Category"));
	}

	@Override
	public Boolean getCategoryHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Category"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
