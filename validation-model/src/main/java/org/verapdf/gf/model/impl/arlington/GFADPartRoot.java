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

public class GFADPartRoot extends GFAObject implements ADPartRoot {

	public GFADPartRoot(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADPartRoot");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DPartRootNode":
				return getDPartRootNode();
			case "NodeNameList":
				return getNodeNameList();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ADPart> getDPartRootNode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDPartRootNode1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPart> getDPartRootNode1_6() {
		COSObject object = getDPartRootNodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADPart> list = new ArrayList<>(1);
			list.add(new GFADPart((COSDictionary)object.getDirectBase(), this.baseObject, "DPartRootNode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNamesGeneral> getNodeNameList() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNodeNameList1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesGeneral> getNodeNameList1_6() {
		COSObject object = getNodeNameListValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesGeneral((COSArray)object.getDirectBase(), this.baseObject, "NodeNameList"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDPartRootNode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DPartRootNode"));
	}

	public COSObject getDPartRootNodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DPartRootNode"));
		return object;
	}

	@Override
	public Boolean getisDPartRootNodeIndirect() {
		COSObject object = getDPartRootNodeValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getDPartRootNodeHasTypeDictionary() {
		COSObject object = getDPartRootNodeValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsNodeNameList() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NodeNameList"));
	}

	public COSObject getNodeNameListValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NodeNameList"));
		return object;
	}

	@Override
	public Boolean getNodeNameListHasTypeArray() {
		COSObject object = getNodeNameListValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsRecordLevel() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RecordLevel"));
	}

	public COSObject getRecordLevelValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RecordLevel"));
		return object;
	}

	@Override
	public Boolean getRecordLevelHasTypeInteger() {
		COSObject object = getRecordLevelValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRecordLevelIntegerValue() {
		COSObject object = getRecordLevelValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
	public Boolean gethasExtensionPDF_VT2() {
		return false;
	}

}