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

public class GFACollectionFolder extends GFAObject implements ACollectionFolder {

	public GFACollectionFolder(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACollectionFolder");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Parent":
				return getParent();
			case "CI":
				return getCI();
			case "Thumb":
				return getThumb();
			case "Next":
				return getNext();
			case "Free":
				return getFree();
			case "Child":
				return getChild();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACollectionFolder> getParent() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getParent1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionFolder> getParent1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionFolder> list = new ArrayList<>(1);
			list.add(new GFACollectionFolder((COSDictionary)object.getDirectBase(), this.baseObject, "Parent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionItem> getCI() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCI1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionItem> getCI1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CI"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionItem> list = new ArrayList<>(1);
			list.add(new GFACollectionItem((COSDictionary)object.getDirectBase(), this.baseObject, "CI"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AThumbnail> getThumb() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getThumb1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AThumbnail> getThumb1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AThumbnail> list = new ArrayList<>(1);
			list.add(new GFAThumbnail((COSStream)object.getDirectBase(), this.baseObject, "Thumb"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionFolder> getNext() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNext1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionFolder> getNext1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Next"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionFolder> list = new ArrayList<>(1);
			list.add(new GFACollectionFolder((COSDictionary)object.getDirectBase(), this.baseObject, "Next"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNumbersGeneral> getFree() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFree1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNumbersGeneral> getFree1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Free"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNumbersGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNumbersGeneral((COSArray)object.getDirectBase(), this.baseObject, "Free"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACollectionFolder> getChild() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getChild1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionFolder> getChild1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Child"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionFolder> list = new ArrayList<>(1);
			list.add(new GFACollectionFolder((COSDictionary)object.getDirectBase(), this.baseObject, "Child"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsNext() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Next"));
	}

	@Override
	public Boolean getisNextIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Next"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getNextHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Next"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Parent"));
	}

	@Override
	public Boolean getisParentIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsChild() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Child"));
	}

	@Override
	public Boolean getisChildIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Child"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getChildHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Child"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsCI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CI"));
	}

	@Override
	public Boolean getCIHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CI"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDesc() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Desc"));
	}

	@Override
	public Boolean getDescHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Desc"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsThumb() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Thumb"));
	}

	@Override
	public Boolean getisThumbIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getThumbHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
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
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	@Override
	public Boolean getentryIDHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsCreationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreationDate"));
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreationDate"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsFree() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Free"));
	}

	@Override
	public Boolean getFreeHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Free"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsModDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ModDate"));
	}

	@Override
	public Boolean getModDateHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ModDate"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

}
