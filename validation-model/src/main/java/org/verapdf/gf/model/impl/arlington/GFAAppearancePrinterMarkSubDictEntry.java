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

public class GFAAppearancePrinterMarkSubDictEntry extends GFAObject implements AAppearancePrinterMarkSubDictEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAAppearancePrinterMarkSubDictEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AAppearancePrinterMarkSubDictEntry");
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

	private List<AXObjectFormPrinterMark> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectFormPrinterMark> getEntry1_4() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormPrinterMark> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormPrinterMark((COSStream)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public Boolean getisIndirect() {
		COSObject object = getValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getHasTypeStream() {
		COSObject object = getValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
