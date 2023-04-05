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

public class GFAArrayOfIndirectFileSpecificationsEntry extends GFAObject implements AArrayOfIndirectFileSpecificationsEntry {

	private String collectionName;

	public GFAArrayOfIndirectFileSpecificationsEntry(COSBase baseObject, COSBase parentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfIndirectFileSpecificationsEntry");
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

	private List<AFileSpecification> getEntry() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getEntry1_7() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getisIndirect() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getnameTreeparentRichMediaContentAssetsContainsString() {
		COSObject object = new COSObject(this.baseObject);
		if (object == null || object.getType() != COSObjType.COS_STRING) {
			return false;
		}
		if (this.parentObject == null || !this.parentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject RichMediaContent = this.parentObject.getKey(ASAtom.getASAtom("RichMediaContent"));
		if (RichMediaContent == null || !RichMediaContent.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Assets = RichMediaContent.getKey(ASAtom.getASAtom("Assets"));
		if (Assets == null || Assets.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(Assets);
		return nameTreeNode.getObject(object.getString()) != null;
	}

}
