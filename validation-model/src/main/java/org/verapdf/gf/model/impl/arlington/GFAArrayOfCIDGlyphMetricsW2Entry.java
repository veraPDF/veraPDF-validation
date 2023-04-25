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

public class GFAArrayOfCIDGlyphMetricsW2Entry extends GFAObject implements AArrayOfCIDGlyphMetricsW2Entry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfCIDGlyphMetricsW2Entry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfCIDGlyphMetricsW2Entry");
		this.parentParentObject = parentParentObject;
		this.collectionName = collectionName;
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entry":
				return getEntry();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNumbersGeneral> getEntry() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getEntry1_2() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getHasTypeArray() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getHasTypeInteger() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getHasTypeNumber() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType().isNumber();
	}

	@Override
	public Long getArraySize() {
		COSObject object = new COSObject(this.baseObject);
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

}