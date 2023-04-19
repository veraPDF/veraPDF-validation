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

public class GFAEncoding extends GFAObject implements AEncoding {

	public GFAEncoding(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AEncoding");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Differences":
				return getDifferences();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfDifferences> getDifferences() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDifferences1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfDifferences> getDifferences1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Differences"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDifferences> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDifferences((COSArray)object.getDirectBase(), this.baseObject, "Differences"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBaseEncoding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaseEncoding"));
	}

	@Override
	public Boolean getBaseEncodingHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseEncoding"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBaseEncodingNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseEncoding"));
		if (object == null || object.empty()) {
			return getBaseEncodingNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getBaseEncodingNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDifferences() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Differences"));
	}

	@Override
	public Boolean getDifferencesHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Differences"));
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

}
